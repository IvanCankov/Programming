import java.awt.*;

// Represents a raster consisting of at least two layers.
//
public class MultiLayerRasterRGBA implements Layered, RasterizedRGBIterable //TODO: activate clause.
{

    private final int size;

    private final Layered myBackground;

    private final SingleLayer myForeGround;

    private int width;

    private int height;


    // Initializes 'this' with top-layer 'foreground' and 'background'.
    // Performs dynamic type checking of 'background'. If 'background' is an instance of 'Layered'
    // this constructor initializes 'this' with top-layer 'foreground' and layers of the
    // 'background'.
    // If 'background' is not an instance of 'Layered', 'background' is copied to a new object of
    // 'SingleLayer' which is then used to initialize the background.
    // Width and height of this raster is determined by width and height of the 'foreground'
    // raster.
    // Pixels that are not defined in the 'background' are assumed to have color (0,0,0,0).
    public MultiLayerRasterRGBA(SingleLayer foreground, RasterizedRGB background) {

        this.myForeGround = foreground;

        if (background instanceof Layered) {
            this.myBackground = (Layered) background;

        } else {
            TreeSparseRasterRGBA newBackground = new TreeSparseRasterRGBA(background.getWidth(), background.getHeight());
            background.copyTo(newBackground);
            this.myBackground = newBackground;

        }
        this.height = foreground.getHeight();
        this.width = foreground.getWidth();
        this.size = 1 + this.myBackground.numberOfLayers();
    }

    @Override
    public Layered newLayer() {
        return new MultiLayerRasterRGBA(new TreeSparseRasterRGBA(this.getWidth(), this.getHeight()), this);
    }

    @Override
    public int numberOfLayers() {
        return size;
    }

    @Override
    public SingleLayer getForeground() {
        return this.myForeGround;
    }

    @Override
    public Layered getBackground() {
        return this.myBackground;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public Color getPixelColor(int x, int y) {
        Color foreGroundColor = this.myForeGround.getPixelColor(x, y);
        Color backGroundColor = this.myBackground.getPixelColor(x, y);
        return RasterRGBA.over(foreGroundColor, backGroundColor);
    }



    @Override
    public void setPixelColor(int x, int y, Color color) {
        this.myForeGround.setPixelColor(x, y, color);
    }

    @Override
    public void convolve(double[][] filterKernel) {
        this.myForeGround.convolve(filterKernel);
    }

    @Override
    public void crop(int width, int height) {
        this.width = width;
        this.height = height;
        this.myForeGround.crop(width, height);
        this.myBackground.crop(width, height);
    }

    @Override
    public RasterizedRGBIterator iterator() {
        return new MyRasterizedRGBIterator(this.getForeground(), this.getBackground());
    }

    @Override
    public boolean allHaveColor(Color c) {

        boolean hasColor = false;

        for (RasterizedRGB layer : this) {
            for (int i = 0; i < layer.getHeight(); i++) {
                for (int j = 0; j < layer.getHeight(); j++) {
                    if (layer.getPixelColor(j, i) == c){
                        hasColor = true;
                        break;
                    }
                }
            }
           if (hasColor) hasColor = false;
           else return false;
        }
        return true;
    }
}

