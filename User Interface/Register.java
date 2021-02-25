import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JPasswordField passwordConfirm;
	private JTextField emailField;
	private JTextField phoneField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Account Name");
		lblNewLabel.setBounds(25, 40, 123, 16);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(25, 80, 61, 16);
		
		JLabel lblNewLabel_2 = new JLabel("Confirm Password");
		lblNewLabel_2.setBounds(25, 121, 123, 16);
		
		JLabel lblNewLabel_3 = new JLabel("Email Address");
		lblNewLabel_3.setBounds(25, 164, 123, 16);
		
		JLabel lblNewLabel_4 = new JLabel("Phone Number");
		lblNewLabel_4.setBounds(25, 211, 99, 16);
		
		JCheckBox CheckPolicy = new JCheckBox("I agree to the Advertisement Policy");
		CheckPolicy.setBounds(25, 271, 299, 23);
		
		usernameField = new JTextField();
		usernameField.setBounds(166, 35, 208, 26);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(166, 75, 208, 26);
		passwordField.setColumns(10);
		
		passwordConfirm = new JPasswordField();
		passwordConfirm.setBounds(166, 116, 208, 26);
		passwordConfirm.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBounds(166, 159, 208, 26);
		emailField.setColumns(10);
		
		phoneField = new JTextField();
		phoneField.setBounds(166, 206, 208, 26);
		phoneField.setColumns(10);
		
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_3);
		contentPane.add(lblNewLabel_4);
		contentPane.add(CheckPolicy);
		contentPane.add(usernameField);
		contentPane.add(passwordField);
		contentPane.add(passwordConfirm);
		contentPane.add(emailField);
		contentPane.add(phoneField);
		
		JButton RegisterButton = new JButton("Register");
		RegisterButton.setBounds(128, 321, 117, 29);
		contentPane.add(RegisterButton);
		RegisterButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (CheckPolicy.isSelected()) {
				if (RegisterCheck(usernameField.getText(), passwordField.getText(), passwordConfirm.getText(), emailField.getText(), phoneField.getText())== false)
				{
					usernameField.setText("");
					passwordField.setText("");
					passwordConfirm.setText("");
					emailField.setText("");
					phoneField.setText("");
				}
				
				else {
					Login newLogin = new Login();
					newLogin.setVisible(true);
					dispose();
				}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You need to agree advertisement policy first.", "Message", JOptionPane.PLAIN_MESSAGE);
				}
					
			}});
	}

	public static Boolean RegisterCheck(String username, String password, String password2, String email, String phoneNumber) 
	{
		ArrayList<User> users = new ArrayList<User>();
		User aolong = new User("A");
		aolong.setEmail("A@student.edu.au");
		aolong.setPhoneNumber("0401234567");
		User nigel = new User("B");
		nigel.setEmail("B@student.edu.au");
		nigel.setPhoneNumber("0412345678");
		User tony = new User("C");
		tony.setEmail("C@student.edu.au");
		tony.setPhoneNumber("0423456789");
		users.add(A);
		users.add(B);
		users.add(C);
		int i;
		User s;
		for (i = 0; i < users.size(); i++ )
		{
			s=users.get(i);
			if (s.getUsername().equals(username))
			{
				JOptionPane.showMessageDialog(null, "Username already exists, please enter another username.", "Message", JOptionPane.PLAIN_MESSAGE);
			
				return false;
			}
			if (!(username.matches("[a-zA-Z0-9]+")))
			{
				JOptionPane.showMessageDialog(null, "Username must contain alpha-numeric characters only.", "Message", JOptionPane.PLAIN_MESSAGE);
				return false;
			}
			if (!(password.equals(password2)))
			{
				JOptionPane.showMessageDialog(null, "Password Mismatches", "Message", JOptionPane.PLAIN_MESSAGE);
				return false;
				
		    }
			if (s.getEmail().equals(email))
			{
				JOptionPane.showMessageDialog(null, "Email address already exists, please enter another email address.", "Message", JOptionPane.PLAIN_MESSAGE);
				return false;
			}
			if (!(email.contains("@"))||!(email.contains(".")))
			{
				JOptionPane.showMessageDialog(null, "Email address is invalid.", "Message", JOptionPane.PLAIN_MESSAGE);
				return false;
			}
			if (s.getPhoneNumber().equals(phoneNumber))
			{
				JOptionPane.showMessageDialog(null, "Phone number already exists, please use another number.", "Message", JOptionPane.PLAIN_MESSAGE);
				return false;
			}
			if (!(phoneNumber.matches("[0-9]+"))||!(phoneNumber.length()==10))
			{
				JOptionPane.showMessageDialog(null, "phone number is invalid.", "Message", JOptionPane.PLAIN_MESSAGE);
	
				return false;
			}
			
		}
		JOptionPane.showMessageDialog(null, "Registration Submitted! Please check your inbox for an email from us to confirm your email address.", "Message", JOptionPane.PLAIN_MESSAGE);
		return true;
	}
	

}
