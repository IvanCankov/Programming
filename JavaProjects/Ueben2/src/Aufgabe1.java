public class Aufgabe1 {
    public static void main(String[] args) {
        char a = '2', b = '5', c = '7';
        int diffAB = -1, diffBC = -1;
        if (a < b) {
            if (b < c && a >= '0' && c <= '9') {
                diffAB = b - a;
                diffBC = c - b;
// hier gilt für a, b , c: . . .
            }
        } else {
            if (c <= b && c >= '0' && a <= '9') {
                diffAB = a - b;
                diffBC = b - c;
// hier gilt für a, b, : . . .
            }
        }
        if (diffAB < 0 || diffBC < 0) {
            System.out.println("Ungültige Werte");
        } else if (diffAB > diffBC) {
            System.out.println("Ja, " + diffAB + " größer " + diffBC);
        } else {
            System.out.println("Nein, " + diffAB + " nicht größer " + diffBC);
        }
    }
}