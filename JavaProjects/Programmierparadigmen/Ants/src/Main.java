import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Field field = new Field(21, 21, 5, 2);
        field.printHillAndFoodSources();
        field.printAnts();
        for (int i = 0; i < 10000; i++) {
            field.update();
        }
        field.printAnts();
    }
}

enum State {
    ERKUNDUNG,
    SUCHE,
    BRINGT
}

record Position(int x, int y) {
    public Position add(Position add) {
        return new Position(
                this.x() + add.x(),
                this.y() + add.y()
        );
    }
};
record Dimension(int width, int height) {};


