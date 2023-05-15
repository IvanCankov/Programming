import java.awt.*;

// This class represents a flood fill operation. More specifically, it allows to set the area of
// contiguous pixels of the same color to a specified color, starting from an initial position and
// using 4-neighborhood.
//
public class UnsafeFillOperation implements UnsafeOperation {

    private int x;
    private int y;
    private Color color;

    public UnsafeFillOperation(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    // TODO: add method specification.
    public RasterizedRGB execute(RasterizedRGB raster) {

        if (!raster.getPixelColor(x, y).equals(color)) {
            SimplePointQueue queue = new SimplePointQueue(10);
            queue.add(new Point(x, y));
            Color oldColor = raster.getPixelColor(x, y);
            while (queue.size() > 0) {
                Point p = queue.poll();
                x = p.getX();
                y = p.getY();
                if (raster.getPixelColor(x, y).equals(oldColor)) {
                    raster.setPixelColor(x, y, color);
                    if (x < raster.getWidth() - 1 && raster.getPixelColor(x + 1, y).equals(oldColor)) queue.add(new Point(x + 1, y));
                    if (x > 0 && raster.getPixelColor(x - 1, y).equals(oldColor)) queue.add(new Point(x - 1, y));
                    if (y < raster.getHeight() - 1 && raster.getPixelColor(x, y + 1).equals(oldColor))
                        queue.add(new Point(x, y + 1));
                    if (y > 0 && raster.getPixelColor(x, y - 1).equals(oldColor)) queue.add(new Point(x, y - 1));
                }
            }
        }
        return raster;
    }
}
