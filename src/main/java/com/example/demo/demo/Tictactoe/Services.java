package com.example.demo.demo.Tictactoe;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.demo.demo.Tictactoe.Board.Board;

@Service
public class Services {
  public List<int[]> getBoardField() {
    Board board = new Board(new int[3][3]);
    int[][] field = board.getField();
    return Arrays.stream(field).toList();
  }

  public Map<String, String> check(int[][] board) {
    Board b = new Board(board);
    Map<String, String> map = new HashMap<>();
    map.put("isWin", b.status(board));
    return map;
  }
}
