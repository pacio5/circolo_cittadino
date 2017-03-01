package view;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import entita.Socio;

public class InserisciFiglioView {

	private JFrame frame;
	private JTextField cf;
	private JTextField nome;
	private JTextField dataNascita;
	private JComboBox<Socio> socio;
	private ButtonGroup aCarico;
	private JButton btnInserisci;
	private JRadioButton rdbtnSi;
	private JRadioButton rdbtnNo;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public InserisciFiglioView(ArrayList<Socio> soci) {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCf = new JLabel("Codice Fiscale");
		lblCf.setBounds(39, 82, 97, 16);
		frame.getContentPane().add(lblCf);
		
		cf = new JTextField();
		cf.setBounds(148, 77, 130, 26);
		frame.getContentPane().add(cf);
		cf.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(39, 143, 97, 16);
		frame.getContentPane().add(lblNome);
		
		nome = new JTextField();
		nome.setColumns(10);
		nome.setBounds(148, 138, 130, 26);
		frame.getContentPane().add(nome);
	
		JLabel lblDataDiNascita = new JLabel("Data di Nascita");
		lblDataDiNascita.setBounds(39, 206, 97, 16);
		frame.getContentPane().add(lblDataDiNascita);
		
		dataNascita = new JTextField();
		dataNascita.setColumns(10);
		dataNascita.setBounds(148, 201, 130, 26);
		frame.getContentPane().add(dataNascita);
		
		JLabel lblGenitore = new JLabel("Genitore");
		lblGenitore.setBounds(39, 273, 61, 16);
		frame.getContentPane().add(lblGenitore);
		
		socio = new JComboBox<Socio>();
		socio.setBounds(148, 269, 130, 27);
		soci.stream().forEach((s)->{
			socio.addItem(s);
		});
		frame.getContentPane().add(socio);
		
		JLabel lblACarico = new JLabel("A Carico");
		lblACarico.setBounds(39, 349, 61, 16);
		frame.getContentPane().add(lblACarico);
		
		rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setBounds(148, 345, 50, 23);
		frame.getContentPane().add(rdbtnSi);
		
		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(228, 345, 50, 23);
		rdbtnNo.setSelected(true);
		frame.getContentPane().add(rdbtnNo);
		
		aCarico = new ButtonGroup();
		aCarico.add(rdbtnSi);
		aCarico.add(rdbtnNo);
		
		btnInserisci = new JButton("Inserisci");
		btnInserisci.setBounds(98, 434, 117, 29);
		frame.getContentPane().add(btnInserisci);
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
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
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
	 * @return the dataNascita
	 */
	public JTextField getDataNascita() {
		return dataNascita;
	}

	/**
	 * @return the socio
	 */
	public JComboBox<Socio> getSocio() {
		return socio;
	}

	/**
	 * @return the aCarico
	 */
	public ButtonGroup getaCarico() {
		return aCarico;
	}

	/**
	 * @return the btnInserisci
	 */
	public JButton getBtnInserisci() {
		return btnInserisci;
	}
	
}
