import codedraw.*;
import java.awt.*;

public class Rewrite {
    public static void main(String[] args) {
        Board board = new Board(10, 10);
        EventScanner myEventSC = board.getMyEventScanner();

        int player = 0;
        while (true) {
            if (myEventSC.hasMouseClickEvent()) {
                MouseClickEvent currentClick = myEventSC.nextMouseClickEvent();
                int mouseX = currentClick.getX();
                int status = board.addPiece(player % 2 + 1, mouseX);
                if (status == 0) {
                    player += 1;
                } else if (status == 1) {
                    System.out.println("Player " + player % 2 + 1 + " wins.");
                    System.exit(0);
                }
            } else {
                myEventSC.nextEvent();
            }
        }
    }
}
