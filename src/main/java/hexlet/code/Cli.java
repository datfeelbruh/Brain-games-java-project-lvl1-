package hexlet.code;
import java.util.Scanner;

public class Cli {
    private static String playerName = "";
    private static Scanner userInput = new Scanner(System.in);

    public static void greeting() {
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        setPlayerName();
        System.out.println("Hello, " + getPlayerName() + "!");
    }

    public static String getPlayerName() {
        return playerName;
    }

    private static void setPlayerName() {
        playerName = userInput.nextLine();
    }

    public static String chooseGame() throws NumberFormatException {
        String playerChoice = "";
        System.out.println("Please enter the game number and press Enter\n"
                            + "1 - Greet\n"
                            + "2 - Even\n"
                            + "3 - Calc\n"
                            + "4 - Gcd\n"
                            + "5 - Progression\n"
                            + "6 - Prime\n"
                            + "0 - Exit");
        System.out.print("Your choice: ");
        playerChoice = userInput.nextLine();
        return playerChoice;
    }
    public static void closeUserInput() {
        userInput.close();
    }

    public static Scanner getUserInput() {
        return userInput;
    }
}
