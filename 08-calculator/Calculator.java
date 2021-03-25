import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Calculator{
  /*Evaluate a postfix expression stored in s.
   *Assume valid postfix notation, of ints doubles and operators separated by spaces.
   *Valid operators are + - / * and % (remainder not modulo)
   *All results are doubles even if the operands are both int.
   *@throws IllegalArgumentException when there are too many or too few operands.
   *        Use the string parameter of your exception to indicate what happened.
  */
  static ArrayDeque<Double> stack;
  public static double eval(String s){
    Scanner mathEq = new Scanner(s);
    stack = new ArrayDeque<Double>();

    while (mathEq.hasNext()){
      String cur = mathEq.next();
      switch(cur){
        case "*":
          checkOperandCount();
          double num1 = stack.removeLast();
          double num2 = stack.removeLast();

          stack.addLast(num2*num1);
          break;
        case "/":
          checkOperandCount();
          num1 = stack.removeLast();
          num2 = stack.removeLast();

          stack.addLast(num2/num1);
          break;
        case "+":
          checkOperandCount();
          num1 = stack.removeLast();
          num2 = stack.removeLast();

          stack.addLast(num2+num1);
          break;
        case "-":
          checkOperandCount();
          num1 = stack.removeLast();
          num2 = stack.removeLast();

          stack.addLast(num2-num1);
          break;
        default:
          stack.addLast(Double.parseDouble(cur));
      }
    }
    if (stack.size() != 1){
      throw new IllegalArgumentException();
    }
    return stack.getLast();
  }

  private static void checkOperandCount(){
    if (stack.size() < 2){
      throw new IllegalArgumentException();
    }
  }
}
