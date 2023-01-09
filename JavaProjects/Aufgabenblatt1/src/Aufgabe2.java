import java.util.Scanner;

/*
    Aufgabe 2) while-Schleifen
*/
public class Aufgabe2 {

    static String text = "Wir beginnen am Anfang mit den Grundlagen.";
    //static String text = "Kein gesuchtes Zeichen im String!";

    public static void main(String[] args) {
        everySecondCharIsNotA();
        placeOfFirstS();
        numbersInRangeX();
        reverseString();
        countOfCertainChars();
    }

    static void everySecondCharIsNotA() {
        int i = 0;

        System.out.print("Ergebnis: ");
        while (i != text.length()) {
            if (text.charAt(i) != 'a' && i % 2 == 1) {
                System.out.print(text.charAt(i));
            }
            i++;
        }
        System.out.println();
    }
    static void placeOfFirstS() {
        int i = 0;
        boolean hasLetterS = false;

        System.out.print("Ergebnis: ");
        while (i != text.length()) {
            if (text.charAt(i) == 's') {
                hasLetterS = true;
                System.out.println(i);
                break;
            }
            i++;
        }
        if (!hasLetterS) System.out.println("-1");
    }

    static void numbersInRangeX() {
        int i = 18;

        System.out.print("Ergebnis: ");
        while (i < 237) {
            if (i % 17 == 0 && i % 2 == 0) {
                System.out.print(i + " ");
            }
            i++;
        }
        System.out.println();
    }

    static void reverseString() {
        int i = text.length() - 1;
        System.out.print("Ergebnis: ");
        while (i >= 0) {
            System.out.print(text.charAt(i));
            i--;
        }
        System.out.println();
    }

    static void countOfCertainChars() {
        int i = 0;
        int counter = 0;
        while (i != text.length()) {
            if (text.charAt(i) == ' ' || text.charAt(i) == '!' || text.charAt(i) == '.') {
                counter++;
            }
            i++;
        }
        System.out.print("Ergebnis: " + counter);
    }
}








