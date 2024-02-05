import javax.swing.*;

public class MyRasterizedRGBIterator implements RasterizedRGBIterator {

    SingleLayer myForeground;
    Layered myBackground;

    public MyRasterizedRGBIterator(SingleLayer foreground, Layered background) {
        this.myForeground = foreground;
        this.myBackground = background;
    }

    @Override
    public RasterizedRGB next() {
        if (this.hasNext()) {
            RasterizedRGB result = this.myForeground;
            this.myForeground = this.myBackground == null ? null : this.myBackground.getForeground();
            this.myBackground = this.myBackground == null ? null : this.myBackground.getBackground();
            return result;

        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return this.myForeground != null;
    }
}
