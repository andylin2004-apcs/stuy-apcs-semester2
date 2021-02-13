import java.util.Arrays;

class QueenBoard{
  private int[][]board;

  public QueenBoard(int size){
    board = new int[size][size];
    this.resetBoard();
  }

  private void resetBoard(){
    for (int i = 0; i<this.board.length; i++){
      for (int v = 0; v<this.board[0].length; v++){
        board[i][v] = 0;
      }
    }
  }

  private void checkForNonZero(){
    for (int i = 0; i<this.board.length; i++){
      for (int v = 0; v<this.board[0].length; v++){
        if (this.board[i][v] != 0) throw new IllegalStateException();
      }
    }
  }
  /**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *_ _ Q _
  *Q _ _ _
  *_ _ _ Q
  *_ Q _ _
  *(pythonic string notation for clarity,
  *excludes the character up to the *)
  */
  public String toString(){
    String result = "";
    for (int i = 0; i<board.length; i++){
      String returnLine = "";
      for (int v = 0; v<board[i].length; v++){
        if (board[i][v] == -1) { returnLine += "Q"; }
        else { returnLine += "_";}
        returnLine += " ";
      }
      result += returnLine + "\n";
    }
    return result;
  }

  /**Find the first solution configuration possible for this size board. Start by placing
  *  the 1st queen in the top left corner, and each new queen in the next COLUMN. When backtracking
  *  move the previous queen down to the next valid space. This means everyone will generate the same
  *  first solution.
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        returns true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value (e.g. you solved a 2nd time.)
  */
  public boolean solve(){
    this.checkForNonZero();
    int total = 0;
    for (int i = 0; i<this.board.length; i++){
      if (solve(0,0,0)) return true;
    }
    this.resetBoard();
    return false;
  }

  private int countSolutions(int numInserted, int nextRow, int nextCol){
    if (numInserted == this.board.length){
      return 1;
    }
    if (addQueen(nextRow, nextCol)){
      int totalPossible = 0;
      for (int i = 0; i<this.board.length; i++){
        totalPossible += countSolutions(numInserted+1, i, nextCol+1);
        if (numInserted + 1 == this.board.length) break;
      }
      removeQueen(nextRow, nextCol);
      return totalPossible;
    }else{
      return 0;
    }
  }

  private boolean solve(int numInserted, int nextRow, int nextCol){
    if (numInserted == this.board.length){
      return true;
    }
    if (addQueen(nextRow, nextCol)){
      for (int i = 0; i<this.board.length; i++){
        if (solve(numInserted+1, i, nextCol+1)) return true;
      }
      removeQueen(nextRow, nextCol);
      return false;
    }else{
      return false;
    }
  }

  /**Find all possible solutions to this size board.
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value (e.g. you ran solve() before this method)
  */
  public int countSolutions(){
    this.checkForNonZero();
    int total = 0;
    for (int i = 0; i<this.board.length; i++){
      total += this.countSolutions(0, i, 0);
    }
    this.resetBoard();
    return total;
  }

  private boolean addQueen(int r, int c){
    if (this.board[r][c] != 0) return false;
    this.board[r][c] = -1;
    this.changeRisk(r, c, 1);
    return true;
  }

  private void removeQueen(int r, int c){
    if (this.board[r][c] != -1) return;
    this.board[r][c] = 0;
    this.changeRisk(r, c, -1);
  }

  private void changeRisk(int r, int c, int changeBy){
    //for column
    for (int i = 0; i<this.board[r].length; i++){
      if (i == c) continue;
      this.board[r][i] += changeBy;
    }
    //for row
    for (int i = 0; i<this.board.length; i++){
      if (i == r) continue;
      this.board[i][c] += changeBy;
    }
    //for diagonals (top left down)
    for (int i = 1; i<this.board.length; i++){
      if (r-i < 0 || c-i < 0) break;
      this.board[r-i][c-i] += changeBy;
    }
    for (int i = 1; i<this.board.length; i++){
      if (r+i >= this.board.length || c+i >= this.board.length) break;
      this.board[r+i][c+i] += changeBy;
    }
    //for diagonals (bottom left up)
    for (int i = 1; i<this.board.length; i++){
      if (r-i < 0 || c+i >= this.board.length) break;
      this.board[r-i][c+i] += changeBy;
    }
    for (int i = 1; i<this.board.length; i++){
      if (r+i >= this.board.length || c-i < 0) break;
      this.board[r+i][c-i] += changeBy;
    }
  }

}
