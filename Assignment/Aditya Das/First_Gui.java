package assignment9;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class First_Gui {
	JTextField tfUser;
	JPasswordField pfPass;
	
	public First_Gui() {
		JFrame frm = new JFrame("Login");
		frm.setLayout(null);
		
		JLabel lblUser = new JLabel("Username: ", JLabel.RIGHT);
		lblUser.setBounds(25,100,200,30);
		frm.add(lblUser);
		
		tfUser = new JTextField();
		tfUser.setBounds(230,100,200,30);
		frm.add(tfUser);
		
		JLabel lblPass = new JLabel("Password: ", JLabel.RIGHT);
		lblPass.setBounds(25,135,200,30);
		frm.add(lblPass);
		
		pfPass = new JPasswordField();
		pfPass.setBounds(230, 135, 200, 30);
		frm.add(pfPass);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String user = tfUser.getText();
				String pass = pfPass.getText();
				System.out.println(user+" / "+pass);
                Write_to_file(user,pass);
			}
		});
		btnSubmit.setBounds(150,250,100,30);
		frm.add(btnSubmit);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new MyClass());
		btnExit.setBounds(260,250,100,30);
		frm.add(btnExit);
	
		frm.setBounds(200, 180, 600, 450);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    public void Write_to_file(String User,String Pass){
        String fileName = "Day9/Data.txt"; 

        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String contentToAdd = User+" / "+Pass;

            bufferedWriter.write(contentToAdd);
            bufferedWriter.newLine(); // Add a newline character if needed

            bufferedWriter.close();

            System.out.println("Content added to the file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public static void main(String[] args) {
		new First_Gui();
	}
}

class MyClass implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent ae) {
		System.out.println("Thank you!");
		System.exit(0);
	}
	
}