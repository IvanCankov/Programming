/*
    Aufgabe 3) Rekursion
*/
public class Aufgabe3 {

    private static void printEvenNumbersAscending(int start, int end) {
        if (end <= start) {
            System.out.println("Invalid start or end value");
            return;
        }

        if (start % 2 == 0) System.out.println(start);
        else {
            start++;
            System.out.println(start);
        }
        printEvenNumbersAscending(start += 2, end);
    }

    private static void printOddNumbersDescending(int start, int end) {
        if (start >= end) {
            System.out.println("Invalid start or end value");
            return;
        }

        if (end % 2 == 1) System.out.println(end);
        else {
            end--;
            System.out.println(end);
        }
        printOddNumbersDescending(start, end -= 2);
    }


    private static int sumSquaredDigits(int number) {
        int sum = 0;

        sum += (number % 10) * (number % 10);
        number = number / 10;
        if (number != 0) {
            sum += sumSquaredDigits(number);
        }
        return sum;
    }

    private static String removeSpaces(String text) {
        //
        if (text != null) {
            if (text.length() == 1) {
                if (text.equals(" ")) return "";
                else return text;
            }

            int i = 0;
            if (text.charAt(i) != ' ') {
                return text.charAt(i) + removeSpaces(text.substring(i + 1));
            }
            else {
                return removeSpaces(text.substring(i + 1));
            }
        }
        return null;
    }

    public static void main(String[] args) {
        printEvenNumbersAscending(10, 20);
        System.out.println();
        printOddNumbersDescending(5, 15);
        System.out.println();

        System.out.println(sumSquaredDigits(1));
        System.out.println(sumSquaredDigits(102));
        System.out.println(sumSquaredDigits(1234));
        System.out.println(sumSquaredDigits(10000));
        System.out.println(sumSquaredDigits(93842));
        System.out.println(sumSquaredDigits(875943789));
        assert (sumSquaredDigits(1) == 1);
        assert (sumSquaredDigits(102) == 5);
        assert (sumSquaredDigits(1234) == 30);
        assert (sumSquaredDigits(10000) == 1);
        assert (sumSquaredDigits(93842) == 174);
        assert (sumSquaredDigits(875943789) == 438);
        System.out.println();

        System.out.println(removeSpaces(" "));
        System.out.println(removeSpaces("+ +"));
        System.out.println(removeSpaces(" 12 3 45 "));
        System.out.println(removeSpaces("a  b   c    d"));
        assert (removeSpaces(" ").equals(""));
        assert (removeSpaces("+ +").equals("++"));
        assert (removeSpaces(" 12 3 45 ").equals("12345"));
        assert (removeSpaces("a  b   c    d").equals("abcd"));
    }
}

