import java.awt.*;


// This class represents a 2D raster of RGB color entries. The class uses
// the class 'aufgabe1.SimpleDataBufferInt' to store the entries.
public class SimpleRasterRGB {

    private final int width;
    private final int height;
    private SimpleDataBufferInt simpleDataBufferInt;

    // Initialises this raster of the specified size with
    // all pixels being black, i.e. (R,G,B) = (0,0,0).
    // Preconditions: height > 0, width > 0
    public SimpleRasterRGB(int width, int height) {
        this.width = width;
        this.height = height;
        this.simpleDataBufferInt = new SimpleDataBufferInt(6, width * height);
    }

    public SimpleRasterRGB(int width, int height, SimpleDataBufferInt simpleDataBufferInt) {
        this.width = width;
        this.height = height;
        this.simpleDataBufferInt = simpleDataBufferInt;
    }

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

    // Returns the color of the specified pixel.
    // Precondition: (x,y) is a valid coordinate of the raster
    public Color getPixelColor(int x, int y) {

        return new Color(this.simpleDataBufferInt.getElem(0, y * this.getWidth() + x),
                this.simpleDataBufferInt.getElem(1, y * this.getWidth() + x), this.simpleDataBufferInt.getElem(2,
                y * this.getWidth() + x));
    }

    // Sets the color of the specified pixel.
    // Precondition: (x,y) is a valid coordinate of the raster, color != null
    public void setPixelColor(int x, int y, Color color) {

        this.simpleDataBufferInt.setElem(0, y * this.getWidth() + x, color.getRed());
        this.simpleDataBufferInt.setElem(1, y * this.getWidth() + x, color.getGreen());
        this.simpleDataBufferInt.setElem(2, y * this.getWidth() + x, color.getBlue());
    }

    // Returns the result of convolution of 'this' with the specified filter kernel. 'this' is not
    // changed by the method call.
    // Precondition (needs to be checked):
    // filterKernel != 0 && filterKernel.length > 0 &&
    // filterKernel.length % 2 == 1 &&
    // filterKernel.length == filterKernel[0].length &&
    // filterKernel.length < this.getWidth() &&
    // filterKernel.length < this.getHeight().

    public SimpleRasterRGB convolve(double[][] filterKernel) {
        SimpleRasterRGB returnedSimpleRasterRGB = new SimpleRasterRGB(width, height);
        returnedSimpleRasterRGB.simpleDataBufferInt = new SimpleDataBufferInt(6, width * height);

        double[] temp_result;

        int filterSideLength = filterKernel.length / 2;
        for (int x = filterSideLength; x < returnedSimpleRasterRGB.width - filterSideLength; x++) {
            for (int y = filterSideLength; y < returnedSimpleRasterRGB.height - filterSideLength; y++) {
                //at every array position, compute filter result
                temp_result = new double[3];
                for (int xx = -filterSideLength; xx <= filterSideLength; xx++) {
                    for (int yy = -filterSideLength; yy <= filterSideLength; yy++) {
                        temp_result[0] += this.getPixelColor(x - xx, y - yy).getRed() * filterKernel[xx + filterSideLength][yy + filterSideLength];
                        temp_result[1] += this.getPixelColor(x - xx, y - yy).getGreen() * filterKernel[xx + filterSideLength][yy + filterSideLength];
                        temp_result[2] += this.getPixelColor(x - xx, y - yy).getBlue() * filterKernel[xx + filterSideLength][yy + filterSideLength];
                    }
                }

                returnedSimpleRasterRGB.simpleDataBufferInt.setElem(0, y * this.width + x, (int) temp_result[0]);
                returnedSimpleRasterRGB.simpleDataBufferInt.setElem(1, y * this.width + x, (int) temp_result[1]);
                returnedSimpleRasterRGB.simpleDataBufferInt.setElem(2, y * this.width + x, (int) temp_result[2]);
            }
        }

        return returnedSimpleRasterRGB;
    }

    public int getWidth() {

        return this.width;
    }

    public int getHeight() {

        return this.height;
    }

    public SimpleDataBufferInt getSimpleDataBufferInt() {
        return this.simpleDataBufferInt;
    }

    // Draws a line from (x1,y1) to (x2,y2) in the raster using the Bresenham algorithm.
    //Preconditions: (x1,y1) and (x2,y2) are valid coordinates of the raster, color != null
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

    public void swapChannel(int ch1, int ch2) {
        SimpleDataBufferInt copy = new SimpleDataBufferInt(6, height * width);
        // NOTE: wi haben hier vergessen die Reihe den Elemente zu tauschen in copy.setElem()
        //die Idee war erst die Channel Nummer dann Position in diesem Fall i und danach die Farbe simpleDataBufferInt.getElem(channel Nummer, Position i)

        for (int i = 0; i < width * height; i++) {
            copy.setElem(ch2, i, simpleDataBufferInt.getElem(ch1, i));
            copy.setElem(ch1, i, simpleDataBufferInt.getElem(ch2, i));

        }
        this.simpleDataBufferInt = copy;
    }
}
