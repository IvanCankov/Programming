package _2022_Gruppe1430.Lösung;
import java.util.*;

// A single continuous closed interval of double values.
// 'Interval' is subtype of 'NumberSet'.
//
// TODO: Implementation of this class.
//
public class Interval implements NumberSet
{

    // TODO: Define missing parts of the class.
    //  Further methods can be added if necessary
    private double lower, upper;


    // Initializes 'this' with the lower and upper bound of the
    // closed interval ('lower' and 'upper' and all values in
    // between are elements of the interval).
    // Precondition: lower <= upper.
    public Interval(double lower, double upper) {

        // TODO: implement constructor.
        this.lower=lower;
        this.upper=upper;

    }


    @Override
    public IntegerSequence getIntegers() {
        Deque<Integer> help = new LinkedList<>();
        for (int i = (int) Math.ceil(lower); i <= (int) Math.floor(upper); i++) {
            help.add(i);
        }
        return new IntegerSequence() {
            @Override
            public int length() {
                return help.size();
            }

            @Override
            public IntegerIterator iterator() {

                return new IntegerIterator() {
                    @Override
                    public boolean hasNext() {
                        return help.size()>0;
                    }

                    @Override
                    public Integer next() {
                        if(!hasNext()) throw new NoSuchElementException("no next integer!");
                        return help.pollFirst();
                    }
                };
            }
        };
    }

    @Override
    public double max() {
        return upper;
    }

    @Override
    public double min() {
        return lower;
    }

    @Override
    public Interval[] asArray() {
        Interval[] ret = {this};
        return ret;
    }

    @Override
    // Returns a readable representation of 'this' including the lower and upper
    // bound of this interval. The format is shown by the following example:
    // from 0.9 to 4.0
    // (See further examples in 'PraxisTest2.java'.)
    public String toString() {

        return "from "+lower+" to "+upper;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return interval.lower==lower && interval.upper == upper;
    }
    @Override
    public int hashCode() {
        return Objects.hash(lower, upper);
    }
}
