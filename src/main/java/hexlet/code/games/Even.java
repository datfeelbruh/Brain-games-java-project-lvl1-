package hexlet.code.games;

import hexlet.code.Cli;

public class Even {
    public static void start() {
        Cli.greeting();
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
        run();
    }
    private static void run() {
        int rounds = 0;
        final int maxRounds = 3;
        final int rangeForNumbers = 100;
        while (rounds < maxRounds) {
            int randomNumber = (int) (Math.random() * rangeForNumbers);
            System.out.println("Question: " + randomNumber);
            System.out.print("Your answer: ");
            String answer = Cli.getUserInput().nextLine();
            if (checkAnswer(randomNumber, answer)) {
                System.out.println("Correct!");
                if (rounds == 2) {
                    System.out.println("Congratulation, " + Cli.getPlayerName() + " !");
                }
                rounds++;
            } else {
                String correctAnswer = answer.equals("yes") ? "no" : "yes";
                System.out.println(answer + " is wrong answer ;(. Correct answer was "
                                    + correctAnswer + ".\n"
                                    + "Let's try again, " + Cli.getPlayerName() + "!");
                rounds = maxRounds;
            }
        }
    }

    private static boolean checkAnswer(int number, String userAnswer) {
        if (number % 2 == 0 && userAnswer.equals("yes")) {
            return true;
        } else {
            return number % 2 != 0 && userAnswer.equals("no");
        }
    }
}
