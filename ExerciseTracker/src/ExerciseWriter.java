import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ExerciseWriter {
    public static void writeToScreen(ArrayList<Exercise> exercise){
        for(Exercise ex : exercise){
            System.out.println(ex);
        }
    }
    public static boolean writeToFile(ArrayList<Exercise> exercise, String fname) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fname))));
            for (Exercise ex : exercise) {
                pw.println(ex);
            }
            pw.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    public static void tabulateSummary(ArrayList<Exercise> exercise){
        String name;
        

    }
}
