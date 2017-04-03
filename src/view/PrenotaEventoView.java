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
import entita.Socio;
import entita.NonSocio;

import java.awt.ScrollPane;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 * @author simoneonori
 *
 */
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
	private JList<Socio> lstSocio;
	private JList<NonSocio> lstNonSocio;
	private JList<Prenotazione> lstPrenotazioni;
	private DefaultListModel<Evento> dlme;
	private DefaultListModel<Prenotazione> dlmp;
	private DefaultListModel<Socio> dlms;
	private DefaultListModel<NonSocio> dlmns;
	private ScrollPane scrollPane;
	private ScrollPane scrollPaneS;
	private ScrollPane scrollPaneNS;
	private ScrollPane scrollPaneEvt;
	private JRadioButton rdbtnNonSocio;
	private JRadioButton rdbtnSocio;
	private ButtonGroup tipo;
	private JTextField textFieldData;
	private JButton btnInfo;
	private JTextField txtBigliettiDisponibili;
	
	

	/**
	 * Costruttore PrenotaEventoView, si occupa di visualizzare la finestra di gestione delle prenotazioni agli eventi
	 * e inizializza tutte le proprietà
	 * @param eventi oggetto di tipo ArrayList<Evento> contenente tutti gli eventi
	 * @param prenotazioni oggetto di tipo ArrayList<Prenotazione> contenente le prenotazioni relative agli eventi
	 * @param affittuariS oggetto di tipo ArrayList<Socio> contenente tutti i soci
	 * @param affittuariNS oggetto di tipo ArrayList<NonSocio> contenente tutti i non soci
	 */
	public PrenotaEventoView(ArrayList<Evento> eventi, ArrayList<Prenotazione> prenotazioni, ArrayList<Socio> affittuariS, ArrayList<NonSocio> affittuariNS) {
		frmCircoloCittadino = new JFrame("Circolo Cittadino - Prenota Evento");
		frmCircoloCittadino.setTitle("Circolo Cittadino - Prenotazione Eventi");
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
			
		lstSocio = new JList<Socio>();
		dlms = new DefaultListModel<Socio>();
		affittuariS.stream().forEach((s)->{
			dlms.addElement(s);
		});
		lstSocio.setModel(dlms);
		
		lstNonSocio = new JList<NonSocio>();
		dlmns = new DefaultListModel<NonSocio>();
		affittuariNS.stream().forEach((ns)->{
			dlmns.addElement(ns);
		});
		lstNonSocio.setModel(dlmns);
		
		lstPrenotazioni = new JList<Prenotazione>();
		dlmp = new DefaultListModel<Prenotazione>();
		prenotazioni.stream().forEach((p)->{
			dlmp.addElement(p);
		});
		lstPrenotazioni.setModel(dlmp);
		
		scrollPaneEvt = new ScrollPane();
		scrollPaneEvt.setBounds(10, 115, 245, 329);
		frmCircoloCittadino.getContentPane().add(scrollPaneEvt);
		scrollPaneEvt.add(lstEvt);
		scrollPaneEvt.setVisible(true);
	
		scrollPaneS = new ScrollPane();
		scrollPaneS.setBounds(261,115, 245, 329);
		frmCircoloCittadino.getContentPane().add(scrollPaneS);
		scrollPaneS.add(lstSocio);
		scrollPaneS.setVisible(true);
		
		scrollPaneNS = new ScrollPane();
		scrollPaneNS.setBounds(261,115, 245, 329);
		frmCircoloCittadino.getContentPane().add(scrollPaneNS);
		scrollPaneNS.add(lstNonSocio);
		scrollPaneNS.setVisible(false);
		
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
		textFieldData.setBounds(126, 450, 129, 20);
		frmCircoloCittadino.getContentPane().add(textFieldData);
		textFieldData.setColumns(10);
		
		SpNumeroBiglietti = new JSpinner();
		SpNumeroBiglietti.setModel(new SpinnerNumberModel(0, 0, null, 1));
		SpNumeroBiglietti.setBounds(409, 450, 97, 20);
		frmCircoloCittadino.getContentPane().add(SpNumeroBiglietti);
		
		lblData = new JLabel("Data Acquisto");
		lblData.setBounds(39, 453, 106, 14);
		frmCircoloCittadino.getContentPane().add(lblData);
		
		lblNumeroBiglietti = new JLabel("Numero Biglietti");
		lblNumeroBiglietti.setBounds(302, 453, 106, 14);
		frmCircoloCittadino.getContentPane().add(lblNumeroBiglietti);
		
		btnInfo = new JButton("Informazioni");
		btnInfo.setBounds(39, 513, 117, 29);
		frmCircoloCittadino.getContentPane().add(btnInfo);
		
		JLabel lblBigliettiDisponibili = new JLabel("Biglietti Disponibili");
		lblBigliettiDisponibili.setBounds(302, 486, 129, 14);
		frmCircoloCittadino.getContentPane().add(lblBigliettiDisponibili);
		
		txtBigliettiDisponibili = new JTextField();
		txtBigliettiDisponibili.setEditable(false);
		txtBigliettiDisponibili.setBounds(432, 481, 74, 20);
		frmCircoloCittadino.getContentPane().add(txtBigliettiDisponibili);
	}
		
	/**
	 * @return txtBigliettiDisponibili (JTextField)
	 */
	public JTextField getTxtBigliettiDisponibili() {
		return txtBigliettiDisponibili;
	}
 
	/**
	 * @return frame (JFrame)
	 */
	public JFrame getFrame() {
		return frmCircoloCittadino;
	}
	
	
	/**
	 * @return Bottone per tornare alla dashboard (JButton)
	 */
	public JButton getBtnDashboard() {
		return btnDashboard;
	}
	
	/**
	 * @return Bottone per avere informazioni relative all'evento (JButton)
	 */
	public JButton getBtnInfo() {
		return btnInfo;
	}
	
	/**
	 * @return Bottone per inserire una prenotazione (JButton)
	 */
	public JButton getBtnInserisci() {
		return btnInserisci;
	}
	
	/**
	 * @return Bottone per cancellare una prenotazione (JButton)
	 */
	public JButton getBtnCancella() {
		return btnCancella;
	}
		
	/**
	 * @return rdbtnNonSocio (JRadioButton)
	 */
	public JRadioButton getRdbtnNonSocio() {
		return rdbtnNonSocio;
	}
	
	/**
	 * @return rdbtnSocio (JRadioButton)
	 */
	public JRadioButton getRbtnSocio() {
		return rdbtnSocio;
	}
	
	/**
	 * @return tipo (ButtonGroup)
	 */
	public ButtonGroup getTipo() {
		return tipo;
	}
	
	/**
	 * @return textFieldData (JTextField)
	 */
	public JTextField getData(){
		return textFieldData;
	}

	/**
	 * @return SpNumeroBiglietti (JSpinner)
	 */
	public JSpinner getNumBiglietti(){
		return SpNumeroBiglietti;
	}

	public void setFrame(JFrame frame) {
		this.frmCircoloCittadino = frame;
	}
	
	public void setListPrenotazioni(JList<Prenotazione> list) {
		this.lstPrenotazioni = list;
	}
	
	/**
	 * @return lstPrenotazioni contentente le prenotazioni (JList)
	 */
	public JList<Prenotazione> getListPrenotazioni() {
		return lstPrenotazioni;
	}
	
	public void setListEvento(JList<Evento> list) {
		this.lstEvt = list;
	}
	
	/**
	 * @return lstEvt contentente gli eventi (JList)
	 */
	public JList<Evento> getListEventi() {
		return lstEvt;
	}
	
	/**
	 * @return lstSocio contentente i soci (JList)
	 */
	public JList<Socio> getListSoci() {
		return lstSocio;
	}
	
	public void setListSoci(JList<Socio> list) {
		this.lstSocio = list;
	}
	
	/**
	 * @return lstNonSocio contentente i non soci (JList)
	 */
	public JList<NonSocio> getListNonSoci() {
		return lstNonSocio;
	}
	
	public void setListNonSoci(JList<NonSocio> list) {
		this.lstNonSocio = list;
	}
	
	/**
	 * @return scrollPaneS (ScrollPane)
	 */
	public ScrollPane getPaneSoci() {
		return scrollPaneS;
	}
	
	/**
	 * @return scrollPaneNS (ScrollPane)
	 */
	public ScrollPane getPaneNonSoci() {
		return scrollPaneNS;
	}
}
