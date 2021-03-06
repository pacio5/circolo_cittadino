package controller;

import model.SocioModel;
import utility.Validator;
import view.InserisciSocioView;
import view.PassaggioCategoriaView;
import view.GestioneExSocioView;
import view.GestioneFigliView;
import view.GestioneNonSocioView;

import java.sql.Date;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entita.Figlio;
import entita.NonSocio;
import entita.Socio;
import entita.ExSocio;
import controller.AdminController;
import view.VisualizzaSociView;

/**
 * @author simoneonori
 * @author eliapacioni
 * @author riccardosmerilli
 * @author francescotalento
 * @version 1.0 Marzo 2017 
 * 
 * Classe SocioController che si occupa di gestire tutti gli eventi generati delle view riguardanti socio, nonsocio, exsocio, figlio
 *  e di prendere i dati necessari dal socioModel
 */
public class SocioController {

	private SocioModel model;

	/**
	 * Costruttore senza parametri del SocioController, istanzia il SocioModel
	 */
	public SocioController() {
		model = new SocioModel();
	}

	/**
	 * Metodo che gestisce gli eventi della InserisciSocioView, 
	 * in particolare l'inserimento del socio (btnInserisci) e il ritorno alla dashboard (btnDashboard)
	 */
	public void inserimentoSocio() {
		InserisciSocioView view = new InserisciSocioView();
		view.getFrame().setVisible(true);
		view.getStatoCivile().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (view.getStatoCivile().getSelectedItem().toString().equals("Coniugato"))
					view.getConiuge().setEnabled(true);
				else {
					view.getConiuge().setEnabled(false);
				}
			}
		});

		view.getBtnInserisci().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				char sex;
				if (view.getRdbtnUomo().isSelected())
					sex = 'M';
				else
					sex = 'F';

				String cf = view.getCf().getText().toUpperCase();
				String nome = view.getNome().getText().toUpperCase();
				String cognome = view.getCognome().getText().toUpperCase();
				String dataNascita = view.getDataNascita().getText();
				String luogoNascita = view.getLuogoNascita().getText().toUpperCase();
				String indirizzo = view.getIndirizzo().getText().toUpperCase();
				String citta = view.getCitta().getText().toUpperCase();
				String cap = view.getCap().getText();
				String email = view.getEmail().getText().toUpperCase();
				String telefono = view.getTelefono().getText();
				String professione = view.getProfessione().getText().toUpperCase();
				String statoCivile = view.getStatoCivile().getSelectedItem().toString().toUpperCase();
				String coniuge = null;
				if (view.getConiuge().getText().length() > 0) {
					coniuge = view.getConiuge().getText().toUpperCase();
				}
				String dataAmmissione = view.getDataAmmissione().getText();
				String tassaAmmissione = view.getTassaAmmissione().getText();
				String modPagamento = view.getModPagamento().getSelectedItem().toString().toUpperCase();
				String metPagamento = view.getMetPagamento().getSelectedItem().toString().toUpperCase();
				String tipologia = view.getTipologia().getSelectedItem().toString().toUpperCase();

				boolean validazione = true;
				if (!Validator.validaCf(cf)) {
					view.getCf().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getCf().getBackground() == Color.red)
						view.getCf().setBackground(Color.white);
				}
				if (!Validator.validaAnagrafica(nome)) {
					view.getNome().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getNome().getBackground() == Color.red)
						view.getNome().setBackground(Color.white);
				}
				if (!Validator.validaAnagrafica(cognome)) {
					view.getCognome().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getCognome().getBackground() == Color.red)
						view.getCognome().setBackground(Color.white);
				}
				if (!Validator.validaData(dataNascita)) {
					view.getDataNascita().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getDataNascita().getBackground() == Color.red)
						view.getDataNascita().setBackground(Color.white);
				}
				if (!Validator.validaAnagrafica(luogoNascita) || luogoNascita.length() > 35) {
					view.getLuogoNascita().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getLuogoNascita().getBackground() == Color.red)
						view.getLuogoNascita().setBackground(Color.white);
				}
				if (!Validator.validaIndirizzo(indirizzo)) {
					view.getIndirizzo().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getIndirizzo().getBackground() == Color.red)
						view.getIndirizzo().setBackground(Color.white);
				}
				if (!Validator.validaAnagrafica(citta) || citta.length() > 35) {
					view.getCitta().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getCitta().getBackground() == Color.red)
						view.getCitta().setBackground(Color.white);
				}
				if (!Validator.validaCap(cap)) {
					view.getCap().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getCap().getBackground() == Color.red)
						view.getCap().setBackground(Color.white);
				}
				if (!Validator.validaEmail(email)) {
					view.getEmail().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getEmail().getBackground() == Color.red)
						view.getEmail().setBackground(Color.white);
				}
				if (!Validator.validaTel(telefono)) {
					view.getTelefono().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getTelefono().getBackground() == Color.red)
						view.getTelefono().setBackground(Color.white);
				}
				if (!Validator.validaAnagrafica(professione) || professione.length() > 30) {
					view.getProfessione().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getProfessione().getBackground() == Color.red)
						view.getProfessione().setBackground(Color.white);
				}
				if (coniuge != null) {
					if (!Validator.validaAnagrafica(coniuge) || coniuge.length() > 20) {
						view.getConiuge().setBackground(Color.red);
						validazione = false;
					} else {
						if (view.getConiuge().getBackground() == Color.red)
							view.getConiuge().setBackground(Color.white);
					}
				}
				if (!Validator.validaData(dataAmmissione)) {
					view.getDataAmmissione().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getDataAmmissione().getBackground() == Color.red)
						view.getDataAmmissione().setBackground(Color.white);
				}
				if (!Validator.validaImporto(tassaAmmissione)) {
					view.getTassaAmmissione().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getTassaAmmissione().getBackground() == Color.red)
						view.getTassaAmmissione().setBackground(Color.white);
				}

				if (validazione) {
					boolean esito = model.inserisciSocio(new Socio(cf, nome, cognome, sex, Date.valueOf(dataNascita),
							luogoNascita, indirizzo, citta, cap, email, telefono, professione, statoCivile, coniuge,
							Date.valueOf(dataAmmissione), Float.valueOf(tassaAmmissione), modPagamento, metPagamento,
							tipologia));

					if (esito) {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Inserimento Effettuato");
						inserimentoSocio();
						view.getFrame().dispose();
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
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminController adminController = new AdminController();
				adminController.controlloEvento();
				view.getFrame().dispose();
			}
		});
	}

	/**
	 * Metodo che gestisce gli eventi generati della VisualizzaSociView, 
	 * in particolare la selezione di un socio, la modifica, l'eliminazione, la dimissione, l'espulsione e il ritorno alla dashboard
	 */
	public void visualizzazioneSoci() {
		VisualizzaSociView view = new VisualizzaSociView(model.elencoSoci());
		view.getFrame().setVisible(true);

		view.getList().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Socio n = view.getList().getSelectedValue();
				view.getCf().setText(n.getCf());
				view.getNome().setText(n.getNome());
				view.getCognome().setText(n.getCognome());
				if (n.getSesso() == 'M')
					view.getRdbtnUomo().setSelected(true);
				else
					view.getRdbtnDonna().setSelected(true);

				view.getDataNascita().setText(n.getDataNascita().toString());
				view.getLuogoNascita().setText(n.getLuogoNascita());
				view.getIndirizzo().setText(n.getIndirizzo());
				view.getCitta().setText(n.getCitta());
				view.getCap().setText(n.getCap());
				view.getEmail().setText(n.getEmail());
				view.getTelefono().setText(n.getTelefono());
				view.getProfessione().setText(n.getProfessione());
				view.getStatoCivile().setSelectedItem(n.getStatoCivile());
				view.getConiuge().setText(n.getConiuge());
				view.getDataAmmissione().setText(n.getDataAmmissione().toString());
				view.getTassaAmmissione().setText(String.valueOf(n.getTassaAmmissione()));
				view.getModPagamento().setSelectedItem(n.getModPagamento());
				view.getMetPagamento().setSelectedItem(n.getMetPagamento());
				view.getTipologia().setSelectedItem(n.getTipologia());
				view.getBtnModifica().setVisible(true);
				view.getBtnDiventaExsocio().setVisible(true);
				view.getBtnElimina().setVisible(true);
				view.getBtnEspelli().setVisible(true);
				view.getBtnAnnulla().setVisible(true);
			}
		});

		view.getBtnModifica().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				view.getBtnDiventaExsocio().setVisible(false);
				view.getBtnElimina().setVisible(false);
				view.getBtnEspelli().setVisible(false);
				view.getBtnModifica().setVisible(false);
				view.getBtnAggiorna().setVisible(true);
				view.getCf().setEnabled(true);
				view.getNome().setEnabled(true);
				view.getCognome().setEnabled(true);
				view.getRdbtnUomo().setEnabled(true);
				view.getRdbtnDonna().setEnabled(true);
				view.getDataNascita().setEnabled(true);
				view.getLuogoNascita().setEnabled(true);
				view.getIndirizzo().setEnabled(true);
				view.getCitta().setEnabled(true);
				view.getCap().setEnabled(true);
				view.getEmail().setEnabled(true);
				view.getTelefono().setEnabled(true);
				view.getProfessione().setEnabled(true);
				view.getStatoCivile().setEnabled(true);
				view.getConiuge().setEnabled(true);
				view.getDataAmmissione().setEnabled(true);
				view.getTassaAmmissione().setEnabled(true);
				view.getModPagamento().setEnabled(true);
				view.getMetPagamento().setEnabled(true);
				view.getTipologia().setEnabled(true);
			}

		});

		view.getBtnAggiorna().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				char sex;
				if (view.getRdbtnUomo().isSelected())
					sex = 'M';
				else
					sex = 'F';

				String cf = view.getCf().getText().toUpperCase();
				String nome = view.getNome().getText().toUpperCase();
				String cognome = view.getCognome().getText().toUpperCase();
				String dataNascita = view.getDataNascita().getText();
				String luogoNascita = view.getLuogoNascita().getText().toUpperCase();
				String indirizzo = view.getIndirizzo().getText().toUpperCase();
				String citta = view.getCitta().getText().toUpperCase();
				String cap = view.getCap().getText();
				String email = view.getEmail().getText().toUpperCase();
				String telefono = view.getTelefono().getText();
				String professione = view.getProfessione().getText().toUpperCase();
				String statoCivile = view.getStatoCivile().getSelectedItem().toString().toUpperCase();
				String coniuge = null;
				if (view.getConiuge().getText().length() > 0) {
					coniuge = view.getConiuge().getText().toUpperCase();
				}
				String dataAmmissione = view.getDataAmmissione().getText();
				String tassaAmmissione = view.getTassaAmmissione().getText();
				String modPagamento = view.getModPagamento().getSelectedItem().toString().toUpperCase();
				String metPagamento = view.getMetPagamento().getSelectedItem().toString().toUpperCase();
				String tipologia = view.getTipologia().getSelectedItem().toString().toUpperCase();

				boolean validazione = true;
				if (!Validator.validaCf(cf)) {
					view.getCf().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getCf().getBackground() == Color.red)
						view.getCf().setBackground(Color.white);
				}
				if (!Validator.validaAnagrafica(nome)) {
					view.getNome().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getNome().getBackground() == Color.red)
						view.getNome().setBackground(Color.white);
				}
				if (!Validator.validaAnagrafica(cognome)) {
					view.getCognome().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getCognome().getBackground() == Color.red)
						view.getCognome().setBackground(Color.white);
				}
				if (!Validator.validaData(dataNascita)) {
					view.getDataNascita().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getDataNascita().getBackground() == Color.red)
						view.getDataNascita().setBackground(Color.white);
				}
				if (!Validator.validaCitta(luogoNascita)) {
					view.getLuogoNascita().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getLuogoNascita().getBackground() == Color.red)
						view.getLuogoNascita().setBackground(Color.white);
				}
				if (!Validator.validaIndirizzo(indirizzo)) {
					view.getIndirizzo().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getIndirizzo().getBackground() == Color.red)
						view.getIndirizzo().setBackground(Color.white);
				}
				if (!Validator.validaCitta(citta)) {
					view.getCitta().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getCitta().getBackground() == Color.red)
						view.getCitta().setBackground(Color.white);
				}
				if (!Validator.validaCap(cap)) {
					view.getCap().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getCap().getBackground() == Color.red)
						view.getCap().setBackground(Color.white);
				}
				if (!Validator.validaEmail(email)) {
					view.getEmail().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getEmail().getBackground() == Color.red)
						view.getEmail().setBackground(Color.white);
				}
				if (!Validator.validaTel(telefono)) {
					view.getTelefono().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getTelefono().getBackground() == Color.red)
						view.getTelefono().setBackground(Color.white);
				}
				if (!Validator.validaProfessione(professione)) {
					view.getProfessione().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getProfessione().getBackground() == Color.red)
						view.getProfessione().setBackground(Color.white);
				}
				if (coniuge != null) {
					if (!Validator.validaAnagrafica(coniuge)) {
						view.getConiuge().setBackground(Color.red);
						validazione = false;
					} else {
						if (view.getConiuge().getBackground() == Color.red)
							view.getConiuge().setBackground(Color.white);
					}
				}
				if (!Validator.validaData(dataAmmissione)) {
					view.getDataAmmissione().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getDataAmmissione().getBackground() == Color.red)
						view.getDataAmmissione().setBackground(Color.white);
				}
				if (!Validator.validaImporto(tassaAmmissione)) {
					view.getTassaAmmissione().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getTassaAmmissione().getBackground() == Color.red)
						view.getTassaAmmissione().setBackground(Color.white);
				}
				if (validazione) {
					if (model.modificaSocio(new Socio(cf, nome, cognome, sex, Date.valueOf(dataNascita), luogoNascita,
							indirizzo, citta, cap, email, telefono, professione, statoCivile, coniuge,
							Date.valueOf(dataAmmissione), Float.valueOf(tassaAmmissione), modPagamento, metPagamento,
							tipologia), view.getList().getSelectedValue().getCf())) {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Socio Aggiornato");
						visualizzazioneSoci();
						view.getFrame().dispose();

					} else {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Socio non aggiornato");
					}

				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(),
							"Campi non validi, modificare i campi contrassegnati in rosso");
				}

			}
		});

		view.getBtnDiventaExsocio().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String data;
				do {
					data = JOptionPane.showInputDialog("Inserisci la data di dimissione");
				} while (!Validator.validaData(data));
				if (model.diventaExSocio(new ExSocio(view.getList().getSelectedValue(), Date.valueOf(data), false))) {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Passaggio Effettuato");
					visualizzazioneSoci();
					view.getFrame().dispose();
				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Passaggio Non Effettuato");
				}
			}
		});

		view.getBtnEspelli().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String data;
				do {
					data = JOptionPane.showInputDialog("Inserisci la data di espulsione");
				} while (!Validator.validaData(data));
				if (model.diventaExSocio(new ExSocio(view.getList().getSelectedValue(), Date.valueOf(data), true))) {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Espulsione Effettuata");
					visualizzazioneSoci();
					view.getFrame().dispose();
				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Espulsione Non Effettuata");
				}
			}
		});

		view.getBtnElimina().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (model.eliminaSocio(view.getList().getSelectedValue())) {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Eliminato correttamente");
					visualizzazioneSoci();
					view.getFrame().dispose();
				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Eliminazione non effettuata");
				}
			}
		});
		
		view.getBtnAnnulla().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				visualizzazioneSoci();
				view.getFrame().dispose();
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

	/**
	 * Metodo che si occupa della gestione degli eventi generati dalla GestioneFigliView,
	 * in particolare l'inserimento, modifica, eliminazione di un figlio e il ritorno alla dashboard
	 */
	public void gestioneFigli() {
		GestioneFigliView view = new GestioneFigliView(model.elencoFigli(null), model.elencoSoci());
		view.getFrame().setVisible(true);

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
				String cf = view.getCf().getText().toUpperCase();
				String nome = view.getNome().getText().toUpperCase();
				char sesso;
				if (view.getRdbtnUomo().isSelected()) {
					sesso = 'M';
				} else {
					sesso = 'F';
				}
				String dataNascita = view.getDataNascita().getText();
				Socio genitore = (Socio) view.getGenitore().getSelectedItem();
				Boolean aCarico;
				if (view.getRdbtnSi().isSelected())
					aCarico = true;
				else
					aCarico = false;

				Boolean validazione = true;
				if (!Validator.validaCf(cf)) {
					view.getCf().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getCf().getBackground() == Color.red)
						view.getCf().setBackground(Color.white);
				}
				if (!Validator.validaAnagrafica(nome)) {
					view.getNome().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getNome().getBackground() == Color.red)
						view.getNome().setBackground(Color.white);
				}
				if (!Validator.validaData(dataNascita)) {
					view.getDataNascita().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getDataNascita().getBackground() == Color.red)
						view.getDataNascita().setBackground(Color.white);
				}
				if (validazione) {
					if (model.inserisciFiglio(
							new Figlio(cf, nome, sesso, Date.valueOf(dataNascita), genitore, aCarico))) {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Inserimento Effettuato");
						gestioneFigli();
						view.getFrame().dispose();
					} else {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Inserimento Non Effettuato");
					}

				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(),
							"Campi non validi, modificare i campi contrassegnati in rosso");
				}
			}
		});

		view.getFiltro().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (view.getFiltro().getSelectedItem() != null) {
					Socio genitore = (Socio) view.getFiltro().getSelectedItem();
					ArrayList<Figlio> figli = model.elencoFigli(genitore.getCf());
					DefaultListModel<Figlio> dlm = new DefaultListModel<Figlio>();
					figli.stream().forEach((f) -> {
						dlm.addElement(f);
					});
					view.getList().setModel(dlm);
				}
			}
		});

		view.getList().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				view.getCf().setEnabled(false);
				view.getNome().setEnabled(false);
				view.getRdbtnDonna().setEnabled(false);
				view.getRdbtnUomo().setEnabled(false);
				view.getDataNascita().setEnabled(false);
				view.getGenitore().setEnabled(false);
				view.getRdbtnSi().setEnabled(false);
				view.getRdbtnNo().setEnabled(false);

				Figlio figlio = view.getList().getSelectedValue();
				view.getCf().setText(figlio.getCf());
				view.getNome().setText(figlio.getNome());
				if (figlio.getSesso() == 'M') {
					view.getRdbtnUomo().setSelected(true);
				} else {
					view.getRdbtnDonna().setSelected(true);
				}
				view.getDataNascita().setText(figlio.getDataNascita().toString());
				view.getGenitore().setSelectedItem(figlio.getGenitore());
				if (figlio.getACarico()) {
					view.getRdbtnSi().setSelected(true);
				} else {
					view.getRdbtnNo().setSelected(false);
				}
				view.getBtnElimina().setVisible(true);
				view.getBtnModifica().setVisible(true);
				view.getBtnAnnulla().setVisible(true);
			}

		});

		view.getBtnElimina().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (model.eliminaFiglio(view.getList().getSelectedValue())) {
					gestioneFigli();
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
				view.getCf().setEnabled(true);
				view.getNome().setEnabled(true);
				view.getRdbtnDonna().setEnabled(true);
				view.getRdbtnUomo().setEnabled(true);
				view.getDataNascita().setEnabled(true);
				view.getGenitore().setEnabled(true);
				view.getRdbtnSi().setEnabled(true);
				view.getRdbtnNo().setEnabled(true);
				view.getBtnAggiorna().setVisible(true);
				view.getBtnElimina().setVisible(false);
				view.getBtnModifica().setVisible(false);
				view.getBtnInserisci().setVisible(false);
			}
		});

		view.getBtnAggiorna().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cf = view.getCf().getText().toUpperCase();
				String nome = view.getNome().getText().toUpperCase();
				char sesso;
				if (view.getRdbtnUomo().isSelected()) {
					sesso = 'M';
				} else {
					sesso = 'F';
				}
				String dataNascita = view.getDataNascita().getText();
				Socio genitore = (Socio) view.getGenitore().getSelectedItem();
				Boolean aCarico;
				if (view.getRdbtnSi().isSelected())
					aCarico = true;
				else
					aCarico = false;

				Boolean validazione = true;
				if (!Validator.validaCf(cf)) {
					view.getCf().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getCf().getBackground() == Color.red)
						view.getCf().setBackground(Color.white);
				}
				if (!Validator.validaAnagrafica(nome)) {
					view.getNome().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getCf().getBackground() == Color.red)
						view.getNome().setBackground(Color.white);
				}
				if (!Validator.validaData(dataNascita)) {
					view.getDataNascita().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getDataNascita().getBackground() == Color.red)
						view.getDataNascita().setBackground(Color.white);
				}
				if (validazione) {
					if (model.modificaFiglio(new Figlio(cf, nome, sesso, Date.valueOf(dataNascita), genitore, aCarico),
							view.getList().getSelectedValue().getCf())) {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Aggiornamento Effettuato");
						gestioneFigli();
						view.getFrame().dispose();
					} else {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Aggiornamento Non Effettuato");
					}

				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(),
							"Campi non validi, modificare i campi contrassegnati in rosso");
				}
			}
		});
		
		view.getBtnAnnulla().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				gestioneFigli();
				view.getFrame().dispose();
			}
		});

	}

	/**
	 * Metodo che si occupa della gestione degli eventi generati dalla GestioneNonSocioView, 
	 * in particolare inserimento, modifica, eliminazione di un non socio e il ritorno alla dashboard
	 */
	public void gestioneNonSocio() {
		GestioneNonSocioView view = new GestioneNonSocioView(model.elencoNonSoci());
		view.getFrame().setVisible(true);
		view.getBtnInserisci().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cf = view.getCf().getText().toUpperCase();
				String nome = view.getNome().getText().toUpperCase();
				String cognome = view.getCognome().getText().toUpperCase();
				char sesso;
				if (view.getRdbtnUomo().isSelected()) {
					sesso = 'M';
				} else {
					sesso = 'F';
				}
				String email = view.getEmail().getText().toUpperCase();
				String telefono = view.getTelefono().getText().toUpperCase();

				Boolean validazione = true;
				if (!Validator.validaCf(cf)) {
					view.getCf().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getCf().getBackground() == Color.red)
						view.getCf().setBackground(Color.white);
				}
				if (!Validator.validaAnagrafica(nome)) {
					view.getNome().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getNome().getBackground() == Color.red)
						view.getNome().setBackground(Color.white);
				}

				if (!Validator.validaAnagrafica(cognome)) {
					view.getCognome().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getCognome().getBackground() == Color.red)
						view.getCognome().setBackground(Color.white);
				}

				if (!Validator.validaEmail(email)) {
					view.getEmail().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getEmail().getBackground() == Color.red)
						view.getEmail().setBackground(Color.white);
				}

				if (!Validator.validaTel(telefono)) {
					view.getTelefono().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getTelefono().getBackground() == Color.red)
						view.getTelefono().setBackground(Color.white);
				}

				if (validazione) {
					if (model.inserisciNonSocio(new NonSocio(cf, nome, cognome, sesso, email, telefono))) {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Inserimento Effettuato");
						gestioneNonSocio();
						view.getFrame().dispose();
					} else {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Inserimento Non Effettuato");
					}
				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(),
							"Campi non validi, modificare i campi contrassegnati in rosso");
				}
			}
		});

		view.getList().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				view.getCf().setEnabled(false);
				view.getNome().setEnabled(false);
				view.getCognome().setEnabled(false);
				view.getRdbtnDonna().setEnabled(false);
				view.getRdbtnUomo().setEnabled(false);
				view.getEmail().setEnabled(false);
				view.getTelefono().setEnabled(false);

				NonSocio nonSocio = view.getList().getSelectedValue();
				view.getCf().setText(nonSocio.getCf());
				view.getNome().setText(nonSocio.getNome());
				view.getCognome().setText(nonSocio.getCognome());
				if (nonSocio.getSesso() == 'M') {
					view.getRdbtnUomo().setSelected(true);
				} else {
					view.getRdbtnDonna().setSelected(true);
				}
				view.getEmail().setText(nonSocio.getEmail());
				view.getTelefono().setText(nonSocio.getTelefono());

				view.getBtnElimina().setVisible(true);
				view.getBtnModifica().setVisible(true);
				view.getBtnAnnulla().setVisible(true);
			}

		});
		
		view.getBtnAnnulla().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				gestioneNonSocio();
				view.getFrame().dispose();
			}
		});

		view.getBtnModifica().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				view.getCf().setEnabled(true);
				view.getNome().setEnabled(true);
				view.getCognome().setEnabled(true);
				view.getRdbtnDonna().setEnabled(true);
				view.getRdbtnUomo().setEnabled(true);
				view.getEmail().setEnabled(true);
				view.getTelefono().setEnabled(true);

				view.getBtnAggiorna().setVisible(true);
				view.getBtnElimina().setVisible(false);
				view.getBtnModifica().setVisible(false);
				view.getBtnInserisci().setVisible(false);
			}
		});

		view.getBtnAggiorna().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cf = view.getCf().getText().toUpperCase();
				String nome = view.getNome().getText().toUpperCase();
				String cognome = view.getCognome().getText().toUpperCase();
				char sesso;
				if (view.getRdbtnUomo().isSelected()) {
					sesso = 'M';
				} else {
					sesso = 'F';
				}
				String email = view.getEmail().getText().toUpperCase();
				String telefono = view.getTelefono().getText().toUpperCase();

				Boolean validazione = true;
				if (!Validator.validaCf(cf)) {
					view.getCf().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getCf().getBackground() == Color.red)
						view.getCf().setBackground(Color.white);
				}
				if (!Validator.validaAnagrafica(nome)) {
					view.getNome().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getNome().getBackground() == Color.red)
						view.getNome().setBackground(Color.white);
				}

				if (!Validator.validaAnagrafica(cognome)) {
					view.getCognome().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getCognome().getBackground() == Color.red)
						view.getCognome().setBackground(Color.white);
				}

				if (!Validator.validaEmail(email)) {
					view.getEmail().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getEmail().getBackground() == Color.red)
						view.getEmail().setBackground(Color.white);
				}

				if (!Validator.validaTel(telefono)) {
					view.getTelefono().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getTelefono().getBackground() == Color.red)
						view.getTelefono().setBackground(Color.white);
				}

				if (validazione) {
					if (model.modificaNonSocio(new NonSocio(cf, nome, cognome, sesso, email, telefono),
							view.getList().getSelectedValue().getCf())) {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Inserimento Effettuato");
						gestioneNonSocio();
						view.getFrame().dispose();
					} else {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Inserimento Non Effettuato");
					}

				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(),
							"Campi non validi, modificare i campi contrassegnati in rosso");
				}
			}

		});

		view.getBtnElimina().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (model.eliminaNonSocio(view.getList().getSelectedValue())) {
					gestioneNonSocio();
					view.getFrame().dispose();
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Eliminazione Effettuata");

				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Eliminazione Non Effettuata");
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

	/**
	 * Metodo che si occupa della gestione degli eventi generati dalla GestioneExSocioView, 
	 * in particolare inserimento, modifica, eliminazione di un non socio e il ritorno alla dashboard
	 */
	public void gestioneExSocio() {
		GestioneExSocioView view = new GestioneExSocioView(model.elencoExSoci());
		view.getFrame().setVisible(true);
		view.getList().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Socio n = view.getList().getSelectedValue();
				view.getCf().setText(n.getCf());
				view.getNome().setText(n.getNome());
				view.getCognome().setText(n.getCognome());
				if (n.getSesso() == 'M')
					view.getRdbtnUomo().setSelected(true);
				else
					view.getRdbtnDonna().setSelected(true);
				view.getDataNascita().setText(n.getDataNascita().toString());
				view.getLuogoNascita().setText(n.getLuogoNascita());
				view.getIndirizzo().setText(n.getIndirizzo());
				view.getCitta().setText(n.getCitta());
				view.getCap().setText(n.getCap());
				view.getEmail().setText(n.getEmail());
				view.getTelefono().setText(n.getTelefono());
				view.getProfessione().setText(n.getProfessione());
				view.getStatoCivile().setSelectedItem(n.getStatoCivile());
				view.getConiuge().setText(n.getConiuge());
				view.getDataAmmissione().setText(n.getDataAmmissione().toString());
				view.getTassaAmmissione().setText(String.valueOf(n.getTassaAmmissione()));
				view.getBtnDiventaSocio().setVisible(true);
			}
		});

		view.getBtnDiventaSocio().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (view.getList().getSelectedValue().getEspulso()) {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(),
							"La persona selezionata è stata espulsa e non può essere riammessa.");
				} else {
					if (model.diventaSocio(view.getList().getSelectedValue())) {
						JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Aggiornamento Effettuato");
						gestioneExSocio();
						view.getFrame().dispose();
					}
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

	/**
	 * Metodo che si occupa della gestione degli eventi generati dalla PassaggiCategoriaView,
	 * in particolare di effettuare il passaggio e tornare alla dashboard
	 */
	public void passaggiCategoria() {
		PassaggioCategoriaView view = new PassaggioCategoriaView(model.passaggioCategoria());
		view.getFrame().setVisible(true);

		view.getBtnEffettua().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (model.effettuaPassaggioCategoria(view.getList().getSelectedValue())) {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Passaggio Effettuato");
				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(),
							"C'è stato qualche problema, riprova");
				}
				
				passaggiCategoria();
				view.getFrame().dispose();
			}
		});
		
		view.getList().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				view.getLblCategoriaAttuale().setText("Categoria Attuale: " + view.getList().getSelectedValue().getTipologia());
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