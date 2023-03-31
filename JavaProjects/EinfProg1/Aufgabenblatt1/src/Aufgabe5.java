/*
    Aufgabe 5) Schleifen und Zeichnen innerhalb des CodeDraw-Fensters
*/

import codedraw.CodeDraw;
import codedraw.Palette;

import java.util.Scanner;

public class Aufgabe5 {

    static Scanner input = new Scanner(System.in);
    static int n;

    public static void main(String[] args) {
        System.out.print("Please input a number bigger than 4: ");
        n = input.nextInt();
        if (n % 2 == 1 && 4 < n && n< 20) drawer();
    }
    static void drawer() {
        CodeDraw myDrawObj = new CodeDraw(300, 300);
        myDrawObj.setLineWidth(4);
        double radius = 300.0 / n / 2.0;

        double startOfRedCirclesX = 300.0 / n / 2;
        double startOfRedCirclesY = 300.0 / n / 2;
        myDrawObj.setColor(Palette.RED);
        for (int i = 0; i < n; i++) {
            myDrawObj.drawCircle(startOfRedCirclesX, startOfRedCirclesY, radius);
            startOfRedCirclesY += radius * 2.0;
        }

        double startOfRedCirclesX2 = 300.0 / n / 2;
        double startOfRedCirclesY2 = 300 - radius;
        for (int i = 0; i < n; i++) {
            myDrawObj.drawCircle(startOfRedCirclesX2, startOfRedCirclesY2, radius);
            startOfRedCirclesX2 += radius * 2.0;
        }

        double startOfInnerRedCirclesX = 5 * radius;
        double startOfInnerRedCirclesY = 5 * radius;
        for (int i = 0; i < n - 4; i++) {
            myDrawObj.drawCircle(startOfInnerRedCirclesX, startOfInnerRedCirclesY, radius);
            startOfInnerRedCirclesY += radius * 2.0;

        }

        double startOfInnerRedCirclesX2 = 5 * radius;
        double startOfInnerRedCirclesY2 = 300 - (5 * radius);
        for (int i = 0; i < n - 4; i++) {
            myDrawObj.drawCircle(startOfInnerRedCirclesX2, startOfInnerRedCirclesY2, radius);
            startOfInnerRedCirclesX2 += radius * 2.0;
        }

        myDrawObj.setColor(Palette.BLUE);
        double startOfInnerBlueCirclesX = 3 * radius;
        double startOfInnerBlueCirclesY = 3 * radius;
        for (int i = 0; i < n - 2; i++) {
            myDrawObj.drawCircle(startOfInnerBlueCirclesX, startOfInnerBlueCirclesY, radius);
            startOfInnerBlueCirclesX += radius * 2.0;
        }

        double startOfInnerBlueCirclesX2 = 300 - (3 * radius);
        double startOfInnerBlueCirclesY2 = 3 * radius;
        for (int i = 0; i < n - 2; i++) {
            myDrawObj.drawCircle(startOfInnerBlueCirclesX2, startOfInnerBlueCirclesY2, radius);
            startOfInnerBlueCirclesY2 += radius * 2.0;
        }

        myDrawObj.show();
    }
}
