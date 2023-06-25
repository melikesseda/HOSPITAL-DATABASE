    package sql;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);

        add(panel);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Check if the username and password are correct
                if (username.equals("doctor@gmail.com") && password.equals("1234")) {
                    // Open the main application window
                	DoctorMainScreenFrame mainScreen = new DoctorMainScreenFrame();
                    mainScreen.setVisible(true);

                    // Close the login window
                    dispose();
                } 
                else if (username.equals("patient@gmail.com") && password.equals("4321")) {
                    // Open the main application window
                	PatientMainScreenFrame mainScreen = new PatientMainScreenFrame();
                    mainScreen.setVisible(true);

                    // Close the login window
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid username or password",
                            "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
                
            }
            
        });
      
            
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
            }
        });
    }
}

    
