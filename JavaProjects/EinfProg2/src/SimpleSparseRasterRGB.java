import java.awt.*;

// This class represents a sparse 2D raster of RGB color entries. It has the same functionality
// as the class 'SimpleRasterRGB', but its implementation differs. It additionally has a
// flood-fill method.
//
// This class is efficient for representing images where only a small fraction of pixels is
// non-empty, meaning they have a color different from (0,0,0) corresponding to Color.BLACK.
// The class uses internally an object of 'SimplePointColorMap' to associate each non-empty
// pixel position (x,y) to the corresponding color. Only pixels with non-zero values are stored.
// Positions that are not in the set of keys of the map are considered to have value (0,0,0).
//
public class SimpleSparseRasterRGB {

    private final int width;
    private final int height;
    private final SimplePointColorMap map;


    // Initialises this raster of the specified size as an empty
    // raster (all pixels being black, i.e. (R,G,B) = (0,0,0)).
    // Preconditions: height > 0, width > 0
    public SimpleSparseRasterRGB(int width, int height) {

        this.width = width;
        this.height = height;
        this.map = new SimplePointColorMap(this.width * this.height);
    }


    // Returns the color of the specified pixel.
    // Preconditions: (x,y) is a valid coordinate of the raster
    public Color getPixelColor(int x, int y) {

        Point coordinates = new Point(x, y);

        if (map.get(coordinates) == null) {

            return Color.BLACK;
        }
        return map.get(coordinates);
    }

    // Sets the color of the specified pixel. (If 'color' is 'Color.BLACK', the method
    // ensures that the pixel is not contained in the internal map.)
    // Preconditions: (x,y) is a valid coordinate of the raster, color != null
    public void setPixelColor(int x, int y, Color color) {

        Point coordinates = new Point(x, y);
        this.map.put(coordinates, color);
    }

    // Returns the result of convolution of 'this' with the specified filter kernel. 'this' is not
    // changed by the method call.
    // The implementation of this method exploits the sparse structure of the raster by
    // calculating the convolution only at non-empty pixel positions.
    // Preconditions:
    // filterKernel != null && filterKernel.length > 0 &&
    // filterKernel.length % 2 == 1 &&
    // filterKernel.length == filterKernel[i].length (for valid i) &&
    // filterKernel.length < this.getWidth() &&
    // filterKernel.length < this.getHeight().
    public SimpleSparseRasterRGB convolve(double[][] filterKernel) {

        SimpleSparseRasterRGB result = new SimpleSparseRasterRGB(width, height);

        double[] temp_result;

        int filterSideLength = filterKernel.length / 2;
        for (int x = filterSideLength; x < result.width - filterSideLength; x++) {
            for (int y = filterSideLength; y < result.height - filterSideLength; y++) {

                // looking if the adjacent colours are not black
                boolean adjacentAreNotBlack = false;

                for (int xx = -filterSideLength; xx <= filterSideLength; xx++) {
                    for (int yy = -filterSideLength; yy <= filterSideLength; yy++) {

                        Color adjacdntColour = this.getPixelColor(x - xx, y - yy);

                        if (adjacdntColour != null) {
                            adjacentAreNotBlack = true;
                            break;
                        }
                    }
                    if (adjacentAreNotBlack) {
                        break;
                    }
                }

                if (adjacentAreNotBlack) {
                    // Apply the convolution to the current pixel
                    temp_result = new double[3];
                    for (int xx = -filterSideLength; xx <= filterSideLength; xx++) {
                        for (int yy = -filterSideLength; yy <= filterSideLength; yy++) {
                            Color neighborColor = this.getPixelColor(x - xx, y - yy);
                            if (neighborColor != null) {
                                temp_result[0] += neighborColor.getRed() * filterKernel[xx + filterSideLength][yy + filterSideLength];
                                temp_result[1] += neighborColor.getGreen() * filterKernel[xx + filterSideLength][yy + filterSideLength];
                                temp_result[2] += neighborColor.getBlue() * filterKernel[xx + filterSideLength][yy + filterSideLength];
                            }
                        }
                    }
                    Color newColour = new Color(
                            (int) temp_result[0],
                            (int) temp_result[1],
                            (int) temp_result[2]);

                    result.setPixelColor(x, y, newColour);
                }
            }
        }
        return result;
    }

    // Returns the width of this raster.
    public int getWidth() {

        // TODO: implement method.
        return this.width;
    }

    // Returns the height of this raster.
    public int getHeight() {

        // TODO: implement method.
        return this.height;
    }

    // Sets the area of contiguous pixels of the same color to the specified color 'color', starting from
    // the initial pixel with position (x,y) and using 4-neighborhood. The method is not
    // recursive, instead it internally uses an object of 'SimplePointQueue' to which unprocessed
    // neighboring positions of the current position are added (the queue stores positions
    // that are still waiting to be processed).
    // 'floodFill' does nothing if the pixel at position (x,y) already has color 'color'.
    // Preconditions: (x,y) are valid coordinates of the raster, color != null.
    public void floodFill(int x, int y, Color color) {

        Color startColor = getPixelColor(x, y);
        if (startColor.equals(color)) {
            return;
        }

        SimplePointQueue queue = new SimplePointQueue(2);
        queue.add(new Point(x, y));

        while (queue.peek() != null) {

            Point toBeCompared = queue.poll();
            int xValue = toBeCompared.x();
            int yValue = toBeCompared.y();

            if (getPixelColor(xValue, yValue).equals(startColor)) {
                setPixelColor(xValue, yValue, color);

                if (xValue > 0) {
                    queue.add(new Point(xValue - 1, yValue));
                }
                if (xValue < width - 1) {
                    queue.add(new Point(xValue + 1, yValue));
                }
                if (yValue > 0) {
                    queue.add(new Point(xValue, yValue - 1));
                }
                if (yValue < height - 1) {
                    queue.add(new Point(xValue, yValue + 1));
                }
            }

        }
    }

    // Draws a line from (x1,y1) to (x2,y2) in the raster using the Bresenham algorithm.
    // Preconditions:
    // (x1,y1) and (x2,y2) are valid coordinates of the raster, color != null.
    public void drawLine(int x1, int y1, int x2, int y2, Color color) {

        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;

        while (x1 != x2 || y1 != y2) {
            this.setPixelColor(x1, y1, color);

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
    }

}
