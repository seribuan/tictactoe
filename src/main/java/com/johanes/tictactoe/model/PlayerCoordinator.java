package com.johanes.tictactoe.model;

public class PlayerCoordinator {

  private int currentPlayer = 0;

  private final char[] playerCharacters = {'X', 'O'};

  public char getCurrentPlayerCharacter() {
    return playerCharacters[currentPlayer];
  }

  public void switchPlayer() {
    currentPlayer = 1 - currentPlayer;
  }
}
