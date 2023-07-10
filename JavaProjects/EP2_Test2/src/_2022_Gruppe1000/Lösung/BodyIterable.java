package _2022_Gruppe1000.Lösung;

// Iterable objects with 'NamedBody' elements.
//
public interface BodyIterable extends Iterable<NamedBody> {

    @Override
    // Returns an iterator over elements of 'NamedBody'.
    BodyIterator iterator();
}
