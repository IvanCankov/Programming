package Gruppe1300;

// A hierarchical system of cosmic bodies with a central body.
// Subsystems can be in orbit.
//
// TODO: Implementation the tree structure of the hierarchical system.
//  Do NOT use the Java-Collection framework in your implementation (arrays are allowed).
//
public class HierarchicalSystem
{
    //TODO: Define variables and constructors, if needed.

    // Initializes this system with its central body and optionally additional bodies in orbit.
    // All bodies in the orbit have lower mass than 'centralBody'.
    // Subsystems specified in 'inOrbit' having bodies with more mass than 'centralBody' are
    // omitted and not added to 'this'.
    // If inOrbit.length == 0, 'this' represents a single body (= leaf node of a hierarchical
    // system).
    // Precondition: centralBody != null (needs not be checked).
    public HierarchicalSystem(NamedBody centralBody, HierarchicalSystem... inOrbit) {
        // TODO: implement constructor.
    }

    // Returns a readable representation of 'this' with the name of each body reflecting the
    // structure of the hierarchy. The central body is listed first, all representations of objects
    // in orbit are in brackets separated by commas.
    // See examples in 'PraxisTest1.java'.
    public String toString() {
        //TODO: implement method.
        return "";
    }

    // Returns the name of the central body of 'this'.
    public String getName() {
        //TODO: implement method.
        return "";
    }

    // Returns the overall number of bodies in 'this', including the central body and
    // all bodies in subsystems.
    public int size() {
        //TODO: implement method.
        return 0;
    }

    // Returns the body of 'this' with the lowest mass (where the search-space includes
    // all subsystems).
    public NamedBody leastMassive() {
        //TODO: implement method.
        return null;
    }

    // Returns a new hierarchical system with the same central body as 'this' and
    // in which all other bodies of all subsystems of 'this' are directly in the orbit
    // around this central body, i.e. there are only two levels in the resulting system.
    // Does not modify any already existing hierarchical system.
    // See examples in 'PraxisTest1.java'.
    public HierarchicalSystem flatten() {
        //TODO: implement method.
        return null;
    }
}

