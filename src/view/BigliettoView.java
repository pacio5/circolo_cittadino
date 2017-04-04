package view;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Window.Type;

/**
 * @author simoneonori
 * @author eliapacioni
 * @author riccardosmerilli
 * @author francescotalento
 *
 * Classe BigliettoView, si occupa di visualizzare la finestra per creare il biglietto
 * di auguri per il compleanno del socio che compie gli anni. 
 */

public class BigliettoView {

	private JFrame frameBiglietto;
	private JButton btnCreaPdfBiglietto;
	private JComboBox<String> comboBoxSocio;
	private JTextField textFieldCodFisc;
	private JTextField textFieldTipologia;
	private JTextField textFieldDataNascita;
	private JTextField textFieldCitta;
	private JTextField textFieldIndirizzo;
	
	/**
	 * Costruttore BigliettoView, si occupa di visualizzare le informazioni di un singolo socio 
	 */

	
	public BigliettoView() {
		initialize();
	}
	
	/**
	 * inizializzazione proprietà
	 */

	private void initialize() {
		frameBiglietto = new JFrame();
		frameBiglietto.setType(Type.POPUP);
		frameBiglietto.setTitle("Biglietto Auguri");
		frameBiglietto.setBounds(100, 100, 460, 339);
		frameBiglietto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameBiglietto.getContentPane().setLayout(null);
		
		JLabel lblSocio = new JLabel("Socio:");
		lblSocio.setBounds(10, 69, 46, 14);
		frameBiglietto.getContentPane().add(lblSocio);
		
		comboBoxSocio = new JComboBox<String>();
		comboBoxSocio.setBounds(55, 66, 275, 20);
		frameBiglietto.getContentPane().add(comboBoxSocio);
		
		JLabel lblCodFiscale = new JLabel("Cod. Fiscale:");
		lblCodFiscale.setBounds(10, 113, 106, 14);
		frameBiglietto.getContentPane().add(lblCodFiscale);
		
		JLabel lblCitta = new JLabel("Citt\u00E0:");
		lblCitta.setBounds(10, 188, 106, 14);
		frameBiglietto.getContentPane().add(lblCitta);
		
		JLabel lblTipologia = new JLabel("Tipologia:");
		lblTipologia.setBounds(10, 138, 106, 14);
		frameBiglietto.getContentPane().add(lblTipologia);
		
		JLabel lblDataNascita = new JLabel("Data di Nascita:");
		lblDataNascita.setBounds(10, 163, 106, 14);
		frameBiglietto.getContentPane().add(lblDataNascita);
		
		
		textFieldCodFisc = new JTextField();
		textFieldCodFisc.setBackground(null);
		textFieldCodFisc.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textFieldCodFisc.setEnabled(false);
		textFieldCodFisc.setBounds(115, 112, 275, 17);
		frameBiglietto.getContentPane().add(textFieldCodFisc);
		textFieldCodFisc.setColumns(10);
		textFieldCodFisc.setDisabledTextColor(Color.black);
		
		textFieldTipologia = new JTextField();
		textFieldTipologia.setBackground(null);
		textFieldTipologia.setEnabled(false);
		textFieldTipologia.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textFieldTipologia.setBounds(115, 137, 275, 17);
		frameBiglietto.getContentPane().add(textFieldTipologia);
		textFieldTipologia.setColumns(10);
		textFieldTipologia.setDisabledTextColor(Color.black);
		
		textFieldDataNascita = new JTextField();
		textFieldDataNascita.setBackground(null);
		textFieldDataNascita.setEnabled(false);
		textFieldDataNascita.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textFieldDataNascita.setBounds(115, 162, 275, 17);
		frameBiglietto.getContentPane().add(textFieldDataNascita);
		textFieldDataNascita.setColumns(10);
		textFieldDataNascita.setDisabledTextColor(Color.black);
		
		textFieldCitta = new JTextField();
		textFieldCitta.setBackground(null);
		textFieldCitta.setEnabled(false);
		textFieldCitta.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textFieldCitta.setBounds(115, 187, 275, 17);
		frameBiglietto.getContentPane().add(textFieldCitta);
		textFieldCitta.setColumns(10);
		textFieldCitta.setDisabledTextColor(Color.black);
		
		btnCreaPdfBiglietto = new JButton("Crea PDF Biglietto");
		btnCreaPdfBiglietto.setBounds(166, 242, 164, 47);
		frameBiglietto.getContentPane().add(btnCreaPdfBiglietto);
		
		JLabel lblIndirizzo = new JLabel("Indirizzo: ");
		lblIndirizzo.setBounds(10, 213, 79, 14);
		frameBiglietto.getContentPane().add(lblIndirizzo);
		
		textFieldIndirizzo = new JTextField();
		textFieldIndirizzo.setBackground(null);
		textFieldIndirizzo.setEnabled(false);
		textFieldIndirizzo.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textFieldIndirizzo.setBounds(115, 211, 275, 20);
		frameBiglietto.getContentPane().add(textFieldIndirizzo);
		textFieldIndirizzo.setColumns(10);
		textFieldIndirizzo.setDisabledTextColor(Color.black);
	}
	
	/**
	 * @return frame (JFrame)
	 */

	public JFrame getFrameBiglietto() {
		return frameBiglietto;
	}

	/**
	 * @return bottone per creare e salvare il pdf del biglietto di auguri (JButton)
	 */
	
	public JButton getBtnCreaPdfBiglietto() {
		return btnCreaPdfBiglietto;
	}

	/**
	 * @return comboBoxSocio dei soci che compiono gli anni nei successivi sette giorni (JComboBox<String>)
	 */
	
	public JComboBox<String> getComboBoxSocio() {
		return comboBoxSocio;
	}
	
	/**
	 * @return textFieldCodFisc (JTextField)
	 */

	public JTextField getTextFieldCodFisc() {
		return textFieldCodFisc;
	}

	/**
	 * @return textFieldTipologia (JTextField)
	 */
	
	public JTextField getTextFieldTipologia() {
		return textFieldTipologia;
	}

	/**
	 * @return textFieldDataNascita (JTextField)
	 */
	
	public JTextField getTextFieldDataNascita() {
		return textFieldDataNascita;
	}

	/**
	 * @return textFieldCitta (JTextField)
	 */
	
	public JTextField getTextFieldCitta() {
		return textFieldCitta;
	}

	/**
	 * @return textFieldIndirizzo (JTextField)
	 */
	
	public JTextField getTextFieldIndirizzo() {
		return textFieldIndirizzo;
	}
	
	
}
