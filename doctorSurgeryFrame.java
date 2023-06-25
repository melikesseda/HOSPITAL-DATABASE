    package sql;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DoctorSurgeryFrame extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;

    public DoctorSurgeryFrame() {
        setTitle("Doctor Surgery");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);

        // Create panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create table model
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Operation Date");
        tableModel.addColumn("Operation Room No");
        tableModel.addColumn("Doctor Name");
        tableModel.addColumn("Doctor Surname");
        tableModel.addColumn("Patient Name");
        tableModel.addColumn("Patient Surname");
        

        // Create table
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Create buttons panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());

        // Create buttons
        JButton showButton = new JButton("Show");
        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");

        // Add buttons to the buttons panel
        buttonsPanel.add(showButton);
        buttonsPanel.add(addButton);
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
                    String query = "SELECT operation_date, OperationRoomNo, doctor_name, doctor_surname,patient_name,patient_surname FROM surgery";
                    ResultSet resultSet = statement.executeQuery(query);

                    // Fetch and display the data
                    while (resultSet.next()) {
                        String operation_date = resultSet.getString("operation_date");
                        int OperationRoomNo = resultSet.getInt("OperationRoomNo");
                        String doctor_name = resultSet.getString("doctor_name");
                        String doctor_surname = resultSet.getString("doctor_surname");
                        String patient_name = resultSet.getString("patient_name");
                        String patient_surname = resultSet.getString("patient_surname");

                        tableModel.addRow(new Object[]{operation_date,OperationRoomNo,doctor_name,doctor_surname,patient_name,patient_surname});
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
                // Prompt the user to enter surgery details
                String operation_date = JOptionPane.showInputDialog(null, "Enter operation date:");
                String OperationRoomNo = JOptionPane.showInputDialog(null, "Enter operation room no:");
                String doctor_name = JOptionPane.showInputDialog(null, "Enter doctor name:");
                String doctor_surname = JOptionPane.showInputDialog(null, "Enter doctor surname:");
                String patient_name = JOptionPane.showInputDialog(null, "Enter patient name:");
                String patient_surname = JOptionPane.showInputDialog(null, "Enter patient surname:");

                try {
                    // Establish database connection
                    Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital", "root", "Root1.");

                    // Create statement
                    Statement statement = connection.createStatement();

                    // Execute insert query
                    String query = "INSERT INTO surgery (operation_date, OperationRoomNo, doctor_name, doctor_surname, patient_name, patient_surname) " +
                            "VALUES ('" + operation_date + "', '" + OperationRoomNo + "', '" + doctor_name + "', '" + doctor_surname + "', '" + patient_name + "', '" + patient_surname + "')";

                    int rowsAffected = statement.executeUpdate(query);

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Surgery added successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to add surgery!");
                    }

                    // Close the resources
                    statement.close();
                    connection.close();
                } catch (SQLIntegrityConstraintViolationException ex) {
                    JOptionPane.showMessageDialog(null, "Failed to add surgery! The specified doctor does not exist.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void clearTable() {
        tableModel.setRowCount(0);
    }
}
    
