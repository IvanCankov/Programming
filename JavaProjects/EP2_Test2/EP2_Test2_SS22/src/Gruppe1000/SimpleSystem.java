package Gruppe1000;

// An unstructured, unordered system of cosmic bodies.
// 'SimpleSystem' is subtype of 'CosmicSystem'.
//
// TODO: Implementation of this class.
//  You can use the Java-Collection framework in your implementation.
//
public class SimpleSystem {

    // TODO: Define missing parts of the class.
    //  Further methods can be added if necessary (but no setters or
    //  getters that return or set just the value of a variable).

    // Initializes this system with its bodies.
    // Precondition: bodies != null && bodies.length > 0.
    public SimpleSystem(NamedBody... bodies) {
        // TODO: implement constructor.
    }

    // Adds a body to 'this'.
    // Precondition: toAdd != null.
    public void add(NamedBody toAdd) {
        // TODO: implement method.
    }

    @Override
    // Returns 'true' if 'this' and 'obj' are equal, i.e. if and only if 'this' and 'obj'
    // have the same set of bodies (regardless of the order specified in the constructor's
    // 'bodies' parameter).
    public boolean equals(Object obj) {
        // TODO: implement method.
        return false;
    }

    @Override
    // Returns the hash code of 'this'.
    public int hashCode() {
        // TODO: implement method.
        return -1;
    }
}

//TODO: Define additional class(es) if needed (either here or in a separate file).