package controller;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import view.LoginView;
import view.ServerView;
import model.LoginModel;
import utility.Validator;

/**
 * @author simoneonori
 * @author eliapacioni
 * @author riccardosmerilli
 * @author francescotalento
 * @version 1.0 Marzo 2017
 * 
 *          Classe LoginController che si occupa di gestire gli eventi generati
 *          dalla LoginView e prendere i dati necessari dal LoginModel
 */
public class LoginController {

	private LoginModel loginModel;
	private LoginView loginView;

	/**
	 * Costruttore senza parametri del LoginController, inizializza la LoginView
	 * e la rende visibile, inizializza il LoginModel
	 */
	public LoginController() {
		loginModel  = new LoginModel();
	}

	/**
	 * Metodo che serve per intercettare gli eventi generati dalla LoginView
	 */
	public void controlloLogin() {
		loginView = new LoginView();
		loginView.getFrame().setVisible(true);
		loginView.getTextFieldPassword().addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent key) {
				if (key.getKeyCode() == KeyEvent.VK_ENTER) {
					String user, password;
					user = loginView.getTextFieldUsername().getText();
					password = loginView.getTextFieldPassword().getText();
					if (loginModel.accedi(user, password)) {
						JOptionPane.showMessageDialog(loginView.getFrame().getContentPane(), "Benvenuto " + user);
						AdminController adminController = new AdminController();
						adminController.controlloEvento();
						loginView.getFrame().dispose();
					} else {
						JOptionPane.showMessageDialog(loginView.getFrame().getContentPane(), "Credenziali errate");
					}
				}
			}

			@Override
			public void keyTyped(KeyEvent key) {
			}

			@Override
			public void keyReleased(KeyEvent key) {
			}
		});

		loginView.getBtnAccedi().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String user, password;
				user = loginView.getTextFieldUsername().getText();
				password = loginView.getTextFieldPassword().getText();
				if (loginModel.accedi(user, password)) {
					JOptionPane.showMessageDialog(loginView.getFrame().getContentPane(), "Benvenuto " + user);
					AdminController adminController = new AdminController();
					adminController.controlloEvento();
					loginView.getFrame().dispose();
				} else {
					JOptionPane.showMessageDialog(loginView.getFrame().getContentPane(), "Credenziali errate");
				}
			}
		});

		loginView.getBtnServer().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				configurazione();
				loginView.getFrame().dispose();

			}
		});
	}

	/**
	 * Metodo che serve per intercettare gli eventi generati dalla ServerView
	 */
	public void configurazione() {
		
		ServerView view = new ServerView(loginModel.getDb());
		view.getFrame().setVisible(true);

		view.getBtnAccetta().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String val = view.getHost().getText();
				String ndb = view.getDb().getText();
				String userdb = view.getUsername().getText();
				String passdb = view.getPassword().getText();
				Boolean validazione = true;
				if (!Validator.validaHost(val)) {
					view.getHost().setBackground(Color.red);
					JOptionPane.showMessageDialog(loginView.getFrame().getContentPane(), "Nome host non valido, indicare nomeHost:nomeporta");
					validazione = false;
				} 
				if(ndb.length() == 0){
					view.getDb().setBackground(Color.red);
					validazione = false;
				}
				
				if(userdb.length() == 0)
					userdb = " ";
				if(passdb.length() == 0)
					passdb = " ";
				
				if(validazione){

					int res = JOptionPane.showConfirmDialog(view.getFrame().getContentPane(),
							"Sei sicuro di voler modificare le impostazioni del server?");
					if (res == JOptionPane.YES_OPTION) {
						String host = "jdbc:mysql://" + val + "/" + ndb;

						try {

							DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
							DocumentBuilder docBuilder;
							docBuilder = docFactory.newDocumentBuilder();

							// Root elements
							Document doc = docBuilder.newDocument();
							Element rootElement = doc.createElement("database");
							doc.appendChild(rootElement);

							// Driver
							Element driver = doc.createElement("driver");
							driver.appendChild(doc.createTextNode("com.mysql.jdbc.Driver"));
							rootElement.appendChild(driver);

							// Url
							Element url = doc.createElement("url");
							url.appendChild(doc.createTextNode(host));
							rootElement.appendChild(url);

							// User
							Element user = doc.createElement("user");
							user.appendChild(doc.createTextNode(userdb));
							rootElement.appendChild(user);

							// Password
							Element password = doc.createElement("password");
							password.appendChild(doc.createTextNode(passdb));
							rootElement.appendChild(password);

							TransformerFactory transformerFactory = TransformerFactory.newInstance();
							Transformer transformer = transformerFactory.newTransformer();
							DOMSource source = new DOMSource(doc);
							StreamResult result = new StreamResult(new File("resources/config.xml"));

							transformer.transform(source, result);

							LoginController loginController = new LoginController();
							loginController.controlloLogin();
							view.getFrame().dispose();

						} catch (ParserConfigurationException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (TransformerException e2) {
							e2.printStackTrace();
						}

					}
				}else{
					
				}
			}
		});

		view.getBtnAnnulla().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginController loginController = new LoginController();
				loginController.controlloLogin();
				view.getFrame().dispose();
			}
		});

	}
}