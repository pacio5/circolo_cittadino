package view;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

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
	private ImageIcon icon;
	

	/**
	 * Create the frame.
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
		
		icon = new ImageIcon("circolo.png");
		JLabel lblImg = new JLabel(new ImageIcon(".\\resources\\circolo.png"));
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
		frmCircoloCittadinoDi.getContentPane().add(btnGestioneBadge);	
		frmCircoloCittadinoDi.getContentPane().add(btnStampaBigliettoAuguri);
		frmCircoloCittadinoDi.getContentPane().add(lblImg);
		
		
		
	}

	public JFrame getFrame() {
		return frmCircoloCittadinoDi;
	}
	
	public JButton getBtnLogout() {
		return btnLogout;
	}
	
	public JButton getBtnInserisciSocio() {
		return btnInserisciSocio;
	}
	
	public JButton getBtnInserisciVersamento() {
		return btnInserisciVersamento;
	}
	
	public JButton getBtnElencoSoci() {
		return btnElencoSoci;
	}
	
	public JButton getBtnInserisciEvento() {
		return btnInserisciEvento;
	}
	
	public JButton getBtnGestioneFigli() {
		return btnGestioneFigli;
	}
	
	public JButton getBtnGestioneVersamenti(){
		return btnGestioneVersamenti;
	}

	public JButton getBtnGestioneNonSocio() {
		return btnGestioneNonSocio;
	}

	public JButton getBtnGestioneExSocio() {
		return btnGestioneExSocio;
	}

	public JButton getBtnInserisciQuota() {
		return btnInserisciQuota;
	}

	public JButton getBtnVisualizzazioneQuote() {
		return btnVisualizzazioneQuote;
	}
	
	public JButton getBtnInserisciSala() {
		return btnInserisciSala;
	}
	
	public JButton getBtnPrenotaSala() {
		return btnPrenotaSala;
	}
	
	public JButton getBtnPrenotaEvento() {
		return btnPrenotaEvento;
	}
	
	public JButton getBtnChiusuraAnnuale() {
		return btnChiusuraAnnuale;
	}

	public JButton getBtnPassaggioCategoria() {
		return btnPassaggioCategoria;
	}

	public JButton getBtnGestioneConvenzioni() {
		return btnGestioneConvenzioni;
	}
	
	public JButton getBtnBefane() {
		return btnBefane;
	}

	public JButton getBtnGestioneBadge() {
		return btnGestioneBadge;
	}

	public JButton getBtnStampaBiglietto() {
		return btnStampaBigliettoAuguri;
	}
	
	
	
	
}