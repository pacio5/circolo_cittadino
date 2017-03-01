package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

import java.awt.Font;

//import javax.swing.ButtonGroup;
//import javax.swing.JComboBox;
import javax.swing.JButton;
//import javax.swing.JCheckBox;

public class PrenotazioneView {
	
	private JFrame frame;
	
	//private JTextField txtFieldNBiglietti;
	//private JTextField txtFieldDataAcquisto;
	//private JTextField txtFieldCf;
	private JTextField txtFieldNomeEvento;
	private JTextField txtFieldDataEvento;
	private JTextArea txtAreaDescrizione;
	private JSpinner spnNPosti;
	private JTextField txtFieldLuogo;
	private JTextField txtFieldPrezzo;
	private JButton btnInserisci;
	private JButton btnDashboard;

	//private JComboBox<String> eventiPassati;
	
	public PrenotazioneView(){
		frame = new JFrame("Circolo Cittadino - Inserisci una nuova attivita'");
		frame.setBounds(100, 100, 800, 600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCompilaForm = new JLabel("Compila il form con i dati relativi all'evento da inserire");
		lblCompilaForm.setBounds(176, 22, 335, 16);
		frame.getContentPane().add(lblCompilaForm);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(25, 133, 97, 16);
		frame.getContentPane().add(lblNome);

		txtFieldNomeEvento = new JTextField();
		txtFieldNomeEvento.setColumns(10);
		txtFieldNomeEvento.setBounds(138, 128, 130, 26);
		frame.getContentPane().add(txtFieldNomeEvento);

		JLabel lblData = new JLabel("Data");
		lblData.setBounds(25, 170, 97, 16);
		frame.getContentPane().add(lblData);

		txtFieldDataEvento = new JTextField();
		txtFieldDataEvento.setBounds(138, 165, 130, 26);
		frame.getContentPane().add(txtFieldDataEvento);
		txtFieldDataEvento.setColumns(10);

		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setBounds(25, 315, 112, 16);
		frame.getContentPane().add(lblDescrizione);

		txtAreaDescrizione = new JTextArea();
		txtAreaDescrizione.setWrapStyleWord(true);
		txtAreaDescrizione.setFont(new Font("Monospaced", Font.PLAIN, 11));
		txtAreaDescrizione.setLineWrap(true);
		txtAreaDescrizione.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		txtAreaDescrizione.setBounds(138, 313, 130, 128);
		frame.getContentPane().add(txtAreaDescrizione);

		JLabel lblNposti = new JLabel("Numero Posti");
		lblNposti.setBounds(25, 207, 112, 16);
		frame.getContentPane().add(lblNposti);

		spnNPosti = new JSpinner();
		spnNPosti.setBounds(138, 202, 130, 26);
		frame.getContentPane().add(spnNPosti);

		JLabel lblLuogo = new JLabel("Luogo");
		lblLuogo.setBounds(25, 244, 112, 16);
		frame.getContentPane().add(lblLuogo);

		txtFieldLuogo = new JTextField();
		txtFieldLuogo.setColumns(10);
		txtFieldLuogo.setBounds(138, 276, 130, 26);
		frame.getContentPane().add(txtFieldLuogo);

		JLabel lblPrezzo = new JLabel("Prezzo");
		lblPrezzo.setBounds(25, 281, 37, 16);
		frame.getContentPane().add(lblPrezzo);

		txtFieldPrezzo = new JTextField();
		txtFieldPrezzo.setColumns(10);
		txtFieldPrezzo.setBounds(138, 239, 130, 26);
		frame.getContentPane().add(txtFieldPrezzo);
		
		btnInserisci = new JButton("Inserisci");
		btnInserisci.setBounds(138, 511, 117, 29);
		frame.getContentPane().add(btnInserisci);

		btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(697, 11, 97, 41);
		frame.getContentPane().add(btnDashboard);
	}
	
	public JButton getBtnDashboard() {
		return btnDashboard;
	}

	public JFrame getFrame() {
		return frame;
	}

	public JButton getBtnInserisci() {
		return btnInserisci;
	}

	public void setBtnInserisci(JButton btnInserisci) {
		this.btnInserisci = btnInserisci;
	}

	public JTextField getNomeEvento() {
		return txtFieldNomeEvento;
	}

	public JTextField getData() {
		return txtFieldDataEvento;
	}

	public JTextArea getDescrizione() {
		return txtAreaDescrizione;
	}

	public JSpinner getNPosti() {
		return spnNPosti;
	}

	public JTextField getLuogo() {
		return txtFieldLuogo;
	}

	public JTextField getPrezzo() {
		return txtFieldPrezzo;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}