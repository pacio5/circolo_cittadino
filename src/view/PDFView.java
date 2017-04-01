package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PDFView {
	private JFrame frmGestionePdf;
	private JButton btnPdfBadge;
	private JButton btnPdfPartecipanti;
	private JButton btnPdfBiglietti;

public PDFView(){
	
	JFrame frameGestionePdf = new JFrame();
	frameGestionePdf.setTitle("Gestione PDF");
	frmGestionePdf = frameGestionePdf;
	frmGestionePdf.setTitle("Gestione PDF");
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
	
	lblImg.setBounds(10,11,524,100);
	
	frameGestionePdf.getContentPane().setLayout(null);
	frameGestionePdf.getContentPane().add(btnPdfBadge);
	frameGestionePdf.getContentPane().add(btnPdfBiglietti);
	frameGestionePdf.getContentPane().add(btnPdfPartecipanti);
	frameGestionePdf.getContentPane().add(lblImg);
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
