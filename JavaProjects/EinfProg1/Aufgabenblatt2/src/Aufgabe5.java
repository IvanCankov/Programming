import codedraw.*;

import java.awt.*;

public class Aufgabe5 {

    public static void main(String[] args) {
        drawObject();
    }

    static void drawObject() {
        int wh = 400;
        double startX = 0;
        double endX = wh / 2.0;
        double startY = wh / 2.0;
        double endY = wh / 2.0;

        double centerX = wh / 4.0;
        double centerY = wh / 2.0;

        CodeDraw myDrawObj = new CodeDraw(wh, wh);
        myDrawObj.setLineWidth(1);

        for (int i = 0; i < 256; i++) {
            int colorPicker = i % 8;

            switch(colorPicker){
                case 0: myDrawObj.setColor(Color.black); break;
                case 1: myDrawObj.setColor(Color.green); break;
                case 2: myDrawObj.setColor(Color.blue); break;
                case 3: myDrawObj.setColor(Color.cyan); break;
                case 4: myDrawObj.setColor(Color.red); break;
                case 5: myDrawObj.setColor(Color.magenta); break;
                case 6: myDrawObj.setColor(Color.yellow); break;
                case 7: myDrawObj.setColor(Color.white); break;
                default: break;
            }

            if (i < 64) {
                myDrawObj.drawCircle(centerX, centerY, wh / 4.0);
                centerX += wh / 256.0;
                centerY -= wh / 256.0;

            } else if (i > 63 && i < 128) {
                myDrawObj.drawCircle(centerX, centerY, wh / 4.0);
                centerX += wh / 256.0;
                centerY += wh / 256.0;

            } else if (i > 127 && i < 192) {
                myDrawObj.drawCircle(centerX, centerY, wh / 4.0);
                centerX -= wh / 256.0;
                centerY += wh / 256.0;

            } else {
                myDrawObj.drawCircle(centerX, centerY, wh / 4.0);
                centerX -= wh / 256.0;
                centerY -= wh / 256.0;
            }
        }


        for (int i = 0; i < 360; i++) {
            int colorPicker = i % 8;

            switch(colorPicker){
            case 0: myDrawObj.setColor(Color.black); break;
            case 1: myDrawObj.setColor(Color.green); break;
            case 2: myDrawObj.setColor(Color.blue); break;
            case 3: myDrawObj.setColor(Color.cyan); break;
            case 4: myDrawObj.setColor(Color.red); break;
            case 5: myDrawObj.setColor(Color.magenta); break;
            case 6: myDrawObj.setColor(Color.yellow); break;
            case 7: myDrawObj.setColor(Color.white); break;
                default: break;
            }

            if (i < 90) {
                myDrawObj.drawLine(startX,startY,endX,endY);
                startX += wh / 2.0 / 90.0;
                endY -= wh / 2.0 / 90.0;

            } else if (i > 90 && i < 180) {
                myDrawObj.drawLine(startX,startY,endX,endY);
                startX += wh / 2.0 / 90.0;
                endY += wh / 2.0 / 90.0;

            } else if (i > 180 && i < 270) {
                myDrawObj.drawLine(startX,startY,endX,endY);
                startX -= wh / 2.0 / 90.0;
                endY += wh / 2.0 / 90.0;

            } else {
                myDrawObj.drawLine(startX, startY, endX, endY);
                startX -= wh / 2.0 / 90.0;
                endY -= wh / 2.0 / 90.0;
            }
        }
        myDrawObj.show();
    }
}
