import java.awt.*;


// This class represents a 2D raster of RGB color entries. The class uses
// the class 'SimpleDataBufferInt' to store the entries.
public class SimpleRasterRGB {
    private int width = 40;
    private int height = 60;

    private SimpleDataBufferInt storage = new SimpleDataBufferInt(6, this.height * this.width);

    // Initialises this raster of the specified size with
    // all pixels being black, i.e. (R,G,B) = (0,0,0).
    // Preconditions: height > 0, width > 0
    public SimpleRasterRGB(int width, int height) {

        this.width = width;
        this.height = height;
        this.storage = new SimpleDataBufferInt(6, this.height * this.width);
    }

    public SimpleRasterRGB createSimpleRasterRGB(SimpleRasterRGB o) {
        return new SimpleRasterRGB(o.getWidth(), o.getHeight());
    }

    // Returns the color of the specified pixel.
    // Precondition: (x,y) is a valid coordinate of the raster
    public Color getPixelColor(int x, int y) {

        // TODO: modify method to become an object method (not static).
        return new Color(
                this.storage.getElem(0, y * this.width + x),
                this.storage.getElem(1, y * this.width + x),
                this.storage.getElem(2, y * this.width + x)
        );
    }

    // Sets the color of the specified pixel.
    // Precondition: (x,y) is a valid coordinate of the raster, color != null
    public void setPixelColor(int x, int y, Color color) {

        // TODO: modify method to become an object method (not static).
        this.storage.setElem(0, y * this.width + x, color.getRed());
        this.storage.setElem(1, y * this.width + x, color.getGreen());
        this.storage.setElem(2, y * this.width + x, color.getBlue());
    }


    // Returns the result of convolution of 'this' with the specified filter kernel. 'this' is not
    // changed by the method call.
    // Precondition (needs not to be checked):

    // filterKernel != 0 && filterKernel.length > 0 &&
    // filterKernel.length % 2 == 1 &&
    // filterKernel.length == filterKernel[0].length &&
    // filterKernel.length < this.getWidth() &&
    // filterKernel.length < this.getHeight().
    public SimpleRasterRGB convolve(double[][] filterKernel) {

        double[] temp_result;

        SimpleRasterRGB copy = createSimpleRasterRGB(this);


        int filterSideLength = filterKernel.length / 2;
        for (int x = filterSideLength; x < this.width - filterSideLength; x++) {
            for (int y = filterSideLength; y < this.height - filterSideLength; y++) {
                //at every array position, compute filter result
                temp_result = new double[3];
                for (int xx = -filterSideLength; xx <= filterSideLength; xx++) {
                    for (int yy = -filterSideLength; yy <= filterSideLength; yy++) {
                        temp_result[0] += this.getPixelColor(x - xx, y - yy).getRed() * filterKernel[xx + filterSideLength][yy + filterSideLength];
                        temp_result[1] += this.getPixelColor(x - xx, y - yy).getGreen() * filterKernel[xx + filterSideLength][yy + filterSideLength];
                        temp_result[2] += this.getPixelColor(x - xx, y - yy).getBlue() * filterKernel[xx + filterSideLength][yy + filterSideLength];
                    }
                }

                copy.storage.setElem(3, y * copy.width + x, (int) temp_result[0]);
                copy.storage.setElem(4, y * copy.width + x, (int) temp_result[1]);
                copy.storage.setElem(5, y * copy.width + x, (int) temp_result[2]);
            }
        }

        /*
        SimpleDataBufferInt.data[0] = SimpleDataBufferInt.data[3];
        SimpleDataBufferInt.data[1] = SimpleDataBufferInt.data[4];
        SimpleDataBufferInt.data[2] = SimpleDataBufferInt.data[5];
         */
        copy.storage.setRow(0, copy.storage.getRow(3));
        copy.storage.setRow(1, copy.storage.getRow(4));
        copy.storage.setRow(2, copy.storage.getRow(5));


        return copy;
    }


    // bleibt statisch
    // Returns the result of convolution of the specified raster 'toBeFiltered' with the specified
    // filter kernel 'filterKernel'.
    // Precondition (needs not be checked):
    // filterKernel != null && filterKernel.length > 0 &&
    // filterKernel.length % 2 == 1 &&
    // filterKernel.length == filterKernel[0].length &&
    // filterKernel.length < this.getWidth() &&
    // filterKernel.length < this.getHeight().
    public static SimpleRasterRGB convolve(SimpleRasterRGB toBeFiltered, double[][] filterKernel) {

        return toBeFiltered.convolve(filterKernel);

    }

    /*
    // TODO: remove following method.

    // Returns the result of convolution of the RGB raster with pixel data stored in the first
    // three rows of SimpleDataBufferInt.data with the specified filter kernel (see
    // https://de.wikipedia.org/wiki/Faltungsmatrix).
    // The method assumes that the pixel (x,y) of the raster is stored at position
    // [component][y*SimpleRasterRGB.width+x] in the data buffer array, where
    // the data bank index 'component' is 0,1 and 2 for the red, green and blue component
    // respectively.
    // The method uses 3 additional data banks with indices 3 to 5 for calculations.
    // Precondition (needs not be checked):
    // SimpleDataBufferInt.data.length >= 6 &&
    // SimpleDataBufferInt.data[i].length >= SimpleRasterRGB.width * SimpleRasterRGB.height for
    // valid i.
    // filterKernel != null && filterKernel.length > 0 &&
    // filterKernel.length % 2 == 1 &&
    // filterKernel.length == filterKernel[0].length &&
    // filterKernel.length < SimpleRasterRGB.width &&
    // filterKernel.length < SimpleRasterRGB.height.
    public static void convolve(double[][] filterKernel) {

        double[] temp_result;

        int filterSideLength = filterKernel.length / 2;
        for (int x = filterSideLength; x < SimpleRasterRGB.width - filterSideLength; x++) {
            for (int y = filterSideLength; y < SimpleRasterRGB.height - filterSideLength; y++) {
                //at every array position, compute filter result
                temp_result = new double[3];
                for (int xx = -filterSideLength; xx <= filterSideLength; xx++) {
                    for (int yy = -filterSideLength; yy <= filterSideLength; yy++) {
                        temp_result[0] += SimpleRasterRGB.getPixelColor(x - xx, y - yy).getRed() * filterKernel[xx + filterSideLength][yy + filterSideLength];
                        temp_result[1] += SimpleRasterRGB.getPixelColor(x - xx, y - yy).getGreen() * filterKernel[xx + filterSideLength][yy + filterSideLength];
                        temp_result[2] += SimpleRasterRGB.getPixelColor(x - xx, y - yy).getBlue() * filterKernel[xx + filterSideLength][yy + filterSideLength];
                    }
                }

                SimpleDataBufferInt.setElem(3, y * SimpleRasterRGB.width + x, (int) temp_result[0]);
                SimpleDataBufferInt.setElem(4, y * SimpleRasterRGB.width + x, (int) temp_result[1]);
                SimpleDataBufferInt.setElem(5, y * SimpleRasterRGB.width + x, (int) temp_result[2]);
            }
        }
        SimpleDataBufferInt.data[0] = SimpleDataBufferInt.data[3];
        SimpleDataBufferInt.data[1] = SimpleDataBufferInt.data[4];
        SimpleDataBufferInt.data[2] = SimpleDataBufferInt.data[5];
    }


     */

    // Returns the width of this raster.
    public int getWidth() {

        return this.width;
    }

    // Returns the height of this raster.
    public int getHeight() {

        return this.height;
    }

    // Returns a mapping from all width*height pixel positions (Point) to corresponding colors
    // (Color) of the pixels. Values of color (0,0,0) are also included in the mapping.
    public TreePointColorMap asMap() {

        TreePointColorMap result = new TreePointColorMap();
        for (int x = 0; x < this.getWidth(); x++) {
            for (int y = 0; y < this.getHeight(); y++) {
                result.put(new Point(x, y), this.getPixelColor(x, y));
            }
        }
        return result;
    }


    public SimpleDataBufferInt getStorage() {
        return this.storage;
    }

    // Draws a line from (x1,y1) to (x2,y2) in the raster using the Bresenham algorithm.
    //Preconditions: (x1,y1) and (x2,y2) are valid coordinates of the raster, color != null
    public void drawLine(int x1, int y1, int x2, int y2, Color color) {

        // TODO: modify method to become an object method (not static) operating on 'this'.
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
