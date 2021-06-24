import java.util.Arrays;
import java.util.Random;
public class ComparisonDriver {
  public static void main(String[]args) {
    if(args.length < 1){
      System.out.println("usage: java Driver SIZE [STYLE] [TEST]");
      System.out.println("supported STYLE: random,equal,sorted,reversed");
    } else {


      int[] randData = new int[Integer.parseInt(args[0])];

      //overhead: 1 random array generation.
      if(args.length < 2 || args[1].equals("random")) {
				Random rng = new Random(Integer.parseInt(args[0]));
	      for (int num = 0; num < Integer.parseInt(args[0]); num++) {
					randData[num] = rng.nextInt() - Integer.parseInt(args[0]) / 2;
				}
      } else if(args[1].equals("equal")) {
				for (int num = 0; num < Integer.parseInt(args[0]); num++) {
					randData[num] = 0;
				}
      } else if(args[1].equals("sorted")) {
				for (int num = 0; num < Integer.parseInt(args[0]); num++) {
					randData[num] = num;
				}
      } else if(args[1].equals("reversed")) {
				for (int num = Integer.parseInt(args[0])-1, index = 0; index < Integer.parseInt(args[0]); num--, index++) {
					randData[num] = index;
				}
      }

	  if (args.length == 3) {//anything exists in test.
		  int[] randDataMerge = Arrays.copyOf(randData, randData.length);
		  Arrays.sort(randData);
		  Merge.mergesort(randDataMerge);

		  if(Arrays.equals(randData,randDataMerge)) {
          	System.out.println("Merge Correct!");
          } else {
         	System.out.println("Merge Not Correct!!!!!!!!!11oneeleven");
          }
	  } else {
		 Arrays.sort(randData);
	  }
    }
  }
}
