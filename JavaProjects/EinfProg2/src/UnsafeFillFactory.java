import java.awt.*;
import java.util.Scanner;

// A factory that creates a 'UnsafeFillOperation' object.
//
public class UnsafeFillFactory implements UnsafeFactory {

    private final Color[] myColor;

    // Assigns the color Array to myColor
    public UnsafeFillFactory(Color[] c) {

        this.myColor = c;
    }

    public Color[] getMyColor() {
        return myColor;
    }

    // executes the fill operation with the given values
    public UnsafeFillOperation create(Scanner sc) {

        int x = sc.nextInt();
        int y = sc.nextInt();
        return new UnsafeFillOperation(x, y, this.getMyColor());
    }
}
