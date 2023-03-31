import java.util.Scanner;

/*
    Aufgabe 3) Verschachtelte Schleifen
*/
public class Aufgabe3 {

    public static Scanner input = new Scanner(System.in);
    static int height;
    static int type;
    static String star = "*";
    static String space = " ";

    public static void main(String[] args) {
        System.out.print("Choose the height of the shape: ");
        height = input.nextInt();
        System.out.print("Choose the type of shape (1-3): ");
        type = input.nextInt();
        execute();
    }

    static void execute() {
        if (height > 1) {
            switch (type) {
                case 1: line(); break;
                case 2: triangle(); break;
                case 3: parallelogramm(); break;
                default:
                    System.out.println("Incorrect type.");;
            }
        }
        else System.out.println("Incorrect height");
    }

    static void line() {
        int trailingSpaces = height - 1;
        int leadingSpaces = 0;

        for (int i = 0; i < height; i++) {
            System.out.println(space.repeat(leadingSpaces) + star + space.repeat(trailingSpaces));
            trailingSpaces--;
            leadingSpaces++;
        }
    }

    static void triangle() {
        int leadingSpaces = height - 1;
        int leadingStars = 1;

        for (int i = 0; i < height; i++) {
            System.out.println(space.repeat(leadingSpaces) + star.repeat(leadingStars));
            leadingSpaces--;
            leadingStars++;
        }
    }

    static void parallelogramm () {
        int starCount = height;
        int leadingSpaces = 0;
        int trailingSpaces = height - 1;

        for (int i = 0; i < height; i++) {
            System.out.println(space.repeat(leadingSpaces) + star.repeat(starCount) + space.repeat(trailingSpaces));
            leadingSpaces++;
            trailingSpaces--;
        }
    }
}

