package view;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

import entita.Evento;
import entita.Prenotazione;

import java.awt.ScrollPane;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JSpinner;

public class PrenotaEventoView {

	private JFrame frmCircoloCittadino;
	private JButton btnDashboard;
	private JButton btnInserisci;
	private JButton btnCancella;
	private JLabel lblElencoEventi;
	private JLabel lblElencoPersone;
	private JLabel lblElencoPrenotazioni;
	private JLabel lblNumeroBiglietti;
	private JLabel lblData;
	private JSpinner SpNumeroBiglietti;
	private JList<Evento> lstEvt;
	private JList lstPrs;
	private JList<Prenotazione> lstPrenotazioni;
	private DefaultListModel<Evento> dlme;
	private DefaultListModel<Prenotazione> dlmp;
	private DefaultListModel dlm;
	private ScrollPane scrollPane;
	private ScrollPane scrollPanePrs;
	private ScrollPane scrollPaneEvt;
	private JRadioButton rdbtnNonSocio;
	private JRadioButton rdbtnSocio;
	private ButtonGroup tipo;
	private JTextField textFieldData;
	
	

	/**
	 * Create the frame.
	 */
	public PrenotaEventoView(ArrayList<Evento> eventi, ArrayList<Prenotazione> prenotazioni) {
		frmCircoloCittadino = new JFrame("Circolo Cittadino - Prenota Sala");
		frmCircoloCittadino.setTitle("Circolo Cittadino - Prenotazione Sale");
		frmCircoloCittadino.setBounds(100, 100, 800, 600);
		frmCircoloCittadino.setResizable(false);
		frmCircoloCittadino.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCircoloCittadino.getContentPane().setLayout(null);
		
		btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(697, 11, 97, 41);
		frmCircoloCittadino.getContentPane().add(btnDashboard);
		
		lstEvt = new JList<Evento>();
		dlme = new DefaultListModel<Evento>();
		eventi.stream().forEach((e)->{
			dlme.addElement(e);
		});
		lstEvt.setModel(dlme);
								
		lstPrs = new JList<>();
		dlm = new DefaultListModel<>();
		//affittuari.stream().forEach((o)->{
			//dlm.addElement(o);
		//});
		
		lstPrenotazioni = new JList<Prenotazione>();
		dlmp = new DefaultListModel<Prenotazione>();
		prenotazioni.stream().forEach((p)->{
			dlmp.addElement(p);
		});
		
		scrollPaneEvt = new ScrollPane();
		scrollPaneEvt.setBounds(10, 115, 245, 329);
		frmCircoloCittadino.getContentPane().add(scrollPaneEvt);
		scrollPaneEvt.add(lstEvt);
		scrollPaneEvt.setVisible(true);
	
		scrollPanePrs = new ScrollPane();
		scrollPanePrs.setBounds(261,115, 245, 329);
		frmCircoloCittadino.getContentPane().add(scrollPanePrs);
		scrollPanePrs.add(lstPrs);
		scrollPanePrs.setVisible(true);
		
		scrollPane = new ScrollPane();
		scrollPane.setBounds(539,115, 245, 375);
		frmCircoloCittadino.getContentPane().add(scrollPane);
		scrollPane.add(lstPrenotazioni);
		scrollPane.setVisible(true);
		
		btnInserisci = new JButton("Inserisci");
		btnInserisci.setBounds(199, 513, 117, 29);
		frmCircoloCittadino.getContentPane().add(btnInserisci);
						
		lblElencoEventi = new JLabel("Elenco Eventi");
		lblElencoEventi.setBounds(89, 77, 129, 14);
		frmCircoloCittadino.getContentPane().add(lblElencoEventi);
		
		btnCancella = new JButton("Cancella");
		btnCancella.setBounds(607, 513, 117, 29);
		frmCircoloCittadino.getContentPane().add(btnCancella);
		
		rdbtnSocio = new JRadioButton("Socio");
		rdbtnSocio.setBounds(150, 39, 109, 23);
		rdbtnSocio.setSelected(true);
		frmCircoloCittadino.getContentPane().add(rdbtnSocio);
	
		rdbtnNonSocio = new JRadioButton("Non Socio");
		rdbtnNonSocio.setBounds(39, 39, 109, 23);
		frmCircoloCittadino.getContentPane().add(rdbtnNonSocio);
		
		tipo = new ButtonGroup();
		tipo.add(rdbtnSocio);
		tipo.add(rdbtnNonSocio);
		
		lblElencoPersone = new JLabel("Elenco Persone");
		lblElencoPersone.setBounds(324, 77, 129, 14);
		frmCircoloCittadino.getContentPane().add(lblElencoPersone);
		
		lblElencoPrenotazioni = new JLabel("Elenco Prenotazioni");
		lblElencoPrenotazioni.setBounds(607, 77, 129, 14);
		frmCircoloCittadino.getContentPane().add(lblElencoPrenotazioni);
		
		textFieldData = new JTextField();
		textFieldData.setBounds(126, 462, 129, 20);
		frmCircoloCittadino.getContentPane().add(textFieldData);
		textFieldData.setColumns(10);
		
		SpNumeroBiglietti = new JSpinner();
		SpNumeroBiglietti.setBounds(409, 462, 97, 20);
		frmCircoloCittadino.getContentPane().add(SpNumeroBiglietti);
		
		lblData = new JLabel("Data Acquisto");
		lblData.setBounds(42, 465, 106, 14);
		frmCircoloCittadino.getContentPane().add(lblData);
		
		lblNumeroBiglietti = new JLabel("Numero Biglietti");
		lblNumeroBiglietti.setBounds(324, 465, 106, 14);
		frmCircoloCittadino.getContentPane().add(lblNumeroBiglietti);
	}
		
	public JFrame getFrame() {
		return frmCircoloCittadino;
	}
	
	public JButton getBtnDashboard() {
		return btnDashboard;
	}
	
	public JButton getBtnInserisci() {
		return btnInserisci;
	}
	
	public JButton getBtnCancella() {
		return btnCancella;
	}
		
	public JRadioButton getRdbtnNonSocio() {
		return rdbtnNonSocio;
	}
	
	public JRadioButton getRbtnSocio() {
		return rdbtnSocio;
	}
	
	public ButtonGroup getTipo() {
		return tipo;
	}

	public void setBtnInserisci(JButton btnInserisci) {
		this.btnInserisci = btnInserisci;
	}

	public void setFrame(JFrame frame) {
		this.frmCircoloCittadino = frame;
	}
	
	public void setListEvento(JList<Evento> list) {
		this.lstEvt = list;
	}
	
	public JList getListPrenotazioni() {
		return lstPrenotazioni;
	}
	
	public JList getListPrs() {
		return lstPrs;
	}
	
}
