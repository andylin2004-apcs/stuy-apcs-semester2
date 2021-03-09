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
      int rowStart = Integer.parseInt(read.next())-1;
      int colStart = Integer.parseInt(read.next())-1;
      int removeBy = Integer.parseInt(read.next());
      int max = -1;
      for (int i = rowStart; i<rowStart+3; i++){
        for (int v = colStart; v<colStart+3; v++){
          max = Math.max(max, field.get(i).get(v));
        }
      }
      for (int i = rowStart; i<rowStart+3; i++){
        for (int v = colStart; v<colStart+3; v++){
          if (field.get(i).get(v) > max-removeBy){
            field.get(i).set(v, max-removeBy);
          }
        }
      }
    }
    int total = 0;
    for (int i = 0; i<field.size(); i++){
      for (int v = 0; v<field.get(0).size(); v++){
        if (field.get(i).get(v) < goalElev){
          total += goalElev - field.get(i).get(v);
        }
      }
    }
    return total * 72 * 72;
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
      for (int rowHere = 0; rowHere<field.size(); rowHere++){
        for (int colHere = 0; colHere<field.get(0).size(); colHere++){
          if (field.get(rowHere).get(colHere) > 0){
            if (rowHere != 0 && field.get(rowHere-1).get(colHere) != -1){
              fieldEdited.get(rowHere-1).set(colHere, field.get(rowHere).get(colHere)+fieldEdited.get(rowHere-1).get(colHere));
            }
            if (colHere != 0 && field.get(rowHere).get(colHere-1) != -1){
              fieldEdited.get(rowHere).set(colHere-1, field.get(rowHere).get(colHere)+fieldEdited.get(rowHere).get(colHere-1));
            }
            if (rowHere != field.size()-1 && field.get(rowHere+1).get(colHere) != -1){
              fieldEdited.get(rowHere+1).set(colHere, field.get(rowHere).get(colHere)+fieldEdited.get(rowHere+1).get(colHere));
            }
            if (colHere != field.get(0).size()-1 && field.get(rowHere).get(colHere+1) != -1){
              fieldEdited.get(rowHere).set(colHere+1, field.get(rowHere).get(colHere)+fieldEdited.get(rowHere).get(colHere+1));
            }
            fieldEdited.get(rowHere).set(colHere, 0);
          }
        }
      }
      field = (ArrayList<ArrayList<Integer>>)fieldEdited.clone();
    }
    return field.get(endRow-1).get(endCol-1);
  }
}
