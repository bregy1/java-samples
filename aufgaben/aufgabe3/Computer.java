


public class Computer {


    public String description;
    private double frequency = 2.5;
    public static final double FREQUENCY = 3.7;

    public Computer(String description, double taktFrequenz) {
        this.description = description;
        this.frequency = taktFrequenz;
    }

    public void setTaktFrequenz(double frequency) {

        if(!this.isFrequencyAllowed(frequency)) {
            System.out.print("Frequency must be less than " + Computer.FREQUENCY + ". Gotten " + frequency);
            return;
        }

        this.frequency = frequency;
    }

    protected boolean isFrequencyAllowed(double frequency) {
        return this.frequency < Computer.FREQUENCY;
    }

}