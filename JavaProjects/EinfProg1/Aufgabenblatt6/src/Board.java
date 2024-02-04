import codedraw.CodeDraw;

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

    Board(int height, int width) {
        this.height = height;
        this.width = width;
        this.pieceRadius = 40;
        this.padding = 60;

        this.board = new int[height][width];
        this.heights = new int[width];

        this.squareSize = (pieceRadius + padding);
        this.myDrawObject = new CodeDraw(squareSize * width, squareSize * height);

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

    CodeDraw getMyDrawObject() {
        return myDrawObject;
    }

    int getSquareSize() {
        return squareSize;
    }

    boolean addPiece(int player, int mouseX) {
        int pieceHeight = height - heights[mouseX] - 1;
        board[pieceHeight ][mouseX] = player;
        heights[mouseX] += 1;
        update(pieceHeight, mouseX);
        return checkWinner(player, pieceHeight, mouseX);
    }

    void update(int pieceHeight, int mouseX) {
        double yPos = pieceHeight * squareSize + squareSize / 2.0;
        double xPos = (mouseX - 1) * squareSize + squareSize / 2.0;
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

        // Check left horizontal
        for (int i = 0; i < 4; i++) {
            if (mouseX - 1 - i >= 0 && board[pieceHeight][mouseX - i] == player) {
                leftHorizontal++;
            } else {
                break; // Break the loop if consecutive pieces are not the same
            }
        }

        // Check left diagonal
        for (int i = 0; i < 4; i++) {
            if (pieceHeight - i >= 0 && mouseX - i >= 0 && board[pieceHeight - i][mouseX - i] == player) {
                leftDiagonal++;
            } else {
                break; // Break the loop if consecutive pieces are not the same
            }
        }

        // Check right horizontal
        for (int i = 0; i < 4; i++) {
            if (mouseX + i < width && board[pieceHeight][mouseX + i] == player) {
                rightHorizontal++;
            } else {
                break; // Break the loop if consecutive pieces are not the same
            }
        }

        // Check down
        for (int i = 0; i < 4; i++) {
            if (pieceHeight + i < height && board[pieceHeight + i][mouseX] == player) {
                down++;
            } else {
                break; // Break the loop if consecutive pieces are not the same
            }
        }

        // Check right diagonal
        for (int i = 0; i < 4; i++) {
            if (pieceHeight - i >= 0 && mouseX + i < width && board[pieceHeight - i][mouseX + i] == player) {
                rightDiagonal++;
            } else {
                break; // Break the loop if consecutive pieces are not the same
            }
        }

        // Check if any of the counts reach 4 (Connect Four)
        return leftHorizontal >= 4 || leftDiagonal >= 4 || rightHorizontal >= 4 || down >= 4 || rightDiagonal >= 4;
    }
}
