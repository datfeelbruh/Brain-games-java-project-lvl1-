package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.Gcd;

public class App {
    public static void main(String[] args) {
        switch (Cli.chooseGame()) {
            case 1 -> Cli.greeting();
            case 2 -> Even.start();
            case 3 -> Calc.start();
            case 4 -> Gcd.start();
            default -> {
            }
        }

        Cli.closeUserInput();

    }
}
