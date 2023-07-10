package Gruppe1000;// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest2 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle Gruppe1130.Gruppe1300.Gruppe1600.MCTest2 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "public int median(int[] a) { return a[a.length / 2]; } \n" +
                        "Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
                        "dieser Methode sinnvoll sein?",

                        new Choice(false, "Vorbedingung: a ist aufsteigend sortiert.                                          (1A)"),
                        new Choice(false, "Nachbedingung: Halbiert die Länge von a.                                           (1B)"),
                        new Choice(false, "Nachbedingung: a != null                                                           (1C)"),
                        new Choice(false, "Nachbedingung: Wirft eine Exception wenn a.length == 0.                            (1D)"),
                        new Choice(false, "Nachbedingung: Gibt den Median zurück wenn a sortiert ist.                         (1E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen in Bezug auf Algorithmen und Datenstrukturen zu?",

                        new Choice(false, "Mergesort wird auf Arrays häufiger eingesetzt als Quicksort.                       (2A)"),
                        new Choice(false, "Bei unbekannter Datenverteilung gehen wir von Zufallsverteilung aus.               (2B)"),
                        new Choice(false, "Bäume verwenden wir meist nur wo andere Datenstrukturen nicht passen.              (2C)"),
                        new Choice(false, "Ein AVL-Baum ist nicht immer effizienter als ein einfacher Suchbaum.               (2D)"),
                        new Choice(false, "Arrays sind sehr effizient wenn normale Arrayzugriffe ausreichen.                  (2E)")
                ),

                new Question(
                        "Welche der folgenden Hoare-Tripel gelten (für Anweisungen in Java)?",

                        new Choice(false, "{true} j = a<b ? a : b; {j>=b}                                                     (3A)"),
                        new Choice(false, "{j>-55} if (j<-56) j--; {j>-55}                                                    (3B)"),
                        new Choice(false, "{j==-55} j++; {j==-56}                                                             (3C)"),
                        new Choice(false, "{true} j++; {j>=0}                                                                 (3D)"),
                        new Choice(false, "{a>=-62} while (j>-62) j--; {a>=-62}                                               (3E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf Ausnahmen und Ausnahmebehandlungen in Java zu?",

                        new Choice(false, "Ausnahmen vom Typ RuntimeException sind überprüft (checked).                       (4A)"),
                        new Choice(false, "finally-Blöcke werden nur ausgeführt, wenn kein catch-Block passt.                 (4B)"),
                        new Choice(false, "Objekte aller Referenztypen sind als Exceptions verwendbar.                        (4C)"),
                        new Choice(false, "Das Ergebnis von getMessage() soll die Fehlerart konkretisieren.                   (4D)"),
                        new Choice(false, "Nicht abgefangene Ausnahmen beenden das Programm mit einem Stack-Trace.            (4E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf gut gewählte Kommentare in Programmen zu?",

                        new Choice(false, "Nachbedingungen stehen hauptsächlich vor Methodenköpfen.                           (5A)"),
                        new Choice(false, "Die meisten Kommentare stehen im Rumpf von Methoden und Konstruktoren.             (5B)"),
                        new Choice(false, "Kommentare sollen vor allem die Innensicht darstellen.                             (5C)"),
                        new Choice(false, "Invarianten stehen hauptsächlich vor Methodenköpfen.                               (5D)"),
                        new Choice(false, "Besonders gute Programmstellen brauchen nicht viele Kommentare.                    (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. public int median(int[] a) { return a[a.length / 2]; } \n" +
            "    Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
            "    dieser Methode sinnvoll sein?\n" +
            "    \n" +
            "    XXXXXXXXX Vorbedingung: a ist aufsteigend sortiert.                                          (1A)\n" +
            "    XXXXXXXXX Nachbedingung: Halbiert die Länge von a.                                           (1B)\n" +
            "    XXXXXXXXX Nachbedingung: a != null                                                           (1C)\n" +
            "    XXXXXXXXX Nachbedingung: Wirft eine Exception wenn a.length == 0.                            (1D)\n" +
            "    XXXXXXXXX Nachbedingung: Gibt den Median zurück wenn a sortiert ist.                         (1E)\n" +
            "\n" +
            " 2. Welche der folgenden Aussagen treffen in Bezug auf Algorithmen und Datenstrukturen zu?\n" +
            "    \n" +
            "    XXXXXXXXX Mergesort wird auf Arrays häufiger eingesetzt als Quicksort.                       (2A)\n" +
            "    XXXXXXXXX Bei unbekannter Datenverteilung gehen wir von Zufallsverteilung aus.               (2B)\n" +
            "    XXXXXXXXX Bäume verwenden wir meist nur wo andere Datenstrukturen nicht passen.              (2C)\n" +
            "    XXXXXXXXX Ein AVL-Baum ist nicht immer effizienter als ein einfacher Suchbaum.               (2D)\n" +
            "    XXXXXXXXX Arrays sind sehr effizient wenn normale Arrayzugriffe ausreichen.                  (2E)\n" +
            "\n" +
            " 3. Welche der folgenden Hoare-Tripel gelten (für Anweisungen in Java)?\n" +
            "    \n" +
            "    XXXXXXXXX {true} j = a<b ? a : b; {j>=b}                                                     (3A)\n" +
            "    XXXXXXXXX {j>-55} if (j<-56) j--; {j>-55}                                                    (3B)\n" +
            "    XXXXXXXXX {j==-55} j++; {j==-56}                                                             (3C)\n" +
            "    XXXXXXXXX {true} j++; {j>=0}                                                                 (3D)\n" +
            "    XXXXXXXXX {a>=-62} while (j>-62) j--; {a>=-62}                                               (3E)\n" +
            "\n" +
            " 4. Welche der folgenden Aussagen treffen auf Ausnahmen und Ausnahmebehandlungen in Java zu?\n" +
            "    \n" +
            "    XXXXXXXXX Ausnahmen vom Typ RuntimeException sind überprüft (checked).                       (4A)\n" +
            "    XXXXXXXXX finally-Blöcke werden nur ausgeführt, wenn kein catch-Block passt.                 (4B)\n" +
            "    XXXXXXXXX Objekte aller Referenztypen sind als Exceptions verwendbar.                        (4C)\n" +
            "    XXXXXXXXX Das Ergebnis von getMessage() soll die Fehlerart konkretisieren.                   (4D)\n" +
            "    XXXXXXXXX Nicht abgefangene Ausnahmen beenden das Programm mit einem Stack-Trace.            (4E)\n" +
            "\n" +
            " 5. Welche der folgenden Aussagen treffen auf gut gewählte Kommentare in Programmen zu?\n" +
            "    \n" +
            "    XXXXXXXXX Nachbedingungen stehen hauptsächlich vor Methodenköpfen.                           (5A)\n" +
            "    XXXXXXXXX Die meisten Kommentare stehen im Rumpf von Methoden und Konstruktoren.             (5B)\n" +
            "    XXXXXXXXX Kommentare sollen vor allem die Innensicht darstellen.                             (5C)\n" +
            "    XXXXXXXXX Invarianten stehen hauptsächlich vor Methodenköpfen.                               (5D)\n" +
            "    XXXXXXXXX Besonders gute Programmstellen brauchen nicht viele Kommentare.                    (5E)\n" +
            "\n";

    public static final long UID = 245148107837955L;

    private static void checkAndPrint(Question... questions) {
        int i = 1;
        String s = "";
        for (Question question : questions) {
            java.util.Scanner scanner = new java.util.Scanner(question.toString());
            s += String.format("%2d. %s\n", i++, scanner.nextLine());
            while (scanner.hasNextLine()) {
                s += String.format("    %s\n", scanner.nextLine());
            }
            s += "\n";
        }
        String converted = s.replace("Richtig: ", "XXXXXXXXX").replace("Falsch:  ", "XXXXXXXXX");
        if (!converted.replaceAll("[ \t]+", " ").equals(EXPECT.replaceAll("[ \t]+", " "))) {
            i = 0;
            String err = "\n";
            java.util.Scanner e = new java.util.Scanner(EXPECT);
            java.util.Scanner f = new java.util.Scanner(converted);
            while (e.hasNextLine() && f.hasNextLine() && i < 5) {
                String el = e.nextLine(), fl = f.nextLine();
                if (!el.replaceAll("[ \t]+", " ").equals(fl.replaceAll("[ \t]+", " "))) {
                    i++;
                    err += "Statt der Zeile: " + fl + "\nsollte stehen:   " + el + "\n\n";
                }
            }
            if (i >= 5) {
                err = "Das sind die erwarteten Fragen und Antwortmöglichkeiten in 'EXPECT':\n\n" + EXPECT;
            }
            System.out.println("ACHTUNG: Sie haben Programmteile verändert, die nicht geändert werden sollten.\n" +
                    "Beurteilt wird so, als ob diese Programmteile unverändert geblieben wären.\n" +
                    err);
            System.exit(1);
        }
        System.out.print("Die Multiple-Choice-Fragen wurden folgendermaßen beantwortet\n" +
                "(das sind nur Ihre Antworten, keine Aussage über Korrektheit):\n\n" +
                s);
        System.exit(0);
    }

    private static class Question {
        private final String question;
        private final Choice[] choices;

        public Question(String question, Choice... choices) {
            this.question = question;
            this.choices = choices;
        }

        public String toString() {
            String s = question + "\n\n";
            for (Choice choice : choices) {
                s += choice + "\n";
            }
            return s;
        }
    }

    private static class Choice {
        private final String answer;
        private final boolean valid;

        public Choice(boolean valid, String answer) {
            this.answer = answer;
            this.valid = valid;
        }

        public String toString() {
            return (valid ? "Richtig:  " : "Falsch:   ") + answer;
        }
    }
}