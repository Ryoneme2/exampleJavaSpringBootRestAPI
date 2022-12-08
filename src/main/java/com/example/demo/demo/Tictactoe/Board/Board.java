package com.example.demo.demo.Tictactoe.Board;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import com.example.demo.demo.Tictactoe.Board.BestMove.Move;

public class Board {

  private int[][] field;

  public Board() {
  }

  public Board(int[][] field) {
    this.field = field;
  }

  public int[][] getField() {
    return this.field;
  }

  public void setField(int[][] field) {
    this.field = field;
  }

  public Board field(int[][] field) {
    setField(field);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Board)) {
      return false;
    }
    Board board = (Board) o;
    return Objects.equals(field, board.field);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(field);
  }

  @Override
  public String toString() {
    return "{" +
        " field='" + getField() + "'" +
        "}";
  }

  public int[][] getBoardRandomMove() {
    List<int[]> count = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (this.field[i][j] == 0) {
          int[] coordinate = new int[2];
          coordinate[0] = i;
          coordinate[1] = j;
          count.add(coordinate);
        }
      }
    }

    System.out.println(count);

    Random rand = new Random();
    int randomNumber = rand.nextInt(count.size());
    int[] randomCoordinate = count.get(randomNumber);
    this.field[randomCoordinate[0]][randomCoordinate[1]] = 2;

    return this.field;
  }

  public int[][] getBoardRandomBestMove() {
    BestMove bm = new BestMove();
    Move m = bm.getMove(this.field);
    this.field[m.row][m.col] = 2;
    return this.field;
  }

  public String status() {
    int n = 3;
    int count = 0;
    for (int r = 0; r < n; r++) {
      if (this.field[r][0] == 1 && this.field[r][1] == 1 && this.field[r][2] == 1) {
        return "win";
      } else if (this.field[r][0] == 2 && this.field[r][1] == 2 && this.field[r][2] == 2) {
        return "lose";
      } else if (this.field[0][r] == 1 && this.field[1][r] == 1 && this.field[2][r] == 1) {
        return "win";
      } else if (this.field[0][r] == 2 && this.field[1][r] == 2 && this.field[2][r] == 2) {
        return "lose";
      } else if (this.field[0][0] == 1 && this.field[1][1] == 1 && this.field[2][2] == 1) {
        return "win";
      } else if (this.field[0][0] == 2 && this.field[1][1] == 2 && this.field[2][2] == 2) {
        return "lose";
      } else if (this.field[0][2] == 1 && this.field[1][1] == 1 && this.field[2][0] == 1) {
        return "win";
      } else if (this.field[0][2] == 2 && this.field[1][1] == 2 && this.field[2][0] == 2) {
        return "lose";
      }
      for (int c = 0; c < 3; c++) {
        if (this.field[r][c] == 1 || this.field[r][c] == 2)
          count++;
      }
    }

    if (count == 9)
      return "draw";
    return "null";
  }

  public void setCoordinate(int x, int y) {
    field[x][y] = 1;
  }

}