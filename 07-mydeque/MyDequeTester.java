import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Random;

public class MyDequeTester extends TesterMethods {

	public static void main(String[] args) {
		DEBUG = false;
		boolean failure = false;
		int tests = 1000;
		failure = toStringTester(50) || failure;
		failure = throwsTester(tests) || failure;
		failure = addFirstTester(tests) || failure;
		failure = addLastTester(tests) || failure;
		failure = resizeTester(tests) || failure;
		failure = getFirstTester(tests) || failure;
		failure = getLastTester(tests) || failure;
		failure = removeFirstTester(tests) || failure;
		failure = removeLastTester(tests) || failure;
		failure = sizeTester(tests) || failure;
		failure = randomTester(tests) || failure;

		overall(failure);
	}

	public static boolean toStringTester(int tests) {
		tester("toString");
		boolean fail = false;
		Random rng = new Random(42);

		MyDeque<Object> tested = new MyDeque<Object>();
		ArrayDeque<Object> reference = new ArrayDeque<Object>();
		for (int test = 0; test < tests; test++) {
			Object add;
			switch (rng.nextInt(7)) {//generates a random object to add
				case 0:
					add = rng.nextInt();
					break;
				case 1:
					add = rng.nextLong();
					break;
				case 2:
					add = rng.nextBoolean();
					break;
				case 3:
					add = reference.toString();
					break;
				case 4:
					byte[] bytes = new byte[2];
					rng.nextBytes(bytes);
					add = bytes;
					break;
				case 5:
					add = rng.nextFloat();
					break;
				case 6:
					add = rng.nextDouble();
					break;
				default:
					add = 42;
					break;
			}

			tested.addFirst(add);
			reference.addFirst(add);
		}


		String referenceString = reference.toString();
		referenceString = "{" + referenceString.substring(1, referenceString.length() - 1) + "}";
		if (tested.toString().equals(referenceString)) {//checks to see all the elements are equal
			passMessage("toString");
		} else {
			fail = true;
			errorMessage("toString", referenceString, tested.toString());
		}

		methodMessage("toString", fail);
		return fail;
	}

	public static boolean throwsTester(int tests) {
		tester("throws");
		boolean fail  = false;

		for (int length = 0; length < tests; length++) {
			if (DEBUG) subtest(length + " length array");
			MyDeque<String> test = new MyDeque<String>(length);

			String subsection = "addFirst";
			try {
				test.addFirst(null);
				fail = true;
				errorMessage("No Exception. Expected NullPointerException");
			} catch (NullPointerException e) {
				if (DEBUG) subtest(subsection);
				passMessage(subsection);
			} catch (Exception e) {
				subtest(length + " length array");
				subtest(subsection);
				e.printStackTrace();
				fail = true;
				errorMessage("Wrong exception. Need a NullPointerException");
			}

			subsection = "addLast";
			try {
				test.addLast(null);
				fail = true;
				errorMessage("No Exception. Expected NullPointerException");
			} catch (NullPointerException e) {
				if (DEBUG) subtest(subsection);
				passMessage(subsection);
			} catch (Exception e) {
				subtest(length + " length array");
				subtest(subsection);
				e.printStackTrace();
				fail = true;
				errorMessage("Wrong exception. Need a NullPointerException");
			}

			subsection = "removeFirst";
			try {
				test.removeFirst();
				fail = true;
				errorMessage("No Exception. Expected NoSuchElementException");
			} catch (NoSuchElementException e) {
				if (DEBUG) subtest(subsection);
				passMessage(subsection);
			} catch (Exception e) {
				subtest(length + " length array");
				subtest(subsection);
				e.printStackTrace();
				fail = true;
				errorMessage("Wrong exception. Need a NoSuchElementException");
			}

			subsection = "removeLast";
			try {
				test.removeLast();
				fail = true;
				errorMessage("No Exception. Expected NoSuchElementException");
			} catch (NoSuchElementException e) {
				if (DEBUG) subtest(subsection);
				passMessage(subsection);
			} catch (Exception e) {
				subtest(length + " length array");
				subtest(subsection);
				e.printStackTrace();
				fail = true;
				errorMessage("Wrong exception. Need a NoSuchElementException");
			}

			subsection = "getFirst";
			try {
				test.getFirst();
				fail = true;
				errorMessage("No Exception. Expected NoSuchElementException");
			} catch (NoSuchElementException e) {
				if (DEBUG) subtest(subsection);
				passMessage(subsection);
			} catch (Exception e) {
				subtest(length + " length array");
				subtest(subsection);
				e.printStackTrace();
				fail = true;
				errorMessage("Wrong exception. Need a NoSuchElementException");
			}

			subsection = "getLast";
			try {
				test.getLast();
				fail = true;
				errorMessage("No Exception. Expected NoSuchElementException");
			} catch (NoSuchElementException e) {
				if (DEBUG) subtest(subsection);
				passMessage(subsection);
			} catch (Exception e) {
				subtest(length + " length array");
				subtest(subsection);
				e.printStackTrace();
				fail = true;
				errorMessage("Wrong exception. Need a NoSuchElementException");
			}
		}

		methodMessage("throwsTester", fail);
		return fail;
	}

	public static boolean addFirstTester(int tests) {
		tester("addFirst");
		boolean fail = false;

		for (int test = 0; test < tests; test++) {
			MyDeque<Integer> tested = new MyDeque<Integer>(test);
			ArrayDeque<Integer> reference = new ArrayDeque<Integer>(test);

			for (int n = 0; n < test; n++) {
				tested.addFirst(n);
				reference.addFirst(n);
			}

			String referenceString = reference.toString();
			referenceString = "{" + referenceString.substring(1, referenceString.length() - 1) + "}";
			if (tested.toString().equals(referenceString)) {
				passMessage(test);
			} else {
				fail = true;
				errorMessage(test, referenceString, tested.toString());
			}

		}

		methodMessage("addFirst", fail);
		return fail;
	}

	public static boolean addLastTester(int tests) {
		tester("addLast");
		boolean fail = false;

		for (int test = 0; test < tests; test++) {
			MyDeque<Integer> tested = new MyDeque<Integer>(test);
			ArrayDeque<Integer> reference = new ArrayDeque<Integer>(test);

			for (int n = 0; n < test; n++) {
				tested.addLast(n);
				reference.addLast(n);
			}

			String referenceString = reference.toString();
			referenceString = "{" + referenceString.substring(1, referenceString.length() - 1) + "}";
			if (tested.toString().equals(referenceString)) {
				passMessage(test);
			} else {
				fail = true;
				errorMessage(test, referenceString, tested.toString());
			}

		}

		methodMessage("addLast", fail);
		return fail;
	}

	public static boolean resizeTester(int tests) {
		tester("resize");
		boolean fail = false;

		subtest("addFirst");
		for (int test = 0; test < tests; test++) {
			MyDeque<Integer> tested = new MyDeque<Integer>(0);
			ArrayDeque<Integer> reference = new ArrayDeque<Integer>(0);

			for (int n = 0; n < test; n++) {
				tested.addFirst(n);
				reference.addFirst(n);
			}

			String referenceString = reference.toString();
			referenceString = "{" + referenceString.substring(1, referenceString.length() - 1) + "}";
			if (tested.toString().equals(referenceString)) {
				passMessage(test);
			} else {
				fail = true;
				errorMessage(test, referenceString, tested.toString());
			}
		}

		subtest("addLast");
		for (int test = 0; test < tests; test++) {
			MyDeque<Integer> tested = new MyDeque<Integer>(0);
			ArrayDeque<Integer> reference = new ArrayDeque<Integer>(0);

			for (int n = 0; n < test; n++) {
				tested.addLast(n);
				reference.addLast(n);
			}

			String referenceString = reference.toString();
			referenceString = "{" + referenceString.substring(1, referenceString.length() - 1) + "}";
			if (tested.toString().equals(referenceString)) {
				passMessage(test);
			} else {
				fail = true;
				errorMessage(test, referenceString, tested.toString());
			}
		}

		methodMessage("resize", fail);
		return fail;
	}

	public static boolean getFirstTester(int tests) {
		tester("getFirst");
		boolean fail = false;
		Random rng = new Random(42);

		for (int test = 1; test < tests; test++) {
			MyDeque<Integer> tested = new MyDeque<Integer>();
			ArrayDeque<Integer> reference = new ArrayDeque<Integer>();

			for (int n = 0; n < test; n++) {
				int add = rng.nextInt();
				tested.addFirst(add);
				reference.addFirst(add);
			}

			if (tested.getFirst().equals(reference.getFirst())) {
				passMessage(test);
			} else {
				fail = true;
				errorMessage(test, reference.getFirst().toString(), tested.getFirst().toString());
			}
		}

		methodMessage("getFirst", fail);
		return fail;
	}

	public static boolean getLastTester(int tests) {
		tester("getLast");
		boolean fail = false;
		Random rng = new Random(42);

		for (int test = 1; test < tests; test++) {
			MyDeque<Integer> tested = new MyDeque<Integer>();
			ArrayDeque<Integer> reference = new ArrayDeque<Integer>();

			for (int n = 0; n < test; n++) {
				int add = rng.nextInt();
				tested.addFirst(add);
				reference.addFirst(add);
			}

			if (tested.getLast().equals(reference.getLast())) {
				passMessage(test);
			} else {
				fail = true;
				errorMessage(test, reference.getLast().toString(), tested.getLast().toString());
			}
		}

		methodMessage("getLast", fail);
		return fail;
	}

	public static boolean removeFirstTester(int tests) {
		tester("removeFirst");
		boolean fail = false;

		for (int test = 1; test < tests; test++) {
			MyDeque<Integer> tested = new MyDeque<Integer>(test);
			ArrayDeque<Integer> reference = new ArrayDeque<Integer>(test);

			for (int n = 0; n < test; n++) {
				tested.addFirst(n);
				reference.addFirst(n);
			}

			while (reference.size() > 0) {
				Integer testedRemoved = tested.removeFirst();
				Integer referenceRemoved = reference.removeFirst();

				if (testedRemoved.equals(referenceRemoved)) {
					passMessage(test);
				} else {
					fail = true;
					errorMessage(test, referenceRemoved.toString(), testedRemoved.toString());
				}
			}

		}

		methodMessage("removeFirst", fail);
		return fail;
	}

	public static boolean removeLastTester(int tests) {
		tester("removeLast");
		boolean fail = false;

		for (int test = 1; test < tests; test++) {
			MyDeque<Integer> tested = new MyDeque<Integer>(test);
			ArrayDeque<Integer> reference = new ArrayDeque<Integer>(test);

			for (int n = 0; n < test; n++) {
				tested.addFirst(n);
				reference.addFirst(n);
			}

			while (reference.size() > 0) {
				Integer testedRemoved = tested.removeLast();
				Integer referenceRemoved = reference.removeLast();

				if (testedRemoved.equals(referenceRemoved)) {
					passMessage(test);
				} else {
					fail = true;
					errorMessage(test, referenceRemoved.toString(), testedRemoved.toString());
				}
			}

		}

		methodMessage("removeLast", fail);
		return fail;
	}

	public static boolean sizeTester(int tests) {
		tester("size");
		boolean fail = false;

		subtest("addFirst");
		for (int test = 0; test < tests; test++) {
			MyDeque<Integer> tested = new MyDeque<Integer>();
			for (int n = 0; n < test; n++) tested.addFirst(n);

			if (tested.size() == test) {
				passMessage(test);
			} else {
				fail = true;
				errorMessage(test);
			}
		}

		subtest("addLast");
		for (int test = 0; test < tests; test++) {
			MyDeque<Integer> tested = new MyDeque<Integer>();
			for (int n = 0; n < test; n++) tested.addLast(n);

			if (tested.size() == test) {
				passMessage(test);
			} else {
				fail = true;
				errorMessage(test);
			}
		}

		subtest("removeFirst");
		for (int test = 1; test < tests; test++) {
			MyDeque<Integer> tested = new MyDeque<Integer>();
			for (int n = 0; n < test; n++) tested.addFirst(n);

			tested.removeFirst();
			if (tested.size() == test - 1) {
				passMessage(test);
			} else {
				fail = true;
				errorMessage(test);
			}
		}

		subtest("removeLast");
		for (int test = 1; test < tests; test++) {
			MyDeque<Integer> tested = new MyDeque<Integer>();
			for (int n = 0; n < test; n++) tested.addFirst(n);

			tested.removeLast();
			if (tested.size() == test - 1) {
				passMessage(test);
			} else {
				fail = true;
				errorMessage(test);
			}
		}

		methodMessage("size", fail);
		return fail;
	}

	public static boolean randomTester(int tests) {
		tester("random");
		boolean fail = false;
		Random rng = new Random(42);

		MyDeque<Object> tested = new MyDeque<Object>();
		ArrayDeque<Object> reference = new ArrayDeque<Object>();
		for (int test = 0; test < tests; test++) {
			boolean addOrRemove = rng.nextBoolean();//true is add, false is remove
			boolean firstOrLast = rng.nextBoolean();//true is first, false is last.

			if (addOrRemove || reference.size() == 1/*prevents throws*/) {//adds element
				Object add;
				switch (rng.nextInt(7)) {//generates a random object to add
					case 0:
						add = rng.nextInt();
						break;
					case 1:
						add = rng.nextLong();
						break;
					case 2:
						add = rng.nextBoolean();
						break;
					case 3:
						add = reference.toString();
						break;
					case 4:
						byte[] bytes = new byte[10];
						rng.nextBytes(bytes);
						add = bytes;
						break;
					case 5:
						add = rng.nextFloat();
						break;
					case 6:
						add = rng.nextDouble();
						break;
					default:
						add = 42;
						break;
				}

				if (firstOrLast) {
					tested.addFirst(add);
					reference.addFirst(add);
				} else {
					tested.addLast(add);
					reference.addLast(add);
				}
			} else {
				Object testedRemoved;
				Object referenceRemoved;

				if (firstOrLast) {
					testedRemoved = tested.removeFirst();
					referenceRemoved = reference.removeFirst();
				} else {
					testedRemoved = tested.removeLast();
					referenceRemoved = reference.removeLast();
				}

				if (testedRemoved.equals(referenceRemoved)) {
					passMessage("Test: " + test + " | First?: " + firstOrLast + " | Added?: " + addOrRemove);
				} else {
					fail = true;
					errorMessage("Test: " + test + " | First?: " + firstOrLast + " | Added?: " + addOrRemove);
					errorMessage(test, referenceRemoved.toString(), testedRemoved.toString());
				}
			}

			if (tested.getFirst().equals(reference.getFirst())) {
				passMessage("getFirst—Test: " + test + " | First?: " + firstOrLast + " | Added?: " + addOrRemove);
			} else {
				fail = true;
				errorMessage("getFirst—Test: " + test + " | First?: " + firstOrLast + " | Added?: " + addOrRemove);
				errorMessage(test, reference.getFirst().toString(), tested.getFirst().toString());
			}

			if (tested.getLast().equals(reference.getLast())) {
				passMessage("getLast—Test: " + test + " | First?: " + firstOrLast + " | Added?: " + addOrRemove);
			} else {
				fail = true;
				errorMessage("getLast—Test: " + test + " | First?: " + firstOrLast + " | Added?: " + addOrRemove);
				errorMessage(test, reference.getLast().toString(), tested.getLast().toString());
			}

			String referenceString = reference.toString();
			referenceString = "{" + referenceString.substring(1, referenceString.length() - 1) + "}";
			if (tested.toString().equals(referenceString)) {
				passMessage("getLast—Test: " + test + " | First?: " + firstOrLast + " | Added?: " + addOrRemove);
			} else {
				fail = true;
				errorMessage(test, referenceString, tested.toString());
			}
		}

		methodMessage("random", fail);
		return fail;
	}

}
