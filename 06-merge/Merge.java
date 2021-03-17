import java.util.Arrays;

class Merge{
  public static void mergesort(int[]data){
    mergesort(data, 0, data.length-1);
  }
  private static int[] mergesort(int[] data, int low, int high){
    // System.out.println(high-low+1);
    if (high-low+1 > 1){
      int[] array1 = mergesort(data, low, Math.round((high-low)/2)+low);
      int[] array2 = mergesort(data, Math.round((high-low)/2)+low+1, high);
      //merge together
      int array1Slot = 0;
      int array2Slot = 0;
      int i = low;
      for (/*see above*/; i<=high && array1Slot<array1.length && array2Slot<array2.length; i++){
        if (array2[array2Slot] <= array1[array1Slot]){
          data[i] = array2[array2Slot];
          array2Slot++;
        }else{
          data[i] = array1[array1Slot];
          array1Slot++;
        }
      }
      if (array1Slot<array1.length){
        for(/*see above*/; i<=high && array1Slot<array1.length; i++){
          data[i] = array1[array1Slot];
          array1Slot++;
        }
      }else if (array2Slot<array2.length){
        for(/*see above*/; i<=high && array2Slot<array2.length; i++){
          data[i] = array2[array2Slot];
          array2Slot++;
        }
      }
    }
    return Arrays.copyOfRange(data, low, high+1);
  }
}
