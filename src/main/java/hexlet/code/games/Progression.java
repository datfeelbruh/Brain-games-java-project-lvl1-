package hexlet.code.games;
import hexlet.code.Engine;

import java.util.Scanner;

public class Progression {
    public static final String DESCRIPTION = "What number is missing in the progression?";
    private static int hiddenNumber;
    private static String[] progression;

    public static void start() {
        Engine.start();
        Scanner playerInput = new Scanner(System.in);
        String playerName = playerInput.nextLine();
        System.out.println("Hello, " + playerName + "!");
        run(playerName, playerInput);
    }
    private static void run(String name, Scanner scanner) {
        System.out.println(DESCRIPTION);
        while (Engine.getRound() != Engine.MAXROUNDS) {
            setQuestion();
            System.out.print("Question: ");
            printProgression(progression);
            System.out.print("\nYour answer: ");
            String answer = scanner.nextLine();
            String correctAnswer = String.valueOf(hiddenNumber);
            boolean check = answer.equals(correctAnswer);
            Engine.run(name, answer, check, correctAnswer);
        }
    }

    private static void setQuestion() {
        // Seed числа с которого начинается прогрессия
        final int seedRange = 15;
        // Устанавливаем минимальную и максимальную длину прогресссии
        final int start = 5;
        final int end = 6;
        // Вычисляем число с которого начинается прогрессия
        final int seed = (int) (Math.random() * seedRange);
        // Получаем длину прогрессии
        final int progressionSize = start + (int) (Math.random() * end);
        // Устанавливаем шаг прогрессии
        final int progressionStepMin = 2;
        final int progressionStepMax = 6;
        final int progressionStep = progressionStepMin + (int) (Math.random() * progressionStepMax);
        // Инициализируем массив с числами прогрессии и заполняем его.
        progression = new String[progressionSize];
        progression[0] = Integer.toString(seed);
        for (int i = 1; i < progressionSize; i++) {
            progression[i] = String.valueOf(Integer.parseInt(progression[i - 1]) + progressionStep);
        }
        // Получаем индекс числа которое будем прятатать
        int hiddenNumberIndex = (int) (Math.random() * progressionSize);
        hiddenNumber = Integer.parseInt(progression[hiddenNumberIndex]);
        progression[hiddenNumberIndex] = "..";
    }

    private static void printProgression(String[] array) {
        for (String elem : array) {
            System.out.print(elem + " ");
        }
    }
}
