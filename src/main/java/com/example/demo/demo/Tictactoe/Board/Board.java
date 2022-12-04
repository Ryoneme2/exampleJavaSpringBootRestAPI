package com.example.demo.demo.Tictactoe.Board;

public class Board {

  private int[][] field;

  public Board(int[][] initField) {
    this.field = initField;
  }

  public String status(int[][] board) {
    int n = 3;
    for (int r = 0; r < n; r++) {
      if (board[r][0] == 1 && board[r][1] == 1 && board[r][2] == 1) {
        return "win";
      }
      if (board[r][0] == 2 && board[r][1] == 2 && board[r][2] == 2) {
        return "lose";
      }
      if (board[0][r] == 1 && board[1][r] == 1 && board[2][r] == 1) {
        return "win";
      }
      if (board[0][r] == 2 && board[1][r] == 2 && board[2][r] == 2) {
        return "lose";
      }
      if (board[r][r] == 1 && board[r][r] == 1 && board[r][r] == 1) {
        return "win";
      }
      if (board[r][r] == 2 && board[r][r] == 2 && board[r][r] == 2) {
        return "lose";
      }
    }
    return "null";
  }

  public void setCoordinate(int x, int y) {
    field[x][y] = 1;
  }

  public int[][] getField() {
    return field;
  }
}