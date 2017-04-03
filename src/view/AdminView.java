package view;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * @author simoneonori
 * @author eliapacioni
 * @author riccardosmerilli
 * @author francescotalento
 * @version 1.0 Marzo 2017 
 * 
 * Classe AdminView, si occupa di visualizzare la finestra "Dashboard" del programma, 
 * da dove è possibile accedere a tutte le view per gestire le varie operazioni
 */
public class AdminView {

	private JFrame frmCircoloCittadinoDi;
	private JButton btnLogout;
	private JButton btnInserisciSocio;
	private JButton btnInserisciVersamento;
	private JButton btnInserisciEvento;
	private JButton btnElencoSoci;
	private JButton btnGestioneFigli;
	private JButton btnGestioneVersamenti;
	private JButton btnGestioneNonSocio;
	private JButton btnGestioneExSocio;
	private JButton btnInserisciQuota;
	private JButton btnVisualizzazioneQuote;
	private JButton btnInserisciSala;
	private JButton btnPrenotaSala;
	private JButton btnPrenotaEvento;
	private JButton btnChiusuraAnnuale;
	private JButton btnPassaggioCategoria;
	private JButton btnGestioneConvenzioni;
	private JButton btnBefane;
	private JButton btnGestioneBadge;
	private JButton btnStampaBigliettoAuguri;
	private JButton btnGestionePdf;

	/**
	 * Costruttore senza parametri, crea il frame ed inizializza tutti i componenti
	 */
	public AdminView() {
		frmCircoloCittadinoDi = new JFrame();
		frmCircoloCittadinoDi.setTitle("Circolo Cittadino di Ascoli Piceno");
		frmCircoloCittadinoDi.setResizable(false);
		frmCircoloCittadinoDi.setBounds(100, 100, 800, 600);
		frmCircoloCittadinoDi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnLogout = new JButton("Logout");
		btnLogout.setBounds(677, 6, 117, 29);
		
		btnInserisciSocio = new JButton("Inserisci Socio");
		btnInserisciSocio.setBounds(100, 200, 160, 29);
		
		btnInserisciVersamento = new JButton("Inserisci Versamento");
		btnInserisciVersamento.setBounds(325, 200, 160, 29);
		
		btnInserisciEvento = new JButton("Gestisci Eventi");
		btnInserisciEvento.setBounds(550, 300, 160, 29);

		btnElencoSoci = new JButton("Elenco Soci");
		btnElencoSoci.setBounds(100, 250, 160, 29);
		
		btnGestioneFigli = new JButton("Gestione Figli");
		btnGestioneFigli.setBounds(100, 300, 160, 29);
		
		btnGestioneVersamenti = new JButton("Gestione Versamenti");
		btnGestioneVersamenti.setBounds(325, 250, 160, 29);
		
		btnGestioneNonSocio = new JButton("Gestione Non Socio");
		btnGestioneNonSocio.setBounds(100, 400, 160, 29);
		
		btnGestioneExSocio = new JButton("Gestione Ex Socio");
		btnGestioneExSocio.setBounds(100, 350, 160, 29);
		
		btnInserisciQuota = new JButton("Inserimento Quota");
		btnInserisciQuota.setBounds(325, 300, 160, 29);
		
		btnVisualizzazioneQuote = new JButton("Visualizzazione Quote");
		btnVisualizzazioneQuote.setBounds(325, 350, 160, 29);
		
		btnInserisciSala = new JButton("Gestione Sale");
		btnInserisciSala.setBounds(550, 200, 160, 29);
		
		btnPrenotaSala = new JButton("Prenota Sala");
		btnPrenotaSala.setBounds(550, 250, 160, 29);
		
		btnPrenotaEvento = new JButton("Prenota Evento");
		btnPrenotaEvento.setBounds(550, 350, 160, 29);
		
		btnChiusuraAnnuale = new JButton("Chiusura Annuale");
		btnChiusuraAnnuale.setBounds(325, 400, 160, 29);
		
		btnPassaggioCategoria = new JButton("Passaggio Categoria");
		btnPassaggioCategoria.setBounds(100, 450, 160, 29);
		
		btnGestioneConvenzioni = new JButton("Gestione Convenzioni");
		btnGestioneConvenzioni.setBounds(325, 450, 160, 29);
		
		btnBefane = new JButton("Le Befane");
		btnBefane.setBounds(550, 400, 160, 29);

		btnGestioneBadge = new JButton("Badge");
		btnGestioneBadge.setBounds(550, 450, 160, 29);
		
		btnStampaBigliettoAuguri = new JButton("Biglietto Auguri");
		btnStampaBigliettoAuguri.setBounds(100, 504, 160, 29);
		
		btnGestionePdf = new JButton("Crea PDF");
		btnGestionePdf.setBounds(550, 450, 160, 29);
		
		JLabel lblImg = new JLabel(new ImageIcon("./resources/circolo.png"));

		lblImg.setBounds(22,6,762,183);
		
		frmCircoloCittadinoDi.getContentPane().setLayout(null);
		frmCircoloCittadinoDi.getContentPane().add(btnLogout);
		frmCircoloCittadinoDi.getContentPane().add(btnInserisciSocio);
		frmCircoloCittadinoDi.getContentPane().add(btnInserisciVersamento);
		frmCircoloCittadinoDi.getContentPane().add(btnInserisciEvento);
		frmCircoloCittadinoDi.getContentPane().add(btnElencoSoci);
		frmCircoloCittadinoDi.getContentPane().add(btnGestioneFigli);
		frmCircoloCittadinoDi.getContentPane().add(btnGestioneVersamenti);
		frmCircoloCittadinoDi.getContentPane().add(btnGestioneNonSocio);
		frmCircoloCittadinoDi.getContentPane().add(btnGestioneExSocio);
		frmCircoloCittadinoDi.getContentPane().add(btnInserisciQuota);
		frmCircoloCittadinoDi.getContentPane().add(btnVisualizzazioneQuote);
		frmCircoloCittadinoDi.getContentPane().add(btnInserisciSala);
		frmCircoloCittadinoDi.getContentPane().add(btnPrenotaSala);
		frmCircoloCittadinoDi.getContentPane().add(btnPrenotaEvento);
		frmCircoloCittadinoDi.getContentPane().add(btnChiusuraAnnuale);	
		frmCircoloCittadinoDi.getContentPane().add(btnPassaggioCategoria);
		frmCircoloCittadinoDi.getContentPane().add(btnGestioneConvenzioni);	
		frmCircoloCittadinoDi.getContentPane().add(btnBefane);	
		frmCircoloCittadinoDi.getContentPane().add(btnGestionePdf);
		frmCircoloCittadinoDi.getContentPane().add(lblImg);
		
		
		
		
		
		
	}

	/**
	 * 
	 * @return frame (JFrame)
	 */
	public JFrame getFrame() {
		return frmCircoloCittadinoDi;
	}
	
	/**
	 * 
	 * @return bottone per il logout (JButton)
	 */
	public JButton getBtnLogout() {
		return btnLogout;
	}
	
	/**
	 * 
	 * @return bottone per l'inserimento del socio (Jbutton)
	 */
	public JButton getBtnInserisciSocio() {
		return btnInserisciSocio;
	}
	
	/**
	 * 
	 * @return bottone per l'inserimento del versamento (Jbutton)
	 */
	public JButton getBtnInserisciVersamento() {
		return btnInserisciVersamento;
	}
	
	/**
	 * 
	 * @return bottone per visualizzare l'elenco soci (Jbutton)
	 */
	public JButton getBtnElencoSoci() {
		return btnElencoSoci;
	}
	
	/**
	 * 
	 * @return bottone per l'inserimento dell'evento (Jbutton)
	 */
	public JButton getBtnInserisciEvento() {
		return btnInserisciEvento;
	}
	
	/**
	 * 
	 * @return bottone per la gestione dei figli (Jbutton)
	 */
	public JButton getBtnGestioneFigli() {
		return btnGestioneFigli;
	}
	
	/**
	 * 
	 * @return bottone per la gestione dei versamenti (Jbutton)
	 */
	public JButton getBtnGestioneVersamenti(){
		return btnGestioneVersamenti;
	}

	/**
	 * 
	 * @return bottone per la gestione dei  nonsocio (Jbutton)
	 */
	public JButton getBtnGestioneNonSocio() {
		return btnGestioneNonSocio;
	}

	/**
	 * 
	 * @return bottone per la gestione degli exsocio (Jbutton)
	 */
	public JButton getBtnGestioneExSocio() {
		return btnGestioneExSocio;
	}

	/**
	 * 
	 * @return bottone per l'inserimento delle quote (Jbutton)
	 */
	public JButton getBtnInserisciQuota() {
		return btnInserisciQuota;
	}

	/**
	 * 
	 * @return bottone per la visualizzazione delle quote (Jbutton)
	 */
	public JButton getBtnVisualizzazioneQuote() {
		return btnVisualizzazioneQuote;
	}
	
	/**
	 * 
	 * @return bottone per l'inserimento della sala (Jbutton)
	 */
	public JButton getBtnInserisciSala() {
		return btnInserisciSala;
	}
	
	/**
	 * 
	 * @return bottone per la prenotazione della sala (Jbutton)
	 */
	public JButton getBtnPrenotaSala() {
		return btnPrenotaSala;
	}
	
	/**
	 * 
	 * @return bottone per la prenotazione dell'evento (Jbutton)
	 */
	public JButton getBtnPrenotaEvento() {
		return btnPrenotaEvento;
	}
	
	/**
	 * 
	 * @return bottone per la gestione della chiusura annuale (Jbutton)
	 */
	public JButton getBtnChiusuraAnnuale() {
		return btnChiusuraAnnuale;
	}

	/**
	 * 
	 * @return bottone per la gestione del passaggio di categoria (Jbutton)
	 */
	public JButton getBtnPassaggioCategoria() {
		return btnPassaggioCategoria;
	}

	/**
	 * 
	 * @return bottone per la gestione delle convenzioni (Jbutton)
	 */
	public JButton getBtnGestioneConvenzioni() {
		return btnGestioneConvenzioni;
	}
	
	/**
	 * 
	 * @return bottone per la gestione dell'evento "Befane" (JButton)
	 */
	public JButton getBtnBefane() {
		return btnBefane;
	}
	
	/**
	 * 
	 * @return Bottone che porta alla creazione di PDF per Badge, Biglietti di Auguri 
	 * e liste dei soci partecipanti agli eventi
	 */
	
	public JButton getBtnGestionePdf() {
		return btnGestionePdf;
	}
	
	
}