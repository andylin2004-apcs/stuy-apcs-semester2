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
      String read = in.nextLine();
      ArrayList<Integer> fieldLine = new ArrayList<Integer>();
      for(int lineChar = 0; lineChar<read.length(); lineChar++){
        char next = read.charAt(lineChar);
        if (next == '*'){
          fieldLine.add(-1);
        }else{
          fieldLine.add(0);
        }
      }
      field.add(fieldLine);
    }
    System.out.println(field);
    initData = new Scanner(in.nextLine());
    int startRow = Integer.parseInt(initData.next());
    int startCol = Integer.parseInt(initData.next());
    int endRow = Integer.parseInt(initData.next());
    int endCol = Integer.parseInt(initData.next());
    field.get(startRow-1).set(startCol-1, 1);
    for (int i = 0; i<timeLimit; i++){
      ArrayList<ArrayList<Integer>> fieldEdited = new ArrayList<ArrayList<Integer>>();
      for (int rowHere = 0; rowHere<field.size(); rowHere++){
        ArrayList<Integer> fieldLine = new ArrayList<Integer>();
        for (int colHere = 0; colHere<field.get(0).size(); colHere++){
          fieldLine.add(field.get(rowHere).get(colHere));
        }
        fieldEdited.add(fieldLine);
      }
      System.out.println(" "+fieldEdited);
      for (int rowHere = 0; rowHere<field.size(); rowHere++){
        for (int colHere = 0; colHere<field.get(0).size(); colHere++){
          if (field.get(rowHere).get(colHere) > 0){
            if (rowHere != 0 && fieldEdited.get(rowHere-1).get(colHere) != -1){
              fieldEdited.get(rowHere-1).set(colHere, field.get(rowHere).get(colHere)+fieldEdited.get(rowHere-1).get(colHere));
            }
            if (colHere != 0 && fieldEdited.get(rowHere).get(colHere-1) != -1){
              fieldEdited.get(rowHere).set(colHere-1, field.get(rowHere).get(colHere)+fieldEdited.get(rowHere).get(colHere-1));
            }
            if (rowHere != field.size()-1 && fieldEdited.get(rowHere+1).get(colHere) != -1){
              fieldEdited.get(rowHere+1).set(colHere, field.get(rowHere).get(colHere)+fieldEdited.get(rowHere+1).get(colHere));
            }
            if (colHere != field.get(0).size()-1 && fieldEdited.get(rowHere).get(colHere+1) != -1){
              fieldEdited.get(rowHere).set(colHere+1, field.get(rowHere).get(colHere)+fieldEdited.get(rowHere).get(colHere+1));
            }
          }
        }
      }
      System.out.println("e"+fieldEdited);
      field = (ArrayList<ArrayList<Integer>>)fieldEdited.clone();
    }
    System.out.println(field);
    System.out.println(field.get(endRow-1).get(endCol-1));
    return field.get(endRow-1).get(endCol-1);
  }

  public static void main(String[] args) throws FileNotFoundException{
    silver("data2.dat");
  }
}
