package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.Utils;
/**
 * This class is for generate game data for game Progression.
 * @author khoroshko.d
 */
public class Progression {
    /** This field is containing game rules. */
    public static final String DESCRIPTION = "What number is missing in the progression?";
    /** This field is containing a max value first element of progression. */
    private static final int MAXSTARTVALUE = 15;
    /** This field is containing a max value step of progression. */
    private static final int MAXSTEPVALUE = 8;
    /** This field is containing a min value step of progression. */
    private static final int MINSIZEVALUE = 5;
    /** This field is containing a max value length of progression. */
    private static final int MAXSIZEVALUE = 10;
    /** This method is generated a two-dimensional array of game data to be processed by the Engine class. */
    public static void start() {
        String[][] data = new String[Engine.MAXROUNDS][2];
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
            data[i][0] = question.toString().trim();
            data[i][1] = String.valueOf(hiddenElement);
        }
        Engine.run(data, DESCRIPTION);
    }
    /**
     * This method generates arithmetic progression of
     * length - <code>size</code>,
     * starting at - <code>progressionStart</code>progressionStart and
     * with step - <code>progressionStep</code>.
     * @param progressionStart - int number start of progression
     * @param progressionStep - int number step of progression
     * @param size - int number length of progression
     * @return int[] - array int of progression
     */
    private static int[] getProgression(int progressionStart, int progressionStep, int size) {
        int[] progression = new int[size];
        for (int i = 0; i < size; i++) {
            progression[i] = progressionStart + (i - 1) * progressionStep;
        }
        return progression;
    }
}
