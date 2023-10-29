package Test.src;

import java.util.Hashtable;

import static Test.src.Parameters.*;

/** Used to store the scents left by different Ants on a specific coordinate
 *  @author Mathias Engel
 */
public class Scent {
    // maps: AntHill -> Ant -> Float
    // The general idea is to store the scent value each ant has left on the particular Scent object
    // since each Ant also has a corresponding home (AntHill) it is easy to map from AntHill to Ant to
    // respective scent strength. This way one can get either the scent value one specific ant has added
    // or the cumulative scent strength a whole colony has added to the Scent object.
    private final Hashtable<AntHill, Hashtable<Ant, Float>> scent;

    public Scent() {
        this.scent = new Hashtable<>();
    }


    // get cumulative strength of scent from Ants of the specified colony
    public float getStrength(Colony colony) {
        var colonyScent = scent.get(colony.getColony());
        if (colonyScent == null) {
            return 0F;
        }
        return colonyScent.values().stream().reduce(0F, Float::sum);
    }

    // get strength of scent of one particular ant
    public float getIndividualStrength(Ant ant) {
        var colonyScent = scent.get(ant.getColony());
        if (colonyScent == null) {
            return 0F;
        }
        return colonyScent.getOrDefault(ant, 0F);
    }

    /**
     * Adds a scent value to a given position
     * @param ant is the ant at that position
     * @param strength is the scent strength to be added
     */
    public void addScent(Ant ant, float strength) {
        final AntHill colony = ant.getColony();
        // add new Hashtable for colony if it doesn't exist already
        scent.computeIfAbsent(colony, k -> new Hashtable<>());
        var colonyScent = scent.get(colony);
        final float prevStrength = colonyScent.getOrDefault(ant, 0F);
        float newStrength = prevStrength + strength;
        newStrength = Math.min(newStrength, MAX_SCENT_STRENGTH); // saturating add
        colonyScent.put(ant, newStrength); // set new strength
    }

    /**
     * Fades all scents by SCENT_FIELD_MULTIPLIER found in Parameters.java
     */
    public void fade() {
        for (var colonyScents : scent.values()) {
            for (Ant key : colonyScents.keySet()) {
                float newStrength = colonyScents.get(key) * SCENT_FIELD_MULTIPLIER;
                colonyScents.put(key, newStrength);
            }
        }
        // optimisation: remove scent values below MIN_SCENT_STRENGTH threshold
        scent.values().forEach(t -> t.values().removeIf(f -> f <= MIN_SCENT_STRENGTH));
        scent.values().removeIf(Hashtable::isEmpty); // remove empty hashsets
    }

    /**
     * @return true if there are no scents at a given position
     */
    public boolean isEmpty() {
        return scent.isEmpty();
    }
}


