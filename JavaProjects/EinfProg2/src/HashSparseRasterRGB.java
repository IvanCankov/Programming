import java.awt.*;

// This class represents a sparse 2D raster of RGB color entries.
//
// This class is efficient for representing images where only a small fraction of pixels is
// non-empty, meaning they have a color different from (0,0,0) corresponding to Color.BLACK.
// The class uses internally an object of 'HashPointColorMap' to associate each non-empty
// pixel position (x,y) to the corresponding color. Only pixels with non-zero values are stored.
// Positions that are not in the set of keys of the map are considered to have value (0,0,0).
//
public class HashSparseRasterRGB implements RasterizedRGB {

    private int width;
    private int height;
    private HashPointColorMap map;

    // Initialises this raster of the specified size as an empty
    // raster (all pixels being black, i.e. (R,G,B) = (0,0,0)).
    // Preconditions: height > 0, width > 0
    public HashSparseRasterRGB(int width, int height) {

        this.width = width;
        this.height = height;
        this.map = new HashPointColorMap();
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

        if (color.equals(Color.BLACK)) {
            return;
        }
        Point coordinates = new Point(x, y);
        this.map.put(coordinates, color);
    }

    // Returns the width of this raster.
    public int getWidth() {

        return this.width;
    }

    // Returns the height of this raster.
    public int getHeight() {

        return this.height;
    }

    // Performs the convolution of 'this' with the specified filter kernel. 'this' is the result of
    // the operation.
    // The implementation of this method exploits the sparse structure of the raster by
    // calculating the convolution only at non-empty pixel positions.
    // Preconditions:
    // filterKernel != null && filterKernel.length > 0 &&
    // filterKernel.length % 2 == 1 &&
    // filterKernel.length == filterKernel[i].length (for valid i) &&
    // filterKernel.length < this.getWidth() &&
    // filterKernel.length < this.getHeight().
    public void convolve(double[][] filterKernel) {

        HashPointColorMap result = new HashPointColorMap();

        double[] temp_result;

        int filterSideLength = filterKernel.length / 2;
        for (int x = filterSideLength; x < this.width - filterSideLength; x++) {
            for (int y = filterSideLength; y < this.height - filterSideLength; y++) {

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

                    result.put(new Point(x, y), newColour);
                }
            }
        }

        this.map = result;

    }

    // Crops 'this' to the rectangular region with upper left coordinates (0,0)
    // and lower right coordinates (width-1, height-1).
    // Precondition: width <= this.getWidth() && height <= this.getHeight().
    public void crop(int width, int height) {

        SimplePointQueue list = this.map.keys();
        HashPointColorMap result = new HashPointColorMap();
        this.width = width;
        this.height = height;
        for (Point currentPoint = list.peek(); currentPoint != null; currentPoint = list.poll()) {
            if (currentPoint.x() <= this.width && currentPoint.y() <= this.height) {
                result.put(currentPoint, this.map.get(currentPoint));
            }
        }
        this.map = result;
    }

}
