import codedraw.CodeDraw;
import codedraw.EventScanner;

import java.awt.*;

public class Board {
    private final int width;
    private final int  height;
    private final int pieceRadius;
    private final int padding;
    private final int[][] board;
    private final int[] heights;
    private final int squareSize;
    private final CodeDraw myDrawObject;
    private final EventScanner myEventScanner;
    Board(int height, int width) {
        this.height = height;
        this.width = width;
        this.pieceRadius = 40;
        this.padding = 60;

        this.board = new int[height][width];
        this.heights = new int[width];

        this.squareSize = (pieceRadius + padding);
        this.myDrawObject = new CodeDraw(squareSize * width, squareSize * height);
        this.myEventScanner = myDrawObject.getEventScanner();

        myDrawObject.setColor(Color.BLUE);
        myDrawObject.fillRectangle(0,0, squareSize * width, squareSize * height);

        myDrawObject.setColor(Color.WHITE);
        int startY = squareSize / 2;
        for (int i = 0; i < height; i++) {
            int startX = squareSize / 2;
            for (int j = 0; j < height; j++) {
                myDrawObject.fillCircle(startX, startY, pieceRadius);
                startX += squareSize;
            }
            startY += squareSize;
        }
        myDrawObject.show();
    }

    EventScanner getMyEventScanner() {
        return myEventScanner;
    }

    boolean addPiece(int player, int mouseX) {
        int x = mouseX / squareSize;
        int pieceHeight = height - heights[x] - 1;
        board[pieceHeight ][x] = player;
        heights[x] += 1;
        update(pieceHeight, x);
        return checkWinner(player, pieceHeight, x);
    }

    void update(int pieceHeight, int mouseX) {
        double yPos = pieceHeight * squareSize + squareSize / 2.0;
        double xPos = (mouseX) * squareSize + squareSize / 2.0;
        switch (board[pieceHeight][mouseX]) {
            case 1 -> myDrawObject.setColor(Color.YELLOW);
            case 2 -> myDrawObject.setColor(Color.RED);
            default -> myDrawObject.setColor(Color.GREEN);
        }
        myDrawObject.fillCircle(xPos, yPos, pieceRadius);
        myDrawObject.show();
    }

    boolean checkWinner(int player, int pieceHeight, int mouseX) {
        int leftHorizontal = 0;
        int leftDiagonal = 0;
        int rightHorizontal = 0;
        int down = 0;
        int rightDiagonal = 0;
        int rightDiagonalUp = 0;
        int leftDiagonalUp = 0;

        // Check left horizontal
        for (int i = 1; i < 4; i++) {
            if (mouseX - 1 - i >= 0 && board[pieceHeight][mouseX - i] == player) {
                leftHorizontal++;
            }

            if (pieceHeight + i < height && mouseX - i > 0 && board[pieceHeight + i][mouseX - i] == player) {
                leftDiagonal++;
            }

            if (mouseX + i < width && board[pieceHeight][mouseX + i] == player) {
                rightHorizontal++;
            }

            if (pieceHeight + i < height && board[pieceHeight + i][mouseX] == player) {
                down++;
            }

            if (pieceHeight + i < height && mouseX + i < width && board[pieceHeight + i][mouseX + i] == player) {
                rightDiagonal++;
            }

            if (pieceHeight - i > 0 && mouseX + i < width && board[pieceHeight - i][mouseX + i] == player) {
                rightDiagonalUp++;
            }

            if (pieceHeight - i > 0 && mouseX - i > 0 && board[pieceHeight - i][mouseX - i] == player) {
                leftDiagonalUp++;
            }
        }

        // Check if any of the counts reach 4 (Connect Four)
        return leftHorizontal >= 3 || leftDiagonal >= 3 || rightHorizontal >= 3 ||
               down >= 3 || rightDiagonal >= 3 || rightDiagonalUp >= 3 || leftDiagonalUp >= 3;
    }
}
