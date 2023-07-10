package _2019_interval.Lösung;

import java.util.*;

// This class implements 'Set' and represents an interval of Integer numbers, specified by the lower and
// upper number of the interval.
public class Interval implements Set {
    // Initializes this 'Interval' with the bounds of the interval.
    private int lower, upper;
    public Interval(int lower, int upper) {
        this.lower=lower;
        this.upper=upper;
    }

    @Override
    public boolean isContinuous() {
        return true;
    }

    // Returns the union of 'this' and 'other'. If the result can be represented by a single
    // interval (i.e., 'this' and 'other' are connected), the result
    // is of type 'Interval', otherwise it is a 'Union'.
    // Examples:
    // The union of 0-5 and 3-8 is 0-8  (type 'Interval'),
    // the union of 0-5 and 6-7 is 0-7  (type 'Interval'),
    // the union of 0-5 and 7-8 is [0-5, 7-8] (type 'Union').
    @Override
    public Set union(Interval other) {
        if (!checkIntersecting(other)) return new Union(this,other);
        return new Interval(Math.min(this.lower, other.lower), Math.max(this.upper, other.upper));

    }
    public boolean checkIntersecting(Interval other){
        return !(this.upper < other.lower-1 || other.upper < this.lower-1);
    }

    @Override
    public Iterator<Integer> iterator() {
        List<Integer> list = new ArrayList<>();
        for (int i = lower; i <= upper ; i++) {
            list.add(i);
        }
        Iterator<Integer> iter = list.iterator();
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public Integer next() {
                if(!hasNext()) throw new NoSuchElementException();
                return iter.next();
            }
        };
    }

    @Override
    public String toString() {
        return lower +" - "+upper;
    }
}

