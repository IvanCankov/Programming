/*
    Aufgabe 2) Erste Methoden
*/
public class Aufgabe2 {
    public static void main(String[] args) {
        char startChar = 'z';
        printAlphabetPartsReverse(startChar);

        assert (calcSum(1,1) == 1); //Passed
        assert (calcSum(1,3) == 6); //Passed
        assert (calcSum(20,22) == 63); //Passed
        assert (calcSum(10,356) == 63501); //Passed


        assert (isAsciiValueInRange('B', 'A', 'G')); //Passed
        assert (!isAsciiValueInRange('!', '0', 'Z')); //Passed
        assert (isAsciiValueInRange('A','A', 'A')); //Passed
        assert (isAsciiValueInRange('B', 'A', 'C')); //Passed
        assert (isAsciiValueInRange(':', '8', 'D')); //Passed
        assert (!isAsciiValueInRange('+', '5', 'A')); //Passed

        assert (removeInString789("").equals("")); //Passed
        assert (removeInString789("7").equals("")); //Passed
        assert (removeInString789("67").equals("6")); //Passed
        assert (removeInString789("7493").equals("43")); //Passed
        assert (removeInString789("Hallo 0123456789:").equals("Hallo 0123456:")); //Passed
        assert (removeInString789("Telefonnummer 120, 178 oder 911?").equals("Telefonnummer 120, 1 oder 11?")); //Passed

    }

    static void printChar(char a) {
        System.out.print(a);
    }

    static void printAlphabetPartsReverse(char startChar) {
        while (startChar >= 'a'){
            printChar(startChar);
            System.out.print(" ");
            startChar--;
        }
    }

    static int calcSum(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }

    static boolean isAsciiValueInRange(char sign, char start, char end) {
        return sign >= start && sign <= end;
    }

    static String removeInString789(String text) {
        String textNew = text.replaceAll("[789]*", ""); //writing RegEx is seriously retarded ;-;
        return textNew;
    }
}
