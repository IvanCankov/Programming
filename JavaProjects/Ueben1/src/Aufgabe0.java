import codedraw.*;

public class Aufgabe0 {
    public static void main(String[] args) {
        windowWithSomeText();
    }

    public static void windowWithSomeText() {
        int width = 300;
        int height = 100;
        int x = 0, x_start = width;
        String someText = "Hello, Ivan!";

        CodeDraw cd = new CodeDraw(width, height);
        cd.setTitle(someText);

        while (true) {
            cd.clear();
            if(x == -width/2)
                x = x_start;
            else
                x--;
            cd.drawText(x, height / 2.0, someText);
            cd.show(10);
        }
    }
}
