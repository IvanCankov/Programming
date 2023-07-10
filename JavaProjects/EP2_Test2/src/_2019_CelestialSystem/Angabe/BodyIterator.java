package _2019_CelestialSystem.Angabe;

import java.util.Iterator;

// An iterator over all 'CelestialBody' objects.
public interface BodyIterator extends Iterator<CelestialBody> {

    // Returns 'true' if the iteration has more elements.
    boolean hasNext();

    // Returns the next element in the iteration.
    // Throws a 'java.util.NoSuchElementException' if the iteration has no more elements.
    CelestialBody next();

}
