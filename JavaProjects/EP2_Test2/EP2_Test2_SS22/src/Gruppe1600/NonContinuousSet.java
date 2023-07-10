package Gruppe1600;

import java.util.*;

// This class represents a set that is composed of multiple disjoint intervals.
// (This means these subsets have no intersection.)
// 'NonContinuousSet' is subtype of 'NumberSet' and 'DoubleIterable'.
//
// TODO: Implementation of this class.
//  You can use the Java-Collection framework in your implementation.
//
public class NonContinuousSet implements NumberSet, DoubleIterable {

    private SortedSet<Interval> set = new TreeSet<>();

    // Initializes 'this' with its continuous subsets (intervals).
    // Precondition: the intervals specified by 'sets' do not intersect,
    // sets != null && sets.length > 1
    public NonContinuousSet(Interval... sets) {
        set.addAll(Arrays.asList(sets));
    }

    // Returns the hull of this set as an 'Gruppe1600.ContinuousSet' view. The hull is the enclosing
    // continuous set with 'this.min()' as lower bound and 'this.max()' as upper bound.
    // Later changes in 'this' will be reflected in the returned view.
    public ContinuousSet getHull() {
        NonContinuousSet temp = this;

        return new ContinuousSet() {

            @Override
            public double max() {
                return temp.max();
            }

            @Override
            public double min() {
                return temp.min();
            }

            public String toString() {
                return "[" + min() + "," + max() + "]";
            }

        };
    }

    // Adds 'interval' to this set.
    // Precondition: interval != null and 'interval' has no intersection with 'this'.
    public void add(Interval interval) {
        set.add(interval);
    }


    // Returns an iterator over all lower and upper bounds of the subsets of 'this' an ascending
    // order. For example if the set has three subsets as in [[-1.2, 5.0], [7.33, 12.5], [21.1,
    // 28.7]] then the iteration is over the elements -1.2, 5.0, 7.33, 12.5, 21.1, 28.7.
    public DoubleIterator iterator() {
        Iterator<Interval> iter = set.iterator();

        return new DoubleIterator() {
            private boolean first = true;
            private Interval interval;

            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            public Double next() {
                double tbr = 0.0;
                if (!hasNext()) throw new NoSuchElementException("no next value");
                if (first && interval == null) {
                    interval = iter.next();
                    tbr = interval.min();
                } else {
                    tbr = interval.max();
                    interval = null;
                }
                first = !first;
                return tbr;
            }
        };
    }

    @Override
    public double min() {
        return set.first().min();
    }

    @Override
    public double max() {
        return set.last().max();
    }

    @Override
    // Returns a representation of 'this' with all the bounds of the interval(s) of 'this'
    // sorted ascending. The exact format is shown on the following example representing a set
    // with three intervals:
    // [[-1.2, 5.0], [7.33, 12.5], [21.1, 28.7]]
    public String toString() {
        if (set.isEmpty()) return "[]";
        StringBuilder s = new StringBuilder("[");
        for (Interval d: set) {
            s.append(d.toString()).append(", ");
        }
        s.append("]");


        return s.substring(0, s.length() - 3) + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NonContinuousSet interval = (NonContinuousSet) obj;
        return this.set.equals(((NonContinuousSet) obj).set);
    }

}

//TODO: Define additional class(es) if needed (either here or in a separate file).