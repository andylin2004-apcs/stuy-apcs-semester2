import java.util.*;

class MazeGenerator{
  public static void generate(char[][]maze,int rows,int cols,int startrow,int startcol){
    removeAt(maze, startrow, startcol);
    for (int i = 0; i<maze.length; i++){
      for (int v = 0; v<maze[0].length; v++){
        System.out.print(maze[i][v]);
      }
      System.out.println();
    }
  }
  private static Boolean removeAt(char[][] maze, int row, int col){
    if (row == 0 || col == 0 || row == maze.length || col == maze[0].length){
      return false;
    }
    maze[row][col] = ' ';
    return true;
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
