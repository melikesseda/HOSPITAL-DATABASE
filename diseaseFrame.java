    package sql;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DiseaseFrame extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;

    public DiseaseFrame() {
        setTitle("Diseases");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);

        // Create panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create table model
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Approximate Treatment Period");
        tableModel.addColumn("Disaese Name");
        tableModel.addColumn("Disease Type");
        

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
                    String query = "SELECT treatment_period, name, type FROM disease";
                    ResultSet resultSet = statement.executeQuery(query);

                    // Fetch and display the data
                    while (resultSet.next()) {
                        int treatment_period = resultSet.getInt("treatment_period");
                        String name = resultSet.getString("name");
                        String type = resultSet.getString("type");
                        

                        tableModel.addRow(new Object[]{treatment_period,name,type});
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
        /*addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Prompt the user to enter department details
                String deptNo = JOptionPane.showInputDialog(null, "Enter department number:");
                String deptName = JOptionPane.showInputDialog(null, "Enter department name:");

                try {
                    // Establish database connection
                    Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employees", "root", "Root1.");

                    // Create statement
                    Statement statement = connection.createStatement();

                    // Execute insert query
                    String query = "INSERT INTO departments (dept_no, dept_name) VALUES ('" + deptNo + "', '" + deptName + "')";
                    int rowsAffected = statement.executeUpdate(query);

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Department added successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to add department!");
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
                    // Get the department number from the selected row
                    String deptNo = (String) table.getValueAt(selectedRow, 0);

                    int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the department with number '" + deptNo + "'?", "Confirm Delete", JOptionPane.YES_NO_OPTION);

                    if (confirmResult == JOptionPane.YES_OPTION) {
                        try {
                            // Establish database connection
                            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employees", "root", "Root1.");

                            // Create statement
                            Statement statement = connection.createStatement();

                            // Execute delete query
                            String query = "DELETE FROM departments WHERE dept_no='" + deptNo + "'";
                            int rowsAffected = statement.executeUpdate(query);

                            if (rowsAffected > 0) {
                                JOptionPane.showMessageDialog(null, "Department deleted successfully!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Failed to delete department!");
                            }

                            // Close the resources
                            statement.close();
                            connection.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a department to delete!");
                }
            }
        });*/
    }

    private void clearTable() {
        tableModel.setRowCount(0);
    }
}
    
