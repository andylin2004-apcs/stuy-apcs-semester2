import java.util.Random;
import java.util.Arrays;

class QuickTest{
  public static void main(String[] args) {
    Random rng = new Random();
    System.out.println("Testing for array length 100000000");
    int[] test1 = new int[100000000];
    int[] test2 = new int[100000000];

    for (int i = 0; i<100000000; i+=2){
      test1[i] = rng.nextInt(100000000)*-1;
      test1[i+1] = test1[i];
      test2[i] = test1[i];
      test2[i+1] = test1[i];
    }

    Quick.quicksort(test1);
    Arrays.sort(test2);
    System.out.println(Arrays.equals(test1,test2));
    // System.out.println(Arrays.toString(test1));
    // System.out.println(Arrays.toString(test2));
  }
}
