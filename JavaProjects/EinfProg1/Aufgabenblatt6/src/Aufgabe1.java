/*
    Aufgabe 1) Zweidimensionale Arrays und Methoden - Vier Gewinnt
*/

import codedraw.*;

import java.awt.*;
import java.util.Arrays;

public class Aufgabe1 {

    private static int[][] genGameBoard(int row, int col) {
        return new int[row][col];
    }

    private static void drawGameBoard(CodeDraw myDrawObj, int[][] currentGameBoard, int oneSquareSize) {

        myDrawObj.setColor(Color.BLUE);
        myDrawObj.fillRectangle(0,0, oneSquareSize * currentGameBoard[0].length, oneSquareSize * currentGameBoard.length);

        int startY = oneSquareSize / 2;
        for (int i = 0; i < currentGameBoard.length; i++) {
            int startX = oneSquareSize / 2;
            for (int j = 0; j < currentGameBoard[0].length; j++) {
                switch(currentGameBoard[i][j]) {
                    case 0 -> myDrawObj.setColor(Color.WHITE);
                    case 1 -> myDrawObj.setColor(Color.YELLOW);
                    case 2 -> myDrawObj.setColor(Color.RED);
                }
                myDrawObj.fillCircle(startX, startY, 20.0);
                startX += oneSquareSize;
            }
            startY += oneSquareSize;
        }
        myDrawObj.show();
    }

    private static boolean isMovePossible(int[][] currentGameBoard, int col) {
        return currentGameBoard[0][col] == 0;
    }

    private static void makeMove(int[][] currentGameBoard, int player, int col) {
        int row = 0;
        for (int i = 0; i < currentGameBoard.length; i++) {
            if (currentGameBoard[i][col] == 0) {
                row = i;
            }
        }
        currentGameBoard[row][col] = player;
    }

    private static boolean existsWinner(int[][] currentGameBoard, int player) {
        //optimise later too lazy rn

        //horizontal check
        for (int i = 0; i < currentGameBoard.length; i++) {
            for (int j = 0; j < currentGameBoard[0].length - 3; j++) {
                if (currentGameBoard[i][j] == player &&
                        currentGameBoard[i][j + 1] == player &&
                        currentGameBoard[i][j + 2] == player &&
                        currentGameBoard[i][j + 3] == player) {
                    return true;
                }
            }
        }

        //vertical check
        for (int i = 0; i < currentGameBoard.length - 3; i++) {
            for (int j = 0; j < currentGameBoard[0].length; j++) {
                if (currentGameBoard[i][j] == player &&
                        currentGameBoard[i + 1][j] == player &&
                        currentGameBoard[i + 2][j] == player &&
                        currentGameBoard[i + 3][j] == player) {
                    return true;
                }
            }
        }

        //ltrd check
        for (int i = 0; i < currentGameBoard.length - 3; i++) {
            for (int j = 0; j < currentGameBoard[0].length - 3; j++) {
                if (currentGameBoard[i][j] == player &&
                        currentGameBoard[i + 1][j + 1] == player &&
                        currentGameBoard[i + 2][j + 2] == player &&
                        currentGameBoard[i + 3][j + 3] == player) {
                    return true;
                }
            }
        }

        //ltru check
        for (int i = 2; i < currentGameBoard.length; i++) {
            for (int j = 0; j < currentGameBoard[0].length - 3; j++) {
                if (currentGameBoard[i][j] == player &&
                        currentGameBoard[i - 1][j + 1] == player &&
                        currentGameBoard[i - 2][j + 2] == player &&
                        currentGameBoard[i - 3][j + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        // canvas settings
        int rowsGameBoard = 10;
        int colsGameBoard = 10;
        int oneSquareSize = 50;
        int width = oneSquareSize * colsGameBoard;
        int height = oneSquareSize * rowsGameBoard;

        CodeDraw myDrawObj = new CodeDraw(width, height);
        EventScanner myEventSC = myDrawObj.getEventScanner();

        // game variables
        int[][] myGameBoard = genGameBoard(rowsGameBoard, colsGameBoard);
        int player = 1;
        int fieldsUsed = 0;
        boolean gameActive = true;

        // set font for text
        TextFormat font = new TextFormat();
        font.setFontSize(28);
        font.setTextOrigin(TextOrigin.CENTER);
        font.setBold(true);
        myDrawObj.setTextFormat(font);

        //initial draw of the game board
        drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);
        System.out.println("Player " + player + " (RED)" + " has to make a move!");

        // gameplay starts
        while (!myDrawObj.isClosed() && gameActive){
            if(myEventSC.hasKeyPressEvent()){
                if(myEventSC.nextKeyPressEvent().getChar() == 'q'){
                    gameActive = false;
                }
            }
            else if (myEventSC.hasMouseClickEvent()) {
                MouseClickEvent currentClick = myEventSC.nextMouseClickEvent();
                int mouseX = currentClick.getX() / 50;
                int mouseY = currentClick.getY() / 50;

                if (!isMovePossible(myGameBoard, mouseX)) {
                    myDrawObj.drawText(width / 2.0, height / 2.0, "Column Full");
                    mouseX = currentClick.getX() / 50;
                }
                else {
                    makeMove(myGameBoard, player % 2 + 1, mouseX);
                    drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);
                    player++;
                    fieldsUsed++;
                    System.out.println("Player " + (player % 2 == 1 ? "1" : "2") + (player % 2 == 1 ? " (RED)" : " (YELLOW)") + " has to make a move!");
                }

                if (fieldsUsed >= rowsGameBoard * colsGameBoard){
                    myDrawObj.drawText(width / 2.0, height / 2.0, "BOARD FULL");
                    myEventSC.hasMouseClickEvent();
                    myGameBoard = genGameBoard(rowsGameBoard, colsGameBoard);
                    player = 1;
                    fieldsUsed = 0;
                }

                if(existsWinner(myGameBoard, 1)) {
                    myDrawObj.drawText(width / 2.0, height / 2.0, "YELLOW WINS");
                    myDrawObj.show();
                    myEventSC.hasMouseClickEvent();
                    myGameBoard = genGameBoard(rowsGameBoard, colsGameBoard);
                    player = 1;
                    fieldsUsed = 0;
                }

                if(existsWinner(myGameBoard, 2)) {
                    myDrawObj.drawText(width / 2.0, height / 2.0, "RED WINS");
                    myDrawObj.show();
                    myGameBoard = genGameBoard(rowsGameBoard, colsGameBoard);
                    player = 1;
                    fieldsUsed = 0;
                }
                
                myDrawObj.show();
            }
            else {
                myEventSC.nextEvent();
            }
        }
        myDrawObj.close();
    }
}


