package hexlet.code;

public class Utils {
    /**
     * The method return random number in range from <code>minValue</code> to <code>maxValue</code>.
     * @author datfeelbruh <datfeelman@gmail.com>
     * @see hexlet.code.games
     * @param minValue minimal number which method can generate
     * @param maxValue maximum number which method can generate
     * @return int
     */
    public static int randomNumber(int minValue, int maxValue) {
        return minValue + (int) (Math.random() * maxValue);
    }
}
