/**
 * 
 */
package view;

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

import entita.Figlio;
import entita.Socio;

/**
 * @author eliapacioni
 *
 */
public class GestioneFigliView {

	private JFrame frame;
	private JList<Figlio> list;
	private DefaultListModel<Figlio> dlm;
	private ScrollPane scrollPane;
	private JTextField cf;
	private JTextField nome;
	private JRadioButton rdbtnUomo;
	private JRadioButton rdbtnDonna;
	private ButtonGroup sesso;
	private JTextField dataNascita;
	private JComboBox<Socio> genitore;
	private JRadioButton rdbtnSi;
	private JRadioButton rdbtnNo;
	private ButtonGroup aCarico;
	private JButton btnDashboard;
	private JButton btnModifica;
	private JButton btnElimina;
	private JButton btnAggiorna;
	private JButton btnInserisci;
	/**
	 * Create the frame.
	 */
	public GestioneFigliView(ArrayList<Figlio> figli, ArrayList<Socio> genitori ) {
		frame = new JFrame("Elenco soci del Circolo Cittadino di Ascoli Piceno");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 800, 600);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblElencoSoci = new JLabel("Elenco Figli ");
		lblElencoSoci.setBounds(360, 22, 132, 16);
		frame.getContentPane().add(lblElencoSoci);
		
		list = new JList<Figlio>();
		dlm = new DefaultListModel<Figlio>();
		figli.stream().forEach((f)->{
			dlm.addElement(f);
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

		JLabel lblSesso = new JLabel("Sesso");
		lblSesso.setBounds(253, 171, 97, 16);
		frame.getContentPane().add(lblSesso);

		rdbtnUomo = new JRadioButton("Uomo");
		rdbtnUomo.setBounds(362, 167, 69, 23);
		rdbtnUomo.setSelected(true);
		rdbtnUomo.setEnabled(false);
		frame.getContentPane().add(rdbtnUomo);

		rdbtnDonna = new JRadioButton("Donna");
		rdbtnDonna.setBounds(430, 167, 79, 23);
		rdbtnDonna.setEnabled(false);
		frame.getContentPane().add(rdbtnDonna);

		sesso = new ButtonGroup();
		sesso.add(rdbtnUomo);
		sesso.add(rdbtnDonna);

		JLabel lblDataDiNascita = new JLabel("Data di Nascita");
		lblDataDiNascita.setBounds(253, 207, 97, 16);
		frame.getContentPane().add(lblDataDiNascita);

		dataNascita = new JTextField();
		dataNascita.setBounds(362, 202, 130, 26);
		dataNascita.setColumns(10);
		dataNascita.setEnabled(false);
		frame.getContentPane().add(dataNascita);
		
		JLabel lblGenitore = new JLabel("Genitore");
		lblGenitore.setBounds(253, 247, 97, 16);
		frame.getContentPane().add(lblGenitore);
		
		genitore = new JComboBox<Socio>();
		genitori.stream().forEach((g)->{
			genitore.addItem(g);
		});
		genitore.setBounds(362, 242, 130, 26);
		frame.getContentPane().add(genitore);
		
		
		JLabel lblACarico = new JLabel("A Carico");
		lblACarico.setBounds(253, 288, 97, 16);
		frame.getContentPane().add(lblACarico);
		
		rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setBounds(362, 283, 43, 26);
		frame.getContentPane().add(rdbtnSi);
		
		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(423, 284, 50, 26);
		frame.getContentPane().add(rdbtnNo);
		
		aCarico = new ButtonGroup();
		aCarico.add(rdbtnSi);
		aCarico.add(rdbtnNo);
		
		btnInserisci = new JButton("Inserisci");
		btnInserisci.setBounds(253, 500, 117, 29);
		frame.getContentPane().add(btnInserisci);
		
		btnModifica = new JButton("Modifica");
		btnModifica.setBounds(504, 500, 117, 29);
		btnModifica.setEnabled(false);
		frame.getContentPane().add(btnModifica);
		
		btnElimina = new JButton("Elimina");
		btnElimina.setBounds(375, 500, 117, 29);
		btnElimina.setEnabled(false);
		frame.getContentPane().add(btnElimina);
		
		btnAggiorna = new JButton("Aggiorna");
		btnAggiorna.setBounds(633, 500, 117, 29);
		btnAggiorna.setVisible(false);
		frame.getContentPane().add(btnAggiorna);
		
		btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(697, 11, 97, 41);
		frame.getContentPane().add(btnDashboard);
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
	public JList<Figlio> getList() {
		return list;
	}
	/**
	 * @return the dlm
	 */
	public DefaultListModel<Figlio> getDlm() {
		return dlm;
	}
	/**
	 * @return the scrollPane
	 */
	public ScrollPane getScrollPane() {
		return scrollPane;
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
	 * @return the dataNascita
	 */
	public JTextField getDataNascita() {
		return dataNascita;
	}
	/**
	 * @return the genitore
	 */
	public JComboBox<Socio> getGenitore() {
		return genitore;
	}
	/**
	 * @return the rdbtnSi
	 */
	public JRadioButton getRdbtnSi() {
		return rdbtnSi;
	}
	/**
	 * @return the rdbtnNo
	 */
	public JRadioButton getRdbtnNo() {
		return rdbtnNo;
	}
	/**
	 * @return the aCarico
	 */
	public ButtonGroup getaCarico() {
		return aCarico;
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
	 * @return the btnElimina
	 */
	public JButton getBtnElimina() {
		return btnElimina;
	}
	/**
	 * @return the btnAggiorna
	 */
	public JButton getBtnAggiorna() {
		return btnAggiorna;
	}
	/**
	 * @return the btnInserisci
	 */
	public JButton getBtnInserisci() {
		return btnInserisci;
	}
}
