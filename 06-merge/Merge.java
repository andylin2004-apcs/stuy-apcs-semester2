class Merge{
  public static void mergesort(int[]data){
    mergesort(data, 0, data.length);
  }
  public static int[] mergesort(int[] data, int low, int high){
    if (data.length > 1){
      mergesort(data, 0, Math.round(data.length/2));
      mergesort(data, Math.round(data.length/2), data.length);
      //merge together
    }
    return data;
  }
}
