public class QueenBoardTester {

	public static void main(String[] args) {
		if (args.length == 0) {
			solveTesterConsensus(9);
			countSolutionsTesterConsensus(9);
		} else if(args[0].equals("throws")) {
			throwsTester(9);
		} else {
			System.out.println(args[0]);
		}
	}

	public static void solveTesterConsensus(int tests) {
		for (int size = 1; size < tests; size++) {
			QueenBoard test = new QueenBoard(size);
			test.solve();
			System.out.print(test + "\n\n");
		}
	}

	public static void countSolutionsTesterConsensus(int tests) {
		for (int size = 1; size < tests; size++) {
			QueenBoard test = new QueenBoard(size);
			System.out.print(test + ": " + test.countSolutions() + "\n");
		}
	}

	public static void throwsTester(int tests) {
		QueenBoard zeroTest = new QueenBoard(0);
		try {
			zeroTest.solve();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(0 + "Shouldnt be an exception here!");
		}

		for (int size = 1; size < tests; size++) {
			QueenBoard test = new QueenBoard(size);
			if (test.solve()) {
				try {
					test.solve();
					System.out.println(test + "Throw an IllegalStateException! You're trying to solve on an uncleared board!");
				} catch (IllegalStateException e) {
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(test + "Print an IllegalStateException!");
				}
			} else {
				try {
					test.solve();
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(test + "Shouldnt be an exception here!");
				}
			}
		}

		zeroTest = new QueenBoard(0);
		try {
			zeroTest.countSolutions();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(0 + "Shouldnt be an exception here!");
		}

		for (int size = 1; size < tests; size++) {
			QueenBoard test = new QueenBoard(size);
			if (test.solve()) {
				try {
					test.countSolutions();
					System.out.println(test + "Throw an IllegalStateException! You're trying to solve on an uncleared board!");
				} catch (IllegalStateException e) {
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(test + "Print an IllegalStateException!");
				}
			} else {
				try {
					test.countSolutions();
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println(test + "Shouldnt be an exception here!");
				}
			}
		}

		for (int size = 0; size < tests; size++) {
			QueenBoard test = new QueenBoard(size);
			test.countSolutions();
			try {
				test.solve();
			} catch (IllegalStateException e) {
				System.out.println("Clear boardState after countSolutions");
			}
		}

		System.out.println("Throws tester complete");
	}
}
