package com.kodilla.tictactoe.ai;

import com.kodilla.tictactoe.Board;
import com.kodilla.tictactoe.Field;
import com.kodilla.tictactoe.Move;
import com.kodilla.tictactoe.ui.Level;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AI {
    private int boardSize;
    private List<Move> moves = new ArrayList<>();

    public int getBoardSize() {
        return boardSize;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public AI(Field field, int boardSize) {
        this.boardSize = boardSize;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                moves.add(new Move(i, j, field));
            }
        }
    }

    public Move aIMove() {
        Random random = new Random();
        int action = random.nextInt(moves.size() - 1);
        Move move = moves.get(action);
        moves.remove(action);
        return move;
    }

    public void aINextMove(Board board) {
        boolean temp2 = false;
        while (!temp2) {
            Move move = aIMove();
            if (board.getField(move.getColm(), move.getRowm()) != Field.NONE) {
                System.out.println(move);
                temp2 = false;
            } else {
                board.setField(move.getColm(), move.getRowm(), move.getFieldm());
                temp2 = true;
            }
        }
    }

    public void aINextMove(Board board, Level level, Move playerMove) {
        boolean temp2 = false;
        while (!temp2) {
            Move move = aIMove(board, level, playerMove);
            if (board.getField(move.getColm(), move.getRowm()) != Field.NONE) {
                System.out.println(move);
                temp2 = false;
            } else {
                board.setField(move.getColm(), move.getRowm(), move.getFieldm());
                temp2 = true;
            }
        }
    }

    public Move aIMove(Board board, Level level, Move playerMove) {
        Move move = null;
        if (level == Level.EASY) {
            Random random = new Random();
            int action = random.nextInt(moves.size() - 1);
            move = moves.get(action);
            moves.remove(action);
        } else if (level == Level.NORMAL) {
            Random random2 = new Random();
            boolean temp = false;
            List<Move> surround = new ArrayList<>();
            if (playerMove.getColm() > 0 && playerMove.getRowm() > 0)
                surround.add(new Move(playerMove.getColm() - 1, playerMove.getRowm() - 1, Field.CIRCLE));
            if (playerMove.getColm() > 0)
                surround.add(new Move(playerMove.getColm() - 1, playerMove.getRowm(), Field.CIRCLE));
            if (playerMove.getColm() > 0 && playerMove.getRowm() < board.getBoardSize() - 2)
                surround.add(new Move(playerMove.getColm() - 1, playerMove.getRowm() + 1, Field.CIRCLE));
            if (playerMove.getRowm() > 0)
                surround.add(new Move(playerMove.getColm(), playerMove.getRowm() - 1, Field.CIRCLE));
            if (playerMove.getRowm() < board.getBoardSize() - 2)
                surround.add(new Move(playerMove.getColm(), playerMove.getRowm() + 1, Field.CIRCLE));
            if (playerMove.getColm() < board.getBoardSize() - 2 && playerMove.getRowm() > 0)
                surround.add(new Move(playerMove.getColm() + 1, playerMove.getRowm() - 1, Field.CIRCLE));
            if (playerMove.getColm() < board.getBoardSize() - 2)
                surround.add(new Move(playerMove.getColm() + 1, playerMove.getRowm(), Field.CIRCLE));
            if (playerMove.getColm() < board.getBoardSize() - 2)
                surround.add(new Move(playerMove.getColm() + 1, playerMove.getRowm() + 1, Field.CIRCLE));

            while (!temp) {
                int action = random2.nextInt(surround.size() - 1);
                Move rmove = surround.get(action);
                if (moves.contains(rmove)) {
                    moves.remove(rmove);
                    temp = true;
                } else if (surround.isEmpty()) {
                    Random random = new Random();
                    int alternativeAct = random.nextInt(moves.size() - 1);
                    move = moves.get(alternativeAct);
                    moves.remove(alternativeAct);
                    temp = true;
                } else {
                    surround.remove(action);
                    temp = false;
                }
            }
        }else{ //Hard (min max)

        }
        return move;
    }
}
