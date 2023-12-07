import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.JTextArea;
import java.util.ArrayList;
public class SummaryPanel extends JPanel {
    private ArrayList<Exercise> exercises;
    private JTextArea summary;
    private JLabel lblSummary;

    /**
     * it is creating exercise frame
     * it taking excercise object and make summary for it
     */
    public void setupGUI() {
        setLayout(new BorderLayout());
        JPanel panNorth = new JPanel();
        panNorth.setLayout(new FlowLayout());
        lblSummary = new JLabel("Exercise Summary");
        panNorth.add(lblSummary);
        add(panNorth,BorderLayout.NORTH);
        summary = new JTextArea(23,40);
        summary.setFont(new Font("monospace", Font.PLAIN, 12));
        summary.setEditable(false);
        add(summary,BorderLayout.CENTER);
    }
    public void setSummaryLabel(String text) {
        lblSummary.setText(text);
    }
    public SummaryPanel(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
        setupGUI();
    }

    /**
     * it is showing summary of every single object in list
     */
    public void updateList() {
        summary.setText("");
        String text = "";
        for (Exercise c : exercises) {
            text = text + c + "\n";
        }
        summary.setText(text);
    }
}