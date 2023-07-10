package Gruppe1000;

// Represents a system of named bodies. Please, do not change this
// interface definition!
//
public interface CosmicSystem extends BodyIterable {

    @Override
    // Returns an iterator over all bodies of this system.
    BodyIterator iterator();

    // Returns a readable representation of 'this' with the name of each body and its mass.
    // Bodies are shown in separate consecutive lines.
    // The format of each line is shown by the following example
    // (see also examples in 'Gruppe1130.Gruppe1300.Gruppe1600.PraxisTest2.java'):
    // Venus: 4.86747E24 kg.
    @Override
    String toString();

    // Returns a 'Massive' view of 'this'. Later changes in 'this' will be reflected in the
    // returned view.
    Massive asMassive();

    @Override
    // Returns 'true' if 'this' and 'obj' are equal.
    boolean equals(Object obj);

    @Override
    // Returns the hash code of 'this'.
    int hashCode();
}
