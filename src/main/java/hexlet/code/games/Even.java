package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

/**
 * This class is for generate game data for game Even.
 * @author khoroshko.d
 */
public class Even {
    /** This field is containing game rules. */
    public static final String DESCRIPTION = "Answer 'yes' if number even otherwise answer 'no'.";
    /** This field is containing max value for generated number. */
    private static final int MAXVALUE = 100;
    /** This method is generated a two-dimensional array of game data to be processed by the Engine class. */
    public static void start() {
        String[][] data = new String[Engine.MAXROUNDS][2];
        for (int i = 0; i < Engine.MAXROUNDS; i++) {
            int randomNumber = Utils.randomNumber(0, MAXVALUE);
            data[i][0] = String.valueOf(randomNumber);
            data[i][1] = isEven(randomNumber) ? "yes" : "no";
        }
        Engine.run(data, DESCRIPTION);
    }

    /**
     * Returns a boolean result of dividing the given number by 2 with a remainder.
     * @param number - The number to be checked for even
     * @return true, if this int divides by 2 with a remainder equal 0, false otherwise
     */
    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
