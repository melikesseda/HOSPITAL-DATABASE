    package sql;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AppointmentFrame extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;

    public AppointmentFrame() {
        setTitle("Appointments");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);

        // Create panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create table model
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Appointment ID");
        tableModel.addColumn("Doctor ID");
        tableModel.addColumn("Appointment Date");
        

        // Create table
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Create buttons panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());

        // Create buttons
        JButton showButton = new JButton("Show");
        JButton addButton = new JButton("Add");
        //JButton deleteButton = new JButton("Delete");

        // Add buttons to the buttons panel
        buttonsPanel.add(showButton);
        buttonsPanel.add(addButton);
        //buttonsPanel.add(deleteButton);

        // Add components to the main panel
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonsPanel, BorderLayout.SOUTH);

        // Add panel to the frame
        add(panel);

        // Add action listener to the show button
        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearTable();

                try {
                    // Establish database connection
                    Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital", "root", "Root1.");

                    // Create statement
                    Statement statement = connection.createStatement();

                    // Execute query
                    String query = "SELECT appointment_id, doctor_id, appointment_date FROM appointment";
                    ResultSet resultSet = statement.executeQuery(query);

                    // Fetch and display the data
                    while (resultSet.next()) {
                        int appointment_id = resultSet.getInt("appointment_id");
                        int doctor_id = resultSet.getInt("doctor_id");
                        String appointment_date = resultSet.getString("appointment_date");
                     

                        tableModel.addRow(new Object[]{appointment_id, doctor_id, appointment_date});
                    }

                    // Close the resources
                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Add action listener to the add button
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Prompt the user to enter employee details
                //String appointment_id = JOptionPane.showInputDialog(null, "Enter appointment id:");
                String doctor_id = JOptionPane.showInputDialog(null, "Enter doctor id:");
                String appointment_date = JOptionPane.showInputDialog(null, "Enter appointment date:");
                

                try {
                    // Establish database connection
                    Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital", "root", "Root1.");

                    // Create statement
                    Statement statement = connection.createStatement();

                    // Check if appointment_id already exists
                    //String checkQuery = "SELECT COUNT(*) FROM appointment WHERE appointment_id = '" + appointment_id + "'";
                    //ResultSet checkResult = statement.executeQuery(checkQuery);
                    //checkResult.next();
                    //int count = checkResult.getInt(1);

                    //if (count > 0) {
                    //    JOptionPane.showMessageDialog(null, "Appointment with appointment_id " + appointment_id + " already exists!");
                    //}else {
                        // Execute insert query with properly quoted values
                        String query = "INSERT INTO appointment ( doctor_id, appointment_date) VALUES ('"  + doctor_id + "', '" + appointment_date + "')";
                        int rowsAffected = statement.executeUpdate(query);

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Appointment added successfully!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to add appointment!");
                        }
                    //}

                    // Close the resources
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Add action listener to the delete button
        /*deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected row index
                int selectedRow = table.getSelectedRow();

                if (selectedRow != -1) {
                    // Get the employee name from the selected row
                    String first_name = (String) table.getValueAt(selectedRow, 1);

                    int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the employee '" + first_name + "'?", "Confirm Delete", JOptionPane.YES_NO_OPTION);

                    if (confirmResult == JOptionPane.YES_OPTION) {
                        try {
                            // Establish database connection
                            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital", "root", "Root1.");

                            // Create statement
                            Statement statement = connection.createStatement();

                            // Execute delete query
                            String query = "DELETE FROM employees WHERE first_name='" + first_name + "'";
                            int rowsAffected = statement.executeUpdate(query);

                            if (rowsAffected > 0) {
                                JOptionPane.showMessageDialog(null, "Employee deleted successfully!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Failed to delete employee!");
                            }

                            // Close the resources
                            statement.close();
                            connection.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select an employee to delete!");
                }
            }
        });*/
    }

    private void clearTable() {
        tableModel.setRowCount(0);
    }

    public static void main(String[] args) {
        AppointmentFrame frame = new AppointmentFrame();
        frame.setVisible(true);
    }
}
    
