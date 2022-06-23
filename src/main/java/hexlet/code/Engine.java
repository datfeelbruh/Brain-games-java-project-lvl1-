package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int MAXROUNDS = 3;

    /**
     * The method that processes the data of the game that invoke this method. In cycle print <code>gameData[0][i]</code> question
     * and get player answer. Compare <code>gameData[1][i]</code> answer and player answer.
     * @author datfeelbruh <datfeelman@gmail.com>
     * @see hexlet.code.games
     * @param gameData <code>gameData[0]</code> - question;
     *                <code>gameData[1]</code> answers;
     * @param description The game rules <code>description</code> to be printed.
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
