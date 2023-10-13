import java.util.Random;

public class Ant {
    private Random random;
    private int[] lastDirection;
    private State state;
    private int[] position; // position[0]=width, position[1]=height

    public Ant(int[] posAntHill) {						        // Ants now take in a height, width argument so that they
        this.state = State.ERKUNDUNG;						    // can be spawned dead centre
        this.position = new int[]{posAntHill[0], posAntHill[1]};   // spawns ants in centre of AntHill
        this.random = new Random();			 				    // TODO: summons a new random every time gotta fix this
    }

    public int[] getPosition() {
        return this.position;
    }

    public State getState() {
        return state;
    }

    public void setState(State tmp) {
        this.state = tmp;
    }

    public void randomMove(Field field) {
        boolean moved = false;

        int[][] directions = {
                {0, 1},    // North
                {1, 1},    // Northeast
                {1, 0},    // East
                {1, -1},   // Southeast
                {0, -1},   // South
                {-1, -1},  // Southwest
                {-1, 0},   // West
                {-1, 1}    // Northwest
        };

        int num = -1;
        if (lastDirection == null) {
            num = random.nextInt(8);
        } else {
            num = random.nextInt(5);

            //there is literally a bug here i can't
            directions = new int[][]{								//lastMove 1,1
                    {lastDirection[0], (lastDirection[1] + 1) % 2},		// 1,0
                    {-lastDirection[0], (lastDirection[1] - 1) % 2},		// 1,0
                    {lastDirection[0], lastDirection[1]},				// 1,1
                    {(lastDirection[0] + 1) % 2, lastDirection[1]},		// 0,1
                    {(lastDirection[0] - 1) % 2, -lastDirection[1]}		// 0,1
            };
        }
        //Probably the dumbest way to go about implementing this, but it is what it is

        int newX = position[0] + directions[num][0];
        int newY = position[1] + directions[num][1];
        lastDirection = new int[]{directions[num][0], directions[num][1]};

        position[0] = newX % field.getFieldDimensions()[1];
        position[1] = newY % field.getFieldDimensions()[0];
    }
}
