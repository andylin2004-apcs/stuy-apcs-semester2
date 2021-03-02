class MazeGenerator{
  public static void generate(char[][]maze,int rows,int cols,int startrow,int startcol){
    maze = new char[rows][cols];
    for (int i = 0; i<rows; i++){
      for (int v = 0; i<cols; v++){
        maze[rows][cols] = '#';
      }
    }
    
  }
}
