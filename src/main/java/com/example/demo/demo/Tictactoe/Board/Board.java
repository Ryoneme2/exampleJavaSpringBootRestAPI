package com.example.demo.demo.Tictactoe.Board;

public class Board {

  private int[][] field;

  public Board() {
    this.field = new int[3][3];
  }

  public void setCoordinate(int x, int y) {
    field[x][y] = 1;
  }

  public int[][] getField() {
    return field;
  }
}