

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class ManufacturerMaintenance extends JInternalFrame {
    private Connection conn;
    private JTable table;
    private DefaultTableModel tableModel;

    public ManufacturerMaintenance(JDesktopPane desktop, Connection conn) {
        super("Manufacturer", true, true, true, true);
        this.conn = conn;

        setLayout(new BorderLayout(5, 5));
        setResizable(true);

        // Create a table model with column names
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("MANUFACTURER-NAME");
        tableModel.addColumn("MANUFACTURER-ABBR");

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
        JButton firstButton = new JButton("<<");
        JButton prevButton = new JButton("<");
        JButton nextButton = new JButton(">");
        JButton lastButton = new JButton(">>");

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        pnlBottom.add(firstButton);
        pnlBottom.add(prevButton);
        pnlBottom.add(nextButton);
        pnlBottom.add(lastButton);

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
                addManufacturer();
            }
        });

        btnModify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyManufacturer();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteManufacturer();
            }
        });

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchManufacturer();
            }
        });
    }

    private void loadDataFromDatabase() {
        try {
            // Create a prepared statement to fetch data from the database
            String query = "SELECT mfg_id, mfg_desc, mfg_abbr FROM manufacturer";
            PreparedStatement preparedStatement = conn.prepareStatement(query);

            // Execute the query and get the result set
            ResultSet resultSet = preparedStatement.executeQuery();

            // Clear existing data in the table
            tableModel.setRowCount(0);

            // Populate the table with data from the result set
            while (resultSet.next()) {
                int mfgId = resultSet.getInt("mfg_id");
                String mfgDesc = resultSet.getString("mfg_desc");
                String mfgAbbr = resultSet.getString("mfg_abbr");

                // Add a row to the table model
                tableModel.addRow(new Object[] { mfgId, mfgDesc, mfgAbbr });
            }

            // Close the result set and prepared statement
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add a manufacturer
    private void addManufacturer() {
        // You can show a dialog for user input (e.g., a JOptionPane or custom dialog)
        // Prompt the user to enter the manufacturer's name and abbreviation

        String manufacturerName = ""; // Initialize with user input
        String manufacturerAbbr = ""; // Initialize with user input

        try {
            // Create a prepared statement to insert data into the database
            String insertQuery = "INSERT INTO manufacturer (mfg_desc, mfg_abbr) VALUES (?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
            preparedStatement.setString(1, manufacturerName);
            preparedStatement.setString(2, manufacturerAbbr);

            // Execute the insert query to add the new manufacturer
            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Manufacturer added successfully.");
                // Refresh the table to display the updated data
                loadDataFromDatabase();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add manufacturer.");
            }

            // Close the prepared statement
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    // Method to modify a manufacturer
    private void modifyManufacturer() {
        // You can show a dialog for selecting a manufacturer to edit
        // Then, show another dialog with the selected manufacturer's data for editing

        int selectedRowIndex = table.getSelectedRow();
        if (selectedRowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please select a manufacturer to modify.");
            return;
        }

        // Get the manufacturer data from the selected row
        int manufacturerId = (int) table.getValueAt(selectedRowIndex, 0);
        String manufacturerName = ""; // Initialize with user input
        String manufacturerAbbr = ""; // Initialize with user input

        try {
            String updateQuery = "UPDATE manufacturer SET mfg_desc = ?, mfg_abbr = ? WHERE mfg_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);
            preparedStatement.setString(1, manufacturerName);
            preparedStatement.setString(2, manufacturerAbbr);
            preparedStatement.setInt(3, manufacturerId);

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Manufacturer modified successfully.");
                loadDataFromDatabase();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to modify manufacturer.");
            }

            // Close the prepared statement
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    // Method to delete a manufacturer
    private void deleteManufacturer() {
        int selectedRowIndex = table.getSelectedRow();
        if (selectedRowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please select a manufacturer to delete.");
            return;
        }

        int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this manufacturer?",
                "Confirm Deletion", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            int manufacturerId = (int) table.getValueAt(selectedRowIndex, 0);

            try {
                String deleteQuery = "DELETE FROM manufacturer WHERE mfg_id = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);
                preparedStatement.setInt(1, manufacturerId);

                int rowsDeleted = preparedStatement.executeUpdate();

                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(this, "Manufacturer deleted successfully.");
                    loadDataFromDatabase();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete manufacturer.");
                }

                // Close the prepared statement
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }

    // Method to search for a manufacturer
    private void searchManufacturer() {

    }
}
