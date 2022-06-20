package hexlet.code.games;

import hexlet.code.Cli;

public class Calc {
    private static int a;
    private static int b;
    private static String operator;
    private static final String[] operators = {"+", "-", "*"};
    private static int answer;

    public static void start() {
        run();
    }

    private static void run() {
        while (Engine.rounds < Engine.maxRounds) {
            setQuestion();
            String expression = a + " " + operator + " " + b;
            System.out.println("Question: " + expression);
            System.out.print("Your answer: ");
            setAnswer();
            if (calcExpression(a, b, operator) == answer) {
                Engine.correctAnswer();
                if (Engine.rounds == 2) {
                    System.out.println("Congratulations, " + Cli.getPlayerName() + "!");
                }
                Engine.rounds++;
            } else {
                String correctAnswer = String.valueOf(calcExpression(a, b,operator));
                Engine.gameLost(String.valueOf(answer), correctAnswer);
                Engine.rounds = Engine.maxRounds;
            }
        }
    }
    private static void setQuestion() {
        final int range = 15;
        a = (int) (Math.random() * range);
        b = (int) (Math.random() * range);
        int operatorsRange = operators.length - 1;
        operator = operators[(int) (Math.round(Math.random() * operatorsRange))];
    }

    private static void setAnswer() {
        answer = Integer.parseInt(Cli.getUserInput().nextLine());
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
