/**
 * 
 */
package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

import view.LoginView;
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

	public void controlloEvento() {

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
	}
}