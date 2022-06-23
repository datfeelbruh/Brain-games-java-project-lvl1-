package hexlet.code;

public class Utils {
    public static int randomNumber(int minValue, int maxValue) {
        return minValue + (int) (Math.random() * maxValue);
    }
}
