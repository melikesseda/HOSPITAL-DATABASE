    package sql;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class PatientMainScreenFrame extends JFrame {

    private JLabel background;

    public PatientMainScreenFrame() {
        setTitle("GSDM HOSPITAL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a JLabel with the background image
        background = new JLabel();
        background.setLayout(new BorderLayout());

        // Set the JLabel as the content pane of the frame
        setContentPane(background);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create menus
        JMenu appointmentMenu = new JMenu("Take Appointment");
        JMenu doctorsMenu = new JMenu("Doctors");
        JMenu surgeryMenu = new JMenu("Surgery");

        // Create menu items
        JMenuItem appointmentItem = new JMenuItem("Show Appointment Dates");
        JMenuItem doctorsItem = new JMenuItem("Show Doctors");
        JMenuItem surgeryItem = new JMenuItem("Show Operation Dates");

        // Add menu items to menus
        appointmentMenu.add(appointmentItem);
        doctorsMenu.add(doctorsItem);
        surgeryMenu.add(surgeryItem);

        // Add menus to menu bar
        menuBar.add(appointmentMenu);
        menuBar.add(doctorsMenu);
        menuBar.add(surgeryMenu);

        // Set the menu bar for the frame
        setJMenuBar(menuBar);

        // Add action listeners to menu items
        appointmentItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AppointmentFrame appointmentFrame = new AppointmentFrame();
                appointmentFrame.setVisible(true);
            }
        });

        doctorsItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DoctorsFrame doctorsFrame = new DoctorsFrame();
                doctorsFrame.setVisible(true);
            }
        });

        surgeryItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SurgeryFrame surgeryFrame = new SurgeryFrame();
                surgeryFrame.setVisible(true);
            }
        });

        // Add a component listener to the frame
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                resizeBackgroundImage();
            }
        });
    }

    private void resizeBackgroundImage() {
        // Resize the background image to fill the frame
        Image img = new ImageIcon("C:\\Users\\gamze\\OneDrive\\Masa�st�\\gsdm.hospital.png").getImage();
        Image resizedImg = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        background.setIcon(new ImageIcon(resizedImg));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PatientMainScreenFrame frame = new PatientMainScreenFrame();
                frame.setSize(1000, 1000);
                frame.setVisible(true);
            }
        });
    }
}

    
