    package sql;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class DoctorMainScreenFrame extends JFrame {//�LK A�ILAN PENCERE
    private JLabel background;

    public DoctorMainScreenFrame() {
        setTitle("GSDM HOSPITAL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);

     // Create a JLabel with the background image
        background = new JLabel();
        background.setLayout(new BorderLayout());

        // Set the JLabel as the content pane of the frame
        setContentPane(background);
        
        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create menus
        JMenu patientMenu = new JMenu("Patients");
        JMenu diseaseMenu = new JMenu("Diseases");
        JMenu medicineMenu = new JMenu("Medicines");
        JMenu surgeryMenu = new JMenu("Surgeries");

        
        // Create menu items
        JMenuItem patientItem = new JMenuItem("Show Patients");
        JMenuItem diseaseItem = new JMenuItem("Show Diseases");
        JMenuItem medicineItem = new JMenuItem("Show Medicines");
        JMenuItem surgeryItem = new JMenuItem("Show Surgeries");
        
        // Add menu items to menus
        patientMenu.add(patientItem);
        diseaseMenu.add(diseaseItem);
        medicineMenu.add(medicineItem);
        surgeryMenu.add(surgeryItem);
       

        // Add menus to menu bar
        menuBar.add(patientMenu);
        menuBar.add(diseaseMenu);
        menuBar.add(medicineMenu);
        menuBar.add(surgeryMenu);
      
        // Set the menu bar for the frame
        setJMenuBar(menuBar);

        // Add action listeners to menu items
        patientItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PatientFrame patientFrame = new PatientFrame();
                patientFrame.setVisible(true);
            }
        });
        
        

        diseaseItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DiseaseFrame diseaseFrame = new DiseaseFrame();
                diseaseFrame.setVisible(true);
            }
        });

        medicineItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MedicineFrame medicineFrame = new MedicineFrame();
                medicineFrame.setVisible(true);
            }
        });
        surgeryItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DoctorSurgeryFrame doctorSurgeryFrame = new DoctorSurgeryFrame();
                doctorSurgeryFrame.setVisible(true);
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
            	LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
            }
        });
    }
}

    
