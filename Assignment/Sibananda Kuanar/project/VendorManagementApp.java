import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class VendorManagementApp extends JFrame {
    private JTextField productNameField;
    private JTextField vendorNameField;
    private JTextField priceField;

    public VendorManagementApp() {
        setTitle("Vendor Management App");
        setSize(600, 400); // Adjusted the size of the main window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JLabel productNameLabel = new JLabel("Product Name:");
        JLabel vendorNameLabel = new JLabel("Vendor Name:");
        JLabel priceLabel = new JLabel("Price:");

        productNameField = new JTextField(30);
        vendorNameField = new JTextField(30);
        priceField = new JTextField(15);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToDatabase();
            }
        });

        JButton showTableButton = new JButton("Show Table");
        showTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTable();
            }
        });

        // Create layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        panel.add(productNameLabel, constraints);
        constraints.gridy = 1;
        panel.add(vendorNameLabel, constraints);
        constraints.gridy = 2;
        panel.add(priceLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(productNameField, constraints);
        constraints.gridy = 1;
        panel.add(vendorNameField, constraints);
        constraints.gridy = 2;
        panel.add(priceField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        panel.add(saveButton, constraints);

        constraints.gridy = 4;
        panel.add(showTableButton, constraints);

        add(panel);
    }

    private void saveToDatabase() {
        String productName = productNameField.getText();
        String vendorName = vendorNameField.getText();
        double price = Double.parseDouble(priceField.getText());

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/intern", "root", "Rashmi@123");
            String query = "INSERT INTO VendorProduct (product_name, vendor_name, price) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, productName);
            preparedStatement.setString(2, vendorName);
            preparedStatement.setDouble(3, price);
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data saved successfully.");
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error saving data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void showTable() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/intern", "root", "Rashmi@123");
            String query = "SELECT * FROM VendorProduct";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Create a table model to hold the data
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("ID");
            tableModel.addColumn("Product Name");
            tableModel.addColumn("Vendor Name");
            tableModel.addColumn("Price");

            // Populate the table model with data from the ResultSet
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String productName = resultSet.getString("product_name");
                String vendorName = resultSet.getString("vendor_name");
                double price = resultSet.getDouble("price");

                tableModel.addRow(new Object[]{id, productName, vendorName, price});
            }

            // Create a new window to display the table
            JFrame tableFrame = new JFrame("Vendor Product Table");
            JTable table = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);
            tableFrame.add(scrollPane);
            tableFrame.setSize(800, 600); // Adjusted the size of the table window
            tableFrame.setLocationRelativeTo(null);
            tableFrame.setVisible(true);

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error displaying table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VendorManagementApp().setVisible(true);
            }
        });
    }
}
