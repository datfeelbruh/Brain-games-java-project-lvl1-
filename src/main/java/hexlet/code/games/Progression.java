package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Arrays;

public class Progression {
    public static final String DESCRIPTION = "What number is missing in the progression?";

    public static void start() {
        String[] questions = new String[Engine.MAXROUNDS];
        String[] answers = new String[Engine.MAXROUNDS];
        for (int i = 0; i < Engine.MAXROUNDS; i++) {
            int start = Utils.randomNumber(1, 15);
            int step = Utils.randomNumber(2, 8);
            int size = Utils.randomNumber(5, 10);
            int[] progression = getProgression(start, step, size);
            int hiddenElement = progression[Utils.randomNumber(0, size - 1)];
            String[] question = new String[size];
            for (int index = 0; index < size; index++) {
                if (progression[index] == hiddenElement) {
                    question[index] = "..";
                } else {
                    question[index] = String.valueOf(progression[index]);
                }
            }
            questions[i] = String.join(" ", question);
            answers[i] = String.valueOf(hiddenElement);
        }
        Engine.run(new String[][]{questions, answers}, DESCRIPTION);
    }
    private static int[] getProgression(int progressionStart, int progressionStep, int size) {
        int[] progression = new int[size];
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                progression[i] = progressionStart;
            } else {
                progression[i] = progression[i - 1] + progressionStep;
            }
        }
        return progression;
    }
}
