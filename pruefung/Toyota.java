public class Toyota extends Car {

    public int prize = 0;

    public Toyota(IEngine engine, String color) {
        super(engine, color);
        this.prize = 25000;
    }

    @Override
    public void move() {
        System.out.println("Toyota moves");
    }

}


