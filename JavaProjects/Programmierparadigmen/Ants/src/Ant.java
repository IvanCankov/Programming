import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Ant {
    private Random random;
    private int lastDirectionIdx;
    private State state;
    private Position position; // position.x() coordinate in width, position.y() coordinate in height

    private int failedMove;

    // These are the 8 relative fields around an Ant
    // the order is important, the coordinates form a circle
    private static final Position[] directions = {
            new Position( 0,  1),    // North
            new Position( 1,  1),    // Northeast
            new Position( 1,  0),    // East
            new Position( 1, -1),   // Southeast
            new Position( 0, -1),   // South
            new Position(-1, -1),  // Southwest
            new Position(-1,  0),   // West
            new Position(-1,  1)    // Northwest
    };

    public Ant(Position posAntHill) {						        	// Ants now take in a height, width argument so that they
        this.state = State.ERKUNDUNG;						    	// can be spawned dead centre
        this.position = posAntHill;    // spawns ants in centre of AntHill
        this.random = new Random();			 				    	// TODO: summons a new random every time gotta fix this
        this.lastDirectionIdx = this.random.nextInt(directions.length);
        this.failedMove = 0;
    }

    public Position getPosition() {
        return this.position;
    }

    public State getState() {
        return state;
    }

    public void setState(State tmp) {
        this.state = tmp;
    }

    // Das hier ist echt schlau W man's @FluxTape
    private int wrapAddDirectionIdx(int add) {
        int newDirectionIdx = (lastDirectionIdx + add) % directions.length;
        if (newDirectionIdx < 0) {newDirectionIdx += directions.length;};
        return newDirectionIdx;
    }

    private void moveInDirection(int directionIdx, Field field) {
        this.position = field.wrapPosition(position.add(directions[directionIdx]));
        this.lastDirectionIdx = directionIdx;
    }
    public void randomMove(Field field) {
        var rNum = this.random.nextInt(-2, 3); // random number from -2 to 2
        // the indexes around the last direction are the new possible directions for the Ant
        var newDirectionIdx = wrapAddDirectionIdx(rNum);
        moveInDirection(newDirectionIdx, field);
    }

    void searchMove(Field field) {
        // get scent in each direction
        var possibleDirIdxs = new int[] {
                wrapAddDirectionIdx(-2),
                wrapAddDirectionIdx(-1),
                lastDirectionIdx,
                wrapAddDirectionIdx(1),
                wrapAddDirectionIdx(2)
        };
        // get relevant scent values
        float maxScent = 0.0F;
        int chosenPos = 0;
        for (int i : possibleDirIdxs) {
            var scentPos = position.add(directions[i]);
            float scent = field.getScentTrail(scentPos);
            if (scent > maxScent) {
                chosenPos = i;
                maxScent = scent;
            }
        }
        if (maxScent < 0.5) {
            this.failedMove += 1;
            this.randomMove(field);
            if (this.failedMove >= 3) {
                this.setState(State.ERKUNDUNG);
                this.failedMove = 0;
            }
        } else {
            this.moveInDirection(chosenPos, field);
        }


    }


    void deliverMove(Field field) {
        // get scent in each direction
        var scentInDir = new float[directions.length];
        var possibleDirIdxs = new int[] {
                wrapAddDirectionIdx(-2),
                wrapAddDirectionIdx(-1),
                lastDirectionIdx,
                wrapAddDirectionIdx(1),
                wrapAddDirectionIdx(2)
        };
        // get relevant scent values
        float scentSum = 0;
        for (int i : possibleDirIdxs) {
            var scentPos = position.add(directions[i]);
            float scent = field.getScentTrail(scentPos);
            scentInDir[i] = scent;
            scentSum += scent;
        }
        // normalise scent values so sum = 1
        for (int i : possibleDirIdxs) {
            scentInDir[i] /= scentSum;
        }
        // calculate probability ranges
        var possibilityRanges = new float[possibleDirIdxs.length+1];
        possibilityRanges[0] = 0;
        for (int i = 1; i < possibilityRanges.length; i++) {
            possibilityRanges[i] = possibilityRanges[i-1] + scentInDir[possibleDirIdxs[i]];
        }
        // calculate next direction
        float r = random.nextFloat(); // get random value between 0 and 1
        int newDirectionIdx = 0;
        for (int i = 0; i < possibilityRanges.length-1; i++) {
            if (r >= possibilityRanges[i] && r < possibilityRanges[i+1]) {
                newDirectionIdx = possibleDirIdxs[i];
                break; // not needed but avoids unnecessary checks
            }
        }
        // update position of Ant
        moveInDirection(newDirectionIdx, field);
    }
}