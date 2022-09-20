package n_queens_52;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
  private final List<List<Queen>> possibleSolutions = new ArrayList<>();

  public int totalNQueens(int n) {
    for (int i = 0; i < n; i++) {
      Queen queen = new Queen(0, i);
      List<Queen> queens = new ArrayList<>();
      queens.add(queen);
      findAvailableQueen(queens, 1, n);
    }

    return possibleSolutions.size();
  }

  private void findAvailableQueen(List<Queen> existQueens, int rowNumber, int size) {
    if (existQueens.size() == size) {
      possibleSolutions.add(existQueens);
      return;
    }
    if (rowNumber == size) {
      return;
    }
    for (int columnNumber = 0; columnNumber < size; columnNumber++) {
      Queen queen = new Queen(rowNumber, columnNumber);
      if (isValidQueen(existQueens, queen)) {
        List<Queen> nextIterationQueens = new ArrayList<>(existQueens);
        nextIterationQueens.add(queen);
        findAvailableQueen(nextIterationQueens, rowNumber + 1, size);
      }
    }
  }

  private boolean isValidQueen(List<Queen> existQueens, Queen newQueen) {
    return existQueens.stream().noneMatch(queen -> isInSameLine(queen, newQueen));
  }

  private boolean isInSameLine(Queen queen, Queen newQueen) {
    if (queen.getX() == newQueen.getX()) {
      return true;
    }
    if (queen.getY() == newQueen.getY()) {
      return true;
    }
    return Math.abs(queen.getX() - newQueen.getX()) == Math.abs(queen.getY() - newQueen.getY());
  }

  private static class Queen {
    private int x;
    private int y;

    private Queen(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return x;
    }

    public void setX(int x) {
      this.x = x;
    }

    public int getY() {
      return y;
    }

    public void setY(int y) {
      this.y = y;
    }
  }
};
