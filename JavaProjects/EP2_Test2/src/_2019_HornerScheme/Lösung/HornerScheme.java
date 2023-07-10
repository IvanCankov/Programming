package _2019_HornerScheme.Lösung;

import java.util.*;

// The class implements 'Polynomial' and represents the form (a + x*p), where 'a' is an Integer
// and 'p' is another polynomial. 'p' must not be 'null' (objects of 'Constant' shall be used to represent constants).
// This class implements 'Polynomial' by using Horner's scheme.
// Example:
// a₀ + a₁*x + a₂*x² + a₃*x³ + a₄*x⁴
// The polynomial above is represented in Horner's scheme as:
// a₀ + x*(a₁ + x*(a₂ + x*(a₃ + x*a₄)))
//
public class HornerScheme implements Polynomial {

    //TODO: define missing parts of this class.

    private Integer a;
    private Polynomial p;

    // Initializes this object.
    // Precondition: 'p' must not be 'null'.
    public HornerScheme(int a, Polynomial p) {
        //TODO: implement this constructor.
        this.a=a;
        this.p=p;
    }

    // Creates a polynomial from the coefficients specified by the array coeffs = {a₀, a₁, a₂, ... a𝘥}.
    // Precondition: coeffs != null and coeffs has at least one element.
    public static Polynomial create(int[] coeffs) {
        //TODO: implement this method.
        Polynomial ret = new Constant(coeffs[coeffs.length-1]);
        for (int i = coeffs.length-2; i >=0; i--) {
           ret=new HornerScheme(coeffs[i], ret);
        }
        return ret;
    }

    @Override
    public int degree() {
        return 1 + p.degree();
    }

    @Override
    public List<Integer> coefficients() {
        List<Integer> ret = new LinkedList<>();
        for (Integer i:this) {
            ret.add(i);
        }
        return ret;
    }

    @Override
    public double eval(double x) {
        return a+(x*p.eval(x));
    }

    @Override
    public Iterator<Integer> iterator() {
        Iterator<Integer> iter = p.iterator();
        Integer sos = a;
        return new Iterator<Integer>() {
            private boolean called;
            @Override
            public boolean hasNext() {
                return !called || iter.hasNext();
            }

            @Override
            public Integer next() {
                if(!hasNext()) throw new NoSuchElementException("no coefficient!");
                if(!called){
                    called=true;
                    return sos;
                }
                return iter.next();
            }
        };
    }

    @Override
    // (3 + x*(-2 + x*(0 + x*(7 + x*5))))
    public String toString() {
        return "(" + a.toString() + " + x*" + p.toString() + ")";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HornerScheme integers = (HornerScheme) o;
        return a == integers.a && Objects.equals(p, integers.p);
    }

}



