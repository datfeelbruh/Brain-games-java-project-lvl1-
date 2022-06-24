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
            case "0":
                break;
            case "1":
                Cli.greeting();
                break;
            case "2":
                Even.start();
                break;
            case "3":
                Calc.start();
                break;
            case "4":
                Gcd.start();
                break;
            case "5":
                Progression.start();
                break;
            case "6":
                Prime.start();
                break;
            default:
                System.out.println("Error! You must choose correct number of game");
                break;
        }
        scanner.close();
    }
}
