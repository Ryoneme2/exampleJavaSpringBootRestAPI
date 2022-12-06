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

  public String check(Board board) {
    Board b = new Board(board.getField());
    return b.status();
  }

  public int[][] getBoardBotMove(Board board) {
    Board b = new Board(board.getField());
    return b.getBoardRandomMove();
  }
}
