import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
public class ExerciseDetailPanel extends JPanel {
    //create private data accessible for this class
    private JTextField txtName;
    private JTextField txtDate;
    private JTextField txtDuration;
    private JTextField txtDistance;
    private JTextArea Comment;

    /**
     * create a frame, which is interactive to user. It allows user to enter data for exercise
     * it is showing all entered exercises and counting burned calories
     */
    public void setupGUI() {
        //create North panel and adding all texts and text fields
        setLayout(new BorderLayout());
        JPanel panNorth = new JPanel();
        panNorth.setLayout(new GridLayout(4, 2));
        JLabel labName = new JLabel("Name");
        txtName = new JTextField(10);
        JLabel labDate = new JLabel("Date");
        txtDate = new JTextField(10);
        JLabel labDur = new JLabel("Duration");
        txtDuration = new JTextField(10);
        JLabel labDist = new JLabel("Distance");
        txtDistance = new JTextField(10);
        panNorth.add(labName);
        panNorth.add(txtName);
        panNorth.add(labDate);
        panNorth.add(txtDate);
        panNorth.add(labDur);
        panNorth.add(txtDuration);
        panNorth.add(labDist);
        panNorth.add(txtDistance);
        add(panNorth, BorderLayout.NORTH);
        //it is creating comment panel, which contain text and text field
        JPanel panComment = new JPanel();
        panComment.setLayout(new BorderLayout());
        JLabel labComment = new JLabel("Add Comment:");
        panComment.add(labComment, BorderLayout.NORTH);
        Comment = new JTextArea(10, 10);
        panComment.add(Comment, BorderLayout.CENTER);
        add(panComment, BorderLayout.CENTER);

    }

    /**
     * it setting up main frame
     */

    public ExerciseDetailPanel() {
        setupGUI();
    }

    /**
     * @return String Name - name entered to text field
     */

    public String getName() {
        return txtName.getText();
    }

    /**
     * @return String Date- date entered to text field
     */

    public String getDate() {
        return txtDate.getText();
    }

    /**
     * @return Double Duration- entered value in text field of duration
     */

    public double getDuration() {
        return Double.parseDouble(txtDuration.getText());
    }
    /**
     * @return Double Distance - entered value in text field of distance
     */
    public double getDistance() {
        return Double.parseDouble(txtDistance.getText());
    }
    /**
     * @return String Comment - entered text field of comment
     */
    public String getComment() {
        return Comment.getText();
    }

    /**
     * it is clearing all text fields in frame, which is interactive to user
     */
    public void clearEntries() {
        txtName.setText("");
        txtDate.setText("");
        txtDuration.setText("");
        txtDistance.setText("");
        Comment.setText("");
    }

    /**
     * it is setting proper visible
     * @param enableYN - true - if user was able to log in
     *                   false - if user was not able to log in
     */
    public void enableEntries(boolean enableYN) {
        txtName.setEnabled(enableYN);
        txtDate.setEnabled(enableYN);
        txtDuration.setEnabled(enableYN);
        txtDistance.setEnabled(enableYN);
        Comment.setEnabled(enableYN);
    }
}
