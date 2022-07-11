package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;
import java.util.Scanner;

/**
 * App class is start point application "Brain games".
 * @author khoroshko.d
 */
public class App {
    private static final String EXIT_CODE = "0";
    private static final String GREET_CODE = "1";
    private static final String EVEN_CODE = "2";
    private static final String CALC_CODE = "3";
    private static final String GCD_CODE = "4";
    private static final String PROGRESSION_CODE = "5";
    private static final String PRIME_CODE = "6";
    /**
     * This is the main() method for application.
     * @param args command line args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter\n"
                + "1 - Greet\n"
                + "2 - Even\n"
                + "3 - Calc\n"
                + "4 - Gcd\n"
                + "5 - Progression\n"
                + "6 - Prime\n"
                + "0 - Exit");
        System.out.print("Your choice: ");
        String playerChoice = scanner.nextLine();
        switch (playerChoice) {
            case EXIT_CODE:
                break;
            case GREET_CODE:
                Cli.greeting();
                break;
            case EVEN_CODE:
                Even.start();
                break;
            case CALC_CODE:
                Calc.start();
                break;
            case GCD_CODE:
                Gcd.start();
                break;
            case PROGRESSION_CODE:
                Progression.start();
                break;
            case PRIME_CODE:
                Prime.start();
                break;
            default:
                System.out.println("Error! You must choose correct number of game");
                break;
        }
        scanner.close();
    }
}
