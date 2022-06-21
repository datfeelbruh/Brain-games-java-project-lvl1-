package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Scanner;

public class Calc {
    public static final String DESCRIPTION = "What is the result of the expression?";
    private static final String[] OPERATORS = {"+", "-", "*"};

    public static void start() {
        Engine.start();
        Scanner playerInput = new Scanner(System.in);
        String playerName = playerInput.nextLine();
        System.out.println("Hello, " + playerName + "!");
        run(playerName, playerInput);
    }

    private static void run(String name, Scanner scanner) {
        System.out.println(DESCRIPTION);
        for (; Engine.round < Engine.MAXROUNDS; Engine.round++) {
            final int range = 15;
            int a = (int) (Math.random() * range);
            int b = (int) (Math.random() * range);
            int operatorsRange = OPERATORS.length - 1;
            String operator = OPERATORS[(int) (Math.round(Math.random() * operatorsRange))];
            String question = a + " " + operator + " " + b;
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();
            String correctAnswer = String.valueOf(calcExpression(a, b, operator));
            boolean check = answer.equals(correctAnswer);
            Engine.run(name, answer, check, correctAnswer);
        }
    }

    private static int calcExpression(int n1, int n2, String op) {
        int result = 0;
        switch (op) {
            case "+" -> result = n1 + n2;
            case "-" -> result = n1 - n2;
            case "*" -> result = n1 * n2;
            default -> System.out.println("No logic for operator" + op);
        }
        return result;
    }
}
