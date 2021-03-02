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
  private static int removeAt(char[][] maze, int row, int col, String from){
    if (row == 0 || col == 0 || row == maze.length-1 || col == maze[0].length-1){
      return 0;
    }
    maze[row][col] = ' ';
    return 0;
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
