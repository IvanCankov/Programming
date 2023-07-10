package Gruppe1130;
// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest1 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest1 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "Y, B und A seien beliebige Referenztypen. Welche der folgenden Aussagen treffen zu?",

                        new Choice(false, "Aus 'Y Untertyp von B' und 'B Untertyp von Y' folgt: 'Y.class==B.class'.      (1A)"),
                        new Choice(false, "Aus 'B Untertyp von A' folgt: 'Kommentare in B und A müssen gleich sein'.     (1B)"),
                        new Choice(false, "Ist B eine Klasse, dann ist B Untertyp von java.lang.Object.                  (1C)"),
                        new Choice(false, "'null' ist nicht Objekt von irgendeinem Referenztyp A.                        (1D)"),
                        new Choice(false, "Aus 'B ist Klasse' und 'A ist Interface' folgt: 'B ist Untertyp von A'.       (1E)")
                ),

                new Question(
                        "i sei eine Variable mit einer leeren assoziativen Datenstruktur, wobei Schlüssel\n" +
                        "und Werte vom Typ 'String' sind (und 'null' sein können).  B und J seien zwei\n" +
                        "voneinander verschiedene String-Konstanten (static final).  Nach welchen der\n" +
                        "folgenden Aufruf-Sequenzen liefert 'i.get(B)' den String in J als Ergebnis?",

                        new Choice(false, "i.put(B, J); i.put(J, B); i.put(i.get(B), i.get(J));                          (2A)"),
                        new Choice(false, "i.put(B, B); i.put(J, J); i.put(i.get(J), i.get(B));                          (2B)"),
                        new Choice(false, "i.put(B, J); i.put(i.get(J), i.get(B)); i.put(J, B);                          (2C)"),
                        new Choice(false, "i.put(J, B); i.put(B, J); i.put(i.get(J), i.get(B));                          (2D)"),
                        new Choice(false, "i.put(B, J); i.put(B, B); i.put(J, B);                                        (2E)")
                ),

                new Question(
                        "i sei eine Variable, die eine leere Double-Ended-Queue ganzer Zahlen enthält.\n" +
                        "Nach welchen der folgenden Aufruf-Sequenzen liefert 'i.peekFirst()'\n" +
                        "die Zahl 5 als Ergebnis?",

                        new Choice(false, "i.addLast(5); i.addLast(3); i.peekFirst();                                    (3A)"),
                        new Choice(false, "i.addFirst(1); i.addLast(3); i.addFirst(5);                                   (3B)"),
                        new Choice(false, "i.addFirst(5); i.addFirst(3); i.pollLast();                                   (3C)"),
                        new Choice(false, "i.addLast(5); i.addLast(3); i.pollLast();                                     (3D)"),
                        new Choice(false, "i.addFirst(5); i.addFirst(3);                                                 (3E)")
                ),

                new Question(
                        "n, o und p seien Objektreferenzen ungleich null.\n" +
                        "Welche der folgenden Bedingungen müssen für jede Implementierung der Methoden\n" +
                        "'boolean equals(Object obj)' und 'int hashCode()' in Java gelten?",

                        new Choice(false, "Aus 'n.hashCode() != o.hashCode()' folgt '!n.equals(o)'.                      (4A)"),
                        new Choice(false, "Aus 'n.equals(o)' folgt 'n.hashCode() == o.hashCode()'.                       (4B)"),
                        new Choice(false, "Aus 'n.equals(o)' und 'o.equals(p)' folgt 'p.equals(n)'.                      (4C)"),
                        new Choice(false, "Aus 'n.equals(o)' und 'o.equals(p)' folgt 'n.equals(p)'.                      (4D)"),
                        new Choice(false, "Aus 'n.equals(o)' folgt  'o.equals(n)'.                                       (4E)")
                ),

                new Question(
                        "H sei ein Referenztyp (Klasse oder Interface), und\n" +
                        "w sei eine Variable eines Referenztyps mit 'w != null'.\n" +
                        "Welche der folgenden Aussagen treffen für alle H und w zu?",

                        new Choice(false, "Gilt 'w instanceof H', dann liefert '(H)w' keinen Laufzeitfehler.             (5A)"),
                        new Choice(false, "Gilt 'w.getClass() == H.class', dann ist H ein Interface.                     (5B)"),
                        new Choice(false, "'w.getClass()' liefert (interne Repr. vom) deklarierten Typ von w.            (5C)"),
                        new Choice(false, "Gilt 'w instanceof H', dann ist H ein Interface.                              (5D)"),
                        new Choice(false, "Aus 'w instanceof H' folgt: 'w.getClass() == H.class'.                        (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. Y, B und A seien beliebige Referenztypen. Welche der folgenden Aussagen treffen zu?\n" +
            "    \n" +
            "    XXXXXXXXX Aus 'Y Untertyp von B' und 'B Untertyp von Y' folgt: 'Y.class==B.class'.      (1A)\n" +
            "    XXXXXXXXX Aus 'B Untertyp von A' folgt: 'Kommentare in B und A müssen gleich sein'.     (1B)\n" +
            "    XXXXXXXXX Ist B eine Klasse, dann ist B Untertyp von java.lang.Object.                  (1C)\n" +
            "    XXXXXXXXX 'null' ist nicht Objekt von irgendeinem Referenztyp A.                        (1D)\n" +
            "    XXXXXXXXX Aus 'B ist Klasse' und 'A ist Interface' folgt: 'B ist Untertyp von A'.       (1E)\n" +
            "\n" +
            " 2. i sei eine Variable mit einer leeren assoziativen Datenstruktur, wobei Schlüssel\n" +
            "    und Werte vom Typ 'String' sind (und 'null' sein können).  B und J seien zwei\n" +
            "    voneinander verschiedene String-Konstanten (static final).  Nach welchen der\n" +
            "    folgenden Aufruf-Sequenzen liefert 'i.get(B)' den String in J als Ergebnis?\n" +
            "    \n" +
            "    XXXXXXXXX i.put(B, J); i.put(J, B); i.put(i.get(B), i.get(J));                          (2A)\n" +
            "    XXXXXXXXX i.put(B, B); i.put(J, J); i.put(i.get(J), i.get(B));                          (2B)\n" +
            "    XXXXXXXXX i.put(B, J); i.put(i.get(J), i.get(B)); i.put(J, B);                          (2C)\n" +
            "    XXXXXXXXX i.put(J, B); i.put(B, J); i.put(i.get(J), i.get(B));                          (2D)\n" +
            "    XXXXXXXXX i.put(B, J); i.put(B, B); i.put(J, B);                                        (2E)\n" +
            "\n" +
            " 3. i sei eine Variable, die eine leere Double-Ended-Queue ganzer Zahlen enthält.\n" +
            "    Nach welchen der folgenden Aufruf-Sequenzen liefert 'i.peekFirst()'\n" +
            "    die Zahl 5 als Ergebnis?\n" +
            "    \n" +
            "    XXXXXXXXX i.addLast(5); i.addLast(3); i.peekFirst();                                    (3A)\n" +
            "    XXXXXXXXX i.addFirst(1); i.addLast(3); i.addFirst(5);                                   (3B)\n" +
            "    XXXXXXXXX i.addFirst(5); i.addFirst(3); i.pollLast();                                   (3C)\n" +
            "    XXXXXXXXX i.addLast(5); i.addLast(3); i.pollLast();                                     (3D)\n" +
            "    XXXXXXXXX i.addFirst(5); i.addFirst(3);                                                 (3E)\n" +
            "\n" +
            " 4. n, o und p seien Objektreferenzen ungleich null.\n" +
            "    Welche der folgenden Bedingungen müssen für jede Implementierung der Methoden\n" +
            "    'boolean equals(Object obj)' und 'int hashCode()' in Java gelten?\n" +
            "    \n" +
            "    XXXXXXXXX Aus 'n.hashCode() != o.hashCode()' folgt '!n.equals(o)'.                      (4A)\n" +
            "    XXXXXXXXX Aus 'n.equals(o)' folgt 'n.hashCode() == o.hashCode()'.                       (4B)\n" +
            "    XXXXXXXXX Aus 'n.equals(o)' und 'o.equals(p)' folgt 'p.equals(n)'.                      (4C)\n" +
            "    XXXXXXXXX Aus 'n.equals(o)' und 'o.equals(p)' folgt 'n.equals(p)'.                      (4D)\n" +
            "    XXXXXXXXX Aus 'n.equals(o)' folgt  'o.equals(n)'.                                       (4E)\n" +
            "\n" +
            " 5. H sei ein Referenztyp (Klasse oder Interface), und\n" +
            "    w sei eine Variable eines Referenztyps mit 'w != null'.\n" +
            "    Welche der folgenden Aussagen treffen für alle H und w zu?\n" +
            "    \n" +
            "    XXXXXXXXX Gilt 'w instanceof H', dann liefert '(H)w' keinen Laufzeitfehler.             (5A)\n" +
            "    XXXXXXXXX Gilt 'w.getClass() == H.class', dann ist H ein Interface.                     (5B)\n" +
            "    XXXXXXXXX 'w.getClass()' liefert (interne Repr. vom) deklarierten Typ von w.            (5C)\n" +
            "    XXXXXXXXX Gilt 'w instanceof H', dann ist H ein Interface.                              (5D)\n" +
            "    XXXXXXXXX Aus 'w instanceof H' folgt: 'w.getClass() == H.class'.                        (5E)\n" +
            "\n";

    public static final long UID = 243047957813823L;

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