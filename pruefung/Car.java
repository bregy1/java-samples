
// Make this as uml
public abstract class Car {

    public static int CAR_COUNT = 0;
    protected IEngine engine;
    protected String color;


    public Car(IEngine engine, String color) {
        this.engine = engine;
        this.color = color;
    }

    public boolean hasV8() {
        return this.engine.type() == "v8";
    }

    abstract void move();

}