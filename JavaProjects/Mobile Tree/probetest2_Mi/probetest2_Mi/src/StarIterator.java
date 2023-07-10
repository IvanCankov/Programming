import java.util.Iterator;

// An iterator over 'Star' objects.
// Please, do not change this interface definition!
//
public interface StarIterator extends Iterator<Star> {

    // Returns 'true' if the iteration has more elements.
    boolean hasNext();

    // Returns the next element in the iteration.
    // Throws a 'java.util.NoSuchElementException' if the iteration has no more elements. The
    // detail massage of the exception is "no star element!".
    Star next();
}
