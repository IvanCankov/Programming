import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Field {

    private int[][] field;
    private final int width;
    private final int height;
    HashSet<Ant> ants;  						// storing ants in a set where each ant has a position stored with it so
    // that we don't have to use a 3D array to store ants and the trail
    HashSet<FoodSource> foodSources;
    AntHill antHill;
    private Random random;
    public Field(int width, int height, int antCount, int foodSourceCount) {
        this.width = width;
        this.height = height;
        this.field = new int[this.width][this.height];  	// initialises the field as an MxN board
        this.random = new Random();
        this.antHill = new AntHill(this.getRandomFieldPos()); // place antHill at random position
        this.ants = new HashSet<>();
        for (int i = 0; i < antCount; i++){	 	// 100 ants get added to the centre of the board
            ants.add(new Ant(this.antHill.getPosition()));
        }
        this.foodSources = new HashSet<>();
        for (int i = 0; i < foodSourceCount; i++) {
            foodSources.add(new FoodSource(this.getRandomFieldPos()));
        }
    }

    // return a random position within the field
    int[] getRandomFieldPos() {
        int w_pos = this.random.nextInt(this.width);
        int h_pos = this.random.nextInt(this.height);
        return new int[]{w_pos, h_pos};
    }

    public int[] getFieldDimensions() {
        return new int[] {field[0].length, field.length};
    }

    void printAnts() {
        System.out.println("Ants:");
        for (Ant ant: ants) {
            System.out.println(Arrays.toString(ant.getPosition()));
        }
    }

    void printHillAndFoodSources() {
        System.out.println("AntHill:");
        System.out.println(Arrays.toString(antHill.getPosition()));
        System.out.println("FoodSources:");
        for (FoodSource foodSource: foodSources) {
            System.out.println(Arrays.toString(foodSource.getPosition()));
        }
    }

    void update() {
        for (Ant ant : ants) {
            State antState = ant.getState();
            switch (antState) {
                case ERKUNDUNG -> ant.randomMove(this);
            }
        }
    }
}