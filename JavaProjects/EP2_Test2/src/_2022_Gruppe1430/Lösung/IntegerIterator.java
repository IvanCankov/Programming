package _2022_Gruppe1430.Lösung;
import java.util.Iterator;

// An iterator over integer numbers.
//
public interface IntegerIterator extends Iterator<Integer> {

    // Returns 'true' if the iteration has more elements.
    boolean hasNext();

    // Returns the next element in the iteration.
    // Throws a 'java.util.NoSuchElementException' with the message "no next integer!" if the
    // iteration has no more elements.
    Integer next();

}
