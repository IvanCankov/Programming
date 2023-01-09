import codedraw.*;

public class Field {
    public static void main(String[] args) {
        int width = 800;
        int height = 540;
        int lineHeight = 520;
        CodeDraw cd = new CodeDraw(width, height);
        cd.setColor(Palette.DARK_GREEN);
        cd.fillRectangle(0, 0, width, height);

        cd.setColor(Palette.WHITE);
        cd.setLineWidth(3);
        cd.drawRectangle(10, 10, 780, lineHeight);

        cd.drawRectangle(10, 100, 150, 340);
        cd.drawRectangle(10, 200, 50, 140);
        cd.fillCircle(120, 270, 5);

        cd.drawRectangle(width - 160, 100, 150, 340);
        cd.drawRectangle(width - 60, 200, 50, 140);
        cd.fillCircle(width - 120, 270, 5);

        cd.drawLine(width / 2, 10, width / 2, lineHeight+ 10);
        cd.drawCircle(width / 2, height / 2, 80);
        cd.fillCircle(width / 2, height / 2, 20);

        cd.show();
    }
}
