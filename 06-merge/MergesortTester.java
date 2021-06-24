import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MergesortTester {
	private static boolean DEBUG = false;

	public static void main(String[] args) {
		boolean failure = false;
		failure = seededRandomSort(1000, 1000);
		failure = seededRandomSort(10, 1) || failure;
		failure = seededRandomSort(10, 0) || failure;
		failure = seededRandomSort(10, 2) || failure;
		failure = linearSort(1000) || failure;
		failure = reverseLinearSort(1000) || failure;
		failure = sameValueSort(1000) || failure;

		TesterMethods.overall(failure);
	}

	public static boolean seededRandomSort(int tests, int arrLen) {
		TesterMethods.tester("seededRandomSort");
		boolean fail = false;

		for (int test = 0; test < tests; test++) {
			Random rng = new Random(test);
			int[] sort = new int[arrLen];
			int[] expected = new int[arrLen];

			for (int i = 0; i < arrLen; i++) {
				int val = rng.nextInt(arrLen) - arrLen / 2;
				sort[i] = val;
				expected[i] = val;
			}

			if (DEBUG) {
				System.out.println(Arrays.toString(sort));
				System.out.println(Arrays.toString(expected));
			}

			Merge.mergesort(sort);
			Arrays.sort(expected);

			if (DEBUG) {
				System.out.println(Arrays.toString(sort));
				System.out.println(Arrays.toString(expected));
			}

			if (Arrays.equals(sort, expected)) {
				if (DEBUG) {
					TesterMethods.passMessage(test);
					System.out.println(Arrays.toString(sort));
				}
			} else {
				fail = true;
				TesterMethods.errorMessage(test, Arrays.toString(expected), Arrays.toString(sort));
			}
		}

		TesterMethods.methodMessage("seededRandomSort", fail);
		return fail;
	}

	public static boolean linearSort(int tests) {
		TesterMethods.tester("linearSort");
		boolean fail = false;

		for (int test = 0; test < tests; test++) {
			ArrayList<Integer> shuffle = new ArrayList<Integer>(test);
			for (int i = 0; i < test; i++) {
				shuffle.add(i);
			}

			int[] checkCopy = shuffle.stream().mapToInt(Integer::intValue).toArray();//Integer ArrayList to int.
			int[] passThrough = shuffle.stream().mapToInt(Integer::intValue).toArray();

			Merge.mergesort(passThrough);
			if (Arrays.equals(passThrough, checkCopy)) {
				//System.out.println("Linear vals test: " + test + " passed.");
			} else {
				System.out.println("Linear vals test: " + test + " failed.");
				fail = true;
			}
		}

		TesterMethods.methodMessage("linearSort", fail);
		return fail;
	}

	public static boolean reverseLinearSort(int tests) {
		TesterMethods.tester("reverseLinearSort");
		boolean fail = false;

		for (int test = 0; test < tests; test++) {
			ArrayList<Integer> shuffle = new ArrayList<Integer>(test);
			for (int i = test; 0 < i; i--) {
				shuffle.add(i);
			}

			int[] passThrough = shuffle.stream().mapToInt(Integer::intValue).toArray();
			Collections.sort(shuffle);
			int[] checkCopy = shuffle.stream().mapToInt(Integer::intValue).toArray();//Integer ArrayList to int.

			Merge.mergesort(passThrough);
			if (Arrays.equals(passThrough, checkCopy)) {
				if (DEBUG) {
					System.out.println("Reverse linear vals test: " + test + " passed.");
					System.out.println(Arrays.toString(passThrough));
				}
			} else {
				System.out.println("Reverse linear vals test: " + test + " failed.");
				fail = true;
			}
		}

		TesterMethods.methodMessage("reverseLinearSort", fail);
		return fail;
	}

	public static boolean sameValueSort(int tests) {
		TesterMethods.tester("sameValueSort");
		boolean fail = false;

		for (int test = 0; test < tests; test++) {
			ArrayList<Integer> shuffle = new ArrayList<Integer>(test);
			for (int i = 0; i < test; i++) {
				shuffle.add(test);
			}

			int[] checkCopy = shuffle.stream().mapToInt(Integer::intValue).toArray();//Integer ArrayList to int.
			int[] passThrough = shuffle.stream().mapToInt(Integer::intValue).toArray();

			Merge.mergesort(passThrough);
			if (Arrays.equals(passThrough, checkCopy)) {
				if (DEBUG) {
					System.out.println("Same vals test: " + test + " passed.");
					System.out.println(Arrays.toString(passThrough));
				}
			} else {
				System.out.println("Same vals test: " + test + " failed.");
				fail = true;
			}
		}

		TesterMethods.methodMessage("sameValueSort", fail);
		return fail;
	}

}
