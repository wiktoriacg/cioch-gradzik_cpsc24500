import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class EmailPrinter {
    /**
     * It is printing to screen a proper format of Email object
     * @param email-Its object of Email
     */
    public static void writeToScreen(ArrayList<Email> email) {
        for (Email em : email){
            System.out.println(em);
            System.out.println();
        }
    }

    /**
     * It is writing to file a proper format of Email object
     * @param email - Email object
     * @param fname - name of file
     * @return - boolean
     *           true-if function was able to access and write to file
     *           false-if function was unsucesfull to write to file
     */
    public static boolean writeToFile(ArrayList<Email> email, String fname) {
        String fileFriendly;
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fname))));
            for (Email em : email) {
                pw.println(em.fileFriendlyString());
            }
            pw.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
