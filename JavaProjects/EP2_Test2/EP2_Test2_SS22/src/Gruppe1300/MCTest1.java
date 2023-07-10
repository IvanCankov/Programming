package Gruppe1300;
// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest1 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest1 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "u sei eine Variable mit einem einfachen binären Suchbaum (nicht AVL-Baum)\n" +
                        "ganzer Zahlen, der durch diese Anweisungen aufgebaut wurde:\n" +
                        "    STree u = new STree(); u.add(4); u.add(7); u.add(6);\n" +
                        "Welche der folgenden Aussagen treffen auf u zu?",

                        new Choice(false, "Der Knoten mit Wert 6 ist Elter von dem mit Wert 4.                           (1A)"),
                        new Choice(false, "Der Knoten mit Wert 4 ist Kind von dem mit Wert 7.                            (1B)"),
                        new Choice(false, "Der Baum ist nicht ausbalanciert.                                             (1C)"),
                        new Choice(false, "Der Knoten mit Wert 6 ist die Wurzel.                                         (1D)"),
                        new Choice(false, "Der Knoten mit Wert 4 ist ein Blattknoten.                                    (1E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen stimmen in Bezug auf rekursive Datenstrukturen?",

                        new Choice(false, "Schleifen erlauben kein vollständiges Traversieren.                           (2A)"),
                        new Choice(false, "Eine Datenstruktur ist rekursiv wenn ihre Methoden rekursiv sind.             (2B)"),
                        new Choice(false, "Dereferenzieren ist das Entfernen von Referenzen aus dem Programm.            (2C)"),
                        new Choice(false, "Jeder Knoten, der mehrere Knoten referenziert, ist Teil eines Baums.          (2D)"),
                        new Choice(false, "Zur Fundierung können spezielle Knoten verwendet werden.                      (2E)")
                ),

                new Question(
                        "A sei ein Referenztyp (Klasse oder Interface), und e sei eine durch\n" +
                        "'I e = new V();' deklarierte Variable, wobei der Compiler keinen Fehler meldet.\n" +
                        "Welche der folgenden Aussagen treffen für alle passenden A, I, V und e zu?",

                        new Choice(false, "'(A)e' liefert keinen Laufzeitfehler wenn V Untertyp von A ist.               (3A)"),
                        new Choice(false, "'(A)e' ändert den dynamischen Typ von e auf A.                                (3B)"),
                        new Choice(false, "V ist Untertyp von I.                                                         (3C)"),
                        new Choice(false, "Mit 'V ist Untertyp von A' gilt: '((A)e).getClass() == A.class'               (3D)"),
                        new Choice(false, "'(A)null' liefert einen Laufzeitfehler.                                       (3E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen stimmen in Bezug auf die unterschiedlichen Arten\n" +
                        "linearer und assoziativer Datenstrukturen?",

                        new Choice(false, "Wahlfreie Zugriffe auf assoziative Datenstrukturen sind meist effizient.      (4A)"),
                        new Choice(false, "Assoziative Datenstrukturen haben FIFO-Verhalten.                             (4B)"),
                        new Choice(false, "Double-Ended-Queues können auch wie Queues verwendet werden.                  (4C)"),
                        new Choice(false, "Lineare Datenstrukturen sind nicht (effizient) wahlfrei zugreifbar.           (4D)"),
                        new Choice(false, "Queues können bei Bedarf größer werden.                                       (4E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen gelten in Java für die unterschiedlichen\n" +
                        "Arten von Variablen und Parametern?",

                        new Choice(false, "Formale Parameter können Klassenvariablen verdecken.                          (5A)"),
                        new Choice(false, "Lokale Variablen werden automatisch vorinitialisiert.                         (5B)"),
                        new Choice(false, "Klassenvariablen werden bei der Objekterzeugung angelegt.                     (5C)"),
                        new Choice(false, "Parameter und lokale Variablen dürfen nicht gleich heißen.                    (5D)"),
                        new Choice(false, "Klassenvariablen werden ohne 'static' deklariert.                             (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. u sei eine Variable mit einem einfachen binären Suchbaum (nicht AVL-Baum)\n" +
            "    ganzer Zahlen, der durch diese Anweisungen aufgebaut wurde:\n" +
            "        STree u = new STree(); u.add(4); u.add(7); u.add(6);\n" +
            "    Welche der folgenden Aussagen treffen auf u zu?\n" +
            "    \n" +
            "    XXXXXXXXX Der Knoten mit Wert 6 ist Elter von dem mit Wert 4.                           (1A)\n" +
            "    XXXXXXXXX Der Knoten mit Wert 4 ist Kind von dem mit Wert 7.                            (1B)\n" +
            "    XXXXXXXXX Der Baum ist nicht ausbalanciert.                                             (1C)\n" +
            "    XXXXXXXXX Der Knoten mit Wert 6 ist die Wurzel.                                         (1D)\n" +
            "    XXXXXXXXX Der Knoten mit Wert 4 ist ein Blattknoten.                                    (1E)\n" +
            "\n" +
            " 2. Welche der folgenden Aussagen stimmen in Bezug auf rekursive Datenstrukturen?\n" +
            "    \n" +
            "    XXXXXXXXX Schleifen erlauben kein vollständiges Traversieren.                           (2A)\n" +
            "    XXXXXXXXX Eine Datenstruktur ist rekursiv wenn ihre Methoden rekursiv sind.             (2B)\n" +
            "    XXXXXXXXX Dereferenzieren ist das Entfernen von Referenzen aus dem Programm.            (2C)\n" +
            "    XXXXXXXXX Jeder Knoten, der mehrere Knoten referenziert, ist Teil eines Baums.          (2D)\n" +
            "    XXXXXXXXX Zur Fundierung können spezielle Knoten verwendet werden.                      (2E)\n" +
            "\n" +
            " 3. A sei ein Referenztyp (Klasse oder Interface), und e sei eine durch\n" +
            "    'I e = new V();' deklarierte Variable, wobei der Compiler keinen Fehler meldet.\n" +
            "    Welche der folgenden Aussagen treffen für alle passenden A, I, V und e zu?\n" +
            "    \n" +
            "    XXXXXXXXX '(A)e' liefert keinen Laufzeitfehler wenn V Untertyp von A ist.               (3A)\n" +
            "    XXXXXXXXX '(A)e' ändert den dynamischen Typ von e auf A.                                (3B)\n" +
            "    XXXXXXXXX V ist Untertyp von I.                                                         (3C)\n" +
            "    XXXXXXXXX Mit 'V ist Untertyp von A' gilt: '((A)e).getClass() == A.class'               (3D)\n" +
            "    XXXXXXXXX '(A)null' liefert einen Laufzeitfehler.                                       (3E)\n" +
            "\n" +
            " 4. Welche der folgenden Aussagen stimmen in Bezug auf die unterschiedlichen Arten\n" +
            "    linearer und assoziativer Datenstrukturen?\n" +
            "    \n" +
            "    XXXXXXXXX Wahlfreie Zugriffe auf assoziative Datenstrukturen sind meist effizient.      (4A)\n" +
            "    XXXXXXXXX Assoziative Datenstrukturen haben FIFO-Verhalten.                             (4B)\n" +
            "    XXXXXXXXX Double-Ended-Queues können auch wie Queues verwendet werden.                  (4C)\n" +
            "    XXXXXXXXX Lineare Datenstrukturen sind nicht (effizient) wahlfrei zugreifbar.           (4D)\n" +
            "    XXXXXXXXX Queues können bei Bedarf größer werden.                                       (4E)\n" +
            "\n" +
            " 5. Welche der folgenden Aussagen gelten in Java für die unterschiedlichen\n" +
            "    Arten von Variablen und Parametern?\n" +
            "    \n" +
            "    XXXXXXXXX Formale Parameter können Klassenvariablen verdecken.                          (5A)\n" +
            "    XXXXXXXXX Lokale Variablen werden automatisch vorinitialisiert.                         (5B)\n" +
            "    XXXXXXXXX Klassenvariablen werden bei der Objekterzeugung angelegt.                     (5C)\n" +
            "    XXXXXXXXX Parameter und lokale Variablen dürfen nicht gleich heißen.                    (5D)\n" +
            "    XXXXXXXXX Klassenvariablen werden ohne 'static' deklariert.                             (5E)\n" +
            "\n";

    public static final long UID = 245053064323929L;

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