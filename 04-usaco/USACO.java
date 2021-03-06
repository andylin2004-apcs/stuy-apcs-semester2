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
    Scanner initData = new Scanner(in.nextLine());
    int row = Integer.parseInt(initData.next());
    int col = Integer.parseInt(initData.next());
    int timeLimit = Integer.parseInt(initData.next());
    ArrayList<ArrayList<Integer>> field = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i<row; i++){
      Scanner read = new Scanner(in.nextLine());
      ArrayList<Integer> fieldLine = new ArrayList<Integer>();
      while(read.hasNext()){
        String next = read.next();
        if (next.equals("*")){
          fieldLine.add(-1);
        }else{
          fieldLine.add(0);
        }
      }
      field.add(fieldLine);
    }
    initData = new Scanner(in.nextLine());
    int startRow = Integer.parseInt(initData.next());
    int startCol = Integer.parseInt(initData.next());
    int endRow = Integer.parseInt(initData.next());
    int endCol = Integer.parseInt(initData.next());
    for (int i = 0; i<timeLimit; i++){
      ArrayList<ArrayList<Integer>> fieldEdited = new ArrayList<ArrayList<Integer>>();
      for (int rowHere = 0; row<field.size(); row++){
        ArrayList<Integer> fieldLine = new ArrayList<Integer>();
        for (int colHere = 0; col<field.get(0).size(); col++){
          fieldLine.add(field.get(row).get(col));
        }
        fieldEdited.add(fieldLine);
      }
      field.get(startRow).set(startCol, 1);
      for (int rowHere = 0; row<field.size(); row++){
        for (int colHere = 0; col<field.get(0).size(); col++){
          if (field.get(row).get(col) > 0){
            if (row != 0 && fieldEdited.get(row-1).get(col) != -1){
              fieldEdited.get(row).set(col, fieldEdited.get(row).get(col)+fieldEdited.get(row-1).get(col));
            }
            if (col != 0 && fieldEdited.get(row).get(col-1) != -1){
              fieldEdited.get(row).set(col, fieldEdited.get(row).get(col)+fieldEdited.get(row).get(col-1));
            }
            if (row != field.size()-1 && fieldEdited.get(row+1).get(col) != -1){
              fieldEdited.get(row).set(col, fieldEdited.get(row).get(col)+fieldEdited.get(row+1).get(col));
            }
            if (col != field.get(0).size()-1 && fieldEdited.get(row).get(col+1) != -1){
              fieldEdited.get(row).set(col, fieldEdited.get(row).get(col)+fieldEdited.get(row).get(col+1));
            }
          }
        }
      }
      field = fieldEdited;
    }
    return field.get(endRow).get(endCol);
  }

  public static void main(String[] args) throws FileNotFoundException{
    bronze("data1.dat");
  }
}
