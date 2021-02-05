class Recursion{
  public static String reverse(String s){
    if (s.length() <= 1){ return s; }
    else { return reverse(s.substring(1, s.length())) + s.charAt(0);}
  }
  public static long countNoDoubleLetterWords(int length,String word){
    if (length == 0){ return 1; }
    for (int i = 0; i<=26; i++){
      if (word.charAt(word.length()-1) == 'a'+i){ continue; }
      else { return countNoDoubleLetterWords(length-1, word+('a'+i)); }
    }
    return 0;
  }
  public static double sqrt(double n){

  }
}
