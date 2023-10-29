package Test.src;

import java.util.concurrent.ThreadLocalRandom;

import static Test.src.Parameters.*;


public class Ant extends FieldObj implements Colony {

    private int lastDirectionIdx;  // the last direction the Ant moved in
    private State state;           // state the Ant is in
    private Behaviour behaviour;   // behavioural pattern the Ant follows
    private final AntHill home;    // the AntHill the Ant belongs to
    private boolean doRandomMove;  // if true the next move will be in a random direction
    private int travelDistance;

    // Ant fightclub uwu
    private int HP;
    private final int attack;


    /**
     * @return HP of the ant
     * @author Ivan Cankov
     */
    public int getHP() {
        return this.HP;
    }

    /**
     * This method makes two ants fight
     * @param ant is the other ant this ant will fight with
     * @author Ivan Cankov
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
        int behaviourIdx = ThreadLocalRandom.current().nextInt(Behaviour.values().length);
        this.behaviour = Behaviour.values()[behaviourIdx];
        this.position = home.getPosition();                                 // spawns ants in centre of AntHill
        this.lastDirectionIdx = ThreadLocalRandom.current().nextInt(directions.length);
        this.doRandomMove = false;
        this.home = home;
        this.travelDistance = 0;
    }

    /**
     * @return the AntHill that the ant belongs to
     */
    @Override
    public AntHill getColony() {
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
     * Add to internal direction index and normalise to the 8 directions that our Ant can move in
     * @param add the direction index to add to the internal index
     * @return the direction index of param 'add' plus the internal index
     */
    private int wrapAddDirectionIdx(int add) {
        int newDirectionIdx = (lastDirectionIdx + add) % directions.length;
        // needed as modulo in Java returns a negative number for negative input
        if (newDirectionIdx < 0) {newDirectionIdx += directions.length;}
        return newDirectionIdx;
    }

    /**
     * Returns the positions an Ant would move to, given a specific directionIdx offset
     * @param field is the field on which the ant currently is
     * @param directionIdxOffset the offset applied to the Ants
     * @return Position on the field, derived from Ants current position and direction
     */
    public Position getRelativePosition(Field field, int directionIdxOffset) {
        return field.wrapPosition(position.add(directions[wrapAddDirectionIdx(directionIdxOffset)]));
    }

    /**
     * Set the direction of the ant to be the inverse of the previous direction
     */
    public void invertDirection() {
        this.lastDirectionIdx = wrapAddDirectionIdx(4);
    }

    // move position of Ant according to directionIdx, and update lastDirectionIdx variable accordingly
    private boolean moveInDirection(Field field, int directionIdx) {
        Position newPos = position.add(directions[directionIdx]);
        Obstacle potentialObstacle = field.obstacleAt(newPos);
        if (potentialObstacle == null || obstacleShouldBeScaled(potentialObstacle)) {
            this.position = field.wrapPosition(newPos);
            this.lastDirectionIdx = directionIdx;
            travelDistance = travelDistance + 1;
            SimulationsDB.addMovement(this, position);
            return true;
        }
        return false;
    }
    /**
     * BLACK MAGIC DO NOT TOUCH
     * @param field is the field that the ant is on
     * @return index of the direction the ant will move
     * @author Ivan Cankov
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
            float probability = scent * 3 / ((distance + 1) * (distance + 1) * (distance + 1));

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
            float scent = field.getScentTrail(scentPos, this) + BASE_PROBABILITY;
            float distance = (float) this.home.getEuclideanDistance(scentPos);
            float probability = scent / (distance + 1);
            scentInDir[i] = probability;
            sum += probability;
        }

        for (int i = 0; i < possibleDirIdxs.length; i++) {
            scentInDir[i] /= sum;
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


    /**
     * uses info about the field and a possible position
     * and updates the state of the Ant if needed
     * @param field is the Field that the Ant is on
     * @return true if Ant should move to checked position directly (FoodSource or AntHill)
     * @author Mathias Engel
     */
    private boolean updateState(Field field, Position possiblePos) {

        switch (this.state) {
            case ERKUNDUNG -> {
                if (field.getScentTrail(possiblePos, this) > SCENT_THRESHOLD_SUCHE) {
                    this.state = State.SUCHE;
                }
                if (grabFoodAndInvertDirection(field, possiblePos)) {
                    this.state = State.BRINGT; // -> Ant can only grab food once
                    return true;
                }
            }
            case SUCHE -> {
                if (grabFoodAndInvertDirection(field, possiblePos)) {
                    this.state = State.BRINGT; // -> Ant can only grab food once
                    return true;
                }
            }
            case BRINGT -> {
                if (this.position.equals(field.getAntHillPosition())) {
                    field.addFoodToAntHill();
                    this.state = State.SUCHE;
                    invertDirection();
                    SimulationsDB.startNewPathAfterAnthill(this);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * try to grab food and if successful invert direction
     * @param field Field the Ant lives on
     * @param pos Position to check for food source
     * @return true if there is a food source at the given position
     *         false if there is no food source at the position
     */
    private boolean grabFoodAndInvertDirection(Field field, Position pos) {
        FoodSource source = field.getFoodSourceAtPosition(pos);
        if (source == null) {
            return false;
        }
        assert(source.hasFood());
        invertDirection();
        source.grabFood();
        SimulationsDB.addMovement(this, pos);
        SimulationsDB.registerFoodFound(this, source);

        if (!source.hasFood())
        {
            //Food source has been exhausted
            field.removeFoodSource(source);
        }
        return true;
    }


    /**
     * returns the index of the next direction the Ant should move
     * based on the scent values of surrounding coordinates and randomness
     * @param field Field the Ant lives on
     * @param invertProbabilities if set to true Ant will prefer directions with
     *                            low scent value instead of high scent values
     * @return the index of the direction the ant should move to
     * @author Mathias Engel
     */
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

    /**
     * Move ant to new Position on the Field based on it's internal State
     * @param field the Field the Ant lives on
     * @author Mathias Engel
     */
    public void move(Field field) {
        // set scent
        switch (this.state) {
            case ERKUNDUNG -> field.addScentTrail(position, this, SCENT_STRENGTH_ERKUNDUNG);
            case SUCHE     -> field.addScentTrail(position, this, SCENT_STRENGTH_SUCHE);
            case BRINGT, RETURNS    -> field.addScentTrail(position, this, SCENT_STRENGTH_BRINGT);
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
            case BRINGT, RETURNS -> deliverMove(field);
        }
        // determine if next move should be random move
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

    // move ant in random direction
    private void randomMove(Field field) {
        int ranInt = ThreadLocalRandom.current().nextInt(5) - 2; // random number from -2 to 2
        int newDirectionIdx = wrapAddDirectionIdx(ranInt);
        boolean canMove = moveInDirection(field, newDirectionIdx); // update position of Ant
        int tempFix = 0; // TODO: add proper fix
        while (!canMove && tempFix < 10)
        {
            if (ranInt >= 2)
            {
                ranInt = -2;
            }
            ranInt = ranInt + 1;
            newDirectionIdx = wrapAddDirectionIdx(ranInt);
            canMove = moveInDirection(field, newDirectionIdx);
            tempFix++;
        }

    }

    // True if obstacle should be scaled, false if obstacle should be avoided
    public boolean obstacleShouldBeScaled(Obstacle obstacle)
    {
        // Scaling can be more taxing if the ant has travelled farther
        return ((int) obstacle.getAvgScaleCost() + travelDistance) < obstacle.getAvgPassCost();
    }
}