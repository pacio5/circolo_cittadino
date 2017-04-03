package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class PDFView {
	private JFrame frmGestionePdf;
	private JButton btnPdfBadge;
	private JButton btnPdfPartecipanti;
	private JButton btnPdfBiglietti;

	public PDFView() {

		frmGestionePdf = new JFrame();
		frmGestionePdf.setTitle("Crea PDF");
		frmGestionePdf.setResizable(false);
		frmGestionePdf.setBounds(100, 100, 550, 400);
		frmGestionePdf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		btnPdfBadge = new JButton("PDF BADGE");
		btnPdfBadge.setBounds(194, 136, 151, 43);

		btnPdfBiglietti = new JButton("PDF BIGLIETTI");
		btnPdfBiglietti.setBounds(194, 213, 151, 43);

		btnPdfPartecipanti = new JButton("PDF PARTECIPANTI");
		btnPdfPartecipanti.setBounds(194, 290, 151, 43);

		JLabel lblImg = new JLabel(new ImageIcon("./resources/circolo.png"));

		lblImg.setBounds(10, 11, 524, 100);

		frmGestionePdf.getContentPane().setLayout(null);
		frmGestionePdf.getContentPane().add(btnPdfBadge);
		frmGestionePdf.getContentPane().add(btnPdfBiglietti);
		frmGestionePdf.getContentPane().add(btnPdfPartecipanti);
		frmGestionePdf.getContentPane().add(lblImg);
	}

	public JFrame getFrameGestionePdf() {
		return frmGestionePdf;
	}

	public JButton getBtnPdfBadge() {
		return btnPdfBadge;
	}

	public JButton getBtnPdfBiglietti() {
		return btnPdfBiglietti;
	}

	public JButton getBtnPdfPartecipanti() {
		return btnPdfPartecipanti;
	}

}
