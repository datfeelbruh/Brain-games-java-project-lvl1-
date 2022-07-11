package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
/**
 * This class is for generate game data for game Calc.
 * @author khoroshko.d
 */
public class Calc {
    /** This field is containing game rules. */
    public static final String DESCRIPTION = "What is the result of the expression?";
    /** This field is containing array of arithmetic operators. */
    private static final String[] OPERATORS = {"+", "-", "*"};
    /** This field is containing max value for generated number. */
    private static final int MAXVALUE = 20;
    /** This method is generated a two-dimensional array of game data to be processed by the Engine class. */
    public static void start() {
        String[][] data = new String[Engine.MAXROUNDS][2];
        for (int i = 0; i < Engine.MAXROUNDS; i++) {
            int firstNumber = Utils.randomNumber(0, MAXVALUE);
            int secondNumber = Utils.randomNumber(0, MAXVALUE);
            String operator = OPERATORS[Utils.randomNumber(0, OPERATORS.length)];
            data[i][0] = firstNumber + " " + operator + " " + secondNumber;
            data[i][1] = String.valueOf(calcExpression(firstNumber, secondNumber, operator));
        }
        Engine.run(data, DESCRIPTION);
    }
    /**
     * Returns an integer result of arithmetic expression.
     * @param n1 - Left operand of expression
     * @param n2 - Right operand of expression
     * @param op - Operator of expression
     * @return int result of arithmetic expression <code>n1</code> <code>op</code> <code>n2</code>
     */
    // Expression result
    private static int calcExpression(int n1, int n2, String op) throws RuntimeException {
        return switch (op) {
            case "+" -> n1 + n2;
            case "-" -> n1 - n2;
            case "*" -> n1 * n2;
            default -> throw new RuntimeException("No logic for " + op + "operator");
        };
    }
}
