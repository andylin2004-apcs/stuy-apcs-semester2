import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

class USACO{
  public static int bronze(String filename) throws FileNotFoundException{
    Scanner in = new Scanner(new File(filename));
    ArrayList<ArrayList<Integer>> field = new ArrayList<ArrayList<Integer>>();
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
      int Rs = Integer.parseInt(read.next())-1;
      int Cs = Integer.parseInt(read.next())-1;
      int removeBy = Integer.parseInt(read.next());
      int max = -10;
      for (int i = Rs; i<Rs+3; i++){
        for (int v = Cs; v<Cs+3; v++){
          max = Math.max(max, field.get(i).get(v));
        }
      }
      max -= removeBy;
      for (int i = Rs; i<Rs+3; i++){
        for (int v = Cs; v<Cs+3; v++){
          if (field.get(i).get(v) > max){
            field.get(i).set(v, max);
          }
        }
      }
    }
    int total = 0;
    for (int i = 0; i<row+1; i++){
      for (int v = 0; v<col+1; v++){
        if (goalElev > field.get(i).get(v)){
          total += goalElev - field.get(i).get(v);
        }
      }
    }
    return total*72*72;
  }
  public static long silver(String filename) throws FileNotFoundException{
    Scanner in = new Scanner(new File(filename));
    return 0;
  }

  public static void main(String[] args) throws FileNotFoundException{
    bronze("data1.dat");
  }
}
