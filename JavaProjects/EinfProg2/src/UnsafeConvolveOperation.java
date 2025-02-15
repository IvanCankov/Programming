// This class represents a convolution operation.
public class UnsafeConvolveOperation implements UnsafeOperation {

    private final double[][] filterkernel;

    // Initializes this convolution operation with the specified filter kernel.
    // Precondition:
    // filterKernel != null && filterKernel.length > 0 &&
    // filterKernel.length % 2 == 1 &&
    // filterKernel.length == filterKernel[i].length (for valid i).
    public UnsafeConvolveOperation(double[][] filterKernel) {

        this.filterkernel = filterKernel;
    }

    // Returns the filter kernel of this convolution operation.
    public double[][] getKernel() {

        return this.filterkernel;
    }

    @Override
    // Executes the convolution of 'raster' with the filter kernel getKernel().
    // The specified object is directly modified by this method call.
    // The returned raster is identical to the specified 'raster'.
    // Precondition:
    // filterKernel.length < raster.getWidth() &&
    // filterKernel.length < raster.getHeight().
    public RasterizedRGB execute(RasterizedRGB raster) {

        raster.convolve(this.getKernel());
        return raster;
    }
}
