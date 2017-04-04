package view;

import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import entita.NonSocio;
import javax.swing.JButton;

/**
 * @author simoneonori
 * @author eliapacioni
 * @author riccardosmerilli
 * @author francescotalento
 * @version 1.0 Marzo 2017 
 *
 * Classe GestioneNonSocioView, si occupa di visualizzare la finestra di gestione dei nonsocio, 
 * dove è possibile gestire le varie operazioni
 */
public class GestioneNonSocioView {

	private JFrame frmCircoloCittadino;
	private JList<NonSocio> list;
	private DefaultListModel<NonSocio> dlm;
	private ScrollPane scrollPane;
	private JTextField cf;
	private JTextField nome;
	private JRadioButton rdbtnUomo;
	private JRadioButton rdbtnDonna;
	private ButtonGroup sesso;
	private JTextField cognome;
	private JTextField telefono;
	private JTextField email;
	private JButton btnInserisci;
	private JButton btnElimina;
	private JButton btnModifica;
	private JButton btnAggiorna;
	private JButton btnAnnulla;
	private JButton btnDashboard;
	
	/**
	 * Costruttore GestioneNonSocioView, si occupa di visualizzare la finestra di gestione dei nonsocio
	 * e inizializza tutte le proprietà
	 * @param nonSoci, elenco dei nonsocio
	 */
	public GestioneNonSocioView(ArrayList<NonSocio> nonSoci) {
		frmCircoloCittadino = new JFrame();
		frmCircoloCittadino.setTitle("Circolo Cittadino - Gestione Non Socio");
		frmCircoloCittadino.setBounds(100, 100, 800, 600);
		frmCircoloCittadino.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		list = new JList<NonSocio>();
		dlm = new DefaultListModel<NonSocio>();
		nonSoci.stream().forEach((n) -> {
			dlm.addElement(n);
		});
		frmCircoloCittadino.getContentPane().setLayout(null);
		list.setModel(dlm);

		scrollPane = new ScrollPane();
		scrollPane.setBounds(6, 54, 228, 470);
		scrollPane.add(list);
		frmCircoloCittadino.getContentPane().add(scrollPane);

		JLabel lblCodiceFiscale = new JLabel("Codice Fiscale");
		lblCodiceFiscale.setBounds(253, 95, 97, 16);
		frmCircoloCittadino.getContentPane().add(lblCodiceFiscale);

		cf = new JTextField();
		cf.setBounds(362, 90, 170, 26);
		cf.setColumns(10);
		frmCircoloCittadino.getContentPane().add(cf);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(253, 133, 97, 16);
		frmCircoloCittadino.getContentPane().add(lblNome);

		nome = new JTextField();
		nome.setColumns(10);
		nome.setBounds(362, 128, 170, 26);
		frmCircoloCittadino.getContentPane().add(nome);

		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setBounds(253, 171, 97, 16);
		frmCircoloCittadino.getContentPane().add(lblCognome);

		cognome = new JTextField();
		cognome.setColumns(10);
		cognome.setBounds(362, 167, 170, 23);
		frmCircoloCittadino.getContentPane().add(cognome);

		JLabel lblSesso = new JLabel("Sesso");
		lblSesso.setBounds(253, 209, 97, 16);
		frmCircoloCittadino.getContentPane().add(lblSesso);

		rdbtnUomo = new JRadioButton("Uomo");
		rdbtnUomo.setBounds(362, 205, 69, 23);
		rdbtnUomo.setSelected(true);
		frmCircoloCittadino.getContentPane().add(rdbtnUomo);

		rdbtnDonna = new JRadioButton("Donna");
		rdbtnDonna.setBounds(453, 205, 79, 23);
		frmCircoloCittadino.getContentPane().add(rdbtnDonna);

		sesso = new ButtonGroup();
		sesso.add(rdbtnUomo);
		sesso.add(rdbtnDonna);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(253, 244, 97, 16);
		frmCircoloCittadino.getContentPane().add(lblEmail);

		email = new JTextField();
		email.setColumns(10);
		email.setBounds(362, 239, 170, 26);
		frmCircoloCittadino.getContentPane().add(email);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(253, 282, 97, 16);
		frmCircoloCittadino.getContentPane().add(lblTelefono);

		telefono = new JTextField();
		telefono.setColumns(10);
		telefono.setBounds(362, 277, 170, 26);
		frmCircoloCittadino.getContentPane().add(telefono);

		btnInserisci = new JButton("Inserisci");
		btnInserisci.setBounds(240, 501, 117, 29);
		frmCircoloCittadino.getContentPane().add(btnInserisci);

		btnElimina = new JButton("Elimina");
		btnElimina.setVisible(false);
		btnElimina.setBounds(362, 501, 117, 29);
		frmCircoloCittadino.getContentPane().add(btnElimina);

		btnModifica = new JButton("Modifica");
		btnModifica.setVisible(false);
		btnModifica.setBounds(477, 501, 117, 29);
		frmCircoloCittadino.getContentPane().add(btnModifica);

		btnAggiorna = new JButton("Aggiorna");
		btnAggiorna.setBounds(592, 501, 117, 29);
		btnAggiorna.setVisible(false);
		frmCircoloCittadino.getContentPane().add(btnAggiorna);
		
		btnAnnulla = new JButton("Annulla");
		btnAnnulla.setBounds(240, 530, 117, 29);
		btnAnnulla.setVisible(false);
		frmCircoloCittadino.getContentPane().add(btnAnnulla);

		btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(697, 6, 97, 41);
		frmCircoloCittadino.getContentPane().add(btnDashboard);

		JLabel lblElencoNonSoci = new JLabel("Elenco Non Soci");
		lblElencoNonSoci.setBounds(376, 17, 128, 16);
		frmCircoloCittadino.getContentPane().add(lblElencoNonSoci);
	}

	/**
	 * @return frame (JFrame)
	 */
	public JFrame getFrame() {
		return frmCircoloCittadino;
	}

	/**
	 * 
	 * @return list, contiene tutti i non socio (JList)
	 */
	public JList<NonSocio> getList() {
		return list;
	}

	/**
	 * @return codice fiscale (JTextField)
	 */
	public JTextField getCf() {
		return cf;
	}

	/**
	 * @return nome (JTextField)
	 */
	public JTextField getNome() {
		return nome;
	}
	
	/**
	 * @return cognome (JTextField)
	 */
	public JTextField getCognome() {
		return cognome;
	}

	/**
	 * @return radio button uomo (JRadioButton)
	 */
	public JRadioButton getRdbtnUomo() {
		return rdbtnUomo;
	}

	/**
	 * @return radio button donna (JRadioButton)
	 */
	public JRadioButton getRdbtnDonna() {
		return rdbtnDonna;
	}
	
	/**
	 * 
	 * @return radio button group sesso (ButtonGroup)
	 */
	public ButtonGroup getSesso() {
		return sesso;
	}

	/**
	 * @return buttonGroup sesso (ButtonGroup)
	 */
	public JTextField getTelefono() {
		return telefono;
	}

	/**
	 * 
	 * @return email (JTextField)
	 */
	public JTextField getEmail() {
		return email;
	}

	/**
	 * @return bottone per inserire il nonsocio (JButton)
	 */
	public JButton getBtnInserisci() {
		return btnInserisci;
	}

	/**
	 * @return bottone per eliminare il nonsocio (JButton)
	 */
	public JButton getBtnElimina() {
		return btnElimina;
	}

	/**
	 * @return bottone per modificare il nonsocio (JButton)
	 */
	public JButton getBtnModifica() {
		return btnModifica;
	}

	/**
	 * @return bottone per salvare le modifiche del nonsocio (JButton)
	 */
	public JButton getBtnAggiorna() {
		return btnAggiorna;
	}
	
	/**
	 * @return bottone per annullare le modifiche del nonsocio (JButton)
	 */
	public JButton getBtnAnnulla() {
		return btnAnnulla;
	}

	/**
	 * @return bottone per tornare alla dashboard (JButton)
	 */
	public JButton getBtnDashboard() {
		return btnDashboard;
	}

}
