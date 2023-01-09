/*
    Aufgabe 1) Codeanalyse, Codingstyle und Methoden
*/
public class Aufgabe1 {
    //TODO zu Punkt a): Beschreiben Sie hier in wenigen Sätzen was der Spaghetticode macht
    // Der Spagetticode gibt ein DNS pattern aus
    //
    //

    //TODO zu Punkt b): Beschreiben Sie in wenigen Sätzen was Sie ändern würden und warum
    // alle for loops wo möglich mit String.repeat() ersetzen
    // damit es leserlicher ist bei Math Klammern nutzen
    // Repetition durch noch eine for loop ersetzen



    //TODO zu Punkt c): Implementieren Sie hier die Methoden Ihrer Lösung


    //In true Java Fashion hab ich (fast) alles in eine Methode ausgezogen...
    static void topPattern(int width) {
        for (int i = 1; i < (width / 2) + 1; i++) {
            System.out.print("+".repeat(i));
            System.out.print("\\");
            System.out.print("*".repeat(width - (2 * i)));
            System.out.print("/");
            System.out.print("+".repeat(i));
            System.out.println();
        }
    }

    static void bottomPatter(int width) {
        for (int i = 1; i < (width / 2) + 1; i++) {
            System.out.print("+".repeat((width / 2) - i + 1));
            System.out.print("/");
            System.out.print("*".repeat(2 * (i - 1)));
            System.out.print("\\");
            System.out.print("+".repeat((width / 2) - i + 1));
            System.out.println();
        }
    }
    static void printPattern(int width, int height) {
        if (width % 2 == 1 || width < 0) {
            System.out.println("Ungültige Eingabe");
            return;
        }
        System.out.println();
        System.out.println("Ausgabe Spaghetticode:");
        System.out.println("|" + "#".repeat(width) + "|");
        for (int j = 0; j < height; j++) {
            topPattern(width);
            bottomPatter(width);
        }
        System.out.println("|" + "#".repeat(width) + "|");
    }

    public static void main(String args[]) {
        //********************************************************
        //TODO zu Punkt d): Implementieren Sie hier Ihre Lösung für die Angabe
        System.out.println("Ihre Ausgabe:");
        printPattern(16, 10);



        //********************************************************

        /*System.out.println();
        System.out.println("Ausgabe Spaghetticode:");
        System.out.print("#");
        for (int i = 1; i <= 10; i++) {
        System.out.print("|");
        }
        System.out.println("#");
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("+");
            }            System.out.print("\\");
        for (int j = 1; j <= (10 - 2 * i); j++) {System.out.print("*");
            }
            System.out.print("/");
        for (int j = 1; j <= i; j++) {System.out.print("+");
            }
            System.out.println();
        }
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= (10/2-i+1); j++) {
                System.out.print("+");            }
        System.out.print("/");
            for (int j = 1; j <= 2*(i-1); j++) {
                System.out.print("*");
            }System.out.print("\\");
            for (int j = 1; j <= (10/2-i+1); j++) { System.out.print("+");
            }
            System.out.println();        }
        for (int i = 1; i < 6; i++) {
                for (int j = 1; j <= i; j++) {
                System.out.print("+");            }
            System.out.print("\\");
                for (int j = 1; j <= (10-2*i); j++) {System.out.print("*");     }
            System.out.print("/");
            for (int j = 1; j <= i; j++) {
                System.out.print("+");
            }
            System.out.println();
        }
        for (int i = 1; i < 6; i++) {
        for (int j = 1; j <= (10/2-i+1); j++) {
                    System.out.print("+");
            }
            System.out.print("/");
            for (int j = 1; j <= 2*(i-1); j++) {
                System.out.print("*");
            }
                System.out.print("\\");
            for (int j = 1; j <= (10/2-i+1); j++) {System.out.print("+");
            }
            System.out.println();
        }
        System.out.print("#");        for (int i = 1; i <= 10; i++) {
            System.out.print("|");
        }
        System.out.println("#");*/
    }
}


