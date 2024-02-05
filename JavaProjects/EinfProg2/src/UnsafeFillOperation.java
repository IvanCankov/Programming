import java.awt.*;

// This class represents a flood fill operation. More specifically, it allows to set the area of
// contiguous pixels of the same color to a specified color, starting from an initial position and
// using 4-neighborhood.
//
public class UnsafeFillOperation implements UnsafeOperation {


    private final int myX;

    private final int myY;

    private final Color[] myColor;

    public UnsafeFillOperation(int x, int y, Color[] color) {
        this.myX = x;
        this.myY = y;
        this.myColor = color;
    }

    public int getMyX() {
        return myX;
    }

    public int getMyY() {
        return myY;
    }

    public Color getMyColor() {
        return myColor[0];
    }

    // Sets the area of contiguous pixels of the same color to the specified color 'color', starting from
    // the initial pixel with position (x,y) and using 4-neighborhood. The method is not
    // recursive, instead it internally uses an object of 'SimplePointQueue' to which unprocessed
    // neighboring positions of the current position are added (the queue stores positions
    // that are still waiting to be processed).
    // 'floodFill' does nothing if the pixel at position (x,y) already has color 'color'.
    // Preconditions: (x,y) are valid coordinates of the raster, color != null.
    public RasterizedRGB execute(RasterizedRGB raster) {

        // alternatively you can implement the floodfill method in RasterizedRGB
        // and then just write raster.floodfill(myX,myY, myColor);
        Point starPoint = new Point(this.getMyX(), this.getMyY());
        Color startColor = raster.getPixelColor(this.getMyX(), this.getMyY());
        if (startColor.equals(this.myColor)) {
            return raster;
        }

        SimplePointQueue queue = new SimplePointQueue(2);
        queue.add(starPoint);

        while (queue.peek() != null) {

            Point toBeCompared = queue.poll();
            int xValue = toBeCompared.x();
            int yValue = toBeCompared.y();

            if (raster.getPixelColor(xValue, yValue).equals(startColor)) {
                raster.setPixelColor(xValue, yValue, this.getMyColor());

                if (xValue > 0) {
                    queue.add(new Point(xValue - 1, yValue));
                }
                if (xValue < raster.getWidth() - 1) {
                    queue.add(new Point(xValue + 1, yValue));
                }
                if (yValue > 0) {
                    queue.add(new Point(xValue, yValue - 1));
                }
                if (yValue < raster.getHeight() - 1) {
                    queue.add(new Point(xValue, yValue + 1));
                }
            }

        }

        return raster;
    }
}
