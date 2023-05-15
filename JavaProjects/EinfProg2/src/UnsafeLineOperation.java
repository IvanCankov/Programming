import java.awt.*;
// This class represents a line operation. More specifically, it allows to draw a line into
// a raster.
//
public class UnsafeLineOperation implements UnsafeOperation {

    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private Color color;

    // Initialises this line operation with starting point (x1, y1) and endpoint (x2, y2)
    // and the color of the line.


    public UnsafeLineOperation(int x1, int y1, int x2, int y2, Color color) {

        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.color = color;
    }

    // Returns the starting point of this line operation.
    public Point getStart() {

        return new Point(this.x1, this.y1);
    }

    // Returns the end point of this line operation.
    public Point getEnd() {

        return new Point(this.x2, this.y2);
    }

    // Returns the color of this line operation.
    public Color getColor() {

        return this.color;
    }

    // Executes the operation. More specifically, this method draws the line with from
    // getStart() to getEnd() with color getColor() into the specified raster
    // using the Bresenham algorithm.
    // The specified object is directly modified by this method call.
    // The returned raster is identical to the specified 'raster'.
    // Precondition: getStart() and getEnd() are valid positions of 'raster'.
    @Override
    public RasterizedRGB execute(RasterizedRGB raster) {

        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;

        while (x1 != x2 || y1 != y2) {
            raster.setPixelColor(x1, y1, color);

            int err2 = 2 * err;
            if (err2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (err2 < dx) {
                err += dx;
                y1 += sy;
            }
        }
        raster.setPixelColor(x1, y1, color);
        return raster;
    }

}
