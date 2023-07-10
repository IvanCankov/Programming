package _2019_CelestialSystem.Lösung;

import java.util.*;

// A system consisting of two subsystems.
// This class implements CelestialSystem and BodyIterable.
//
public class BinaryCelestialSystem
implements CelestialSystem, BodyIterable
{

    // TODO: define missing parts of this class.
    private CelestialSystem p1, p2;

    // Initializes this object, with two components. 'this' is a pair consisting of 'p1' and 'p2';
    // it contains all bodies of 'p1' and 'p2'.
    public BinaryCelestialSystem(CelestialSystem p1, CelestialSystem p2) {
        // TODO: implement constructor.
        this.p1=p1;
        this.p2=p2;

    }

    @Override
    public BodyIterator iterator() {
        List<CelestialBody> list = new ArrayList<>();
        getAllBodies(list);
        return new BodyIterator() {
            @Override
            public boolean hasNext() {
                return list.size()>0;
            }

            @Override
            public CelestialBody next() {
                if(!hasNext()) throw  new NoSuchElementException("efwg");
                return list.remove(0);
            }
        };
    }

    private void getAllBodies(List<CelestialBody> list){
        if(p1 instanceof CelestialBody) list.add((CelestialBody) p1);
        else ((BinaryCelestialSystem) p1).getAllBodies(list);
        if(p2 instanceof CelestialBody) list.add((CelestialBody) p2);
        else ((BinaryCelestialSystem) p2).getAllBodies(list);
    }

    @Override
    public CelestialSystem merge(CelestialSystem celestialSystem) {
        return new BinaryCelestialSystem( this, celestialSystem);
    }

    @Override
    public double getMass() {
        return p1.getMass()+ p2.getMass();
    }

    @Override
    public String toString() {
        return p1.toString()+", "+p2.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BinaryCelestialSystem that = (BinaryCelestialSystem) o;

        Set<CelestialBody> s1 = new HashSet<>();
        Set<CelestialBody> s2 = new HashSet<>();

        for (CelestialBody i: this) {
            s1.add(i);
        }
        for (CelestialBody i: that) {
            s2.add(i);
        }
        return s1.equals(s2);
    }

    @Override
    public int hashCode() {
        int result = p1 != null ? p1.hashCode() : 0;
        result = 31 * result + (p2 != null ? p2.hashCode() : 0);
        return result;
    }
}
