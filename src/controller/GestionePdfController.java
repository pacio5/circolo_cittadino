package controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.UIManager;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import entita.Socio;
import model.SocioModel;
import view.BadgeView;
import view.BigliettoView;
import view.PDFView;

public class GestionePdfController {
	private PDFView pdfView;
	private BadgeView viewBadge;
	private BigliettoView viewBiglietto;
	private ArrayList<Socio> soci;
	private Font bigFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.ITALIC);
	private Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.ITALIC);
	private Font formalFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.ITALIC);

	public GestionePdfController() {
		pdfView = new PDFView();
		pdfView.getFrameGestionePdf().setVisible(true);
	}

	public void gestionePdf() {
		pdfView.getBtnPdfBadge().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				viewBadge = new BadgeView();
				viewBadge.getFrameBadge().setVisible(true);
				riempimentoComboBoxSociBadge();
				controlloEventiBadge();
			}
		});

		pdfView.getBtnPdfBiglietti().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				viewBiglietto = new BigliettoView();
				viewBiglietto.getFrameBiglietto().setVisible(true);
				riempimentoComboBoxSociBiglietto();
				controlloEventiBiglietto();
			}
		});

		pdfView.getBtnPdfPartecipanti().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				viewBiglietto = new BigliettoView();
				viewBiglietto.getFrameBiglietto().setVisible(true);
				riempimentoComboBoxSociBiglietto();
				controlloEventiBiglietto();
			}
		});
	}

	/**
	 * Metodo per visualizzare i soci presenti nel database del circolo
	 * visualizzandone il nome, cognome e cf
	 */

	void riempimentoComboBoxSociBadge() {
		SocioModel modelSocio = new SocioModel();
		soci = new ArrayList<Socio>(modelSocio.elencoSoci());
		for (int i = 0; i < soci.size(); i++)
			viewBadge.getComboBoxSocio()
					.addItem(soci.get(i).getNome() + " " + soci.get(i).getCognome() + " - " + soci.get(i).getCf());
		viewBadge.getComboBoxSocio().setSelectedIndex(-1);
	}

	/**
	 * Metodo per gestire gli eventi relativi alla creazione del badge
	 */

	private void controlloEventiBadge() {

		/**
		 * Metodo per visualizzare a schermo le informazioni principali(nome,
		 * cognome, cf, tipologia e citt�) del socio puntato nella combobox
		 */

		viewBadge.getComboBoxSocio().addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (viewBadge.getComboBoxSocio().getSelectedIndex() != -1) {
					viewBadge.getTextFieldCodFisc()
							.setText(soci.get(viewBadge.getComboBoxSocio().getSelectedIndex()).getCf());
					viewBadge.getTextFieldTipologia()
							.setText(soci.get(viewBadge.getComboBoxSocio().getSelectedIndex()).getTipologia());
					viewBadge.getTextFieldCitta()
							.setText(soci.get(viewBadge.getComboBoxSocio().getSelectedIndex()).getCitta());
					viewBadge.getTextFieldDataNascita().setText(
							soci.get(viewBadge.getComboBoxSocio().getSelectedIndex()).getDataNascita().toString());
				} else {
					viewBadge.getTextFieldCodFisc().setText("");
					viewBadge.getTextFieldTipologia().setText("");
					viewBadge.getTextFieldCitta().setText("");
					viewBadge.getTextFieldDataNascita().setText("");
				}

			}
		});

		/**
		 * Gestione evento per il funzionamento del tasto "Crea PDF" che porter�
		 * alla creazione e al salvataggio del badge in formato ID1 del socio
		 * puntato nella combobox
		 */
		viewBadge.getBtnCreaPdfBadge().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/**
				 * Blocco di codice contenente istruzioni che potrebbero
				 * generare un'eccezione se ci� non si verifica verr� creato e
				 * salvato il pdf, altrimenti verr� eseguito il blocco catch
				 * document � il container in formato ID1(ideale per Badge) che
				 * rappresenta un oggetto della classe Document
				 */
				try {
					String file = null;
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Document document = new Document(PageSize.ID_1);
					file = showSaveFileDialogBadge(document);
					PdfWriter.getInstance(document, new FileOutputStream(file + ".pdf"));
					document.open();
					aggiungiPrefazioneBadge(document);
					document.close();
					/**
					 * Utile per informare dove � stata rilevata l'eccezione
					 * all'interno del codice
					 */
				} catch (Exception p) {
					p.printStackTrace();
				}

			}
		});

	}

	/**
	 * Metodo per visualizzare a schermo la finestra di dialogo per effettuare
	 * il salvataggio del pdf
	 * 
	 * @param document
	 *            d� in input il documento pdf creato in precedenza
	 * @return il percorso di destinazione
	 */

	private String showSaveFileDialogBadge(Document document) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Salva Badge");
		File fileToSave = null;
		int userSelection = fileChooser.showSaveDialog(fileChooser);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			fileToSave = fileChooser.getSelectedFile();
		}
		return fileToSave.getAbsolutePath();
	}

	/**
	 * Metodo per creare il pdf relativo al badge del socio richiesto nella
	 * combobox formato da: nome, cognome, cf, tipologia socio e citt�
	 * attraverso la scrittura e il salvataggio delle informazioni nel documento
	 * 
	 * @param document
	 * 
	 * @throws DocumentException
	 *             Delega delle eccezioni gestite nel try... catch
	 */

	void aggiungiPrefazioneBadge(Document document) throws DocumentException {
		Paragraph prefazioneBadge = new Paragraph();

		prefazioneBadge.add(new Paragraph("CIRCOLO CITTADINO", bigFont));

		prefazioneBadge.add(new Paragraph(
				"Nome: " + soci.get(viewBadge.getComboBoxSocio().getSelectedIndex()).getNome(), smallBold));

		prefazioneBadge.add(new Paragraph(
				"Cognome: " + soci.get(viewBadge.getComboBoxSocio().getSelectedIndex()).getCognome(), smallBold));

		prefazioneBadge.add(
				new Paragraph("CF: " + soci.get(viewBadge.getComboBoxSocio().getSelectedIndex()).getCf(), smallBold));

		prefazioneBadge.add(new Paragraph(
				"Citt�: " + soci.get(viewBadge.getComboBoxSocio().getSelectedIndex()).getCitta(), smallBold));

		prefazioneBadge.add(new Paragraph(
				"Tipologia: " + soci.get(viewBadge.getComboBoxSocio().getSelectedIndex()).getTipologia(), smallBold));

		/**
		 * Aggiunta al documento
		 */

		document.add(prefazioneBadge);

	}

	/**
	 * Metodo per visualizzare i soci del circolo che compiono gli anni
	 * nell'immediato visualizzandone il nome, cognome e cf
	 */

	void riempimentoComboBoxSociBiglietto() {
		SocioModel modelSocio = new SocioModel();
		soci = new ArrayList<Socio>(modelSocio.elencoSoci());
		for (int i = 0; i < soci.size(); i++)
			viewBiglietto.getComboBoxSocio()
					.addItem(soci.get(i).getNome() + " " + soci.get(i).getCognome() + " - " + soci.get(i).getCf());
		viewBiglietto.getComboBoxSocio().setSelectedIndex(-1);
	}

	/**
	 * Metodo per gestire gli eventi relativi alla creazione del biglietto di
	 * auguri
	 */

	private void controlloEventiBiglietto() {

		/**
		 * Metodo per visualizzare a schermo le informazioni principali(nome,
		 * cognome, cf, tipologia, citt� e indirizzo) del socio puntato nella
		 * combobox
		 */

		viewBiglietto.getComboBoxSocio().addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (viewBiglietto.getComboBoxSocio().getSelectedIndex() != -1) {
					viewBiglietto.getTextFieldCodFisc()
							.setText(soci.get(viewBiglietto.getComboBoxSocio().getSelectedIndex()).getCf());
					viewBiglietto.getTextFieldTipologia()
							.setText(soci.get(viewBiglietto.getComboBoxSocio().getSelectedIndex()).getTipologia());
					viewBiglietto.getTextFieldCitta()
							.setText(soci.get(viewBiglietto.getComboBoxSocio().getSelectedIndex()).getCitta());
					viewBiglietto.getTextFieldDataNascita().setText(
							soci.get(viewBiglietto.getComboBoxSocio().getSelectedIndex()).getDataNascita().toString());
					viewBiglietto.getTextFieldIndirizzo()
							.setText(soci.get(viewBiglietto.getComboBoxSocio().getSelectedIndex()).getIndirizzo());

				} else {
					viewBiglietto.getTextFieldCodFisc().setText("");
					viewBiglietto.getTextFieldTipologia().setText("");
					viewBiglietto.getTextFieldCitta().setText("");
					viewBiglietto.getTextFieldDataNascita().setText("");
					viewBiglietto.getTextFieldIndirizzo().setText("");
				}

			}
		});

		/**
		 * Gestione evento per il funzionamento del tasto "Crea PDF Biglietto"
		 * che porter� alla creazione e al salvataggio del biglietto in formato
		 * ID3 del socio puntato nella combobox
		 */

		viewBiglietto.getBtnCreaPdfBiglietto().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/**
				 * Blocco di codice contenente istruzioni che potrebbero
				 * generare un'eccezione se ci� non si verifica verr� creato e
				 * salvato il pdf, altrimenti verr� eseguito il blocco catch
				 */
				try {
					String file = null;
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Document document = new Document(PageSize.ID_3);
					file = showSaveFileDialogBiglietto(document);
					PdfWriter.getInstance(document, new FileOutputStream(file + ".pdf"));
					document.open();
					aggiungiPrefazioneBiglietto(document);
					document.close();
					/**
					 * Utile per informare dove � stata rilevata l'eccezione
					 * all'interno del codice
					 */
				} catch (Exception p) {
					p.printStackTrace();
				}

			}
		});

	}

	/**
	 * Metodo per visualizzare a schermo la finestra di dialogo per effettuare
	 * il salvataggio del pdf
	 * 
	 * @param document
	 *            d� in input il documento pdf creato in precedenza
	 * @return il percorso di destinazione
	 */

	private String showSaveFileDialogBiglietto(Document document) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Salva Biglietto");
		File fileToSave = null;
		int userSelection = fileChooser.showSaveDialog(fileChooser);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			fileToSave = fileChooser.getSelectedFile();
		}
		return fileToSave.getAbsolutePath();
	}

	/**
	 * Metodo per creare il pdf relativo al badge del socio richiesto nella
	 * combobox formato da: nome, cognome, cf, tipologia socio e citt�
	 * attraverso la scrittura e il salvataggio delle informazioni nel documento
	 * 
	 * @param document
	 * 
	 * @throws DocumentException
	 *             Delega delle eccezioni gestite nel try... catch
	 */

	void aggiungiPrefazioneBiglietto(Document document) throws DocumentException {
		Paragraph prefazioneBiglietto = new Paragraph();

		prefazioneBiglietto.add(new Paragraph("CIRCOLO CITTADINO", bigFont));

		prefazioneBiglietto.add(new Paragraph(" "));

		prefazioneBiglietto.add(new Paragraph(" "));

		prefazioneBiglietto.add(new Paragraph(
				"Questo nostro piccolo pensiero sia per te un augurio sincero di buon compleanno!", formalFont));

		/**
		 * Aggiunta al documento
		 */

		document.add(prefazioneBiglietto);

	}

}
