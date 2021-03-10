import java.util.Random;
import java.util.Arrays;

class Preliminary{
  /*Modify the array such that:
       *1. A random index from start to end inclusive is chosen, the corresponding
       *   element is designated the pivot element.
       *2. all elements in range that are smaller than the pivot element are placed before the pivot element.
       *3. all elements in range that are larger than the pivot element are placed after the pivot element.
       *4. Only the indices from start to end inclusive are considered in range
       *@return the index of the final position of the pivot element.
    */
  public static int partition ( int [] data, int start, int end){
    Random rng = new Random();
    int randomNum = rng.nextInt(end-start+1)+start;
    int temp = data[randomNum];
    int addLeftAt = 0;
    int addRightAt = end+1;
    data[randomNum] = data[0];
    data[0] = temp;
    randomNum = data[0];
    System.out.println(randomNum);
    System.out.println(Arrays.toString(data));

    for(int i = start+1; i<end+1; i++){

      if (addLeftAt >= end || addRightAt <= start){
        break;
      }
      System.out.print("meems");
      int random2 = rng.nextInt(2);
      if (data[i] < randomNum || (data[i] == randomNum && random2 == 0)){
        addLeftAt++;
        temp = data[addLeftAt];
        data[addLeftAt] = data[i];
        data[i] = temp;
        i--;
      }
      System.out.println(Arrays.toString(data));
      System.out.println(addLeftAt+""+addRightAt);

    }
    temp = data[addLeftAt];
    data[addLeftAt] = randomNum;
    data[0] = temp;
    System.out.println(Arrays.toString(data));
    System.out.println(addLeftAt+""+addRightAt);
    return randomNum-start;
  }

  public static void main(String[] args) {
    partition(new int[]{4,40,20,1,69}, 0, 2);
  }
}
