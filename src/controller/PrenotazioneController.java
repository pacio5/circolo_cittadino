package controller;

import model.PrenotazioneModel;
import utility.Validator;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.lang.Float;
import java.sql.Date;
import entita.Evento;
import view.PrenotazioneView;

public class PrenotazioneController {
	
	private PrenotazioneModel model;
	
	public PrenotazioneController(){
		model = new PrenotazioneModel();
	}
	
	public void Inserimento() {
		PrenotazioneView view = new PrenotazioneView();
		view.getFrame().setVisible(true);
		view.getBtnInserisci().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nome = view.getNomeEvento().getText().toUpperCase();
				String data = view.getData().getText();
				String descrizione = view.getDescrizione().getText().toUpperCase();
				String nPosti = view.getNPosti().toString();
				String luogo = view.getLuogo().getText().toUpperCase();
				String prezzo = view.getPrezzo().getText();
				
				boolean validazione = true;
				if (!Validator.ValidaAnagrafica(nome)) {
					view.getNomeEvento().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getNomeEvento().getBackground() == Color.red)
						view.getNomeEvento().setBackground(Color.white);
				}
				
				if (!Validator.ValidaData(data)) {
					view.getData().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getData().getBackground() == Color.red)
						view.getData().setBackground(Color.white);
				}
				
				if (!Validator.ValidaAnagrafica(descrizione)) {
					view.getDescrizione().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getDescrizione().getBackground() == Color.red)
						view.getDescrizione().setBackground(Color.white);
				}
								
				if (!Validator.ValidaAnagrafica(luogo)|| luogo.length() > 35) {
					view.getLuogo().setBackground(Color.red);
				} else {
					if (view.getLuogo().getBackground() == Color.red)
						view.getLuogo().setBackground(Color.white);
				}
				
				if (!Validator.ValidaImporto(prezzo)) {
					view.getPrezzo().setBackground(Color.red);
				} else {
					if (view.getPrezzo().getBackground() == Color.red)
						view.getPrezzo().setBackground(Color.white);
				}

				if (validazione) {
					boolean esito = model.insertEvento(new Evento(nome, Date.valueOf(data),
							descrizione, Integer.valueOf(nPosti), luogo, Float.valueOf(prezzo)));

					if (esito) {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Inserimento Effettuato");
						view.getFrame().dispose();
						AdminController adminController = new AdminController();
						adminController.controlloEvento();
					} else {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Inserimento Non Effettuato");
					}

				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(),
							"Campi non validi, modificare i campi contrassegnati in rosso");
				}
			}
		});

		view.getBtnDashboard().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				AdminController adminController = new AdminController();
				adminController.controlloEvento();
				view.getFrame().dispose();
			}
		});

	}

}
