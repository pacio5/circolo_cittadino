package main;

import java.awt.EventQueue;

import controller.LoginController;

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
					LoginController controller = new LoginController();
					controller.controlloEvento();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
