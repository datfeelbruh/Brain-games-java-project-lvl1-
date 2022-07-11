package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
/**
 * This class is for generate game data for game Prime.
 * @author khoroshko.d
 */
public class Prime {
    /** This field is containing game rules. */
    public static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    /** This field is containing max value for generated number. */
    private static final int MAXVALUE = 100;
    /** This method is generated a two-dimensional array of game data to be processed by the Engine class. */
    public static void start() {
        String[][] data = new String[Engine.MAXROUNDS][2];
        for (int i = 0; i < Engine.MAXROUNDS; i++) {
            int randomNumber = Utils.randomNumber(0, MAXVALUE);
            data[i][0] = String.valueOf(randomNumber);
            data[i][1] = isPrime(randomNumber) ? "yes" : "no";
        }
        Engine.run(data, DESCRIPTION);
    }
    /**
     * Returns a boolean result a primality test for number.
     * @param number - The number to be checked for primality.
     * @return true if this int prime, false otherwise
     */
    // Prime number test
    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
