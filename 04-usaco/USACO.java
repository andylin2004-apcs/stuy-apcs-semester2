import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

class USACO{
  public static int bronze(String filename) throws FileNotFoundException{
    Scanner in = new Scanner(new File(filename));
    ArrayList<ArrayList<Integer>> field = new ArrayList<ArrayList<Integer>>();
    ArrayList<ArrayList<Integer>> instruct = new ArrayList<ArrayList<Integer>>();
    Scanner initData = new Scanner(in.nextLine());
    int row = Integer.parseInt(initData.next());
    int col = Integer.parseInt(initData.next());
    int goalElev = Integer.parseInt(initData.next());
    int numInstruct = Integer.parseInt(initData.next());
    for(int i = 0; i<row; i++){
      Scanner read = new Scanner(in.nextLine());
      field.add(new ArrayList<Integer>());
      while(read.hasNext()){
        field.get(i).add(Integer.parseInt(read.next()));
      }
    }
    while(in.hasNextLine()){
      Scanner read = new Scanner(in.nextLine());
      ArrayList<Integer> instructLine = new ArrayList<Integer>();
      while(read.hasNext()){
        instructLine.add(Integer.parseInt(read.next()));
      }
      instruct.add(instructLine);
    }
    return 0;
  }
  public static long silver(String filename) throws FileNotFoundException{
    Scanner in = new Scanner(new File(filename));
    return 0;
  }

  public static void main(String[] args) throws FileNotFoundException{
    bronze("data1.dat");
  }
}
