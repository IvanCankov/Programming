public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Rational r1 = new Rational(3, 2);
        Rational r2 = new Rational(6, 4);
        Rational r3 = new Rational(1, 10);
        Rational r4 = new Rational(2, 20);
        Rational r5 = new Rational(1, 1);


        RationalCollection rc = new RationalCollection();
        rc.add(new Node(r1));
        rc.add(new Node(r2));
        rc.add(new Node(r3));
        rc.add(new Node(r4));
        rc.add(new Node(r5));

        System.out.println(rc.count(new Rational(3, 2)));
        System.out.println(rc.count(new Rational(1, 10)));
        System.out.println(rc.count(new Rational(10, 10)));
        System.out.println(rc.count(new Rational(7, 56)));
        System.out.println(rc);
    }
}