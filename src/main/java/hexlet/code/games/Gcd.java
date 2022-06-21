package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Scanner;

public class Gcd {
    public static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";


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
            final int range = 100;
            int a = (int) (Math.random() * range);
            int b = (int) (Math.random() * range);
            System.out.println("Question: " + a + " " + b);
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();
            String correctAnswer = String.valueOf(getGcd(a, b));
            boolean check = answer.equals(correctAnswer);
            Engine.run(name, answer, check, correctAnswer);
        }
    }

    private static int getGcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return getGcd(n2, n1 % n2);
    }


}
