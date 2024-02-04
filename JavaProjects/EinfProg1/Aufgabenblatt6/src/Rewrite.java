import codedraw.*;
import java.awt.*;

import static java.lang.Thread.sleep;

public class Rewrite {
    public static void main(String[] args) throws InterruptedException {
        Board board = new Board(10, 10, 60, 90);
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
                    sleep(500);
                    System.exit(0);
                }
            } else {
                myEventSC.nextEvent();
            }
        }
    }
}
