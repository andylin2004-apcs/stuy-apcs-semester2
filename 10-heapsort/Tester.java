/******************************************************************************
 *  Compilation:  javac Tester.java
 *  Execution:    java Tester [DEBUG]
 *
 *  DEBUG: Whether to add extra outputs (seed, error output). Defaults true.
 ******************************************************************************/

import java.util.*;
public class Tester {
    public static void main(String[] args) {
        boolean DEBUG = true;
        if (args.length > 0 && Boolean.parseBoolean(args[0]) == false) DEBUG = false;
        TesterMethods t = new TesterMethods(DEBUG);
        String test = "";

        test = "MyHeap.buildHeap()";
        try {
            int[] a1 = {2, 17, 3, 25, 7, 1, 36, 100, 19};
            MyHeap.buildHeap(a1);
            t.check(test, a1[0], 100);
            t.check(test, a1[0] >= a1[1] && a1[0] >= a1[2], true);

            for (int i = 0; i < 1000; i++) {
                Random seeder = new Random();
                int seed = seeder.nextInt();
                Random rng = new Random(seed);

                int[] a2 = new int[rng.nextInt(100) + 5];
                for (int j = 0; j < a2.length; j++) {
                    a2[j] = rng.nextInt();
                }

                MyHeap.buildHeap(a2);
                t.check(test, a2[0] >= a2[1] && a2[0] >= a2[2], true);
            }
        } catch (RuntimeException e) {
            t.except(test, e);
        }

        t.results();
    }
}
