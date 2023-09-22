package com.day15;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class USERinterface {
    JTextField tslno, tname, tregdNo;
    Connection conn;
    java.sql.PreparedStatement preparedStatement; 
    Statement stmt; 
    ResultSet rs;

    public UIApplication() {
        JFrame frm = new JFrame("Students Database");
        frm.setLayout(null);
        JLabel slno = new JLabel("slno:");
        slno.setBounds(25, 50, 200, 30);
        frm.add(slno);
        tslno = new JTextField();
        tslno.setBounds(100, 50, 200, 30);
        frm.add(tslno);
        JLabel name = new JLabel("name:");
        name.setBounds(25, 100, 200, 30);
        frm.add(name);
        tname = new JTextField();
        tname.setBounds(100, 100, 200, 30);
        frm.add(tname);
        JLabel regdNo = new JLabel("regd_No:");
        regdNo.setBounds(25, 150, 200, 30);
        frm.add(regdNo);
        tregdNo = new JTextField();
        tregdNo.setBounds(100, 150, 200, 30);
        frm.add(tregdNo);
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Slno = slno.getText();
                String Name = name.getText();
                String RegdNo = regdNo.getText();
                System.out.println("slno:" + Slno);
                System.out.println("name:" + Name);
                System.out.println("regd_No:" + RegdNo);
                insertData(Slno, Name, RegdNo);
            }
        });
        JButton exitbutton = new JButton("Exit");
        exitbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exitbutton.setBounds(100, 250, 150, 30);
        frm.add(exitbutton);

        frm.setBounds(300, 180, 350, 350);
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void insertData(String slno, String name, String regdNo) {
        try {
            Class.forName("org.gjt.mm.mysql.Driver"); 
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gift_4", "root", "");
            stmt = conn.createStatement();
            String insertQuery = "INSERT INTO students (slNo, name, Regd_no) VALUES ( , "Raj", 210126587)";
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
