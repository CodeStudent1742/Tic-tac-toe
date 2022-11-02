package com.kodilla.tictactoe;

import com.kodilla.tictactoe.ui.UserDialogs;

import javax.servlet.ServletOutputStream;


public class TicTacToeApplication {

    public static void main(String[] args) {

        Board board = new Board();
        System.out.println(board);
        Board.playSelection(board);
    }

}
