


public class Main {

    public String description;
    private double frequency = 2.5;
    public static final double FREQUENCY = 2.5;


    public static void main(String[] args) {

        System.err.println("args" + args[0] + args[1]);
        Computer cmp1 = new Computer("performant", 1.4);
        Computer cmp2 = new Computer("langsam", 5.8);
        cmp1.setTaktFrequenz(1.1);
        cmp2.setTaktFrequenz(8.5);
    }


    public Main(String description, double taktFrequenz) {
        this.description = description;
        this.frequency = taktFrequenz;
    }


}