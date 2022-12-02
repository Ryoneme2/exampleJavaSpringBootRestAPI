package com.example.demo.demo.Tictactoe;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.demo.Tictactoe.Board.Board;

@RestController
@RequestMapping(path = "api/v1/boards")
public class Controller {
  public <T> List<T> twoDArrayToList(T[][] twoDArray) {
    List<T> list = new ArrayList<T>();
    for (T[] array : twoDArray) {
      list.addAll(Arrays.asList(array));
    }
    return list;
  }

  @GetMapping
  public List<int[]> getBoardField() {
    Board board = new Board();
    int[][] field = board.getField();
    return Arrays.stream(field).toList();
  }
}
