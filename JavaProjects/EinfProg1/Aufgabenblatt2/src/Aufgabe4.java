import java.util.Scanner;

public class Aufgabe4 {

    static int randomNumberInInterval() {
        int number = (int) (Math.random() * 200) + 1; //int r = (int) (Math.random() * (upper)) + lower;
        return number;
    }

    static int readUserInput() {
        String message = "";
        int number = randomNumberInInterval();
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter your guess: ");
        boolean isInteger = false;
        int userInput = -1;

        while (!isInteger) {
            System.out.println("Try#: ");
            if (myScanner.hasNext()) {
                if (myScanner.hasNextInt()) {
                    userInput = myScanner.nextInt();
                    if (userInput < 0 || userInput > 200) System.out.println(userInput + " is too large!");
                    else isInteger = true;
                } else System.out.println(myScanner.next() + " is not a number!");
            } else System.out.println("Number " + number + " not found.");
        }
        return userInput;
    }

    static String messageToUser(String message) {
        String returnedMessage = message;
        return returnedMessage;
    }


    public static void main(String[] args) {
        while (true) {
            int trial = 1;
            int number = randomNumberInInterval();
            while (trial != 8) {
                int guess = readUserInput();
                String message = "Which number from the range 1 to 100 was chosen?";
                if (guess != number) trial++;
                System.out.println(message);
            }
            System.out.println("You have exceeded the limit");
        }
    }
}
