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
    int randomNum = rng.nextInt(end-start+1)+start;
    // System.out.println(Arrays.toString(data));
    for (int i = start; i<end+1; i++){
      if ((data[randomNum] > data[i] && randomNum < i) || (data[randomNum] < data[i] && randomNum > i)){
        int temp = data[randomNum];
        data[randomNum] = data[i];
        data[i] = temp;
        randomNum = i;
        // System.out.println(Arrays.toString(data));
      }
    }
    for (int i = start; i<end+1; i++){
      if ((data[randomNum] > data[i] && randomNum < i) || (data[randomNum] < data[i] && randomNum > i)){
        int temp = data[randomNum];
        data[randomNum] = data[i];
        data[i] = temp;
        randomNum = i;
        // System.out.println(Arrays.toString(data));
      }
    }
    // System.out.println(Arrays.toString(data)+data[randomNum]+""+randomNum);
    return randomNum-start;
  }
  public static void main(String[] args) {
    partition(new int[]{40,40,40,1}, 0, 2);
  }
}
