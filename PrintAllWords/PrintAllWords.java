class PrintAllWords{
  public static void printAllWords(int length){
    printAllWords(length,"");
  }
  public static void printAllWords(int length,String word){
    if (length == 0){ System.out.println(word); }
    else{
      for (int i = 97; i < 123; i++){
        printAllWords(length-1, (word+(char)i));
      }
    }
  }
  /*Print all words that are made of the characters in letters. There may not be consecutive equal letters,
  *aax is not allowed, but axa is allowed.
  *@param length : the length of the words that are to be printed
  *@param letters: the letters you should be using
  */
  public static void printNoDoubleLetterWords(int length,char[] letters){
    printNoDoubleLetterWords(length,"",letters);
  }

  /*Print all words that are made of the characters in letters. There may not be consecutive equal letters,
  *aax is not allowed, but axa is allowed.
  *@param length : either how many more letters need to be
  *@param word   : the partial word so far.
  *@param letters: the letters you should be using
  */
  public static void printNoDoubleLetterWords(int length,String word,char[]letters){
    if (length == 0){ System.out.println(word); }
    else{
      for (char letter : letters){
        if (word.length() > 0 && word.charAt(word.length()-1) == letter){continue;}
        printNoDoubleLetterWords(length-1, (word+letter), letters);
      }
    }
  }
}
