package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginpage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public loginpage() {
    	
    	
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JLabel headingLabel = new JLabel("STOCK ACCOUNTING LOGIN");
        
        headingLabel.setFont(new Font("Arial", Font.BOLD, 24)); 
        
        

        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridwidth = 2;
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(headingLabel, constraints);

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JButton submitButton = new JButton("Submit");
        JButton exitButton = new JButton("Exit");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());

                // Add your authentication logic here
                if (authenticate(username, password)) {
                    JOptionPane.showMessageDialog(example.this, "Login successful!");
                } else {
                    JOptionPane.showMessageDialog(example.this, "Login failed. Please try again.");
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        constraints.gridwidth = 1;
        constraints.gridy = 1;
        panel.add(usernameLabel, constraints);
        constraints.gridx = 1;
        panel.add(usernameField, constraints);

        constraints.gridy = 2;
        constraints.gridx = 0;
        panel.add(passwordLabel, constraints);
        constraints.gridx = 1;
        panel.add(passwordField, constraints);

        constraints.gridy = 3;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(submitButton, constraints);

        constraints.gridy = 4;
        panel.add(exitButton, constraints);

        setContentPane(panel);
        pack(); // Automatically adjust the window size based on components

        // Add a component listener to handle resizing
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                // Ensure a minimum size of 400x300
                int width = getWidth() < 400 ? 400 : getWidth();
                int height = getHeight() < 300 ? 300 : getHeight();

                setSize(width, height);
            }
        });
    }

    private boolean authenticate(String username, String password) {
        // Replace this with your authentication logic
        return username.equals("admin") && password.equals("password");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new example().setVisible(true);
            }
        });
    }
}
