package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entita.Convenzione;
import model.ConvenzioneModel;
import utility.Validator;
import view.GestioneConvenzioniView;

public class ConvenzioneController {
	private ConvenzioneModel model;

	public ConvenzioneController() {
		model = new ConvenzioneModel();
	}

	public void gestioneConvenzione() {
		GestioneConvenzioniView view = new GestioneConvenzioniView(model.listaConvenzioni());
		view.getFrame().setVisible(true);

		view.getList().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				view.getBtnModifica().setVisible(true);
				view.getBtnCancella().setVisible(true);
				view.getBtnInserisci().setVisible(false);
				view.getTextFieldRagioneSociale().setEnabled(false);
				view.getTextFieldIndirizzo().setEnabled(false);
				view.getTextAreaDescrizione().setEnabled(false);
				view.getTextFieldSconto().setEnabled(false);
				view.getBtnAnnullaModifiche().setVisible(true);

				Convenzione c = view.getList().getSelectedValue();
				view.getTextFieldRagioneSociale().setText(c.getRagioneSociale());
				view.getTextFieldIndirizzo().setText(c.getIndirizzo());
				view.getTextAreaDescrizione().setText(c.getDescrizione());
				view.getTextFieldSconto().setText(String.valueOf(c.getSconto()));

			}
		});

		view.getBtnInserisci().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String ragioneSociale = view.getTextFieldRagioneSociale().getText().toUpperCase();
				String indirizzo = view.getTextFieldIndirizzo().getText().toUpperCase();
				String descrizione = view.getTextAreaDescrizione().getText().toUpperCase();
				String sconto = view.getTextFieldSconto().getText();
				
				Boolean validazione = true;
				if(ragioneSociale.isEmpty()){
					view.getTextFieldRagioneSociale().setBackground(Color.red);
					validazione = false;
				} 
				else{
					if(view.getTextFieldRagioneSociale().getBackground() == Color.red)
						view.getTextFieldRagioneSociale().setBackground(Color.white);
				}
				if (!Validator.ValidaIndirizzo(indirizzo)) {
					view.getTextFieldIndirizzo().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getTextFieldIndirizzo().getBackground() == Color.red)
						view.getTextFieldIndirizzo().setBackground(Color.white);
				}
				if (!Validator.ValidaImporto(sconto) || Double.valueOf(sconto)>100 ) {
					view.getTextFieldSconto().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getTextFieldSconto().getBackground() == Color.red)
						view.getTextFieldSconto().setBackground(Color.white);
				}

				if (validazione) {
					if (model.insertConvenzione(
							new Convenzione(ragioneSociale, indirizzo, descrizione, Double.valueOf(sconto)))) {
						gestioneConvenzione();
						view.getFrame().dispose();
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Inserimento Effettuata");
					} else {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Inserimento Non Effettuata");
					}
				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(),
							"Campi non validi, modificare i campi contrassegnati in rosso");
				}

			}
		});

		view.getBtnCancella().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (model.deleteConvenzione(view.getList().getSelectedValue())) {
					gestioneConvenzione();
					view.getFrame().dispose();
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Eliminazione Effettuata");
				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Eliminazione Non Effettuata");
				}
			}
		});

		view.getBtnModifica().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				view.getTextFieldRagioneSociale().setEnabled(true);
				view.getTextFieldIndirizzo().setEnabled(true);
				view.getTextAreaDescrizione().setEnabled(true);
				view.getTextFieldSconto().setEnabled(true);
				view.getBtnModifica().setVisible(false);
				view.getBtnCancella().setVisible(false);
				view.getBtnSalvaModifiche().setVisible(true);
			}
		});

		view.getBtnSalvaModifiche().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = view.getList().getSelectedValue().getId();
				String ragioneSociale = view.getTextFieldRagioneSociale().getText().toUpperCase();
				String indirizzo = view.getTextFieldIndirizzo().getText().toUpperCase();
				String descrizione = view.getTextAreaDescrizione().getText().toUpperCase();
				String sconto = view.getTextFieldSconto().getText();
				Boolean validazione = true;
				if(ragioneSociale.isEmpty()){
					view.getTextFieldRagioneSociale().setBackground(Color.red);
					validazione = false;
				} 
				else{
					if(view.getTextFieldRagioneSociale().getBackground() == Color.red)
						view.getTextFieldRagioneSociale().setBackground(Color.white);
				}
				if (!Validator.ValidaIndirizzo(indirizzo)) {
					view.getTextFieldIndirizzo().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getTextFieldIndirizzo().getBackground() == Color.red)
						view.getTextFieldIndirizzo().setBackground(Color.white);
				}
				if (!Validator.ValidaImporto(sconto) || Double.valueOf(sconto)>100) {
					view.getTextFieldSconto().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getTextFieldSconto().getBackground() == Color.red)
						view.getTextFieldSconto().setBackground(Color.white);
				}
				
				if (validazione) {
					if (model.updateConvenzione(
							new Convenzione(id, ragioneSociale, indirizzo, descrizione, Double.valueOf(sconto)))) {
						gestioneConvenzione();
						view.getFrame().dispose();
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Aggiornamento Effettuata");
					} else {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Aggiornamento Non Effettuata");
					}
				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(),
							"Campi non validi, modificare i campi contrassegnati in rosso");
				}
			}
		});
		
		view.getBtnAnnullaModifiche().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gestioneConvenzione();
				view.getFrame().dispose();
			}
		});

		view.getBtnDashboard().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminController adminController = new AdminController();
				adminController.controlloEvento();
				view.getFrame().dispose();
			}
		});
	}
}