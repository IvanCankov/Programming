package Gruppe1300;

// Represents an shopping list. There is no specified order.
// The availability of a large number of ingredients has to be assumed, not just those three
// currently used in this project.
public interface ShoppingMap {

    // Returns a readable representation with all distinct ingredients together with their quantity.
    // There is no specified order of the listed ingredients. Ingredients occur at most once in the
    // representation.
    // The format is shown in the following example:
    // {Gruppe1300.Egg=2, Gruppe1300.Flour=1}
    String toString();

    // Returns 'true' if 'obj' is of type 'Gruppe1300.ShoppingMap' and the number of distinct ingredients and
    // their corresponding quantity in 'this' and in 'obj' is the same. This definition ensures
    // that the equals method works properly across different implementations
    // of the 'Gruppe1300.ShoppingMap' interface.
    boolean equals(Object obj);

    // Returns the hash code of 'this'.
    int hashCode();

}
