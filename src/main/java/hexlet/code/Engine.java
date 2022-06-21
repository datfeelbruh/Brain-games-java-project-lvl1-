package hexlet.code;

public class Engine {

    private static int round = 0;
    public static final int MAXROUNDS = 3;

    public static void start() {
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
    }

    public static void run(String name, String answer, boolean check, String correctAnswer) {
        if (check) {
            correctAnswer();
            if (round == 2) {
                gameWon(name);
            }
            round++;
        } else {
            gameLost(answer, correctAnswer, name);
            Engine.round = MAXROUNDS;
        }
    }
    public static int getRound() {
        return round;
    }
    public static void correctAnswer() {
        System.out.println("Correct!");
    }

    public static void gameWon(String playerName) {
        System.out.println("Congratulations, " + playerName + "!");
    }

    public static void gameLost(String answer, String correctAnswer, String playerName) {
        System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was "
                + "'" + correctAnswer + "'" + ".\n"
                + "Let's try again, " + playerName + "!");
    }
}
