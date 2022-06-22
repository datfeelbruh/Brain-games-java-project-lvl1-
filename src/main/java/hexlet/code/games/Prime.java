package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    public static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void start() {
        String[] questions = new String[Engine.MAXROUNDS];
        String[] answers = new String[Engine.MAXROUNDS];
        for (int i = 0; i < Engine.MAXROUNDS; i++) {
            int number = Utils.randomNumber();
            questions[i] = String.valueOf(number);
            answers[i] = isPrime(number) ? "yes" : "no";
        }
        Engine.run(new String[][]{questions, answers}, DESCRIPTION);
    }

    private static boolean isPrime(int num) {
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        for (int i = num / 2; i > 1; i--) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
