package com.kodilla.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class BoardRow {
    List<Field> cols = new ArrayList<>();

    public  BoardRow(){
        for (int col =0; col < 3; col++){
            cols.add(Field.NONE);
        }
    }

    public List<Field> getCols() {
        return cols;
    }

    @Override
    public String toString() {
        String s = "|";
        for( int col = 0; col < 3; col++){
            s += cols.get(col)+ "|";
        }
        s+= "\n";
        return s;
    }
}
