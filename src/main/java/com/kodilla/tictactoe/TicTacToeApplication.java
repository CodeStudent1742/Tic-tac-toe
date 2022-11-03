package com.kodilla.tictactoe;

import com.kodilla.tictactoe.ui.UserDialogs;

import javax.servlet.ServletOutputStream;


public class TicTacToeApplication {

    public static void main(String[] args) {
        int boardSize = Board.playSelection();
        Board board = new Board(boardSize);
        System.out.println(board);
        Board.opponentSelection(board);
    }

}
