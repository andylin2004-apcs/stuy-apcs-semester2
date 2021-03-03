import java.util.*;

class MazeGenerator{
  public static void generate(char[][]maze,int rows,int cols,int startrow,int startcol){
    if (!(startrow == 0 || startcol == 0 || startrow == maze.length-1 || startcol == maze[0].length-1)){
      maze[startrow][startcol] = ' ';
      String[] toDoArray = new String[]{"goUp", "goDown", "goLeft", "goRight"};
      List<String> toDo = Arrays.asList(toDoArray);
      processInstruct(maze, toDo, startrow, startcol);
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
    ArrayList<String> toDo = new ArrayList<String>();
    if (!direction.equals("down")){
      toDo.add("goDown");
    }
    if (!direction.equals("up")){
      toDo.add("goUp");
    }
    if (!direction.equals("right")){
      toDo.add("goRight");
    }
    if (!direction.equals("left")){
      toDo.add("goLeft");
    }
    processInstruct(maze, toDo, row, col);
    return 0;
  }

  private static void processInstruct(char[][] maze, List<String> toDo, int row, int col){
    Collections.shuffle(toDo);
    for (int i = 0; i<toDo.size(); i++){
      switch (toDo.get(i)) {
        case "goUp":
          removeAt(maze, row-1, col, "down");
        case "goDown":
          removeAt(maze, row+1, col, "up");
        case "goLeft":
          removeAt(maze, row, col-1, "right");
        default:
          removeAt(maze, row, col+1, "left");
      }
    }
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
