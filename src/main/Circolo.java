package main;

import java.awt.EventQueue;

import controller.LoginController;
import view.LoginView;

/**
 * @author eliapacioni
 *
 */
public class Circolo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView view = new LoginView();
					view.getFrame().setVisible(true);
					LoginController controller = new LoginController(view);
					controller.controlloEvento();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
