package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;

public class App {
    public static void main(String[] args) {
        switch (Cli.chooseGame()) {
            case 1 -> Cli.greeting();
            case 2 -> Even.start();
            case 3 -> Calc.start();
            default -> {
            }
        }

        Cli.closeUserInput();

    }
}
