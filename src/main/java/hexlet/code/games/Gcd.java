package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Gcd {
    public static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";

    public static void start() {
        String[] questions = new String[Engine.MAXROUNDS];
        String[] answers = new String[Engine.MAXROUNDS];
        final int maxValue = 100;
        for (int i = 0; i < Engine.MAXROUNDS; i++) {
            int firstNumber = Utils.randomNumber(1, maxValue);
            int secondNumber = Utils.randomNumber(1, maxValue);
            questions[i] = firstNumber + " " + secondNumber;
            answers[i] = String.valueOf(getGcd(firstNumber, secondNumber));
        }
        Engine.run(new String[][]{questions, answers}, DESCRIPTION);
    }

    private static int getGcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return getGcd(n2, n1 % n2);
    }


}
