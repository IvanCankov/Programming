package Gruppe1600;

// A single continuous closed interval of double values.
// 'Interval' is subtype of 'ContinuousSet'.
//
// TODO: Implementation of this class.
//
public class Interval implements Comparable, ContinuousSet {

    private double upper;
    private double lower;

    // Initializes 'this' with the lower and upper bound of the
    // closed interval ('lower' and 'upper' and all values in
    // between are elements of the interval).
    // Precondition: lower <= upper.
    public Interval(double lower, double upper) {
        this.upper = upper;
        this.lower = lower;
    }


    @Override
    public double max() {
        return this.upper;
    }

    @Override
    public double min() {
        return this.lower;
    }

    // Returns a readable representation of 'this' including the lower and upper
    // bound of this interval. The format is shown by the following example:
    // [0.9, 4.0]
    // (See further examples in 'PraxisTest2.java'.)
    @Override
    public String toString() {
        return "[" + lower + ", " + upper + "]";
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() == Interval.class) return false;
        Interval comp = (Interval) obj;
        return comp.max() == this.max() && comp.min() == this.min();
    }

    @Override
    public int compareTo(Object o) {
        if (this.min() > ((Interval) o).max()) return 1;
        if (this.max() < ((Interval) o).min()) return -1;
        return 0;
    }
}
