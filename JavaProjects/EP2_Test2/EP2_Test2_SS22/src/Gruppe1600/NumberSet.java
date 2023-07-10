package Gruppe1600;

// Represents a set of double values.
// Please, do not change this interface definition.
//
public interface NumberSet {

    // Returns the maximum element of this set.
    double max();

    // Returns the minimum element of this set.
    double min();

    // Returns -1 if all elements of 'this' are less than the smallest element of 'set' and
    // returns 1 if all elements of 'this' are greater than the largest element of 'set'.
    // Returns 0 otherwise.
    // Precondition: set != null
    default int compare(NumberSet set) {
        if (this.max() < set.min()) {
            return -1;
        }

        if (this.min() > set.max()) {
            return 1;
        }

        return 0;
    }

    // Returns a representation of 'this' with all the bounds of the interval(s) of 'this'.
    String toString();

    // Returns 'true' if 'obj' is of the same class as 'this' and has the same
    // elements as 'this'. This means that for each interval in 'this' there is an equal
    // interval in 'obj' and 'this' and 'obj' have the number of intervals.
    // Two intervals are equal if their lower bounds resp. their upper bounds are the same.
    boolean equals(Object obj);

    // Returns the hash code of 'this'.
    int hashCode();
}

