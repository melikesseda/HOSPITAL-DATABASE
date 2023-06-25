    package sql;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SurgeryFrame extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;

    public SurgeryFrame() {
        setTitle("Surgery");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
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


        // Create table
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Create buttons panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());

        // Create buttons
        JButton showButton = new JButton("Show");
        //JButton addButton = new JButton("Add");
        //JButton deleteButton = new JButton("Delete");

        // Add buttons to the buttons panel
        buttonsPanel.add(showButton);
        //buttonsPanel.add(addButton);
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
                    String query = "SELECT operation_date, OperationRoomNo,doctor_name,doctor_surname FROM surgery";
                    ResultSet resultSet = statement.executeQuery(query);

                    // Fetch and display the data
                    while (resultSet.next()) {
                        String operation_date = resultSet.getString("operation_date");
                        String OperationRoomNo = resultSet.getString("OperationRoomNo");
                        String doctor_name = resultSet.getString("doctor_name");
                        String doctor_surname = resultSet.getString("doctor_surname");

                        tableModel.addRow(new Object[]{operation_date, OperationRoomNo,doctor_name,doctor_surname});
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
       /* addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Prompt the user to enter manager details
                String emp_no = JOptionPane.showInputDialog(null, "Enter emp_no:");
                String dept_no = JOptionPane.showInputDialog(null, "Enter dept_no:");

                try {
                    // Establish database connection
                    Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employees", "root", "Root1.");

                    // Create statement
                    Statement statement = connection.createStatement();

                    // Execute insert query
                    String query = "INSERT INTO departments_manager (emp_no, surname) VALUES ('" + emp_no + "', '" + dept_no + "')";
                    int rowsAffected = statement.executeUpdate(query);

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Manager added successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to add manager!");
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
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected row index
                int selectedRow = table.getSelectedRow();

                if (selectedRow != -1) {
                    // Get the manager name from the selected row
                    String emp_no = (String) table.getValueAt(selectedRow, 0);

                    int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the manager '" + emp_no + "'?", "Confirm Delete", JOptionPane.YES_NO_OPTION);

                    if (confirmResult == JOptionPane.YES_OPTION) {
                        try {
                            // Establish database connection
                            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employees", "root", "Root1.");

                            // Create statement
                            Statement statement = connection.createStatement();

                            // Execute delete query
                            String query = "DELETE FROM departments_manager WHERE name='" + emp_no + "'";
                            int rowsAffected = statement.executeUpdate(query);

                            if (rowsAffected > 0) {
                                JOptionPane.showMessageDialog(null, "Manager deleted successfully!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Failed to delete manager!");
                            }

                            // Close the resources
                            statement.close();
                            connection.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a manager to delete!");
                }
            }
        });*/
    }

    private void clearTable() {
        tableModel.setRowCount(0);
    }
}
    
