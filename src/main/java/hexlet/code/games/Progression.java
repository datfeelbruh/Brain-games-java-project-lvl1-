package hexlet.code.games;
import hexlet.code.Cli;

public class Progression {
    private static int rounds = Engine.getRounds();
    private static int hiddenNumber;
    private static int hiddenNumberIndex;
    private static String[] progression;
    private static int answer;
    public static void start() {
        run();
    }

    private static void run() {
        while (rounds < Engine.MAXROUNDS) {
            setQuestion();
            System.out.print("Question: ");
            printProgression(progression);
            System.out.print("\nYour answer: ");
            setAnswer();
            if (answer == hiddenNumber) {
                Engine.correctAnswer();
                if (rounds == 2) {
                    Engine.gameWon();
                }
                rounds++;
            } else {
                Engine.gameLost(String.valueOf(answer), String.valueOf(hiddenNumber));
                rounds = Engine.MAXROUNDS;
            }
        }


    }

    private static void setAnswer() {
        answer = Integer.parseInt(Cli.getUserInput().nextLine());
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
        hiddenNumberIndex = (int) (Math.random() * progressionSize);
        hiddenNumber = Integer.parseInt(progression[hiddenNumberIndex]);
        progression[hiddenNumberIndex] = "..";
    }

    private static void printProgression(String[] array) {
        for (String elem : array) {
            System.out.print(elem + " ");
        }
    }
}
