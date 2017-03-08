package view;

import java.awt.Font;
import java.awt.ScrollPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import entita.Sala;
import entita.Socio;
import entita.NonSocio;
import entita.Affitto;
import entita.Evento;

import java.util.ArrayList;
import javax.swing.JRadioButton;

public class AffittaSalaView {
	
	private JFrame frmCircoloCittadino;
	private JButton btnInserisci;
	private JButton btnDashboard;
	private JButton btnModifica;
	private JButton btnCancella;
	private JButton btnSalvaModifiche;
	private JButton btnAnnullaModifiche;
	private JLabel lblElencoSale;
	private JLabel lblAft;
	private JList<Sala> lstSale;
	private JList lstAft;
	private DefaultListModel<Sala> dlms;
	private ScrollPane scrollPane;
	private ScrollPane scrollPaneAft;
	private JRadioButton rdbtnExsocio;
	private JRadioButton rdbtnNonSocio;
	private JRadioButton rdbtnSocio;
	

	
	public AffittaSalaView(ArrayList<Sala> sale, ArrayList<Socio> soci, ArrayList<NonSocio> nonsoci, ArrayList<Affitto> prenotazioni){
		frmCircoloCittadino = new JFrame("Circolo Cittadino - Prenota Sala");
		frmCircoloCittadino.setTitle("Circolo Cittadino - Prenotazione Sale");
		frmCircoloCittadino.setBounds(100, 100, 800, 600);
		frmCircoloCittadino.setResizable(false);
		frmCircoloCittadino.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCircoloCittadino.getContentPane().setLayout(null);
		
		lstSale = new JList<Sala>();
		dlms = new DefaultListModel<Sala>();
		sale.stream().forEach((s)->{
			dlms.addElement(s);
		});
		lstSale.setModel(dlms);
								
		lstAft = new JList<>();

		
		scrollPane = new ScrollPane();
		scrollPane.setBounds(425, 115, 359, 352);
		frmCircoloCittadino.getContentPane().add(scrollPane);
		scrollPane.add(lstSale);
		scrollPane.setVisible(true);
		
		scrollPaneAft = new ScrollPane();
		scrollPaneAft.setBounds(10,115, 359, 352);
		frmCircoloCittadino.getContentPane().add(scrollPaneAft);
		scrollPaneAft.add(lstAft);
		scrollPaneAft.setVisible(true);
		
		btnInserisci = new JButton("Inserisci");
		btnInserisci.setBounds(186, 513, 117, 29);
		frmCircoloCittadino.getContentPane().add(btnInserisci);

		btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(697, 11, 97, 41);
		frmCircoloCittadino.getContentPane().add(btnDashboard);
						
		lblElencoSale = new JLabel("Elenco Sale Libere");
		lblElencoSale.setBounds(524, 77, 129, 14);
		frmCircoloCittadino.getContentPane().add(lblElencoSale);
		
		btnModifica = new JButton("Modifica");
		btnModifica.setBounds(357, 513, 117, 29);
		frmCircoloCittadino.getContentPane().add(btnModifica);
		
		btnCancella = new JButton("Cancella");
		btnCancella.setBounds(524, 513, 117, 29);
		frmCircoloCittadino.getContentPane().add(btnCancella);
		
		btnSalvaModifiche = new JButton("Salva");
		btnSalvaModifiche.setBounds(357, 513, 117, 29);
		frmCircoloCittadino.getContentPane().add(btnSalvaModifiche);
		
		btnAnnullaModifiche = new JButton("Annulla");
		btnAnnullaModifiche.setBounds(524, 513, 117, 29);
		frmCircoloCittadino.getContentPane().add(btnAnnullaModifiche);
		
		rdbtnExsocio = new JRadioButton("Ex-Socio");
		rdbtnExsocio.setBounds(260, 39, 109, 23);
		frmCircoloCittadino.getContentPane().add(rdbtnExsocio);
		
		rdbtnSocio = new JRadioButton("Socio");
		rdbtnSocio.setBounds(150, 39, 109, 23);
		frmCircoloCittadino.getContentPane().add(rdbtnSocio);
		
		rdbtnNonSocio = new JRadioButton("Non Socio");
		rdbtnNonSocio.setBounds(39, 39, 109, 23);
		frmCircoloCittadino.getContentPane().add(rdbtnNonSocio);
		
		lblAft = new JLabel("Elenco Affittuari");
		lblAft.setBounds(130, 77, 129, 14);
		frmCircoloCittadino.getContentPane().add(lblAft);
	}
	
	public JButton getBtnDashboard() {
		return btnDashboard;
	}

	public JFrame getFrame() {
		return frmCircoloCittadino;
	}

	public JButton getBtnInserisci() {
		return btnInserisci;
	}
	
	public JButton getBtnModifica() {
		return btnModifica;
	}
	
	public JButton getBtnCancella() {
		return btnCancella;
	}
	
	public JButton getBtnSalvaModifiche() {
		return btnSalvaModifiche;
	}
	
	public JButton getBtnAnnullaModifiche() {
		return btnAnnullaModifiche;
	}
	
	public JRadioButton getRdbtnExsocio() {
		return rdbtnExsocio;
	}
	
	public JRadioButton getRdbtnNonSocio() {
		return rdbtnNonSocio;
	}
	
	public JRadioButton getRbtnSocio() {
		return rdbtnSocio;
	}

	public void setBtnInserisci(JButton btnInserisci) {
		this.btnInserisci = btnInserisci;
	}

	public void setFrame(JFrame frame) {
		this.frmCircoloCittadino = frame;
	}
	
	public void setList(JList<Sala> list) {
		this.lstSale = list;
	}
	
	public JList<Sala> getList() {
		return lstSale;
	}
}