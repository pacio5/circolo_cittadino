package view;

import entita.Socio;

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

public class VisualizzaSoci {

	private JFrame frame;
	private JList<Socio> list;
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
	private JButton btnModifica;
	private JButton btnDiventaExsocio;
	private JButton btnEspelli;
	private JButton btnElimina;
	private DefaultListModel<Socio> dlm;
	private ScrollPane scrollPane;
	private JButton btnAggiorna;

	/**
	 * Create the frame.
	 */
	public VisualizzaSoci(ArrayList<Socio> soci) {
		frame = new JFrame("Elenco soci del Circolo Cittadino di Ascoli Piceno");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 800, 600);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblElencoSoci = new JLabel("Elenco Soci ");
		lblElencoSoci.setBounds(341, 20, 75, 16);
		frame.getContentPane().add(lblElencoSoci);
		
		list = new JList<Socio>();
		dlm = new DefaultListModel<Socio>();
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

		JLabel lblMetPagamento = new JLabel("Modalità Pagamento");
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

		String[] tip = { "ORDINARIO", "STRAORDINARIO", "BENEMERITO", "ONORARIO" };
		tipologia = new JComboBox(tip);
		tipologia.setSelectedIndex(0);
		tipologia.setBounds(661, 392, 130, 27);
		tipologia.setEnabled(false);
		frame.getContentPane().add(tipologia);
		btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(694, 15, 97, 41);
		frame.getContentPane().add(btnDashboard);
		
		btnModifica = new JButton("Modifica");
		btnModifica.setBounds(253, 500, 117, 29);
		btnModifica.setEnabled(false);
		frame.getContentPane().add(btnModifica);
		
		btnDiventaExsocio = new JButton("Diventa Ex-Socio");
		btnDiventaExsocio.setBounds(375, 500, 153, 29);
		btnDiventaExsocio.setEnabled(false);
		frame.getContentPane().add(btnDiventaExsocio);
		
		btnEspelli = new JButton("Espelli");
		btnEspelli.setBounds(528, 500, 117, 29);
		btnEspelli.setEnabled(false);
		frame.getContentPane().add(btnEspelli);
		
		btnElimina = new JButton("Elimina");
		btnElimina.setBounds(645, 500, 117, 29);
		btnElimina.setEnabled(false);
		frame.getContentPane().add(btnElimina);
		
		btnAggiorna = new JButton("Aggiorna");
		btnAggiorna.setBounds(253, 540, 117, 29);
		frame.getContentPane().add(btnAggiorna);
		btnAggiorna.setVisible(false);
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
	public JList<Socio> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(JList<Socio> list) {
		this.list = list;
	}
	
	/**
	 * @return the cf
	 */
	public JTextField getCf() {
		return cf;
	}

	/**
	 * @return the nome
	 */
	public JTextField getNome() {
		return nome;
	}

	/**
	 * @return the cognome
	 */
	public JTextField getCognome() {
		return cognome;
	}

	/**
	 * @return the dataNascita
	 */
	public JTextField getDataNascita() {
		return dataNascita;
	}

	/**
	 * @return the luogoNascita
	 */
	public JTextField getLuogoNascita() {
		return luogoNascita;
	}

	/**
	 * @return the rdbtnUomo
	 */
	public JRadioButton getRdbtnUomo() {
		return rdbtnUomo;
	}

	/**
	 * @return the rdbtnDonna
	 */
	public JRadioButton getRdbtnDonna() {
		return rdbtnDonna;
	}

	/**
	 * @return the sesso
	 */
	public ButtonGroup getSesso() {
		return sesso;
	}

	/**
	 * @return the indirizzo
	 */
	public JTextField getIndirizzo() {
		return indirizzo;
	}

	/**
	 * @return the citta
	 */
	public JTextField getCitta() {
		return citta;
	}

	/**
	 * @return the cap
	 */
	public JTextField getCap() {
		return cap;
	}

	/**
	 * @return the email
	 */
	public JTextField getEmail() {
		return email;
	}

	/**
	 * @return the telefono
	 */
	public JTextField getTelefono() {
		return telefono;
	}

	/**
	 * @return the professione
	 */
	public JTextField getProfessione() {
		return professione;
	}

	/**
	 * @return the statoCivile
	 */
	public JComboBox<String> getStatoCivile() {
		return statoCivile;
	}

	/**
	 * @return the coniuge
	 */
	public JTextField getConiuge() {
		return coniuge;
	}

	/**
	 * @return the dataAmmissione
	 */
	public JTextField getDataAmmissione() {
		return dataAmmissione;
	}

	/**
	 * @return the tassaAmmissione
	 */
	public JTextField getTassaAmmissione() {
		return tassaAmmissione;
	}

	/**
	 * @return the modPagamento
	 */
	public JComboBox<String> getModPagamento() {
		return modPagamento;
	}

	/**
	 * @return the metPagamento
	 */
	public JComboBox<String> getMetPagamento() {
		return metPagamento;
	}

	/**
	 * @return the tipologia
	 */
	public JComboBox<String> getTipologia() {
		return tipologia;
	}

	/**
	 * @return the btnDashboard
	 */
	public JButton getBtnDashboard() {
		return btnDashboard;
	}
	/**
	 * @return the btnModifica
	 */
	public JButton getBtnModifica() {
		return btnModifica;
	}
	
	/**
	 * @return the btnAggiorna
	 */
	public JButton getBtnAggiorna() {
		return btnAggiorna;
	}

	/**
	 * @return the btnDiventaExsocio
	 */
	public JButton getBtnDiventaExsocio() {
		return btnDiventaExsocio;
	}

	/**
	 * @return the btnEspelli
	 */
	public JButton getBtnEspelli() {
		return btnEspelli;
	}

	/**
	 * @return the btnElimina
	 */
	public JButton getBtnElimina() {
		return btnElimina;
	}

	/**
	 * @return the scrollPane
	 */
	public ScrollPane getScrollPane() {
		return scrollPane;
	}
}
