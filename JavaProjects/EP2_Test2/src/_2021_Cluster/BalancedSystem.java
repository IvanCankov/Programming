package _2021_Cluster;

import java.util.NoSuchElementException;

public class BalancedSystem implements Cluster {

    private Cluster left;
    private  Cluster right;

    //the constructor should throw a BalancedSystemIllegalArgumentException (to be implemented), if one of the arguments is null
    BalancedSystem(Cluster left, Cluster right) throws BalancedSystemIllegalArgumentException {
        if(left==null || right==null) throw new BalancedSystemIllegalArgumentException("null");
        this.left=left;
        this.right=right;
    }

    @Override
    //adds a Body b to the BalancedSystem. If the mass of the left cluster is less than the mass of the right cluster,
    //the body is added to the left cluster, otherwise to the right cluster.
    //Returns this after the operation
    /* Die add-Methode hat als Nachbedingung zusätzlich die Zusicherung, dass die Differenz zwischen den Massen des linken und rechten Clusters
    kleiner ist als die Masse des hinzugefügten Bodies.
    Neue Bodies sollten somit immer zu dem Cluster hinzugefügt werden, der eine geringere Masse aufweist.*/
    public Cluster add(Body b) throws BalancedSystemIllegalArgumentException {
        if(left.getMass()<right.getMass()) left = left.add(b);
        else right = right.add(b);
        if(left.getMass()-right.getMass()>=b.getMass()) throw new BalancedSystemIllegalArgumentException("not balanced");
        return this;
    }

    @Override
    //returns overall number of bodies in the cluster (and its sub-clusters)
    public int numberOfBodies() {
        return left.numberOfBodies() + right.numberOfBodies();
    }

    @Override
    //returns the summed mass of all the bodies in the cluster (ans its sub-clusters)
    public double getMass() {
        return left.getMass() + right.getMass();
    }

    @Override
    //returns an iterator over all bodies
    public BodyIterator iterator() {
        BodyIterator lIter = left.iterator();
        BodyIterator rIter = right.iterator();
        return new BodyIterator() {
            @Override
            public boolean hasNext() {
                return lIter.hasNext() || rIter.hasNext();
            }

            @Override
            public Body next() throws NoSuchElementException {
                if(!hasNext()) throw new NoSuchElementException("no more element");
                if(lIter.hasNext()) return lIter.next();
                else return rIter.next();
            }

            @Override
            public void remove() throws IllegalStateException {

            }
        };
    }

    @Override
    //returns a String indicating the masses of the left and right subsystem
    //E.g., "Left mass: 10.0, right mass: 12.0
    public String toString() {
        return "Left mass:" + left.getMass() + ", "+ "right mass:" + right.getMass();
    }
}