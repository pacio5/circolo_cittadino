package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

/**
 * @author simoneonori
 * @author eliapacioni
 * @author riccardosmerilli
 * @author francescotalento
 * @version 1.0 Marzo 2017 
 *
 * Classe GestioneLoginView, si occupa di visualizzare la finestra di login, 
 * dove è possibile gestire l'operazione di accesso
 */
public class LoginView {

	private JFrame frmCircoloCittadino;
	private JTextField username;
	private JPasswordField password;
	private JButton btnAccedi;

	/**
	 * Costruttore senza parametri LoginView, crea l'interfaccia utente per la gestione del login ed inizializza tutte le proprietà
	 */
	public LoginView() {
		frmCircoloCittadino = new JFrame("Circolo Cittadino - Login");
		frmCircoloCittadino.setResizable(false);
		frmCircoloCittadino.setBounds(100, 100, 450, 300);
		frmCircoloCittadino.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setBounds(23, 10, 70, 16);

		username = new JTextField();
		username.setBounds(98, 5, 130, 26);
		username.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(233, 10, 59, 16);

		password = new JPasswordField();
		password.setBounds(297, 5, 130, 26);
		password.setColumns(10);

		btnAccedi = new JButton("Accedi");
		btnAccedi.setBounds(182, 36, 86, 29);
		frmCircoloCittadino.getContentPane().setLayout(null);
		frmCircoloCittadino.getContentPane().add(lblUsername);
		frmCircoloCittadino.getContentPane().add(username);
		frmCircoloCittadino.getContentPane().add(lblPassword);
		frmCircoloCittadino.getContentPane().add(password);
		frmCircoloCittadino.getContentPane().add(btnAccedi);	
	}

	/**
	 * 
	 * @return username (JTextField)
	 */
	public JTextField getTextFieldUsername() {
		return username;
	}

	/**
	 * 
	 * @return password (JTextField)
	 */
	public JTextField getTextFieldPassword() {
		return password;
	}
	
	/**
	 * 
	 * @return frmCircoloCittadino (JFrame)
	 */
	public JFrame getFrame() {
		return frmCircoloCittadino;
	}

	/**
	 * 
	 * @return btnAccedi (JButton) bottone per effettuare il login
	 */
	public JButton getBtnAccedi() {
		return btnAccedi;
	}
}
