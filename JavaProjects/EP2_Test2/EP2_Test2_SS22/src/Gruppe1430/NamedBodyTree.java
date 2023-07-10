package Gruppe1430;
// This class represents a collection of 'NamedBody'-objects. It uses a binary search tree to
// store 'NamedBody' objects, sorted according to their distance to the origin (0.0, 0.0, 0.0)
// of the coordinate system.
//
// TODO: define further classes for the implementation of the binary search tree, if needed.
//
public class NamedBodyTree {

    //TODO: Define variables and constructors, if needed.

    // Inserts the specified body to the binary search tree of bodies and returns 'true' if it did
    // not already contain this body before. Otherwise, the body is not added and the method returns
    // 'false'.
    // Precondition: b != null (needs not be checked).
    public boolean add(NamedBody b) {
        //TODO: implement method.
        return false;
    }

    // Returns a new object of 'NamedBodyTree' with all bodies of this tree which have at least the
    // specified distance from the origin of the coordinate system (0.0, 0.0, 0.0), which is
    // assumed to be the center of the solar system.
    // If there are no such bodies in this tree, an empty tree is returned.
    // Does not modify any existing objects.
    // The method exploits the binary search tree structure, i.e., traverses only relevant parts
    // of the tree.
    public NamedBodyTree getDistantBodies(double lowestDistance) {
        //TODO: implement method.
        return null;
    }

    // Returns 'true' if the object 'b' is contained in the tree (with identity), otherwise it
    // returns 'false'. The method exploits the binary search tree structure, i.e., traverses only
    // relevant parts of the tree.
    // Precodition: b != null (needs not be checked).
    public boolean contains(NamedBody b) {
        //TODO: implement method.
        return false;
    }

    // Returns a readable representation with each of the bodies of this tree in a separate line
    // ordered according to their distance to the origin of the coordinate system (center of the
    // solar system). Returns "EMPTY" if 'this' has no bodies.
    // See examples in 'PraxisTest1.java'.
    public String toString() {
        //TODO: implement method.
        return "";
    }
}

//TODO: Define additional class(es) implementing the binary search tree
// (either here or in a separate file).
