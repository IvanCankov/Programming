// This class represents a camel (animal). A camel has a strength and can walk at a
// maximum pace (speed) determined by its strength and the load it carries. Load slows down the
// camel (maximal pace = strength - load).
// Please, do not change this class definition.
//
public class Camel {
    private int strength;
    private int load;

    // Initializes this point with its coordinates.
    // Precondition: strength > 0 && load >= 0.
    public Camel(int strength, int load) {

        this.strength = strength;
        this.load = load;
    }

    // Returns the strength of this camel.
    public int getStrength() {

        return this.strength;
    }

    // Returns the maximum pace of this camel.
    public int getMaxPace() {

        return this.strength > this.load ? this.strength - this.load : 0;
    }

    // Returns the load that this camel is carrying.
    public int getLoad() {

        return this.load;
    }

    // Returns a string representation of this camel in the form
    // (strength - load = maximal pace).
    @Override
    public String toString() {

        return "(" + this.strength + "-" + this.load + "=" + getMaxPace() + ")";
    }
}
