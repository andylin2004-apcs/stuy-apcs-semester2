import java.util.*;

class MazeGenerator{
  public static void generate(char[][]maze,int rows,int cols,int startrow,int startcol){
    if (!(startrow == 0 || startcol == 0 || startrow == maze.length-1 || startcol == maze[0].length-1)){
      maze[startrow][startcol] = ' ';
      removeAt(maze, startrow+1, startcol, "up");
      removeAt(maze, startrow, startcol+1, "left");
      removeAt(maze, startrow-1, startcol, "down");
      removeAt(maze, startrow, startcol-1, "right");
    }
    for (int i = 0; i<maze.length; i++){
      for (int v = 0; v<maze[0].length; v++){
        System.out.print(maze[i][v]);
      }
      System.out.println();
    }
  }
  private static int removeAt(char[][] maze, int row, int col, String direction){
    if (row == 0 || col == 0 || row == maze.length-1 || col == maze[0].length-1 || maze[row][col] == ' ' || checkParallelSurround(maze, row, col)){
      return 0;
    }
    maze[row][col] = ' ';
    for (int i = 0; i<maze.length; i++){
      for (int v = 0; v<maze[0].length; v++){
        System.out.print(maze[i][v]);
      }
      System.out.println();
    }
    System.out.println();
    int returnNum = 0;
    if (!direction.equals("down")){
      returnNum += removeAt(maze, row+1, col, "up");
    }
    if (!direction.equals("up")){
      returnNum += removeAt(maze, row-1, col, "down");
    }
    if (!direction.equals("right")){
      returnNum += removeAt(maze, row, col+1, "left");
    }
    if (!direction.equals("left")){
      returnNum += removeAt(maze, row, col-1, "right");
    }
    return returnNum;
  }
  private static boolean checkParallelSurround(char[][] maze, int row, int col){
    if ((maze[row-1][col] == ' ' && maze[row][col+1] == ' ') || (maze[row-1][col] == ' ' && maze[row][col-1] == ' ') || (maze[row+1][col] == ' ' && maze[row][col+1] == ' ') || (maze[row+1][col] == ' ' && maze[row][col-1] == ' ')){
      return true;
    }
    return false;
  }
  public static void main(String[] args) {
    char[][] maze = new char[8][8];
    for (int i = 0; i<maze.length; i++){
      for (int v = 0; v<maze[0].length; v++){
        maze[i][v] = '#';
      }
    }
    generate(maze, maze.length, maze[0].length, 1, 1);
  }
}
