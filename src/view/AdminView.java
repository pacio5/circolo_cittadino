package view;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class AdminView {

	private JFrame frame;
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

	/**
	 * Create the frame.
	 */
	public AdminView() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnLogout = new JButton("Logout");
		btnLogout.setBounds(677, 6, 117, 29);
		
		btnInserisciSocio = new JButton("Inserisci Socio");
		btnInserisciSocio.setBounds(24, 50, 152, 29);
		
		btnInserisciVersamento = new JButton("Inserisci Versamento");
		btnInserisciVersamento.setBounds(199, 50, 152, 29);
		
		btnInserisciEvento = new JButton("Inserisci Evento");
		btnInserisciEvento.setBounds(24, 254, 152, 29);
		
		JLabel lblCircoloCittadinoDi = new JLabel("Circolo Cittadino di Ascoli Piceno");
		lblCircoloCittadinoDi.setBounds(266, 11, 211, 16);

		btnElencoSoci = new JButton("Elenco Soci");
		btnElencoSoci.setBounds(24, 91, 152, 29);
		
		btnGestioneFigli = new JButton("Gestione Figli");
		btnGestioneFigli.setBounds(24, 132, 152, 29);
		
		btnGestioneVersamenti = new JButton("Gestione Versamenti");
		btnGestioneVersamenti.setBounds(199, 90, 152, 29);
		
		btnGestioneNonSocio = new JButton("Gestione Non Socio");
		btnGestioneNonSocio.setBounds(24, 173, 152, 29);
		
		btnGestioneExSocio = new JButton("Gestione Ex Socio");
		btnGestioneExSocio.setBounds(24, 214, 152, 29);
		
		btnInserisciQuota = new JButton("Inserimento Quota");
		btnInserisciQuota.setBounds(199, 132, 152, 29);
		
		btnVisualizzazioneQuote = new JButton("Visualizzazione Quote");
		btnVisualizzazioneQuote.setBounds(199, 172, 152, 29);
		
		btnInserisciSala = new JButton("Inserisci Sala");
		btnInserisciSala.setBounds(199, 254, 152, 29);
		
		btnPrenotaSala = new JButton("Prenota Sala");
		btnPrenotaSala.setBounds(199, 294, 152, 29);
		
		btnPrenotaEvento = new JButton("Prenota Evento");
		btnPrenotaEvento.setBounds(24, 294, 152, 29);
		
		btnChiusuraAnnuale = new JButton("Chiusura annuale");
		btnChiusuraAnnuale.setBounds(199, 214, 152, 29);
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnLogout);
		frame.getContentPane().add(btnInserisciSocio);
		frame.getContentPane().add(btnInserisciVersamento);
		frame.getContentPane().add(btnInserisciEvento);
		frame.getContentPane().add(lblCircoloCittadinoDi);
		frame.getContentPane().add(btnElencoSoci);
		frame.getContentPane().add(btnGestioneFigli);
		frame.getContentPane().add(btnGestioneVersamenti);
		frame.getContentPane().add(btnGestioneNonSocio);
		frame.getContentPane().add(btnGestioneExSocio);
		frame.getContentPane().add(btnInserisciQuota);
		frame.getContentPane().add(btnVisualizzazioneQuote);
		frame.getContentPane().add(btnInserisciSala);
		frame.getContentPane().add(btnPrenotaSala);
		frame.getContentPane().add(btnPrenotaEvento);
		frame.getContentPane().add(btnChiusuraAnnuale);
		
		btnPassaggioCategoria = new JButton("Passaggio Categoria");
		btnPassaggioCategoria.setBounds(363, 50, 152, 29);
		frame.getContentPane().add(btnPassaggioCategoria);
		
		btnGestioneConvenzioni = new JButton("Gestione Convenzioni");
		btnGestioneConvenzioni.setBounds(363, 91, 152, 29);
		frame.getContentPane().add(btnGestioneConvenzioni);
		
		
	}

	public JFrame getFrame() {
		return frame;
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
}