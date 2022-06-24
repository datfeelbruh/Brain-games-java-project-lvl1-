package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
/**
 * This class is for generate game data for game Gcd.
 * @author khoroshko.d
 */
public class Gcd {
    /** This field is contains game rules. */
    public static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";
    /** This field is contains max value for generate number. */
    private static final int MAXVALUE = 100;
    /** This method is generated two-dimensional array of game data to be processed by the Engine class. */
    public static void start() {
        String[] questions = new String[Engine.MAXROUNDS];
        String[] answers = new String[Engine.MAXROUNDS];
        for (int i = 0; i < Engine.MAXROUNDS; i++) {
            int firstNumber = Utils.randomNumber(1, MAXVALUE);
            int secondNumber = Utils.randomNumber(1, MAXVALUE);
            questions[i] = firstNumber + " " + secondNumber;
            answers[i] = String.valueOf(getGcd(firstNumber, secondNumber));
        }
        Engine.run(new String[][]{questions, answers}, DESCRIPTION);
    }

    /**
     * Returns an int the greatest common divisor for <code>n1</code> and <code>n2</code>.
     * @param n1 - int number
     * @param n2 - int number
     * @return int the greatest common divisor
     */
    private static int getGcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return getGcd(n2, n1 % n2);
    }


}
