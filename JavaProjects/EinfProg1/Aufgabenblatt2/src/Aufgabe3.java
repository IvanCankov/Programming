import java.io.IOException;
import java.util.Scanner;

public class Aufgabe3 {

    private static boolean isHappyNumber(int number) {
        String intToText = String.valueOf(number);
        int digitSum = 0;
        int sumNum = 0;
        int localNumber;

        if (number != 0) {
            while (sumNum != 4 && digitSum != 1){
                int localSum = 0;
                digitSum = 0;
                for (int i = 0; i < intToText.length(); i++) {
                    localNumber = Character.digit(intToText.charAt(i), 10);
                    localSum += Math.pow(localNumber, 2);
                    digitSum += localNumber;
                }
                intToText = String.valueOf(localSum);
                sumNum = localSum;
            }
        }
        return sumNum == 1; //I seriously don't have any clue how to make this shoter help
    }

    private static int countHappyNumbers(int start, int end) {
        int count = 0;
        if (start > 0 && end > 0 && start <= end) {
            for (int i = start; i < end; i++) {
                if (isHappyNumber(i)) count++;
            }
        }
        return count;
    }

    private static void printHappyNumbers(int start, int end) {
        if (start > 0 && end > 0 && start <= end) {
            for (int i = start; i < end; i++) {
            if (isHappyNumber(i)) System.out.println(i + " --> " + isHappyNumber(i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a start value: ");
        int start = input.nextInt();
        System.out.print("Please enter an end value: ");
        int end = input.nextInt();

        System.out.println("Please wait until we process your input.\nThis may take a few minutes...");
        System.out.println("The number of happy numbers between" + start +", " + end +
                            " is: " + countHappyNumbers(start, end));
        printHappyNumbers(start, end);
    }
}
