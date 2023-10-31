import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class EmailPrinter {
    public static void writeToScreen(ArrayList<Email> email) {
        for (Email em : email){
            System.out.println(em);
            System.out.println();
        }
    }
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
