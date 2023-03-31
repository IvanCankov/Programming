/*
    Aufgabe 1) Schleifen - geometrische Formen und Muster (optische Täuschung)
*/

import codedraw.CodeDraw;
import codedraw.Palette;

import java.awt.*;

public class Aufgabe1 {
    static int ws = 400;
    static double radius = 1.0/60 * ws;
    static double startX = 2 * radius;
    static double startY = 2 * radius;

    public static void main(String[] args) {
        drawer();

    }
    static void drawer() {
        CodeDraw myDrawObj = new CodeDraw(ws, ws);

        //black circles = outline
        myDrawObj.setLineWidth(3);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                myDrawObj.setColor(Color.BLACK);
                myDrawObj.fillCircle(startX, startY, radius);
                myDrawObj.setColor(Color.GRAY);
                myDrawObj.drawCircle(startX, startY, radius);
                startX += 4 * radius;
            }
            startX = 2 * radius;
            startY += 4 * radius;
        }

        //middle square(s)
        double startSquareX = 0.25 * ws + radius;
        double startSquareY = 0.25 * ws + radius;
        double squareSide = (0.5 * ws) - (2 * radius);

        myDrawObj.setColor(Color.WHITE);
        myDrawObj.fillSquare(startSquareX, startSquareY, squareSide);

        myDrawObj.setLineWidth(1);
        myDrawObj.setColor(Color.BLACK);
        myDrawObj.drawSquare(startSquareX, startSquareY, squareSide);

        //mini squares
        double miniSquareStartX = 0.25 * ws + 2 * radius;
        double miniSquareStartY = 0.25 * ws + 2 * radius;
        double miniSquareSize = 2 * radius;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                myDrawObj.drawSquare(miniSquareStartX, miniSquareStartY, miniSquareSize);
                miniSquareStartX += 4 * radius;
            }
            miniSquareStartX = 0.25 * ws + 2 * radius;
            miniSquareStartY += 4 * radius;
        }

        myDrawObj.show();
    }
}
