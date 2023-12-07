import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
public class ExerciseWriter {
    /**
     * it is saving list of exercises to file
     * @param f - file in which it is supposed to be sace
     * @param exercises - list of exercises
     * @return - true - if it was able to save to file
     *           false - if it wasnt able to save to file
     */
    public static boolean writeToFile(File f, ArrayList<Exercise> exercises) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
            for (Exercise c : exercises) {
                pw.println(c);
            }
            pw.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
