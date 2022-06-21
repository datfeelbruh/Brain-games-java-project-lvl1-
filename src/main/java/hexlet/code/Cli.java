package hexlet.code;

import java.util.Scanner;

public class Cli {

    public static void greeting() {
        Scanner playerNameInput = new Scanner(System.in);
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        String playerName = playerNameInput.nextLine();
        System.out.println("Hello, " + playerName + "!");
    }
}
