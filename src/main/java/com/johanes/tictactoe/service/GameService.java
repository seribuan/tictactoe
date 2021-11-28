package com.johanes.tictactoe.service;

import com.johanes.tictactoe.model.Board;
import com.johanes.tictactoe.model.PlayerCoordinator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class GameService {

  private final HttpSession httpSession;

  public Board createBoard(int size){
      Board board = new Board(size);
      httpSession.setAttribute("board", board);
      return board;
  }

  public Board getBoard(){
    Board board = (Board) httpSession.getAttribute("board");
    if(board == null) {
      throw new RuntimeException("Board is null");
    }

    return board;
  }

  public PlayerCoordinator getPlayerCoordinator() {
    PlayerCoordinator playerCoordinator = (PlayerCoordinator) httpSession.getAttribute("playerCoordinator");
    if(playerCoordinator == null) {
      playerCoordinator = new PlayerCoordinator();
      httpSession.setAttribute("playerCoordinator", playerCoordinator);
    }

    return playerCoordinator;
  }

  public void updateBoard(Integer row, Integer col) {
    Board board = this.getBoard();
    PlayerCoordinator playerCoordinator = this.getPlayerCoordinator();

    board.put(playerCoordinator.getCurrentPlayerCharacter(), row, col);
  }

  public void switchPlayer() {
    PlayerCoordinator playerCoordinator = this.getPlayerCoordinator();
    playerCoordinator.switchPlayer();
    //httpSession.setAttribute("playerCoordinaor", playerCoordinator);

  }

}
