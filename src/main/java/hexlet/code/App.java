package hexlet.code;

import hexlet.code.games.Even;

public class App {
    public static void main(String[] args) {
        switch (Cli.chooseGame()) {
            case 1 -> Cli.greeting();
            case 2 -> Even.start();
            default -> {
            }
        }

        Cli.closeUserInput();

    }
}
