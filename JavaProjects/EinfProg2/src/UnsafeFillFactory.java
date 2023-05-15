import java.awt.*;
import java.util.Scanner;

// A factory that creates a 'UnsafeFillOperation' object.
//
public class UnsafeFillFactory implements UnsafeFactory {

    private Color color;

    // TODO: add constructor specification.
    public UnsafeFillFactory(Color[] c) {

        this.color = c[0];
    }

    // TODO: add method specification.
    public UnsafeFillOperation create(Scanner sc) {

        int x = sc.nextInt();
        int y = sc.nextInt();
        return new UnsafeFillOperation(x, y, color);

    }
}
