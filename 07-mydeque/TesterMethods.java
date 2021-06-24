public class TesterMethods {

	public static boolean DEBUG = true;

	public static void overall(boolean failure) {
		System.out.println("\n ~~~ Overall Result ~~~");
		if (failure) {
			System.out.println("The deque was stacked against you!");
		} else {
			System.out.println("You believed in the heart of the cards!");
		}
	}

	public static void tester(String test) {
		System.out.println("\n ~~~ " + test + " ~~~\n");
	}

	public static void subtest(String subtest) {
		System.out.println("\n __ " + subtest + " __\n");
	}

	public static void passMessage(int testCase) {
		if (DEBUG) System.out.println("Test case " + testCase + " passed.");
	}

	public static void passMessage(String testCase) {
		if (DEBUG) System.out.println("Test case " + testCase + " passed.");
	}

	public static void errorMessage(int testCase) {
		System.out.println("Test case " + testCase + " failed.");
	}

	public static void errorMessage(String testCase) {
		System.out.println("Test case " + testCase + " failed.");
	}

	public static void errorMessage(String testCase, String expected, String actual) {
		errorMessage(testCase);
		System.out.println("Expected: " + expected);
		System.out.println("Actual:" + actual);
	}

	public static void errorMessage(String testCase, int expected, int actual) {
		errorMessage(testCase);
		System.out.println("Expected: " + expected);
		System.out.println("Actual:" + actual);
	}

	public static void errorMessage(int testCase, String expected, String actual) {
		errorMessage(Integer.toString(testCase), expected, actual);
	}

	public static void errorMessage(int testCase, int expected, int actual) {
		errorMessage(Integer.toString(testCase), Integer.toString(expected), Integer.toString(actual));
	}

	public static void methodMessage(String method, boolean fail) {
		if (fail) {
			System.out.println("\nAt least one test case failed for " + method);
		} else {
			System.out.println(method + " PASSED");
		}
	}

}
