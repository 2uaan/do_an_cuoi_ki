package view;

import java.awt.EventQueue;
import java.lang.Object;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame{
	

	private JPanel contentPane;
	private JTextField nameTextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 181);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setToolTipText("Login");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel NameLabel = new JLabel("Name:");
		NameLabel.setFont(new Font("Consolas", Font.BOLD, 20));
		NameLabel.setBounds(60, 36, 67, 20);
		contentPane.add(NameLabel);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Consolas", Font.PLAIN, 15));
		nameTextField.setBounds(150, 36, 228, 20);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel PasswordLabel = new JLabel("Password:");
		PasswordLabel.setFont(new Font("Consolas", Font.BOLD, 20));
		PasswordLabel.setBounds(17, 67, 110, 20);
		contentPane.add(PasswordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(150, 67, 228, 20);
		contentPane.add(passwordField);
		
		JButton LoginButton = new JButton("Login");
		LoginButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		LoginButton.setForeground(new Color(255, 255, 255));
		LoginButton.setBackground(new Color(0, 128, 192));
		LoginButton.setBounds(349, 105, 77, 27);
		contentPane.add(LoginButton);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(380, 38, 46, 14);
		contentPane.add(lblNewLabel);
		
		ImageIcon icon = new ImageIcon("D:\\","eye");
		
		JButton showButton = new JButton("Show");
		showButton.setBounds(388, 65, 67, 23);
		contentPane.add(showButton);
		
		showButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (showButton.getText().equals("Show")) {
					passwordField.setEchoChar((char) 0);
					showButton.setText("Hide");
				}
				else{
					passwordField.setEchoChar('\u2022');
					showButton.setText("Show");
				}
			}
		});
		
		LoginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String n="minh2uan", p="281004";
				String name= nameTextField.getText();
				String pw= new String (passwordField.getPassword());
				if (name.equals(n) && pw.equals(p)) {
					setVisible(false);
					HomePageView hpv = new HomePageView();
					hpv.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null,"The username or password is incorrect !!!!","Error!!!", JOptionPane.ERROR_MESSAGE);
					nameTextField.setText("");
					passwordField.setText("");
				}
			}
		});
	}
	

}
