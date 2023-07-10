package _2022_Gruppe1600.Angabe;

// A single continuous closed interval of double values.
// 'Interval' is subtype of 'ContinuousSet'.
//
// TODO: Implementation of this class.
//
public class Interval implements ContinuousSet, Comparable{

    private double lower;
    private double upper;

    // Initializes 'this' with the lower and upper bound of the
    // closed interval ('lower' and 'upper' and all values in
    // between are elements of the interval).
    // Precondition: lower <= upper.
    public Interval(double lower, double upper) {
        this.lower = lower;
        this.upper = upper;

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
        return "[" + lower + "," + upper + "]";
    }

    @Override
    public int compareTo(Object o) {
        return Double.compare(((Interval) o).max(),((Interval) this).max());
    }
}
