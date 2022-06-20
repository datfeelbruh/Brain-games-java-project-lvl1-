package hexlet.code;

import hexlet.code.games.Engine;


public class App {
    public static void main(String[] args) {
        String chosenGame = Cli.chooseGame();
        switch (chosenGame) {
            case "1" -> Cli.greeting();
            case "2", "3", "4", "5", "6" -> Engine.start(chosenGame);
            default -> {
            }
        }
    }
}
