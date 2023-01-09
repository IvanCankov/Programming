//Variablen und Datentypen
public class Main {
    public static void main(String[] args) {
        //final macht die Variabel unveränderlich
        final int aNumber = 4754832;
        int anotherNumber = 4_754_832;
        //String ist eine Funktion
        String aWord = "Word";
        char aCharacter = '\uAAAA';
        boolean aBool = true;
        double aDouble = 0.123456789;
        System.out.println(aNumber + " " +
                anotherNumber + " " +
                aWord + " " +
                aCharacter + " " +
                aBool + " " +
                aDouble);
    }
}

/*
*long largeNumber = 100000000000000L;
*float weight = 75.5f;
 */

/*
*Vorsicht 013 sit im octal,
*0b10110 ist ein Bitmuster,
*0x7FFF ist eine Hexzahl
*/

/**
 * So macht man Dokumentation
 */