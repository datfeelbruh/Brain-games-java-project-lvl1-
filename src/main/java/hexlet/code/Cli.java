package hexlet.code;
import java.util.Scanner;

public class Cli {
    static String playerName = "";
    public static void greeting() {
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        Scanner sc = new Scanner(System.in);
        playerName = sc.nextLine();
        System.out.println("Hello, " + playerName + "!");
    }

    public static int choice() {
        System.out.println("Please enter the game number and press Enter\n" +
                            "1 - Greet\n" +
                            "2 - Even\n" +
                            "0 - Exit");
        System.out.print("Your choice: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        return choice;
    }
}
