import java.util.Arrays;

class Merge{
  public static void mergesort(int[]data){
    mergesort(data, 0, data.length-1);
  }
  public static int[] mergesort(int[] data, int low, int high){
    if (high-low+1 > 1){
      int[] array1 = mergesort(data, low, Math.round(high/2)-1);
      int[] array2 = mergesort(data, Math.round(high/2), high);
      //merge together
      int array1Slot = 0;
      int array2Slot = 0;
      for (int i = low; i<=high; i++){
        if (array2[array2Slot] >= array1[array1Slot]){
          data[i] = array2[array2Slot];
          array2Slot++;
        }else{
          data[i] = array1[array1Slot];
          array1Slot++;
        }
      }
    }
    return Arrays.copyOfRange(data, low, high);
  }
}
