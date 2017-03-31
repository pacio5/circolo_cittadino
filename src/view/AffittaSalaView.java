package view;

import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import entita.Sala;
import entita.Affitto;
import entita.NonSocio;
import entita.Socio;

import java.util.ArrayList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * @author simoneonori
 * @author eliapacioni
 * @author smerilliriccardo
 * @author francescotalento
 * @version 1.0 marzo 2017
 * Classe AffittaSalaView, si occupa di visualizzare la finestra di gestione dell'affitto delle sale, 
 * da dove è possibile accedere a tutte le varie funzioni
 */
public class AffittaSalaView {
	
	private JFrame frmCircoloCittadino;
	private JButton btnInserisci;
	private JButton btnDashboard;
	private JButton btnCancella;
	private JLabel lblElencoSale;
	private JLabel lblAft;
	private JLabel lblElencoPrenotazioni;
	private JList<Sala> lstSale;
	private JList<Socio> lstS;
	private JList<NonSocio> lstNS;
	private JList<Affitto> lst;
	private DefaultListModel<Affitto> dlma;
	private DefaultListModel<Socio> dlm;
	private DefaultListModel<NonSocio> dlmns;
	private ScrollPane scrollPane;
	private ScrollPane scrollPaneS;
	private ScrollPane scrollPaneNS;
	private ScrollPane scrollPaneSal;
	private JRadioButton rdbtnNonSocio;
	private JRadioButton rdbtnSocio;
	private ButtonGroup tipo;
	private JTextField textFieldData;
	private JButton btnInfo;
	private JButton btnLstSale;
	

	/**
	 * Costruttore AffittaSalaView, si occupa di visualizzare la finestra di gestione degli affitti delle sale
	 * e inizializza tutte le proprietà
	 * @param soci oggetto di tipo ArrayList<Socio> contenente tutti i soci
	 * @param nsoci oggetto di tipo ArrayList<NonSocio> contenente tutti i non soci
	 * @param prenotazioni oggetto di tipo ArrayList<Affitto> contenente tutti gli affitti relativi alle sale
	 */
	public AffittaSalaView(ArrayList<Socio> soci, ArrayList<NonSocio> nsoci, ArrayList<Affitto> prenotazioni) {
		frmCircoloCittadino = new JFrame("Circolo Cittadino - Prenota Sala");
		frmCircoloCittadino.setTitle("Circolo Cittadino - Prenotazione Sale");
		frmCircoloCittadino.setBounds(100, 100, 800, 600);
		frmCircoloCittadino.setResizable(false);
		frmCircoloCittadino.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCircoloCittadino.getContentPane().setLayout(null);
		
		lstSale = new JList<Sala>();
								
		lstS = new JList<Socio>();
		dlm = new DefaultListModel<Socio>();
		soci.stream().forEach((p)->{
			dlm.addElement(p);
		});
		lstS.setModel(dlm);
		
		lstNS = new JList<NonSocio>();
		dlmns = new DefaultListModel<NonSocio>();
		nsoci.stream().forEach((p)->{
			dlmns.addElement(p);
		});
		lstNS.setModel(dlmns);
		
		lst = new JList<Affitto>();
		dlma = new DefaultListModel<Affitto>();
		prenotazioni.stream().forEach((a)->{
			dlma.addElement(a);
		});
		lst.setModel(dlma);
		
		scrollPaneSal = new ScrollPane();
		scrollPaneSal.setBounds(261, 103, 245, 375);
		frmCircoloCittadino.getContentPane().add(scrollPaneSal);
		scrollPaneSal.add(lstSale);
		scrollPaneSal.setVisible(true);
	
		scrollPaneS = new ScrollPane();
		scrollPaneS.setBounds(10,103, 245, 375);
		frmCircoloCittadino.getContentPane().add(scrollPaneS);
		scrollPaneS.add(lstS);
		scrollPaneS.setVisible(true);
		
		scrollPaneNS = new ScrollPane();
		scrollPaneNS.setBounds(10,103, 245, 375);
		frmCircoloCittadino.getContentPane().add(scrollPaneNS);
		scrollPaneNS.add(lstNS);
		scrollPaneNS.setVisible(false);
		
		scrollPane = new ScrollPane();
		scrollPane.setBounds(539,103, 245, 375);
		frmCircoloCittadino.getContentPane().add(scrollPane);
		scrollPane.add(lst);
		scrollPane.setVisible(true);
		
		btnInserisci = new JButton("Inserisci");
		btnInserisci.setBounds(198, 513, 117, 29);
		frmCircoloCittadino.getContentPane().add(btnInserisci);

		btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(697, 11, 97, 41);
		frmCircoloCittadino.getContentPane().add(btnDashboard);
						
		lblElencoSale = new JLabel("Elenco Sale Libere");
		lblElencoSale.setBounds(329, 77, 129, 14);
		frmCircoloCittadino.getContentPane().add(lblElencoSale);
		
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
		
		lblAft = new JLabel("Elenco Affittuari");
		lblAft.setBounds(87, 77, 129, 14);
		frmCircoloCittadino.getContentPane().add(lblAft);
		
		lblElencoPrenotazioni = new JLabel("Elenco Prenotazioni");
		lblElencoPrenotazioni.setBounds(607, 77, 129, 14);
		frmCircoloCittadino.getContentPane().add(lblElencoPrenotazioni);
		
		textFieldData = new JTextField();
		textFieldData.setBounds(138, 484, 117, 20);
		frmCircoloCittadino.getContentPane().add(textFieldData);
		textFieldData.setColumns(10);
		
		JLabel lblDataPrenotazione = new JLabel("Data Prenotazione");
		lblDataPrenotazione.setBounds(10, 487, 153, 14);
		frmCircoloCittadino.getContentPane().add(lblDataPrenotazione);
		
		btnInfo = new JButton("Informazioni");
		btnInfo.setBounds(325, 513, 117, 29);
		frmCircoloCittadino.getContentPane().add(btnInfo);
		
		btnLstSale = new JButton("Visualizza Sale");
		btnLstSale.setBounds(59, 513, 129, 29);
		btnLstSale.setVisible(false);
		frmCircoloCittadino.getContentPane().add(btnLstSale);
	}
	
	/**
	 * @return data di prenotazione della sala (JTextField)
	 */
	public JTextField getData() {
		return textFieldData;
	}
	
	/**
	 * @return Bottone per visualizzare le informazioni di una sala (JButton)
	 */
	public JButton getBtnInfo() {
		return btnInfo;
	}
	
	
	/**
	 * @return Bottone per visualizzare le sale (JButton)
	 */
	public JButton getBtnVisualizzaSale() {
		return btnLstSale;
	}
	
	
	/**
	 * @return Bottone per tornare alla dashboard (JButton)
	 */
	public JButton getBtnDashboard() {
		return btnDashboard;
	}
	
	/**
	 * @return frame (JFrame)
	 */
	public JFrame getFrame() {
		return frmCircoloCittadino;
	}

	
	/**
	 * @return Bottone per inserire una prenotazione di una sala (JButton)
	 */
	public JButton getBtnInserisci() {
		return btnInserisci;
	}
	
	/**
	 * @return Bottone per cancellare una prenotazione di una sala (JButton)
	 */
	public JButton getBtnCancella() {
		return btnCancella;
	}
		
	/**
	 * @return radio button non socio (JRadioButton)
	 */
	public JRadioButton getRdbtnNonSocio() {
		return rdbtnNonSocio;
	}
	
	/**
	 * @return radio button socio (JRadioButton)
	 */
	public JRadioButton getRbtnSocio() {
		return rdbtnSocio;
	}
	
	/**
	 * @return Gruppo di Bottoni per la selezione tra socio e non socio (ButtonGroup)
	 */
	public ButtonGroup getTipo() {
		return tipo;
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
	
	/**
	 * @return lista contentente le sale (JList)
	 */
	public JList<Sala> getListSala() {
		return lstSale;
	}
	
	/**
	 * @return lista contentente i soci (JList)
	 */
	public JList<Socio> getListSoci() {
		return lstS;
	}
	
	/**
	 * @return lista contentente i non soci (JList)
	 */
	public JList<NonSocio> getListNonSoci() {
		return lstNS;
	}
	
	/**
	 * @return lista contentente gli affitti (JList)
	 */
	public JList<Affitto> getList() {
		return lst;
	}
	
	/**
	 * @return ScrollPane della lista dei soci (ScrollPane)
	 */
	public ScrollPane getPaneSoci() {
		return scrollPaneS;
	}
	
	/**
	 * @return ScrollPane della lista dei non soci (ScrollPane)
	 */
	public ScrollPane getPaneNonSoci() {
		return scrollPaneNS;
	}
}