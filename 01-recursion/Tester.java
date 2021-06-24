import java.util.*;
import java.io.*;
public class Tester {
     public static void main(String[] args) {
          Random rng = new Random();
          boolean rworks = true;
          for (int t = 0; t < 1000; t++) {
               int size = rng.nextInt()%1000;
               String s = "";
               for (int i = 0; i < size; i++) s += (char)(rng.nextInt()%26 + 'a');
               String ans = Recursion.reverse(s);
               for (int i = 0; i < s.length(); i++)
                    if (s.charAt(i)!=ans.charAt(ans.length()-1-i)) {
                         rworks = false;
                         break;
                    }
               if (! rworks) break;
          }
          if (rworks) System.out.println("Congrats! Reverse works.");
          else System.out.println("Oops! Reverse doesn't work");
          boolean cworks = true;
          for (int t = 0; t < 7; t++) {
               long ans = Recursion.countNoDoubleLetterWords(t, "");
               long myans;
               if (t==0) myans = 1;
               else myans = 26 * (long)Math.pow(25, t-1);
               if (ans != myans) {
                    cworks = false;
                    break;
               }
               if (! cworks) break;
          }
          if (cworks) System.out.println("Congrats! countNoDoubleLetterWords works.");
          else System.out.println("Oops! countNoDoubleLetterWords doesn't work");
          boolean sworks = true;
          for (int t = 0; t < 1000; t++) {
               double test = (double)rng.nextInt();
               double myans = Math.sqrt(test);
               test = Recursion.sqrt(test);
               if (Math.abs(test-myans)/myans > 0.001) sworks=false;
               if (! sworks) break;
          }
          if (sworks) System.out.println("Congrats! Sqrt works.");
          else System.out.println("Oops! Sqrt doesn't work.");
     }
}
