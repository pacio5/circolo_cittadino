package view;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import utility.MySql;

public class ServerView {

	private JFrame frame;
	private JTextField host;
	private JTextField username;
	private JPasswordField password;
	private JTextField db;
	private JButton btnAccetta;
	private JButton btnAnnulla;

	/**
	 * Costruttore senza parametri ServerView,  crea l'interfaccia utente per la gestione del login ed inizializza tutte le proprietà
	 */
	public ServerView(MySql database) {
		frame = new JFrame("Parametri Configurazione Server");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHost = new JLabel("Host: ");
		lblHost.setBounds(59, 34, 76, 16);
		frame.getContentPane().add(lblHost);
		
		String url = database.getUrl();
		String[] parts = url.split("(//)");
		parts = parts[1].split("/");
		
		host = new JTextField();
		host.setColumns(10);
		host.setBounds(201, 29, 130, 26);
		host.setText(parts[0]);
		frame.getContentPane().add(host);
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setBounds(59, 72, 70, 16);
		frame.getContentPane().add(lblUsername);

		username = new JTextField();
		username.setBounds(201, 67, 130, 26);
		username.setColumns(10);
		username.setText(database.getUtente());
		frame.getContentPane().add(username);

		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(59, 110, 76, 16);
		frame.getContentPane().add(lblPassword);

		password = new JPasswordField();
		password.setBounds(201, 105, 130, 26);
		password.setColumns(10);
		frame.getContentPane().add(password);
		
		JLabel lblDb = new JLabel("Nome del database: ");
		lblDb.setBounds(59, 143, 130, 16);
		frame.getContentPane().add(lblDb);

		db = new JTextField();
		db.setBounds(201, 143, 130, 26);
		db.setColumns(10);
		db.setText(parts[1]);
		frame.getContentPane().add(db);
		
		btnAccetta = new JButton("Accetta");
		btnAccetta.setBounds(6, 243, 148, 29);
		frame.getContentPane().add(btnAccetta);
		
		btnAnnulla = new JButton("Annulla");
		btnAnnulla.setBounds(296, 243, 148, 29);
		frame.getContentPane().add(btnAnnulla);
	}

	/**
	 * 
	 * @return frame (JFrame)
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * 
	 * @return host (JTextField)
	 */
	public JTextField getHost() {
		return host;
	}

	/**
	 * 
	 * @return username (JTextField)
	 */
	public JTextField getUsername() {
		return username;
	}

	/**
	 * 
	 * @return password (JTextField)
	 */
	public JTextField getPassword() {
		return password;
	}
	
	/**
	 * 
	 * @return db (JTextField)
	 */
	public JTextField getDb(){
		return db;
	}

	/**
	 * 
	 * @return btnAccetta (JButton)
	 */
	public JButton getBtnAccetta() {
		return btnAccetta;
	}

	/**
	 * 
	 * @return btnAnnulla (JButton)
	 */
	public JButton getBtnAnnulla() {
		return btnAnnulla;
	}
	
	
	
	
}