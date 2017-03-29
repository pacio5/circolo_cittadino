package view;

import entita.ExSocio;

import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class GestioneExSocioView {

	private JFrame frame;
	private JList<ExSocio> list;
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
	private JButton btnDashboard;
	private JButton btnDiventaSocio;
	private DefaultListModel<ExSocio> dlm;
	private ScrollPane scrollPane;

	/**
	 * Create the frame.
	 */
	public GestioneExSocioView(ArrayList<ExSocio> soci) {
		frame = new JFrame("Circolo Cittadino Ascoli Piceno");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 800, 600);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblElencoSoci = new JLabel("Elenco Ex Soci ");
		lblElencoSoci.setBounds(341, 20, 105, 16);
		frame.getContentPane().add(lblElencoSoci);
		
		list = new JList<ExSocio>();
		dlm = new DefaultListModel<ExSocio>();
		soci.stream().forEach((s)->{
			dlm.addElement(s);
		});
		list.setModel(dlm);
		
		scrollPane = new ScrollPane();
		scrollPane.setBounds(6, 54, 228, 518);
		frame.getContentPane().add(scrollPane);
		scrollPane.add(list);
		
		JLabel lblCodiceFiscale = new JLabel("Codice Fiscale");
		lblCodiceFiscale.setBounds(253, 95, 97, 16);
		frame.getContentPane().add(lblCodiceFiscale);

		cf = new JTextField();
		cf.setBounds(362, 90, 130, 26);
		cf.setColumns(10);
		cf.setEnabled(false);
		frame.getContentPane().add(cf);
		
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(253, 133, 97, 16);
		frame.getContentPane().add(lblNome);

		nome = new JTextField();
		nome.setColumns(10);
		nome.setBounds(362, 128, 130, 26);
		nome.setEnabled(false);
		frame.getContentPane().add(nome);
		

		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setBounds(253, 171, 97, 16);
		frame.getContentPane().add(lblCognome);

		cognome = new JTextField();
		cognome.setColumns(10);
		cognome.setBounds(362, 166, 130, 26);
		cognome.setEnabled(false);
		frame.getContentPane().add(cognome);

		JLabel lblSesso = new JLabel("Sesso");
		lblSesso.setBounds(253, 208, 97, 16);
		frame.getContentPane().add(lblSesso);

		rdbtnUomo = new JRadioButton("Uomo");
		rdbtnUomo.setBounds(362, 204, 69, 23);
		rdbtnUomo.setSelected(true);
		rdbtnUomo.setEnabled(false);
		frame.getContentPane().add(rdbtnUomo);

		rdbtnDonna = new JRadioButton("Donna");
		rdbtnDonna.setBounds(427, 204, 79, 23);
		rdbtnDonna.setEnabled(false);
		frame.getContentPane().add(rdbtnDonna);

		sesso = new ButtonGroup();
		sesso.add(rdbtnUomo);
		sesso.add(rdbtnDonna);

		JLabel lblDataDiNascita = new JLabel("Data di Nascita");
		lblDataDiNascita.setBounds(253, 244, 97, 16);
		frame.getContentPane().add(lblDataDiNascita);

		dataNascita = new JTextField();
		dataNascita.setBounds(362, 239, 130, 26);
		dataNascita.setColumns(10);
		dataNascita.setEnabled(false);
		frame.getContentPane().add(dataNascita);
		

		JLabel lblLuogoDiNascita = new JLabel("Luogo di Nascita");
		lblLuogoDiNascita.setBounds(253, 282, 112, 16);
		frame.getContentPane().add(lblLuogoDiNascita);

		luogoNascita = new JTextField();
		luogoNascita.setColumns(10);
		luogoNascita.setBounds(362, 277, 130, 26);
		luogoNascita.setEnabled(false);
		frame.getContentPane().add(luogoNascita);

		JLabel lblIndirizzo = new JLabel("Indirizzo");
		lblIndirizzo.setBounds(253, 320, 112, 16);
		frame.getContentPane().add(lblIndirizzo);

		indirizzo = new JTextField();
		indirizzo.setColumns(10);
		indirizzo.setBounds(362, 315, 130, 26);
		indirizzo.setEnabled(false);
		frame.getContentPane().add(indirizzo);

		JLabel lblCitta = new JLabel("Città");
		lblCitta.setBounds(253, 358, 112, 16);
		frame.getContentPane().add(lblCitta);

		citta = new JTextField();
		citta.setColumns(10);
		citta.setBounds(362, 353, 130, 26);
		citta.setEnabled(false);
		frame.getContentPane().add(citta);

		JLabel lblCap = new JLabel("Cap");
		lblCap.setBounds(253, 396, 37, 16);
		frame.getContentPane().add(lblCap);

		cap = new JTextField();
		cap.setColumns(10);
		cap.setBounds(362, 391, 130, 26);
		cap.setEnabled(false);
		frame.getContentPane().add(cap);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(253, 434, 50, 16);
		frame.getContentPane().add(lblEmail);

		email = new JTextField();
		email.setColumns(10);
		email.setBounds(362, 429, 130, 26);
		email.setEnabled(false);
		frame.getContentPane().add(email);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(531, 95, 55, 16);
		frame.getContentPane().add(lblTelefono);

		telefono = new JTextField();
		telefono.setColumns(10);
		telefono.setBounds(661, 90, 130, 26);
		telefono.setEnabled(false);
		frame.getContentPane().add(telefono);

		JLabel lblProfessione = new JLabel("Professione");
		lblProfessione.setBounds(531, 133, 79, 16);
		frame.getContentPane().add(lblProfessione);

		professione = new JTextField();
		professione.setColumns(10);
		professione.setBounds(661, 128, 130, 26);
		professione.setEnabled(false);
		frame.getContentPane().add(professione);

		JLabel lblStatoCivile = new JLabel("Stato Civile");
		lblStatoCivile.setBounds(531, 171, 85, 16);
		frame.getContentPane().add(lblStatoCivile);

		String[] state = {"CONIUGATO", "CELIBE", "NUBILE", "VEDOVO"};
		statoCivile = new JComboBox(state);
		statoCivile.setSelectedIndex(2);
		statoCivile.setBounds(664, 167, 130, 26);
		statoCivile.setEnabled(false);
		frame.getContentPane().add(statoCivile);

		JLabel lblConiuge = new JLabel("Coniuge");
		lblConiuge.setBounds(531, 208, 85, 16);
		frame.getContentPane().add(lblConiuge);

		coniuge = new JTextField();
		coniuge.setEnabled(false);
		coniuge.setColumns(10);
		coniuge.setBounds(661, 203, 130, 26);
		frame.getContentPane().add(coniuge);

		JLabel lblDataAmmissione = new JLabel("Data Ammissione");
		lblDataAmmissione.setBounds(531, 244, 114, 16);
		frame.getContentPane().add(lblDataAmmissione);

		dataAmmissione = new JTextField();
		dataAmmissione.setColumns(10);
		dataAmmissione.setBounds(661, 239, 130, 26);
		dataAmmissione.setEnabled(false);
		frame.getContentPane().add(dataAmmissione);

		JLabel lblTassaAmmissione = new JLabel("Tassa Ammissione");
		lblTassaAmmissione.setBounds(531, 282, 130, 16);
		frame.getContentPane().add(lblTassaAmmissione);

		tassaAmmissione = new JTextField();
		tassaAmmissione.setColumns(10);
		tassaAmmissione.setBounds(661, 277, 130, 26);
		tassaAmmissione.setEnabled(false);
		frame.getContentPane().add(tassaAmmissione);

		JLabel lblModPagamento = new JLabel("Modalità Pagamento");
		lblModPagamento.setBounds(531, 320, 130, 16);
		frame.getContentPane().add(lblModPagamento);

		String[] mod = { "ESATTORE", "BONIFICO BANCARIO" };
		modPagamento = new JComboBox(mod); // Manca <String>
		modPagamento.setSelectedIndex(0);
		modPagamento.setBounds(661, 316, 130, 27);
		modPagamento.setEnabled(false);
		frame.getContentPane().add(modPagamento);

		JLabel lblMetPagamento = new JLabel("Metodo Pagamento");
		lblMetPagamento.setBounds(531, 358, 130, 16);
		frame.getContentPane().add(lblMetPagamento);

		String[] met = { "MENSILE", "TRIMESTRALE", "SEMESTRALE", "ANNUALE" };
		metPagamento = new JComboBox(met);
		metPagamento.setSelectedIndex(3);
		metPagamento.setBounds(661, 354, 130, 27);
		metPagamento.setEnabled(false);
		frame.getContentPane().add(metPagamento);

		JLabel lblTipologia = new JLabel("Tipologia");
		lblTipologia.setBounds(531, 396, 130, 16);
		frame.getContentPane().add(lblTipologia);

		String[] tip = { "ORDINARIO", "STRAORDINARIO", "BENEMERITO", "ONORARIO", "GIOVANE", "PIU GIOVANE" };
		tipologia = new JComboBox(tip);
		tipologia.setSelectedIndex(0);
		tipologia.setBounds(661, 392, 130, 27);
		tipologia.setEnabled(false);
		frame.getContentPane().add(tipologia);
		
		btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(694, 15, 97, 41);
		frame.getContentPane().add(btnDashboard);
		
		btnDiventaSocio = new JButton("Diventa Socio");
		btnDiventaSocio.setBounds(253, 500, 117, 29);
		btnDiventaSocio.setVisible(false);
		frame.getContentPane().add(btnDiventaSocio);
	}
	
	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}
	
	/**
	 * @return the list
	 */
	public JList<ExSocio> getList() {
		return list;
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

	public JButton getBtnDashboard() {
		return btnDashboard;
	}

	public JButton getBtnDiventaSocio() {
		return btnDiventaSocio;
	}
}

