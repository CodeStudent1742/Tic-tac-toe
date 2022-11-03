package com.kodilla.tictactoe.ai;

import com.kodilla.tictactoe.Board;
import com.kodilla.tictactoe.Field;
import com.kodilla.tictactoe.Move;


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
}
