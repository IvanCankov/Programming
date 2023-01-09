import java.util.Scanner;

public class Ass {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int number = (int) (Math.random() * 100) + 1;
        int guess = 0;
        int trial = 1;
        String message = "Which number from the range 1 to 100 was chosen?";
        while (guess != number) {
            System.out.println(message);
            System.out.println("Try#: " + trial);
            if (myScanner.hasNext()) {
                if (myScanner.hasNextInt()) {
                    guess = myScanner.nextInt();
                    message = guess + (guess < number ? " is too small." : (guess > number ? " is too large." : " Congratulation!"));
                } else {
                    message = myScanner.next() + " is not a number!";
                }
            } else {
                message = "Number " + number + " not found.";
                guess = number; // Alternativ hier break;
            }
            trial++;
        }
        System.out.println(message);
    }
}
