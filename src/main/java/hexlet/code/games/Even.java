package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;


public class Even {
    public static final String DESCRIPTION = "Answer 'yes' if number even otherwise answer 'no'.";
    private static final int MAXVALUE = 100;
    public static void start() {
        String[] questions = new String[Engine.MAXROUNDS];
        String[] answers = new String[Engine.MAXROUNDS];
        for (int i = 0; i < Engine.MAXROUNDS; i++) {
            int randomNumber = Utils.randomNumber(0, MAXVALUE);
            questions[i] = String.valueOf(randomNumber);
            answers[i] = isEven(randomNumber) ? "yes" : "no";
        }
        Engine.run(new String[][]{questions, answers}, DESCRIPTION);
    }

    // Even number test
    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
