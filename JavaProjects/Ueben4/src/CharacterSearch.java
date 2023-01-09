public class CharacterSearch {
    public static void main(String[] args) {
        char a = 'u';
        String b = "Schneeeule";
        if (characterSearch(a, b) > 1) System.out.println("Zwei oder mehr Zeichen gefunden");
        else if (characterSearch(a, b) == 1) System.out.println("Genau ein Zeichen gefunden");
        else System.out.println("Kein Zeichen gefunden");
    }

    static int characterSearch(char a, String b) {
        int counter = 0;
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == a) counter++;
        }
        return counter;
    }
}