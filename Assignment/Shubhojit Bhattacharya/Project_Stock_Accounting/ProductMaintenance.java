package Project_Stock_Accounting;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

public class ProductMaintenance extends JFrame {
    JTable table;
    public Connection conn;
    public Statement stmt;
    public ResultSet rs;
    public ResultSetMetaData rsmd;
	public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        new ProductMaintenance();
    });
}

    public ProductMaintenance() {
        this.setLayout(new BorderLayout());
        this.setTitle("Product");

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stock_accounting", "root", "");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT p.product_id,p.product_desc,m.mfg_desc,k.pack_desc FROM product AS p LEFT JOIN manufacturer AS m ON p.mfg_id=m.mfg_id LEFT JOIN packing AS k ON p.pack_id=k.pack_id");
            rsmd = rs.getMetaData();
            String[] columnNames = {"ID", "PRODUCT-NAME", "MANUFACTURER-NAME", "PACKING"};

            // Create a table model with column names and no data
            MyTableModel model = new MyTableModel(rs, columnNames);

            // Create the table using the model
            table = new JTable(model);

            // Wrap the table in a JScrollPane
            JScrollPane scrollPane = new JScrollPane(table);
            this.add(scrollPane, BorderLayout.CENTER);

        } catch (ClassNotFoundException e) {
        } catch (SQLException e) {
        } catch (Exception e) {
        }

        // Create a panel for the top section (Manufacturer, Zero-Stock, Indent-Now, Alphabetical)
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 30, 5));
        topPanel.add(new JLabel("| Manufacturer |"));
        topPanel.add(new JLabel("| Zero-Stock |"));
        topPanel.add(new JLabel("| Indent-Now |"));
        topPanel.add(new JLabel("| Alphabetical |"));

        // Create and add the bottom panel with buttons
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton addButton = new JButton("Add");
        JButton modifyButton = new JButton("Modify");
        JButton deleteButton = new JButton("Delete");
        JButton searchButton = new JButton("Search");
        JButton printButton = new JButton("Print");
        JButton exitButton = new JButton("Exit");
        JButton firstButton = new JButton("<<");
        JButton prevButton = new JButton("<");
        JButton nextButton = new JButton(">");
        JButton lastButton = new JButton(">>");

        // Add arrow buttons to the bottom panel
        bottomPanel.add(firstButton);
        bottomPanel.add(prevButton);
        bottomPanel.add(nextButton);
        bottomPanel.add(lastButton);

        bottomPanel.add(addButton);
        bottomPanel.add(modifyButton);
        bottomPanel.add(deleteButton);
        bottomPanel.add(searchButton);
        bottomPanel.add(printButton);
        bottomPanel.add(exitButton);

        add(bottomPanel, BorderLayout.SOUTH);
        add(topPanel, BorderLayout.NORTH);

        this.setBounds(100, 100, 650, 400);
        this.setVisible(true);
    }
	
}

class MyTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    public ResultSet rs;
    public ResultSetMetaData rsmd;
    private String[] columnNames;

    public MyTableModel(ResultSet rs, String[] columnNames) {
        this.rs = rs;
        this.columnNames = columnNames;
        try {
            this.rsmd = rs.getMetaData();
        } catch (SQLException e) {
        } catch (Exception e) {
        }
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        int maxRow = 0;
        try {
            int row = rs.getRow();
            rs.last();
            maxRow = rs.getRow();
            rs.absolute(row);
        } catch (SQLException e) {
        } catch (Exception e) {
        }
        return maxRow;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Object colData = null;
        try {
            rs.absolute(row + 1);
            colData = rs.getObject(col + 1);
        } catch (SQLException e) {
        } catch (Exception e) {
        }
        return colData;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
	

}

