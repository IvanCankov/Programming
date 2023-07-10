package Gruppe1600;// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest2 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle Gruppe1600.MCTest2 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "Welche der folgenden Hoare-Tripel gelten (für Anweisungen in Java)?",

                        new Choice(false, "{y==15} y+=1; {y==14}                                                              (1A)"),
                        new Choice(true, "{true} y=-43; {y>=-43}                                                             (1B)"),
                        new Choice(true, "{y>15} if (y<14) y--; {y>15}                                                       (1C)"),
                        new Choice(true, "{true} y = w<z ? w : z; {y>=z}                                                     (1D)"),
                        new Choice(false, "{y>-43} while (y>-43) y--; {y>-43}                                                 (1E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf die notwendige Überprüfung von Eingabedaten zu?",

                        new Choice(false, "Alle Parameter einer Methode müssen in der Methode überprüft werden.               (2A)"),
                        new Choice(false, "Nicht validierbare Daten reparieren wir direkt nach der Eingabe.                   (2B)"),
                        new Choice(false, "Java-Objekte vom Typ Pattern helfen bei der Prüfung der Syntax.                    (2C)"),
                        new Choice(false, "Reguläre Ausdrücke können Prüfungen der Semantik vereinfachen.                     (2D)"),
                        new Choice(false, "Plausibilitätsprüfungen sollen direkt nach der Eingabe erfolgen.                   (2E)")
                ),

                new Question(
                        "public int median(int[] p) { return p[p.length / 2]; } \n" +
                        "Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
                        "dieser Methode sinnvoll sein?",

                        new Choice(false, "Vorbedingung: Gibt den Median zurück wenn p sortiert ist.                          (3A)"),
                        new Choice(false, "Nachbedingung: Gibt einen Eintrag etwa in der Mitte von p zurück.                  (3B)"),
                        new Choice(false, "Nachbedingung: Lässt p unverändert.                                                (3C)"),
                        new Choice(false, "Nachbedingung: p ist absteigend sortiert.                                          (3D)"),
                        new Choice(false, "Vorbedingung: p != null                                                            (3E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen für Design-by-Contract zu?",

                        new Choice(false, "Invarianten beziehen sich auf Objektzustände.                                      (4A)"),
                        new Choice(false, "Objektzustände dürfen geändert werden, wo dies nicht explizit verboten ist.        (4B)"),
                        new Choice(false, "Nachbedingungen beziehen sich auf einzelne Methoden.                               (4C)"),
                        new Choice(false, "Auch ohne Zusicherungen muss gelten, was allgemein erwartet wird.                  (4D)"),
                        new Choice(false, "Eine Vorbedingung darf im Untertyp stärker sein als im Obertyp.                    (4E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf Klassen und Interfaces im\n" +
                        "Java-Collections-Framework zu?",

                        new Choice(false, "ArrayList<E> verbietet mehrere gleiche Einträge.                                   (5A)"),
                        new Choice(false, "LinkedHashMap<K,V> implementiert Map<K,V>.                                         (5B)"),
                        new Choice(false, "In eine Queue<E> kann man neben add auch mittels offer einfügen.                   (5C)"),
                        new Choice(false, "LinkedList<E> ist Untertyp von Deque<E>                                            (5D)"),
                        new Choice(false, "TreeSet<E> ist ein balancierter binärer Suchbaum.                                  (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. Welche der folgenden Hoare-Tripel gelten (für Anweisungen in Java)?\n" +
            "    \n" +
            "    XXXXXXXXX {y==15} y+=1; {y==14}                                                              (1A)\n" +
            "    XXXXXXXXX {true} y=-43; {y>=-43}                                                             (1B)\n" +
            "    XXXXXXXXX {y>15} if (y<14) y--; {y>15}                                                       (1C)\n" +
            "    XXXXXXXXX {true} y = w<z ? w : z; {y>=z}                                                     (1D)\n" +
            "    XXXXXXXXX {y>-43} while (y>-43) y--; {y>-43}                                                 (1E)\n" +
            "\n" +
            " 2. Welche der folgenden Aussagen treffen auf die notwendige Überprüfung von Eingabedaten zu?\n" +
            "    \n" +
            "    XXXXXXXXX Alle Parameter einer Methode müssen in der Methode überprüft werden.               (2A)\n" +
            "    XXXXXXXXX Nicht validierbare Daten reparieren wir direkt nach der Eingabe.                   (2B)\n" +
            "    XXXXXXXXX Java-Objekte vom Typ Pattern helfen bei der Prüfung der Syntax.                    (2C)\n" +
            "    XXXXXXXXX Reguläre Ausdrücke können Prüfungen der Semantik vereinfachen.                     (2D)\n" +
            "    XXXXXXXXX Plausibilitätsprüfungen sollen direkt nach der Eingabe erfolgen.                   (2E)\n" +
            "\n" +
            " 3. public int median(int[] p) { return p[p.length / 2]; } \n" +
            "    Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
            "    dieser Methode sinnvoll sein?\n" +
            "    \n" +
            "    XXXXXXXXX Vorbedingung: Gibt den Median zurück wenn p sortiert ist.                          (3A)\n" +
            "    XXXXXXXXX Nachbedingung: Gibt einen Eintrag etwa in der Mitte von p zurück.                  (3B)\n" +
            "    XXXXXXXXX Nachbedingung: Lässt p unverändert.                                                (3C)\n" +
            "    XXXXXXXXX Nachbedingung: p ist absteigend sortiert.                                          (3D)\n" +
            "    XXXXXXXXX Vorbedingung: p != null                                                            (3E)\n" +
            "\n" +
            " 4. Welche der folgenden Aussagen treffen für Design-by-Contract zu?\n" +
            "    \n" +
            "    XXXXXXXXX Invarianten beziehen sich auf Objektzustände.                                      (4A)\n" +
            "    XXXXXXXXX Objektzustände dürfen geändert werden, wo dies nicht explizit verboten ist.        (4B)\n" +
            "    XXXXXXXXX Nachbedingungen beziehen sich auf einzelne Methoden.                               (4C)\n" +
            "    XXXXXXXXX Auch ohne Zusicherungen muss gelten, was allgemein erwartet wird.                  (4D)\n" +
            "    XXXXXXXXX Eine Vorbedingung darf im Untertyp stärker sein als im Obertyp.                    (4E)\n" +
            "\n" +
            " 5. Welche der folgenden Aussagen treffen auf Klassen und Interfaces im\n" +
            "    Java-Collections-Framework zu?\n" +
            "    \n" +
            "    XXXXXXXXX ArrayList<E> verbietet mehrere gleiche Einträge.                                   (5A)\n" +
            "    XXXXXXXXX LinkedHashMap<K,V> implementiert Map<K,V>.                                         (5B)\n" +
            "    XXXXXXXXX In eine Queue<E> kann man neben add auch mittels offer einfügen.                   (5C)\n" +
            "    XXXXXXXXX LinkedList<E> ist Untertyp von Deque<E>                                            (5D)\n" +
            "    XXXXXXXXX TreeSet<E> ist ein balancierter binärer Suchbaum.                                  (5E)\n" +
            "\n";

    public static final long UID = 245099841201306L;

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