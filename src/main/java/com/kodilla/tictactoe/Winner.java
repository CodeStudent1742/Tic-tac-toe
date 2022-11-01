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

    public static boolean draw(Board board) {
        boolean result = false;
        List<Field> theResult = board.getRows().stream()
                .flatMap(s -> s.getCols().stream())
                .collect(Collectors.toList());
        result = !theResult.contains(Field.NONE);
        if(result)
            System.out.println("DRAW!");
        return result;
    }
}

