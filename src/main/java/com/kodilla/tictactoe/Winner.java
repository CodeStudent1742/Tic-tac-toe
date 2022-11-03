package com.kodilla.tictactoe;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    public static boolean winnerCheck(Board board) {
        boolean result = false;

        result = Winner.check(board, Field.CIRCLE) || Winner.check(board, Field.CROSS);
        return result;
    }

    public static boolean check(Board board, Field field) {
        boolean result = false;
        if (board.getBoardSize() == 3) {
            result = Winner.check3(board, field);
        } else {
            result = Winner.check5(board, field);
        }
        return result;
    }

    public static boolean draw(Board board) {
        boolean result = false;
        List<Field> theResult = board.getRows().stream()
                .flatMap(s -> s.getCols().stream())
                .collect(Collectors.toList());
        result = !theResult.contains(Field.NONE);
        if (result)
            System.out.println("DRAW!");
        return result;
    }

    public static boolean check3(Board board, Field field) {
        boolean result = false;
        for (int i = 0; i < 3; i++) {
            //Check Rows
            if (board.getField(0, i) == field && board.getField(1, i) == field && board.getField(2, i) == field) {
                System.out.println("Winner is player playing: " + field);
                result = true;
            }
            //Check Columns
            if (board.getField(i, 0) == field && board.getField(i, 1) == field && board.getField(i, 2) == field) {
                System.out.println("Winner is player playing: " + field);
                result = true;
            }
        }
        //Check \
        if (board.getField(0, 0) == field && board.getField(1, 1) == field && board.getField(2, 2) == field) {
            System.out.println("Winner is player playing: " + field);
            result = true;
        }
        //Check /
        if (board.getField(2, 0) == field && board.getField(1, 1) == field && board.getField(0, 2) == field) {
            System.out.println("Winner is player playing: " + field);
            result = true;

        }
        return result;
    }

    public static boolean check5(Board board, Field field) {
        boolean result = false;
        for (int i = 0; i < board.getBoardSize(); i++) {
            for (int j = 0; j < board.getBoardSize() - 5; j++) {
                //Check Rows
                if (board.getField(j, i) == field && board.getField(j + 1, i) == field && board.getField(j + 2, i) == field && board.getField(j + 3, i) == field && board.getField(j + 4, i) == field) {
                    System.out.println("Winner is player playing: " + field);
                    result = true;
                }
                //Check Columns
                if (board.getField(i, j) == field && board.getField(i, j + 1) == field && board.getField(i, j + 2) == field && board.getField(i, j + 3) == field && board.getField(i, j + 4) == field) {
                    System.out.println("Winner is player playing: " + field);
                    result = true;
                }
            }
        }
        for (int i = 0; i < board.getBoardSize() - 4; i++) {
            for (int j = 0; j < board.getBoardSize() - 4; j++) {
                //Check /
                if (board.getField(i + 4, j) == field && board.getField(i + 3, j + 1) == field && board.getField(i + 2, j + 2) == field && board.getField(i + 1, j + 3) == field && board.getField(i, j + 4) == field) {
                    System.out.println("Winner is player playing: " + field);
                    result = true;
                }
                //Check \
                if (board.getField(i, j) == field && board.getField(i + 1, j + 1) == field && board.getField(i + 2, j + 2) == field && board.getField(i + 3, j + 3) == field && board.getField(i + 4, j + 4) == field) {
                    System.out.println("Winner is player playing: " + field);
                    result = true;
                }
            }
        }
        return result;
    }
}



