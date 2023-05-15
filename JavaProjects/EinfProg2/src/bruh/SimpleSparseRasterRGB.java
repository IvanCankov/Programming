import java.awt.*;

// This class represents a sparse 2D raster of RGB color entries. It has the same functionality
// as the class 'SimpleRasterRGB', but its implementation differs. It additionally has a
// flood-fill method.
//
// This class is efficient for representing images where only a small fraction of pixels is
// non-empty, meaning they have a color different from (0,0,0) corresponding to Color.BLACK.
// The class uses internally an object of 'Aufgabe2.SimplePointColorMap' to associate each non-empty
// pixel position (x,y) to the corresponding color. Only pixels with non-zero values are stored.
// Positions that are not in the set of keys of the map are considered to have value (0,0,0).
//
public class SimpleSparseRasterRGB {

    private int width;
    private int height;
    private SimplePointColorMap map;

    public SimpleSparseRasterRGB(int width, int height) {

        this.width = width;
        this.height = height;
        this.map = new SimplePointColorMap(width*height);
    }

    public int getWidth() {

        return this.width;
    }

    public int getHeight() {

        return this.height;
    }

    public Color getPixelColor(int x, int y) {

        Point point = new Point(x,y);
        if (map.get(point) == null) {
            return Color.BLACK;
        }
        return map.get(point);
    }

    public void setPixelColor(int x, int y, Color color) {
        if(color != Color.BLACK) {
            Point point = new Point(x,y);
            map.put(point, color);
        }
    }

    public SimpleSparseRasterRGB convolve(double[][] filterKernel) {
        SimpleSparseRasterRGB returnedSimpleRasterRGB = new SimpleSparseRasterRGB(width, height);

        double[] temp_result;

        int filterSideLength = filterKernel.length / 2;
        for (int x = filterSideLength; x < returnedSimpleRasterRGB.width - filterSideLength; x++) {
            for (int y = filterSideLength; y < returnedSimpleRasterRGB.height - filterSideLength; y++) {
                temp_result = new double[3];
                for (int xx = -filterSideLength; xx <= filterSideLength; xx++) {
                    for (int yy = -filterSideLength; yy <= filterSideLength; yy++) {
                        temp_result[0] += this.getPixelColor(x - xx, y - yy).getRed() * filterKernel[xx + filterSideLength][yy + filterSideLength];
                        temp_result[1] += this.getPixelColor(x - xx, y - yy).getGreen() * filterKernel[xx + filterSideLength][yy + filterSideLength];
                        temp_result[2] += this.getPixelColor(x - xx, y - yy).getBlue() * filterKernel[xx + filterSideLength][yy + filterSideLength];
                    }
                    Color result = new Color((int) temp_result[0], (int)temp_result[1], (int)temp_result[2]);
                    returnedSimpleRasterRGB.setPixelColor(x,y,result);
                }
            }
        }

        return returnedSimpleRasterRGB;
    }

    // Sets the area of contiguous pixels of the same color to the specified color 'color', starting from
    // the initial pixel with position (x,y) and using 4-neighborhood. The method is not
    // recursive, instead it internally uses an object of 'Aufgabe2.SimplePointQueue' to which unprocessed
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

        while (queue.size() > 0) {
            Point current = queue.poll();
            int currentX = current.getX();
            int currentY = current.getY();

            if (getPixelColor(currentX, currentY).equals(startColor)) {
                setPixelColor(currentX, currentY, color);

                if (currentX > 0) {
                    queue.add(new Point(currentX - 1, currentY));
                }
                if (currentX < width - 1) {
                    queue.add(new Point(currentX + 1, currentY));
                }
                if (currentY > 0) {
                    queue.add(new Point(currentX, currentY - 1));
                }
                if (currentY < height - 1) {
                    queue.add(new Point(currentX, currentY + 1));
                }
            }
        }
    }

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
