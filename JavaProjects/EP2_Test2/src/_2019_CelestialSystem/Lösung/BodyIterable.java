package _2019_CelestialSystem.Lösung;
public interface BodyIterable extends Iterable<CelestialBody> {

    // Returns an iterator over all celestial bodies of the system.
    // The 'next' method throws a 'java.util.NoSuchElementException' if the iteration
    // has no more elements.
    BodyIterator iterator();

}
