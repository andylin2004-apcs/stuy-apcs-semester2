/**
 * @author Christopher Liu
 * Tester Methods for APCS2 Labs
 * MKS22X - AP Computer Science A, Konstantinovich
 * Stuyvesant High School
 */

public class TesterMethods {
    private int ERR;
    private boolean DEBUG;

    /**
     * Sets up a tester instance.
     * 
     * @param DEBUG whether to print random seeds and exception stack traces.
     */
    public TesterMethods(boolean DEBUG) {
        this.ERR = 0;
        this.DEBUG = DEBUG;
    }

    /**
     * Compare the test case with the expected result and print a failure
     * message if they are not the same.
     * 
     * @param test the test name.
     * @param actual the test object.
     * @param expected the expected result.
     */
    public void check(String test, Object actual, Object expected) {
        if (actual == null || expected == null) {
            if (actual != null) {
                System.out.println("Failure on " + test + ": Expected \"" +
                                expected + "\", got \"" + actual + "\".");
                ERR++;
            }
            return;
        }

        if (!actual.equals(expected)) {
            System.out.println("Failure on " + test + ": Expected \"" +
                                expected + "\", got \"" + actual + "\".");
            ERR++;
        }
    }

    /**
     * Compare the test case with the expected result and print a failure
     * message if they are not the same with the random seed if in debug mode.
     * 
     * @param test the test name.
     * @param actual the test object.
     * @param expected the expected result.
     * @param seed the random seed.
     */
    public void check(String test, Object actual, Object expected, int seed) {
        if (actual == null || expected == null) {
            if (actual != null) {
                System.out.print("Failure on " + test + ": Expected \"" +
                                expected + "\", got \"" + actual + "\".");
                if (DEBUG) System.out.println(" Seed: " + seed);
                else System.out.println();
                ERR++;
            }
            return;
        }
        
        if (!actual.equals(expected)) {
            System.out.print("Failure on " + test + ": Expected \"" +
                                expected + "\", got \"" + actual + "\".");
            if (DEBUG) System.out.println(" Seed: " + seed);
            else System.out.println();
            ERR++;
        }
    }

    /**
     * Print a failure message for an unexpected exception and print the stack
     * trace if in debug mode.
     * 
     * @param test the test name.
     * @param e the Exception object.
     */
    public void except(String test, Exception e) {
        System.out.println("Failure on " + test + ": RuntimeException");
        if (DEBUG) System.out.println(e.toString());
        ERR++;
    }

    /**
     * Print a failure message if an exception was supposed to occur but did
     * not.
     * 
     * @param test the test name.
     * @param expected the expected Exception object.
     */
    public void noException(String test, String expected) {
        System.out.println("Failure on " + test + ": Expected " + expected);
        ERR++;
    }

    /**
     * Do nothing with the objects (only here to prvent IDE linter warnings).
     * 
     * @param nothings objects to do nothing with.
     */
    public void nothing(Object... nothings) {
        return;
    }

    /**
     * Print the results of the tests: if there are no errors, an "All good!"
     * message is printed; if there are 1+ errors, an "Uh oh..." message is
     * printed.
     */
    public void results() {
        if (ERR == 0) System.out.println("All good!");
        else if (ERR == 1) System.out.println("Uh oh... 1 error found.");
        else System.out.println("Uh oh... " + ERR + " errors found.");
    }
}
