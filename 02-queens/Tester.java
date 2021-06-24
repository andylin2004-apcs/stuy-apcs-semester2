class Tester{
  public static void main(String[] args) {
    for (int i = 13; i<14; i++){
      QueenBoard test = new QueenBoard(i);
      System.out.println("Now testing for "+i+"x"+i+" board");
      System.out.println(test.countSolutions()+"\n");
    }
  }
}
