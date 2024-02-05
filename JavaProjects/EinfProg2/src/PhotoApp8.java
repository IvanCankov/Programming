import codedraw.CodeDraw;

import java.awt.*;
import java.util.HashMap;
import java.util.Scanner;

public class PhotoApp8 {

    public static void main(String[] args) {

        // TODO: modify according to 'Aufgabenblatt8.md'.

        // TODO: declare and initialize 'Layered' variable.
        // Type 'RasterizedRGB' could be used as well...
        Layered raster = null;
        Scanner sc = new Scanner(System.in);

        // set default color.
        Color[] c = {Color.GREEN};
        // The variable c contains the default color as an array entry. An array is
        // used because it enables the default color to be changed by other classes after
        // it has been passed to a factory object (multiple objects use identical array).

        /*
        String input =
            "create 30 40\n" +
            "line 2 3 10 20\n" +
            "newlayer\n" +
            "setcolor 255 0 255 255\n" +
            "line 0 10 17 7\n" +
            "newlayer\n" +
            "setcolor 255 0 0 255 \n" +
            "line 0 30 19 0\n" +
            "load src/Image.txt";

        sc = new Scanner(input);
        // */

        // HashMap<String, SafeFactory> is a predefined associative data structure in the
        // Java libraries implemented using a hash table, where keys are of type 'String' and
        // associated values of type 'SafeFactory'.
        HashMap<String, SafeFactory> commandMap = new HashMap<String, SafeFactory>();
        // TODO: put key-value associations to 'commandMap': keys are command strings (like "line"
        //  or "newlayer"), values are corresponding factories.

        while (sc.hasNext()) {
            String command = sc.next();

            //TODO: process command, modify and draw raster.

        }
    }
}
