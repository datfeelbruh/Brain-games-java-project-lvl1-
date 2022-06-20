package hexlet.code.games;

import hexlet.code.Cli;

public class Engine {
    private static int rounds = 0;
    static final int MAXROUNDS = 3;
    public static void start(String game) {
        Cli.greeting();
        switch (game) {
            case "0":
                break;
            case "1":
                Cli.greeting();
            case "2":
                System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
                Even.start();
                break;
            case "3":
                System.out.println("What is the result of the expression?");
                Calc.start();
                break;
            case "4":
                System.out.println("Find the greatest common divisor of given numbers.");
                Gcd.start();
                break;
            case "5":
                System.out.println("What number is missing in the progression?");
                Progression.start();
                break;
            case "6":
                System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'..");
                Prime.start();
                break;
            default:
                System.out.println("You must choose correct number of game");
                break;
        }
        Cli.closeUserInput();
    }
    public static int getRounds() {
        return rounds;
    }
    public static void correctAnswer() {
        System.out.println("Correct!");
    }

    public static void gameWon() {
        System.out.println("Congratulations, " + Cli.getPlayerName() + "!");
    }

    public static void gameLost(String answer, String correctAnswer) {
        System.out.println("'" + answer + " is wrong answer ;(. Correct answer was "
                + correctAnswer + ".\n"
                + "Let's try again, " + Cli.getPlayerName() + "!");
    }
}
