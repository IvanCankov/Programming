public class Rational {

    private int numerator;
    private int denominator;

    public Rational(int nominator, int denominator) {

        this.numerator = nominator;
        this.denominator = denominator;
    }

    public double value() {

        return (double) this.numerator / this.denominator;
    }

    public int compareTo(Rational other) {

        double thisValue = value();
        double otherValue = other.value();

        if (thisValue < otherValue) return 1;
        else if (thisValue == otherValue) return 0;
        else return -1;
    }

    @Override
    public String toString() {

        return (value() < 0) ? "-" + this.denominator + "/" + this.numerator:
                                "" + this.denominator + "/" + this.numerator;
    }
}
