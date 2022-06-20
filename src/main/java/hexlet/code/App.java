package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;



public class App {
    public static void main(String[] args) {
        switch (Cli.chooseGame()) {
            case "1" -> Cli.greeting();
            case "2" -> Even.start();
            case "3" -> Calc.start();
            case "4" -> Gcd.start();
            case "5" -> Progression.start();
            case "6" -> Prime.start();
            default -> {
            }
        }

        Cli.closeUserInput();

    }
}
