public class Rational {

    private final int numerator;
    private final int denominator;


    //Initialises this with the specified numerator and denominator.
    public Rational(int numerator, int denominator) {

        this.numerator = numerator;
        this.denominator = denominator;
    }

    //Returns the value of this.
    public double value() {

        return (double) this.numerator / this.denominator;
    }

    //Compares 2 Rationals if this is smaller than other it returns 1,
    //if they are equal it returns 0,
    //and if this is larger, then it returns -1.
    public int compareTo(Rational other) {

        if (this.value() < other.value()) return 1;
        else if (this.value() == other.value()) return 0;
        else return -1;
    }


    //Returns the string representation of this.
    @Override
    public String toString() {

        return (value() < 0) ? "-" + Math.abs(this.denominator) + "/" + Math.abs(this.numerator):
                                "" + Math.abs(this.denominator) + "/" + Math.abs(this.numerator);
    }
}
