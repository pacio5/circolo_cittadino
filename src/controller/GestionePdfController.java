package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.PDFView;

public class GestionePdfController {
	private PDFView pdfView;

	public GestionePdfController() {
		pdfView = new PDFView();
		pdfView.getFrameGestionePdf().setVisible(true);
	}

	public void gestionePdf() {
		pdfView.getBtnPdfBadge().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SalvaPdfController pdfController = new SalvaPdfController();
				pdfController.gestioneBadge();
			}
		});

		pdfView.getBtnPdfBiglietti().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SalvaPdfController pdfController = new SalvaPdfController();
				pdfController.gestioneBiglietto();
			}
		});

		pdfView.getBtnPdfPartecipanti().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SalvaPdfController pdfController = new SalvaPdfController();
				pdfController.gestioneBiglietto();
			}
		});

	}

}
