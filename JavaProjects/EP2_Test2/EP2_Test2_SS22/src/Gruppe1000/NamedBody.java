package Gruppe1000;

// This class represents a single body with no other objects in orbit.
// A named body has a name and a mass in kilograms.
// Please, do not change this class definition!
//
public class NamedBody implements Massive {

    private String name;
    private double mass;

    // Initializes this body with name, mass and position.
    // Preconditions (need not be checked):
    // name != null, mass > 0, position != null
    public NamedBody(String name, double mass) {
        this.name = name;
        this.mass = mass;
    }

    // Returns the name of 'this'.
    public String getName() {

        return name;
    }

    // Returns a readable representation of 'this' with the name of the body and its mass.
    public String toString() {
        return name + ": " + mass + " kg.";
    }

    @Override
    public double getMass() {
        return mass;
    }
}

