public class Student {

    // Fields (attributes)
    private String brand;
    private String name;
    private String surname;
    private int age;

    // Constructor
    public Student(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public void info() {
        String info = this.name + " " + this.surname + " " + this.age;
        System.out.println(info);
    }
}