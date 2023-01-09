import codedraw.CodeDraw;
import codedraw.Palette;

public class CodeDrawDebug {

    public static void main(String[] args) {
        int screenWidth = 500;
        int screenHeight = 350;

        int rows = 4;
        int boxLength = 429;
        int boxHeight = 286;

        // Alle Werte bis hierher sind fix und sollen nicht verändert werden

        CodeDraw cd = new CodeDraw(screenWidth, screenHeight);
        cd.setInstantDraw(true);
        cd.setAlwaysOnTop(true);

        int startX = (screenWidth - boxLength) / 2;
        int startY = (screenHeight - boxHeight) / 2;
        int size = boxHeight / rows;
        boolean red = true;

        for (int row = 1; row <= rows; rows++) {
            int xOffset = 0;
            while (xOffset <= boxLength) {
                cd.setColor(red ? Palette.RED : Palette.BLUE);
                cd.fillSquare(startX + xOffset, startY + row * size, size);
                xOffset += size;
                red = !red;
            }
        }

        cd.setColor(Palette.BLACK);
        cd.setLineWidth(2);
        cd.drawRectangle(startX, startY, boxLength, boxHeight);

        // der Aufruf auf show ist nicht nötig, da setInstantDraw(true) oben gesetzt worden ist
        // cd.show();
    }
}
