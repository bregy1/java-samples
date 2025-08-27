public class Car {
    // Fields (attributes)
    private final String brand;
    private String color;
    private boolean driving;
    private boolean destroyed;

    // Constructor
    public Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
        this.driving = false;
        this.destroyed = false;
    }

    public void status() {

        String info =  this.brand + " " + this.color + " Status:";
        
        if(this.destroyed) {
            info += "zerstört";
        }
        else if(this.driving) {
            info += " fährt";
        } else {
            info += " steht";
        }

        System.out.println(info);
    }

    public void drive() {
        this.driving = true;
    }

    public void stop() {
        this.driving = false;
    }

    public void crash() {
        this.destroyed = true;
    }

    public void setColor(String color) {
        this.color = color;
    }
}