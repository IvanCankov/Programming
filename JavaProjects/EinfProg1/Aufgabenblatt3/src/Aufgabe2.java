/*
    Aufgabe 2) Überladen von Methoden
*/
public class Aufgabe2 {

    private static void addSign(String text, char sign) {
        if (text == null) {
            System.out.println("Ungültige Eingabe");
            return;
        }

        String charToString = String.valueOf(sign);
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            if (i + 1 != text.length()) System.out.print(charToString.repeat(i + 1));
        }
        System.out.println();
    }

    private static void addSign(int number, char sign) {
        if (number < 0) {
            System.out.println("Ungültige Eingabe");
            return;
        }

        String charToString = String.valueOf(sign);
        String text = Integer.toString(number);
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            if (i + 1 != text.length()) System.out.print(charToString.repeat(i + 1));
        }
        System.out.println();
    }

    private static void addSign(String text, String signs) {
        if ((text == null) || (signs == null)) {
            System.out.println("Ungültige Eingabe");
            return;
        }

        for (int i = 0; i < signs.length(); i++) {
            String charAtI = String.valueOf(signs.charAt(i));
            for (int j = 0; j < text.length(); j++) {
                System.out.print(text.charAt(j));
                if (j + 1 != text.length()) {
                    System.out.print(charAtI.repeat(j + 1));
                }
            }
            System.out.println();
        }
    }

    private static void addSign(String text) {
        if (text == null) {
            System.out.println("Ungültige Eingabe");
            return;
        }

        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            if (i + 1 != text.length()) System.out.print("=".repeat(i + 1));
        }
        System.out.println();
    }


    public static void main(String[] args) {
        String text0 = "";
        String text1 = "IT";
        String text2 = "Hello!";
        String text3 = "+EP1+";
        String text4 = "INT";

        addSign(text0, '+');
        addSign(text1, '-');
        addSign(text2, '#');
        addSign(text3, '&');
        addSign(text4, '*');
        System.out.println();

        addSign(1, '$');
        addSign(42, '%');
        addSign(183, '.');
        addSign(4096, ':');
        addSign(65536, ']');
        System.out.println();

        addSign(text1, "/X/");
        addSign(text2, "(#?§");
        System.out.println();

        addSign(text0);
        addSign(text1);
        addSign(text2);
    }
}
