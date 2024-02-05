import java.util.Scanner;

// A factory that creates a 'UnsafeCropOperation' object.
//
public class UnsafeCropFactory implements UnsafeFactory {

    //TODO: declare variables (if needed).

    @Override
    // Returns a new 'UnsafeCropOperation' object. The 'width' and 'height' parameters of the
    // returned object are provided by the scanner object 'sc'.
    public UnsafeOperation create(Scanner sc) {

        int width = sc.nextInt();
        int height = sc.nextInt();
        return new UnsafeCropOperation(width, height);
    }
}
