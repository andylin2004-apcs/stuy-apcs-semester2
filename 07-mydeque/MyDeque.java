import java.util.NoSuchElementException;

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
    start = Math.round(initialCapacity/2);
    end = Math.round(initialCapacity/2);
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
    nullPointExc(element);
    if (start <= 0){
      resize();
    }
    if (size != 0){
      start--;
    }
    size++;
    data[start] = element;
  }
  public void addLast(E element){
    nullPointExc(element);
    if (end >= data.length-1){
      resize();
    }
    if (size != 0){
      end++;
    }
    size++;
    data[end] = element;
  }
  public E removeFirst(){
    noSuchExc();
    E returnData = data[start];
    data[start] = null;
    start++;
    size--;
    return returnData;
  }
  public E removeLast(){
    noSuchExc();
    E returnData = data[end];
    data[end] = null;
    end--;
    size--;
    return returnData;
  }
  public E getFirst(){
    noSuchExc();
    return data[start];
  }
  public E getLast(){
    noSuchExc();
    return data[end];
  }
  private void resize(){
    E[] newData = (E[])new Object[(size+1)*3];
    for (int i = 0; i<size; i++){
      newData[size+i] = data[i+start];
    }
    data = newData;
    start = size;
    end = size+start-1;
    if (size == 0){
      end++;
    }
  }
  private void noSuchExc(){
    if (size == 0){
      throw new NoSuchElementException();
    }
  }
  private void nullPointExc(E input){
    if (input == null){
      throw new NullPointerException();
    }
  }
}
