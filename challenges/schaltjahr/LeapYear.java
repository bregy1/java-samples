
import java.util.Scanner;


public class LeapYear {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Gib ein Schaltjahr zur Kontrolle ein:");
        String text = scanner.nextLine();

        int year;
        try {
            year = Integer.parseInt(text);
        } catch(NumberFormatException e) {
            System.out.println("Eingabe ungültig. Erwartet wird eine Zahl.");
            System.exit(1);
            return;
        }

        if(LeapYear.isLeapYear(year)) {
            System.out.println(text+ " ist ein Schaltjahr");
        } else {
            System.out.println(text + " ist nicht ein Schaltjahr");
        }

    }

    private static boolean isLeapYear(int  year) {

        if(year % 100 == 0) {
            return year % 400 == 0;
        }

        return year % 4 == 0;

    }
}
