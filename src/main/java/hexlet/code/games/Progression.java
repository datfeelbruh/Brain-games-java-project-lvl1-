package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    public static final String DESCRIPTION = "What number is missing in the progression?";
    private static final int MAXSTARTVALUE = 15;
    private static final int MAXSTEPVALUE = 8;
    private static final int MINSIZEVALUE = 5;
    private static final int MAXSIZEVALUE = 10;

    public static void start() {
        String[] questions = new String[Engine.MAXROUNDS];
        String[] answers = new String[Engine.MAXROUNDS];
        for (int i = 0; i < Engine.MAXROUNDS; i++) {
            // Generate param for arithmetic progression
            int start = Utils.randomNumber(1, MAXSTARTVALUE);
            int step = Utils.randomNumber(2, MAXSTEPVALUE);
            int size = Utils.randomNumber(MINSIZEVALUE, MAXSIZEVALUE);
            int[] progression = getProgression(start, step, size);
            // Generate index of hidden element
            int hiddenElement = progression[Utils.randomNumber(0, size - 1)];
            StringBuilder question = new StringBuilder();
            for (int index = 0; index < size; index++) {
                if (progression[index] == hiddenElement) {
                    question.append("..");
                    question.append(" ");
                } else {
                    question.append(progression[index]);
                    question.append(" ");
                }
            }
            questions[i] = question.toString().trim();
            answers[i] = String.valueOf(hiddenElement);
        }
        Engine.run(new String[][]{questions, answers}, DESCRIPTION);
    }
    // This method generate arithmetic progression size - size, start with - progressionStart, step - progressionStep
    private static int[] getProgression(int progressionStart, int progressionStep, int size) {
        int[] progression = new int[size];
        for (int i = 0; i < size; i++) {
            progression[i] = progressionStart + (i - 1) * progressionStep;
        }
        return progression;
    }
}
