class QueenBoard{
  private int[][]board;

  public QueenBoard(int size){
    board = new int[size][size];
    for (int i = 0; i<size; i++){
      for (int v = 0; v<size; v++){
        board[i][v] = 0;
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
  // public boolean solve(){}

  /**Find all possible solutions to this size board.
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value (e.g. you ran solve() before this method)
  */
  // public int countSolutions(){}

  private boolean addQueen(int r, int c){
    if (board[r][c] != 0) return false;
    board[r][c] = -1;
    //for column
    for (int i = 0; i<board[r].length; i++){
      if (i == c) continue;
      board[r][i] += 1;
    }
    //for row
    for (int i = 0; i<board.length; i++){
      if (i == r) continue;
      board[i][c] += 1;
    }
    //for diagonals (top left down)
    for (int i = 1; i<board.length; i++){
      if (r-i < 0 || c-i < 0) break;
      board[r-i][c-i] += 1;
    }
    for (int i = 1; i<board.length; i++){
      if (r+i >= board.length || c+i >= board.length) break;
      board[r+i][c+i] += 1;
    }
    //for diagonals (bottom left up)
    for (int i = 1; i<board.length; i++){
      if (r-i < 0 || c+i >= board.length) break;
      board[r-i][c-i] += 1;
    }
    for (int i = 1; i<board.length; i++){
      if (r+i >= board.length || c-i < 0) break;
      board[r+i][c+i] += 1;
    }
    return true;
  }

  private void removeQueen(int r, int c){}
}
