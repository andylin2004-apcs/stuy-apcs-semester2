import java.util.*;
import java.io.*;
public class Maze{

 private char[][]mazeList;
 private boolean animate;//false by default

 /*Constructor loads a mazeList text file, and sets animate to false by default.
   When the file is not found then:
      throw a FileNotFoundException

   You may assume the file contains a rectangular ascii mazeList, made with the following 4 characters:
   '#' - Walls - locations that cannot be moved onto
   ' ' - Empty Space - locations that can be moved onto
   'E' - the location of the goal (exactly 1 per file)
   'S' - the location of the start(exactly 1 per file)

   You may also assume the mazeList has a border of '#' around the edges.
   So you don't have to check for out of bounds!
 */
 public Maze(String filename) throws FileNotFoundException{
   ArrayList<ArrayList<Character>> mazeList = new ArrayList<ArrayList<Character>>();
   //instead of a try/catch, you can throw the FileNotFoundException.
   //This is generally bad behavior

   File text = new File(filename);
   // can be a path like: "/full/path/to/file.txt" or "../data/file.txt"

   //inf stands for the input file
   Scanner inf = new Scanner(text);

   while(inf.hasNextLine()){
       String line = inf.nextLine();
       mazeList.add(new ArrayList<Character>());
       System.out.println(line);//hopefully you can do other things with the line
       for (int i = 0; i<line.length(); i++){
         mazeList.get(mazeList.size()-1).add(line.charAt(i));
       }
   }

   System.out.println(mazeList);

   char[][] mazeReturn = new char[mazeList.size()][mazeList.get(0).size()];
   for (int i = 0; i<mazeList.size(); i++){
     for (int v = 0; v<mazeList.get(0).size(); v++){
       mazeReturn[i][v] = mazeList.get(i).get(v);
     }
   }
 }

 private void wait(int millis){
      try {
          Thread.sleep(millis);
      }
      catch (InterruptedException e) {
      }
  }

 public void setAnimate(boolean b){
     animate = b;
 }

 public static void clearTerminal(){
     //erase terminal
     System.out.println("\033[2J");
 }
 public static void gotoTop(){
   //go to top left of screen
   System.out.println("\033[1;1H");
 }

 /*Return the string that represents the mazeList.
  It should look like the text file with some characters replaced.
 */
 public String toString(){
         return "WRITE THIS METHOD";
 }

 /*Wrapper Solve Function returns the helper function
   Note the helper function has the same name, but different parameters.
   Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
 */
 public int solve(){
         //only clear the terminal if you are running animation
         if(animate){
           clearTerminal();
         }
         //start solving at the location of the s.
         //return solve(???,???);
         return 0;
 }

 /*
   Recursive Solve function:

   A solved mazeList has a path marked with '@' from S to E.

   Returns the number of @ symbols from S to E when the mazeList is solved,
   Returns -1 when the mazeList has no solution.

   Postcondition:
     The 'S' is replaced with '@'
     The 'E' remain the same
     All visited spots that were not part of the solution are changed to '.'
     All visited spots that are part of the solution are changed to '@'
 */
 private int solve(int row, int col){ //you can add more parameters since this is private
     //automatic animation! You are welcome.
     if(animate){
         gotoTop();
         System.out.println(this);
         wait(50);
     }

     if (mazeList[row][col] == '#'){
       return -1;
     }
     return -1; //so it compiles
 }

 private static String colorize(String s){
  s = s.replace("@", "\033[32m\033[49m@\033[0m");
  s = s.replace("#", "\033[37m\033[47m#\033[0m");
  s = s.replace("E", "\033[35m\033[49mE\033[0m");
  return s;
}
}
