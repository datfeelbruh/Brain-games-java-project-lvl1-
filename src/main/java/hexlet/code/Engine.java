package hexlet.code;

import java.util.Scanner;


/**
 * This class is for manipulating two dimensions array with game data.
 * @author khoroshko.d
 */
public class Engine {

    /**
     * This field is value of max count iteration of compare for game data.
     */
    public static final int MAXROUNDS = 3;

    /**
     * This method is for print messages in command line and for compare game data.
     * @param gameData Two dimension array with game data
     * @param description The description of game rules to be printed in command line
     */
    public static void run(String[][] gameData, String description) {
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        Scanner scanner = new Scanner(System.in);
        String playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName + "!");
        System.out.println(description);
        for (int i = 0; i < MAXROUNDS; i++) {
            String question = gameData[0][i];
            String answer = gameData[1][i];
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String playerAnswer = scanner.nextLine();
            if (playerAnswer.equals(answer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + playerAnswer + "'" + " is wrong answer ;(. Correct answer was "
                        + "'" + answer + "'" + ".\n"
                        + "Let's try again, " + playerName + "!");
                return;
            }
        }
        scanner.close();
        System.out.println("Congratulations, " + playerName + "!");
    }
}
