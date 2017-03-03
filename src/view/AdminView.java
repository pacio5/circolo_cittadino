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
		btnInserisciEvento.setBounds(199, 132, 152, 29);
		
		JLabel lblCircoloCittadinoDi = new JLabel("Circolo Cittadino di Ascoli Piceno");
		lblCircoloCittadinoDi.setBounds(266, 11, 211, 16);

		btnElencoSoci = new JButton("Elenco Soci");
		btnElencoSoci.setBounds(24, 91, 152, 29);
		
		btnGestioneFigli = new JButton("Gestione Figli");
		btnGestioneFigli.setBounds(24, 132, 152, 29);
		
		btnGestioneVersamenti = new JButton("Gestione Versamenti");
		btnGestioneVersamenti.setBounds(199, 90, 152, 29);
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnLogout);
		frame.getContentPane().add(btnInserisciSocio);
		frame.getContentPane().add(btnInserisciVersamento);
		frame.getContentPane().add(btnInserisciEvento);
		frame.getContentPane().add(lblCircoloCittadinoDi);
		frame.getContentPane().add(btnElencoSoci);
		frame.getContentPane().add(btnGestioneFigli);
		frame.getContentPane().add(btnGestioneVersamenti);
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
}
