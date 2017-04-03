package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

import entita.Evento;

import java.awt.Color;
import java.awt.Window.Type;

/**
 * @author Francesco
 *
 */
public class PartecipantiView {

	private JFrame framePartecipanti;
	private JButton btnCreaPdfLista;
	private JComboBox<Evento> comboBoxEventi;
	private JTextField textFieldLuogo;
	private JTextField textFieldData;
	private JTextField textFieldNposti;

	public PartecipantiView() {
		framePartecipanti = new JFrame();
		framePartecipanti.setType(Type.POPUP);
		framePartecipanti.setTitle("Lista Partecipanti");
		framePartecipanti.setBounds(100, 100, 460, 339);
		framePartecipanti.setResizable(false);
		framePartecipanti.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		framePartecipanti.getContentPane().setLayout(null);
		
		JLabel lblEvento = new JLabel("Evento:");
		lblEvento.setBounds(10, 69, 46, 14);

		comboBoxEventi = new JComboBox<Evento>();
		comboBoxEventi.setBounds(55, 66, 275, 20);

		JLabel lblLuogo = new JLabel("Luogo:");
		lblLuogo.setBounds(10, 113, 63, 14);
		
		textFieldLuogo = new JTextField();
		textFieldLuogo.setBackground(null);
		textFieldLuogo.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textFieldLuogo.setEnabled(false);
		textFieldLuogo.setBounds(115, 112, 154, 17);
		textFieldLuogo.setColumns(10);
		textFieldLuogo.setDisabledTextColor(Color.black);

		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(10, 138, 46, 14);
		
		textFieldData = new JTextField();
		textFieldData.setBackground(null);
		textFieldData.setEnabled(false);
		textFieldData.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textFieldData.setBounds(115, 137, 154, 17);
		textFieldData.setColumns(10);
		textFieldData.setDisabledTextColor(Color.black);

		JLabel lblNposti = new JLabel("Numero Posti:");
		lblNposti.setBounds(10, 163, 106, 14);
		
		textFieldNposti = new JTextField();
		textFieldNposti.setBackground(null);
		textFieldNposti.setEnabled(false);
		textFieldNposti.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textFieldNposti.setBounds(115, 162, 154, 17);
		textFieldNposti.setColumns(10);
		textFieldNposti.setDisabledTextColor(Color.black);

		btnCreaPdfLista = new JButton("Crea PDF Lista");
		btnCreaPdfLista.setBounds(166, 223, 127, 47);

		framePartecipanti.getContentPane().add(lblEvento);
		framePartecipanti.getContentPane().add(comboBoxEventi);
		framePartecipanti.getContentPane().add(lblLuogo);
		framePartecipanti.getContentPane().add(textFieldLuogo);
		framePartecipanti.getContentPane().add(lblData);
		framePartecipanti.getContentPane().add(textFieldData);
		framePartecipanti.getContentPane().add(lblNposti);
		framePartecipanti.getContentPane().add(textFieldNposti);
		framePartecipanti.getContentPane().add(btnCreaPdfLista);
		
	}
	
	public JFrame getFramePartecipanti() {
		return framePartecipanti;
	}

	public JComboBox<Evento> getComboBoxEventi() {
		return comboBoxEventi;
	}

	public JTextField getTextFieldLuogo() {
		return textFieldLuogo;
	}

	public JTextField getTextFieldData() {
		return textFieldData;
	}

	public JTextField getTextFieldNposti() {
		return textFieldNposti;
	}
	
	public JButton getBtnCreaPdfLista() {
		return btnCreaPdfLista;
	}
}