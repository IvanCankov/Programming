import java.util.HashSet;
import java.util.Random;

public class Field {

    private float[][] field;
    private final Dimension dimension; // width = x dimension, height = y dimension
    HashSet<Ant> ants;  						// storing ants in a set where each ant has a position stored with it so
    // that we don't have to use a 3D array to store ants and the trail
    HashSet<FoodSource> foodSources;
    AntHill antHill;
    private Random random;

    public Field(int width, int height, int antCount, int foodSourceCount) {

        this.dimension = new Dimension(width, height);
        this.field = new float[width][height];  			// initialises the field as an MxN board
        this.random = new Random();
        this.antHill = new AntHill(this.getRandomFieldPos()); 		// place antHill at random position
        this.ants = new HashSet<>();
        for (int i = 0; i < antCount; i++){	 						// ants get added to the centre of the board
            ants.add(new Ant(this.antHill.getPosition()));
        }
        this.foodSources = new HashSet<>();
        for (int i = 0; i < foodSourceCount; i++) {
            foodSources.add(new FoodSource(this.getRandomFieldPos()));
        }
    }

    // return a random position within the field
    Position getRandomFieldPos() {
        int w_pos = this.random.nextInt(dimension.width());
        int h_pos = this.random.nextInt(dimension.height());
        return new Position(w_pos, h_pos);
    }

    Dimension getDimension() {
        return dimension;
    }

    void printAnts() {
        System.out.println("Ants:");
        for (Ant ant: ants) {
            System.out.println(ant.getPosition().toString());
        }
    }

    void printHillAndFoodSources() {
        System.out.println("AntHill:");
        System.out.println(antHill.getPosition().toString());
        System.out.println("FoodSources:");
        for (FoodSource foodSource: foodSources) {
            System.out.println(foodSource.getPosition().toString());
        }
    }

    public Position wrapPosition(Position pos) {
        var x = pos.x() % dimension.width();
        if (x < 0) {x += dimension.width();}
        var y = pos.y() % dimension.height();
        if (y < 0) {y += dimension.height();}
        return new Position(x, y);
    }

    void setScentTrail(Position pos, float strength) {
        pos = wrapPosition(pos); // normalise coordinates to field boundaries
        this.field[pos.y()][pos.x()] = strength;
    }

    float getScentTrail(Position pos) {
        pos = wrapPosition(pos); // normalise coordinates to field boundaries
        return this.field[pos.y()][pos.x()];
    }

    void update() {
        for (Ant ant : ants) {
            State antState = ant.getState();
            Position position = ant.getPosition();
            if (getScentTrail(position) > 0.7F) {
                ant.setState(State.SUCHE);
            }
            for (FoodSource source : this.foodSources) {
                if (source.getPosition().equals(ant.getPosition())) {
                    ant.setState(State.BRINGT);
                }
            }
            setScentTrail(position, 0.98F);
            switch (antState) {
                case ERKUNDUNG -> ant.randomMove(this);
                case SUCHE -> ant.searchMove(this);
                case BRINGT -> ant.deliverMove(this);
            }
        }
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                field[i][j] *= 0.98F;
            }
        }
    }
}