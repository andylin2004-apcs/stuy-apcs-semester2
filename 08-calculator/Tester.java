/******************************************************************************
 *  Compilation:  javac Tester.java
 *  Execution:    java Tester [DEBUG]
 *
 *  DEBUG: Whether to add extra outputs (seed, error output). Defaults true.
 ******************************************************************************/

public class Tester {
    public static void main(String[] args) {
        boolean DEBUG = true;
        if (args.length > 0 && Boolean.parseBoolean(args[0]) == false) DEBUG = false;
        TesterMethods t = new TesterMethods(DEBUG);
        String test = "";

        test = "Calculator.eval()";
        try {
            t.check(test, Calculator.eval("10 2.0 +"), 12.0);
            t.check(test, Calculator.eval("11 3 - 4 + 2.5 *"), 30.0);
            t.check(test, Calculator.eval("8 2 + 99 9 - * 2 + 9 -"), 893.0);
            t.check(test, Calculator.eval("1 2 3 4 5 + * - -"), 26.0);
            t.check(test, Calculator.eval("5 9 + 2 * 6 5 * +"), 58.0);
            t.check(test, Calculator.eval("4 5 7 2 + - *"), -16.0);
            t.check(test, Calculator.eval("3 4 + 2 * 7 /"), 2.0);
            t.check(test, Calculator.eval("5 7 + 6 2 - *"), 48.0);
            t.check(test, Calculator.eval("4 2 + 3 5 1 - * +"), 18.0);

            Calculator.eval("4 2 3 5 1 - + * + *");
            t.noException(test, "IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            try {
                Calculator.eval("5 3 7 9 + +");
                t.noException(test, "IllegalArgumentException");
            } catch (IllegalArgumentException e1) {}
        } catch (RuntimeException e) {
            t.except(test, e);
        }

        t.results();
    }
}
