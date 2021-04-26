class MyHeap{
  /*Swap the element at the provided index downward into the correct position.
  This will swap with the larger of the child nodes provided thatchild is larger.
  This stops when a leaf is reached, or neither child is larger.
  *@param size the number of heap elements in the data array.
  This is needed to allow a partially full array to be provided.
  *@precondition the children of data[index] are valid heaps.
  *@precondition index is between 0 and size-1 inclusive
  *@precondition size is between 0 and data.length inclusive.
  */
  public static void pushDown(int[]data, int size, int index){
    while (2*index+2 < size && (data[index] < data[2*index+1] || data[index] < data[2*index+2])){
      if (data[2*index+2] <= data[2*index+1] && data[index] < data[2*index+1]){
        int temp = data[index];
        data[index] = data[2*index+1];
        data[2*index+1] = temp;
        index *= 2;
        index += 1;
      }else if (data[2*index+2] > data[2*index+1] && data[index] < data[2*index+2]){
        int temp = data[index];
        data[index] = data[2*index+2];
        data[2*index+2] = temp;
        index *= 2;
        index += 2;
      }
    }
  }

  /*Reorder the provided array to be a valid heap.
  *@param data is the array to be modified
  */
  public static void buildHeap(int[]data){
    for (int i = (data.length-2)/2; i>=0; i--){
      pushDown(data, data.length, i);
    }
  }

  /*Swap the root node with the element at the provided index.
  *Then push the new root down, but not past the index that it swapped with.
  *@precondition: size is between 0 and data.length inclusive.
  */
 private static void remove(int[]data,int size){

 }

 /*Sort the provided array
  *@param data is the array to be sorted
  */
 public static void heapsort(int[]data){

 }

}
