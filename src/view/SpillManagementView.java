package view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class SpillManagementView {

	private JFrame frame;
	private JTable table;
	private JTextField txtFieldData;
	private JTextField txtFieldImporto;
	private JTextArea textAreaDescrizione;
	private JCheckBox chckbxGennaio;
	private JCheckBox chckbxFebbraio;
	private JCheckBox chckbxMarzo;
	private JCheckBox chckbxAprile;
	private JCheckBox chckbxMaggio;
	private JCheckBox chckbxGiugno;
	private JCheckBox chckbxLuglio;
	private JCheckBox chckbxAgosto;
	private JCheckBox chckbxSettembre;
	private JCheckBox chckbxOttobre;
	private JCheckBox chckbxNovembre;
	private JCheckBox chckbxDicembre;
	private JButton btnModifica;
	private JButton btnElimina;
	private JButton btnDashboard;
	
	/**
	 * Create the application.
	 */
	public SpillManagementView() {
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
		lblIntroduzione.setBounds(10, 11, 571, 42);
		
		table = new JTable();
		
		table.setBackground(null);
		table.setAutoResizeMode(4);
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(10,64,764,129);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(10, 228, 46, 14);
		
		
		JLabel lblImporto = new JLabel("Importo");
		lblImporto.setBounds(10, 253, 46, 14);
		
		
		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setBounds(10, 278, 59, 14);
		
		txtFieldData = new JTextField();
		txtFieldData.setBounds(79, 225, 86, 20);
		txtFieldData.setColumns(10);
		
		txtFieldImporto = new JTextField();
		txtFieldImporto.setBounds(79, 250, 86, 20);
		txtFieldImporto.setColumns(10);
		
		textAreaDescrizione = new JTextArea();
		textAreaDescrizione.setBounds(79, 273, 157, 136);
		textAreaDescrizione.setWrapStyleWord(true);
		textAreaDescrizione.setFont(new Font("Monospaced", Font.PLAIN, 11));
		textAreaDescrizione.setLineWrap(true);
		textAreaDescrizione.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		
		JLabel lblMesi = new JLabel("Mesi");
		lblMesi.setBounds(265, 226, 46, 20);
		
		chckbxGennaio = new JCheckBox("Gennaio");
		chckbxGennaio.setBounds(312, 225, 73, 23);
		frame.getContentPane().add(chckbxGennaio);
		
		chckbxFebbraio = new JCheckBox("Febbraio");
		chckbxFebbraio.setBounds(396, 225, 91, 23);
		frame.getContentPane().add(chckbxFebbraio);
		
		chckbxMarzo = new JCheckBox("Marzo");
		chckbxMarzo.setBounds(484, 227, 73, 23);
		frame.getContentPane().add(chckbxMarzo);
		
		chckbxAprile = new JCheckBox("Aprile");
		chckbxAprile.setBounds(312, 250, 73, 23);
		frame.getContentPane().add(chckbxAprile);
		
		chckbxMaggio = new JCheckBox("Maggio");
		chckbxMaggio.setBounds(396, 250, 73, 23);
		frame.getContentPane().add(chckbxMaggio);
		
		chckbxGiugno = new JCheckBox("Giugno");
		chckbxGiugno.setBounds(484, 252, 73, 23);
		frame.getContentPane().add(chckbxGiugno);
		
		chckbxLuglio = new JCheckBox("Luglio");
		chckbxLuglio.setBounds(312, 275, 73, 23);
		frame.getContentPane().add(chckbxLuglio);
		
		chckbxAgosto = new JCheckBox("Agosto");
		chckbxAgosto.setBounds(396, 275, 73, 23);
		frame.getContentPane().add(chckbxAgosto);
		
		chckbxSettembre = new JCheckBox("Settembre");
		chckbxSettembre.setBounds(484, 275, 97, 23);
		frame.getContentPane().add(chckbxSettembre);
		
		chckbxOttobre = new JCheckBox("Ottobre");
		chckbxOttobre.setBounds(312, 300, 73, 23);
		frame.getContentPane().add(chckbxOttobre);
		
		chckbxNovembre = new JCheckBox("Novembre");
		chckbxNovembre.setBounds(396, 300, 91, 23);
		frame.getContentPane().add(chckbxNovembre);
		
		chckbxDicembre = new JCheckBox("Dicembre");
		chckbxDicembre.setBounds(484, 300, 97, 23);
		frame.getContentPane().add(chckbxDicembre);
		
		btnModifica = new JButton("Modifica");
		btnModifica.setBounds(79, 460, 89, 23);
		
		btnElimina = new JButton("Elimina");
		btnElimina.setBounds(178, 460, 89, 23);
		
		btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(654, 11, 120, 33);
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblIntroduzione);
		frame.getContentPane().add(scroll);
		frame.getContentPane().add(lblData);
		frame.getContentPane().add(lblImporto);
		frame.getContentPane().add(lblDescrizione);
		frame.getContentPane().add(txtFieldData);
		frame.getContentPane().add(txtFieldImporto);
		frame.getContentPane().add(textAreaDescrizione);
		frame.getContentPane().add(lblMesi);
		frame.getContentPane().add(chckbxGennaio);
		frame.getContentPane().add(chckbxFebbraio);
		frame.getContentPane().add(chckbxMarzo);
		frame.getContentPane().add(chckbxAprile);
		frame.getContentPane().add(chckbxMaggio);
		frame.getContentPane().add(chckbxGiugno);
		frame.getContentPane().add(chckbxLuglio);
		frame.getContentPane().add(chckbxAgosto);
		frame.getContentPane().add(chckbxSettembre);
		frame.getContentPane().add(chckbxOttobre);
		frame.getContentPane().add(chckbxNovembre);
		frame.getContentPane().add(chckbxDicembre);
		frame.getContentPane().add(btnModifica);
		frame.getContentPane().add(btnElimina);
		frame.getContentPane().add(btnDashboard);
		
	}
	
	public JFrame getFrameGestVersamento (){
		return frame;
	}
	
	public JTable getTable () {
		return table;
	}

	public JTextField getTxtFieldData() {
		return txtFieldData;
	}

	public JTextField getTxtFieldImporto() {
		return txtFieldImporto;
	}

	public JTextArea getTextAreaDescrizione() {
		return textAreaDescrizione;
	}

	public JCheckBox getChckbxGennaio() {
		return chckbxGennaio;
	}

	public JCheckBox getChckbxFebbraio() {
		return chckbxFebbraio;
	}

	public JCheckBox getChckbxMarzo() {
		return chckbxMarzo;
	}

	public JCheckBox getChckbxAprile() {
		return chckbxAprile;
	}

	public JCheckBox getChckbxMaggio() {
		return chckbxMaggio;
	}

	public JCheckBox getChckbxGiugno() {
		return chckbxGiugno;
	}

	public JCheckBox getChckbxLuglio() {
		return chckbxLuglio;
	}

	public JCheckBox getChckbxAgosto() {
		return chckbxAgosto;
	}

	public JCheckBox getChckbxSettembre() {
		return chckbxSettembre;
	}

	public JCheckBox getChckbxOttobre() {
		return chckbxOttobre;
	}

	public JCheckBox getChckbxNovembre() {
		return chckbxNovembre;
	}

	public JCheckBox getChckbxDicembre() {
		return chckbxDicembre;
	}
	
	public JButton getBtnModifica() {
		return btnModifica;
	}
	
	public JButton getBtnElimina() {
		return btnElimina;
	}
	
	public JButton getBtnDashboard() {
		return btnDashboard;
	}
}
