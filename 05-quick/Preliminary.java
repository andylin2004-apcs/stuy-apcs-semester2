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
    int randomNum = rng.nextInt(end+1);
    int temp = data[start];
    data[start] = data[randomNum];
    data[randomNum] = temp;
    int pivot = data[start];
    int addLeft = start;
    System.out.println(pivot);
    System.out.println(Arrays.toString(data));
    for (int interval = start+1; interval <= end; interval++){
      if (data[interval] < pivot){
        addLeft++;
        temp = data[addLeft];
        data[addLeft] = data[interval];
        data[interval] = temp;
      }
      System.out.println(Arrays.toString(data)+addLeft);
    }
    temp = data[addLeft];
    data[addLeft] = pivot;
    data[start] = temp;
    System.out.println(Arrays.toString(data)+addLeft);
    return addLeft;
  }

  public static void main(String[] args) {
    partition(new int[]{4,40,20,1,69}, 1, 3);
  }
}
