package _2022_Gruppe1430.Lösung;
// Represents a set of double values. A set is composed of an arbitrary number of intervals
// representing continuous ranges of double values, i.e. a union of intervals of double values.
// Please, do not change this interface definition!
//
public interface NumberSet {

    // Returns an 'IntegerSequence' view of integer elements of 'this'.
    // Later changes in 'this' will be reflected in the returned view.
    IntegerSequence getIntegers();

    // Returns the maximum element of this set.
    double max();

    // Returns the minimum element of this set.
    double min();

    // Returns all intervals of this set in an array. The array is sorted as follows:
    // If 's' is of class 'Set' and Interval[] arr = s.asArray() then for all valid i and j
    // the following condition holds: arr[i].compare(arr[j]) < 0 if i < j.
    Interval[] asArray();

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

    // Returns a representation of 'this' listing the intervals of this set in ascending order.
    // The exact format is shown on the following example representing a set with three intervals:
    // from -1.2 to 5.0 and then from 7.33 to 12.5 and then from 20.0 to 20.0
    String toString();

    // Returns 'true' if 'obj' is of the same class as 'this' and has the same
    // elements as 'this'. This means that for each interval in 'this' there is an equal
    // interval in 'obj' and 'this' and 'obj' have the number of intervals.
    // Two intervals are equal if their lower bounds resp. their upper bounds are the same.
    boolean equals(Object obj);

    // Returns the hash code of 'this'.
    int hashCode();
}

