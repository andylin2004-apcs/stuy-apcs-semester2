import java.util.*;

class Driver1{
  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    for (int i = 0; i < 10000000; i++) {
      Random seeder = new Random();
      int seed = seeder.nextInt();
      Random rng = new Random(seed);

      int[] a2 = new int[rng.nextInt(1) + 5];
      for (int j = 0; j < a2.length; j++) {
        a2[j] = rng.nextInt();
      }

      MyHeap.buildHeap(a2);
    }
    System.out.println((System.currentTimeMillis()-start));
  }
}
