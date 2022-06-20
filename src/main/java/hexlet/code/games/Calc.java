package hexlet.code.games;

import hexlet.code.Cli;

public class Calc {
    public static void start() {
        Cli.greeting();
        System.out.println("What is the result of the expression?");
        run();
    }

    private static void run() {
        String[] operators = {"+", "-", "*"};
        final int maxRounds = 3;
        final int range = 15;
        int rounds = 0;
        while (rounds < maxRounds) {
            int a = (int) (Math.random() * range);
            int b = (int) (Math.random() * range);
            int operatorsRange = operators.length - 1;
            String chosenOperator = operators[(int) (Math.round(Math.random() * operatorsRange))];
            String expression = Integer.toString(a) + " " + chosenOperator + " " + Integer.toString(b);
            System.out.println("Question: " + expression);
            System.out.print("Your answer: ");
            int answer = Integer.parseInt(Cli.getUserInput().nextLine());
            if (calcExpression(a, b, chosenOperator) == answer) {
                System.out.println("Correct!");
                if (rounds == 2) {
                    System.out.println("Congratulation, " + Cli.getPlayerName() + " !");
                }
                rounds++;
            } else {
                System.out.println("'" + Integer.toString(answer) + "'" + " is wrong answer ;(. "
                                    + "Correct answer was " + "'" + calcExpression(a, b, chosenOperator) + "'.\n"
                                    + "Let's try again, " + Cli.getPlayerName());
                rounds = maxRounds;
            }
        }
    }

    private static int calcExpression(int a, int b, String operator) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> 0;
        };
    }
}
