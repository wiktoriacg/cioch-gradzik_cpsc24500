/*
 * Wiktoria Cioch-Gradzik
 * 12/07/2023
 * FA23-CPSC-24500-002
 * This program is keeping track of exercise and count the number of calories burned
 * Its allowing user to put data using GUI
 * Its allowing user to enter exercise after log in
 * Its allow to save exercises in file
 */
import java.util.ArrayList;
public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Exercise> exercises = new ArrayList<Exercise>();
        MainFrame frame = new MainFrame(exercises);
        frame.setVisible(true);

    }


}