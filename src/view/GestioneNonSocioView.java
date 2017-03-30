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
 * @author eliapacioni
 *
 */
public class GestioneNonSocioView {

	private JFrame frame;
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
	
	public GestioneNonSocioView(ArrayList<NonSocio> nonSoci) {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		list = new JList<NonSocio>();
		dlm = new DefaultListModel<NonSocio>();
		nonSoci.stream().forEach((n) -> {
			dlm.addElement(n);
		});
		frame.getContentPane().setLayout(null);
		list.setModel(dlm);

		scrollPane = new ScrollPane();
		scrollPane.setBounds(6, 54, 228, 470);
		scrollPane.add(list);
		frame.getContentPane().add(scrollPane);

		JLabel lblCodiceFiscale = new JLabel("Codice Fiscale");
		lblCodiceFiscale.setBounds(253, 95, 97, 16);
		frame.getContentPane().add(lblCodiceFiscale);

		cf = new JTextField();
		cf.setBounds(362, 90, 170, 26);
		cf.setColumns(10);
		frame.getContentPane().add(cf);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(253, 133, 97, 16);
		frame.getContentPane().add(lblNome);

		nome = new JTextField();
		nome.setColumns(10);
		nome.setBounds(362, 128, 170, 26);
		frame.getContentPane().add(nome);

		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setBounds(253, 171, 97, 16);
		frame.getContentPane().add(lblCognome);

		cognome = new JTextField();
		cognome.setColumns(10);
		cognome.setBounds(362, 167, 170, 23);
		frame.getContentPane().add(cognome);

		JLabel lblSesso = new JLabel("Sesso");
		lblSesso.setBounds(253, 209, 97, 16);
		frame.getContentPane().add(lblSesso);

		rdbtnUomo = new JRadioButton("Uomo");
		rdbtnUomo.setBounds(362, 205, 69, 23);
		rdbtnUomo.setSelected(true);
		frame.getContentPane().add(rdbtnUomo);

		rdbtnDonna = new JRadioButton("Donna");
		rdbtnDonna.setBounds(453, 205, 79, 23);
		frame.getContentPane().add(rdbtnDonna);

		sesso = new ButtonGroup();
		sesso.add(rdbtnUomo);
		sesso.add(rdbtnDonna);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(253, 244, 97, 16);
		frame.getContentPane().add(lblEmail);

		email = new JTextField();
		email.setColumns(10);
		email.setBounds(362, 239, 170, 26);
		frame.getContentPane().add(email);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(253, 282, 97, 16);
		frame.getContentPane().add(lblTelefono);

		telefono = new JTextField();
		telefono.setColumns(10);
		telefono.setBounds(362, 277, 170, 26);
		frame.getContentPane().add(telefono);

		btnInserisci = new JButton("Inserisci");
		btnInserisci.setBounds(240, 501, 117, 29);
		frame.getContentPane().add(btnInserisci);

		btnElimina = new JButton("Elimina");
		btnElimina.setVisible(false);
		btnElimina.setBounds(362, 501, 117, 29);
		frame.getContentPane().add(btnElimina);

		btnModifica = new JButton("Modifica");
		btnModifica.setVisible(false);
		btnModifica.setBounds(477, 501, 117, 29);
		frame.getContentPane().add(btnModifica);

		btnAggiorna = new JButton("Aggiorna");
		btnAggiorna.setBounds(592, 501, 117, 29);
		btnAggiorna.setVisible(false);
		frame.getContentPane().add(btnAggiorna);
		
		btnAnnulla = new JButton("Annulla");
		btnAnnulla.setBounds(240, 530, 117, 29);
		btnAnnulla.setVisible(false);
		frame.getContentPane().add(btnAnnulla);

		btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(697, 6, 97, 41);
		frame.getContentPane().add(btnDashboard);

		JLabel lblElencoNonSoci = new JLabel("Elenco Non Soci");
		lblElencoNonSoci.setBounds(376, 17, 128, 16);
		frame.getContentPane().add(lblElencoNonSoci);
	}

	public JFrame getFrame() {
		return frame;
	}

	public JList<NonSocio> getList() {
		return list;
	}

	public JTextField getCf() {
		return cf;
	}

	public JTextField getNome() {
		return nome;
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

	public JTextField getCognome() {
		return cognome;
	}

	public JTextField getTelefono() {
		return telefono;
	}

	public JTextField getEmail() {
		return email;
	}

	public JButton getBtnInserisci() {
		return btnInserisci;
	}

	public JButton getBtnElimina() {
		return btnElimina;
	}

	public JButton getBtnModifica() {
		return btnModifica;
	}

	public JButton getBtnAggiorna() {
		return btnAggiorna;
	}
	
	public JButton getBtnAnnulla() {
		return btnAnnulla;
	}

	public JButton getBtnDashboard() {
		return btnDashboard;
	}

}
