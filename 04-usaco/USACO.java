import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

class USACO{
  public static int bronze(String filename) throws FileNotFoundException{
    Scanner in = new Scanner(new File(filename));
    ArrayList<ArrayList<Integer>> field = new ArrayList<ArrayList<Integer>>();
    while (in.hasNextLine()){
      String read = in.nextLine();
      field.add(new ArrayList<Integer>());
      for (int i = 0; i<read.length(); i+=2){
        field.get(field.size()-1).add((int)read.charAt(i));
      }
    }
    return 0;
  }
  public static long silver(String filename) throws FileNotFoundException{
    Scanner in = new Scanner(new File(filename));
    return 0;
  }
}
