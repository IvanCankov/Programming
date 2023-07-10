package Gruppe1430;
// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest1 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest1 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "Welche der folgenden Aussagen treffen auf Objektmethoden bzw. Klassenmethoden zu?",

                        new Choice(false, "In Objektmethoden bezeichnet 'this' das aktuelle Objekt.                      (1A)"),
                        new Choice(false, "Klassenmethoden haben keinen Zugriff auf Objektvariablen.                     (1B)"),
                        new Choice(false, "Jede Methode b() aus einer Klasse X ist durch 'X.b()' aufrufbar.              (1C)"),
                        new Choice(false, "Jede nicht als 'static' deklarierte Methode ist eine Objektmethode.           (1D)"),
                        new Choice(false, "Aufrufe von 'this(...)' sind nur in Klassenmethoden erlaubt.                  (1E)")
                ),

                new Question(
                        "x sei eine Variable mit einem einfachen binären Suchbaum (nicht AVL-Baum)\n" +
                        "ganzer Zahlen, der durch diese Anweisungen aufgebaut wurde:\n" +
                        "    STree x = new STree(); x.add(0); x.add(7); x.add(3);\n" +
                        "Welche der folgenden Aussagen treffen auf x zu?",

                        new Choice(false, "Der Knoten mit Wert 3 ist die Wurzel.                                         (2A)"),
                        new Choice(false, "Der Knoten mit Wert 3 ist Kind von dem mit Wert 7.                            (2B)"),
                        new Choice(false, "Der Baum ist perfekt ausbalanciert.                                           (2C)"),
                        new Choice(false, "Der Knoten mit Wert 7 ist ein Blattknoten.                                    (2D)"),
                        new Choice(false, "Der Knoten mit Wert 7 ist Elter von dem mit Wert 0.                           (2E)")
                ),

                new Question(
                        "I sei ein Referenztyp (Klasse oder Interface), und s sei eine durch\n" +
                        "'L s = new P();' deklarierte Variable, wobei der Compiler keinen Fehler meldet.\n" +
                        "Welche der folgenden Aussagen treffen für alle passenden I, L, P und s zu?",

                        new Choice(false, "'(I)s' ändert den dynamischen Typ von s auf I.                                (3A)"),
                        new Choice(false, "'(I)s' liefert keinen Laufzeitfehler wenn P Untertyp von I ist.               (3B)"),
                        new Choice(false, "L und P müssen gleich sein.                                                   (3C)"),
                        new Choice(false, "Mit 'P ist Untertyp von I' gilt: '((I)s).getClass() == P.class'               (3D)"),
                        new Choice(false, "'(I)null' liefert einen Laufzeitfehler.                                       (3E)")
                ),

                new Question(
                        "t sei eine Variable mit einer leeren assoziativen Datenstruktur, wobei Schlüssel\n" +
                        "und Werte vom Typ 'String' sind (und 'null' sein können).  U und V seien zwei\n" +
                        "voneinander verschiedene String-Konstanten (static final).  Nach welchen der\n" +
                        "folgenden Aufruf-Sequenzen liefert 't.get(U)' den String in V als Ergebnis?",

                        new Choice(false, "t.put(U, V); t.put(U, U); t.put(t.get(U), t.get(V));                          (4A)"),
                        new Choice(false, "t.put(U, U); t.put(V, V); t.put(t.get(U), t.get(V));                          (4B)"),
                        new Choice(false, "t.put(V, U); t.put(U, V); t.put(t.get(V), t.get(U));                          (4C)"),
                        new Choice(false, "t.put(V, U); t.put(t.get(V), t.get(U)); t.put(U, V);                          (4D)"),
                        new Choice(false, "t.put(t.get(U), t.get(V)); t.put(U, U); t.put(V, V);                          (4E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen stimmen in Bezug auf die Innen- und Außensicht\n" +
                        "eines abstrakten Datentyps?",

                        new Choice(false, "Beschreibungen der Methodenverwendung gehören zur Außensicht.                 (5A)"),
                        new Choice(false, "Public Methoden betreffen nur die Außensicht.                                 (5B)"),
                        new Choice(false, "Private Methoden sind in jedem Objekt der gleichen Klasse aufrufbar.          (5C)"),
                        new Choice(false, "Private Variablen sind nur im selben Objekt (this) zugreifbar.                (5D)"),
                        new Choice(false, "Die Innensicht beschreibt Implementierungsdetails.                            (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. Welche der folgenden Aussagen treffen auf Objektmethoden bzw. Klassenmethoden zu?\n" +
            "    \n" +
            "    XXXXXXXXX In Objektmethoden bezeichnet 'this' das aktuelle Objekt.                      (1A)\n" +
            "    XXXXXXXXX Klassenmethoden haben keinen Zugriff auf Objektvariablen.                     (1B)\n" +
            "    XXXXXXXXX Jede Methode b() aus einer Klasse X ist durch 'X.b()' aufrufbar.              (1C)\n" +
            "    XXXXXXXXX Jede nicht als 'static' deklarierte Methode ist eine Objektmethode.           (1D)\n" +
            "    XXXXXXXXX Aufrufe von 'this(...)' sind nur in Klassenmethoden erlaubt.                  (1E)\n" +
            "\n" +
            " 2. x sei eine Variable mit einem einfachen binären Suchbaum (nicht AVL-Baum)\n" +
            "    ganzer Zahlen, der durch diese Anweisungen aufgebaut wurde:\n" +
            "        STree x = new STree(); x.add(0); x.add(7); x.add(3);\n" +
            "    Welche der folgenden Aussagen treffen auf x zu?\n" +
            "    \n" +
            "    XXXXXXXXX Der Knoten mit Wert 3 ist die Wurzel.                                         (2A)\n" +
            "    XXXXXXXXX Der Knoten mit Wert 3 ist Kind von dem mit Wert 7.                            (2B)\n" +
            "    XXXXXXXXX Der Baum ist perfekt ausbalanciert.                                           (2C)\n" +
            "    XXXXXXXXX Der Knoten mit Wert 7 ist ein Blattknoten.                                    (2D)\n" +
            "    XXXXXXXXX Der Knoten mit Wert 7 ist Elter von dem mit Wert 0.                           (2E)\n" +
            "\n" +
            " 3. I sei ein Referenztyp (Klasse oder Interface), und s sei eine durch\n" +
            "    'L s = new P();' deklarierte Variable, wobei der Compiler keinen Fehler meldet.\n" +
            "    Welche der folgenden Aussagen treffen für alle passenden I, L, P und s zu?\n" +
            "    \n" +
            "    XXXXXXXXX '(I)s' ändert den dynamischen Typ von s auf I.                                (3A)\n" +
            "    XXXXXXXXX '(I)s' liefert keinen Laufzeitfehler wenn P Untertyp von I ist.               (3B)\n" +
            "    XXXXXXXXX L und P müssen gleich sein.                                                   (3C)\n" +
            "    XXXXXXXXX Mit 'P ist Untertyp von I' gilt: '((I)s).getClass() == P.class'               (3D)\n" +
            "    XXXXXXXXX '(I)null' liefert einen Laufzeitfehler.                                       (3E)\n" +
            "\n" +
            " 4. t sei eine Variable mit einer leeren assoziativen Datenstruktur, wobei Schlüssel\n" +
            "    und Werte vom Typ 'String' sind (und 'null' sein können).  U und V seien zwei\n" +
            "    voneinander verschiedene String-Konstanten (static final).  Nach welchen der\n" +
            "    folgenden Aufruf-Sequenzen liefert 't.get(U)' den String in V als Ergebnis?\n" +
            "    \n" +
            "    XXXXXXXXX t.put(U, V); t.put(U, U); t.put(t.get(U), t.get(V));                          (4A)\n" +
            "    XXXXXXXXX t.put(U, U); t.put(V, V); t.put(t.get(U), t.get(V));                          (4B)\n" +
            "    XXXXXXXXX t.put(V, U); t.put(U, V); t.put(t.get(V), t.get(U));                          (4C)\n" +
            "    XXXXXXXXX t.put(V, U); t.put(t.get(V), t.get(U)); t.put(U, V);                          (4D)\n" +
            "    XXXXXXXXX t.put(t.get(U), t.get(V)); t.put(U, U); t.put(V, V);                          (4E)\n" +
            "\n" +
            " 5. Welche der folgenden Aussagen stimmen in Bezug auf die Innen- und Außensicht\n" +
            "    eines abstrakten Datentyps?\n" +
            "    \n" +
            "    XXXXXXXXX Beschreibungen der Methodenverwendung gehören zur Außensicht.                 (5A)\n" +
            "    XXXXXXXXX Public Methoden betreffen nur die Außensicht.                                 (5B)\n" +
            "    XXXXXXXXX Private Methoden sind in jedem Objekt der gleichen Klasse aufrufbar.          (5C)\n" +
            "    XXXXXXXXX Private Variablen sind nur im selben Objekt (this) zugreifbar.                (5D)\n" +
            "    XXXXXXXXX Die Innensicht beschreibt Implementierungsdetails.                            (5E)\n" +
            "\n";

    public static final long UID = 243131448312000L;

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