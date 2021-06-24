public class Driver {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Driver <expression>");
        }

        System.out.println(Calculator.eval(args[0]));
    }
}
