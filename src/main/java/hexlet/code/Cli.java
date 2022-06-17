package hexlet.code;
import java.util.Scanner;

public class Cli {
    public static void greeting() {
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        Scanner sc = new Scanner(System.in);
        String playerName = sc.nextLine();
        System.out.println("Hello, " + playerName + "!");
    }
}
