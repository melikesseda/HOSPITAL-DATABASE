    package sql;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class MedicineFrame extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;

    public MedicineFrame() {
        setTitle("Medicines");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);

        // Create panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create table model
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Medication Name");
        tableModel.addColumn("Prescription No");
        tableModel.addColumn("Production Date");
        tableModel.addColumn("Expiry Date");
        tableModel.addColumn("Stock Status");
        

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
                    String query = "SELECT MedicationName, PrescriptionNo, ProductionDate, ExpiryDate,StockStatus FROM medicine";
                    ResultSet resultSet = statement.executeQuery(query);

                    // Fetch and display the data
                    while (resultSet.next()) {
                        String medication_name = resultSet.getString("MedicationName");
                        String prescription_no = resultSet.getString("PrescriptionNo");
                        String production_date = resultSet.getString("ProductionDate");
                        String expiry_date = resultSet.getString("ExpiryDate");
                        int stock_status = resultSet.getInt("StockStatus");

                        tableModel.addRow(new Object[]{medication_name,prescription_no,production_date,expiry_date,stock_status});
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
                String medication_name = JOptionPane.showInputDialog(null, "Enter medicine name:");
                String prescription_no = JOptionPane.showInputDialog(null, "Enter prescription no:");
                String production_date = JOptionPane.showInputDialog(null, "Enter production date:");
                String expiry_date = JOptionPane.showInputDialog(null, "Enter expiry date:");
                String stock_status = JOptionPane.showInputDialog(null, "Enter stock status:");
              

                try {
                    // Establish database connection
                    Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital", "root", "Root1.");

                    // Create statement
                    Statement statement = connection.createStatement();
                   
                    // Execute insert query
                    String query = "INSERT INTO medicine (MedicationName, PrescriptionNo, ProductionDate, ExpiryDate, StockStatus) VALUES ('" + medication_name + "', '" + prescription_no + "', '" + production_date + "', '" + expiry_date + "', '" + stock_status + "')";

                    int rowsAffected = statement.executeUpdate(query);

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Medicine added successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to add medicine!");
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
                    // Get the medicine informations from the selected row
                    //String medication_name = (String) table.getValueAt(selectedRow, 0);
                    String prescription_no = (String) table.getValueAt(selectedRow, 1);
                    /*String production_date = (String) table.getValueAt(selectedRow, 2);
                    String expiry_date = (String) table.getValueAt(selectedRow, 3);
                    int stock_stotus = (int) table.getValueAt(selectedRow, 4);*/
                    

                    int confirmResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the medicine with prescription no '" + prescription_no + "'?", "Confirm Delete", JOptionPane.YES_NO_OPTION);

                    if (confirmResult == JOptionPane.YES_OPTION) {
                        try {
                            // Establish database connection
                            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital", "root", "Root1.");

                            // Create statement
                            Statement statement = connection.createStatement();

                            // Execute delete query
                            String query = "DELETE FROM medicine WHERE PrescriptionNo='" + prescription_no + "'";
                            int rowsAffected = statement.executeUpdate(query);

                            if (rowsAffected > 0) {
                                JOptionPane.showMessageDialog(null, "Medicine deleted successfully!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Failed to delete medicine!");
                            }

                            // Close the resources
                            statement.close();
                            connection.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a medicine to delete!");
                }
            }
        });
    }

    private void clearTable() {
        tableModel.setRowCount(0);
    }
}
    
