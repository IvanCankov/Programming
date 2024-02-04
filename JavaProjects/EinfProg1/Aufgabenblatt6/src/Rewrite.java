import codedraw.*;
import java.awt.*;

public class Rewrite {
    public static void main(String[] args) {
        Board board = new Board(10, 10);
        board.addPiece(1, 3);
        board.addPiece(2, 3);
        board.addPiece(1, 3);
        board.addPiece(2, 3);
        board.addPiece(2, 3);
        board.addPiece(2, 3);
        System.out.printf("Winner exists: " + board.addPiece(2, 3));
    }

}
