package com.johanes.tictactoe.model;

import java.util.List;

public class Board {

  private char[][] cells;
  private int size;

  private int emptyCell;

  public Board(int size) {
    this.size = size;
    cells = new char[size][size];
    emptyCell = size * size;
  }

  public void put(char character, int row, int col){
    if(cells[row][col] == Character.MIN_VALUE) {
      cells[row][col] = character;
      emptyCell--;
    }
  }

  public boolean checkWinner() {
    //check rows for same characters
    for (int row = 0; row < size; row++) {
      //take the first character, and compare the rest of the rows with it, if all is the same, then we have a winner
      char firstCharacter = cells[row][0];
      if(firstCharacter == Character.MIN_VALUE) {
        break;
      }
      for (int col = 1; col < size; col++) {
        if(firstCharacter != cells[row][col]){
          break;
        } else if (col == size -1) {
          return true;
        }
      }
    }

    //similar to the first one, but this one checks the column
    for (int col = 0; col < size; col++) {
      char firstCharacter = cells[0][col];
      if(firstCharacter == Character.MIN_VALUE) {
        break;
      }

      for (int row = 1; row < size; row++) {
        if(firstCharacter != cells[row][col]){
          break;
        } else if (row == size -1) {
          return true;
        }
      }
    }

    //check the first diagonal
    char firstCharacter = cells[0][0];
    if(firstCharacter != Character.MIN_VALUE) {
      for (int i = 1; i < size; i++) {
        if(firstCharacter != cells[i][i]){
          break;
        } else if (i == size - 1) {
          return true;
        }
      }
    }

    //check the second diagonal
    firstCharacter = cells[size - 1][0];
    if(firstCharacter != Character.MIN_VALUE) {
      for (int i = 1; i < size; i++) {
        if(firstCharacter != cells[size-i-1][i]){
          break;
        } else if (i == size - 1) {
          return true;
        }
      }
    }

    return false;
  }

  public char[][] getCells() {
    return cells;
  }

  public int getEmptyCell() {
    return emptyCell;
  }
}
