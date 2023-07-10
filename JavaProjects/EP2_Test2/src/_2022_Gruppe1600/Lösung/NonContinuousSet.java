package _2022_Gruppe1600.Lösung;

import java.util.*;

// This class represents a set that is composed of multiple disjoint intervals.
// (This means these subsets have no intersection.)
// 'NonContinuousSet' is subtype of 'NumberSet' and 'DoubleIterable'.
//
// TODO: Implementation of this class.
//  You can use the Java-Collection framework in your implementation.
//
public class NonContinuousSet implements NumberSet, DoubleIterable{

    // TODO: Define missing parts of the class.
    //  Further methods can be added if necessary (but no setters or
    //  getters that return or set just the value of a variable).
    private SortedSet<Interval> set =  new TreeSet<>();


    // Initializes 'this' with its continuous subsets (intervals).
    // Precondition: the intervals specified by 'sets' do not intersect,
    // sets != null && sets.length > 1
    public NonContinuousSet(Interval... sets) {
        // TODO: implement constructor.
        for (int i = 0; i < sets.length; i++) {
            set.add(sets[i]);
        }
    }

    // Returns the hull of this set as an 'Gruppe1600.ContinuousSet' view. The hull is the enclosing
    // continuous set with 'this.min()' as lower bound and 'this.max()' as upper bound.
    // Later changes in 'this' will be reflected in the returned view.
    public ContinuousSet getHull() {
        // TODO: implement method.
        NonContinuousSet sos = this;
        return new ContinuousSet() {
            @Override
            public boolean equals(Object obj) {
                return this.toString().equals(obj.toString());
            }

            @Override
            public String toString() {
                return "["+this.min()+", "+this.max()+"]";
            }

            @Override
            public double max() {
                return sos.max();
            }

            @Override
            public double min() {
                return sos.min();
            }
        };
    }

    // Adds 'interval' to this set.
    // Precondition: interval != null and 'interval' has no intersection with 'this'.
    public void add(Interval interval) {
        // TODO: implement method.
        set.add(interval);
    }


    // Returns an iterator over all lower and upper bounds of the subsets of 'this' an ascending
    // order. For example if the set has three subsets as in [[-1.2, 5.0], [7.33, 12.5], [21.1,
    // 28.7]] then the iteration is over the elements -1.2, 5.0, 7.33, 12.5, 21.1, 28.7.
    public DoubleIterator iterator() {
        // TODO: implement method.
        Iterator<Interval> iter = set.iterator();

        return new DoubleIterator() {
            private boolean done;
            private Interval interval;
            @Override
            public boolean hasNext() {
                return iter.hasNext() || done==true;
            }

            @Override
            public Double next() {
                if(!hasNext()) throw new NoSuchElementException("no next value!");
                if(done==false && interval==null) interval = iter.next();
                if(done==false){
                    done=true;
                    return interval.min();
                }else {
                    done=false;
                    double ret = interval.max();
                    interval=null;
                    return ret;
                }
            }
        };
    }

    @Override
    public double max() {
        return set.last().max();
    }

    @Override
    public double min() {
        return set.first().min();
    }

    @Override
    // Returns a representation of 'this' with all the bounds of the interval(s) of 'this'
    // sorted ascending. The exact format is shown on the following example representing a set
    // with three intervals:
    // [[-1.2, 5.0], [7.33, 12.5], [21.1, 28.7]]
    public String toString() {
        // TODO: implement method.
        if(set.isEmpty()) return "[]";
        String ret = "[";
        Iterator<Interval> iter = set.iterator();
        while (iter.hasNext()){
            ret+=iter.next().toString() +", ";
        }
        ret = ret.substring(0, ret.length()-2)+"]";
        return ret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NonContinuousSet doubles = (NonContinuousSet) o;

        return Objects.equals(set, doubles.set);
    }

    @Override
    public int hashCode() {
        return set != null ? set.hashCode() : 0;
    }
}

//TODO: Define additional class(es) if needed (either here or in a separate file).