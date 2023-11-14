import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

public class ExerciseWriter {
    /**
     * It is printing to screen a format of Exercise object
     * @param exercise-Its object of Exercise
     */
    public static void writeToScreen(ArrayList<Exercise> exercise){
        for(Exercise ex : exercise){
            System.out.println(ex);
        }
    }
    /**
     * It is writing to file a proper format of Excercise object
     * @param exercise - Excercise object
     * @param fname - name of file
     * @return - boolean
     *           true-if function was able to access and write to file
     *           false-if function was unsucesfull to write to file
     */
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
    /**
     * It is printing to screen a user-friendly format of Exercise object
     * @param exercise-Its object of Exercise
     */
    public static void tabulateSummary(ArrayList<Exercise> exercise){
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        for(Exercise ex : exercise){
            System.out.printf("%-20s%-20s%-25s%-20.2f\n",ex.getType(),ex.getName(),df.format(ex.getDate()),ex.getCaloriesBurned());
        }

    }
}
