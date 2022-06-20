package hexlet.code.games;

import hexlet.code.Cli;


public class Gcd {
    private static int rounds = Engine.getRounds();
    private static int a;
    private static int b;
    private static int answer;

    public static void start() {
        run();
    }

    private static void run() {
        while (rounds < Engine.MAXROUNDS) {
            setQuestion();
            System.out.println("Question: " + a + " " + b);
            System.out.print("Your answer: ");
            setAnswer();
            if (getGcd(a, b) == answer) {
                Engine.correctAnswer();
                if (rounds == 2) {
                    Engine.gameWon();
                }
                rounds++;
            } else {
                String correctAnswer = String.valueOf(getGcd(a, b));
                Engine.gameLost(String.valueOf(answer), correctAnswer);
                rounds = Engine.MAXROUNDS;
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
    private static int getGcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return getGcd(n2, n1 % n2);
    }
}
