package Test.src;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static Test.src.Parameters.*;

public class Ant extends FieldObj {

    private int lastDirectionIdx;  // the last direction the Ant moved in
    private State state;           // state the Ant is in
    private final AntHill home;          // the AntHill the Ant belongs to
    private boolean doRandomMove;

    // Ant fightclub uwu
    private int HP;
    private final int attack;

    /**
     * @return HP of the ant
     */
    public int getHP() {
        return this.HP;
    }

    /**
     * This method makes two ants fight
     * @param ant is the other ant this ant will fight with
     */
    public void fight(Ant ant) {
        ant.HP -= this.attack;
        this.HP -= ant.attack;
    }

    /**
     *  These are the 8 relative fields around an Ant
     *  the order is important, the coordinates form a circle
     */
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

    /**
     * @param home is the anthill the ant belong to
     * @param hp is the hitpoints that the ant has
     * @param attack is the attack power that the ant has
     */

    public Ant(AntHill home, int hp, int attack) {
        this.HP = hp;                                // position of AntHill needed for spawning of Ants
        this.attack = attack;
        this.state = State.ERKUNDUNG;						    	// initial State is 'Erkundung'
        this.position = home.getPosition();                                 // spawns ants in centre of AntHill
        this.lastDirectionIdx = ThreadLocalRandom.current().nextInt(directions.length);
        this.doRandomMove = false;
        this.home = home;
    }

    /**
     * @return the anthill that the ant belongs to
     */

    public AntHill getHome() {
        return this.home;
    }

    /**
     * Set lastDirectionIdx to provided value, wrapped if too large or small
     * @param lastDirectionIdx the last direction the ant chose
     */
    public void setLastDirectionIdx(int lastDirectionIdx) {
        this.lastDirectionIdx = 0;
        this.lastDirectionIdx = wrapAddDirectionIdx(lastDirectionIdx);
    }

    /**
     * @return the state of the ant
     */
    public State getState() {
        return state;
    }

    /**
     * Sets the state of the ant
     * @param tmp is what the ants state will be set to
     */
    public void setState(State tmp) {
        this.state = tmp;
    }

    /**
     * Normalises directions to the 8 that our ant can move in
     * @param add
     * @return the direction in which our ant will move
     */
    private int wrapAddDirectionIdx(int add) {
        int newDirectionIdx = (lastDirectionIdx + add) % directions.length;
        // needed as modulo in Java returns a negative number for negative input
        if (newDirectionIdx < 0) {newDirectionIdx += directions.length;}
        return newDirectionIdx;
    }

    /**
     * Returns all the positions the ant can move to
     * @param field is the field on which the ant currently is
     * @param directionIdx ??
     * @return ??
     */
    public Position getRelativePosition(Field field, int directionIdx) {
        return field.wrapPosition(position.add(directions[wrapAddDirectionIdx(directionIdx)]));
    }

    /**
     * Set the direction of the ant to be the inverse of the previous direction
     */
    public void invertDirection() {
        this.lastDirectionIdx = wrapAddDirectionIdx(4);
    }

    // move position of Ant according to directionIdx, and update lastDirectionIdx variable accordingly
    private void moveInDirection(Field field, int directionIdx) {
        this.position = field.wrapPosition(position.add(directions[directionIdx]));
        this.lastDirectionIdx = directionIdx;
        SimulationsDB.addMovement(this, position);
    }

    /**
     * BLACK MAGIC DO NOT TOUCH
     * @param field is the field that the ant is on
     * @return index of the direction the ant will move
     */
    private int getPositionWithLowestEuclideanDistance(Field field) {
        var possibleDirIdxs = new int[] {
                wrapAddDirectionIdx(-2),
                wrapAddDirectionIdx(-1),
                lastDirectionIdx,
                wrapAddDirectionIdx(1),
                wrapAddDirectionIdx(2)
        };

        float maxProbability = Float.MIN_VALUE;
        int maxProbabilityIdx = -1;

        for (int i : possibleDirIdxs) {
            Position scentPos = position.add(directions[i]);
            float scent = field.getScentTrail(scentPos, this) + BASE_PROBABILITY;
            float distance = (float) this.home.getEuclideanDistance(scentPos);

            // play around with this so the ants path is not just a straight line
            // float probability = (distance + 1) * scent / ((distance + 1) * (distance + 1));
            // float probability = scent / ((distance + 1) * (distance + 1));
            // float probability = (-distance + 1) * scent / ((distance + 1) * (distance + 1)); this is js beautiful

            // Best one so far
            // float probability = scent * 3 / ((distance + 1) * (distance + 1) * (distance + 1));
            float probability = (float) (scent * 13.4F / Math.pow((distance + 1), 7));

            if (probability > maxProbability) {
                maxProbability = probability;
                maxProbabilityIdx = i;
            }
        }

        if (maxProbabilityIdx != -1) {
            return maxProbabilityIdx;
        }

        float[] scentInDir = new float[possibleDirIdxs.length];
        float sum = 0;

        for (int i = 0; i < possibleDirIdxs.length; i++) {
            int idx = possibleDirIdxs[i];
            Position scentPos = position.add(directions[idx]);
            float scent = field.getScentTrail(scentPos, this);
            float distance = (float) ((float) this.home.getEuclideanDistance(scentPos));
            float probability = (scent + (-distance + 1)) / (-distance + 1);
            scentInDir[i] = probability;
            sum += probability * -(distance + 1);
        }

        for (int i = 0; i < possibleDirIdxs.length; i++) {
            scentInDir[i] /= sum;
            if (scentInDir[i] < 0.1F) scentInDir[i] = 0.5F / sum;

        }

        float r = ThreadLocalRandom.current().nextFloat();
        int newDirectionIdx = 0;

        for (int i = 0; i < scentInDir.length; i++) {
            if (r >= (i > 0 ? scentInDir[i - 1] : 0) && r < scentInDir[i]) {
                newDirectionIdx = possibleDirIdxs[i];
                break;
            }
        }

        return newDirectionIdx;
    }

    // uses info about the field and a possible position
    // to check if the state of the Ant needs to be updated
    // returns true if Ant should move to field directly (FoodSource or AntHill
    private boolean updateState(Field field, Position possiblePos) {
        switch (this.state) {
            case ERKUNDUNG -> {
                if (field.getScentTrail(possiblePos, this) > SCENT_THRESHOLD_SUCHE) {
                    this.state = State.SUCHE;
                }
                for (FoodSource source : field.getFoodSourcesAtPosition(possiblePos)) {
                    this.state = State.BRINGT;
                    invertDirection();
                    source.grabFood();
                    SimulationsDB.registerFoodFound(this, source);
                    // Ant can only grab food once
                    return true;
                }
            }
            case SUCHE -> {
                for (FoodSource source : field.getFoodSourcesAtPosition(possiblePos)) {
                    this.state = State.BRINGT;
                    invertDirection();
                    source.grabFood();
                    // Ant can only grab food once
                    return true;
                }
            }
            case BRINGT -> {
                if (this.position.equals(field.getAntHillPosition())) {
                    field.addFoodToAntHill();
                    this.state = State.SUCHE;
                    invertDirection();
                    return true;
                }
            }
        }
        return false;
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
            float scent = field.getScentTrail(scentPos, this) + BASE_PROBABILITY;
            boolean moveDirectly = updateState(field, scentPos);
            if (moveDirectly) {
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

    public void move(Field field) {
        // set scent
        switch (this.state) {
            case ERKUNDUNG -> field.addScentTrail(position, this, SCENT_STRENGTH_ERKUNDUNG);
            case SUCHE     -> field.addScentTrail(position, this, SCENT_STRENGTH_SUCHE);
            case BRINGT    -> field.addScentTrail(position, this, SCENT_STRENGTH_BRINGT);
        }
        // move Ant
        if (doRandomMove) {
            this.doRandomMove = false;
            randomMove(field);
            return;
        }
        switch (this.state) {
            case ERKUNDUNG -> discoverMove(field);
            case SUCHE     -> searchMove(field);
            case BRINGT    -> deliverMove(field);
        }
        this.doRandomMove = ThreadLocalRandom.current().nextFloat() <= RANDOM_MOVE_PROBABILITY;
    }

    // move Ant to next coordinate, used in State 'Erkundung'
    private void discoverMove(Field field) {
        // invert probabilities so the direction with the least scent has the highest probability
        int newDirectionIdx = getNextDirIdx(field, true);
        moveInDirection(field, newDirectionIdx); // update position of Ant
    }

    // move Ant to next coordinate, used in State 'Suche'
    private void searchMove(Field field) {
        int newDirectionIdx = getNextDirIdx(field, false);
        moveInDirection(field, newDirectionIdx); // update position of Ant
    }

    // move Ant to next coordinate, used in State 'Bringt'
    private void deliverMove(Field field) {
        int newDirectionIdx = getPositionWithLowestEuclideanDistance(field);
        moveInDirection(field, newDirectionIdx); // update position of Ant
    }

    private void randomMove(Field field) {
        int ranInt = ThreadLocalRandom.current().nextInt(5) - 2; // random number from -2 to 2
        int newDirectionIdx = wrapAddDirectionIdx(ranInt);
        moveInDirection(field, newDirectionIdx); // update position of Ant
    }
}