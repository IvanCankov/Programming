package _2022_Gruppe1000.Lösung;

import java.util.*;

// A hierarchical system of named bodies consisting of cosmic systems.
// 'HierarchicalSystem' is subtype of CosmicSystem.
//
// TODO: Implementation of this class.
//  You can use the Java-Collection framework in your implementation.
//
public class HierarchicalSystem implements CosmicSystem{

    // TODO: Define missing parts of the class.
    //  Further methods can be added if necessary (but no setters or
    //  getters that return or set just the value of a variable).

    private List<CosmicSystem> hSystem = new ArrayList<>();


    // Initializes 'this' with subsystems.
    // Precondition: systems != null && systems.length > 1.
    public HierarchicalSystem(CosmicSystem... systems) {
        // TODO: implement constructor.
        for (int i = 0; i < systems.length; i++) {
            hSystem.add(systems[i]);
        }
    }

    @Override
    public BodyIterator iterator() {
        Iterator<CosmicSystem> iter = hSystem.iterator();
        return new BodyIterator() {
            private BodyIterator iterator = iter.next().iterator();
            @Override
            public NamedBody next() {
                if(!hasNext()) throw new NoSuchElementException("no next body!");
                if(iterator.hasNext())return iterator.next();
                iterator = iter.next().iterator();
                return iterator.next();
            }

            @Override
            public boolean hasNext() {
                return iter.hasNext() || iterator.hasNext();
            }
        };
    }

    @Override
    public Massive asMassive() {
        HierarchicalSystem sos =this;
        return new Massive() {
            @Override
            public double getMass() {
                double ret = 0;
                Iterator<CosmicSystem> iter = sos.hSystem.iterator();
                while (iter.hasNext()){
                    ret+=iter.next().asMassive().getMass();
                }
                return ret;
            }
        };
    }


    @Override
    // Returns 'true' if 'this' and 'obj' are equal, i.e., if 'this' and 'obj' have equal
    // subsystems with equal hierarchical structure, however regardless of the order
    // in which subsystems appear at each level of the system.
    // This means the method returns 'true' if the number of subsystems is
    // the same in 'this' and 'obj' and every subsystem of the specified system is equal to one
    // in 'this' (or equivalently, every subsystem of 'this' is equal to one in the specified
    // system). Otherwise 'false' is returned.
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HierarchicalSystem system = (HierarchicalSystem) o;

        Iterator<CosmicSystem> iterThis = hSystem.iterator();
        while (iterThis.hasNext()){
            boolean check=false;
            Iterator<CosmicSystem> iterSystem = system.hSystem.iterator();
            CosmicSystem test = iterThis.next();
            while (iterSystem.hasNext()){
                if(test.equals(iterSystem.next())) check = true;
            }
            if(!check) return false;
        }
        return true;
    }

    @Override
    public String toString(){
        String ret = "";
        for (NamedBody i :
                this) {
            ret+=i.toString()+"\n";
        }
        return ret;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (NamedBody i:this) {
            hash+=i.hashCode();
        }
        return hash;
    }
}

//TODO: Define additional class(es) if needed (either here or in a separate file).
