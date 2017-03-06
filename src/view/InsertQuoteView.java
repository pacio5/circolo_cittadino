package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;

public class InsertQuoteView {

	private JFrame frame;
	private JTextField txtFieldDataIPre;
	private JTextField txtFieldDataFPre;
	private JTextField txtFieldValorePre;
	private JTextField txtFieldDataI;
	private JTextField txtFieldDataF;
	private JTextField txtFieldValore;
	private JComboBox<String> cmbbxTipologia;
	private JButton btnInserisci;
	private JButton btnAzzera;
	private JButton btnDashboard;

	/**
	 * Create the application.
	 */
	public InsertQuoteView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
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
				new String[] { "Ordinario", "Straordinario", "Benemerito", "Onorario" }));
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

		JLabel lblDataFPre = new JLabel("Data fine:");
		lblDataFPre.setBounds(10, 215, 72, 14);

		txtFieldDataFPre = new JTextField();
		txtFieldDataFPre.setEnabled(false);
		txtFieldDataFPre.setBounds(79, 214, 86, 17);
		txtFieldDataFPre.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtFieldDataFPre.setColumns(10);
		txtFieldDataFPre.setBackground(null);
		txtFieldDataFPre.setDisabledTextColor(Color.black);

		JLabel lblValorePre = new JLabel("Valore:");
		lblValorePre.setBounds(10, 240, 72, 14);

		txtFieldValorePre = new JTextField();
		txtFieldValorePre.setEnabled(false);
		txtFieldValorePre.setColumns(10);
		txtFieldValorePre.setBounds(79, 239, 86, 17);
		txtFieldValorePre.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtFieldValorePre.setBackground(null);
		txtFieldValorePre.setDisabledTextColor(Color.black);
		
		JLabel lblDataInizio = new JLabel("Data inizio");
		lblDataInizio.setBounds(352, 122, 59, 20);
		
		txtFieldDataI = new JTextField();
		txtFieldDataI.setBounds(421, 122, 86, 20);
		txtFieldDataI.setColumns(10);
		
		JLabel lblDataFine = new JLabel("Data fine");
		lblDataFine.setBounds(352, 153, 59, 20);
		
		txtFieldDataF = new JTextField();
		txtFieldDataF.setBounds(421, 153, 86, 20);
		txtFieldDataF.setColumns(10);
		
		JLabel lblValore = new JLabel("Valore");
		lblValore.setBounds(352, 184, 59, 20);
		
		txtFieldValore = new JTextField();
		txtFieldValore.setColumns(10);
		txtFieldValore.setBounds(421, 184, 86, 20);
		
		JLabel lblValoreEDurata = new JLabel("Valore e durata quota precendente");
		lblValoreEDurata.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblValoreEDurata.setBounds(10, 165, 206, 14);
		
		btnInserisci = new JButton("Inserisci");
		btnInserisci.setBounds(352, 236, 89, 23);
		
		btnAzzera = new JButton("Azzera");
		btnAzzera.setBounds(458, 236, 89, 23);
		
		btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(654, 11, 120, 33);
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblIntroduzione);
		frame.getContentPane().add(lblDataInizio);
		frame.getContentPane().add(txtFieldDataI);
		frame.getContentPane().add(lblDataFine);
		frame.getContentPane().add(txtFieldDataF);
		frame.getContentPane().add(lblValore);
		frame.getContentPane().add(txtFieldValore);
		frame.getContentPane().add(cmbbxTipologia);
		frame.getContentPane().add(lblDataIPre);
		frame.getContentPane().add(txtFieldDataIPre);
		frame.getContentPane().add(lblDataFPre);
		frame.getContentPane().add(txtFieldDataFPre);
		frame.getContentPane().add(lblValorePre);
		frame.getContentPane().add(txtFieldValorePre);
		frame.getContentPane().add(lblValoreEDurata);
		frame.getContentPane().add(btnInserisci);
		frame.getContentPane().add(btnAzzera);
		frame.getContentPane().add(btnDashboard);
	}

	public JFrame getFrame() {
		return frame;
	}

	public JTextField getTxtFieldDataI() {
		return txtFieldDataI;
	}

	public JTextField getTxtFieldDataF() {
		return txtFieldDataF;
	}

	public JTextField getTxtFieldValore() {
		return txtFieldValore;
	}

	public JComboBox<String> getCmbbxTipologia() {
		return cmbbxTipologia;
	}
	
	public JTextField getTxtFieldDataIPre() {
		return txtFieldDataIPre;
	}

	public JTextField getTxtFieldDataFPre() {
		return txtFieldDataFPre;
	}

	public JTextField getTxtFieldValorePre() {
		return txtFieldValorePre;
	}
	
	public JButton getBtnInserisci() {
		return btnInserisci;
	}
	
	public JButton getBtnAzzera() {
		return btnAzzera;
	}
	
	public JButton getBtnDashboard() {
		return btnDashboard;
	}
}
