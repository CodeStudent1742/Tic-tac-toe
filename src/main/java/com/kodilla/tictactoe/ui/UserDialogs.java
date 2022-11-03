package com.kodilla.tictactoe.ui;

import com.kodilla.tictactoe.Field;
import com.kodilla.tictactoe.Move;

import java.util.Scanner;

public class UserDialogs {

    public static Move getNextMove(Field field, int boardSize) {
        Move moveU = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your move col&row eg 11(col & row in range of 0-" + (boardSize - 1) + ": ");
        while (moveU == null) {
            String s = scanner.nextLine();
            try {
                moveU = handleInput(s, field, boardSize);
            } catch (ForTestException e) {
                System.out.println("Wrong move, try again( Only two numbers from 1 to " + (boardSize - 1) + " without space");
            }
        }
        return moveU;
    }

    public static Move handleInput(String s, Field field, int boardSize) throws ForTestException {
        Move move = null;
        try {
            int col = Integer.parseInt(s.substring(0, 1));
            int row = Integer.parseInt(s.substring(1, 2));
            if (col >= boardSize || row >= boardSize) {
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

    public static opponentOption opponentSelection() {
        boolean checker = false;
        Scanner scanner = new Scanner(System.in);
        opponentOption choice = null;
        while (!checker) {
            System.out.println("Choose with who you want to play : Computer(C) or 2nd player(P)");
            String getKey = scanner.nextLine();
            getKey = getKey.toUpperCase();
            switch (getKey.toUpperCase()) {
                case "C":
                    checker = true;
                    choice = opponentOption.COMPUTER;
                    break;
                case "P":
                    checker = true;
                    choice = opponentOption.PLAYER;
                    break;
                default:
                    System.out.println("You inputted wrong key. Try again");
                    checker = false;
            }
        }
        return choice;
    }

    public static playOption playSelection() {
        boolean checker = false;
        Scanner scanner = new Scanner(System.in);
        playOption choice2 = null;
        while (!checker) {
            System.out.println("Choose type od Game: Classic(C) or to Five(F)");
            String getKey = scanner.nextLine();
            getKey = getKey.toUpperCase();
            switch (getKey.toUpperCase()) {
                case "C":
                    checker = true;
                    choice2 = playOption.CLASSIC;
                    break;
                case "F":
                    checker = true;
                    choice2 = playOption.FIVE;
                    break;
                default:
                    System.out.println("You inputted wrong key. Try again");
                    checker = false;
            }
        }
        return choice2;
    }
}
