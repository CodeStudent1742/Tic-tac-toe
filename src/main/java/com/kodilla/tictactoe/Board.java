package com.kodilla.tictactoe;

import com.kodilla.tictactoe.ai.AI;
import com.kodilla.tictactoe.ui.UserDialogs;
import com.kodilla.tictactoe.ui.opponentOption;
import com.kodilla.tictactoe.ui.playOption;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int boardSize;
    final List<BoardRow> rows = new ArrayList<>();

    @Override
    public String toString() {
        String s = "";
        for (int row = 0; row < boardSize; row++) {
            s += rows.get(row).toString();
        }
        return s;
    }

    public Board(int boardSize) {
        this.boardSize = boardSize;
        for (int row = 0; row < boardSize; row++) {
            rows.add(new BoardRow(boardSize));
        }
    }

    public List<BoardRow> getRows() {
        return rows;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public Field getField(int col, int row) {
        return rows.get(row).getCols().get(col);
    }

    public void setField(int col, int row, Field field) {
        rows.get(row).getCols().set(col, field);
    }

    public boolean move(Move move) {
        if (getField(move.getColm(), move.getRowm()) != Field.NONE) {
            Field temp = getField(move.getColm(), move.getRowm());
            System.out.println("Field already filled with: " + temp + " Choose other field");
            return false;
        } else {
            setField(move.getColm(), move.getRowm(), move.getFieldm());
            return true;
        }
    }

    public static void playPlayer(Board board) {
        boolean gameNotEnd = false;
        boolean switcher = false;
        while (!gameNotEnd) {

            if (switcher == false) {
                boolean ok = false;
                while (!ok) {
                    System.out.println("Set field for Cross");
                    Move move1 = UserDialogs.getNextMove(Field.CROSS, board.getBoardSize());
                    ok = board.move(move1);
                }
                switcher = true;
            } else {
                boolean ok = false;
                while (!ok) {
                    System.out.println("Set field for Circle");
                    Move move2 = UserDialogs.getNextMove(Field.CIRCLE,board.getBoardSize());
                    ok = board.move(move2);
                }
                switcher = false;
            }
            System.out.println(board);
            gameNotEnd = Winner.winnerCheck(board);
            gameNotEnd = gameNotEnd || Winner.draw(board);
        }
    }

    public static void playAI(Board board) {
        boolean gameNotEnd2 = false;
        boolean switcher2 = false;
        AI aI = new AI(Field.CIRCLE,board.getBoardSize());
        while (!gameNotEnd2) {

            if (switcher2 == false) {
                boolean ok2 = false;
                while (!ok2) {
                    System.out.println("Set field for Cross");
                    Move moveU1 = UserDialogs.getNextMove(Field.CROSS,board.getBoardSize());
                    ok2 = board.move(moveU1);
                }
                switcher2 = true;
            } else {
                System.out.println("Computer set field for Circle");
                aI.aINextMove(board);
                switcher2 = false;
            }
            System.out.println(board);
            gameNotEnd2 = Winner.winnerCheck(board);
            gameNotEnd2 = gameNotEnd2 || Winner.draw(board);
        }
    }
    public static void opponentSelection(Board board){
        opponentOption play =UserDialogs.opponentSelection();
        if(play.equals(opponentOption.PLAYER)){
            Board.playPlayer(board);
        }else{
            Board.playAI(board);
        }
    }
    public static int playSelection() {
        int bSize;
        playOption play = UserDialogs.playSelection();
        if(play == playOption.FIVE){
           bSize = 10;
        }else{
            bSize = 3;
        }
        return bSize;
    }
}
