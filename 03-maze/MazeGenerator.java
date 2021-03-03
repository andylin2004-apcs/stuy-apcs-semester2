import java.util.*;

class MazeGenerator{
  public static void generate(char[][]maze,int rows,int cols,int startrow,int startcol){
    if (!(startrow == 0 || startcol == 0 || startrow == maze.length-1 || startcol == maze[0].length-1)){
      maze[startrow][startcol] = ' ';
      String[] toDoArray = new String[]{"goUp", "goDown", "goLeft", "goRight"};
      List<String> toDo = Arrays.asList(toDoArray);
      Collections.shuffle(toDo);
      for (int i = 0; i<4; i++){
        switch (toDo.get(i)) {
          case "goUp":
            removeAt(maze, startrow-1, startcol, "down");
          case "goDown":
            removeAt(maze, startrow+1, startcol, "up");
          case "goLeft":
            removeAt(maze, startrow, startcol-1, "right");
          default:
            removeAt(maze, startrow, startcol+1, "left");
        }
      }
    }
    for (int i = 0; i<maze.length; i++){
      for (int v = 0; v<maze[0].length; v++){
        System.out.print(maze[i][v]);
      }
      System.out.println();
    }
  }
  private static int removeAt(char[][] maze, int row, int col, String direction){
    if (row == 0 || col == 0 || row == maze.length-1 || col == maze[0].length-1 || maze[row][col] == ' ' || checkAdjacents(maze, row, col)){
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

  private static boolean checkAdjacents(char[][] maze, int row, int col){
    int returnVal = 0;
    if (maze[row+1][col] == ' '){
      returnVal++;
    }
    if (maze[row-1][col] == ' '){
      returnVal++;
    }
    if (maze[row][col+1] == ' '){
      returnVal++;
    }
    if (maze[row][col-1] == ' '){
      returnVal++;
    }
    return returnVal > 1;
  }

  public static void main(String[] args) {
    char[][] maze = new char[8][8];
    for (int i = 0; i<maze.length; i++){
      for (int v = 0; v<maze[0].length; v++){
        maze[i][v] = '#';
      }
    }
    generate(maze, maze.length, maze[0].length, 4, 4);
  }
}
