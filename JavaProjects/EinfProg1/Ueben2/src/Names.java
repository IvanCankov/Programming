import java.util.Scanner;

public class Names {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben Sie Ihren vollständigen Namen ein:");
        String input = scanner.nextLine().trim();

        int firstIndex = input.indexOf(' ');
        int lastIndex = input.lastIndexOf(' ');

        if (firstIndex != -1) {
            if (firstIndex != lastIndex) {
                String firstName = input.substring(0, firstIndex);
                if (firstName.length() < 6) {
                    System.out.println(input.substring(lastIndex + 1) + ", " + input.substring(0, firstIndex) +
                            " " + input.charAt(firstIndex + 1) + ".");
                } else System.out.println(input.substring(lastIndex + 1) + ", " + input.charAt(0) + '.' + " " +
                        input.charAt(firstIndex + 1) + ".");
            } else System.out.println(input.substring(firstIndex + 1) + ", " + input.substring(0, firstIndex));
        } else System.out.println("FEHLER! Kein vollständiger Name eingegeben");
    }
}

//        if (firstIndex == -1) {
//            System.out.println("FEHLER! Kein vollständiger Name eingegeben");
//        } else if (firstIndex == lastIndex) {
//            System.out.println(input.substring(firstIndex + 1) + ", " + input.substring(0, firstIndex));
//        } else if (firstIndex > 6) {
//                System.out.println(input.substring(lastIndex + 1) + ", " + input.charAt(0) + '.' +
//                        " " + input.charAt(firstIndex + 1) + ".");
//        } else {
//                System.out.println(input.substring(lastIndex + 1) + ", " + input.substring(0, firstIndex) +
//                        " " + input.charAt(firstIndex + 1) + ".");}}}


