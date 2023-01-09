import java.util.Scanner;

public class Calculation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int firstNumber = input.nextInt();
        int secondNumber = input.nextInt();
        String vari = "%s";
        int lengthOfFirst = String.valueOf(firstNumber).length();
        int lengthOfSecond = String.valueOf(secondNumber).length();
        int difference = 24 - (Math.abs(lengthOfFirst - lengthOfSecond)) - 1;
        vari += "%" + difference + "s%23s";

        System.out.format("%s%24s%24s", "Erste Zahl", "Zweite Zahl", "Dazu addiert");
        System.out.println();
        System.out.format(vari, firstNumber, secondNumber,"333");
    }
}
