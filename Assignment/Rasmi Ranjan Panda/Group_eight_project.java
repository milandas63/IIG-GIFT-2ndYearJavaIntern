package com.regapp.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Group_eight_project {
    private JFrame frame;
    private JTextField nameField, emailField, mobileField;
    private JPasswordField passwordField;
    private JFrame loginFrame;

    public RegistrationApp() {
        initializeUI();
    }

    private void initializeUI() {
        frame = new JFrame("Registration App");
        frame.setLayout(new GridLayout(5, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();

        JLabel mobileLabel = new JLabel("Mobile:");
        mobileField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle registration and database insertion here
                registerUser();
            }
        });

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(mobileLabel);
        frame.add(mobileField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(new JLabel());
        frame.add(registerButton);

        // Set frame size
        int frameWidth = 600;
        int frameHeight = 400;
        frame.setSize(frameWidth, frameHeight);

        // Center the frame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frameWidth) / 2;
        int centerY = (screenSize.height - frameHeight) / 2;
        frame.setLocation(centerX, centerY);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void openWelcomeWindow() {
        // Close all previous windows
        frame.dispose();
        if (loginFrame != null) {
            loginFrame.dispose();
        }

        // Create a new welcome window
        JFrame welcomeFrame = new JFrame("Welcome to Stock Management");
        welcomeFrame.setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome to our Stock Management Project. Have fun!");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 24));

        welcomeFrame.add(welcomeLabel, BorderLayout.CENTER);

        // Set frame size
        int frameWidth = 800;
        int frameHeight = 600;
        welcomeFrame.setSize(frameWidth, frameHeight);

        // Center the frame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frameWidth) / 2;
        int centerY = (screenSize.height - frameHeight) / 2;
        welcomeFrame.setLocation(centerX, centerY);

        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcomeFrame.setVisible(true);
    }

    private void registerUser() {
        String name = nameField.getText();
        String email = emailField.getText();
        String mobile = mobileField.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/intern", "root", "Rashmi@123");
            
            // Check if the email already exists
            PreparedStatement checkEmailStatement = conn.prepareStatement("SELECT COUNT(*) FROM users WHERE email = ?");
            checkEmailStatement.setString(1, email);
            ResultSet resultSet = checkEmailStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);

            if (count > 0) {
                JOptionPane.showMessageDialog(frame, "Duplicate email. Please try a new one.");
            } else {
                // Email is not a duplicate, proceed with registration
                PreparedStatement insertStatement = conn.prepareStatement("INSERT INTO users (name, email, mobile, password) VALUES (?, ?, ?, ?)");
                insertStatement.setString(1, name);
                insertStatement.setString(2, email);
                insertStatement.setString(3, mobile);
                insertStatement.setString(4, password);

                int rowsInserted = insertStatement.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(frame, "User registered successfully!");

                    // Open the login verification window
                    openLoginVerificationWindow(email, password);
                } else {
                    JOptionPane.showMessageDialog(frame, "Registration failed.");
                }
            }

            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Database error: " + ex.getMessage());
        }
    }


    private void openLoginVerificationWindow(String email, String password) {
        loginFrame = new JFrame("Login Verification");
        loginFrame.setLayout(new GridLayout(3, 2));

        JLabel emailLabel = new JLabel("Email (Username):");
        JTextField emailField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JButton verifyButton = new JButton("Verify");
        verifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredEmail = emailField.getText();
                char[] enteredPasswordChars = passwordField.getPassword();
                String enteredPassword = new String(enteredPasswordChars);

                // Verify the entered credentials
                if (verifyLogin(enteredEmail, enteredPassword)) {
                    JOptionPane.showMessageDialog(loginFrame, "Login successful!");
                    // Open the welcome window
                    openWelcomeWindow();
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Login failed. Incorrect username or password.");
                }
            }
        });

        loginFrame.add(emailLabel);
        loginFrame.add(emailField);
        loginFrame.add(passwordLabel);
        loginFrame.add(passwordField);
        loginFrame.add(new JLabel());
        loginFrame.add(verifyButton);

        // Set frame size
        int frameWidth = 400;
        int frameHeight = 200;
        loginFrame.setSize(frameWidth, frameHeight);

        // Center the frame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - frameWidth) / 2;
        int centerY = (screenSize.height - frameHeight) / 2;
        loginFrame.setLocation(centerX, centerY);

        loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loginFrame.setVisible(true);
    }

    private boolean verifyLogin(String enteredEmail, String enteredPassword) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/intern", "root", "Rashmi@123");
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
            statement.setString(1, enteredEmail);
            statement.setString(2, enteredPassword);

            ResultSet resultSet = statement.executeQuery();

            // If a row is found, it means the credentials are correct
            return resultSet.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Database error: " + ex.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistrationApp();
            }
        });
    }
}
