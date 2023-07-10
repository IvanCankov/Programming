package _2019_CelestialSystem.Angabe;
// Do not change this interface definition.
//
// Represents a celestial system.
//
public interface CelestialSystem {

    // Returns 'true' if the celestial system represented by 'this' and 'o' are equal.
    // Celestial systems are equal if they contain the same celestial bodies
    // (even if 'this' and 'o' have different structure).
    boolean equals(Object o);

    // Returns a new 'CelestialSystem' object, which contains the celestial bodies of 'this' and
    // 'celestialSystem'.
    CelestialSystem merge(CelestialSystem celestialSystem);

    // Returns the hashCode of 'this'.
    int hashCode();

    // Returns the sum of the mass of all bodies of this system.
    double getMass();

    // Returns a string representation of the 'this', listing the string representation of its
    // celestial bodies.
    // (Order is not specified.)
    String toString();

}

