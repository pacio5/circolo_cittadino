package controller;

import model.PrenotazioneModel;
import model.SocioModel;
import view.GestioneEventiView;
import view.GestioneSaleView;
import view.AffittaSalaView;
import view.PrenotaEventoView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

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
import entita.Sala;
import entita.Socio;
import entita.NonSocio;
import entita.Affitto;
import entita.Prenotazione;

public class PrenotazioneController {
	
	private PrenotazioneModel model;
	private SocioModel modelS;
	private JFrame frame;
	
	public PrenotazioneController(){
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
		ArrayList<Sala> sale = model.listaSaleDisponibili();
		ArrayList<Affitto> affitti = model.afittuari();
		ArrayList<Socio> soci = modelS.elencoSoci();
		ArrayList<NonSocio> nsoci = modelS.elencoNonSoci();
		
		AffittaSalaView view = new AffittaSalaView(sale, soci, nsoci, affitti);
		view.getFrame().setVisible(true);
		
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
				String data = view.getData().getText();
				Socio socio = view.getListSoci().getSelectedValue();
				NonSocio nsocio = view.getListNonSoci().getSelectedValue();
				Sala sala = view.getListSala().getSelectedValue();
				boolean esito;
				if(view.getListSoci().isVisible()){
					esito = model.insertAffittoS(socio, sala, Date.valueOf(data));
				} else esito = model.insertAffittoN(nsocio, sala, Date.valueOf(data));
				if (esito) {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Inserimento Effettuato");
						view.getFrame().dispose();
						AdminController adminController = new AdminController();
						adminController.controlloEvento();
				} else JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Inserimento Non Effettuato");
			
			}
		});
		
		view.getBtnCancella().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Affitto a = view.getList().getSelectedValue();
				boolean esito = model.deleteAffitto(a);
				if (esito) {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Cancellato correttamente");
					gestioneSale();
					view.getFrame().dispose();
				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Cancellazione non effettuata");
				}
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
				
				//i valori del posizionamento sono casuali
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
				
				JLabel lblDescrizione= new JLabel("Descrizione");
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
				//non so se si fa cosi
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
				
				//i valori del posizionamento sono casuali
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
				
				JLabel lblDescrizione= new JLabel("Descrizione");
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
				int nBiglietti = Integer.valueOf(view.getNumBiglietti().toString());
				Socio socio = view.getListSoci().getSelectedValue();
				NonSocio nsocio = view.getListNonSoci().getSelectedValue();
				Evento evento = view.getListEventi().getSelectedValue();
				boolean validazione = true;
				
				if (!Validator.ValidaData(data)) {
					view.getData().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getData().getBackground() == Color.red)
						view.getData().setBackground(Color.white);
				}
				
				if (validazione) {
					boolean esito;
					if(view.getListSoci().isVisible()){
						esito = model.insertPrenotazioneS(socio, nBiglietti, evento, Date.valueOf(data));
					} else esito = model.insertPrenotazioneN(nsocio, nBiglietti, evento, Date.valueOf(data));
					if (esito) {
							JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Inserimento Effettuato");
							int pd = Integer.valueOf(view.getTxtAreaPD().getText());
							view.setTxtAreaPD(pd-nBiglietti); //sotto e' corretto?
							view.getFrame().dispose();
							AdminController adminController = new AdminController();
							adminController.controlloEvento();
						} else JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Inserimento Non Effettuato");
				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(),
							"Campi non validi, modificare i campi contrassegnati in rosso");
				}
			}
		});
		
		view.getBtnCancella().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Prenotazione p = view.getListPrenotazioni().getSelectedValue();
				boolean esito = model.deletePrenotazione(p);
				if (esito) {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Cancellato correttamente");
					int pd = Integer.valueOf(view.getTxtAreaPD().getText());
					view.setTxtAreaPD(pd+p.getNumBiglietti());
					gestioneSale();
					view.getFrame().dispose();
				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Cancellazione non effettuata");
				}
			}
		});
	}
	
}
