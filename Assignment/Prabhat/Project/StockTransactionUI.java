package com.main;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StockTransactionUI extends JInternalFrame {
     
	private static final long serialVersionUID = 1L;
	private Connection conn;
    private JTable table;
    private DefaultTableModel tableModel;

    public StockTransactionUI(JDesktopPane desktop, Connection conn) {
        super("Transaction Type", true, true, true, true);
        this.conn = conn;

        setLayout(new BorderLayout(5, 5));
        setResizable(true);

        // Create a table model with column names
        tableModel = new DefaultTableModel();
        tableModel.addColumn("cust_id");
        tableModel.addColumn("cust_name");
        tableModel.addColumn("cust_address");
        tableModel.addColumn("cust_phone");
        tableModel.addColumn("balance_amt");
        tableModel.addColumn("del");

        // Create the table using the model
        table = new JTable(tableModel);

        // Wrap the table in a JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel pnlBottom = new JPanel(new GridLayout(1, 6));
        add(pnlBottom, BorderLayout.SOUTH);

        JButton btnAdd = new JButton("Add");
        JButton btnModify = new JButton("Modify");
        JButton btnDelete = new JButton("Delete");
        JButton btnSearch = new JButton("Search");
        JButton btnPrint = new JButton("Print");
        JButton btnExit = new JButton("Exit");

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        pnlBottom.add(btnAdd);
        pnlBottom.add(btnModify);
        pnlBottom.add(btnDelete);
        pnlBottom.add(btnSearch);
        pnlBottom.add(btnPrint);
        pnlBottom.add(btnExit);

        desktop.add(this);
        setBounds(0, 0, desktop.getWidth(), desktop.getHeight() - 1);
        setVisible(true);

        // Load data from the database
        loadDataFromDatabase();

        // Add action listeners to buttons
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTransactionType();
            }
        });

        btnModify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyTransactionType();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteTransactionType();
            }
        });

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchTransactionType();
            }
        });
    }

    private void loadDataFromDatabase() {
        try {
            // Create a prepared statement to fetch data from the database
            String query = "SELECT cust_id, cust_name, cust_address, cust_phone, balance_amt, del FROM customer";
            PreparedStatement preparedStatement = conn.prepareStatement(query);

            // Execute the query and get the result set
            ResultSet resultSet = preparedStatement.executeQuery();

            // Clear existing data in the table
            tableModel.setRowCount(0);

            // Populate the table with data from the result set
            while (resultSet.next()) {
                int cust_id = resultSet.getInt("cust_id");
                String cust_name = resultSet.getString("cust_name");
                String cust_address = resultSet.getString("cust_address");
                String cust_phone = resultSet.getString("cust_phone");
                String balance_amt = resultSet.getString("balance_amt");
                
                String del = resultSet.getString("del");

                // Add a row to the table model
                tableModel.addRow(new Object[]{cust_id, cust_name, cust_address, cust_phone, balance_amt, del});
            }

            // Close the result set and prepared statement
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add a transaction type
    private void addTransactionType() {
        // You can show a dialog for user input (e.g., a JOptionPane or custom dialog)
        // Prompt the user to enter the transaction type details

        int custId = -1; 
        String cust_name="";// Auto-incremented in the database
        String cust_address=""; // Initialize with user input
        String cust_phone=""; // Initialize with user input
        String balance_amt=""; // Initialize with user input
        String del = ""; // Initialize with user input

        try {
            // Create a prepared statement to insert data into the database
            String insertQuery = "INSERT INTO transaction_type (cust_name, cust_address, cust_phone, balance_amt, del) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
            
			preparedStatement.setString(1, cust_name);
           
			preparedStatement.setString(2, cust_address);
           
			preparedStatement.setString(3, cust_phone);
            
			preparedStatement.setString(4, balance_amt);
            preparedStatement.setString(5, del);

            // Execute the insert query to add the new transaction type
            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Transaction type added successfully.");
                // Refresh the table to display the updated data
                loadDataFromDatabase();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add transaction type.");
            }

            // Close the prepared statement
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    // Method to modify a transaction type
    private void modifyTransactionType() {
        // You can show a dialog for selecting a transaction type to edit
        // Then, show another dialog with the selected transaction type's data for editing

        int selectedRowIndex = table.getSelectedRow();
        if (selectedRowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please select a transaction type to modify.");
            return;
        }

        // Get the transaction type data from the selected row
        int ttypeId = (int) table.getValueAt(selectedRowIndex, 0);
        String ttypeDesc = ""; // Initialize with user input
        String ttypeAbbr = ""; // Initialize with user input
        String action = ""; // Initialize with user input
        String del = ""; // Initialize with user input

        try {
            String updateQuery = "UPDATE transaction_type SET cust_name = ?, cust_address = ?, cust_phone = ?, balance_amt = ?, del = ? WHERE cust_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);
            preparedStatement.setString(1, ttypeDesc);
            preparedStatement.setString(2, ttypeAbbr);
            preparedStatement.setString(3, action);
            preparedStatement.setString(4, del);
            preparedStatement.setInt(5, ttypeId);

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Transaction type modified successfully.");
                loadDataFromDatabase();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to modify transaction type.");
            }

            // Close the prepared statement
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    // Method to delete a transaction type
    private void deleteTransactionType() {
        int selectedRowIndex = table.getSelectedRow();
        if (selectedRowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please select a transaction type to delete.");
            return;
        }

        int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this transaction type?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            int ttypeId = (int) table.getValueAt(selectedRowIndex, 0);

            try {
                String deleteQuery = "DELETE FROM transaction_type WHERE cust_id = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
                preparedStatement.setInt(1, ttypeId);

                int rowsDeleted = preparedStatement.executeUpdate();

                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(this, "Transaction type deleted successfully.");
                    loadDataFromDatabase();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete transaction type.");
                }

                // Close the prepared statement
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }

    // Method to search for a transaction type
    private void searchTransactionType() {
        // Implement search functionality here
    }
}
