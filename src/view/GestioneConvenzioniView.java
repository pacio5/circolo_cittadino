package view;

import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import entita.Convenzione;

public class GestioneConvenzioniView{
	private JFrame frame;
	private JTextField textFieldIndirizzo;
	private JTextArea textAreaDescrizione;
	private JTextField textFieldRagioneSociale;
	private JTextField textFieldSconto;
	private JList<Convenzione> list;
	private DefaultListModel<Convenzione> dlm;
	private ScrollPane scrollPane;
	private JButton btnInserisci;
	private JButton btnDashboard;
	private JButton btnModifica;
	private JButton btnCancella;
	private JButton btnSalvaModifiche;
	private JButton btnAnnullaModifiche;
	
	public GestioneConvenzioniView(ArrayList<Convenzione> conv){
		frame = new JFrame("Circolo Cittadino - Gestisci Convenzioni");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 600);
		frame.getContentPane().setLayout(null);
		
		JLabel lblElencoConvenzioni = new JLabel("Elenco Convenzioni");
		lblElencoConvenzioni.setBounds(170, 81, 128, 14);
		frame.getContentPane().add(lblElencoConvenzioni);
		
		list = new JList<Convenzione>();
		dlm = new DefaultListModel<Convenzione>();
		conv.stream().forEach((c)->{
			dlm.addElement(c);
		});
		list.setModel(dlm);
		
		scrollPane = new ScrollPane();
		scrollPane.setBounds(28, 128, 408, 356);
		frame.getContentPane().add(scrollPane);
		scrollPane.add(list);
		
		JLabel lblCompilaForm = new JLabel("Inserisci i dati relativi alla convenzione");
		lblCompilaForm.setBounds(491, 81, 269, 14);
		frame.getContentPane().add(lblCompilaForm);
		
		JLabel lblIndirizzo = new JLabel("Indirizzo:");
		lblIndirizzo.setBounds(491, 197, 102, 17);
		frame.getContentPane().add(lblIndirizzo);
		
		textFieldIndirizzo = new JTextField();
		textFieldIndirizzo.setBounds(623, 195, 137, 20);
		textFieldIndirizzo.setColumns(10);
		frame.getContentPane().add(textFieldIndirizzo);
		
		JLabel lblRagioneSociale = new JLabel("Ragione Sociale:");
		lblRagioneSociale.setBounds(491, 167, 120, 14);
		frame.getContentPane().add(lblRagioneSociale);
		
		textFieldRagioneSociale = new JTextField();
		textFieldRagioneSociale.setBounds(623, 163, 137, 20);
		textFieldRagioneSociale.setColumns(10);
		frame.getContentPane().add(textFieldRagioneSociale);
		
		JLabel lblDescrizione = new JLabel("Descrizione:");
		lblDescrizione.setBounds(491, 231, 91, 14);
		frame.getContentPane().add(lblDescrizione);
		
		textAreaDescrizione = new JTextArea();
		textAreaDescrizione.setBounds(491, 251, 269, 193);
		frame.getContentPane().add(textAreaDescrizione);
		
		JLabel lblSconto = new JLabel("Sconto:");
		lblSconto.setBounds(491, 470, 61, 14);
		frame.getContentPane().add(lblSconto);
		
		textFieldSconto = new JTextField();
		textFieldSconto.setBounds(605, 467, 127, 17);
		frame.getContentPane().add(textFieldSconto);
		
		btnInserisci = new JButton("Inserisci");
		btnInserisci.setBounds(28, 516, 117, 29);
		frame.getContentPane().add(btnInserisci);
		
		btnModifica = new JButton("Modifica");
		btnModifica.setBounds(170, 516, 117, 29);
		btnModifica.setVisible(false);
		frame.getContentPane().add(btnModifica);
		
		btnCancella = new JButton("Cancella");
		btnCancella.setBounds(319, 516, 117, 29);
		btnCancella.setVisible(false);
		frame.getContentPane().add(btnCancella);
		
		btnSalvaModifiche = new JButton("Salva");
		btnSalvaModifiche.setBounds(465, 516, 117, 29);
		btnSalvaModifiche.setVisible(false);
		frame.getContentPane().add(btnSalvaModifiche);
		
		btnAnnullaModifiche = new JButton("Annulla");
		btnAnnullaModifiche.setBounds(605, 516, 117, 29);
		btnAnnullaModifiche.setVisible(false);
		frame.getContentPane().add(btnAnnullaModifiche);
		
		btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(689, 6, 109, 44);
		frame.getContentPane().add(btnDashboard);
		
		JLabel label = new JLabel("%");
		label.setBounds(747, 468, 47, 16);
		frame.getContentPane().add(label);
	}

	public JFrame getFrame() {
		return frame;
	}

	public JTextField getTextFieldIndirizzo() {
		return textFieldIndirizzo;
	}

	public JTextArea getTextAreaDescrizione() {
		return textAreaDescrizione;
	}

	public JTextField getTextFieldRagioneSociale() {
		return textFieldRagioneSociale;
	}

	public JTextField getTextFieldSconto() {
		return textFieldSconto;
	}

	public JButton getBtnInserisci() {
		return btnInserisci;
	}

	public JButton getBtnDashboard() {
		return btnDashboard;
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

	public JList<Convenzione> getList() {
		return list;
	}

	public DefaultListModel<Convenzione> getDlm() {
		return dlm;
	}

	public ScrollPane getScrollPane() {
		return scrollPane;
	}

	public JButton getBtnAnnullaModifiche() {
		return btnAnnullaModifiche;
	}

}