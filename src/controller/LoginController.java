/**
 * 
 */
package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

import view.LoginView;
import view.AdminView;
import model.LoginModel;

/**
 * @author eliapacioni
 *
 */
public class LoginController {

	private LoginModel loginModel;
	private LoginView loginView;

	public LoginController() {
		loginView = new LoginView();
		loginView.getFrame().setVisible(true);
		loginModel = new LoginModel();
	}
	
	public LoginController(LoginView view){
		loginView = view;
		loginModel = new LoginModel();
	}

	public void controlloEvento() {

		loginView.getBtnAccedi().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String user, password;
				user = loginView.getTextFieldUsername().getText();
				password = loginView.getTextFieldPassword().getText();
				boolean esito = loginModel.accedi(user, password);
				if(esito){
					JOptionPane.showMessageDialog(loginView.getFrame().getContentPane(), "Benvenuto "+ user);
					AdminView adminView = new AdminView();
					adminView.getFrame().setVisible(true);
					AdminController adminController  = new AdminController(adminView);
					adminController.controlloEvento();
					loginView.getFrame().dispose();
				}else{
					JOptionPane.showMessageDialog(loginView.getFrame().getContentPane(), "Credenziali errate");
					
				}
			}
		});
	}

}