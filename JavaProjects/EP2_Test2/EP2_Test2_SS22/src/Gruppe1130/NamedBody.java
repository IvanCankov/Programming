package Gruppe1130;
// This class represents a single body with no other objects in orbit.
// A named body has a name and a mass in kilograms.
//
public class NamedBody {

    //TODO: declare variables.

    // Initializes this body with name, mass and position.
    // Preconditions (need not be checked):
    // name != null, mass > 0, position != null
    public NamedBody(String name, double mass, Vector2 position) {
        // TODO: implement constructor.
    }

    // Returns the name of 'this'.
    public String getName() {
        // TODO: implement method.
        return "";
    }

    // Returns the mass of 'this'.
    public double getMass() {
        // TODO: implement method.
        return 0;
    }

    // Returns the position of 'this'.
    public Vector2 getPosition() {
        // TODO: implement method.
        return null;
    }

    // Returns a readable representation of 'this' with the name of the body, its mass
    // and its position.
    public String toString() {
        // TODO: implement method.
        return "";
    }

    // Returns a new body which represents the result of merging 'b' and 'this' if 'this' has the
    // same position as 'b' in which case result has the same position as 'this'.
    // Otherwise 'null' is returned.
    // The result has the name of 'this' if 'this' has more mass than 'b', otherwise
    // it has the name of 'b'. The mass of the result corresponds to the sum of the
    // masses of 'b' and 'this'.
    // Objects 'this' and 'b' must not be modified.
    // Precodition: b != null (needs not be checked).
    public NamedBody merge(NamedBody b) {
        // TODO: implement method.
        return null;
    }

    // Compares the position of 'this' with that of 'body'. With 'p1' being the position
    // of 'this' and 'p2' the position of 'body', the method returns p1.compareTo(p2).
    // Precondition: b != null (needs not be checked).
    public int compareTo(NamedBody body) {
        // TODO: implement method.
        return 0;
    }


}





