package _2019_CelestialSystem.Lösung;

import java.util.Objects;

// A single celestial body (regarded as the the most simple celestial system).
// A celestial body has a name and a mass in kg.
// This class implements CelestialSystem.
//
public class CelestialBody implements CelestialSystem
{

    //TODO: Define missing parts of this class.
    private String name;
    private double mass;

    public CelestialBody(String n, double m){
        this.name=n;
        this.mass=m;
    }

    @Override
    // Returns 'true' if and only if 'this' and 'o' have the same name.
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CelestialBody that = (CelestialBody) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public CelestialSystem merge(CelestialSystem celestialSystem) {
        return new BinaryCelestialSystem(this, celestialSystem);
    }

    @Override
    public double getMass() {
        return mass;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
