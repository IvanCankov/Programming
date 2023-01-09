import codedraw.*;

import java.awt.*;

public class TestCodeDraw {
    public static void main(String[] args) {
        //"Hello World!" einmal anders.
        int width = 400;
        int height = 400;
        int x = 0, x_start = -90;
        int squareX = 0;
        int squareY = 0;

        CodeDraw cd = new CodeDraw(width, height);
        int counter = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (counter % 2 == 0) cd.setColor(Color.WHITE);
                else cd.setColor(Color.BLACK);
                cd.fillSquare(squareX, squareY, 50);
                squareX += 50;
                counter++;
            }
            counter++;
            squareX = 0;
            squareY += 50;
        }

        squareX = 0;
        squareY = 0;
        counter = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (counter % 5 == 0) {
                    cd.setColor(Palette.GOLD);
                    cd.fillCircle(squareX + 25, squareY + 25, 12.5);
                }
                counter++;
                squareX += 50;
            }
            squareX = 0;
            squareY += 50;
        }
        cd.show();
    }
}

