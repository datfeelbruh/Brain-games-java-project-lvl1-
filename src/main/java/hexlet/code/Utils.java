package hexlet.code;

public class Utils {
    public static final int MAXNUMBER = 50;
    public static int randomNumber() {
        return (int) (Math.random() * MAXNUMBER);
    }
}
