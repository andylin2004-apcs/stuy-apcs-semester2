class Tester{
	public static void main(String[] args) {
		BurnTrees test = new BurnTrees(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Double.parseDouble(args[2]));
		long startTime = System.currentTimeMillis();
		int ticks = test.run();
		long endTime = System.currentTimeMillis();

		System.out.println("Executed in " + (endTime-startTime)/1000.0 + " seconds in " + ticks + " ticks.");
	}
}
