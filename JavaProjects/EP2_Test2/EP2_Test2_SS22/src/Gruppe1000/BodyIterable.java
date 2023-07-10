package Gruppe1000;

// Iterable objects with 'NamedBody' elements.
//
public interface BodyIterable extends Iterable<NamedBody> {

    @Override
    // Returns an iterator over elements of 'NamedBody'.
    BodyIterator iterator();
}
