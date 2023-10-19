package Test.src;

import java.util.*;
import java.lang.Math;

public class Field {

    private Hashtable<Position, Float> field; // 2D array of all scent values in the Field

    private final Dimension dimension; // width = x dimension, height = y dimension
    private HashSet<Ant> ants;  						// storing ants in a set where each ant has a position stored with it so
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
        for (int i = 0; i < antCount; i++){	 						// add ants to the centre of the AntHill
            ants.add(new Ant(this.antHill.getPosition()));
        }
        this.foodSources = new HashSet<>();
        for (int i = 0; i < foodSourceCount; i++) {                 // randomly place food sources
            foodSources.add(new FoodSource(this.getRandomFieldPos()));
        }
    }

    // returns an Iterable over all Ant positions, functional style
    // http://www.lambdafaq.org/how-do-i-turn-a-stream-into-an-iterable/
    public Iterable<Position> getAntPositions() {
        return ants.stream().map(Ant::getPosition)::iterator;
    }

    // returns an Iterable over all FoodSource positions, functional style
    public Iterable<Position> getFoodSourcePositions() {
        return foodSources.stream().map(FoodSource::getPosition)::iterator;
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
    void printHillAndFoodSources() {
        System.out.println("AntHill:");
        System.out.println(antHill.getPosition().toString());
        System.out.println("FoodSources:");
        for (FoodSource foodSource: foodSources) {
            System.out.println(foodSource.getPosition().toString());
        }
    }

    // returns a Position width coordinates wrapped around to fit within the Field
    public Position wrapPosition(Position pos) {
        var x = pos.x() % dimension.width();
        if (x < 0) {x += dimension.width();};
        var y = pos.y() % dimension.height();
        if (y < 0) {y += dimension.height();};
        return new Position(x, y);
    }

    // set scent value at specified Position
    private void setScentTrail(Position position, float strength) {
        position = wrapPosition(position); // normalise coordinates to field boundaries
        this.field.put(position, strength);
    }

    // get scent value at specified Position
    public float getScentTrail(Position position) {
        position = wrapPosition(position); // normalise coordinates to field boundaries
        return this.field.getOrDefault(position, 0.00F);
    }

    // add to scent value at specified Position
    // saturating add -> MAX_SCENT constant
    public void addScentTrail(Position position, float strength) {
        final float MAX_SCENT = 5;
        float newStrength = getScentTrail(position) + strength;
        newStrength = Math.min(newStrength, MAX_SCENT);
        setScentTrail(position, newStrength);
    }

    // update all scent values in the field, and switch Ant modes
    void update() {
        for (Ant ant : ants) {
            State antState = ant.getState();
            Position position = ant.getPosition();
            if (getScentTrail(position) > 1F) {
                ant.setState(State.SUCHE);
            }
            for (FoodSource source : this.foodSources) {
                if (source.getPosition().equals(ant.getPosition())) {
                    ant.setState(State.BRINGT);
                    ant.invertDirection();
                }
            }
            if (antState == State.BRINGT && position.equals(antHill.getPosition())) {
                antHill.addFood();
                ant.setState(State.SUCHE);
                ant.invertDirection();
            }
            switch (antState) {
                case ERKUNDUNG -> {
                    addScentTrail(position, 0.1F);
                    ant.discoverMove(this);
                }
                case SUCHE     -> {
                    addScentTrail(position, 0.1F);
                    ant.searchMove(this);
                }
                case BRINGT    -> {
                    addScentTrail(position, 1.0F);
                    ant.deliverMove(this);
                }
            }
        }
        for (int y = 0; y < dimension.height(); y++) {
            for (int x = 0; x < dimension.width(); x++) {
                Position currentPosition = new Position(x, y);
                float newStrength = this.field.getOrDefault(currentPosition, 0.0F) * 0.998F;
                this.field.put(currentPosition, newStrength);
            }
        }
    }
}