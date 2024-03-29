import java.lang.Math;

class Recursion{
  public static String reverse(String s){
    if (s.length() <= 1){ return s; }
    else { return reverse(s.substring(1, s.length())) + s.charAt(0);}
  }
  public static long countNoDoubleLetterWords(int length,String word){
    if (length == 0){ return 1; }
    int total = 0;
    for (int i = 'a'; i<='z'; i++){
      if (word.length() > 0 && word.charAt(word.length()-1) == i){ continue; }
      total += countNoDoubleLetterWords(length-1, word+(char)i);
    }
    return total;
  }
  public static double sqrt(double n){
    return sqrt(n, n/2);
  }
  private static double sqrt(double n, double guess){
    double rounded = Math.round((Math.abs(guess*guess-n)/n)*10000);
    if (rounded/10000 <= 0.00001) { return guess; }
    else { return sqrt(n, ((n/guess)+guess)/2); }
  }
}
