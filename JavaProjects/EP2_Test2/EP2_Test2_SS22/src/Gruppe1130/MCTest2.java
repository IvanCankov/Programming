package Gruppe1130;// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest2 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle Gruppe1130.Gruppe1300.Gruppe1600.MCTest2 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "Welche der folgenden Aussagen treffen auf das Testen großer Programme zu?",

                        new Choice(false, "Black-Box-Testen leitet Testfälle aus Anwendungsfällen ab.                         (1A)"),
                        new Choice(false, "Auch intensives Testen kann nicht alle Fehler aufdecken.                           (1B)"),
                        new Choice(false, "Regressions-Tests sind fast immer automatisiert.                                   (1C)"),
                        new Choice(false, "Schnittstellen-Tests überprüfen die Benutzeroberfläche.                            (1D)"),
                        new Choice(false, "Grey-Box-Testen legt Testfälle vor der Implementierung fest.                       (1E)")
                ),

                new Question(
                        "int m=62, p=1, k=1; while (k < m) p *= ++k; \n" +
                        "Welche der folgenden Aussagen sind gültige Schleifeninvarianten dieser Schleife?",

                        new Choice(false, "m == 62                                                                            (2A)"),
                        new Choice(false, "p ist das Produkt aller Zahlen von 1 bis k, also 1*...*k                           (2B)"),
                        new Choice(false, "k >= 1 && k <= 62                                                                  (2C)"),
                        new Choice(false, "p >= m                                                                             (2D)"),
                        new Choice(false, "p ist das Produkt aller Zahlen von 1 bis m, also 1*...*m                           (2E)")
                ),

                new Question(
                        "public int sumFrom1To(int n) { return (n * (n + 1)) / 2; } \n" +
                        "Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
                        "dieser Methode sinnvoll sein?",

                        new Choice(false, "Nachbedingung: Lässt den Objektzustand unverändert.                                (3A)"),
                        new Choice(false, "Nachbedingung: Ergebnis ist für n < 1 nicht die Zahlensumme.                       (3B)"),
                        new Choice(false, "Vorbedingung: Gibt (n * (n + 1)) / 2 zurück.                                       (3C)"),
                        new Choice(false, "Nachbedingung: Ergebnis hängt nur von n ab.                                        (3D)"),
                        new Choice(false, "Vorbedingung: n >= 1.                                                              (3E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf Klassen und Interfaces im\n" +
                        "Java-Collections-Framework zu?",

                        new Choice(false, "TreeMap<K,V> ist Untertyp von SortedMap<K,V>.                                      (4A)"),
                        new Choice(false, "LinkedList<E> verbietet mehrere gleiche Einträge.                                  (4B)"),
                        new Choice(false, "Aus einer Queue<E> kann man Elemente mittels remove und poll löschen.              (4C)"),
                        new Choice(false, "LinkedList<E> implementiert Deque<E>.                                              (4D)"),
                        new Choice(false, "List<E> erweitert Set<E> um zusätzliche Methoden.                                  (4E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf die notwendige Überprüfung von Eingabedaten zu?",

                        new Choice(false, "Plausibilitätsprüfungen sollen direkt nach der Eingabe erfolgen.                   (5A)"),
                        new Choice(false, "Alle Daten von außerhalb des Programms müssen überprüft werden.                    (5B)"),
                        new Choice(false, "Zu intensive Prüfung kann z.B. zu einer SQL-Injection führen.                      (5C)"),
                        new Choice(false, "Reguläre Ausdrücke können Prüfungen von Datenformaten vereinfachen.                (5D)"),
                        new Choice(false, "Nicht validierbare Daten müssen zurückgewiesen werden.                             (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. Welche der folgenden Aussagen treffen auf das Testen großer Programme zu?\n" +
            "    \n" +
            "    XXXXXXXXX Black-Box-Testen leitet Testfälle aus Anwendungsfällen ab.                         (1A)\n" +
            "    XXXXXXXXX Auch intensives Testen kann nicht alle Fehler aufdecken.                           (1B)\n" +
            "    XXXXXXXXX Regressions-Tests sind fast immer automatisiert.                                   (1C)\n" +
            "    XXXXXXXXX Schnittstellen-Tests überprüfen die Benutzeroberfläche.                            (1D)\n" +
            "    XXXXXXXXX Grey-Box-Testen legt Testfälle vor der Implementierung fest.                       (1E)\n" +
            "\n" +
            " 2. int m=62, p=1, k=1; while (k < m) p *= ++k; \n" +
            "    Welche der folgenden Aussagen sind gültige Schleifeninvarianten dieser Schleife?\n" +
            "    \n" +
            "    XXXXXXXXX m == 62                                                                            (2A)\n" +
            "    XXXXXXXXX p ist das Produkt aller Zahlen von 1 bis k, also 1*...*k                           (2B)\n" +
            "    XXXXXXXXX k >= 1 && k <= 62                                                                  (2C)\n" +
            "    XXXXXXXXX p >= m                                                                             (2D)\n" +
            "    XXXXXXXXX p ist das Produkt aller Zahlen von 1 bis m, also 1*...*m                           (2E)\n" +
            "\n" +
            " 3. public int sumFrom1To(int n) { return (n * (n + 1)) / 2; } \n" +
            "    Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
            "    dieser Methode sinnvoll sein?\n" +
            "    \n" +
            "    XXXXXXXXX Nachbedingung: Lässt den Objektzustand unverändert.                                (3A)\n" +
            "    XXXXXXXXX Nachbedingung: Ergebnis ist für n < 1 nicht die Zahlensumme.                       (3B)\n" +
            "    XXXXXXXXX Vorbedingung: Gibt (n * (n + 1)) / 2 zurück.                                       (3C)\n" +
            "    XXXXXXXXX Nachbedingung: Ergebnis hängt nur von n ab.                                        (3D)\n" +
            "    XXXXXXXXX Vorbedingung: n >= 1.                                                              (3E)\n" +
            "\n" +
            " 4. Welche der folgenden Aussagen treffen auf Klassen und Interfaces im\n" +
            "    Java-Collections-Framework zu?\n" +
            "    \n" +
            "    XXXXXXXXX TreeMap<K,V> ist Untertyp von SortedMap<K,V>.                                      (4A)\n" +
            "    XXXXXXXXX LinkedList<E> verbietet mehrere gleiche Einträge.                                  (4B)\n" +
            "    XXXXXXXXX Aus einer Queue<E> kann man Elemente mittels remove und poll löschen.              (4C)\n" +
            "    XXXXXXXXX LinkedList<E> implementiert Deque<E>.                                              (4D)\n" +
            "    XXXXXXXXX List<E> erweitert Set<E> um zusätzliche Methoden.                                  (4E)\n" +
            "\n" +
            " 5. Welche der folgenden Aussagen treffen auf die notwendige Überprüfung von Eingabedaten zu?\n" +
            "    \n" +
            "    XXXXXXXXX Plausibilitätsprüfungen sollen direkt nach der Eingabe erfolgen.                   (5A)\n" +
            "    XXXXXXXXX Alle Daten von außerhalb des Programms müssen überprüft werden.                    (5B)\n" +
            "    XXXXXXXXX Zu intensive Prüfung kann z.B. zu einer SQL-Injection führen.                      (5C)\n" +
            "    XXXXXXXXX Reguläre Ausdrücke können Prüfungen von Datenformaten vereinfachen.                (5D)\n" +
            "    XXXXXXXXX Nicht validierbare Daten müssen zurückgewiesen werden.                             (5E)\n" +
            "\n";

    public static final long UID = 245099598553782L;

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