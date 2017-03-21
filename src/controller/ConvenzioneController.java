package controller;


import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Convenzioneview.Convenzione;
import controller.AdminController;
import entita.Sala;
import model.ConvenzioneModel;
import utility.Validator;
import view.GestioneConvenzioniView;
import view.GestioneSaleView;


public class ConvenzioneController {
	private ConvenzioneModel model;
	private GestioneConvenzioniView viewGestione;
	private ArrayList<Convenzione> convenzioni;
	private Convenzione convenzioneapre;

	public ConvenzioneController() {
		model = new ConvenzioneModel();
	}

	
	public void gestioneConvenzioni() {
		ArrayList<Convenzione> convenzioni = model.listaConvenzioni();
		GestioneConvenzioniView view = new GestioneConvenzioniView(convenzioni);
		view.getFrame().setVisible(true);
	
		view.getList().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent lse) {
				Convenzione c = view.getList().getSelectedValue();
				view.getId().setText(c.getId());
				view.getIndirizzo().setText(c.getIndirizzo());
				view.getDescrizione().setText(c.getDescrizione());
				view.getRagione_Sociale().setValue(c.getRagione_sociale());
				view.getSconto().setValue(c.getSconto());
				view.getBtnModifica().setEnabled(true);
				view.getBtnCancella().setEnabled(true);
			}
		});	
		
		
		view.getBtnInserisci().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String id = view.getId().getText().toUpperCase();
				String indirizzo = view.getIndirizzo().getText().toUpperCase();
				String descrizione = view.getDescrizione().getText().toUpperCase();
				String sconto = view.getSconto().toString();
				String ragione_sociale = view.getRagione_sociale().toString();
				
				
				boolean validazione = true;
				
				if (!Validator.ValidaAnagrafica(id)) {
					view.getId().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getId().getBackground() == Color.red)
						view.getId().setBackground(Color.white);
				}
								
				if (!Validator.ValidaTesto(descrizione)) {
					view.getDescrizione().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getDescrizione().getBackground() == Color.red)
						view.getDescrizione().setBackground(Color.white);
				}
				
				if (validazione) {
					boolean esito = model.insertConvenzione(new Convenzione(id, indirizzo, Integer.valueOf(sconto),	descrizione, Integer.valueOf(ragione_sociale)));
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
		
		
		view.getBtnModifica().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				view.getBtnInserisci().setVisible(false);
				view.getBtnCancella().setVisible(false);
				view.getBtnModifica().setVisible(false);
				view.getBtnAnnullaModifiche().setVisible(true);
				view.getBtnSalvaModifiche().setVisible(true);
				view.getId().setEnabled(true);;
				view.getDescrizione().setEnabled(true);
				view.getRagione_sociale().setEnabled(true);
				view.getIndirizzo().setEnabled(true);
				view.getSconto().setEnabled(true);
			}

		});
		
		
		view.getBtnSalvaModifiche().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String id = view.getId().getText().toUpperCase();
				String indirizzo = view.getIndirizzo().getText().toUpperCase();
				String descrizione = view.getDescrizione().getText().toUpperCase();
				String sconto = view.getSconto().toString();
				String ragione_sociale = view.getRagione_sociale().toString();
				
				
				boolean validazione = true;
				
				if (!Validator.ValidaAnagrafica(id)) {
					view.getId().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getId().getBackground() == Color.red)
						view.getId().setBackground(Color.white);
				}
								
				if (!Validator.ValidaTesto(descrizione)) {
					view.getDescrizione().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getDescrizione().getBackground() == Color.red)
						view.getDescrizione().setBackground(Color.white);
				}
				
				if (validazione) {
					boolean esito = model.insertConvenzione(new Convenzione(id, indirizzo, Integer.valueOf(sconto),	descrizione, Integer.valueOf(ragione_sociale)));
					if (esito) {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Modifica Effettuata");
						view.getFrame().dispose();
						AdminController adminController = new AdminController();
						adminController.controlloEvento();
					} else {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Modifica Non Effettuata");
					}

				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(),
							"Campi non validi, modificare i campi contrassegnati in rosso");
				}
			}
		});
		
		view.getBtnCancella().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				boolean esito = model.deleteConvenzione(view.getList().getSelectedValue().getId());
				if (esito) {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Cancellata correttamente");
					gestioneConvenzioni();
					view.getFrame().dispose();
				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Cancellazione non effettuata");
				}
			}
		});
		
		view.getBtnAnnullaModifiche().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				gestioneConvenzioni();
				view.getFrame().dispose();
			}
		});
		
		
		
		

