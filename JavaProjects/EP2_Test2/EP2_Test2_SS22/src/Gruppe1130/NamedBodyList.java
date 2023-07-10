package Gruppe1130;
// This class represents a sorted list of 'NamedBody' objects which are sorted according to their
// position. 'NamedBodyList' uses a linked list to store its bodies. This class
// uses the 'compareTo' method of 'Vector2' to implement the sorting. ('Vector2' objects are sorted
// primarily according to their x-coordinates. In case of equal x-coordinates 'Vector2' objects are
// sorted according to their y-coordinates.)
//
// TODO: define further classes for the implementation of the linked list, if needed.
//  (The implementation can be as a double linked list or single linked list).
//
public class NamedBodyList {

    //TODO: Define variables and constructors, if needed.

    // Inserts the specified body into the list of bodies. If the list already contains a body at
    // the specified position, the result of merging the existing body with the specified body
    // replaces the old entry.
    // Precondition: b != null (needs not be checked).
    public void insert(NamedBody b) {
        //TODO: implement method.
    }

    // Returns a new list with all bodies of this list located at the
    // specified x-coordinate, i.e., all bodies with a position in the range from
    // (x, Integer.MIN_VALUE) to (x, Integer.MAX_VALUE).
    // If there are no such bodies in this list, an empty list is returned.
    // The method exploits the sorted list structure, i.e., traverses only relevant parts
    // of the list.
    public NamedBodyList getBodiesAtX(int x) {
        //TODO: implement method.
        return null;
    }

    // Returns the body with the specified position.
    // The method returns 'null' if no such body exits in the list.
    // The method exploits the sorted list structure, i.e., traverses only relevant parts
    // of the list.
    // Precondition: position != null (needs not be checked).
    public NamedBody get(Vector2 position) {
        //TODO: implement method.
        return null;
    }

    // Returns a readable representation with each of the bodies of this list in a separate line
    // ordered according to their position, or "EMPTY" if the list has no body.
    // See examples in 'PraxisTest1.java'.
    public String toString() {
        //TODO: implement method.
        return "";
    }

}

//TODO: Define additional class(es) implementing the linked list (as a double linked list
// or single linked list; either here or in a separate file).
