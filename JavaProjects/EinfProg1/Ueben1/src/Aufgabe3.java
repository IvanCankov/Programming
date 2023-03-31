public class Aufgabe3 {
    public static void main(String[] args) {
        experiment();
    }

    public static void experiment() {
        double exp = 102 * 20 / 100.0;
        double exp2 = (double) 102 * 20 / 100; //do not use this!!
        System.out.println(exp + " " + exp2);
    }

    public static void theExercise() {
        int drinks = 102;
        int food = 204;
        double withTaxes = drinks * 1.1 + food + food * 20 / 100.0;

        System.out.println("*** Ristorante EP1 ***");
        System.out.println("* Netto: " + (drinks + food));
        System.out.println("Brutto: " + withTaxes);
        System.out.println("lazy to type it out");
    }
}
