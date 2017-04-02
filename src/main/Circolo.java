package main;

import java.awt.EventQueue;

import controller.LoginController;

/**
 * @author simoneonori
 * @author eliapacioni
 * @author riccardosmerilli
 * @author francescotalento
 * @version 1.0 Marzo 2017 
 * 
 * Classe principale del programma, contiene il metodo main(), rappresenta quindi il punto d'ingresso dell'applicazione.
 * Si occupa di chiamare il controller che gestisce il login
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
					controller.controlloLogin();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
