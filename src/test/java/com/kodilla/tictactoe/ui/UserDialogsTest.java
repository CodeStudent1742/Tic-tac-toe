package com.kodilla.tictactoe.ui;

import com.kodilla.tictactoe.Field;
import com.kodilla.tictactoe.Move;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class UserDialogsTest {
    @Test
    public void shouldReturnMove() throws ForTestException {
        //Given
        Field field = Field.CROSS;
        String input = "11";
        int boardSize = 3;
        //When
        Move result = UserDialogs.handleInput(input,field,boardSize);
        //Then
        assertEquals(new Move(0,0,Field.CROSS), result);
    }

    @Test
    public void shouldThrowException(){
        //Given
        Field field = Field.CROSS;
        String input = "44";
        int boardSize = 3;
        //When & Then
        assertThrows(ForTestException .class, ()->UserDialogs.handleInput(input,field,boardSize));
    }
}