import java.util.NoSuchElementException;
import java.util.*;

@SuppressWarnings("unchecked")
public class MyDeque<E>{
  private E[] data;
  private int size, start, end;
  private boolean firstDone = false;

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
    for (int i = start; i<end+1; i++){
      if (data[i] != null){
        result += data[i];
      }
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
    if (firstDone){
      start--;
    }
    size++;
    data[start] = element;
    firstDone = true;
  }
  public void addLast(E element){
    if (end == data.length-1){
      resize();
    }
    if (firstDone){
      end++;
    }
    size++;
    data[end] = element;
    firstDone = true;
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
    E[] newData = (E[])new Object[(data.length)*3];
    for (int i = start; i<end+1; i++){
      newData[size+i] = data[i];
    }
    data = newData;
    start = size+start;
    end = size+end;
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

  public static boolean equals(MyDeque<Integer>a, ArrayDeque<Integer>b){
    if(a==null && b==null)
    return true;
    if(a==null || b==null)
    return false;
    if(a.size()!=b.size())
    return false;
    if(a.size()==0 && b.size()==0)
    return true;

    try{
      while(b.size()>0){
        if(!a.removeFirst().equals(b.removeFirst())){
          return false;
        }
      }
    }catch(NoSuchElementException e){
      return false;
    }
    return b.size()==0;
  }

  public static int test6(int max){
    MyDeque<Integer> a = new MyDeque<Integer>();
    ArrayDeque<Integer>b = new ArrayDeque<Integer>();

    for(int i = 0; i < max; i++){
      int op = (int)(Math.random()*4);
      if(op == 0){
        a.addLast(i);
        b.addLast(i);
      }
      if(op == 1){
        a.addFirst(i);
        b.addFirst(i);
      }
      if(op == 2){
        if(b.size()>0){
          if(! a.getLast().equals(b.getLast())){
            System.out.println("Fail test6a "+a.getLast()+" vs "+b.getLast());
            return 0;
          }
          a.removeLast();
          b.removeLast();
        }
      }
      if(op == 3){
        if(b.size()>0){
          if(! a.getFirst().equals(b.getFirst())){
            System.out.println("Fail test6a "+a.getFirst()+" vs "+b.getFirst());
            return 0;
          }
          a.removeFirst();
          b.removeFirst();
        }
      }
    }
    if( equals(a,b) ){
      return 1;
    }
    System.out.println("Fail test6 end");
    return 0;
  }

  public static void main(String[] args) {
    System.out.println(test6(10000));
  }
}
