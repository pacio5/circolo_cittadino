package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.Color;

public class InsertSpillView {

	private JFrame frameInsVersamento;
	private JComboBox<String> cmbbxSocio;
	private JTextField txtFieldCodFisc;
	private JTextField txtFieldModPagamento;
	private JTextField txtFieldMetPagamento;
	private JTextField txtFieldTipologia;
	private JTextField txtFieldTelefono;
	private JTextField txtFieldEmail;
	private JTextField txtFieldData;
	private JTextField txtFieldImporto;
	private JTextArea txtAreaDescrizione;
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
	private JButton btnInserisci;
	private JButton btnAzzera;
	private JButton btnDashboard;

	/**
	 * Create the application.
	 */
	public InsertSpillView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameInsVersamento = new JFrame();
		frameInsVersamento.setBounds(100, 100, 800, 600);
		frameInsVersamento.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameInsVersamento.getContentPane().setLayout(null);

		JLabel lblIntroduzione = new JLabel("descrizione");
		lblIntroduzione.setBounds(10, 11, 633, 82);

		JLabel lblSocio = new JLabel("Socio");
		lblSocio.setBounds(10, 109, 46, 14);

		cmbbxSocio = new JComboBox<String>();
		cmbbxSocio.setBounds(49, 106, 233, 20);
		cmbbxSocio.setSelectedIndex(-1);

		JLabel lblCodFiscale = new JLabel("Cod. Fiscale:");
		lblCodFiscale.setBounds(10, 167, 72, 14);

		txtFieldCodFisc = new JTextField();
		txtFieldCodFisc.setEnabled(false);
		txtFieldCodFisc.setBounds(85, 166, 134, 17);
		txtFieldCodFisc.setColumns(10);
		txtFieldCodFisc.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtFieldCodFisc.setBackground(null);
		txtFieldCodFisc.setDisabledTextColor(Color.black);

		JLabel lblModalitaPagamento = new JLabel("Modal. pagamento:");
		lblModalitaPagamento.setBounds(10, 192, 107, 14);

		txtFieldModPagamento = new JTextField();
		txtFieldModPagamento.setEnabled(false);
		txtFieldModPagamento.setBounds(119, 191, 120, 17);
		txtFieldModPagamento.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtFieldModPagamento.setColumns(10);
		txtFieldModPagamento.setBackground(null);
		txtFieldModPagamento.setDisabledTextColor(Color.black);

		JLabel lblMetodoPagamento = new JLabel("Met. pagamento:");
		lblMetodoPagamento.setBounds(10, 217, 107, 14);

		txtFieldMetPagamento = new JTextField();
		txtFieldMetPagamento.setEnabled(false);
		txtFieldMetPagamento.setColumns(10);
		txtFieldMetPagamento.setBounds(110, 216, 86, 17);
		txtFieldMetPagamento.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtFieldMetPagamento.setBackground(null);
		txtFieldMetPagamento.setDisabledTextColor(Color.black);

		JLabel lblTipologia = new JLabel("Tipologia:");
		lblTipologia.setBounds(10, 242, 54, 14);

		txtFieldTipologia = new JTextField();
		txtFieldTipologia.setEnabled(false);
		txtFieldTipologia.setColumns(10);
		txtFieldTipologia.setBounds(66, 241, 153, 17);
		txtFieldTipologia.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtFieldTipologia.setBackground(null);
		txtFieldTipologia.setDisabledTextColor(Color.black);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(10, 267, 54, 14);

		txtFieldTelefono = new JTextField();
		txtFieldTelefono.setEnabled(false);
		txtFieldTelefono.setColumns(10);
		txtFieldTelefono.setBounds(66, 266, 153, 17);
		txtFieldTelefono.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtFieldTelefono.setBackground(null);
		txtFieldTelefono.setDisabledTextColor(Color.black);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 292, 46, 14);

		txtFieldEmail = new JTextField();
		txtFieldEmail.setEnabled(false);
		txtFieldEmail.setColumns(10);
		txtFieldEmail.setBounds(49, 290, 170, 17);
		txtFieldEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtFieldEmail.setBackground(null);
		txtFieldEmail.setDisabledTextColor(Color.black);

		JLabel lblData = new JLabel("Data");
		lblData.setBounds(415, 106, 54, 14);

		txtFieldData = new JTextField();
		txtFieldData.setColumns(10);
		txtFieldData.setBounds(475, 104, 86, 17);

		JLabel lblImporto = new JLabel("Importo");
		lblImporto.setBounds(415, 241, 54, 14);

		txtFieldImporto = new JTextField();
		txtFieldImporto.setEnabled(false);
		txtFieldImporto.setColumns(10);
		txtFieldImporto.setBounds(475, 239, 86, 17);
		txtFieldImporto.setDisabledTextColor(Color.black);
		txtFieldImporto.setText("0.0");

		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setBounds(391, 276, 78, 14);

		txtAreaDescrizione = new JTextArea();
		txtAreaDescrizione.setWrapStyleWord(true);
		txtAreaDescrizione.setFont(new Font("Monospaced", Font.PLAIN, 11));
		txtAreaDescrizione.setLineWrap(true);
		txtAreaDescrizione.setBounds(479, 273, 164, 132);
		txtAreaDescrizione.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		chckbxGennaio = new JCheckBox("Gennaio");
		chckbxGennaio.setBounds(412, 127, 73, 23);

		chckbxFebbraio = new JCheckBox("Febbraio");
		chckbxFebbraio.setBounds(496, 127, 91, 23);

		chckbxMarzo = new JCheckBox("Marzo");
		chckbxMarzo.setBounds(584, 129, 73, 23);

		chckbxAprile = new JCheckBox("Aprile");
		chckbxAprile.setBounds(412, 152, 73, 23);

		chckbxMaggio = new JCheckBox("Maggio");
		chckbxMaggio.setBounds(496, 152, 73, 23);

		chckbxGiugno = new JCheckBox("Giugno");
		chckbxGiugno.setBounds(584, 154, 73, 23);

		chckbxLuglio = new JCheckBox("Luglio");
		chckbxLuglio.setBounds(412, 177, 73, 23);

		chckbxAgosto = new JCheckBox("Agosto");
		chckbxAgosto.setBounds(496, 177, 73, 23);

		chckbxSettembre = new JCheckBox("Settembre");
		chckbxSettembre.setBounds(584, 177, 97, 23);

		chckbxOttobre = new JCheckBox("Ottobre");
		chckbxOttobre.setBounds(412, 202, 73, 23);

		chckbxNovembre = new JCheckBox("Novembre");
		chckbxNovembre.setBounds(496, 202, 91, 23);

		chckbxDicembre = new JCheckBox("Dicembre");
		chckbxDicembre.setBounds(584, 202, 97, 23);

		btnInserisci = new JButton("Inserisci");
		btnInserisci.setBounds(54, 332, 89, 23);

		btnAzzera = new JButton("Azzera");
		btnAzzera.setBounds(165, 332, 89, 23);

		btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(654, 11, 120, 33);

		frameInsVersamento.getContentPane().setLayout(null);
		frameInsVersamento.getContentPane().add(lblIntroduzione);
		frameInsVersamento.getContentPane().add(lblSocio);
		frameInsVersamento.getContentPane().add(cmbbxSocio);
		frameInsVersamento.getContentPane().add(lblCodFiscale);
		frameInsVersamento.getContentPane().add(txtFieldCodFisc);
		frameInsVersamento.getContentPane().add(lblModalitaPagamento);
		frameInsVersamento.getContentPane().add(txtFieldModPagamento);
		frameInsVersamento.getContentPane().add(lblMetodoPagamento);
		frameInsVersamento.getContentPane().add(txtFieldMetPagamento);
		frameInsVersamento.getContentPane().add(lblTipologia);
		frameInsVersamento.getContentPane().add(txtFieldTipologia);
		frameInsVersamento.getContentPane().add(lblTelefono);
		frameInsVersamento.getContentPane().add(txtFieldTelefono);
		frameInsVersamento.getContentPane().add(lblEmail);
		frameInsVersamento.getContentPane().add(txtFieldEmail);
		frameInsVersamento.getContentPane().add(lblData);
		frameInsVersamento.getContentPane().add(txtFieldData);
		frameInsVersamento.getContentPane().add(lblImporto);
		frameInsVersamento.getContentPane().add(txtFieldImporto);
		frameInsVersamento.getContentPane().add(lblDescrizione);
		frameInsVersamento.getContentPane().add(txtAreaDescrizione);
		frameInsVersamento.getContentPane().add(chckbxGennaio);
		frameInsVersamento.getContentPane().add(chckbxFebbraio);
		frameInsVersamento.getContentPane().add(chckbxMarzo);
		frameInsVersamento.getContentPane().add(chckbxAprile);
		frameInsVersamento.getContentPane().add(chckbxMaggio);
		frameInsVersamento.getContentPane().add(chckbxGiugno);
		frameInsVersamento.getContentPane().add(chckbxLuglio);
		frameInsVersamento.getContentPane().add(chckbxAgosto);
		frameInsVersamento.getContentPane().add(chckbxSettembre);
		frameInsVersamento.getContentPane().add(chckbxOttobre);
		frameInsVersamento.getContentPane().add(chckbxNovembre);
		frameInsVersamento.getContentPane().add(chckbxDicembre);
		frameInsVersamento.getContentPane().add(btnInserisci);
		frameInsVersamento.getContentPane().add(btnAzzera);
		frameInsVersamento.getContentPane().add(btnDashboard);
	}

	public JFrame getFrameInsVersamento() {
		return frameInsVersamento;
	}

	public JComboBox<String> getCmbbxSocio() {
		return cmbbxSocio;
	}

	public JTextField getTxtFieldCodFisc() {
		return txtFieldCodFisc;
	}

	public JTextField getTxtFieldModPagamento() {
		return txtFieldModPagamento;
	}

	public JTextField getTxtFieldMetPagamento() {
		return txtFieldMetPagamento;
	}

	public JTextField getTxtFieldTipologia() {
		return txtFieldTipologia;
	}

	public JTextField getTxtFieldTelefono() {
		return txtFieldTelefono;
	}

	public JTextField getTxtFieldEmail() {
		return txtFieldEmail;
	}

	public JTextField getTxtFieldData() {
		return txtFieldData;
	}

	public JTextField getTxtFieldImporto() {
		return txtFieldImporto;
	}

	public JTextArea getTxtFieldDescrizione() {
		return txtAreaDescrizione;
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

	public int getNumberChckbxChecked() {
		int cont = 0;
		if (chckbxGennaio.isSelected())
			cont++;
		if (chckbxFebbraio.isSelected())
			cont++;
		if (chckbxMarzo.isSelected())
			cont++;
		if (chckbxAprile.isSelected())
			cont++;
		if (chckbxMaggio.isSelected())
			cont++;
		if (chckbxGiugno.isSelected())
			cont++;
		if (chckbxLuglio.isSelected())
			cont++;
		if (chckbxAgosto.isSelected())
			cont++;
		if (chckbxSettembre.isSelected())
			cont++;
		if (chckbxOttobre.isSelected())
			cont++;
		if (chckbxNovembre.isSelected())
			cont++;
		if (chckbxDicembre.isSelected())
			cont++;
		return cont;
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
