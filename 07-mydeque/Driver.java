public class Driver{

  public static void main(String[] args) {
    MyDeque funs = new MyDeque();
    int[] ree = {0, 1, 2, 4, 3, 5, 6, 7, 8, 9, 10};
    for (int i = 0; i < ree.length; i++) {
      funs.addFirst(ree[i]);
    }
    System.out.println(funs.toString());
    for (int i = 0; i < 3; i++) {
      funs.removeLast();
    }
    System.out.println(funs.toString());
    System.out.println(funs.removeLast());
    System.out.println(funs.toString());
  }

}
