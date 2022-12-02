package com.example.demo.demo.Tictactoe;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.demo.Tictactoe.Board.Board;

@RestController
@RequestMapping(path = "api/v1/boards")
public class Controller {
  @GetMapping
  public List<int[][]> getBoardField() {
    Board board = new Board();
    int[][] field = board.getField();
    System.out.println(field);
    return List.of();
  }
}
