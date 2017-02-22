package view;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LoginView {

	private JFrame frmCircoloCittadino;
	private JTextField textFieldUsername;
	private JPasswordField Password;
	private JButton btnAccedi;

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCircoloCittadino = new JFrame("Circolo Cittadino - Login");
		frmCircoloCittadino.setBounds(100, 100, 450, 300);
		frmCircoloCittadino.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel lblUsername = new JLabel("Username: ");

		textFieldUsername = new JTextField();
		textFieldUsername.setColumns(10);

		JLabel lblPassword = new JLabel("Password");

		Password = new JPasswordField();
		Password.setColumns(10);

		btnAccedi = new JButton("Accedi");
		FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 5, 5);
		frmCircoloCittadino.getContentPane().setLayout(flowLayout);
		frmCircoloCittadino.getContentPane().add(lblUsername);
		frmCircoloCittadino.getContentPane().add(textFieldUsername);
		frmCircoloCittadino.getContentPane().add(lblPassword);
		frmCircoloCittadino.getContentPane().add(Password);
		frmCircoloCittadino.getContentPane().add(btnAccedi);
		
	}

	public JTextField getTextFieldUsername() {
		return textFieldUsername;
	}

	public JTextField getTextFieldPassword() {
		return Password;
	}

	public JFrame getFrame() {
		return frmCircoloCittadino;
	}

	public JButton getBtnAccedi() {
		return btnAccedi;
	}
}
