import java.util.Random;
import java.util.Arrays;

class Quick{

  /*return the value that is the kth smallest value of the array.
  *@param data must have a length > 0
  *@param k is 0 to data.length-1 inclusive
  *@postcondition The array can be modified. (If we did not want to modify the array, we could make a copy before we start the process)
  */
  public static int quickselect(int[]data, int k){
    return quickselect(data, 0, data.length, k);
  }

  public static void quicksort(int[] data){
    int start = 0;
    int end = data.length;
    // partition(data, start, end);
  }

  /*Modify the array such that:
  *1. A random index from start to end inclusive is chosen, the corresponding
  *   element is designated the pivot element.
  *2. all elements in range that are smaller than the pivot element are placed before the pivot element.
  *3. all elements in range that are larger than the pivot element are placed after the pivot element.
  *4. Only the indices from start to end inclusive are considered in range
  *@return the index of the final position of the pivot element.
  */
  public static int quickselect( int [] data, int start, int end, int k){
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
      if (data[interval] < pivot || (data[interval] == pivot && rng.nextInt(2) == 0)){
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
    if (pivot == k){
      return addLeft;
    }else if (k < pivot){
      return quickselect(data, 0, addLeft, k);
    }
    return quickselect(data, addLeft, data.length, k);
  }

}
