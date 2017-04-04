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
 * @author simoneonori
 * @author eliapacioni
 * @author riccardosmerilli
 * @author francescotalento
 * @version 1.0 Marzo 2017 
 *
 * Classe GestioneFigliView, si occupa di visualizzare la finestra di gestione dei figli, 
 * dove è possibile gestire le varie operazioni
 */
public class GestioneFigliView {

	private JFrame frame;
	private JList<Figlio> list;
	private DefaultListModel<Figlio> dlm;
	private ScrollPane scrollPane;
	private JComboBox<Socio> filtro;
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
	private JButton btnAnnulla;
	
	/**
	 * Costruttore GestioneFigliView, si occupa di visualizzare la finestra di gestione dei figli
	 * e inizializza tutte le proprietà
	 */
	public GestioneFigliView(ArrayList<Figlio> figli, ArrayList<Socio> genitori ) {
		frame = new JFrame("Circolo Cittadino - Gestione Figli");
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
		scrollPane.setBounds(6, 54, 228, 470);
		frame.getContentPane().add(scrollPane);
		scrollPane.add(list);
		
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

		JLabel lblSesso = new JLabel("Sesso");
		lblSesso.setBounds(253, 171, 97, 16);
		frame.getContentPane().add(lblSesso);

		rdbtnUomo = new JRadioButton("Uomo");
		rdbtnUomo.setBounds(362, 167, 69, 23);
		rdbtnUomo.setSelected(true);
		frame.getContentPane().add(rdbtnUomo);

		rdbtnDonna = new JRadioButton("Donna");
		rdbtnDonna.setBounds(453, 167, 79, 23);
		frame.getContentPane().add(rdbtnDonna);

		sesso = new ButtonGroup();
		sesso.add(rdbtnUomo);
		sesso.add(rdbtnDonna);

		JLabel lblDataDiNascita = new JLabel("Data di Nascita");
		lblDataDiNascita.setBounds(253, 207, 97, 16);
		frame.getContentPane().add(lblDataDiNascita);

		dataNascita = new JTextField();
		dataNascita.setBounds(362, 202, 170, 26);
		dataNascita.setColumns(10);
		frame.getContentPane().add(dataNascita);
		
		JLabel lblGenitore = new JLabel("Genitore");
		lblGenitore.setBounds(253, 247, 97, 16);
		frame.getContentPane().add(lblGenitore);
		
		genitore = new JComboBox<Socio>();
		genitori.stream().forEach((g)->{
			genitore.addItem(g);
		});
		genitore.setBounds(362, 242, 170, 26);
		frame.getContentPane().add(genitore);
		
		
		JLabel lblACarico = new JLabel("A Carico");
		lblACarico.setBounds(253, 288, 97, 16);
		frame.getContentPane().add(lblACarico);
		
		rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setBounds(362, 283, 43, 26);
		rdbtnSi.setSelected(true);
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
		btnModifica.setVisible(false);
		frame.getContentPane().add(btnModifica);
		
		btnElimina = new JButton("Elimina");
		btnElimina.setBounds(375, 500, 117, 29);
		btnElimina.setVisible(false);
		frame.getContentPane().add(btnElimina);
		
		btnAggiorna = new JButton("Aggiorna");
		btnAggiorna.setBounds(633, 500, 117, 29);
		btnAggiorna.setVisible(false);
		frame.getContentPane().add(btnAggiorna);
		
		btnAnnulla = new JButton("Annulla");
		btnAnnulla.setBounds(253, 531, 117, 26);
		btnAnnulla.setVisible(false);
		frame.getContentPane().add(btnAnnulla);
		
		btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(697, 11, 97, 41);
		frame.getContentPane().add(btnDashboard);
		
		JLabel lblFiltraPerGenitore = new JLabel("Filtra per genitore");
		lblFiltraPerGenitore.setBounds(6, 534, 117, 16);
		frame.getContentPane().add(lblFiltraPerGenitore);
		
		filtro = new JComboBox<Socio>();
		filtro.addItem(null);
		genitori.stream().forEach((g)->{
			filtro.addItem(g);
		});
		
		filtro.setBounds(119, 530, 130, 26);
		filtro.setSelectedIndex(0);
		frame.getContentPane().add(filtro);
	}
	
	/**
	 * @return frame (JFrame)
	 */
	public JFrame getFrame() {
		return frame;
	}
	
	/**
	 * @return lista con l'elenco dei figli (JList)
	 */
	public JList<Figlio> getList() {
		return list;
	}
	
	/**
	 * @return dlm, model della lista (DefaultListModel)
	 */
	public DefaultListModel<Figlio> getDlm() {
		return dlm;
	}
	
	/**
	 * @return scrollPane, pannello in cui viene visualizzata la vista (ScrollPane)
	 */
	public ScrollPane getScrollPane() {
		return scrollPane;
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
	 * @return buttonGroup sesso (ButtonGroup)
	 */
	public ButtonGroup getSesso() {
		return sesso;
	}
	
	/**
	 * @return dataNascita (JTextField)
	 */
	public JTextField getDataNascita() {
		return dataNascita;
	}
	
	/**
	 * @return genitore (Socio)
	 */
	public JComboBox<Socio> getGenitore() {
		return genitore;
	}
	
	/**
	 * @return radio button si (JRadioButton), riferito alla proprietà a carico
	 */
	public JRadioButton getRdbtnSi() {
		return rdbtnSi;
	}
	
	/**
	 * @return radio button no (JRadioButton), riferito alla proprietà a carico
	 */
	public JRadioButton getRdbtnNo() {
		return rdbtnNo;
	}
	
	/**
	 * @return buttonGroup aCarico (ButtonGroup)
	 */
	public ButtonGroup getaCarico() {
		return aCarico;
	}
	
	/**
	 * @return bottone per tornare alla dashboard (JButton)
	 */
	public JButton getBtnDashboard() {
		return btnDashboard;
	}
	
	/**
	 * @return bottone per modificare il figlio (JButton)
	 */
	public JButton getBtnModifica() {
		return btnModifica;
	}
	
	/**
	 * @return bottone per eliminare il figlio (JButton)
	 */
	public JButton getBtnElimina() {
		return btnElimina;
	}
	
	/**
	 * @return bottone per salvare i cambiamenti del figlio (JButton)
	 */
	public JButton getBtnAggiorna() {
		return btnAggiorna;
	}
	
	/**
	 * @return bottone per salvare i cambiamenti del figlio (JButton)
	 */
	public JButton getBtnAnnulla() {
		return btnAnnulla;
	}
	
	/**
	 * @return bottone per l'inserimento del figlio (JButton)
	 */
	public JButton getBtnInserisci() {
		return btnInserisci;
	}
	
	/**
	 * @return filtro, per filtrare i figli in base al genitore (JComboBox)
	 */
	public JComboBox<Socio> getFiltro() {
		return filtro;
	}
}
