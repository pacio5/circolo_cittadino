/**
 * 
 */
package controller;

import view.AdminView;
import view.LoginView;
//import model.AdminModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author eliapacioni
 *
 */
public class AdminController {

	private AdminView adminView;

	/**
	 * Il model è stato inserito per dare una visione completa anche se a
	 * livello di admin è inutilizzato in questo momento private AdminModel
	 * adminModel;
	 */

	public AdminController(AdminView view) {
		adminView = view;
		// adminModel = new AdminModel();
	}

	public void controlloEvento() {
		adminView.getBtnLogout().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginView loginView = new LoginView();
				loginView.getFrame().setVisible(true);
				adminView.getFrame().dispose();
			}
		});
	}
}
