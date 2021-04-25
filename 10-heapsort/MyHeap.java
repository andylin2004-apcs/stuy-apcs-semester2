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
  private static void pushDown(int[]data, int size, int index){
    while (2*index < size || (data[index] > data[2*index+1] && data[index] > data[2*index+2])){
      if (2*index+1 < size && data[index] < data[2*index+1]){
        int temp = data[index];
        data[index] = data[2*index+1];
        data[2*index+1] = data[index];
        index *= 2 + 1;
      }else if (2*index+2 < size && data[index] < data[2*index+2]){
        int temp = data[index];
        data[index] = data[2*index+2];
        data[2*index+2] = data[index];
        index *= 2 + 2;
      }
    }
  }

  /*Reorder the provided array to be a valid heap.
  *@param data is the array to be modified
  */
  private static void buildHeap(int[]data){

  }
}
