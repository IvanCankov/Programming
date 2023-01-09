public class Loops {
    public static void main(String[] args) {
        System.out.println(sumOfNumbers());
        System.out.println(concatString());
        System.out.println(removeHashtags());
    }
    
    static int sumOfNumbers() {
        int sum = 0;
        for (int i = 13; i <= 68; i++) {
            if (i % 7 == 0 || i % 4 == 0) sum += i;
        }
        return sum;
    }

    static String concatString() {
        String iHaveNoIdeaWhatToNameThisString = "";
        for (int i = 10; i <= 20; i++) {
            if (i % 3 == 2) iHaveNoIdeaWhatToNameThisString += "*";
            iHaveNoIdeaWhatToNameThisString += i + "=";
        }

        return iHaveNoIdeaWhatToNameThisString;
    }

    static String removeHashtags() {
        String str = "#Wichtige #Nachricht erhalten##";
        String strNew = str.replace("#", "");
        return strNew;
    }
}
