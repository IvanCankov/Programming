import codedraw.CodeDraw;
import java.awt.*;

public class PhotoApp2 {

    public static void main(String[] args) {

        SimpleSparseRasterRGB simpleSparseRasterRGB = new SimpleSparseRasterRGB(40, 60);
        simpleSparseRasterRGB.drawLine(0, 1, 35, 9, new Color(20, 25, 250));
        simpleSparseRasterRGB.drawLine(30, 5, 0, 30, Color.ORANGE);
        simpleSparseRasterRGB.drawLine(2, 0, 7, 40, Color.GREEN);
        simpleSparseRasterRGB.floodFill(4, 3, Color.CYAN);
        draw(simpleSparseRasterRGB);
        SimpleSparseRasterRGB simpleSparseRasterRGBFilledConvolved =
                simpleSparseRasterRGB.convolve(new double[][]{
                        {0.077847, 0.123317, 0.077847},
                        {0.123317, 0.195346, 0.123317},
                        {0.077847, 0.123317, 0.077847}
                });
        draw(simpleSparseRasterRGBFilledConvolved);
        simpleSparseRasterRGBFilledConvolved.floodFill(7, 7, null);
        draw(simpleSparseRasterRGBFilledConvolved);
    }

    // Draws the image (specified by a sparse raster) with fixed pixel size in a new window.
    // Precondition: raster != null.
    public static void draw(SimpleSparseRasterRGB raster) {

        int cellSize = 10;
        CodeDraw cd = new CodeDraw(raster.getWidth() * cellSize, raster.getHeight() * cellSize);

        // draw a square of size 'cellSize' for each pixel
        for (int j = 0; j < raster.getHeight(); j++) {
            for (int i = 0; i < raster.getWidth(); i++) {
                int x = i * cellSize;
                int y = j * cellSize;
                cd.setColor(raster.getPixelColor(i, j));
                cd.fillSquare(x, y, cellSize);
            }
        }
        cd.show();
    }
}
