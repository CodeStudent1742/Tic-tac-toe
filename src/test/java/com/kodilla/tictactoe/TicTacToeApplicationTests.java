package com.kodilla.tictactoe;

import org.junit.jupiter.api.*;


class TicTacToeApplicationTests {
    private static int testCounter = 0;
    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }
    @Nested
    @DisplayName(" Player 0 tests")
    class OPlayerTests {
        @Test
        void OWinsInRow() {
            //Given
            Board board = new Board();

            //When
            board.setField(0,0,Field.CIRCLE);
            board.setField(1,0,Field.CIRCLE);
            board.setField(2,0,Field.CIRCLE);
            boolean result = Winner.check(board,Field.CIRCLE);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        void OWinsInColumns() {
            //Given
            Board board = new Board();

            //When
            board.setField(0,0,Field.CIRCLE);
            board.setField(0,1,Field.CIRCLE);
            board.setField(0,2,Field.CIRCLE);
            boolean result = Winner.check(board,Field.CIRCLE);

            //Then
            Assertions.assertTrue(result);
        }
        @Test
        void OWinsInDiagonal1() {
            //Given
            Board board = new Board();

            //When
            board.setField(0,0,Field.CIRCLE);
            board.setField(1,1,Field.CIRCLE);
            board.setField(2,2,Field.CIRCLE);
            boolean result = Winner.check(board,Field.CIRCLE);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        void OWinsInDiagonal2() {
            //Given
            Board board = new Board();

            //When
            board.setField(2,0,Field.CIRCLE);
            board.setField(1,1,Field.CIRCLE);
            board.setField(0,2,Field.CIRCLE);
            boolean result = Winner.check(board,Field.CIRCLE);

            //Then
            Assertions.assertTrue(result);
        }
    }
    @Nested
    @DisplayName(" Player X tests")
    class XPLayerTests {
        @Test
        void XWinsInRow() {
            //Given
            Board board = new Board();

            //When
            board.setField(0,0,Field.CROSS);
            board.setField(1,0,Field.CROSS);
            board.setField(2,0,Field.CROSS);
            boolean result = Winner.check(board,Field.CROSS);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        void XWinsInColumns() {
            //Given
            Board board = new Board();

            //When
            board.setField(0,0,Field.CROSS);
            board.setField(0,1,Field.CROSS);
            board.setField(0,2,Field.CROSS);
            boolean result = Winner.check(board,Field.CROSS);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        void XWinsInDiagonal1() {
            //Given
            Board board = new Board();

            //When
            board.setField(0,0,Field.CROSS);
            board.setField(1,1,Field.CROSS);
            board.setField(2,2,Field.CROSS);
            boolean result = Winner.check(board,Field.CROSS);

            //Then
            Assertions.assertTrue(result);
        }

        @Test
        void XWinsInDiagonal2() {
            //Given
            Board board = new Board();

            //When
            board.setField(2,0,Field.CROSS);
            board.setField(1,1,Field.CROSS);
            board.setField(0,2,Field.CROSS);
            boolean result = Winner.check(board,Field.CROSS);

            //Then
            Assertions.assertTrue(result);
        }
    }
    @Test
    void TestDraw() {
        //Given
        Board board = new Board();

        //When
        board.setField(0,0,Field.CIRCLE);
        board.setField(1,1,Field.CROSS);
        board.setField(2,2,Field.CIRCLE);
        board.setField(0,1,Field.CROSS);
        board.setField(2,1,Field.CIRCLE);
        board.setField(2,0,Field.CROSS);
        board.setField(0,2,Field.CIRCLE);
        board.setField(1,2,Field.CROSS);
        board.setField(1,0,Field.CIRCLE);
        boolean result = Winner.draw(board);

        //Then
        Assertions.assertTrue(result);
    }
    @Test
    void ThrowException() {
        //Given
        Board board = new Board();

        //When
        board.setField(0,0,Field.CIRCLE);
        board.setField(1,1,Field.CROSS);
        boolean result = Winner.draw(board);

        //Then
        Assertions.assertTrue(result);

    }


}
