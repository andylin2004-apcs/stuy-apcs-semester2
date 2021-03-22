@SuppressWarnings("unchecked")
public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    data = (E[])new Object[10];
    size = 0;
    start = 5;
    end = 5;
  }
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    size = 0;
    start = Math.round(initialCapacity/2)-1;
    end = Math.round(initialCapacity/2)-1;
  }
  public int size(){
    return size;
  }
  public String toString(){
    String result = "{";
    for (int i = start; i<start+size; i++){
      result += data[i];
      if (i<end){
        result += ", ";
      }
    }
    return result+"}";
  }
  public void addFirst(E element){
    if (start == 0){
      resize();
    }
    start--;
    size++;
    data[start] = element;
  }
  public void addLast(E element){
    if (end == data.length-1){
      resize();
    }
    end++;
    size++;
    data[end] = element;
  }
  public E removeFirst(){
    E returnData = data[start];
    data[start] = null;
    start++;
    size--;
    return returnData;
  }
  public E removeLast(){
    E returnData = data[end];
    data[end] = null;
    end--;
    size--;
    return returnData;
  }
  public E getFirst(){
    return data[start];
  }
  public E getLast(){
    return data[end];
  }
  private void resize(){
    E[] newData = (E[])new Object[size*3];
    for (int i = start; i<=end; i++){
      newData[size+i] = data[i];
    }
    data = newData;
    start = size;
    end = size+end;
  }
}
