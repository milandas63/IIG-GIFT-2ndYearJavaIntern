package project;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProductMaintenance extends JInternalFrame {
    private Connection conn;
    private JTable table;
    private DefaultTableModel tableModel;

    public ProductMaintenance(JDesktopPane desktop, Connection conn) {
        super("Product", true, true, true, true);
        this.conn = conn;

        setLayout(new BorderLayout(5, 5));
        setResizable(true);

        // Create a table model with column names
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("PRODUCT-NAME");
        tableModel.addColumn("MANUFACTURER-NAME");
        tableModel.addColumn("PACKING");

        // Create the table using the model
        table = new JTable(tableModel);

        // Wrap the table in a JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel pnlBottom = new JPanel(new GridLayout(1, 7));
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
    }

    private void loadDataFromDatabase() {
        try {
            // Create a prepared statement to fetch data from the database
            String query = "SELECT p.product_id, p.product_desc, m.mfg_desc, k.pack_desc FROM product AS p LEFT JOIN manufacturer AS m ON p.mfg_id=m.mfg_id LEFT JOIN packing AS k ON p.pack_id=k.pack_id";
            PreparedStatement preparedStatement = conn.prepareStatement(query);

            // Execute the query and get the result set
            ResultSet resultSet = preparedStatement.executeQuery();

            // Clear existing data in the table
            tableModel.setRowCount(0);

            // Populate the table with data from the result set
            while (resultSet.next()) {
                String productId = resultSet.getString("product_id");
                String productDesc = resultSet.getString("product_desc");
                String manufacturerName = resultSet.getString("mfg_desc");
                String packing = resultSet.getString("pack_desc");

                // Add a row to the table model
                tableModel.addRow(new Object[]{productId, productDesc, manufacturerName, packing});
            }

            // Close the result set and prepared statement
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
      }
