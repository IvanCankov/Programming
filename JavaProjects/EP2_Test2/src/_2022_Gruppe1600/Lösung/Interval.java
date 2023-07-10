package _2022_Gruppe1600.Lösung;

// A single continuous closed interval of double values.
// 'Interval' is subtype of 'ContinuousSet'.
//
// TODO: Implementation of this class.
//
public class Interval implements ContinuousSet, Comparable<Interval>{

    // TODO: Define missing parts of the class.
    //  Further methods can be added if necessary (but no setters or
    //  getters that return or set just the value of a variable).

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
    public double max() {
        return upper;
    }

    @Override
    public double min() {
        return lower;
    }

    // Returns a readable representation of 'this' including the lower and upper
    // bound of this interval. The format is shown by the following example:
    // [0.9, 4.0]
    // (See further examples in 'PraxisTest2.java'.)
    @Override
    public String toString() {
        // TODO: implement method.
        return "["+lower+", "+upper+"]";
    }


    @Override
    public int compareTo(Interval o) {
        if (this.max() < o.min()) {
            return -1;
        }

        if (this.min() > o.max()) {
            return 1;
        }

        return 0;
    }
}
