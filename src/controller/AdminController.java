/**
 * 
 */
package controller;

import view.AdminView;
import controller.LoginController;
import controller.SocioController;
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

	public AdminController(){
		adminView = new AdminView();
		adminView.getFrame().setVisible(true);
	}
	
	public AdminController(AdminView view) {
		adminView = view;
	}

	public void controlloEvento() {
		adminView.getBtnLogout().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginController loginController = new LoginController();
				loginController.controlloEvento();
				adminView.getFrame().dispose();
			}
		});
		
		adminView.getBtnInserisciSocio().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SocioController socioController = new SocioController();
				socioController.inserimentoSocio();
				adminView.getFrame().dispose();
			}
		});
		
		adminView.getBtnInserisciVersamento().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SpillController spillController = new SpillController();
				spillController.MostraInserimentoVers();
				adminView.getFrame().dispose();
			}
		});

		adminView.getBtnElencoSoci().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SocioController socioController = new SocioController();
				socioController.visualizzazioneSoci();
				adminView.getFrame().dispose();
			}
		});
		
		adminView.getBtnInserisciEvento().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PrenotazioneController prenotazioneController = new PrenotazioneController();
				prenotazioneController.Inserimento();
				adminView.getFrame().dispose();
			}
		});
		
		adminView.getBtnGestioneFigli().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				SocioController socioController = new SocioController();
				socioController.gestioneFigli();
				adminView.getFrame().dispose();
			}
		});
	}
	
}
