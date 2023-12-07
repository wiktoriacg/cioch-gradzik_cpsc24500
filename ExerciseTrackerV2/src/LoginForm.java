import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginForm extends JDialog {
    private boolean loggedIn;
    private String password;
    private String userName;

    /**
     * its creating additional frame, which is opening only when user open "Log in" from main frame
     * Its allowing user to put username and password
     * Its making main frame visible if user will enter correct data.
     */
    public void setupGUI() {
        //set up size, central Panel
        setBounds(300,300,320,200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JPanel panCenter = new JPanel();
        panCenter.setLayout(new FlowLayout());
        //it is adding texts and text fields
        JLabel labUsername = new JLabel("Username");
        panCenter.add(labUsername);
        JTextField txtUserName = new JTextField(25);
        panCenter.add(txtUserName);
        c.add(panCenter,BorderLayout.CENTER);
        panCenter.setLayout(new FlowLayout());
        JLabel labPassword = new JLabel("Password");
        panCenter.add(labPassword);
        JPasswordField txtPassword = new JPasswordField(25);
        panCenter.add(txtPassword);
        c.add(panCenter,BorderLayout.CENTER);
        //it is creating South panel for button
        //it is adding button
        JPanel panSouth = new JPanel();
        JButton btnOK = new JButton("Log in");
        //create action listener which is checking if values entered by user are
        //valid. It sets main frame visible if user enter correct value
        btnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredPassword = new String(txtPassword.getPassword());
                String enteredUserName = txtUserName.getText();
                if (enteredPassword.equals(password) && enteredUserName.equals(userName)) {
                    loggedIn = true;
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null,"The username/password you entered was incorrect.");
                }
            }
        });
        //Action listener, which is reponding to buton "Cancel". It is making main frame invisible
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loggedIn = false;
                setVisible(false);
            }
        });
        panSouth.setLayout(new FlowLayout());
        panSouth.add(btnOK);
        panSouth.add(btnCancel);
        c.add(panSouth,BorderLayout.SOUTH);
    }
    //constructor which is setting expecting login form
    public LoginForm(JFrame owner, String title, boolean modal) {
        super(owner,title,modal);
        setupGUI();
        loggedIn = false;
        password = "donut";
        userName = "healthy";
    }

    /**
     *
     * @return boolean true - if user is log in
     *                        if user is not log in
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }

}

