package _2022_Gruppe1430.Angabe;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

// This class represents a set that is composed of two disjoint sets 'a' and 'b' that can not be
// represented as a single interval. (This means 'a' and 'b' have no intersection.)
// 'ComposedSet' is subtype of 'NumberSet'.
// Since 'a' and 'b' are themselves of type 'NumberSet', this class represents a recursive structure.
//
// TODO: Implementation of this class.
//
public class ComposedSet
{

    // TODO: Define missing parts of the class.
    //  Further methods can be added if necessary



    // Initializes 'this' as a union of 'a' and 'b'.
    // Precondition: a != null && b != null && a.compare(b) < 0.
    public ComposedSet(NumberSet a, NumberSet b) {
        
        // TODO: implement constructor.

    }

    // Adds 'interval' to this set. For simplicity it is assumed that 'interval'
    // does not intersect with 'this' and that it is either entirely greater than or less
    // the elements of 'this'.
    // Precondition: interval != null, 'interval' has no intersection with 'this' and
    // interval.compare(a) < 0 || interval.compare(b) > 0
    public void add(Interval interval) {

        // TODO: implement method.

    }



}
