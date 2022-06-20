package hexlet.code.games;

import hexlet.code.Cli;

public class Even {
    private static int rounds = Engine.getRounds();
    private static int question;
    private static String answer;

    public static void start() {
        run();
    }
    private static void run() {
        while (rounds < Engine.MAXROUNDS) {
            setQuestion();
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            setAnswer();
            if (checkAnswer(question, answer)) {
                Engine.correctAnswer();
                if (rounds == 2) {
                    Engine.gameWon();
                }
                rounds++;
            } else {
                String correctAnswer = answer.equals("yes") ? "no" : "yes";
                Engine.gameLost(answer, correctAnswer);
                rounds = Engine.MAXROUNDS;
            }
        }
    }
    private static void setAnswer() {
        answer = Cli.getUserInput().nextLine();
    }
    public static void setQuestion() {
        final int rangeForNumbers = 100;
        question = (int) (Math.random() * rangeForNumbers);
    }

    private static boolean checkAnswer(int number, String userAnswer) {
        if (number % 2 == 0 && userAnswer.equals("yes")) {
            return true;
        } else {
            return number % 2 != 0 && userAnswer.equals("no");
        }
    }
}
