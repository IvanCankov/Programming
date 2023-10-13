import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Field field = new Field(21, 21, 5, 2);
        field.printHillAndFoodSources();
        field.printAnts();
        field.update();
        field.update();
        field.update();
        field.update();
        field.printAnts();
    }
}

enum State {
    ERKUNDUNG,
    SUCHE,
    BRINGT
}