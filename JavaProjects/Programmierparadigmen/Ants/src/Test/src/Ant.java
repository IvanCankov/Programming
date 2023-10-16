package Test.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Ant {
    private static final float BASE_PROBABILITY = 0.01F;
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
        this.position = posAntHill;                                     // spawns ants in centre of AntHill
        this.lastDirectionIdx = ThreadLocalRandom.current().nextInt(directions.length);
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

    public void invertDirection() {
        this.lastDirectionIdx = wrapAddDirectionIdx(4);
    }

    private void moveInDirection(int directionIdx, Field field) {
        this.position = field.wrapPosition(position.add(directions[directionIdx]));
        this.lastDirectionIdx = directionIdx;
    }

    private int getNextDirIdx(Field field, boolean invertProbabilities) {
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
            Position scentPos = position.add(directions[i]);
            float scent = field.getScentTrail(scentPos) + BASE_PROBABILITY;

            if (field.getScentTrail(scentPos) > 0.6 && this.state == State.ERKUNDUNG) {
                this.setState(State.SUCHE);
                return i;
            }

            if (invertProbabilities) {
                scent = 1/scent;
            }
            scentInDir[i] = scent;
            scentSum += scent;
        }
        // normalise scent values so sum = 1, implies scent values will be between 0 and 1
        for (int i : possibleDirIdxs) {
            scentInDir[i] /= scentSum;
        }
        // calculate probability ranges
        var possibilityRanges = new float[possibleDirIdxs.length+1];
        possibilityRanges[0] = 0;
        for (int i = 0; i < possibleDirIdxs.length; i++) {
            possibilityRanges[i+1] = possibilityRanges[i] + scentInDir[possibleDirIdxs[i]];
        }
        // calculate next direction
        float r = ThreadLocalRandom.current().nextFloat(); // get random value between 0 and 1
        int newDirectionIdx = 0;
        for (int i = 0; i < possibilityRanges.length-1; i++) {
            if (r >= possibilityRanges[i] && r < possibilityRanges[i+1]) {
                newDirectionIdx = possibleDirIdxs[i];
                break; // not needed but avoids unnecessary checks
            }
        }
        return newDirectionIdx;
    }

    public void discoverMove(Field field) {
        int newDirectionIdx = getNextDirIdx(field, true);
        moveInDirection(newDirectionIdx, field); // update position of Ant
    }

    void searchMove(Field field) {
        int newDirectionIdx = getNextDirIdx(field, false);
        moveInDirection(newDirectionIdx, field); // update position of Ant
    }


    public void deliverMove(Field field) {
        int newDirectionIdx = getNextDirIdx(field, false);
        moveInDirection(newDirectionIdx, field); // update position of Ant
    }
}