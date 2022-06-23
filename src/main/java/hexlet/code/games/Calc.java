package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    public static final String DESCRIPTION = "What is the result of the expression?";
    private static final String[] OPERATORS = {"+", "-", "*"};

    public static void start() {
        String[] questions = new String[Engine.MAXROUNDS];
        String[] answers = new String[Engine.MAXROUNDS];
        for (int i = 0; i < Engine.MAXROUNDS; i++) {
            int firstNumber = Utils.randomNumber(0, 20);
            int secondNumber = Utils.randomNumber(0, 20);
            String operator = OPERATORS[Utils.randomNumber(0, OPERATORS.length)];
            questions[i] = firstNumber + " " + operator + " " + secondNumber;
            answers[i] = String.valueOf(calcExpression(firstNumber, secondNumber, operator));
        }
        Engine.run(new String[][]{questions, answers}, DESCRIPTION);
    }

    private static int calcExpression(int n1, int n2, String op) throws RuntimeException {
        return switch (op) {
            case "+" -> n1 + n2;
            case "-" -> n1 - n2;
            case "*" -> n1 * n2;
            default -> throw new RuntimeException("No logic for " + op + "operator");
        };
    }
}
