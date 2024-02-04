import codedraw.*;
import java.awt.*;

public class Rewrite {
    public static void main(String[] args) {
        Board board = new Board(10, 10);
        CodeDraw myDrawObj = board.getMyDrawObject();
        EventScanner myEventSC = myDrawObj.getEventScanner();
        int player = 0;
        while (true) {
            if (myEventSC.hasMouseClickEvent()) {
                MouseClickEvent currentClick = myEventSC.nextMouseClickEvent();
                int mouseX = currentClick.getX();
                System.out.println("debug");
                System.out.println("Winner exists: " + board.addPiece(player % 2 + 1, mouseX));
                player += 1;
            }
        }

    }

}
