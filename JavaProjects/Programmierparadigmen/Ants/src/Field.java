import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Field {

    private float[][] field;
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
        this.field = new float[this.width][this.height];  			// initialises the field as an MxN board
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

    void setScentTrail(int x, int y, float strength) {
        this.field[y][x] = strength;
    }

    float getScentTrail(int x, int y) {
        return this.field[y][x];
    }

    void update() {
        for (Ant ant : ants) {
            State antState = ant.getState();
            int[] position = ant.getPosition();
            if (getScentTrail(position[0], position[1]) > 0.7F) {
                ant.setState(State.SUCHE);
            }
            // @FluxTape wenn die Ameisen Futter bringen mach es so, dass die eine Spurstaerke von 0.98 hinterlassen
            // ich will es naemlich so implementieren wenn die eine Spur von groesser als 0.7 finden dann fangen die
            // Ameisen an diese zu Folgen. Danke :)

            setScentTrail(position[0], position[1], 0.7F);
            switch (antState) {
                case ERKUNDUNG -> ant.randomMove(this);
                case SUCHE -> ant.searchMove(this);
            }
        }
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                field[i][j] *= 0.98F;
            }
        }
    }
}