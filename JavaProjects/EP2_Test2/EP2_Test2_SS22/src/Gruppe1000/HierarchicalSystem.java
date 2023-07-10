package Gruppe1000;

// A hierarchical system of named bodies consisting of cosmic systems.
// 'HierarchicalSystem' is subtype of CosmicSystem.
//
// TODO: Implementation of this class.
//  You can use the Java-Collection framework in your implementation.
//
public class HierarchicalSystem {

    // TODO: Define missing parts of the class.
    //  Further methods can be added if necessary (but no setters or
    //  getters that return or set just the value of a variable).

    // Initializes 'this' with subsystems.
    // Precondition: systems != null && systems.length > 1.
    public HierarchicalSystem(CosmicSystem... systems) {
        // TODO: implement constructor.
    }

    @Override
    // Returns 'true' if 'this' and 'obj' are equal, i.e., if 'this' and 'obj' have equal
    // subsystems with equal hierarchical structure, however regardless of the order
    // in which subsystems appear at each level of the system.
    // This means the method returns 'true' if the number of subsystems is
    // the same in 'this' and 'obj' and every subsystem of the specified system is equal to one
    // in 'this' (or equivalently, every subsystem of 'this' is equal to one in the specified
    // system). Otherwise 'false' is returned.
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
