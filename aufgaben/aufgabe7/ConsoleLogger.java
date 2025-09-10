
public class ConsoleLogger implements ILogger {

    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";

    @Override
    public void println(String data) {
        System.out.println(data);
    }


    @Override
    public void errorln(String error) {
        System.err.println(ConsoleLogger.RED + "Error: " + error + ConsoleLogger.RESET);
    }

}

