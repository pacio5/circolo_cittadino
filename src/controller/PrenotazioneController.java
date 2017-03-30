package controller;

import model.PrenotazioneModel;
import model.SocioModel;
import view.GestioneEventiView;
import view.GestioneSaleView;
import view.AffittaSalaView;
import view.PrenotaEventoView;
import view.BefaneView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.lang.Float;
import java.sql.Date;
import java.util.ArrayList;
import utility.Validator;

import entita.Evento;
import entita.Figlio;
import entita.Sala;
import entita.Socio;
import entita.NonSocio;
import entita.Affitto;
import entita.Prenotazione;

/**
 * @author simoneonori
 * @author eliapacioni
 * @author smerilliriccardo
 * @author francescotalento
 * @version 1.0 marzo 2017
 */
/**
 *classe che si occupa della gestione degli eventi generati dalle view riguardanti l'affitto delle sale, la prenotazione degli eventi
 *la gestione di eventi, sale e del'evento speciale delle befane, prendendo i dati necessari dal PrenotazioneModel
 */
public class PrenotazioneController {

	private PrenotazioneModel model;
	private SocioModel modelS;

	/** Costruttore del Controller della prenotazione
	 * @return oggetto di tipo PrenotazioneController
	 */
	public PrenotazioneController() {
		model = new PrenotazioneModel();
		modelS = new SocioModel();
	}
	
	/**
	 *  metodo che gestisce gli eventi della GestioneEventiView, in particolare l'inserimeto, la modifica e la cancellazione
	 *  di un evento (btnInserisci, btnModifica, btnCancella) e il ritrono alla dashboard (btnDashboard)
	 */
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
				int nPosti = Integer.valueOf(view.getNPosti().getValue().toString());
				String luogo = view.getLuogo().getText().toUpperCase();
				String prezzo = view.getPrezzo().getText();

				boolean validazione = true;
				if (!Validator.validaAnagrafica(nome)) {
					view.getNomeEvento().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getNomeEvento().getBackground() == Color.red)
						view.getNomeEvento().setBackground(Color.white);
				}

				if (!Validator.validaData(data)) {
					view.getData().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getData().getBackground() == Color.red)
						view.getData().setBackground(Color.white);
				}

				if (!Validator.validaImporto(prezzo)) {
					view.getPrezzo().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getPrezzo().getBackground() == Color.red)
						view.getPrezzo().setBackground(Color.white);
				}

				if (!Validator.validaIndirizzo(luogo) || luogo.length() > 35) {
					view.getLuogo().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getLuogo().getBackground() == Color.red)
						view.getLuogo().setBackground(Color.white);
				}

				if (validazione) {
					boolean esito = model.insertEvento(
							new Evento(nome, Date.valueOf(data), descrizione, nPosti, luogo, Float.valueOf(prezzo)));
					if (esito) {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Inserimento Effettuato");
						view.getFrame().dispose();
						gestioneEventi();
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
				if (view.getList().isSelectionEmpty() == false) {
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
				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Evento Non Selezionato");
				}
			}

		});

		view.getBtnSalvaModifiche().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				int idv = Integer.valueOf(view.getList().getSelectedValue().getId());
				String nome = view.getNomeEvento().getText().toUpperCase();
				String data = view.getData().getText();
				String descrizione = view.getDescrizione().getText().toUpperCase();
				String nPosti = view.getNPosti().getValue().toString();
				String luogo = view.getLuogo().getText().toUpperCase();
				String prezzo = view.getPrezzo().getText();

				boolean validazione = true;
				if (!Validator.validaAnagrafica(nome)) {
					view.getNomeEvento().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getNomeEvento().getBackground() == Color.red)
						view.getNomeEvento().setBackground(Color.white);
				}

				if (!Validator.validaData(data)) {
					view.getData().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getData().getBackground() == Color.red)
						view.getData().setBackground(Color.white);
				}

				if (!Validator.validaImporto(prezzo)) {
					view.getPrezzo().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getPrezzo().getBackground() == Color.red)
						view.getPrezzo().setBackground(Color.white);
				}

				if (!Validator.validaIndirizzo(luogo) || luogo.length() > 35) {
					view.getLuogo().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getLuogo().getBackground() == Color.red)
						view.getLuogo().setBackground(Color.white);
				}

				if (validazione) {
					boolean esito = model.updateEvento(new Evento(nome, Date.valueOf(data), descrizione,
							Integer.valueOf(nPosti), luogo, Float.valueOf(prezzo)), idv);

					if (esito) {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Modifica Effettuata");
						view.getFrame().dispose();
						gestioneEventi();
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
				if (view.getList().isSelectionEmpty() == false) {
					boolean esito = model.deleteEvento(view.getList().getSelectedValue().getId());
					if (esito) {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Cancellato correttamente");
						gestioneEventi();
						view.getFrame().dispose();
					} else {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Cancellazione non effettuata");
					}
				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Evento Non Selezionato");
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

	/**
	 * metodo che gestisce gli eventi della GestioneSaleView, in particolare l'inserimento, la modifica e la cancellazione 
	 * di una sala (btnInserisci, btnModifica, btnCancella) e il ritrono alla dashboard (btnDashboard)
	 */
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
				int capienza = Integer.valueOf(view.getCapienza().getValue().toString());
				String tariffa = view.getTariffa().getText();

				boolean validazione = true;

				if (!Validator.validaAnagrafica(nome)) {
					view.getNomeSala().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getNomeSala().getBackground() == Color.red)
						view.getNomeSala().setBackground(Color.white);
				}

				if (!Validator.validaImporto(tariffa)) {
					view.getTariffa().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getTariffa().getBackground() == Color.red)
						view.getTariffa().setBackground(Color.white);
				}

				if (validazione) {
					boolean esito = model.insertSala(new Sala(nome, capienza, descrizione, Float.valueOf(tariffa)));
					if (esito) {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Inserimento Effettuato");
						view.getFrame().dispose();
						gestioneSale();
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
				if (view.getList().isSelectionEmpty() == false) {
					view.getBtnInserisci().setVisible(false);
					view.getBtnCancella().setVisible(false);
					view.getBtnModifica().setVisible(false);
					view.getBtnAnnullaModifiche().setVisible(true);
					view.getBtnSalvaModifiche().setVisible(true);
					view.getNomeSala().setEnabled(true);
					;
					view.getDescrizione().setEnabled(true);
					view.getCapienza().setEnabled(true);
					view.getTariffa().setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Sala Non Selezionata");
				}
			}

		});

		view.getBtnSalvaModifiche().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				String nome = view.getNomeSala().getText().toUpperCase();
				String descrizione = view.getDescrizione().getText().toUpperCase();
				int capienza = Integer.valueOf(view.getCapienza().getValue().toString());
				String tariffa = view.getTariffa().getText();

				boolean validazione = true;
				if (!Validator.validaAnagrafica(nome)) {
					view.getNomeSala().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getNomeSala().getBackground() == Color.red)
						view.getNomeSala().setBackground(Color.white);
				}

				if (!Validator.validaImporto(tariffa)) {
					view.getTariffa().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getTariffa().getBackground() == Color.red)
						view.getTariffa().setBackground(Color.white);
				}

				if (validazione) {
					boolean esito = model.updateSala(new Sala(nome, capienza, descrizione, Float.valueOf(tariffa)),
							view.getList().getSelectedValue().getNome());
					if (esito) {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Modifica Effettuata");
						gestioneSale();
						view.getFrame().dispose();
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
				if (view.getList().isSelectionEmpty() == false) {
					boolean esito = model.deleteSala(view.getList().getSelectedValue().getNome());
					if (esito) {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Cancellato correttamente");
						gestioneSale();
						view.getFrame().dispose();
					} else {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Cancellazione non effettuata");
					}
				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Sala Non Selezionata");
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

	/**
	 * metodo che gestisce gli eventi della AffittaSalaView, in particolare l'inserimento e la cancellazione 
	 * di un'affitto (btnInserisci, btnCancella), la visualizzazione delle sale disponibili (btnVisualizzaSale),
	 * la visuzlizzazione delle informazioni di una sala (btnInfo) e il ritrono alla dashboard (btnDashboard)
	 */
	public void affittaSale() {
		ArrayList<Affitto> affitti = model.affittuari();
		ArrayList<Socio> soci = modelS.elencoSoci();
		ArrayList<NonSocio> nsoci = modelS.elencoNonSoci();

		AffittaSalaView view = new AffittaSalaView(soci, nsoci, affitti);
		view.getFrame().setVisible(true);

		view.getData().addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				view.getBtnVisualizzaSale().setVisible(false);
			}

			@Override
			public void focusGained(FocusEvent e) {
				view.getBtnVisualizzaSale().setVisible(true);
			}
		});

		view.getBtnVisualizzaSale().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String data = view.getData().getText();
				if (Validator.validaData(data)) {
					ArrayList<Sala> sale = model.listaSaleDisponibili(Date.valueOf(data));
					DefaultListModel<Sala> dlms = new DefaultListModel<Sala>();
					sale.stream().forEach((s) -> {
						dlms.addElement(s);
					});
					view.getListSala().setModel(dlms);
				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(),
							"Inserisci un formato data corretto AAAA/MM/GG");
				}
			}
		});

		view.getRbtnSocio().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				view.getPaneSoci().setVisible(true);
				view.getPaneNonSoci().setVisible(false);
			}
		});

		view.getRdbtnNonSocio().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				view.getPaneSoci().setVisible(false);
				view.getPaneNonSoci().setVisible(true);
			}
		});

		view.getBtnDashboard().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				AdminController adminController = new AdminController();
				adminController.controlloEvento();
				view.getFrame().dispose();
			}
		});

		view.getBtnInserisci().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if ((view.getListSoci().isSelectionEmpty() == false
						|| view.getListNonSoci().isSelectionEmpty() == false)
						&& view.getListSala().isSelectionEmpty() == false) {
					String data = view.getData().getText();
					boolean validazione = true;
					boolean esito;
					if (!Validator.validaData(data)) {
						view.getData().setBackground(Color.red);
						validazione = false;
					} else {
						if (view.getData().getBackground() == Color.red)
							view.getData().setBackground(Color.white);
					}
					if (validazione) {
						Sala sala = view.getListSala().getSelectedValue();
						if (view.getPaneSoci().isVisible()) {
							esito = model.insertAffittoS(view.getListSoci().getSelectedValue(), sala,
									Date.valueOf(data));
						} else
							esito = model.insertAffittoN(view.getListNonSoci().getSelectedValue(), sala,
									Date.valueOf(data));
						if (esito) {
							JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Inserimento Effettuato");
							view.getFrame().dispose();
							AdminController adminController = new AdminController();
							adminController.controlloEvento();
						} else
							JOptionPane.showMessageDialog(view.getFrame().getContentPane(),
									"Inserimento Non Effettuato");
					} else {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(),
								"Campi non validi, modificare i campi contrassegnati in rosso");
					}
				} else
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(),
							"Selezionare una Sala e un Cliente");
			}
		});

		view.getBtnCancella().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (view.getList().isSelectionEmpty() == false) {
					Affitto a = view.getList().getSelectedValue();
					boolean esito = model.deleteAffitto(a);
					if (esito) {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Cancellato correttamente");
						gestioneSale();
						view.getFrame().dispose();
					} else {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Cancellazione non effettuata");
					}
				} else
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Prenotazione Non Selezionata");
			}
		});

		view.getBtnInfo().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (view.getListSala().isSelectionEmpty() == false) {
					Sala sala = view.getListSala().getSelectedValue();
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "La sala : " + sala.getNome()
							+ "\nHa capienza: " + sala.getCapienza() + " \nDescrizione: " + sala.getDescrizione());
				} else
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Sala Non Selezionata");
			}
		});
	}

	/**
	 * metodo che gestisce gli eventi della PrenotaEventoView,  in particolare l'inserimento e la cancellazione 
	 * di una prenotazione ad un evento (btnInserisci, btnCancella), la visuzlizzazione delle informazioni di un'evento (btnInfo) 
	 * e il ritrono alla dashboard (btnDashboard)
	 */
	public void prenotaEvento() {
		ArrayList<Evento> eventi = model.listaEventiValidi();
		ArrayList<Socio> soci = modelS.elencoSoci();
		ArrayList<NonSocio> nsoci = modelS.elencoNonSoci();
		ArrayList<Prenotazione> prenotazioni = model.listaPrenotazioni(null);

		PrenotaEventoView view = new PrenotaEventoView(eventi, prenotazioni, soci, nsoci);
		view.getFrame().setVisible(true);

		view.getListEventi().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent lse) {
				Evento e = view.getListEventi().getSelectedValue();
				int pd = model.postiDisponibili(e);
				ArrayList<Prenotazione> prenotazioni = model.listaPrenotazioni(e.getId());
				view.getTxtBigliettiDisponibili().setText(String.valueOf(pd));

				DefaultListModel<Prenotazione> dlmp = new DefaultListModel<Prenotazione>();
				prenotazioni.stream().forEach((p) -> {
					dlmp.addElement(p);
				});
				view.getListPrenotazioni().setModel(dlmp);
			}
		});

		view.getRbtnSocio().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				view.getPaneNonSoci().setVisible(false);
				view.getPaneSoci().setVisible(true);
			}
		});

		view.getRdbtnNonSocio().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				view.getPaneSoci().setVisible(false);
				view.getPaneNonSoci().setVisible(true);
			}
		});

		view.getBtnDashboard().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				AdminController adminController = new AdminController();
				adminController.controlloEvento();
				view.getFrame().dispose();
			}
		});

		view.getBtnInfo().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (view.getListEventi().isSelectionEmpty() == false) {
					Evento ev = view.getListEventi().getSelectedValue();
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(),
							"L'evento : " + ev.getNome() + "\nN Posti: " + ev.getPosti() + "\nIn data: " + ev.getData()
									+ "\nDescrizione: " + ev.getDescrizione());
				} else
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Sala Non Selezionata");
			}
		});

		view.getBtnInserisci().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Evento evento = view.getListEventi().getSelectedValue();
				if (Integer.valueOf(view.getTxtBigliettiDisponibili().getText()) > evento.getPosti()) {
					String data = view.getData().getText();
					int nBiglietti = Integer.valueOf(view.getNumBiglietti().getValue().toString());
					Socio socio = view.getListSoci().getSelectedValue();
					NonSocio nsocio = view.getListNonSoci().getSelectedValue();

					boolean validazione = true;

					if (!Validator.validaData(data)) {
						view.getData().setBackground(Color.red);
						validazione = false;
					} else {
						if (view.getData().getBackground() == Color.red)
							view.getData().setBackground(Color.white);
					}

					if (validazione) {
						boolean esito;
						if (view.getPaneSoci().isVisible()) {
							esito = model.insertPrenotazioneS(socio, nBiglietti, evento, Date.valueOf(data));
						} else
							esito = model.insertPrenotazioneN(nsocio, nBiglietti, evento, Date.valueOf(data));
						if (esito) {
							JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Inserimento Effettuato");
							prenotaEvento();
							view.getFrame().dispose();
						} else
							JOptionPane.showMessageDialog(view.getFrame().getContentPane(),
									"Inserimento Non Effettuato");
					} else {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(),
								"Campi non validi, modificare i campi contrassegnati in rosso");
					}
				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(),
							"Ci sono pochi biglietti disponibili, richiedine meno del numero massimo");
				}
			}
		});

		view.getBtnCancella().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (view.getListPrenotazioni().isSelectionEmpty() == false) {
					Prenotazione p = view.getListPrenotazioni().getSelectedValue();
					if (model.deletePrenotazione(p)) {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Cancellato correttamente");
						prenotaEvento();
						view.getFrame().dispose();
					} else {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Cancellazione non effettuata");
					}
				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Prenotazione Non Selezionata");
				}
			}
		});
	}
	
	/**
	 * metodo che gestisce gli eventi della BefaneView, in particolare la visualizzazione della lista di figli 
	 * e il ritrono alla dashboard (btnDashboard)
	 */
	public void gestioneBefane() {
		ArrayList<Figlio> figli = modelS.elencoFigli(null);
		BefaneView view = new BefaneView(figli);
		view.getFrame().setVisible(true);

		view.getListF().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent lse) {
				view.setTxtG(view.getListF().getSelectedValue().getGenitore().toString());
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
