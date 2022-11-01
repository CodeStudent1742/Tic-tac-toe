package com.kodilla.tictactoe;

public class Move {
    private int colm;
    private int rowm;
    private Field fieldm;

    public Move(int colm, int rowm, Field fieldm) {
        this.colm = colm;
        this.rowm = rowm;
        this.fieldm = fieldm;
    }

    public int getColm() {
        return colm;
    }

    public int getRowm() {
        return rowm;
    }

    public Field getFieldm() {
        return fieldm;
    }
}
