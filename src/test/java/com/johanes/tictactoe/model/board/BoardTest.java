package com.johanes.tictactoe.model.board;

import com.johanes.tictactoe.model.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

  @Test
  void put() {
    Board board = new Board(3);
    board.put('X', 0,0);
    assertEquals('X',board.getCells()[0][0]);
  }

  @Test
  void checkWinnerRow() {
    Board board = new Board(3);
    board.put('X', 0,0);
    board.put('X', 0,1);
    board.put('X', 0,2);
    assertEquals(true, board.checkWinner());
  }

  @Test
  void checkWinnerCol() {
    Board board = new Board(3);
    board.put('X', 0,0);
    board.put('X', 1,0);
    board.put('X', 2,0);
    assertEquals(true, board.checkWinner());
  }

  @Test
  void checkWinnerFirstDiagonal() {
    Board board = new Board(3);
    board.put('X', 0,0);
    board.put('X', 1,1);
    board.put('X', 2,2);
    assertEquals(true, board.checkWinner());
  }

  @Test
  void checkWinnerSecondDiagonal() {
    Board board = new Board(3);
    board.put('X', 2,0);
    board.put('X', 1,1);
    board.put('X', 0,2);
    assertEquals(true, board.checkWinner());
  }

  @Test
  void checkNotWinner() {
    Board board = new Board(3);
    board.put('X', 0,0);
    board.put('O', 0,1);
    board.put('X', 0,2);
    assertEquals(false, board.checkWinner());

    board = new Board(3);
    board.put('X', 0,0);
    board.put('O', 1,1);
    board.put('X', 2,2);
    assertEquals(false, board.checkWinner());
  }
}