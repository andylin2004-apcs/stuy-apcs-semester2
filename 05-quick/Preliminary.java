import java.util.Random;
import java.util.Arrays;

class Preliminary{
  /*Modify the array such that:
       *1. A random index from start to end inclusive is chosen, the corresponding
       *   element is designated the pivot element.
       *2. all elements in range that are smaller than the pivot element are placed before the pivot element.
       *3. all elements in range that are larger than the pivot element are placed after the pivot element.
       *4. Only the indices from start to end inclusive are considered in range
       *@return the index of the final position of the pivot element.
    */
  public static int partition ( int [] data, int start, int end){
    Random rng = new Random();
    int randomNum = rng.nextInt(end-start)+start;
    System.out.println(data[randomNum]);
    for (int i = start; i<end+1; i++){
      if (i == randomNum){
        continue;
      }
      if (data[i] > data[randomNum] && i < randomNum){
        int toMove = data[i];
        for (int arrayStop=i+1; arrayStop<randomNum+1; arrayStop++){
          data[arrayStop-1] = data[arrayStop];
        }
        data[randomNum] = toMove;
        randomNum -= 1;
        i -= 1;
      }else{

      }
    }
    System.out.println(Arrays.toString(data)+"");
    return 0;
  }
  public static void main(String[] args) {
    partition(new int[]{4,3,2,1}, 0, 3);
  }
}
