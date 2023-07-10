package _2022_Gruppe1000.Lösung;

import java.util.*;

// An unstructured, unordered system of cosmic bodies.
// 'SimpleSystem' is subtype of 'CosmicSystem'.
//
// TODO: Implementation of this class.
//  You can use the Java-Collection framework in your implementation.
//
public class SimpleSystem implements CosmicSystem {

    // TODO: Define missing parts of the class.
    //  Further methods can be added if necessary (but no setters or
    //  getters that return or set just the value of a variable).
    private Set<NamedBody> set = new HashSet<>();


    // Initializes this system with its bodies.
    // Precondition: bodies != null && bodies.length > 0.
    public SimpleSystem(NamedBody... bodies) {
        // TODO: implement constructor.
        for (int i = 0; i < bodies.length; i++) {
            set.add(bodies[i]);
        }
    }

    // Adds a body to 'this'.
    // Precondition: toAdd != null.
    public void add(NamedBody toAdd) {
        // TODO: implement method.
        set.add(toAdd);
    }

    @Override
    public String toString() {
        String ret = "";
        for (NamedBody i:this) {
            ret+=i.toString()+"\n";
        }
        return ret;
    }

    @Override
    public Massive asMassive() {
        SimpleSystem sos = this;
        return new Massive() {
            @Override
            public double getMass() {
                double ret = 0;
                for (NamedBody i:sos) {
                    ret+=i.getMass();
                }
                return ret;
            }
        };
    }

    public BodyIterator iterator() {
        Iterator<NamedBody> iterator = set.iterator();
        return new BodyIterator() {
            @Override
            public NamedBody next() {
                if (!hasNext()) throw new NoSuchElementException("no next body!");
                return iterator.next();
            }

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }
        };
    }


    @Override
    // Returns 'true' if 'this' and 'obj' are equal, i.e. if and only if 'this' and 'obj'
    // have the same set of bodies (regardless of the order specified in the constructor's
    // 'bodies' parameter).
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleSystem that = (SimpleSystem) o;
        for (NamedBody i:this) {
            boolean check = false;
            for (NamedBody j: that) {
                if(i.equals(j)) {
                    check = true;
                }
            }
            if(!check) return false;
        }
        return true;
    }



}
//TODO: Define additional class(es) if needed (either here or in a separate file).