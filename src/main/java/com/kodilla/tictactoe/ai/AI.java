package com.kodilla.tictactoe.ai;
import com.kodilla.tictactoe.Board;
import com.kodilla.tictactoe.Field;
import com.kodilla.tictactoe.Move;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AI {

    private List<Move> moves = new ArrayList<>();

    public AI(Field field){
        moves.add(new Move(0,0,field));
        moves.add(new Move(0,1,field));
        moves.add(new Move(0,2,field));
        moves.add(new Move(1,0,field));
        moves.add(new Move(1,1,field));
        moves.add(new Move(1,2,field));
        moves.add(new Move(2,0,field));
        moves.add(new Move(2,1,field));
        moves.add(new Move(2,2,field));
    }
    public Move aIMove() {
        Random random = new Random();
        int action = random.nextInt(moves.size()-1);
        Move move =  moves.get(action);
        moves.remove(action);
        return move;
    }

    public void aINextMove(Board board, Field fieldAI) {
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
