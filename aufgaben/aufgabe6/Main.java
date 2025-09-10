public class Main {

    public static void main(String[] args) {
        FileLogger l1 = new FileLogger("test.log");
        ConsoleLogger l2 = new ConsoleLogger();

        Main.testLogger(l1);
        Main.testLogger(l2);


    }

    public static void testLogger(ILogger logger) {
        logger.println("Programm Start");
        logger.errorln("Programm Fehler erkannt");
        logger.println("Programm Ende");
    }
}