package src;

public final class Parameters {

    private Parameters() {
        // restrict instantiation
    }

    // switch from 'ERKUDUNG' to 'SUCHE' if this threshold is met
    public static final float SCENT_THRESHOLD_SUCHE = 1F;
    // to always allow for some randomness even if scent is 0 at some coordinates but not others
    public static final float BASE_PROBABILITY = 0.01F;
    // strength of scent left by Ant in State 'ERKUNDUNG'
    public static final float SCENT_STRENGTH_ERKUNDUNG = 0.1F;
    // strength of scent left by Ant in State 'SUCHE'
    public static final float SCENT_STRENGTH_SUCHE = 0.1F;
    // strength of scent left by Ant in State 'BRINGT'
    public static final float SCENT_STRENGTH_BRINGT = 1F;
    // multiplier used for color strength in scent display
    public static final float SCENT_DISPLAY_MULTIPLIER = 1F;
    // at each iteration all scent strength values on the field are multiplied by this number
    public static final float SCENT_FIELD_MULTIPLIER = 0.99F;


}
