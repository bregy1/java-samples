public class TestCode {

    public static void main(String[] args) {
        int a = 3;
        if (a > 0) {
            for (int i = 0; i < 2; i++) {
                while (a < 5) {
                    switch (i) {
                        case 0:
                            if (a % 2 == 1) {
                                doSomething(new Runnable() {
                                    public void run() {
                                        System.out.println("Deep enough?");
                                        
                                    }
                                });
                            }
                            break;
                        case 1:
                            if (a % 2 == 0) {
                                doAnotherThing(a);
                            }
                            break;
                        default:
                            break;
                    }
                    a++;
                }
            }
        }
    }

    static void doSomething(Runnable r) {
        r.run();
    }

    static void doAnotherThing(int x) {
        if (x < 10) {
            System.out.println("Doing another thing with " + x);
        }
    }
}





