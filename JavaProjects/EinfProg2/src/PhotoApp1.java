import codedraw.CodeDraw;
import java.awt.*;

public class PhotoApp1 {

    public static void main(String[] args) {
        SimpleRasterRGB simpleRasterRGB = new SimpleRasterRGB(40,60);

        simpleRasterRGB.drawLine(0, 1, 35, 9, new Color(20, 25, 250));
        simpleRasterRGB.drawLine(30, 5, 0, 30, Color.ORANGE);
        simpleRasterRGB.drawLine(2, 0, 7, 40, Color.GREEN);
        simpleRasterRGB.drawLine(0, 0, 0, 60, Color.RED);
        draw(simpleRasterRGB);

        draw(simpleRasterRGB.convolve(new double[][]{
                {0.11, 0.13, 0.11},
                {0.11, 0.07, 0.11},
                {0.11, 0.13, 0.11}
        }));

        simpleRasterRGB.swapChannel(0, 1);
        draw(simpleRasterRGB);
    }

    // Draws the image with fixed pixel size in a new window.
    public static void draw(SimpleRasterRGB simpleRasterRGB) {
        int cellSize = 10;
        CodeDraw cd = new CodeDraw(simpleRasterRGB.getWidth() * cellSize, simpleRasterRGB.getHeight() * cellSize);

        // draw a square of size 'cellSize' for each pixel
        for (int j = 0; j < simpleRasterRGB.getHeight(); j++) {
            for (int i = 0; i < simpleRasterRGB.getWidth(); i++) {
                int x = i * cellSize;
                int y = j * cellSize;
                cd.setColor(simpleRasterRGB.getPixelColor(i, j));
                cd.fillSquare(x, y, cellSize);
            }
        }
        cd.show();
    }
}
