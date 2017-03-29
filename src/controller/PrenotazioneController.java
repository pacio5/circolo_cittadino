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
import javax.swing.JFrame;
import javax.swing.JLabel;
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

public class PrenotazioneController {

	private PrenotazioneModel model;
	private SocioModel modelS;
	private JFrame frame;

	public PrenotazioneController() {
		model = new PrenotazioneModel();
		modelS = new SocioModel();
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

	public void affittaSale() {
		ArrayList<Affitto> affitti = model.afittuari();
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
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), data);
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
					Socio socio = view.getListSoci().getSelectedValue();
					NonSocio nsocio = view.getListNonSoci().getSelectedValue();
					Sala sala = view.getListSala().getSelectedValue();
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
						if (view.getListSoci().isVisible()) {
							esito = model.insertAffittoS(socio, sala, Date.valueOf(data));
						} else
							esito = model.insertAffittoN(nsocio, sala, Date.valueOf(data));
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
					frame = new JFrame("Circolo Cittadino - Prenota Evento");
					frame.setTitle("Circolo Cittadino - Prenotazione Eventi");
					frame.setBounds(100, 100, 800, 600);
					frame.setResizable(false);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.getContentPane().setLayout(null);

					// i valori del posizionamento sono casuali
					Sala sala = view.getListSala().getSelectedValue();

					JLabel lblNome = new JLabel("Nome");
					lblNome.setBounds(253, 95, 97, 16);
					frame.getContentPane().add(lblNome);

					JLabel lblName = new JLabel(sala.getNome());
					lblName.setBounds(253, 111, 27, 46);
					frame.getContentPane().add(lblName);

					JLabel lblCap = new JLabel("Capienza");
					lblCap.setBounds(253, 95, 97, 16);
					frame.getContentPane().add(lblCap);

					JLabel lblDate = new JLabel(String.valueOf(sala.getCapienza()));
					lblDate.setBounds(253, 123, 22, 34);
					frame.getContentPane().add(lblDate);

					JLabel lblDescrizione = new JLabel("Descrizione");
					lblDescrizione.setBounds(123, 23, 14, 25);
					frame.getContentPane().add(lblDescrizione);

					JLabel lblDescription = new JLabel(sala.getDescrizione());
					lblDescription.setBounds(124, 26, 97, 16);
					frame.getContentPane().add(lblDescription);

					JLabel lblPrezzo = new JLabel("Tariffa");
					lblPrezzo.setBounds(113, 125, 117, 116);
					frame.getContentPane().add(lblPrezzo);

					JLabel lblPrice = new JLabel(String.valueOf(sala.getTariffa()));
					lblPrice.setBounds(153, 115, 141, 116);
					frame.getContentPane().add(lblPrice);
				} else
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Sala Non Selezionata");
			}
		});
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void prenotaEvento() {
		ArrayList<Evento> eventi = model.listaEventiValidi();
		ArrayList<Socio> soci = modelS.elencoSoci();
		ArrayList<NonSocio> nsoci = modelS.elencoNonSoci();
		ArrayList<Prenotazione> prenotazioni = model.listaPrenotazioni("0");

		PrenotaEventoView view = new PrenotaEventoView(eventi, prenotazioni, soci, nsoci);
		view.getFrame().setVisible(true);

		view.getListEventi().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent lse) {
				Evento e = view.getListEventi().getSelectedValue();
				int pd = model.postiDisponibili(e);
				ArrayList<Prenotazione> prenotazioni = model.listaPrenotazioni(e.getId());
				PrenotaEventoView view = new PrenotaEventoView(eventi, prenotazioni, soci, nsoci);
				view.getFrame().dispose();
				view.setTxtAreaPD(pd);
				// non so se si fa cosi
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
				frame = new JFrame("Circolo Cittadino - Prenota Evento");
				frame.setTitle("Circolo Cittadino - Prenotazione Eventi");
				frame.setBounds(100, 100, 800, 600);
				frame.setResizable(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);

				// i valori del posizionamento sono casuali
				Evento evnt = view.getListEventi().getSelectedValue();

				JLabel lblNome = new JLabel("Nome");
				lblNome.setBounds(253, 95, 97, 16);
				frame.getContentPane().add(lblNome);

				JLabel lblName = new JLabel(evnt.getNome());
				lblName.setBounds(253, 111, 27, 46);
				frame.getContentPane().add(lblName);

				JLabel lblData = new JLabel("Data");
				lblData.setBounds(253, 95, 97, 16);
				frame.getContentPane().add(lblData);

				JLabel lblDate = new JLabel(evnt.getData().toString());
				lblDate.setBounds(253, 123, 22, 34);
				frame.getContentPane().add(lblDate);

				JLabel lblDescrizione = new JLabel("Descrizione");
				lblDescrizione.setBounds(123, 23, 14, 25);
				frame.getContentPane().add(lblDescrizione);

				JLabel lblDescription = new JLabel(evnt.getDescrizione());
				lblDescription.setBounds(124, 26, 97, 16);
				frame.getContentPane().add(lblDescription);

				JLabel lblNPosti = new JLabel("Numero Posti");
				lblData.setBounds(33, 235, 17, 99);
				frame.getContentPane().add(lblNPosti);

				JLabel lblNSeat = new JLabel(String.valueOf(evnt.getPosti()));
				lblNSeat.setBounds(37, 295, 57, 116);
				frame.getContentPane().add(lblNSeat);

				JLabel lblLuogo = new JLabel("Luogo");
				lblLuogo.setBounds(63, 45, 27, 16);
				frame.getContentPane().add(lblLuogo);

				JLabel lblLocation = new JLabel(evnt.getLuogo());
				lblLocation.setBounds(53, 25, 7, 6);
				frame.getContentPane().add(lblLocation);

				JLabel lblPrezzo = new JLabel("Prezzo");
				lblPrezzo.setBounds(113, 125, 117, 116);
				frame.getContentPane().add(lblPrezzo);

				JLabel lblPrice = new JLabel(String.valueOf(evnt.getPrezzo()));
				lblPrice.setBounds(153, 115, 141, 116);
				frame.getContentPane().add(lblPrice);
			}
		});

		view.getBtnInserisci().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String data = view.getData().getText();
				int nBiglietti = Integer.valueOf(view.getNumBiglietti().getValue().toString());
				Socio socio = view.getListSoci().getSelectedValue();
				NonSocio nsocio = view.getListNonSoci().getSelectedValue();
				Evento evento = view.getListEventi().getSelectedValue();
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
					if (view.getListSoci().isVisible()) {
						esito = model.insertPrenotazioneS(socio, nBiglietti, evento, Date.valueOf(data));
					} else
						esito = model.insertPrenotazioneN(nsocio, nBiglietti, evento, Date.valueOf(data));
					if (esito) {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Inserimento Effettuato");
						int pd = Integer.valueOf(view.getTxtAreaPD().getText());
						view.setTxtAreaPD(pd - nBiglietti); // sotto e'
															// corretto?
						view.getFrame().dispose();
						AdminController adminController = new AdminController();
						adminController.controlloEvento();
					} else
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Inserimento Non Effettuato");
				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(),
							"Campi non validi, modificare i campi contrassegnati in rosso");
				}
			}
		});

		view.getBtnCancella().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (view.getListPrenotazioni().isSelectionEmpty() == false) {
					Prenotazione p = view.getListPrenotazioni().getSelectedValue();
					boolean esito = model.deletePrenotazione(p);
					if (esito) {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Cancellato correttamente");
						int pd = Integer.valueOf(view.getTxtAreaPD().getText());
						view.setTxtAreaPD(pd + p.getNumBiglietti());
						gestioneSale();
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
