package Test.src;

import java.util.*;

public class Field {

    private Hashtable<Position, Scent> field; // 2D array of all scent values in the Field

    private final Dimension dimension; // width = x dimension, height = y dimension
    private HashSet<Ant> ants;  // storing ants in a set where each ant has a position stored with it so
    // that we don't have to use a 3D array to store ants and the trail
    private HashSet<FoodSource> foodSources;
    private AntHill antHill;
    private Random random;

    public Field(int width, int height, int antCount, int foodSourceCount) {
        this.dimension = new Dimension(width, height);
        this.field = new Hashtable<>();  			        // initialises the field as an MxN board
        this.random = new Random();
        this.antHill = new AntHill(this.getRandomFieldPos()); 		// place antHill at random position
        this.ants = new HashSet<>();
        this.foodSources = new HashSet<>();

        for (int i = 0; i < antCount; i++){	 						// add ants to the centre of the AntHill
            int hp = random.nextInt(100);
            int attack = random.nextInt(100);
            ants.add(new Ant(this.antHill, hp, attack));
        }
        while (foodSources.size() < foodSourceCount) {
            Position newPosition = this.getRandomFieldPos();
            FoodSource newFoodSource = new FoodSource(newPosition);

            if (foodSources.stream().noneMatch(source -> source.getPosition().equals(newPosition))) {
                foodSources.add(newFoodSource);
            }
        }
    }

    // constructor for test case usage
    public Field(int width, int height, Position[] antPositions, Position[] foodSourcePositions, int foodSourceCount) {
        this.dimension = new Dimension(width, height);
        this.field = new Hashtable<>();  			        // initialises the field as an MxN board
        this.random = new Random();
        this.antHill = new AntHill(new Position(width/2, height/2)); // place ant hill in center
        this.ants = new HashSet<>();

        for (var pos : antPositions) {
            int hp = random.nextInt(100);
            int attack = random.nextInt(100);
            ants.add(new Ant(this.antHill, hp, attack));
        }
        while (foodSources.size() < foodSourceCount) {
            Position newPosition = this.getRandomFieldPos();
            FoodSource newFoodSource = new FoodSource(newPosition);

            if (foodSources.stream().noneMatch(source -> source.getPosition().equals(newPosition))) {
                foodSources.add(newFoodSource);
            }
        }
    }

    public AntHill getAntHill() {
        return antHill;
    }

    // returns an Iterable over all Ant positions, STYLE: functional
    // http://www.lambdafaq.org/how-do-i-turn-a-stream-into-an-iterable/
    public Iterable<Position> getAntPositions() {
        return ants.stream().map(Ant::getPosition)::iterator;
    }

    public Iterable<Ant> getAnts() {
        return ants;
    }

    // returns an Iterable over all FoodSource positions, STYLE: functional
    public Iterable<Position> getFoodSourcePositions() {
        return foodSources.stream().map(FoodSource::getPosition)::iterator;
    }

    // returns an Iterable of all FoodSources at a given position, STYLE: functional
    public Iterable<FoodSource> getFoodSourcesAtPosition(Position pos) {
        return foodSources.stream().filter(f -> f.position.equals(pos))::iterator;
    }

    public void addFoodToAntHill() {
        this.antHill.addFood();
    }

    // return position of AntHill
    public Position getAntHillPosition() {
        return antHill.getPosition();
    }

    // return a random position within the field
    private Position getRandomFieldPos() {
        int w_pos = this.random.nextInt(dimension.width());
        int h_pos = this.random.nextInt(dimension.height());
        return new Position(w_pos, h_pos);
    }

    // return dimension of field
    public Dimension getDimension() {
        return dimension;
    }

    // debug print method
    public void printAnts() {
        System.out.println("Ants:");
        for (Ant ant: ants) {
            System.out.println(ant.getPosition().toString());
        }
    }

    // debug print method
    public void printHillAndFoodSources() {
        System.out.println("AntHill:");
        System.out.println(antHill.getPosition().toString());
        System.out.println("FoodSources:");
        for (FoodSource foodSource: foodSources) {
            System.out.println(foodSource.getPosition().toString());
        }
    }

    // returns a Position width coordinates wrapped around to fit within the Field
    public Position wrapPosition(Position pos) {
        int x = (pos.x() % dimension.width() + dimension.width()) % dimension.width();
        int y = (pos.y() % dimension.height() + dimension.height()) % dimension.height();
        return new Position(x, y);
    }

    // get scent value at specified Position
    public float getScentTrail(Position position, Ant ant) {
        position = wrapPosition(position); // Normalise coordinates to field boundaries
        Scent scent = this.field.get(position);
        return (scent != null) ? scent.getStrength(ant) : 0F;
    }

    // TODO: add unified interface for Ant and AntHill
    public float getScentTrail(Position position, AntHill antHill) {
        position = wrapPosition(position); // Normalise coordinates to field boundaries
        Scent scent = this.field.get(position);
        return (scent != null) ? scent.getStrength(antHill) : 0F;
    }

    // add to scent value at specified Position
    // saturating add -> MAX_SCENT constant
    public void addScentTrail(Position position, Ant ant, float strength) {
        Scent scent = this.field.getOrDefault(position, new Scent());
        scent.addScent(ant, strength);
        this.field.put(position, scent);
    }

    /**
     * Each ant will fight with every other ant on the field
     * with the same position if and only if the ant isn't dead
     * additionally an ant will not fight itself
     */
    private void antsFight() {
        this.ants.removeIf(ant -> ant.getHP() <= 0);
        this.ants.forEach(ant -> {
            if (ant.getHP() <= 0) return;
            this.ants.stream()
                    .filter(a -> a != ant && a.getPosition().equals(ant.getPosition())
                            && !a.getHome().equals(ant.getHome()))
                    .forEach(ant::fight);
        });
    }

    /**
     * Updates everything within the field
     */
    public void update() {
        antsFight();
        this.ants.forEach(ant -> ant.move(this));
        this.field.values().forEach(Scent::fade);
        this.field.values().removeIf(Scent::isEmpty);
    }
}