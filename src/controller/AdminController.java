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

	public AdminController() {
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
				VersamentoController versamentoController = new VersamentoController();
				versamentoController.mostraInserimentoVers();
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
				prenotazioneController.gestioneEventi();
				adminView.getFrame().dispose();
			}
		});

		adminView.getBtnGestioneFigli().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SocioController socioController = new SocioController();
				socioController.gestioneFigli();
				adminView.getFrame().dispose();
			}
		});

		adminView.getBtnGestioneVersamenti().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VersamentoController versamentoController = new VersamentoController();
				versamentoController.mostraGestioneVers();
				adminView.getFrame().dispose();
			}
		});
		
		adminView.getBtnGestioneNonSocio().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SocioController socioController = new SocioController();
				socioController.gestioneNonSocio();
				adminView.getFrame().dispose();
			}
		});
		
		adminView.getBtnGestioneExSocio().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SocioController socioController = new SocioController();
				socioController.gestioneExSocio();
				adminView.getFrame().dispose();
			}
		});
		
		adminView.getBtnInserisciQuota().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				QuotaController quotaController = new QuotaController();
				quotaController.mostraInserimentoQuote();
				adminView.getFrame().dispose();
			}
		});
		
		adminView.getBtnVisualizzazioneQuote().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				QuotaController quotaController = new QuotaController();
				quotaController.mostraGestioneQuote();
				adminView.getFrame().dispose();
			}
		});
		
		adminView.getBtnInserisciSala().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PrenotazioneController prenotazioneController = new PrenotazioneController();
				prenotazioneController.gestioneSale();
				adminView.getFrame().dispose();
			}
		});
	}
	
}
