package com.kodilla.tictactoe;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return colm == move.colm && rowm == move.rowm && fieldm == move.fieldm;
    }

    @Override
    public int hashCode() {
        return Objects.hash(colm, rowm, fieldm);
    }
}
