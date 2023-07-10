package Gruppe1300;// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest2 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle Gruppe1300.Gruppe1600.MCTest2 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "public int median(int[] h) { return h[h.length / 2]; } \n" +
                        "Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
                        "dieser Methode sinnvoll sein?",

                        new Choice(false, "Nachbedingung: Gibt einen Eintrag etwa in der Mitte von h zurück.                  (1A)"),
                        new Choice(false, "Vorbedingung: h != null                                                            (1B)"),
                        new Choice(false, "Vorbedingung: Lässt h unverändert.                                                 (1C)"),
                        new Choice(false, "Vorbedingung: Greift auf einen Eintrag von h zu.                                   (1D)"),
                        new Choice(false, "Nachbedingung: Wirft eine Exception wenn h.length == 0.                            (1E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen für Design-by-Contract zu?",

                        new Choice(false, "Eine Nachbedingung darf im Untertyp schwächer sein als im Obertyp.                 (2A)"),
                        new Choice(false, "Invarianten beziehen sich auf einzelne Methoden.                                   (2B)"),
                        new Choice(false, "Objektzustände dürfen nur geändert werden, wo dies erwartet wird.                  (2C)"),
                        new Choice(false, "Vorbedingungen beziehen sich auf einzelne Methoden.                                (2D)"),
                        new Choice(false, "Eine Vorbedingung darf im Untertyp schwächer sein als im Obertyp.                  (2E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf die notwendige Überprüfung von Eingabedaten zu?",

                        new Choice(false, "Alle Parameter einer Methode müssen in der Methode überprüft werden.               (3A)"),
                        new Choice(false, "Die Validierung soll erst möglichst knapp vor der Ausgabe erfolgen.                (3B)"),
                        new Choice(false, "Die Korrektheit kann nicht geprüft werden, nur die Plausibilität.                  (3C)"),
                        new Choice(false, "Zu intensive Prüfung kann z.B. zu einer SQL-Injection führen.                      (3D)"),
                        new Choice(false, "Nicht validierbare Daten müssen zurückgewiesen werden.                             (3E)")
                ),

                new Question(
                        "int r=62, t=1, j=1; while (j < r) t *= ++j; \n" +
                        "Welche der folgenden Aussagen sind gültige Schleifeninvarianten dieser Schleife?",

                        new Choice(false, "t ist das Produkt aller Zahlen von 1 bis r, also 1*...*r                           (4A)"),
                        new Choice(false, "j > 0 && j < r                                                                     (4B)"),
                        new Choice(false, "t >= j                                                                             (4C)"),
                        new Choice(false, "t <= r                                                                             (4D)"),
                        new Choice(false, "j >= 1 && j <= r                                                                   (4E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf Klassen und Interfaces im\n" +
                        "Java-Collections-Framework zu?",

                        new Choice(false, "LinkedList<E> implementiert LinkedHashSet<E>                                       (5A)"),
                        new Choice(false, "LinkedHashMap<K,V> implementiert SortedMap<K,V>.                                   (5B)"),
                        new Choice(false, "TreeMap<K,V> ist Untertyp von SortedSet<E>.                                        (5C)"),
                        new Choice(false, "TreeSet<E> erlaubt mehrere gleiche Einträge.                                       (5D)"),
                        new Choice(false, "Aus einer Queue<E> kann man Elemente mittels remove und poll löschen.              (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. public int median(int[] h) { return h[h.length / 2]; } \n" +
            "    Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
            "    dieser Methode sinnvoll sein?\n" +
            "    \n" +
            "    XXXXXXXXX Nachbedingung: Gibt einen Eintrag etwa in der Mitte von h zurück.                  (1A)\n" +
            "    XXXXXXXXX Vorbedingung: h != null                                                            (1B)\n" +
            "    XXXXXXXXX Vorbedingung: Lässt h unverändert.                                                 (1C)\n" +
            "    XXXXXXXXX Vorbedingung: Greift auf einen Eintrag von h zu.                                   (1D)\n" +
            "    XXXXXXXXX Nachbedingung: Wirft eine Exception wenn h.length == 0.                            (1E)\n" +
            "\n" +
            " 2. Welche der folgenden Aussagen treffen für Design-by-Contract zu?\n" +
            "    \n" +
            "    XXXXXXXXX Eine Nachbedingung darf im Untertyp schwächer sein als im Obertyp.                 (2A)\n" +
            "    XXXXXXXXX Invarianten beziehen sich auf einzelne Methoden.                                   (2B)\n" +
            "    XXXXXXXXX Objektzustände dürfen nur geändert werden, wo dies erwartet wird.                  (2C)\n" +
            "    XXXXXXXXX Vorbedingungen beziehen sich auf einzelne Methoden.                                (2D)\n" +
            "    XXXXXXXXX Eine Vorbedingung darf im Untertyp schwächer sein als im Obertyp.                  (2E)\n" +
            "\n" +
            " 3. Welche der folgenden Aussagen treffen auf die notwendige Überprüfung von Eingabedaten zu?\n" +
            "    \n" +
            "    XXXXXXXXX Alle Parameter einer Methode müssen in der Methode überprüft werden.               (3A)\n" +
            "    XXXXXXXXX Die Validierung soll erst möglichst knapp vor der Ausgabe erfolgen.                (3B)\n" +
            "    XXXXXXXXX Die Korrektheit kann nicht geprüft werden, nur die Plausibilität.                  (3C)\n" +
            "    XXXXXXXXX Zu intensive Prüfung kann z.B. zu einer SQL-Injection führen.                      (3D)\n" +
            "    XXXXXXXXX Nicht validierbare Daten müssen zurückgewiesen werden.                             (3E)\n" +
            "\n" +
            " 4. int r=62, t=1, j=1; while (j < r) t *= ++j; \n" +
            "    Welche der folgenden Aussagen sind gültige Schleifeninvarianten dieser Schleife?\n" +
            "    \n" +
            "    XXXXXXXXX t ist das Produkt aller Zahlen von 1 bis r, also 1*...*r                           (4A)\n" +
            "    XXXXXXXXX j > 0 && j < r                                                                     (4B)\n" +
            "    XXXXXXXXX t >= j                                                                             (4C)\n" +
            "    XXXXXXXXX t <= r                                                                             (4D)\n" +
            "    XXXXXXXXX j >= 1 && j <= r                                                                   (4E)\n" +
            "\n" +
            " 5. Welche der folgenden Aussagen treffen auf Klassen und Interfaces im\n" +
            "    Java-Collections-Framework zu?\n" +
            "    \n" +
            "    XXXXXXXXX LinkedList<E> implementiert LinkedHashSet<E>                                       (5A)\n" +
            "    XXXXXXXXX LinkedHashMap<K,V> implementiert SortedMap<K,V>.                                   (5B)\n" +
            "    XXXXXXXXX TreeMap<K,V> ist Untertyp von SortedSet<E>.                                        (5C)\n" +
            "    XXXXXXXXX TreeSet<E> erlaubt mehrere gleiche Einträge.                                       (5D)\n" +
            "    XXXXXXXXX Aus einer Queue<E> kann man Elemente mittels remove und poll löschen.              (5E)\n" +
            "\n";

    public static final long UID = 245143517755626L;

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