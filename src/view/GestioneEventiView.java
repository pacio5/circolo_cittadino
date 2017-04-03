package view;

import java.awt.Font;
import java.awt.ScrollPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import entita.Evento;

import java.util.ArrayList;
import javax.swing.SpinnerNumberModel;

/**
 * @author simoneonori
 * @author eliapacioni
 * @author smerilliriccardo
 * @author francescotalento
 * @version 1.0 marzo 2017
 * Classe GestioneEventiView, si occupa di visualizzare la finestra di gestione degli eventi, 
 * da dove è possibile accedere alle funzioni di inserimento, modifica e canzellazione di un evento
 */
public class GestioneEventiView {
	
	private JFrame frmCircoloCittadino;	
	private JTextField txtFieldNomeEvento;
	private JTextField txtFieldDataEvento;
	private JTextArea txtAreaDescrizione;
	private JSpinner spnNPosti;
	private JTextField txtFieldLuogo;
	private JTextField txtFieldPrezzo;
	private JButton btnInserisci;
	private JButton btnDashboard;
	private JButton btnModifica;
	private JButton btnCancella;
	private JButton btnSalvaModifiche;
	private JButton btnAnnullaModifiche;
	private JList<Evento> lstEventi;
	private DefaultListModel<Evento> dlme;
	private ScrollPane scrollPane;
	

	/**
	 * Costruttore GestioneEventiView, si occupa di visualizzare la finestra di gestione degli eventi
	 * e inizializza tutte le proprietà
	 * @param eventi oggetto di tipo ArrayList<Evento> contenente tutti gli eventi
	 */
	public GestioneEventiView(ArrayList<Evento> eventi){
		frmCircoloCittadino = new JFrame("Circolo Cittadino - Elenco attivita'");
		frmCircoloCittadino.setTitle("Circolo Cittadino - Gestisci attivita'");
		frmCircoloCittadino.setBounds(100, 100, 800, 600);
		frmCircoloCittadino.setResizable(false);
		frmCircoloCittadino.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCircoloCittadino.getContentPane().setLayout(null);
		
		lstEventi = new JList<Evento>();
		dlme = new DefaultListModel<Evento>();
		eventi.stream().forEach((e)->{
			dlme.addElement(e);
		});
		lstEventi.setModel(dlme);

		scrollPane = new ScrollPane();
		scrollPane.setBounds(28, 128, 408, 356);
		frmCircoloCittadino.getContentPane().add(scrollPane);
		scrollPane.add(lstEventi);
		
		JLabel lblCompilaForm = new JLabel("Inserisci i dati relativi all'evento");
		lblCompilaForm.setBounds(593, 76, 335, 16);
		frmCircoloCittadino.getContentPane().add(lblCompilaForm);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(544, 133, 97, 16);
		frmCircoloCittadino.getContentPane().add(lblNome);

		txtFieldNomeEvento = new JTextField();
		txtFieldNomeEvento.setColumns(10);
		txtFieldNomeEvento.setBounds(636, 128, 130, 26);
		frmCircoloCittadino.getContentPane().add(txtFieldNomeEvento);

		JLabel lblData = new JLabel("Data");
		lblData.setBounds(544, 170, 97, 16);
		frmCircoloCittadino.getContentPane().add(lblData);

		txtFieldDataEvento = new JTextField();
		txtFieldDataEvento.setBounds(636, 165, 130, 26);
		frmCircoloCittadino.getContentPane().add(txtFieldDataEvento);
		txtFieldDataEvento.setColumns(10);

		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setBounds(544, 323, 112, 16);
		frmCircoloCittadino.getContentPane().add(lblDescrizione);

		txtAreaDescrizione = new JTextArea();
		txtAreaDescrizione.setWrapStyleWord(true);
		txtAreaDescrizione.setFont(new Font("Monospaced", Font.PLAIN, 11));
		txtAreaDescrizione.setLineWrap(true);
		txtAreaDescrizione.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		txtAreaDescrizione.setBounds(636, 321, 130, 163);
		frmCircoloCittadino.getContentPane().add(txtAreaDescrizione);

		JLabel lblNposti = new JLabel("Numero Posti");
		lblNposti.setBounds(544, 207, 112, 16);
		frmCircoloCittadino.getContentPane().add(lblNposti);

		spnNPosti = new JSpinner();
		spnNPosti.setModel(new SpinnerNumberModel(0, 0, null, 1));
		spnNPosti.setBounds(636, 202, 130, 26);
		frmCircoloCittadino.getContentPane().add(spnNPosti);

		JLabel lblLuogo = new JLabel("Luogo");
		lblLuogo.setBounds(544, 284, 112, 16);
		frmCircoloCittadino.getContentPane().add(lblLuogo);

		txtFieldLuogo = new JTextField();
		txtFieldLuogo.setColumns(10);
		txtFieldLuogo.setBounds(636, 279, 130, 26);
		frmCircoloCittadino.getContentPane().add(txtFieldLuogo);

		JLabel lblPrezzo = new JLabel("Prezzo");
		lblPrezzo.setBounds(544, 241, 84, 23);
		frmCircoloCittadino.getContentPane().add(lblPrezzo);

		txtFieldPrezzo = new JTextField();
		txtFieldPrezzo.setColumns(10);
		txtFieldPrezzo.setBounds(636, 239, 130, 26);
		frmCircoloCittadino.getContentPane().add(txtFieldPrezzo);
		
		btnInserisci = new JButton("Inserisci");
		btnInserisci.setBounds(186, 513, 117, 29);
		frmCircoloCittadino.getContentPane().add(btnInserisci);

		btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(697, 11, 97, 41);
		frmCircoloCittadino.getContentPane().add(btnDashboard);
						
		JLabel lblElencoAttivita = new JLabel("Elenco attivita'");
		lblElencoAttivita.setBounds(186, 77, 112, 14);
		frmCircoloCittadino.getContentPane().add(lblElencoAttivita);
		
		btnModifica = new JButton("Modifica");
		btnModifica.setBounds(357, 513, 117, 29);
		frmCircoloCittadino.getContentPane().add(btnModifica);
		
		btnCancella = new JButton("Cancella");
		btnCancella.setBounds(524, 513, 117, 29);
		frmCircoloCittadino.getContentPane().add(btnCancella);
		
		btnSalvaModifiche = new JButton("Salva");
		btnSalvaModifiche.setBounds(357, 513, 117, 29);
		frmCircoloCittadino.getContentPane().add(btnSalvaModifiche);
		
		btnAnnullaModifiche = new JButton("Annulla");
		btnAnnullaModifiche.setBounds(524, 513, 117, 29);
		frmCircoloCittadino.getContentPane().add(btnAnnullaModifiche);
	}
	
	
	/**
	 * @return Bottone per tornare alla dashboard (JButton)
	 */
	public JButton getBtnDashboard() {
		return btnDashboard;
	}
 
	/**
	 * @return frame (JFrame)
	 */
	public JFrame getFrame() {
		return frmCircoloCittadino;
	}

	/**
	 * @return Bottone per inserire i dati dell'evento (JButton)
	 */
	public JButton getBtnInserisci() {
		return btnInserisci;
	}

	/**
	 * @return Bottone per modificare i dati dell'evento (JButton)
	 */
	public JButton getBtnModifica(){
		return btnModifica;
	}

	/**
	 * @return Bottone per cancellare i dati dell'evento (JButton)
	 */
	public JButton getBtnCancella(){
		return btnCancella;
	}

	/**
	 * @return Bottone per salvare le modifiche effettuate (JButton)
	 */
	public JButton getBtnSalvaModifiche(){
		return btnSalvaModifiche;
	}

	/**
	 * @return Bottone per annullare le modifiche effettuate (JButton)
	 */
	public JButton getBtnAnnullaModifiche(){
		return btnAnnullaModifiche;
	}

	/**
	 * @return txtFieldNomeEvento (JTextField)
	 */
	public JTextField getNomeEvento() {
		return txtFieldNomeEvento;
	}

	/**
	 * @return txtFieldDataEvento (JTextField)
	 */
	public JTextField getData() {
		return txtFieldDataEvento;
	}

	/**
	 * @return txtAreaDescrizione (JTextArea)
	 */
	public JTextArea getDescrizione() {
		return txtAreaDescrizione;
	}

	/**
	 * @return spnNPosti (JSpinner)
	 */
	public JSpinner getNPosti() {
		return spnNPosti;
	}

	/**
	 * @return txtFieldLuogo (JTextField)
	 */
	public JTextField getLuogo() {
		return txtFieldLuogo;
	}

	/**
	 * @return txtFieldPrezzo (JTextField)
	 */
	public JTextField getPrezzo() {
		return txtFieldPrezzo;
	}

	public void setFrame(JFrame frame) {
		this.frmCircoloCittadino = frame;
	}
	
	public void setList(JList<Evento> list) {
		this.lstEventi = list;
	}
	
	/**
	 * @return lstEventi contentente gli Eventi (JList)
	 */
	public JList<Evento> getList() {
		return lstEventi;
	}
}