package _2020_Orbitable.Lösung;

public interface OrbitIterable extends Iterable<Orbitable> {

    // Returns an iterator over 'Orbitable' objects.
    OrbitIterator iterator();

}
