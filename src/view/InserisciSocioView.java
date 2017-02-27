package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class InserisciSocioView {

	private JFrame frame;

	private JTextField cf;
	private JTextField nome;
	private JTextField cognome;
	private JTextField dataNascita;
	private JTextField luogoNascita;
	private JRadioButton rdbtnUomo;
	private JRadioButton rdbtnDonna;
	private ButtonGroup sesso;
	private JTextField indirizzo;
	private JTextField citta;
	private JTextField cap;
	private JTextField email;
	private JTextField telefono;
	private JTextField professione;
	private JComboBox<String> statoCivile;
	private JTextField coniuge;
	private JTextField dataAmmissione;
	private JTextField tassaAmmissione;
	private JComboBox<String> modPagamento;
	private JComboBox<String> metPagamento;
	private JComboBox<String> tipologia;
	private JButton btnInserisci;
	private JButton btnDashboard;

	/**
	 * Create the frame.
	 */
	public InserisciSocioView() {
		frame = new JFrame("Circolo Cittadino - Inserisci un nuovo socio");
		frame.setBounds(100, 100, 672, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblCompilaIlForm = new JLabel("Compila il form con i dati del nuovo socio da inserire");
		lblCompilaIlForm.setBounds(176, 22, 335, 16);
		frame.getContentPane().add(lblCompilaIlForm);

		JLabel lblCodiceFiscale = new JLabel("Codice Fiscale");
		lblCodiceFiscale.setBounds(25, 75, 97, 16);
		frame.getContentPane().add(lblCodiceFiscale);

		cf = new JTextField();
		cf.setBounds(138, 70, 130, 26);
		frame.getContentPane().add(cf);
		cf.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(25, 100, 97, 16);
		frame.getContentPane().add(lblNome);

		nome = new JTextField();
		nome.setColumns(10);
		nome.setBounds(138, 95, 130, 26);
		frame.getContentPane().add(nome);

		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setBounds(25, 125, 97, 16);
		frame.getContentPane().add(lblCognome);

		cognome = new JTextField();
		cognome.setColumns(10);
		cognome.setBounds(138, 120, 130, 26);
		frame.getContentPane().add(cognome);

		JLabel lblSesso = new JLabel("Sesso");
		lblSesso.setBounds(25, 150, 97, 16);
		frame.getContentPane().add(lblSesso);

		rdbtnUomo = new JRadioButton("Uomo");
		rdbtnUomo.setBounds(138, 145, 69, 23);
		rdbtnUomo.setSelected(true);
		frame.getContentPane().add(rdbtnUomo);

		rdbtnDonna = new JRadioButton("Donna");
		rdbtnDonna.setBounds(199, 145, 79, 23);
		frame.getContentPane().add(rdbtnDonna);

		sesso = new ButtonGroup();
		sesso.add(rdbtnUomo);
		sesso.add(rdbtnDonna);

		JLabel lblDataDiNascita = new JLabel("Data di Nascita");
		lblDataDiNascita.setBounds(25, 175, 97, 16);
		frame.getContentPane().add(lblDataDiNascita);

		dataNascita = new JTextField();
		dataNascita.setBounds(138, 170, 130, 26);
		frame.getContentPane().add(dataNascita);
		dataNascita.setColumns(10);

		JLabel lblLuogoDiNascita = new JLabel("Luogo di Nascita");
		lblLuogoDiNascita.setBounds(25, 200, 112, 16);
		frame.getContentPane().add(lblLuogoDiNascita);

		luogoNascita = new JTextField();
		luogoNascita.setColumns(10);
		luogoNascita.setBounds(138, 195, 130, 26);
		frame.getContentPane().add(luogoNascita);

		JLabel lblIndirizzo = new JLabel("Indirizzo");
		lblIndirizzo.setBounds(25, 225, 112, 16);
		frame.getContentPane().add(lblIndirizzo);

		indirizzo = new JTextField();
		indirizzo.setColumns(10);
		indirizzo.setBounds(138, 220, 130, 26);
		frame.getContentPane().add(indirizzo);

		JLabel lblCitta = new JLabel("Città");
		lblCitta.setBounds(25, 250, 112, 16);
		frame.getContentPane().add(lblCitta);

		citta = new JTextField();
		citta.setColumns(10);
		citta.setBounds(138, 245, 130, 26);
		frame.getContentPane().add(citta);

		JLabel lblCap = new JLabel("Cap");
		lblCap.setBounds(25, 275, 37, 16);
		frame.getContentPane().add(lblCap);

		cap = new JTextField();
		cap.setColumns(10);
		cap.setBounds(138, 270, 130, 26);
		frame.getContentPane().add(cap);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(25, 300, 50, 16);
		frame.getContentPane().add(lblEmail);

		email = new JTextField();
		email.setColumns(10);
		email.setBounds(138, 295, 130, 26);
		frame.getContentPane().add(email);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(357, 75, 69, 16);
		frame.getContentPane().add(lblTelefono);

		telefono = new JTextField();
		telefono.setColumns(10);
		telefono.setBounds(503, 70, 130, 26);
		frame.getContentPane().add(telefono);

		JLabel lblProfessione = new JLabel("Professione");
		lblProfessione.setBounds(357, 100, 79, 16);
		frame.getContentPane().add(lblProfessione);

		professione = new JTextField();
		professione.setColumns(10);
		professione.setBounds(503, 95, 130, 26);
		frame.getContentPane().add(professione);

		JLabel lblStatoCivile = new JLabel("Stato Civile");
		lblStatoCivile.setBounds(357, 125, 85, 16);
		frame.getContentPane().add(lblStatoCivile);

		String[] state = {"Coniugato", "Celibe", "Nubile", "Vedovo"};
		statoCivile = new JComboBox(state);
		statoCivile.setSelectedIndex(2);
		statoCivile.setBounds(503, 120, 130, 26);
		frame.getContentPane().add(statoCivile);

		JLabel lblConiuge = new JLabel("Coniuge");
		lblConiuge.setBounds(357, 150, 85, 16);
		frame.getContentPane().add(lblConiuge);

		coniuge = new JTextField();
		coniuge.setEnabled(false);
		coniuge.setColumns(10);
		coniuge.setBounds(503, 145, 130, 26);
		frame.getContentPane().add(coniuge);

		JLabel lblDataAmmissione = new JLabel("Data Ammissione");
		lblDataAmmissione.setBounds(357, 175, 114, 16);
		frame.getContentPane().add(lblDataAmmissione);

		dataAmmissione = new JTextField();
		dataAmmissione.setColumns(10);
		dataAmmissione.setBounds(503, 170, 130, 26);
		frame.getContentPane().add(dataAmmissione);

		JLabel lblTassaAmmissione = new JLabel("Tassa Ammissione");
		lblTassaAmmissione.setBounds(357, 200, 130, 16);
		frame.getContentPane().add(lblTassaAmmissione);

		tassaAmmissione = new JTextField();
		tassaAmmissione.setColumns(10);
		tassaAmmissione.setBounds(503, 195, 130, 26);
		frame.getContentPane().add(tassaAmmissione);

		JLabel lblModPagamento = new JLabel("Modalità Pagamento");
		lblModPagamento.setBounds(357, 225, 130, 16);
		frame.getContentPane().add(lblModPagamento);

		String[] mod = { "Esattore", "Bonifico Bancario" };
		modPagamento = new JComboBox(mod); // Manca <String>
		modPagamento.setSelectedIndex(0);
		modPagamento.setBounds(503, 220, 130, 27);
		frame.getContentPane().add(modPagamento);

		JLabel lblMetPagamento = new JLabel("Modalità Pagamento");
		lblMetPagamento.setBounds(357, 250, 130, 16);
		frame.getContentPane().add(lblMetPagamento);

		String[] met = { "Mensile", "Trimestrale", "Semestrale", "Annuale" };
		metPagamento = new JComboBox(met);
		metPagamento.setSelectedIndex(3);
		metPagamento.setBounds(503, 245, 130, 27);
		frame.getContentPane().add(metPagamento);

		JLabel lblTipologia = new JLabel("Tipologia");
		lblTipologia.setBounds(357, 275, 130, 16);
		frame.getContentPane().add(lblTipologia);

		String[] tip = { "Ordinario", "Straordinario", "Benemerito", "Onorario" };
		tipologia = new JComboBox(tip);
		tipologia.setSelectedIndex(0);
		tipologia.setBounds(503, 271, 130, 27);
		frame.getContentPane().add(tipologia);
		
		btnInserisci = new JButton("Inserisci");
		btnInserisci.setBounds(280, 353, 117, 29);
		frame.getContentPane().add(btnInserisci);

		btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(569, 11, 97, 41);
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

	public JTextField getCf() {
		return cf;
	}

	public JTextField getNome() {
		return nome;
	}

	public JTextField getCognome() {
		return cognome;
	}

	public JTextField getDataNascita() {
		return dataNascita;
	}

	public JTextField getLuogoNascita() {
		return luogoNascita;
	}

	public JRadioButton getRdbtnUomo() {
		return rdbtnUomo;
	}

	public JRadioButton getRdbtnDonna() {
		return rdbtnDonna;
	}

	public ButtonGroup getSesso() {
		return sesso;
	}

	public JTextField getIndirizzo() {
		return indirizzo;
	}

	public JTextField getCitta() {
		return citta;
	}

	public JTextField getCap() {
		return cap;
	}

	public JTextField getEmail() {
		return email;
	}

	public JTextField getTelefono() {
		return telefono;
	}

	public JTextField getProfessione() {
		return professione;
	}

	public JComboBox<String> getStatoCivile() {
		return statoCivile;
	}

	public JTextField getConiuge() {
		return coniuge;
	}

	public JTextField getDataAmmissione() {
		return dataAmmissione;
	}

	public JTextField getTassaAmmissione() {
		return tassaAmmissione;
	}

	public JComboBox<String> getModPagamento() {
		return modPagamento;
	}

	public JComboBox<String> getMetPagamento() {
		return metPagamento;
	}

	public JComboBox<String> getTipologia() {
		return tipologia;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}