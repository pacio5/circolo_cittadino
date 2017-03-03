/**
 * 
 */
package controller;

import model.SocioModel;
import utility.Validator;
import view.InserisciSocioView;
import view.GestioneFigliView;

import java.sql.Date;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entita.Figlio;
import entita.Socio;
import controller.AdminController;
import view.VisualizzaSociView;

/**
 * @author eliapacioni
 *
 */
public class SocioController {

	private SocioModel model;

	public SocioController() {
		model = new SocioModel();
	}

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
				if (!Validator.ValidaCf(cf)) {
					view.getCf().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getCf().getBackground() == Color.red)
						view.getCf().setBackground(Color.white);
				}
				if (!Validator.ValidaAnagrafica(nome)) {
					view.getNome().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getCf().getBackground() == Color.red)
						view.getNome().setBackground(Color.white);
				}
				if (!Validator.ValidaAnagrafica(cognome)) {
					view.getCognome().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getCf().getBackground() == Color.red)
						view.getCognome().setBackground(Color.white);
				}
				if (!Validator.ValidaData(dataNascita)) {
					view.getDataNascita().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getDataNascita().getBackground() == Color.red)
						view.getDataNascita().setBackground(Color.white);
				}
				if (!Validator.ValidaAnagrafica(luogoNascita) || luogoNascita.length() > 35) {
					view.getLuogoNascita().setBackground(Color.red);
				} else {
					if (view.getLuogoNascita().getBackground() == Color.red)
						view.getLuogoNascita().setBackground(Color.white);
				}
				if (!Validator.ValidaIndirizzo(indirizzo)) {
					view.getIndirizzo().setBackground(Color.red);
				} else {
					if (view.getIndirizzo().getBackground() == Color.red)
						view.getDataNascita().setBackground(Color.white);
				}
				if (!Validator.ValidaAnagrafica(citta) || citta.length() > 35) {
					view.getCitta().setBackground(Color.red);
				} else {
					if (view.getCitta().getBackground() == Color.red)
						view.getCitta().setBackground(Color.white);
				}
				if (!Validator.ValidaCap(cap)) {
					view.getCap().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getCap().getBackground() == Color.red)
						view.getCap().setBackground(Color.white);
				}
				if (!Validator.ValidaEmail(email)) {
					view.getEmail().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getEmail().getBackground() == Color.red)
						view.getEmail().setBackground(Color.white);
				}
				if (!Validator.ValidaTel(telefono)) {
					view.getTelefono().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getTelefono().getBackground() == Color.red)
						view.getTelefono().setBackground(Color.white);
				}
				if (!Validator.ValidaAnagrafica(professione) || professione.length() > 30) {
					view.getProfessione().setBackground(Color.red);
				} else {
					if (view.getProfessione().getBackground() == Color.red)
						view.getProfessione().setBackground(Color.white);
				}
				if (coniuge != null) {
					if (!Validator.ValidaAnagrafica(coniuge) || coniuge.length() > 20)
						view.getConiuge().setBackground(Color.red);
					else {
						if (view.getConiuge().getBackground() == Color.red)
							view.getConiuge().setBackground(Color.white);
					}
				}
				if (!Validator.ValidaData(dataAmmissione)) {
					view.getDataAmmissione().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getDataAmmissione().getBackground() == Color.red)
						view.getDataAmmissione().setBackground(Color.white);
				}
				if (!Validator.ValidaImporto(tassaAmmissione)) {
					view.getTassaAmmissione().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getTassaAmmissione().getBackground() == Color.red)
						view.getTassaAmmissione().setBackground(Color.white);
				}

				if (validazione) {
					boolean esito = model.InserisciSocio(new Socio(cf, nome, cognome, sex, Date.valueOf(dataNascita),
							luogoNascita, indirizzo, citta, cap, email, telefono, professione, statoCivile, coniuge,
							Date.valueOf(dataAmmissione), Float.valueOf(tassaAmmissione), modPagamento, metPagamento,
							tipologia));

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

	public void visualizzazioneSoci() {
		ArrayList<Socio> soci = model.ElencoSoci();
		VisualizzaSociView view = new VisualizzaSociView(soci);
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
				view.getBtnModifica().setEnabled(true);
				view.getBtnDiventaExsocio().setEnabled(true);
				view.getBtnElimina().setEnabled(true);
				view.getBtnEspelli().setEnabled(true);
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
				if (!Validator.ValidaCf(cf)) {
					view.getCf().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getCf().getBackground() == Color.red)
						view.getCf().setBackground(Color.white);
				}
				if (!Validator.ValidaAnagrafica(nome)) {
					view.getNome().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getCf().getBackground() == Color.red)
						view.getNome().setBackground(Color.white);
				}
				if (!Validator.ValidaAnagrafica(cognome)) {
					view.getCognome().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getCf().getBackground() == Color.red)
						view.getCognome().setBackground(Color.white);
				}
				if (!Validator.ValidaData(dataNascita)) {
					view.getDataNascita().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getDataNascita().getBackground() == Color.red)
						view.getDataNascita().setBackground(Color.white);
				}
				if (!Validator.ValidaCitta(luogoNascita)) {
					view.getLuogoNascita().setBackground(Color.red);
				} else {
					if (view.getLuogoNascita().getBackground() == Color.red)
						view.getLuogoNascita().setBackground(Color.white);
				}
				if (!Validator.ValidaIndirizzo(indirizzo)) {
					view.getIndirizzo().setBackground(Color.red);
				} else {
					if (view.getIndirizzo().getBackground() == Color.red)
						view.getDataNascita().setBackground(Color.white);
				}
				if (!Validator.ValidaCitta(citta)) {
					view.getCitta().setBackground(Color.red);
				} else {
					if (view.getCitta().getBackground() == Color.red)
						view.getCitta().setBackground(Color.white);
				}
				if (!Validator.ValidaCap(cap)) {
					view.getCap().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getCap().getBackground() == Color.red)
						view.getCap().setBackground(Color.white);
				}
				if (!Validator.ValidaEmail(email)) {
					view.getEmail().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getEmail().getBackground() == Color.red)
						view.getEmail().setBackground(Color.white);
				}
				if (!Validator.ValidaTel(telefono)) {
					view.getTelefono().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getTelefono().getBackground() == Color.red)
						view.getTelefono().setBackground(Color.white);
				}
				if (!Validator.ValidaProfessione(professione)) {
					view.getProfessione().setBackground(Color.red);
				} else {
					if (view.getProfessione().getBackground() == Color.red)
						view.getProfessione().setBackground(Color.white);
				}
				if (coniuge != null) {
					if (!Validator.ValidaAnagrafica(coniuge))
						view.getConiuge().setBackground(Color.red);
					else {
						if (view.getConiuge().getBackground() == Color.red)
							view.getConiuge().setBackground(Color.white);
					}
				}
				if (!Validator.ValidaData(dataAmmissione)) {
					view.getDataAmmissione().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getDataAmmissione().getBackground() == Color.red)
						view.getDataAmmissione().setBackground(Color.white);
				}
				if (!Validator.ValidaImporto(tassaAmmissione)) {
					view.getTassaAmmissione().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getTassaAmmissione().getBackground() == Color.red)
						view.getTassaAmmissione().setBackground(Color.white);
				}
				if (validazione) {
					boolean esito = model.ModificaSocio(new Socio(cf, nome, cognome, sex, Date.valueOf(dataNascita),
							luogoNascita, indirizzo, citta, cap, email, telefono, professione, statoCivile, coniuge,
							Date.valueOf(dataAmmissione), Float.valueOf(tassaAmmissione), modPagamento, metPagamento,
							tipologia), view.getList().getSelectedValue().getCf());

					if (esito) {
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
				boolean esito = model.DiventaExSocio(view.getList().getSelectedValue(), false);
				if (esito) {
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
				boolean esito = model.DiventaExSocio(view.getList().getSelectedValue(), true);
				if (esito) {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Espulso correttamente");
					visualizzazioneSoci();
					view.getFrame().dispose();
				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Espulsione non effettuata");
				}
			}
		});

		view.getBtnElimina().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				boolean esito = model.EliminaSocio(view.getList().getSelectedValue());
				if (esito) {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Eliminato correttamente");
					visualizzazioneSoci();
					view.getFrame().dispose();
				} else {
					JOptionPane.showMessageDialog(view.getFrame().getContentPane(), "Eliminazione non effettuata");
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

	public void gestioneFigli() {
		GestioneFigliView view = new GestioneFigliView(model.ElencoFigli(), model.ElencoSoci());
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
				String dataNascita = view.getDataNascita().getText();
				Socio genitore = (Socio) view.getGenitore().getSelectedItem();
				Boolean aCarico;
				if (view.getRdbtnSi().isSelected())
					aCarico = true;
				else
					aCarico = false;

				Boolean validazione = true;
				if (!Validator.ValidaCf(cf)) {
					view.getCf().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getCf().getBackground() == Color.red)
						view.getCf().setBackground(Color.white);
				}
				if (!Validator.ValidaAnagrafica(nome)) {
					view.getNome().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getCf().getBackground() == Color.red)
						view.getNome().setBackground(Color.white);
				}
				if (!Validator.ValidaData(dataNascita)) {
					view.getDataNascita().setBackground(Color.red);
					validazione = false;
				} else {
					if (view.getDataNascita().getBackground() == Color.red)
						view.getDataNascita().setBackground(Color.white);
				}
				if (validazione) {
					boolean esito = model
							.InserisciFiglio(new Figlio(cf, nome, Date.valueOf(dataNascita), genitore, aCarico));

					if (esito) {
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
	}
}