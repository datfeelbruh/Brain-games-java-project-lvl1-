package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    private static final int SIZE = 10;
    private static final int MINSTEP = 2;
    public static final String DESCRIPTION = "What number is missing in the progression?";

    public static void start() {
        String[] questions = new String[Engine.MAXROUNDS];
        String[] answers = new String[Engine.MAXROUNDS];
        for (int i = 0; i < Engine.MAXROUNDS; i++) {
            int start = Utils.randomNumber();
            int step = MINSTEP + (int) (Math.random() * SIZE);
            int[] progression = getProgression(start, step);
            int hiddenElement = hideProgressionElement(progression);
            questions[i] = printProgression(progression, hiddenElement);
            answers[i] = String.valueOf(progression[hiddenElement]);
        }
        Engine.run(new String[][]{questions, answers}, DESCRIPTION);
    }
    private static int[] getProgression(int progressionStart, int progressionStep) {
        // Инициализируем массив с числами прогрессии и заполняем его.
        int[] progression = new int[Progression.SIZE];
        progression[0] = progressionStart;
        for (int i = 1; i < Progression.SIZE; i++) {
            progression[i] = progression[i - 1] + progressionStep;
        }
        return progression;
    }

    private static int hideProgressionElement(int[] progression) {
        int size = progression.length;
        return (int) (Math.random() * size);
    }

    private static String printProgression(int[] array, int hiddenIndex) {
        StringBuilder printed = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i == hiddenIndex) {
                printed.append("..");
                printed.append(" ");
            } else {
                printed.append(array[i]);
                printed.append(" ");
            }
        }
        return printed.toString().trim();
    }
}
