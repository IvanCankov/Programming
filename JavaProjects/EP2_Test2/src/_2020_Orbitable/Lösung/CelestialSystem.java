package _2020_Orbitable.Lösung;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

// A celestial system implements 'Orbitable' and has at least one object in orbit around its
// central celestial body. Further objects can be added.
//
public class CelestialSystem implements Orbitable {

    //TODO: Define variables.
    //TODO: define missing parts of the class.
    private CelestialBody central;
    private List<Orbitable> children = new ArrayList<>();

    // Initialises this system with its central body.
    public CelestialSystem(CelestialBody centralBody, Orbitable inOrbit) {
        //TODO: implement constructor.
        this.central=centralBody;
        children.add(inOrbit);

    }

    public CelestialSystem(CelestialBody central, List<Orbitable> list){
        this.central=central;
        this.children=list;
    }


    @Override
    public OrbitIterator iterator() {
        Iterator<Orbitable> iter = children.iterator();
        return new OrbitIterator() {
            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public Orbitable next() {
                if(!hasNext()) throw new NoSuchElementException();
                return iter.next();
            }
        };
    }

    @Override
    public String getName() {
        return central.getName();
    }

    @Override
    public Orbitable add(Orbitable inOrbit) {
        List<Orbitable> copy = new ArrayList<>(children);
        copy.add(inOrbit);
        return new CelestialSystem(this.central, copy);
    }

    @Override
    public String toString() {
        return this.toStringhelper(1);
    }

    private String toStringhelper(int index){
        String ret = central.toString();
        for (Orbitable i:children) {
            ret+="\n";
            for (int j = 0; j < index; j++) {
                ret+="\t";
            }
            if(i instanceof CelestialBody) ret+=i.toString();
            else ret+=((CelestialSystem) i).toStringhelper(index+1);
        }
        return ret;
    }



}
