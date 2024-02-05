import codedraw.CodeDraw;

import java.awt.*;

public class PhotoApp1 {

    public static void main(String[] args) {

        SimpleRasterRGB objekt = new SimpleRasterRGB(40, 60);
        // TODO: change this method according to 'Aufgabenblatt1.md'.
        objekt.drawLine(0, 1, 35, 9, new Color(20, 25, 250));
        objekt.drawLine(30, 5, 0, 30, Color.ORANGE);
        objekt.drawLine(2, 0, 7, 40, Color.GREEN);
        draw(objekt);


        SimpleRasterRGB s = objekt.convolve(new double[][]{
                {0.077847, 0.123317, 0.077847},
                {0.123317, 0.195346, 0.123317},
                {0.077847, 0.123317, 0.077847}
        });


        draw(s);

    }

    // Draws the image with fixed pixel size in a new window.
    public static void draw(SimpleRasterRGB o) {

        // TODO: change this method according to 'Aufgabenblatt1.md'.
        int cellSize = 10;


        CodeDraw cd = new CodeDraw(o.getWidth() * cellSize, o.getHeight() * cellSize);

        // draw a square of size 'cellSize' for each pixel
        for (int j = 0; j < o.getHeight(); j++) {
            for (int i = 0; i < o.getWidth(); i++) {
                int x = i * cellSize;
                int y = j * cellSize;
                cd.setColor(o.getPixelColor(i, j));
                cd.fillSquare(x, y, cellSize);
            }
        }
        cd.show();


    }
}
