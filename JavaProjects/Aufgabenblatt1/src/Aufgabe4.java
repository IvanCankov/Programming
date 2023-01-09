/*
    Aufgabe 4) CodeDraw Bibliothek
*/

import codedraw.CodeDraw;
import codedraw.Palette;

public class Aufgabe4 {

    public static void main(String[] args) {

        CodeDraw myDrawObj = new CodeDraw(400, 400);
        myDrawObj.setLineWidth(2);

        myDrawObj.setColor(Palette.CYAN);
        myDrawObj.drawCircle(100, 100,100);

        myDrawObj.setColor(Palette.MAGENTA);
        myDrawObj.fillCircle(100, 100,50);

        myDrawObj.setColor(Palette.YELLOW);
        myDrawObj.fillSquare(50,250, 100);

        myDrawObj.setColor(Palette.BLUE);
        myDrawObj.drawLine(50,250, 150, 350);
        myDrawObj.drawLine(150,250, 50, 350);

        int endOfGreenLine = 200;
        for (int i = 0; i < 11; i++) {
            myDrawObj.setColor(Palette.GREEN);
            myDrawObj.drawLine(200,0, endOfGreenLine, 400);
            endOfGreenLine += 40;
        }

        myDrawObj.setColor(Palette.RED);
        myDrawObj.fillEllipse(340, 60, 15, 60);
        myDrawObj.fillEllipse(340, 60, 60, 15);

        myDrawObj.show();
    }
}
