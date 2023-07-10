package Gruppe1600;

import java.util.Iterator;

// An iterator over double elements.
//
public interface DoubleIterator extends Iterator<Double> {

    // Returns 'true' if the iteration has more elements.
    boolean hasNext();

    // Returns the next element in the iteration.
    // Throws a 'java.util.NoSuchElementException' with the message "no next value!" if the
    // iteration has no more elements.
    Double next();

}
