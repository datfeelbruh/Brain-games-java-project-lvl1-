package hexlet.code;

/**
 * This class is for generate random number in range.
 * @author khoroshko.d
 */
public class Utils {
    /**
     * This method return random number in range from <code>minValue</code> to <code>maxValue</code>.
     * @param minValue minimal number which method can generate
     * @param maxValue maximum number which method can generate
     * @return int
     */
    public static int randomNumber(int minValue, int maxValue) {
        return minValue + (int) (Math.random() * maxValue);
    }
}
