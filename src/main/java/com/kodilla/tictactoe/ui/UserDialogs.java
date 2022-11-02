package com.kodilla.tictactoe.ui;

import com.kodilla.tictactoe.Field;
import com.kodilla.tictactoe.Move;

import java.util.Scanner;

public class UserDialogs {

//  Previous version
//    public static Move getNextMove(Field field) {
//        Scanner scanner = new Scanner(System.in);
//        boolean temp = false;
//        Move move = null;
//        while (!temp) {
//            System.out.println("Enter your move col&row eg 11(col & row in range of 1-3 ): ");
//            String s = scanner.nextLine();
//            try {
//                int col = Integer.parseInt(s.substring(0, 1)) - 1;
//                int row = Integer.parseInt(s.substring(1, 2)) - 1;
//                if (s.length() >= 3) throw new Exception();
//                if (col > 3 || row > 3) throw new Exception();
//                temp = true;
//                move = new Move(col, row, field);
//            } catch (Exception e) {
//                temp = false;
//                System.out.println("Wrong move, try again( Only two numbers from 1 to 3 without space");
//            }
//        }
//        return move;
//    }

    public static Move getNextMove(Field field)  {
        boolean temp = false;
        Move move = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your move col&row eg 11(col & row in range of 1-3 ): ");
        while (move == null) {
            String s = scanner.nextLine();
            try {
                move = handleInput(s, field);
            }catch(ForTestException e){
                System.out.println("Wrong move, try again( Only two numbers from 1 to 3 without space");
            }
        }
        return move;
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
}
