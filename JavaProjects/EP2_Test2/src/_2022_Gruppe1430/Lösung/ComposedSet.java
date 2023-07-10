package _2022_Gruppe1430.Lösung;
import java.util.*;

// This class represents a set that is composed of two disjoint sets 'a' and 'b' that can not be
// represented as a single interval. (This means 'a' and 'b' have no intersection.)
// 'ComposedSet' is subtype of 'NumberSet'.
// Since 'a' and 'b' are themselves of type 'NumberSet', this class represents a recursive structure.
//
// TODO: Implementation of this class.
//
public class ComposedSet implements NumberSet
{

    // TODO: Define missing parts of the class.
    //  Further methods can be added if necessary

    private NumberSet a,b;


    // Initializes 'this' as a union of 'a' and 'b'.
    // Precondition: a != null && b != null && a.compare(b) < 0.
    public ComposedSet(NumberSet a, NumberSet b) {
        
        // TODO: implement constructor.
        this.a=a;
        this.b=b;
    }

    // Adds 'interval' to this set. For simplicity it is assumed that 'interval'
    // does not intersect with 'this' and that it is either entirely greater than or less
    // the elements of 'this'.
    // Precondition: interval != null, 'interval' has no intersection with 'this' and
    // interval.compare(a) < 0 || interval.compare(b) > 0
    public void add(Interval interval) {

        // TODO: implement method.
        if (interval.max() <=  a.min())
            a = new ComposedSet(interval, a);
        if (interval.min() >= b.max())
            b = new ComposedSet(b, interval);
    }

    @Override
    public IntegerSequence getIntegers() {
        return new IntegerSequence() {
            @Override
            public int length() {
                return a.getIntegers().length() + b.getIntegers().length();
            }

            @Override
            public IntegerIterator iterator() {
                IntegerIterator aIter = a.getIntegers().iterator();
                IntegerIterator bIter = b.getIntegers().iterator();
                return new IntegerIterator() {
                    @Override
                    public boolean hasNext() {
                        return aIter.hasNext() || bIter.hasNext();
                    }

                    @Override
                    public Integer next() {
                        if(!hasNext()) throw new NoSuchElementException("no next integer!");
                        if(aIter.hasNext()) return aIter.next();
                        else return bIter.next();
                    }
                };
            }
        };
    }

    @Override
    public double max() {
        return b.max();
    }

    @Override
    public double min() {
        return a.min();
    }

    @Override
    public Interval[] asArray() {
        Interval[] arrayA = a.asArray();
        Interval[] arrayB = b.asArray();
        Interval[] newArray = new Interval[arrayA.length+arrayB.length];
        int index = 0;
        for (int i = 0; i < arrayA.length; i++) {
            newArray[index++]=arrayA[i];
        }
        for (int i = 0; i < arrayB.length; i++) {
            newArray[index++]=arrayB[i];
        }
        return newArray;
    }

    @Override
    public String toString() {
        return a.toString() + " and then "+ b.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComposedSet that = (ComposedSet) o;

        Set<Interval> h1 = new HashSet<>();
        Set<Interval> h2 = new HashSet<>();
        Interval[] array1 = this.asArray();
        Interval[] array2 = that.asArray();
        for (int i = 0; i < array1.length; i++) {
            h1.add(array1[i]);
        }
        for (int i = 0; i < array2.length; i++) {
         h2.add(array2[i]);
        }

        return h1.equals(h2);
    }

    @Override
    public int hashCode() {
        return a.hashCode() + b.hashCode();
    }
}
