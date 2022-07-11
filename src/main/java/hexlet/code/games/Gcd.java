package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
/**
 * This class is for generate game data for game Gcd.
 * @author khoroshko.d
 */
public class Gcd {
    /** This field is containing game rules. */
    public static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";
    /** This field is containing max value for generated number. */
    private static final int MAXVALUE = 100;
    /** This method is generated a two-dimensional array of game data to be processed by the Engine class. */
    public static void start() {
        String[][] data = new String[Engine.MAXROUNDS][2];
        for (int i = 0; i < Engine.MAXROUNDS; i++) {
            int firstNumber = Utils.randomNumber(1, MAXVALUE);
            int secondNumber = Utils.randomNumber(1, MAXVALUE);
            data[i][0] = firstNumber + " " + secondNumber;
            data[i][1] = String.valueOf(getGcd(firstNumber, secondNumber));
        }
        Engine.run(data, DESCRIPTION);
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
