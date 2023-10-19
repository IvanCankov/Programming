package Test.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Ant {
    private static final float BASE_PROBABILITY = 0.01F; // to always allow for some randomness even if scent is 0
    private int lastDirectionIdx;  // the last direction the Ant moved in
    private State state;           // state the Ant is in
    private Position position;     // position.x() coordinate in width, position.y() coordinate in height


    // These are the 8 relative fields around an Ant
    // the order is important, the coordinates form a circle
    private static final Position[] directions = {
            new Position( 0,  1),    // North
            new Position( 1,  1),    // Northeast
            new Position( 1,  0),    // East
            new Position( 1, -1),    // Southeast
            new Position( 0, -1),    // South
            new Position(-1, -1),    // Southwest
            new Position(-1,  0),    // West
            new Position(-1,  1)     // Northwest
    };

    public Ant(Position posAntHill) {				// position of AntHill needed for spawning of Ants
        this.state = State.ERKUNDUNG;				// initial State is 'Erkundung'
        this.position = posAntHill;                 // spawns ants in centre of AntHill
        this.lastDirectionIdx = ThreadLocalRandom.current().nextInt(directions.length);
    }

    // returns the position of the Ant
    public Position getPosition() {
        return this.position;
    }

    // returns the State of the Ant
    public State getState() {
        return state;
    }

    // set the State of the Ant from other classes
    public void setState(State tmp) {
        this.state = tmp;
    }

    // Das hier ist echt schlau W man's @FluxTape
    private int wrapAddDirectionIdx(int add) {
        int newDirectionIdx = (lastDirectionIdx + add) % directions.length;
        // needed as modulo in Java returns a negative number for negative input
        if (newDirectionIdx < 0) {newDirectionIdx += directions.length;}
        return newDirectionIdx;
    }

    // set direction of the Ant to be the inverse of the previous direction
    public void invertDirection() {
        this.lastDirectionIdx = wrapAddDirectionIdx(4);
    }

    // move position of Ant according to directionIdx, and update lastDirectionIdx variable accordingly
    private void moveInDirection(int directionIdx, Field field) {
        this.position = field.wrapPosition(position.add(directions[directionIdx]));
        this.lastDirectionIdx = directionIdx;
    }

    // returns the index of the next direction the Ant should move
    // based on the scent values of surrounding coordinates and randomness
    private int getNextDirIdx(Field field, boolean invertProbabilities) {
        // calculate direction indexes the Ant could move
        var scentInDir = new float[directions.length];
        var possibleDirIdxs = new int[] {
                wrapAddDirectionIdx(-2),
                wrapAddDirectionIdx(-1),
                lastDirectionIdx,
                wrapAddDirectionIdx(1),
                wrapAddDirectionIdx(2)
        };
        // get relevant scent values from previously calculated directions
        float scentSum = 0; // sum of scent values of relevant coordinates
        for (int i : possibleDirIdxs) {
            Position scentPos = position.add(directions[i]);
            float scent = field.getScentTrail(scentPos) + BASE_PROBABILITY;
            // if scent is above some threshold update state of the Ant
            if (field.getScentTrail(scentPos) > 0.6 && this.state == State.ERKUNDUNG) {
                this.setState(State.SUCHE);
                return i;
            }
            // if the invertProbabilities argument is true, invert the probabilities
            // by using the reciprocal of the scent values.
            // this is possible because the values will be normalised anyway
            if (invertProbabilities) {
                scent = 1/scent;
            }
            scentInDir[i] = scent; // set scent value in local array
            scentSum += scent;     // update sum of scent values
        }
        // normalise scent values so sum = 1, implies scent values will be between 0 and 1
        for (int i : possibleDirIdxs) {
            scentInDir[i] /= scentSum;
        }
        // calculate probability ranges from scent values
        // result has the form [0, 0.a, 0.b, 0.c, ..., 1]
        var possibilityRanges = new float[possibleDirIdxs.length+1];
        possibilityRanges[0] = 0;
        for (int i = 0; i < possibleDirIdxs.length; i++) {
            possibilityRanges[i+1] = possibilityRanges[i] + scentInDir[possibleDirIdxs[i]];
        }
        // calculate next direction using probability ranges and randomness
        float r = ThreadLocalRandom.current().nextFloat(); // get random value between 0 and 1
        int newDirectionIdx = 0;
        for (int i = 0; i < possibilityRanges.length-1; i++) {
            if (r >= possibilityRanges[i] && r < possibilityRanges[i+1]) {
                newDirectionIdx = possibleDirIdxs[i];
                break; // not needed but avoids unnecessary checks as only one range will satisfy condition
            }
        }
        return newDirectionIdx;
    }

    // move Ant to next coordinate, used in State 'Erkundung'
    public void discoverMove(Field field) {
        // invert probabilities so the direction with the least scent has the highest probability
        int newDirectionIdx = getNextDirIdx(field, true);
        moveInDirection(newDirectionIdx, field); // update position of Ant
    }

    // move Ant to next coordinate, used in State 'Suche'
    void searchMove(Field field) {
        int newDirectionIdx = getNextDirIdx(field, false);
        moveInDirection(newDirectionIdx, field); // update position of Ant
    }

    // move Ant to next coordinate, used in State 'Bringt'
    public void deliverMove(Field field) {
        int newDirectionIdx = getNextDirIdx(field, false);
        moveInDirection(newDirectionIdx, field); // update position of Ant
    }
}