package Gruppe1000;// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest1 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle Gruppe1000.MCTest1 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "I sei ein Referenztyp (Klasse oder Interface), und\n" +
                        "j sei eine Variable eines Referenztyps mit 'j != null'.\n" +
                        "Welche der folgenden Aussagen treffen für alle I und j zu?",

                        new Choice(false, "Gilt 'j instanceof I', dann kann j vom deklarierten Typ I sein.               (1A)"),
                        new Choice(false, "Liefert '(I)j' einen Laufzeitfehler, dann gilt '!(j instanceof I)'.           (1B)"),
                        new Choice(false, "'j.getClass()' liefert ein Objekt vom Typ 'String'.                           (1C)"),
                        new Choice(false, "Aus 'j instanceof I' folgt: 'j.getClass() == I.class'.                        (1D)"),
                        new Choice(false, "Aus 'j.getClass() == I.class' folgt: 'I ist eine Klasse'.                     (1E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen müssen für jede Verwendung von\n" +
                        "'this(...)' bzw. 'this' in einem Konstruktor zutreffen?",

                        new Choice(false, "'this(...);' kann nur im Default-Konstruktor aufgerufen werden.               (2A)"),
                        new Choice(false, "Der Wert von 'this' ist nur schreibbar, nicht lesbar.                         (2B)"),
                        new Choice(false, "'this != null' gibt immer 'true' zurück.                                      (2C)"),
                        new Choice(false, "'this' referenziert den Untertyp der aktuellen Klasse.                        (2D)"),
                        new Choice(false, "'this(...);' darf nur als letzte Anweisung vorkommen.                         (2E)")
                ),

                new Question(
                        "Z und H seien Referenztypen, sodass der Compiler folgenden Programmtext\n" +
                        "fehlerfrei compiliert: 'H b = new Z();  b.a();'\n" +
                        "Welche der folgenden Aussagen treffen für alle passenden Z, H, b und a() zu?",

                        new Choice(false, "Z kann Klasse oder Interface sein.                                            (3A)"),
                        new Choice(false, "H ist Obertyp von Z.                                                          (3B)"),
                        new Choice(false, "Durch 'b.a()' wird die Methode in Z ausgeführt.                               (3C)"),
                        new Choice(false, "Die Methode a() muss in H vorkommen, nicht in Z.                              (3D)"),
                        new Choice(false, "Kommentare zu a() in H müssen auch auf a() in Z zutreffen.                    (3E)")
                ),

                new Question(
                        "s sei eine Variable mit einer leeren assoziativen Datenstruktur, wobei Schlüssel\n" +
                        "und Werte vom Typ 'String' sind (und 'null' sein können).  F und Y seien zwei\n" +
                        "voneinander verschiedene String-Konstanten (static final).  Nach welchen der\n" +
                        "folgenden Aufruf-Sequenzen liefert 's.get(F)' den String in Y als Ergebnis?",

                        new Choice(false, "s.put(s.get(F), s.get(Y)); s.put(F, F); s.put(Y, Y);                          (4A)"),
                        new Choice(false, "s.put(F, F); s.put(s.get(F), s.get(Y)); s.put(Y, Y);                          (4B)"),
                        new Choice(false, "s.put(F, Y); s.put(F, F); s.put(s.get(F), s.get(Y));                          (4C)"),
                        new Choice(false, "s.put(F, Y); s.put(s.get(Y), s.get(F)); s.put(Y, F);                          (4D)"),
                        new Choice(false, "s.put(F, F); s.put(Y, Y); s.put(s.get(F), s.get(Y));                          (4E)")
                ),

                new Question(
                        "y sei eine Referenz auf einen Knoten (Typ 'Node') in einer einfach verketteten Liste\n" +
                        "mit mindestens einem existierenden Nachfolger (in der Objektvariablen 'next').\n" +
                        "Welche der folgenden Anweisungs-Sequenzen entfernen den direkten Nachfolger von y\n" +
                        "aus einer Liste, ändern sonst aber nichts?",

                        new Choice(false, "Node d = y.next.next; d.next = y;                                             (5A)"),
                        new Choice(false, "Node u = y.next; u = u.next;                                                  (5B)"),
                        new Choice(false, "Node o = y; o.next = y.next.next;                                             (5C)"),
                        new Choice(false, "Node o = y.next; y.next = o.next;                                             (5D)"),
                        new Choice(false, "Node w = y.next.next; y.next = w;                                             (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. I sei ein Referenztyp (Klasse oder Interface), und\n" +
            "    j sei eine Variable eines Referenztyps mit 'j != null'.\n" +
            "    Welche der folgenden Aussagen treffen für alle I und j zu?\n" +
            "    \n" +
            "    XXXXXXXXX Gilt 'j instanceof I', dann kann j vom deklarierten Typ I sein.               (1A)\n" +
            "    XXXXXXXXX Liefert '(I)j' einen Laufzeitfehler, dann gilt '!(j instanceof I)'.           (1B)\n" +
            "    XXXXXXXXX 'j.getClass()' liefert ein Objekt vom Typ 'String'.                           (1C)\n" +
            "    XXXXXXXXX Aus 'j instanceof I' folgt: 'j.getClass() == I.class'.                        (1D)\n" +
            "    XXXXXXXXX Aus 'j.getClass() == I.class' folgt: 'I ist eine Klasse'.                     (1E)\n" +
            "\n" +
            " 2. Welche der folgenden Aussagen müssen für jede Verwendung von\n" +
            "    'this(...)' bzw. 'this' in einem Konstruktor zutreffen?\n" +
            "    \n" +
            "    XXXXXXXXX 'this(...);' kann nur im Default-Konstruktor aufgerufen werden.               (2A)\n" +
            "    XXXXXXXXX Der Wert von 'this' ist nur schreibbar, nicht lesbar.                         (2B)\n" +
            "    XXXXXXXXX 'this != null' gibt immer 'true' zurück.                                      (2C)\n" +
            "    XXXXXXXXX 'this' referenziert den Untertyp der aktuellen Klasse.                        (2D)\n" +
            "    XXXXXXXXX 'this(...);' darf nur als letzte Anweisung vorkommen.                         (2E)\n" +
            "\n" +
            " 3. Z und H seien Referenztypen, sodass der Compiler folgenden Programmtext\n" +
            "    fehlerfrei compiliert: 'H b = new Z();  b.a();'\n" +
            "    Welche der folgenden Aussagen treffen für alle passenden Z, H, b und a() zu?\n" +
            "    \n" +
            "    XXXXXXXXX Z kann Klasse oder Interface sein.                                            (3A)\n" +
            "    XXXXXXXXX H ist Obertyp von Z.                                                          (3B)\n" +
            "    XXXXXXXXX Durch 'b.a()' wird die Methode in Z ausgeführt.                               (3C)\n" +
            "    XXXXXXXXX Die Methode a() muss in H vorkommen, nicht in Z.                              (3D)\n" +
            "    XXXXXXXXX Kommentare zu a() in H müssen auch auf a() in Z zutreffen.                    (3E)\n" +
            "\n" +
            " 4. s sei eine Variable mit einer leeren assoziativen Datenstruktur, wobei Schlüssel\n" +
            "    und Werte vom Typ 'String' sind (und 'null' sein können).  F und Y seien zwei\n" +
            "    voneinander verschiedene String-Konstanten (static final).  Nach welchen der\n" +
            "    folgenden Aufruf-Sequenzen liefert 's.get(F)' den String in Y als Ergebnis?\n" +
            "    \n" +
            "    XXXXXXXXX s.put(s.get(F), s.get(Y)); s.put(F, F); s.put(Y, Y);                          (4A)\n" +
            "    XXXXXXXXX s.put(F, F); s.put(s.get(F), s.get(Y)); s.put(Y, Y);                          (4B)\n" +
            "    XXXXXXXXX s.put(F, Y); s.put(F, F); s.put(s.get(F), s.get(Y));                          (4C)\n" +
            "    XXXXXXXXX s.put(F, Y); s.put(s.get(Y), s.get(F)); s.put(Y, F);                          (4D)\n" +
            "    XXXXXXXXX s.put(F, F); s.put(Y, Y); s.put(s.get(F), s.get(Y));                          (4E)\n" +
            "\n" +
            " 5. y sei eine Referenz auf einen Knoten (Typ 'Node') in einer einfach verketteten Liste\n" +
            "    mit mindestens einem existierenden Nachfolger (in der Objektvariablen 'next').\n" +
            "    Welche der folgenden Anweisungs-Sequenzen entfernen den direkten Nachfolger von y\n" +
            "    aus einer Liste, ändern sonst aber nichts?\n" +
            "    \n" +
            "    XXXXXXXXX Node d = y.next.next; d.next = y;                                             (5A)\n" +
            "    XXXXXXXXX Node u = y.next; u = u.next;                                                  (5B)\n" +
            "    XXXXXXXXX Node o = y; o.next = y.next.next;                                             (5C)\n" +
            "    XXXXXXXXX Node o = y.next; y.next = o.next;                                             (5D)\n" +
            "    XXXXXXXXX Node w = y.next.next; y.next = w;                                             (5E)\n" +
            "\n";

    public static final long UID = 245142257006772L;

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