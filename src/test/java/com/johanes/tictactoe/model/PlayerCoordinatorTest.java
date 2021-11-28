package com.johanes.tictactoe.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerCoordinatorTest {

  @Test
  void getCurrentPlayerCharacter() {
    PlayerCoordinator playerCoordinator = new PlayerCoordinator();
    assertEquals('X', playerCoordinator.getCurrentPlayerCharacter());
  }

  @Test
  void switchPlayer() {
    PlayerCoordinator playerCoordinator = new PlayerCoordinator();
    playerCoordinator.switchPlayer();
    assertEquals('O', playerCoordinator.getCurrentPlayerCharacter());

    playerCoordinator.switchPlayer();
    assertEquals('X', playerCoordinator.getCurrentPlayerCharacter());
  }
}