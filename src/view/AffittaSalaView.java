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

import java.util.ArrayList;

public class AffittaSalaView {
	
	private JFrame frmCircoloCittadino;
	private JTextField txtFieldNomeSala;
	private JTextArea txtAreaDescrizione;
	private JSpinner spnCapienza;
	private JTextField txtFieldTariffa;
	private JButton btnInserisci;
	private JButton btnDashboard;
	private JButton btnModifica;
	private JButton btnCancella;
	private JButton btnSalvaModifiche;
	private JButton btnAnnullaModifiche;
	private JList<Sala> lstSale;
	private DefaultListModel<Sala> dlms;
	private ScrollPane scrollPane;
	

	
	public AffittaSalaView(ArrayList<Sala> sale, ArrayList<Socio> soci, ArrayList<NonSocio> nonsoci, ArrayList<Affitto> prenotazioni){
		frmCircoloCittadino = new JFrame("Circolo Cittadino - Prenota Sala");
		frmCircoloCittadino.setTitle("Circolo Cittadino - Prenotazione Sale");
		frmCircoloCittadino.setBounds(100, 100, 800, 600);
		frmCircoloCittadino.setResizable(false);
		frmCircoloCittadino.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCircoloCittadino.getContentPane().setLayout(null);
		dlms = new DefaultListModel<Sala>();
		sale.stream().forEach((s)->{
			dlms.addElement(s);
		});

		scrollPane = new ScrollPane();
		scrollPane.setBounds(357, 128, 177, 352);
		frmCircoloCittadino.getContentPane().add(scrollPane);
		
		JLabel lblCompilaForm = new JLabel("Inserisci i dati relativi alla sala");
		lblCompilaForm.setBounds(593, 76, 335, 16);
		frmCircoloCittadino.getContentPane().add(lblCompilaForm);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(544, 133, 97, 16);
		frmCircoloCittadino.getContentPane().add(lblNome);

		txtFieldNomeSala = new JTextField();
		txtFieldNomeSala.setColumns(10);
		txtFieldNomeSala.setBounds(636, 128, 130, 26);
		frmCircoloCittadino.getContentPane().add(txtFieldNomeSala);

		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setBounds(544, 241, 112, 16);
		frmCircoloCittadino.getContentPane().add(lblDescrizione);

		txtAreaDescrizione = new JTextArea();
		txtAreaDescrizione.setWrapStyleWord(true);
		txtAreaDescrizione.setFont(new Font("Monospaced", Font.PLAIN, 11));
		txtAreaDescrizione.setLineWrap(true);
		txtAreaDescrizione.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		txtAreaDescrizione.setBounds(636, 239, 130, 245);
		frmCircoloCittadino.getContentPane().add(txtAreaDescrizione);

		JLabel lblCapienza = new JLabel("Capienza");
		lblCapienza.setBounds(544, 170, 112, 16);
		frmCircoloCittadino.getContentPane().add(lblCapienza);

		spnCapienza = new JSpinner();
		spnCapienza.setBounds(636, 165, 130, 26);
		frmCircoloCittadino.getContentPane().add(spnCapienza);

		JLabel lblTariffa = new JLabel("Tariffa");
		lblTariffa.setBounds(544, 204, 84, 23);
		frmCircoloCittadino.getContentPane().add(lblTariffa);

		txtFieldTariffa = new JTextField();
		txtFieldTariffa.setColumns(10);
		txtFieldTariffa.setBounds(636, 202, 130, 26);
		frmCircoloCittadino.getContentPane().add(txtFieldTariffa);
		
		btnInserisci = new JButton("Inserisci");
		btnInserisci.setBounds(186, 513, 117, 29);
		frmCircoloCittadino.getContentPane().add(btnInserisci);

		btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(697, 11, 97, 41);
		frmCircoloCittadino.getContentPane().add(btnDashboard);
						
		JLabel lblElencoSale = new JLabel("Elenco Sale");
		lblElencoSale.setBounds(186, 77, 76, 14);
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
		
		lstSale = new JList<Sala>();
		lstSale.setBounds(357, 128, 177, 352);
		frmCircoloCittadino.getContentPane().add(lstSale);
		lstSale.setModel(dlms);
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
	
	public JButton getBtnModifica(){
		return btnModifica;
	}
	
	public JButton getBtnCancella(){
		return btnCancella;
	}
	
	public JButton getBtnSalvaModifiche(){
		return btnSalvaModifiche;
	}
	
	public JButton getBtnAnnullaModifiche(){
		return btnAnnullaModifiche;
	}

	public void setBtnInserisci(JButton btnInserisci) {
		this.btnInserisci = btnInserisci;
	}
	
	public JTextField getNomeSala() {
		return txtFieldNomeSala;
	}

	public JTextArea getDescrizione() {
		return txtAreaDescrizione;
	}

	public JSpinner getCapienza() {
		return spnCapienza;
	}

	public JTextField getTariffa() {
		return txtFieldTariffa;
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