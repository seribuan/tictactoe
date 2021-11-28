package com.johanes.tictactoe.controller;

import com.johanes.tictactoe.model.Board;
import com.johanes.tictactoe.model.dto.BoardSizeDto;
import com.johanes.tictactoe.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("board")
@RequiredArgsConstructor
public class BoardController {

  private final GameService gameService;

  @PostMapping
  public RedirectView createBoard(BoardSizeDto sizeDto) {
    if(sizeDto.getSize() % 2 == 0) {
      throw new RuntimeException("Size must be an odd number");
    }
    gameService.createBoard(sizeDto.getSize());

    return new RedirectView("/board");
  }

  @GetMapping()
  public String getBoard(Model model) {
    Board board = gameService.getBoard();
    model.addAttribute("board", board.getCells());
    if(board.checkWinner()){
      model.addAttribute("winner", true);
    } else {
      model.addAttribute("winner", false);
      gameService.switchPlayer();
    }

    model.addAttribute("emptyCell",board.getEmptyCell());
    model.addAttribute("currentPlayer", gameService.getPlayerCoordinator().getCurrentPlayerCharacter());
    return "board.html";
  }

  @PostMapping("/{row}/{col}/write")
  public RedirectView write(HttpSession session, @PathVariable Integer row, @PathVariable Integer col) {
    gameService.updateBoard(row, col);
    return new RedirectView("/board");
  }


}
