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
		btnInserisciEvento.setBounds(199, 214, 152, 29);
		
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
		btnPrenotaSala.setBounds(199, 288, 152, 29);
		
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
		return btnInserisciSala;
	}
}
