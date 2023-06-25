    package sql;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class PatientFrame extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;

    public PatientFrame() {
        setTitle("Patients");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);

        // Create panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create table model
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Patient ID");
        tableModel.addColumn("Patient Name");
        tableModel.addColumn("Patient Surname");
        tableModel.addColumn("Date Of Birth");
        tableModel.addColumn("Patient Gender");
        tableModel.addColumn("Illness");
        tableModel.addColumn("AppointmentDate");
        tableModel.addColumn("Discharge Date");
        

        // Create table
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Create buttons panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());

        // Create buttons
        JButton showButton = new JButton("Show");
        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update Discharge Date");
        JButton deleteButton = new JButton("Delete");
        // Add buttons to the buttons panel
        buttonsPanel.add(showButton);
        buttonsPanel.add(addButton);
        buttonsPanel.add(updateButton);
        buttonsPanel.add(deleteButton);
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
                    String query = "SELECT id, name, surname,DateOfBirth,gender,illness,AppointmentDate,DischargeDate FROM patient";
                    ResultSet resultSet = statement.executeQuery(query);

                    // Fetch and display the data
                    while (resultSet.next()) {
                        int patient_id = resultSet.getInt("id");
                        String patient_name = resultSet.getString("name");
                        String patient_surname = resultSet.getString("surname");
                        String patient_date = resultSet.getString("DateOfBirth");
                        String patient_gender = resultSet.getString("gender");
                        String patient_illness = resultSet.getString("illness");
                        String patient_AppointmentDate = resultSet.getString("AppointmentDate");
                        String patient_DischargeDate = resultSet.getString("DischargeDate");

                        tableModel.addRow(new Object[]{patient_id, patient_name,patient_surname,patient_date,patient_gender,patient_illness,patient_AppointmentDate,patient_DischargeDate});
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
                // Prompt the user to enter department details
                String patient_name = JOptionPane.showInputDialog(null, "Enter patient name:");
                String patient_surname = JOptionPane.showInputDialog(null, "Enter patient surname:");
                String patient_date = JOptionPane.showInputDialog(null, "Enter patient date of birth:");
                String patient_gender = JOptionPane.showInputDialog(null, "Enter patient gender:");
                String patient_illness = JOptionPane.showInputDialog(null, "Enter patient illness:");
                String patient_AppointmentDate = JOptionPane.showInputDialog(null, "Enter appointment date:");
                String patient_DischargeDate = "9999-01-01";

                try {
                    // Establish database connection
                    Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital", "root", "Root1.");

                    // Create statement
                    Statement statement = connection.createStatement();

                    // Execute insert query
                    String query = "INSERT INTO patient (name, surname,DateOfBirth,gender,illness,AppointmentDate,DischargeDate) VALUES ('" + patient_name + "', '" + patient_surname + "','" + patient_date + "', '" + patient_gender + "','" + patient_illness + "', '" + patient_AppointmentDate + "','" + patient_DischargeDate + "')";
                    int rowsAffected = statement.executeUpdate(query);

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Patient added successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to add patient!");
                    }

                    // Close the resources
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Add action listener to the delete button
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected row index
                int selectedRow = table.getSelectedRow();

                if (selectedRow != -1) {
                    // Get the department number from the selected row
                    String patient_name = (String) table.getValueAt(selectedRow, 1);
                    String patient_surname = (String) table.getValueAt(selectedRow, 2);

                    int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to update discharge date of this patient  '" + patient_name+ patient_surname  + "'?", "Confirm Delete", JOptionPane.YES_NO_OPTION);

                    if (confirmResult == JOptionPane.YES_OPTION) {
                    	String patient_DischargeDate = JOptionPane.showInputDialog(null, "Enter updated discharge date:");
                        try {
                            // Establish database connection
                            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital", "root", "Root1.");

                            // Create statement
                            Statement statement = connection.createStatement();

                            // Execute delete query
                            String query = "UPDATE patient SET DischargeDate='" + patient_DischargeDate + "' WHERE name='" + patient_name + "' AND surname='" + patient_surname + "'";
                            int rowsAffected = statement.executeUpdate(query);

                            if (rowsAffected > 0) {
                                JOptionPane.showMessageDialog(null, "Discharge date updated successfully!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Failed to update discharge date!");
                            }

                            // Close the resources
                            statement.close();
                            connection.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a discharge date to update!");
                }
            }
        });
     // Add action listener to the delete button
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected row index
                int selectedRow = table.getSelectedRow();

                if (selectedRow != -1) {
                    String patient_name = (String) table.getValueAt(selectedRow, 1);
                    String patient_surname = (String) table.getValueAt(selectedRow, 2);

                    int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the patient with patient name '" +  patient_name + " " + patient_surname + "'?", "Confirm Delete", JOptionPane.YES_NO_OPTION);

                    if (confirmResult == JOptionPane.YES_OPTION) {
                        try {
                            // Establish database connection
                            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital", "root", "Root1.");

                            // Create statement
                            Statement statement = connection.createStatement();

                            // Execute delete query
                            String query = "DELETE FROM patient WHERE name='" +  patient_name + "' AND surname='" + patient_surname + "'";
                            int rowsAffected = statement.executeUpdate(query);

                            if (rowsAffected > 0) {
                                JOptionPane.showMessageDialog(null, "Patient deleted successfully!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Failed to delete patient!");
                            }

                            // Close the resources
                            statement.close();
                            connection.close();
                        }   catch (SQLIntegrityConstraintViolationException ex) {
                            JOptionPane.showMessageDialog(null, "Cannot delete the patient. This patient is referenced in the surgery table.");
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a patient to delete!");
                }
            }
        });

    }
    

    private void clearTable() {
        tableModel.setRowCount(0);
    }
}
    
