import java.io.*;
import java.util.*;
public class MaxTester {

    public static void main(String[] args) {
        int simpletests = 100;
        int simpleops = 10;
        int inttests = 1000;
        int intops = 1000;
        int hardtests = 200;
        int hardops = 100;
        boolean fail = false;
        System.out.println("Preliminary testing with shorter integer expressions:");
        for (int seed = 0; seed < simpletests; seed++) {
            if(fail) break;
            Random rng = new Random(seed);
            int answer = nxtint(rng);
            String expression = genint(rng, simpleops, answer);
            double guess = Calculator.eval(expression);
            if (Math.abs(answer - guess)/answer > 0.001) {
                fail=true;
                System.out.println("You did an oopsie on seed " + seed);
                System.out.println("Original expression: " + expression);
                System.out.println("Correct answer: " + answer);
                System.out.println("Your answer: " + guess);
            }
        }
        System.out.println("Stress testing with integer expressions:");
        for (int seed = 0; seed < inttests; seed++) {
            if(fail) break;
            Random rng = new Random(seed);
            int answer = nxtint(rng);
            String expression = genint(rng, intops, answer);
            double guess = Calculator.eval(expression);
            if (Math.abs(answer - guess)/answer > 0.001) {
                fail=true;
                System.out.println("You did an oopsie on seed " + seed);
                System.out.println("Original expression: " + expression);
                System.out.println("Correct answer: " + answer);
                System.out.println("Your answer: " + guess);
            }
        }
        if (! fail) System.out.println("Testing double expressions:");
        for (int seed = 0; seed < hardtests; seed++) {
            if(fail) break;
            Random rng = new Random(seed);
            double answer = nxt(rng);
            String expression = generate(rng, hardops, answer);
            double guess = Calculator.eval(expression);
            if (Math.abs(answer - guess)/answer > 0.01) {
                fail=true;
                System.out.println("You did an oopsie on seed " + seed);
                System.out.println("Original expression: " + expression);
                System.out.println("Correct answer: " + answer);
                System.out.println("Your answer: " + guess);
            }
        }
        if (! fail) System.out.println("Testing exceptions:");
        String[] bad = {"1 1 + +",
        "5 5 5 5 +",
        "%",
        "8 8",
        "8 + 8 3 2 5 6 2 3 4",
        "5 8 2 - 5 8 / - 2 * 5 % 8 +"};
        String[] mistake = {"too many operators", "too many operands"};
        for (int i = 0; i < bad.length; i++) {
            if(fail) break;
            try {
                Calculator.eval(bad[i]);
                fail=true;
                System.out.println("Your exceptions failed for the expression " + bad[i]);
                System.out.println("It looks like you need to account for " + mistake[i%2]);
            } catch (IllegalArgumentException e) {}
            catch (RuntimeException e) {
                fail=true;
                System.out.println("Your exceptions failed for the expression " + bad[i]);
                System.out.println("It looks like you need to account for " + mistake[i%2]);
            }
            if(fail) break;
        }
        if (! fail) System.out.println("Congrats!");
    }

    public static int nxtint(Random rng) {
        int ans = rng.nextInt(50)+1;
        if (rng.nextBoolean()) ans = -ans;
        return ans;
    }

    public static double nxt(Random rng) {
        double ans = rng.nextDouble();
        while (ans<-100 || ans>100 || ans==0) ans = rng.nextDouble();
        return ans;
    }

    public static String genint(Random rng, int ops, int ans) {
        if (ops==0) return String.valueOf(ans);
        long a=100000000, b=100000000;
        int c = rng.nextInt(ops);
        String end = "";
        while (Math.abs(a) >= 100000 || Math.abs(b) >= 100000) {
            switch (rng.nextInt(5)) {
                case 0:
                    a = nxtint(rng);
                    b = ans-a;
                    end = "+";
                    break;
                case 1:
                    b = nxtint(rng);
                    a = ans+b;
                    end = "-";
                    break;
                case 2:
                    a = 1;
                    for (int i = 0; i < 100; i++) {
                        int temp = nxtint(rng);
                        if (ans%temp==0) {
                            a = temp;
                            break;
                        }
                    }
                    b = ans/a;
                    end = "*";
                    break;
                case 3:
                    b = nxtint(rng);
                    a = ans*b;
                    end = "/";
                    break;
                case 4:
                    b = Math.abs(nxtint(rng));
                    if (b <= Math.abs(ans)) b += Math.abs(ans);
                    int temp = rng.nextInt(100);
                    if (ans<0) {
                        a = ans - temp*b;
                        b = -b;
                    } else a = ans + temp*b;
                    end = "%";
                    break;
            }
        }
        return genint(rng, c, (int)a) + " " + genint(rng, ops-1-c, (int)b) + " " + end;
    }

    public static String generate(Random rng, int ops, double ans) {
        if (ops==0) return String.valueOf(ans);
        double a=0, b=0;
        int c = rng.nextInt(ops);
        String end = "";
        switch (rng.nextInt(5)) {
            case 0:
                a = nxt(rng);
                b = ans-a;
                end = "+";
                break;
            case 1:
                b = nxt(rng);
                a = ans+b;
                end = "-";
                break;
            case 2:
                a = nxt(rng);
                b = ans/a;
                end = "*";
                break;
            case 3:
                b = nxt(rng);
                a = ans*b;
                end = "/";
                break;
            case 4:
                b = Math.abs(nxt(rng));
                if (b <= Math.abs(ans)) b += Math.abs(ans);
                int temp = rng.nextInt(100);
                if (ans<0) {
                    a = ans - temp*b;
                    b = -b;
                } else a = ans + temp*b;
                end = "%";
                break;
        }
        return generate(rng, c, a) + " " + generate(rng, ops-1-c, b) + " " + end;
    }

}
