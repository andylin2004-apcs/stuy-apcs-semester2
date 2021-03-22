public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    size = 1;
    start = 5;
    end = 5;
  }
  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    size = 1;
    start = Math.round(initialCapacity/2);
    end = Math.round(initialCapacity/2);
  }
  public int size(){
    return size;
  }
  public String toString(){
    String result = "{";
    for (int i = start; i<=end; i++){
      result += data[i];
      if (i<end){
        result += ", ";
      }
    }
    return result+"}";
  }
  public void addFirst(E element){ }
  public void addLast(E element){ }
  public E removeFirst(){
    E returnData = data[start];
    data[start] = null;
    start++;
    return returnData;
  }
  public E removeLast(){
    E returnData = data[end];
    data[end] = null;
    end--;
    return returnData;
  }
  public E getFirst(){
    return data[start];
  }
  public E getLast(){
    return data[end];
  }

}
