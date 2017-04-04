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
 *Classe BadgeView, si occupa di visualizzare la finestra per creare il badge di un singolo socio, 
 */

public class BadgeView {

	private JFrame frameBadge;
	private JButton btnCreaPdfBadge;
	private JComboBox<String> comboBoxSocio;
	private JTextField textFieldCodFisc;
	private JTextField textFieldTipologia;
	private JTextField textFieldDataNascita;
	private JTextField textFieldCitta;
	
	/**
	 * Costruttore BadgeView, si occupa di visualizzare le informazioni di un singolo socio 
	 * e inizializza tutte le proprietà
	 */

	public BadgeView() {
		frameBadge = new JFrame();
		frameBadge.setType(Type.POPUP);
		frameBadge.setTitle("Badge");
		frameBadge.setBounds(100, 100, 460, 339);
		frameBadge.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameBadge.getContentPane().setLayout(null);
		
		JLabel lblSocio = new JLabel("Socio:");
		lblSocio.setBounds(10, 69, 46, 14);
		frameBadge.getContentPane().add(lblSocio);
		
		comboBoxSocio = new JComboBox<String>();
		comboBoxSocio.setBounds(55, 66, 275, 20);
		frameBadge.getContentPane().add(comboBoxSocio);
		
		JLabel lblCodFiscale = new JLabel("Cod. Fiscale:");
		lblCodFiscale.setBounds(10, 113, 106, 14);
		frameBadge.getContentPane().add(lblCodFiscale);
		
		JLabel lblCitta = new JLabel("Citt\u00E0:");
		lblCitta.setBounds(10, 188, 106, 14);
		frameBadge.getContentPane().add(lblCitta);
		
		JLabel lblTipologia = new JLabel("Tipologia:");
		lblTipologia.setBounds(10, 138, 106, 14);
		frameBadge.getContentPane().add(lblTipologia);
		
		JLabel lblDataNascita = new JLabel("Data di Nascita:");
		lblDataNascita.setBounds(10, 163, 106, 14);
		frameBadge.getContentPane().add(lblDataNascita);
		
		
		textFieldCodFisc = new JTextField();
		textFieldCodFisc.setBackground(null);
		textFieldCodFisc.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textFieldCodFisc.setEnabled(false);
		textFieldCodFisc.setBounds(115, 112, 267, 17);
		frameBadge.getContentPane().add(textFieldCodFisc);
		textFieldCodFisc.setColumns(10);
		textFieldCodFisc.setDisabledTextColor(Color.black);
		
		textFieldTipologia = new JTextField();
		textFieldTipologia.setBackground(null);
		textFieldTipologia.setEnabled(false);
		textFieldTipologia.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textFieldTipologia.setBounds(115, 137, 267, 17);
		frameBadge.getContentPane().add(textFieldTipologia);
		textFieldTipologia.setColumns(10);
		textFieldTipologia.setDisabledTextColor(Color.black);
		
		textFieldDataNascita = new JTextField();
		textFieldDataNascita.setBackground(null);
		textFieldDataNascita.setEnabled(false);
		textFieldDataNascita.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textFieldDataNascita.setBounds(115, 162, 267, 17);
		frameBadge.getContentPane().add(textFieldDataNascita);
		textFieldDataNascita.setColumns(10);
		textFieldDataNascita.setDisabledTextColor(Color.black);
		
		textFieldCitta = new JTextField();
		textFieldCitta.setBackground(null);
		textFieldCitta.setEnabled(false);
		textFieldCitta.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textFieldCitta.setBounds(115, 187, 267, 17);
		frameBadge.getContentPane().add(textFieldCitta);
		textFieldCitta.setColumns(10);
		textFieldCitta.setDisabledTextColor(Color.black);
		
		btnCreaPdfBadge = new JButton("Crea PDF Badge");
		btnCreaPdfBadge.setBounds(166, 223, 127, 47);
		frameBadge.getContentPane().add(btnCreaPdfBadge);
	}

	/**
	 * @return frame (JFrame)
	 */
	
	public JFrame getFrameBadge() {
		return frameBadge;
	}
	
	/**
	 * @return bottone per creare e salvare il pdf del badge di un socio (JButton)
	 */

	public JButton getBtnCreaPdfBadge() {
		return btnCreaPdfBadge;
	}
	
	/**
	 * @return comboBoxSocio dei soci presenti nel database (JComboBox<String>)
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
	
}
