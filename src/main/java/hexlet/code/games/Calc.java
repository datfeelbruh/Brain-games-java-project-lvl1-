package hexlet.code.games;

import hexlet.code.Cli;

public class Calc {
    private static int rounds = Engine.getRounds();
    private static int a;
    private static int b;
    private static String operator;
    private static final String[] OPERATORS = {"+", "-", "*"};
    private static int answer;

    public static void start() {
        run();
    }

    private static void run() {
        while (rounds < Engine.MAXROUNDS) {
            setQuestion();
            String expression = a + " " + operator + " " + b;
            System.out.println("Question: " + expression);
            System.out.print("Your answer: ");
            setAnswer();
            if (calcExpression(a, b, operator) == answer) {
                Engine.correctAnswer();
                if (rounds == 2) {
                    System.out.println("Congratulations, " + Cli.getPlayerName() + "!");
                }
                rounds++;
            } else {
                String correctAnswer = String.valueOf(calcExpression(a, b, operator));
                Engine.gameLost(String.valueOf(answer), correctAnswer);
                rounds = Engine.MAXROUNDS;
            }
        }
    }
    private static void setQuestion() {
        final int range = 15;
        a = (int) (Math.random() * range);
        b = (int) (Math.random() * range);
        int operatorsRange = OPERATORS.length - 1;
        operator = OPERATORS[(int) (Math.round(Math.random() * operatorsRange))];
    }

    private static void setAnswer() {
        answer = Integer.parseInt(Cli.getUserInput().nextLine());
    }
    private static int calcExpression(int n1, int n2, String op) {
        return switch (op) {
            case "+" -> n1 + n2;
            case "-" -> n1 - n2;
            case "*" -> n1 * n2;
            default -> 0;
        };
    }
}
