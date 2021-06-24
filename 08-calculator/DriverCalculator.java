import java.util.*;
import java.io.*;
public class DriverCalculator {
  public static void main(String[] args) {

    if (true) {
      boolean success = true;
      String s1 = "11 3 - 4 + 2.5 *";
      String s2 = "10 2.0 +";
      String s3 = "8 2 + 99 9 - * 2 + 9 -";
      String s4 = "1 -2 3 4 5 + * - -";
      if (Calculator.eval(s1) != 30.0) success = false;
      if (Calculator.eval(s2) != 12.0) success = false;
      if (Calculator.eval(s3) != 893.0) success = false;
      if (Calculator.eval(s4) != 30.0) success = false;
      if (success) {
        System.out.println("basic reading comprehension is good");
      } else {
        System.out.println("failing on the basics");
      }
    }

    if (true) {
      boolean excess = true;
      String p1 = "";
      String p2 = "4 2 3 5 1 - + x + x";
      String p3 = "5 3 7 9 + +";
      String p4 = "5 89 - 6 ~";
      try {
        Calculator.eval(p1);//Nothing to evaluate
        excess = false;
      }
      catch (IllegalArgumentException e) { }
      catch (RuntimeException e) { excess = false; }
      ////////
      try {
        Calculator.eval(p2);//not enough operands or too many operators
        excess = false;
      }
      catch (IllegalArgumentException e) { }
      catch (RuntimeException e) { excess = false; }
      /////////
      try {
        Calculator.eval(p3);//too many operands or not enough operators
        excess = false;
      }
      catch (IllegalArgumentException e) { }
      catch (RuntimeException e) { excess = false; }
      ////////
      try {
        Calculator.eval(p4);//Invalid operator or operand
        excess = false;
      }
      catch (IllegalArgumentException e) { }
      catch (RuntimeException e) { excess = false; }
      ////////
      if (excess) {
        System.out.println("exception stuff is good");
      } else {
        System.out.println("failing on the exceptions");
      }
      ////////
    }

    if (true) {
      boolean trials = true;
      for (int a = 0; a < 5; a++) {
        String[] pair = statement();
        Double found = Calculator.eval(pair[0]);
        Double correct = Double.parseDouble(pair[1]);
        if ( !found.equals(correct) ) trials = false;
      }
      if (trials) {
        System.out.println("random trials were good!");
      } else {
        System.out.println("code did not work on randomly generated post-fix statements");
      }
    }

///////////////////
  }

  private static String[] statement() {
    double num = 0;
    String ans = "";
    Random r = new Random();
    int halfLen = r.nextInt(10);
    Double[] operands = {4.0, -5.0, 6.0, -13.0, 32.0, 9.8, -41.0, 100.0, 2.0, -3.4};
    String[] operators = {"*", "-", "+", "/", "%", "*", "-", "+", "/", "%"};
    List<String> gators = Arrays.asList(operators);
    List<Double> bands = Arrays.asList(operands);
		Collections.shuffle(gators);  Collections.shuffle(bands);
		gators.toArray(operators);  bands.toArray(operands);
    for (int b = 0; b < halfLen; b++) {
      ans = operands[b]+" "+ans;
      if (b == 0) {
        ans = ""+operands[b];
        num = operands[b];
      } else {
        ans = ans+" "+operators[b];
        if (operators[b].equals("-")) {
          num = operands[b] - num;
        } else if (operators[b].equals("+")) {
          num = operands[b] + num;
        } else if (operators[b].equals("/")) {
          num = operands[b] / num;
        } else if (operators[b].equals("*")) {
          num = operands[b] * num;
        } else if (operators[b].equals("%")) {
          num = operands[b] % num;
        }
      }
    }
    String[] answer = {ans, num+""};
    return answer;
  }




////////////////////////
}
