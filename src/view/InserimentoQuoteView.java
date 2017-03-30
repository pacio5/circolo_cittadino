package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;

/**
 * @author simoneonori
 * @author eliapacioni
 * @author riccardosmerilli
 * @author francescotalento
 * 
 * @version 1.0 Marzo 2017
 * 
 * 
 * Classe che si della definizione e visualizzazione della
 * finestra dell'inserimento delle quote e i relativi componenti
 */
public class InserimentoQuoteView {

	private JFrame frame;
	private JTextField txtFieldDataIPre;
	private JTextField txtFieldValorePre;
	private JTextField txtFieldDataI;
	private JTextField txtFieldValore;
	private JComboBox<String> cmbbxTipologia;
	private JButton btnInserisci;
	private JButton btnAzzera;
	private JButton btnDashboard;

	/**
	 * Creazione dell'applicazione
	 */
	public InserimentoQuoteView() {
		initialize();
	}

	/**
	 * Inizializzazione del contenuto del frame
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblIntroduzione = new JLabel("descrizione");
		lblIntroduzione.setBounds(10, 11, 634, 100);

		JLabel lblTipologia = new JLabel("Tipologia");
		lblTipologia.setBounds(10, 122, 59, 20);
		frame.getContentPane().add(lblTipologia);

		cmbbxTipologia = new JComboBox<String>();
		cmbbxTipologia.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Ordinario", "Straordinario", "Benemerito", "Onorario", "Giovane", "Piu giovane" }));
		cmbbxTipologia.setBounds(79, 122, 137, 20);
		cmbbxTipologia.setSelectedIndex(-1);

		JLabel lblDataIPre = new JLabel("Data inizio:");
		lblDataIPre.setBounds(10, 190, 72, 14);

		txtFieldDataIPre = new JTextField();
		txtFieldDataIPre.setEnabled(false);
		txtFieldDataIPre.setBounds(79, 189, 86, 17);
		txtFieldDataIPre.setColumns(10);
		txtFieldDataIPre.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtFieldDataIPre.setBackground(null);
		txtFieldDataIPre.setDisabledTextColor(Color.black);

		JLabel lblValorePre = new JLabel("Valore:");
		lblValorePre.setBounds(10, 216, 72, 14);

		txtFieldValorePre = new JTextField();
		txtFieldValorePre.setEnabled(false);
		txtFieldValorePre.setColumns(10);
		txtFieldValorePre.setBounds(79, 215, 86, 17);
		txtFieldValorePre.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtFieldValorePre.setBackground(null);
		txtFieldValorePre.setDisabledTextColor(Color.black);

		JLabel lblDataInizio = new JLabel("Data inizio");
		lblDataInizio.setBounds(350, 165, 59, 20);

		txtFieldDataI = new JTextField();
		txtFieldDataI.setBounds(419, 165, 86, 20);
		txtFieldDataI.setColumns(10);

		JLabel lblValore = new JLabel("Valore");
		lblValore.setBounds(350, 196, 59, 20);

		txtFieldValore = new JTextField();
		txtFieldValore.setColumns(10);
		txtFieldValore.setBounds(419, 196, 86, 20);

		JLabel lblValoreEDurata = new JLabel("Valore e durata quota precendente");
		lblValoreEDurata.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblValoreEDurata.setBounds(10, 165, 206, 14);

		btnInserisci = new JButton("Inserisci");
		btnInserisci.setBounds(350, 248, 89, 23);

		btnAzzera = new JButton("Azzera");
		btnAzzera.setBounds(456, 248, 89, 23);

		btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(654, 11, 120, 33);

		JLabel lblFormatoData = new JLabel("aaaa/mm");
		lblFormatoData.setBounds(515, 168, 72, 14);

		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblIntroduzione);
		frame.getContentPane().add(lblDataInizio);
		frame.getContentPane().add(txtFieldDataI);
		frame.getContentPane().add(lblValore);
		frame.getContentPane().add(txtFieldValore);
		frame.getContentPane().add(cmbbxTipologia);
		frame.getContentPane().add(lblDataIPre);
		frame.getContentPane().add(txtFieldDataIPre);
		frame.getContentPane().add(lblValorePre);
		frame.getContentPane().add(txtFieldValorePre);
		frame.getContentPane().add(lblValoreEDurata);
		frame.getContentPane().add(btnInserisci);
		frame.getContentPane().add(btnAzzera);
		frame.getContentPane().add(btnDashboard);
		frame.getContentPane().add(lblFormatoData);
	}

	/**
	 * @return frame (JFrame)
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @return txtFieldDataI (JTextField)
	 */
	public JTextField getTxtFieldDataI() {
		return txtFieldDataI;
	}

	/**
	 * @return txtFieldValore (JTextField)
	 */
	public JTextField getTxtFieldValore() {
		return txtFieldValore;
	}

	/**
	 * @return cmbbxTipologia (JTextField)
	 */
	public JComboBox<String> getCmbbxTipologia() {
		return cmbbxTipologia;
	}

	/**
	 * @return txtFieldDataIPre (JTextField)
	 */
	public JTextField getTxtFieldDataIPre() {
		return txtFieldDataIPre;
	}

	/**
	 * @return txtFieldValorePre (JTextField)
	 */
	public JTextField getTxtFieldValorePre() {
		return txtFieldValorePre;
	}

	/**
	 * @return btnInserisci (JButton)
	 */
	public JButton getBtnInserisci() {
		return btnInserisci;
	}

	/**
	 * @return btnAzzera (JButton)
	 */
	public JButton getBtnAzzera() {
		return btnAzzera;
	}

	/**
	 * @return btnDashboard (JButton)
	 */
	public JButton getBtnDashboard() {
		return btnDashboard;
	}
}
