package com.example.demo.demo.Tictactoe.Board;

import java.util.ArrayList;
import java.util.Arrays;
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
    int count = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (this.field[i][j] == 1)
          count++;
      }
    }

    if (count == 1) {
      return getBoardRandomMove();
    }

    int[] losingPos = this.getLosingPosition();
    if (losingPos != null) {
      this.field[losingPos[0]][losingPos[1]] = 2;
      return this.field;
    }

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

  public int[] checkLosing() {
    int[][] f = this.field;
    if (f[0][0] == 1 && f[2][2] == 1 || f[0][2] == 1 && f[2][0] == 1) {
      int[] x = { 1, 1 };
      return x;
    }
    if (f[0][0] == 1 && f[1][1] == 1) {
      int[] x = { 2, 2 };
      return x;
    }
    if (f[2][2] == 1 && f[1][1] == 1) {
      int[] x = { 0, 0 };
      return x;
    }
    if (f[0][2] == 1 && f[1][1] == 1) {
      int[] x = { 2, 0 };
      return x;
    }
    if (f[2][0] == 1 && f[1][1] == 1) {
      int[] x = { 0, 2 };
      return x;
    }

    return null;
  }

  public int[] getLosingPosition() {
    // Loop through each space on the board
    int[] col = new int[3];
    int[] blankCol = new int[3];
    for (int i = 0; i < 3; i++) {
      int rowCount = 0;
      int blank = -1;
      for (int j = 0; j < 3; j++) {
        if (this.field[i][j] == 1) {
          rowCount++;
          col[j]++;
        }
        if (this.field[i][j] == 0) {
          blank = j;
          blankCol[j] = i;
        }
      }
      if (rowCount == 2) {
        int[] x = { i, blank };
        return x;
      }
    }
    for (int c = 0; c < 3; c++) {
      if (col[c] == 2) {
        int[] x = { c, blankCol[c] };
        return x;
      }
    }

    int[] diaCheck = this.checkLosing();

    if (diaCheck != null) {
      return diaCheck;
    }

    return null; // Game is not about to be a loss
  }

}