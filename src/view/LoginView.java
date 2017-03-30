package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

/**
 * @author eliapacioni
 *
 */
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
		frmCircoloCittadino.setResizable(false);
		frmCircoloCittadino.setBounds(100, 100, 450, 300);
		frmCircoloCittadino.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setBounds(23, 10, 70, 16);

		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(98, 5, 130, 26);
		textFieldUsername.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(233, 10, 59, 16);

		Password = new JPasswordField();
		Password.setBounds(297, 5, 130, 26);
		Password.setColumns(10);

		btnAccedi = new JButton("Accedi");
		btnAccedi.setBounds(182, 36, 86, 29);
		frmCircoloCittadino.getContentPane().setLayout(null);
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
