package controller;

import model.PrenotazioneModel;
import model.SocioModel;
import view.GestioneEventiView;
import view.GestioneSaleView;
import view.AffittaSalaView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.lang.Float;
import java.sql.Date;
import java.util.ArrayList;
import utility.Validator;

import entita.Evento;
import entita.Sala;
import entita.Socio;
import entita.NonSocio;
import entita.Affitto;

public class PrenotazioneController {
	
	private PrenotazioneModel model;
	private SocioModel modelS;
	
	public PrenotazioneController(){
		model = new PrenotazioneModel();
	}
	
	public void gestioneEventi() {
		ArrayList<Evento> eventi = model.listaEventi();
		GestioneEventiView view = new GestioneEventiView(eventi);
		view.getFrame().setVisible(true);
	
		view.getList().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent lse) {
				Evento e = view.getList().getSelectedValue();
				view.getNomeEvento().setText(e.getNome());
				view.getData().setText(e.getData().toString());
				view.getLuogo().setText(e.getLuogo());
				view.getDescrizione().setText(e.getDescrizione());
				view.getNPosti().setValue(e.getPosti());
				view.getPrezzo().setText(String.valueOf(e.getPrezzo()));
				view.getBtnModifica().setEnabled(true);
				view.getBtnCancella().setEnabled(true);
			}
		});		
		
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
				
				if (!Validator.ValidaTesto(descrizione)) {
					view.getDescrizione().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getDescrizione().getBackground() == Color.red)
						view.getDescrizione().setBackground(Color.white);
				}
								
				if (!Validator.ValidaTesto(luogo) || luogo.length() > 35) {
					view.getLuogo().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getLuogo().getBackground() == Color.red)
						view.getLuogo().setBackground(Color.white);
				}
				
				if (!Validator.ValidaImporto(prezzo)) {
					view.getPrezzo().setBackground(Color.red);
					validazione = false;
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
		
		view.getBtnModifica().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				view.getBtnInserisci().setVisible(false);
				view.getBtnCancella().setVisible(false);
				view.getBtnModifica().setVisible(false);
				view.getBtnAnnullaModifiche().setVisible(true);
				view.getBtnSalvaModifiche().setVisible(true);
				view.getNomeEvento().setEnabled(true);
				view.getData().setEnabled(true);
				view.getDescrizione().setEnabled(true);
				view.getNPosti().setEnabled(true);
				view.getLuogo().setEnabled(true);
				view.getPrezzo().setEnabled(true);
			}

		});

		view.getBtnSalvaModifiche().addMouseListener(new MouseAdapter() {
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
				
				if (!Validator.ValidaTesto(descrizione)) {
					view.getDescrizione().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getDescrizione().getBackground() == Color.red)
						view.getDescrizione().setBackground(Color.white);
				}
								
				if (!Validator.ValidaTesto(luogo) || luogo.length() > 35) {
					view.getLuogo().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getLuogo().getBackground() == Color.red)
						view.getLuogo().setBackground(Color.white);
				}
				
				if (!Validator.ValidaImporto(prezzo)) {
					view.getPrezzo().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getPrezzo().getBackground() == Color.red)
						view.getPrezzo().setBackground(Color.white);
				}

				if (validazione) {
					boolean esito = model.insertEvento(new Evento(nome, Date.valueOf(data),
							descrizione, Integer.valueOf(nPosti), luogo, Float.valueOf(prezzo)));

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
				boolean esito = model.deleteEvento(view.getList().getSelectedValue().getId());
				if (esito) {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Cancellato correttamente");
					gestioneEventi();
					view.getFrame().dispose();
				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Cancellazione non effettuata");
				}
			}
		});
		
		view.getBtnAnnullaModifiche().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				gestioneEventi();
				view.getFrame().dispose();
			}
		});
		
	}
	
	public void gestioneSale() {
		ArrayList<Sala> sale = model.listaSale();
		GestioneSaleView view = new GestioneSaleView(sale);
		view.getFrame().setVisible(true);
	
		view.getList().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent lse) {
				Sala s = view.getList().getSelectedValue();
				view.getNomeSala().setText(s.getNome());
				view.getDescrizione().setText(s.getDescrizione());
				view.getCapienza().setValue(s.getCapienza());
				view.getTariffa().setText(String.valueOf(s.getTariffa()));
				view.getBtnModifica().setEnabled(true);
				view.getBtnCancella().setEnabled(true);
			}
		});		
		
		view.getBtnInserisci().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String nome = view.getNomeSala().getText().toUpperCase();
				String descrizione = view.getDescrizione().getText().toUpperCase();
				String capienza = view.getCapienza().toString();
				String tariffa = view.getTariffa().getText();
				
				boolean validazione = true;
				
				if (!Validator.ValidaAnagrafica(nome)) {
					view.getNomeSala().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getNomeSala().getBackground() == Color.red)
						view.getNomeSala().setBackground(Color.white);
				}
								
				if (!Validator.ValidaTesto(descrizione)) {
					view.getDescrizione().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getDescrizione().getBackground() == Color.red)
						view.getDescrizione().setBackground(Color.white);
				}
				
				if (!Validator.ValidaImporto(tariffa)) {
					view.getTariffa().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getTariffa().getBackground() == Color.red)
						view.getTariffa().setBackground(Color.white);
				}

				if (validazione) {
					boolean esito = model.insertSala(new Sala(nome, Integer.valueOf(capienza),	descrizione, Float.valueOf(tariffa)));
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
				view.getNomeSala().setEnabled(true);;
				view.getDescrizione().setEnabled(true);
				view.getCapienza().setEnabled(true);
				view.getTariffa().setEnabled(true);
			}

		});

		view.getBtnSalvaModifiche().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				String nome = view.getNomeSala().getText().toUpperCase();
				String descrizione = view.getDescrizione().getText().toUpperCase();
				String capienza = view.getCapienza().toString();
				String tariffa = view.getTariffa().getText();

				boolean validazione = true;
				if (!Validator.ValidaAnagrafica(nome)) {
					view.getNomeSala().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getNomeSala().getBackground() == Color.red)
						view.getNomeSala().setBackground(Color.white);
				}
				
				if (!Validator.ValidaTesto(descrizione)) {
					view.getDescrizione().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getDescrizione().getBackground() == Color.red)
						view.getDescrizione().setBackground(Color.white);
				}
										
				if (!Validator.ValidaImporto(tariffa)) {
					view.getTariffa().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getTariffa().getBackground() == Color.red)
						view.getTariffa().setBackground(Color.white);
				}

				if (validazione) {
					boolean esito = model.insertSala(new Sala(nome, Integer.valueOf(capienza), 	descrizione, Float.valueOf(tariffa)));

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
				boolean esito = model.deleteSala(view.getList().getSelectedValue().getNome());
				if (esito) {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Cancellato correttamente");
					gestioneSale();
					view.getFrame().dispose();
				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Cancellazione non effettuata");
				}
			}
		});
		
		view.getBtnAnnullaModifiche().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				gestioneSale();
				view.getFrame().dispose();
			}
		});
		
	}
	
	public void affittaSale() {
		ArrayList<Sala> sale = model.listaSale();
		ArrayList<Affitto> affitti = model.afittuari();
		ArrayList<Socio> soci = modelS.elencoSoci();
		ArrayList<NonSocio> nsoci = modelS.elencoNonSoci();
		
		AffittaSalaView view = new AffittaSalaView(sale, soci, affitti);
		view.getFrame().setVisible(true);
		
		/*
		view.getRdbtnNonSocio().addChangeListener(new ChangeListener() {
			
		});
	
		view.get
		*/
	}
	
}
