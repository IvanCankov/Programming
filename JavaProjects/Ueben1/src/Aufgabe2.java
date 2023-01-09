public class Aufgabe2 {
    public static void main(String[] args) {
        declarations();
    }

    public static void declarations() {
        int a = 0b1011;
        int b = -98762;
        int c = 0x42;
        int d = 0b011;
        System.out.println("0b1011: " + a + ", -98762: " + b + ", 0x42: " + c + ", 011: " + d);

        long e = 21474836471L;
        double f = 34.56;
        double g = -0.823;
        float h = 3e-2f;
        System.out.println("21474836471L: " + e + ", 34.56: " + f + ", -0.823: " + g + ", 3e-2f: " + h);

        char i = '%';
        char j = '\n';
        System.out.println("%: " + i + ", \\n: " + j);

        String k = "EP1";
        boolean l = false;
        System.out.println("EP1: " + k + ", false: " + l);
    }
}
