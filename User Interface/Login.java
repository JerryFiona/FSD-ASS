import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField loginame;
	private JPasswordField loginpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(50, 51, 90, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(50, 107, 90, 16);
		contentPane.add(lblNewLabel_1);
		
		loginame = new JTextField();
		loginame.setBounds(152, 47, 173, 26);
		contentPane.add(loginame);
		loginame.setColumns(10);
		
		loginpass = new JPasswordField();
		loginpass.setBounds(152, 103, 173, 26);
		contentPane.add(loginpass);
		loginpass.setColumns(10);
		
		JButton LoginButton = new JButton("Login");
		LoginButton.setForeground(Color.BLACK);
		LoginButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
			if (loginCheck(loginame.getText(),loginpass.getText())== false)
			{
				loginame.setText("");
				loginpass.setText("");
			}
			
			else {
				Homepage newpage = new Homepage();
				newpage.setVisible(true);
				dispose();
			}
			
			}});
	
		LoginButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		LoginButton.setBounds(50, 179, 311, 29);
		contentPane.add(LoginButton);
		
		JButton registerButton = new JButton("Create New Account");
		registerButton.setBounds(109, 226, 196, 29);
		contentPane.add(registerButton);
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Register createAccount = new Register();
				createAccount.setVisible(true);
				dispose();
			}
			
			});
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Remember Me");
		chckbxNewCheckBox.setBounds(50, 144, 128, 23);
		contentPane.add(chckbxNewCheckBox);
	}
	public static Boolean loginCheck(String username, String password) 
	{
		ArrayList<User> users = new ArrayList<User>();
		User aolong = new User("aolong");
		aolong.setPassword("fsd111");
		User nigel = new User("nigel");
		nigel.setPassword("fsd222");
		User tony = new User("tony");
		tony.setPassword("fsd333");
		users.add(aolong);
		users.add(nigel);
		users.add(tony);
		int i;
		User s;
		for (i = 0; i < users.size(); i++ )
		{
			s=users.get(i);
			if (s.getUsername().equals(username)&& s.getPassword().equals(password))
			{
				JOptionPane.showMessageDialog(null, "Login successful!", "Message", JOptionPane.PLAIN_MESSAGE);
			return true;
			}
		}
		JOptionPane.showMessageDialog(null, "Username or password incorrect", "Message", JOptionPane.PLAIN_MESSAGE);
		return false;
		
	}
}
