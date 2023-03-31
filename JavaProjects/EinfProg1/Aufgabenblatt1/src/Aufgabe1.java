/*
    Aufgabe 1) for-Schleifen
*/
public class Aufgabe1 {

    public static void main(String[] args) {

      isDivisibleby17();
      printDivisibleBy6();
      divisibleBy9And13();
      printASCII();
      countOfE();
      countOfEAlternative();
    }

    static void isDivisibleby17() {
        int result = 0;

        for (int i = 0; i <= 170; i += 17) {
            result += i;
        }
        System.out.println("Ergebnis: " + result);
    }

    static void printDivisibleBy6() {
        System.out.print("Ergebnis: ");
        for (int i = 60; i <= 82; i += 6) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void divisibleBy9And13() {
        System.out.print("Ergebnis: ");
        for (int i = 118; i < 585; i++) {
            if (i % 9 == 0 && i % 13 == 0) System.out.print("+" + i);
        }
        System.out.println("+");
    }

    static void printASCII() {
        char startChar = 'A';

        System.out.print("Ergebnis: ");
        for (int i = 0; i < 20; i++) {
            System.out.print(startChar + " ");
            startChar -= 1;
        }
        System.out.println();
    }

    static void countOfE() {
        String sentence = "Es ist kein echtes Edelmetall!";
        int counter = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == 'e' || sentence.charAt(i) == 'E') counter++;
        }
        System.out.println("Ergebnis: " + counter);
    }

    static void countOfEAlternative() {
        String sentence = "Es ist kein echtes Edelmetall!";
        sentence = sentence.toLowerCase();
        int counter = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == 'e') counter++;
        }
        System.out.println("Ergebnis: " + counter);
    }
}
