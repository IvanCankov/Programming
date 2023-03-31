import codedraw.*;

public class Lines {

    public static void main(String[] args) {

        CodeDraw cd = new CodeDraw(1920, 1080);
        int length = 40;
        int distance = 20;
        int i = 1;

        while (i < 16) {
            double y = i * distance - distance / 2.0;
            double x = length / 2.0;
            cd.setLineWidth(6);
            if (y % 2 == 0) cd.setColor(Palette.DARK_BLUE);
            else cd.setColor(Palette.PURPLE);
            cd.drawLine(x, y, x + length * 2 * i, y);

            i++;
        }

        cd.show();
    }
}
