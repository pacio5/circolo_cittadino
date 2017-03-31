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
 * @author simoneonori
 * @author eliapacioni
 * @author riccardosmerilli
 * @author francescotalento
 * @version 1.0 Marzo 2017 
 * 
 * Classe AdminController, si occupa di gestire tutti gli eventi generati dell' AdminView e di reindirizzare alla nuova view richiesta
 */
public class AdminController {

	private AdminView adminView;

	/**
	 * Costruttore dell'AdminController, 
	 * inizializza l'AdminView e la rende visibile
	 */
	public AdminController() {
		adminView = new AdminView();
		adminView.getFrame().setVisible(true);
	}
	
	/**
	 * Metodo che si occupa di gestire gli eventi generati dall' AdminView, 
	 * e di inizializzare il controller adeguato per far visualizzare all'utente la view richiesta
	 */
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
		
		adminView.getBtnPrenotaSala().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PrenotazioneController prenotazioneController = new PrenotazioneController();
				prenotazioneController.affittaSale();
				adminView.getFrame().dispose();
			}
		});
		
		adminView.getBtnPrenotaEvento().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PrenotazioneController prenotazioneController = new PrenotazioneController();
				prenotazioneController.prenotaEvento();
				adminView.getFrame().dispose();
			}
		});
		
		adminView.getBtnChiusuraAnnuale().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VersamentoController versamentoController = new VersamentoController();
				versamentoController.mostraChiusuraAnnuale();;
				adminView.getFrame().dispose();
			}
		});
		
		adminView.getBtnPassaggioCategoria().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				SocioController socioController = new SocioController();
				socioController.passaggiCategoria();
				adminView.getFrame().dispose();
			}
		});
		
		adminView.getBtnGestioneConvenzioni().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				ConvenzioneController convenzioneController = new ConvenzioneController();
				convenzioneController.gestioneConvenzione();
				adminView.getFrame().dispose();
			}
		});
		
		adminView.getBtnBefane().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				PrenotazioneController befaneController = new PrenotazioneController();
				befaneController.gestioneBefane();
				adminView.getFrame().dispose();
			}
		});
		
		adminView.getBtnGestionePdf().addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				GestionePdfController gestionePdfController = new GestionePdfController();
				gestionePdfController.gestionePdf();
				adminView.getFrame().setEnabled(false);
			}
		});
		
		
	}	
}