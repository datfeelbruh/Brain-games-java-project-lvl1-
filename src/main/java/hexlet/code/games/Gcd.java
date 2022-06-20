package hexlet.code.games;

import hexlet.code.Cli;


public class Gcd {
    private static int a;
    private static int b;
    private static int answer;

    public static void start() {
        run();
    }

    private static void run() {
        while (Engine.rounds < Engine.maxRounds) {
            setQuestion();
            System.out.println("Question: " + a + " " + b);
            System.out.print("Your answer: ");
            setAnswer();
            if (getGcd(a, b) == answer) {
                Engine.correctAnswer();
                if (Engine.rounds == 2) {
                    Engine.gameWon();
                }
                Engine.rounds++;
            } else {
                String correctAnswer = String.valueOf(getGcd(a, b));
                Engine.gameLost(String.valueOf(answer), correctAnswer);
                Engine.rounds = Engine.maxRounds;
            }
        }
    }

    private static void setQuestion() {
        final int range = 100;
        a = (int) (Math.random() * range);
        b = (int) (Math.random() * range);
    }

    private static void setAnswer() {
        answer = Integer.parseInt(Cli.getUserInput().nextLine());
    }
    private static int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGcd(b, a % b);
    }
}
