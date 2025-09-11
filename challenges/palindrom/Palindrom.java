
import java.util.Scanner;


public class Palindrom {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Gib ein Palindrom zur Kontrolle ein:");
        String text = scanner.nextLine();

        if(Palindrom.isPalindrom(text)) {
            System.out.println("\"" + text + "\" ist ein Palindrom");
        } else {
            System.out.println("\"" + text + "\" ist nicht ein Palindrom");
        }

    }

    private static boolean isPalindrom(String text) {

        int lowerMiddle = text.length() / 2;
        
        System.out.println("lower" + lowerMiddle);
        for (int i = 0; i < lowerMiddle; i++) {
            char ch1 = text.charAt(i);
            char ch2 = text.charAt(text.length() - 1 - i);
            if (Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
                return false;
            }
        }

        return true;

    }
}
