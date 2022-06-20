package hexlet.code.games;
import hexlet.code.Cli;

public class Progression {
    public static void start() {
        Cli.greeting();
        System.out.println("Find the greatest common divisor of given numbers.");
        run();
    }

    private static void run() {
        int rounds = 0;
        final int maxRounds = 3;
        final int seedRange = 15;
        while (rounds < maxRounds) {
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
            final String[] progression = new String[progressionSize];
            progression[0] = Integer.toString(seed);
            for (int i = 1; i < progressionSize; i++) {
                progression[i] = String.valueOf(Integer.parseInt(progression[i - 1]) + progressionStep);
            }
            // Получаем индекс числа которое будем прятатать
            final int hiddenNumberIndex = (int) (Math.random() * progressionSize);
            final int hiddenNumber = Integer.parseInt(progression[hiddenNumberIndex]);
            progression[hiddenNumberIndex] = "..";
            System.out.println("Question: ");
            printProgression(progression);
            System.out.print("Your answer: ");
            int answer = Integer.parseInt(Cli.getUserInput().nextLine());
            if (answer == hiddenNumber) {
                System.out.println("Correct!");
                if (rounds == 2) {
                    System.out.println("Congratulation, " + Cli.getPlayerName() + "!");
                }
                rounds++;
            } else {
                System.out.println("'" + Integer.toString(answer) + "'" + " is wrong answer ;(. "
                        + "Correct answer was " + "'" + hiddenNumber + "'.\n"
                        + "Let's try again, " + Cli.getPlayerName());
                rounds = maxRounds;
            }
        }


    }

    private static void printProgression(String[] progression) {
        for (String elem : progression) {
            System.out.print(elem + " ");
        }
    }
}
