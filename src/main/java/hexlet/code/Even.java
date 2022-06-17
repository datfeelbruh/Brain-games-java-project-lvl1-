package hexlet.code;
import java.util.Scanner;

public class Even {
    public static void start() {
        Cli.greeting();
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
        run();
    }
    public static void run() {
        int gamesCount = 1;
        while (gamesCount <= 3) {
            int number = (int) (Math.random() * 50);
            System.out.println("Question: " + number);
            Scanner sc = new Scanner(System.in);
            System.out.print("Your answer: " );
            String userAnswer = sc.nextLine();
            if (check(userAnswer, number)) {
                System.out.println("Correct");
                if (gamesCount == 3) {
                    System.out.println("Congratulation, " + Cli.playerName);
                }
                gamesCount++;
            } else {
                System.out.println("'yes' is wrong answer ;(. Correct answer was 'no'.\n" +
                                    "Let's try again, " + Cli.playerName + "!");
                break;
            }
        }
    }

    public static boolean check(String userAnswer, int number) {
        return (number % 2 == 0 && userAnswer.equals("yes")) || (number % 2 != 0 && userAnswer.equals("no"));
    }
}
