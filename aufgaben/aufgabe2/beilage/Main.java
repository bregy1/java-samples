

public class Main {

    public static void main(String[] args) {

        Car car1 = new Car("toyota", "rot");
        Car car2 = new Car("audi", "grün");
        Car car3 = new Car("mazda", "violett");

        car1.drive();

        car2.drive();
        car2.stop();

        car3.crash();
        car3.setColor("mixed");

        car1.status();
        car2.status();
        car3.status();

    }



 
}


