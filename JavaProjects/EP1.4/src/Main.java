import java.math.BigInteger;
public class Main {
    public static void main(String[] args) {
        maxValue();
        whileLoop();
        gleitkommaRechnung();
        bigInteger();
    }

    public static void maxValue() {
        int x = Integer.MAX_VALUE; // x = 2147483647
        int y = x + 1; //y = -2147483648
        int z = (int) 2.5; //casting
        System.out.println(x + " " + y + " " + z);
    }

    public static void whileLoop() {
        int counter = 0;
        while (counter <= 10) {
            if (counter != 10) {System.out.print(counter + ", ");}
            else {System.out.println(counter);}
            counter++;
        }
    }

    public static void gleitkommaRechnung() {
        System.out.println(0.1 + 0.2);
        System.out.println(0.1 + 0.3);
        //((3 * 8) + (5 / 4)) mehr lesbar als (3 * 8 + 5 / 4)
    }

    public static void bigInteger() {
        //gibt's a BigDecimal() press F4 dumbass :D
        BigInteger big = new BigInteger("123456789123456789123456789123456789");
        BigInteger big2 = new BigInteger("123456789123456789123456789123456789");
        System.out.println(big.add(big2));
    }
}