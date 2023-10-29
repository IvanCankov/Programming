package Test.src;

public final class Parameters {

    private Parameters() {
        // restrict instantiation
    }

    // switch from 'ERKUDUNG' to 'SUCHE' if this threshold is met
    public static final float SCENT_THRESHOLD_SUCHE = 2F;
    // to always allow for some randomness even if scent is 0 at some coordinates but not others
    public static final float BASE_PROBABILITY = 0.0001F;
    // probability of ant doing a random move instead
    public static final float RANDOM_MOVE_PROBABILITY = 0.05F;
    // strength of scent left by Ant in State 'ERKUNDUNG'
    public static final float SCENT_STRENGTH_ERKUNDUNG = 0.05F;
    // strength of scent left by Ant in State 'SUCHE'
    public static final float SCENT_STRENGTH_SUCHE = 0.1F;
    // strength of scent left by Ant in State 'BRINGT'
    public static final float SCENT_STRENGTH_BRINGT = 0.25F;
    // multiplier used for color strength in scent display
    public static final float SCENT_DISPLAY_MULTIPLIER = 1F;
    // at each iteration all scent strength values on the field are multiplied by this number
    public static final float SCENT_FIELD_MULTIPLIER = 0.999F;
    //
    public static final float MIN_SCENT_STRENGTH = 0.00001F;
    // max scent value possible
    public static final float MAX_SCENT_STRENGTH = 100F;

    public static final boolean ANT_SLEEPY_WAKEY_TIMER = true;

}
