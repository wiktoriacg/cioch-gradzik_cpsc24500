
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class MainFrame extends JFrame implements  ActionListener {
    private ArrayList<Exercise> exercises;
    private ExerciseDetailPanel cdp;
    private JButton btnAddCircle;
    private JMenuItem miLogin;
    private JMenuItem miLogout;

    /**
     * main frame, which is adding interactive frame, summary and button together
     * it is showing the message if user entered invalid value
     */
    public void setupGUI() {
        setBounds(200, 200, 800, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Exercise Tracer V2.0");
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        cdp = new ExerciseDetailPanel();
        SummaryPanel sumPan = new SummaryPanel(exercises);
        c.add(cdp, BorderLayout.WEST);
        c.add(sumPan, BorderLayout.EAST);
        JPanel panSouth = new JPanel();
        btnAddCircle = new JButton("Add Exercise");
        btnAddCircle.addActionListener(new ActionListener() {
            //it is responding and showing message when there is the error
            public void actionPerformed(ActionEvent e) {
                double duration = 0;
                String date = "";
                double distance = 0;
                ArrayList<String> errors = new ArrayList<String>();
                String name = cdp.getName();
                String comment = cdp.getComment();
                try {
                    duration = cdp.getDuration();
                } catch (Exception ex) {
                    errors.add("The duration must be non-zero number.");
                }
                try {
                    SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                    date = cdp.getDate();
                    df.parse(date);
                } catch (Exception ex) {
                    errors.add("The date must be entered in mm/dd/yyyy format.");
                }
                try {
                    distance = cdp.getDistance();
                } catch (Exception ex) {
                    errors.add("The distance must be non-zero number.");
                }
                String errorMessage = "";
                if (errors.size() > 0) {
                    for (String error : errors) {
                        errorMessage = errorMessage + error + " ";
                    }
                    JOptionPane.showMessageDialog(null, errorMessage);
                } else {
                    //create new run walk exercise and it is adding it to exercise list
                    RunWalk ex = new RunWalk(name, comment, duration, date, distance);
                    exercises.add(ex);
                    sumPan.updateList();
                    //clear text field after creating object and shows number of burned calories
                    cdp.clearEntries();
                    sumPan.setSummaryLabel(String.format("Exercise Summary(%.2f burned)", RunWalk.getTotalCaloriesBurned(exercises)));
                    repaint();  // updates what is shown on the frame
                }
            }
        });
        panSouth.setLayout(new FlowLayout());
        panSouth.add(btnAddCircle);
        c.add(panSouth, BorderLayout.SOUTH);
        setupMenu();
        enableControls(false);
    }

    /**
     * it is creating menu, which allows user to show log in form
     * its showing message after clicking help
     */
    public void setupMenu() {
        JMenuBar mbar = new JMenuBar();
        setJMenuBar(mbar);
        JMenu mnuFile = new JMenu("File");
        mbar.add(mnuFile);
        JMenu mnuHelp = new JMenu("Help");
        mbar.add(mnuHelp);
        miLogin = new JMenuItem("Log in");
        miLogin.addActionListener(this);
        miLogout = new JMenuItem("Log out");
        miLogout.addActionListener(this);
        JMenuItem miSave = new JMenuItem("Save");
        JMenuItem miExit = new JMenuItem("Exit");
        mnuFile.add(miLogin);
        mnuFile.add(miLogout);
        mnuFile.add(miSave);
        mnuFile.add(miExit);
        //show message after clicking About button
        miExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JMenuItem miAbout = new JMenuItem("About");
        mnuHelp.add(miAbout);
        miAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "ExerciseTracker V2.0-CPSC 24500 Fall 2023");
            }
        });
        //it is saving exercise to file
        miSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                File f;
                if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    f = chooser.getSelectedFile();
                    if (ExerciseWriter.writeToFile(f, exercises)) {
                        JOptionPane.showMessageDialog(null, "Exercises were saved.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Exercises were not saved.");
                    }
                }
            }
        });
    }

    public MainFrame(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
        setupGUI();
    }

    public void enableControls(boolean enableYN) {
        cdp.enableEntries(enableYN);
        btnAddCircle.setEnabled(enableYN);
    }

    /**
     * it is creating logingform object and it is checking if user is log in
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == miLogin) {
            LoginForm dlgLogin = new LoginForm(this, "Please log in", true);
            dlgLogin.setVisible(true);
            if (dlgLogin.isLoggedIn()) {
                enableControls(true);
            } else {
                enableControls(false);
            }
        } else { // logout
            enableControls(false);
        }
    }
}
