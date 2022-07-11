package hexlet.code;

import java.util.Scanner;
/**
 * This class is for greet user.
 * @author khoroshko.d
 */
public class Cli {
    /** This method is for greeting user and get his name. */
    public static void greeting() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        String playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName + "!");
        scanner.close();
    }
}
