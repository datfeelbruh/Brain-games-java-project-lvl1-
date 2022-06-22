package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int MAXROUNDS = 3;

    public static void run(String[][] gameData, String description) {
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        Scanner scanner = new Scanner(System.in);
        String playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName + "!");
        for (int i = 0; i < MAXROUNDS; i++) {
            String question = gameData[0][i];
            String answer = gameData[1][i];
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String playerAnswer = scanner.nextLine();
            if (playerAnswer.equals(answer)) {
                System.out.println("Correct!");
                if (i == 2) {
                    System.out.println("Congratulations, " + playerName + "!");
                }
            } else {
                System.out.println("'" + playerAnswer + "'" + " is wrong answer ;(. Correct answer was "
                        + "'" + answer + "'" + ".\n"
                        + "Let's try again, " + playerName + "!");
                i = MAXROUNDS;
            }
        }
        scanner.close();
    }
}
