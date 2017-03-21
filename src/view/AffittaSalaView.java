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
import entita.Socio;

import java.util.ArrayList;
import javax.swing.JRadioButton;

public class AffittaSalaView {
	
	private JFrame frmCircoloCittadino;
	private JButton btnInserisci;
	private JButton btnDashboard;
	private JButton btnCancella;
	private JLabel lblElencoSale;
	private JLabel lblAft;
	private JLabel lblElencoPrenotazioni;
	private JList<Sala> lstSale;
	private JList lstAft;
	private JList<Affitto> lst;
	private DefaultListModel<Sala> dlms;
	private DefaultListModel<Affitto> dlma;
	private DefaultListModel<Socio> dlm;
	private ScrollPane scrollPane;
	private ScrollPane scrollPaneAft;
	private ScrollPane scrollPaneSal;
	private JRadioButton rdbtnNonSocio;
	private JRadioButton rdbtnSocio;
	private ButtonGroup tipo;
	

	
	public AffittaSalaView(ArrayList<Sala> sale, ArrayList<Socio> affittuari, ArrayList<Affitto> prenotazioni) {
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
								
		lstAft = new JList<Socio>();
		dlm = new DefaultListModel<Socio>();
		affittuari.stream().forEach((p)->{
			dlm.addElement(p);
		});
		
		lst = new JList<Affitto>();
		dlma = new DefaultListModel<Affitto>();
		prenotazioni.stream().forEach((a)->{
			dlma.addElement(a);
		});
		
		scrollPaneSal = new ScrollPane();
		scrollPaneSal.setBounds(261, 115, 245, 375);
		frmCircoloCittadino.getContentPane().add(scrollPaneSal);
		scrollPaneSal.add(lstSale);
		scrollPaneSal.setVisible(true);
	
		scrollPaneAft = new ScrollPane();
		scrollPaneAft.setBounds(10,115, 245, 375);
		frmCircoloCittadino.getContentPane().add(scrollPaneAft);
		scrollPaneAft.add(lstAft);
		scrollPaneAft.setVisible(true);
		
		scrollPane = new ScrollPane();
		scrollPane.setBounds(539,115, 245, 375);
		frmCircoloCittadino.getContentPane().add(scrollPane);
		scrollPane.add(lst);
		scrollPane.setVisible(true);
		
		btnInserisci = new JButton("Inserisci");
		btnInserisci.setBounds(199, 513, 117, 29);
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
	
	public void setList(JList<Sala> list) {
		this.lstSale = list;
	}
	
	public JList<Sala> getListSala() {
		return lstSale;
	}
	
	public JList getListAffittuari() {
		return lstAft;
	}
	
	public JList<Affitto> getList() {
		return lst;
	}
}