package com.kodilla.tictactoe.ui;

import com.kodilla.tictactoe.Field;
import com.kodilla.tictactoe.Move;

import java.util.Scanner;

public class UserDialogs {

    public static Move getNextMove(Field field) {
        Move moveU = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your move col&row eg 11(col & row in range of 1-3 ): ");
        while (moveU == null) {
            String s = scanner.nextLine();
            try {
                moveU = handleInput(s, field);
            } catch (ForTestException e) {
                System.out.println("Wrong move, try again( Only two numbers from 1 to 3 without space");
            }
        }
        return moveU;
    }

    public static Move handleInput(String s, Field field) throws ForTestException {
        Move move = null;
        try {
            int col = Integer.parseInt(s.substring(0, 1)) - 1;
            int row = Integer.parseInt(s.substring(1, 2)) - 1;
            if (col >= 3 || row >= 3) {
                throw new ForTestException();
            }
            if (s.length() >= 3) {
                throw new ForTestException();
            }

            move = new Move(col, row, field);
        } catch (Exception e) {
            throw new ForTestException();
        }
        return move;
    }

    public static playOption playSelection() {
        boolean checker = false;
        Scanner scanner = new Scanner(System.in);
        playOption choice = null;
        while (!checker) {
            System.out.println("Choose with who you want to play : Computer(C) or 2nd player(P)");
            String getKey = scanner.nextLine();
            getKey = getKey.toUpperCase();
            switch (getKey.toUpperCase()) {
                case "C":
                    checker = true;
                    choice = playOption.COMPUTER;
                    break;
                case "P":
                    checker = true;
                    choice = playOption.PLAYER;
                    break;
                default:
                    System.out.println("You inputted wrong key. Try again");
                    checker = false;
            }
        }
        return choice;
    }
}
