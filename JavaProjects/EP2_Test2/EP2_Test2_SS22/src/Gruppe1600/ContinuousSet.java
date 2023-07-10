package Gruppe1600;

// A single continuous set (interval).
// Please, do not change this interface definition.
//
public interface ContinuousSet extends NumberSet {

    // Returns a representation of 'this' with lower and upper bound of 'this'.
    // The exact format is shown in the following example:
    // [-1.2, 5.0]
    String toString();

    // Returns 'true' if 'obj' is of the type 'Gruppe1600.ContinuousSet' and has the same
    // elements as 'this', i.e., if the lower bounds resp. the upper bounds of 'this' and
    // 'obj' are the same.
    boolean equals(Object obj);

    // Returns the hash code of 'this'.
    int hashCode();
}
