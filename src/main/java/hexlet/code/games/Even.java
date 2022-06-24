package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

/**
 * This class is for generate game data for game Even.
 * @author khoroshko.d
 */
public class Even {
    /** This field is contains game rules. */
    public static final String DESCRIPTION = "Answer 'yes' if number even otherwise answer 'no'.";
    /** This field is contains max value for generate number. */
    private static final int MAXVALUE = 100;
    /** This method is generated two-dimensional array of game data to be processed by the Engine class. */
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

    /**
     * Returns a boolean result of dividing the given number by 2 with a remainder.
     * @param number - The number to be checked for even
     * @return true if this int divide by 2 with a remainder equal 0, false otherwise
     */
    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
