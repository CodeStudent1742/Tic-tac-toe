package com.kodilla.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class BoardRow {
    private int boardSize;
    List<Field> cols = new ArrayList<>();

    public  BoardRow(int boardSize){
        this.boardSize = boardSize;
        for (int col =0; col < boardSize; col++){
            cols.add(Field.NONE);
        }
    }

    public List<Field> getCols() {
        return cols;
    }

    public int getBoardSize() {
        return boardSize;
    }

    @Override
    public String toString() {
        String s = "|";
        for(int col = 0; col < boardSize; col++){
            s += cols.get(col)+ "|";
        }
        s+= "\n";
        return s;
    }


}
