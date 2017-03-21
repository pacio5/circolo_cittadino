package view;

import java.awt.EventQueue;
import java.awt.ScrollPane;

import entita.Convenzione;
import entita.Sala;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestioneConvenzioniView {

	private JFrame frameCircoloCittadino;
	private JLabel lblCompilaForm;
	private JTextField textFieldId;
	private JTextField textFieldIndirizzo;
	private JTextArea textAreaDescrizione;
	private JComboBox comboBoxRagione_sociale;
	private JSpinner spinnerSconto;
	private JButton btnInserisci;
	private JButton btnDashboard;
	private JButton btnModifica;
	private JButton btnCancella;
	private JButton btnSalvaModifiche;
	private JButton btnAnnullaModifiche;
	private JList<Sala> lstConvenzioni;
	private DefaultListModel<Convenzione> dlms;
	private ScrollPane scrollPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestioneConvenzioniView window = new GestioneConvenzioniView();
					window.frameCircoloCittadino.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GestioneConvenzioniView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameCircoloCittadino = new JFrame();
		frameCircoloCittadino.setResizable(false);
		frameCircoloCittadino.setTitle("Circolo Cittadino - Gestisci Convenzioni");
		frameCircoloCittadino.setBounds(100, 100, 844, 629);
		frameCircoloCittadino.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCircoloCittadino.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 128, 408, 356);
		frameCircoloCittadino.getContentPane().add(scrollPane);
		
		JList listConvenzioni = new JList();
		scrollPane.setViewportView(listConvenzioni);
		
		JLabel lblElencoConvenzioni = new JLabel("Elenco Convenzioni");
		lblElencoConvenzioni.setBounds(170, 81, 128, 14);
		frameCircoloCittadino.getContentPane().add(lblElencoConvenzioni);
		
		lblCompilaForm = new JLabel("Inserisci i dati relativi alla convenzione");
		lblCompilaForm.setBounds(525, 92, 229, 14);
		frameCircoloCittadino.getContentPane().add(lblCompilaForm);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(491, 130, 46, 14);
		frameCircoloCittadino.getContentPane().add(lblId);
		
		JLabel lblIndirizzo = new JLabel("Indirizzo:");
		lblIndirizzo.setBounds(491, 197, 46, 17);
		frameCircoloCittadino.getContentPane().add(lblIndirizzo);
		
		JLabel lblRagioneSociale = new JLabel("Ragione Sociale:");
		lblRagioneSociale.setBounds(491, 167, 91, 14);
		frameCircoloCittadino.getContentPane().add(lblRagioneSociale);
		
		JComboBox comboBoxRagione_sociale = new JComboBox();
		comboBoxRagione_sociale.setModel(new DefaultComboBoxModel(new String[] {"S.s.", "S.n.c.", "S.a.s.", "S.r.l.", "S.p.a.", "S.a.p.a."}));
		comboBoxRagione_sociale.setBounds(594, 164, 137, 20);
		frameCircoloCittadino.getContentPane().add(comboBoxRagione_sociale);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(594, 127, 137, 17);
		frameCircoloCittadino.getContentPane().add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldIndirizzo = new JTextField();
		textFieldIndirizzo.setBounds(594, 195, 137, 20);
		frameCircoloCittadino.getContentPane().add(textFieldIndirizzo);
		textFieldIndirizzo.setColumns(10);
		
		JLabel lblDescrizione = new JLabel("Descrizione:");
		lblDescrizione.setBounds(491, 231, 91, 14);
		frameCircoloCittadino.getContentPane().add(lblDescrizione);
		
		JLabel lblSconto = new JLabel("Sconto:");
		lblSconto.setBounds(491, 470, 46, 14);
		frameCircoloCittadino.getContentPane().add(lblSconto);
		
		JTextArea textAreaDescrizione = new JTextArea();
		textAreaDescrizione.setBounds(594, 231, 137, 214);
		frameCircoloCittadino.getContentPane().add(textAreaDescrizione);
		
		JSpinner spinnerSconto = new JSpinner();
		spinnerSconto.setBounds(604, 467, 127, 17);
		frameCircoloCittadino.getContentPane().add(spinnerSconto);
		
		table = new JTable();
		table.setBackground(null);
		table.setAutoResizeMode(4);

		
		JButton btnInserisci = new JButton("Inserisci");
		btnInserisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnInserisci.setBounds(28, 516, 117, 29);
		frameCircoloCittadino.getContentPane().add(btnInserisci);
		
		JButton btnModifica = new JButton("Modifica");
		btnModifica.setBounds(186, 516, 117, 29);
		frameCircoloCittadino.getContentPane().add(btnModifica);
		
		JButton btnCancella = new JButton("Cancella");
		btnCancella.setBounds(357, 516, 117, 29);
		frameCircoloCittadino.getContentPane().add(btnCancella);
		
		JButton btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(681, 26, 109, 44);
		frameCircoloCittadino.getContentPane().add(btnDashboard);
		
		btnSalvaModifiche = new JButton("Salva");
		btnSalvaModifiche.setBounds(525, 516, 117, 29);
		frameCircoloCittadino.getContentPane().add(btnSalvaModifiche);
		
		btnAnnullaModifiche = new JButton("Annulla");
		btnAnnullaModifiche.setBounds(681, 516, 117, 29);
		frameCircoloCittadino.getContentPane().add(btnAnnullaModifiche);
	}
	
	public JButton getBtnDashboard() {
		return btnDashboard;
	}

	public JFrame getFrame() {
		return frameCircoloCittadino;
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
	
	public JTextField getId() {
		return textFieldId;
	}

	public JTextArea getDescrizione() {
		return textAreaDescrizione;
	}

	public JComboBox getRagione_sociale(){
		return comboBoxRagione_sociale;
	}
	
	public JSpinner getSconto(){
		return spinnerSconto;
	}

	public void setFrame(JFrame frame) {
		this.frameCircoloCittadino = frame;
	}
	
	public void setList(JList<Convenzione> list) {
		this.lstConvenzioni = list;
	}
	
	public JList<Convenzione> getList() {
		return lstConvenzioni;
	}
	
}