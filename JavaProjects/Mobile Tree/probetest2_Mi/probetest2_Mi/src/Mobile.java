// A mobile is a hanging room decoration consisting of sticks with a specified stick weight on which
// further mobiles are attached (recursive structure). The actual decorations (e.g. stars with
// a specified weight) are the leaf nodes.
//
//                     |
//              +------5---+----+
//              |          |    |
//        +-----2--+--+    *    *
//        |        |  |    12   5
//        |        |  *
//        *        |  2
//        7        |
//              +--1--+
//              |     |
//              *     *
//              3     3
//
// Readable representation as string: 5[2[*7, 1[*3, *3], *2], *12, *5]
// Please, do not change this interface definition!
//
public interface Mobile extends StarIterable {

    // Returns the total weight of this mobile (including all sticks and stars).
    int getWeight();

    // Returns a readable representation of the mobile, showing its complete
    // structure with all weights using an expression with brackets.
    // Example (compare with the graphical representation above):
    // 5[2[*7, 1[*3, *3], *2], *12, *5]
    String toString();

    // Returns 'true' if 'this' and 'o' are equal.
    boolean equals(Object o);

    // Returns the hash code of 'this'.
    int hashCode();

    // Returns a 'Countable' view of 'this'. The returned object counts the
    // number of sticks in this mobile.
    // Later changes in 'this' will be reflected in the returned view.
    Countable getStickCountable();

    // Returns an iterator over all 'Star' objects in 'this' mobile. The order of iteration
    // is not specified.
    StarIterator iterator();
}
