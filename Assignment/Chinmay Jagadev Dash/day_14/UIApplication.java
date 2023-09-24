package Day14;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UIApplication {
    JTextField tfSlno, tfName, tfRegdNo;
    Connection conn;
    java.sql.PreparedStatement preparedStatement; 
    Statement stmt; 
    ResultSet rs;

    public UIApplication() {
        JFrame frm = new JFrame("Students Database");
        frm.setLayout(null);
        frm.setIconImage(new ImageIcon("./icon.png").getImage());

        JLabel lbSlno = new JLabel("SLNo: ");
        lbSlno.setBounds(25, 50, 200, 30);
        frm.add(lbSlno);

        tfSlno = new JTextField();
        tfSlno.setBounds(230, 50, 200, 30);
        frm.add(tfSlno);

        JLabel lbName = new JLabel("Name: ");
        lbName.setBounds(25, 100, 200, 30);
        frm.add(lbName);

        tfName = new JTextField();
        tfName.setBounds(230, 100, 200, 30);
        frm.add(tfName);

        JLabel lbRegdNo = new JLabel("Regd_No: ");
        lbRegdNo.setBounds(25, 150, 200, 30);
        frm.add(lbRegdNo);

        tfRegdNo = new JTextField();
        tfRegdNo.setBounds(230, 150, 200, 30);
        frm.add(tfRegdNo);


        JButton btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String slno = tfSlno.getText();
                String name = tfName.getText();
                String regdNo = tfRegdNo.getText();
                System.out.println("SLNo: " + slno);
                System.out.println("Name: " + name);
                System.out.println("Regd_No: " + regdNo);
                insertData(slno, name, regdNo);

                System.out.println("Data inserted into the database.");
            }
        });
        btnSubmit.setBounds(150, 250, 100, 30);
        frm.add(btnSubmit);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Thank you!");
                System.exit(0);
            }
        });
        btnExit.setBounds(260, 250, 100, 30);
        frm.add(btnExit);

        frm.setBounds(200, 180, 600, 450);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void insertData(String slno, String name, String regdNo) {
        try {
            Class.forName("org.gjt.mm.mysql.Driver"); 
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gift_4", "root", "");
            stmt = conn.createStatement();

            String insertQuery = "INSERT INTO students (slno, name, regd_no) VALUES (?, ?, ?)";
            preparedStatement = conn.prepareStatement(insertQuery);

            preparedStatement.setString(1, slno);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, regdNo);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Data insertion failed.");
            }


            preparedStatement.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new UIApplication();
    }
}