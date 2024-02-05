// This class represents an operation creating a new top-most layer.
//
public class UnsafeNewLayerOperation implements UnsafeOperation {

    @Override
    public RasterizedRGB execute(RasterizedRGB raster) {

        return ((Layered) raster).newLayer();
    }
}
