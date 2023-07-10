package Gruppe1000;

import java.util.Iterator;

// An iterator over elements of 'NamedBody'.
//
public interface BodyIterator extends Iterator<NamedBody> {

    @Override
    // Returns the next element in the iteration.
    // Throws a 'java.util.NoSuchElementException with the message "no next body!"
    // if the iteration has no more elements.
    NamedBody next();

    @Override
    // Returns 'true' if the iteration has more elements.
    boolean hasNext();
}
