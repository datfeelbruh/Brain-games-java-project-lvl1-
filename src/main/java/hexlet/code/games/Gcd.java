package hexlet.code.games;

import hexlet.code.Cli;

public class Gcd {
    public static void start() {
        Cli.greeting();
        System.out.println("Find the greatest common divisor of given numbers.");
        run();
    }

    private static void run() {
        final int maxRounds = 3;
        final int range = 100;
        int rounds = 0;
        while (rounds < maxRounds) {
            int a = (int) (Math.random() * range);
            int b = (int) (Math.random() * range);
            System.out.println("Question: " + a + " " + b);
            System.out.print("Your answer: ");
            int answer = Integer.parseInt(Cli.getUserInput().nextLine());
            if (getGcd(a, b) == answer) {
                System.out.println("Correct!");
                if (rounds == 2) {
                    System.out.println("Congratulation, " + Cli.getPlayerName() + " !");
                }
                rounds++;
            } else {
                System.out.println("'" + Integer.toString(answer) + "'" + " is wrong answer ;(. "
                        + "Correct answer was " + "'" + getGcd(a, b) + "'.\n"
                        + "Let's try again, " + Cli.getPlayerName());
                rounds = maxRounds;
            }
        }
    }

    private static int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGcd(b, a % b);
    }
}
