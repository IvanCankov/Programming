package _2019_interval.Angabe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

// This class implements 'Set' and represents an interval of Integer numbers, specified by the lower and
// upper number of the interval.
public class Interval implements Set {


    private int upper;
    private int lower;
    public Interval(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
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
    //@Override
    public Set union(Interval other) {

        if (this.max() > other.min() || this.min() > other.max())
            return new Interval(Math.min(this.min(), other.min()), Math.min(this.max(), other.max()));

        return new Set() {
            @Override
            public boolean isContinuous() {
                return false;
            }

            @Override
            public Set union(Interval other) {
                return null;
            }

            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<>() {
                    @Override
                    public boolean hasNext() {
                        return false;
                    }

                    @Override
                    public Integer next() {
                        return null;
                    }
                };
            }
        };

    }


    @Override
    public Iterator<Integer> iterator() {


    }

    public int max() {
        return upper;
    }

    public int min() {
        return lower;
    }

}

