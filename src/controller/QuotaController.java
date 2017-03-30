package controller;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.QuotaModel;
import utility.Validator;
import view.InserimentoQuoteView;
import view.GestioneQuoteView;
import entita.Quota;

/**
 * @author smerilli
 *
 */
public class QuotaController {
	private QuotaModel model;
	private GestioneQuoteView viewGestione;
	private InserimentoQuoteView viewInserimento;
	private ArrayList<Quota> quote;
	private Quota quotapre;

	public QuotaController() {
		model = new QuotaModel();
	}

	public void mostraGestioneQuote() {
		viewGestione = new GestioneQuoteView();
		riempimentoTableQuote();
		viewGestione.getFrameGestQuote().setVisible(true);
		controlloEventiGestione();
	}

	public void mostraInserimentoQuote() {
		viewInserimento = new InserimentoQuoteView();
		viewInserimento.getFrame().setVisible(true);
		controlloEventiInserimento();
	}

	public void controlloEventiInserimento() {
		// Riempimento form della quota precedente
		viewInserimento.getCmbbxTipologia().addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (viewInserimento.getCmbbxTipologia().getSelectedIndex() != -1) {
					quotapre = model.getQuotaPrecendente(viewInserimento.getCmbbxTipologia()
							.getItemAt(viewInserimento.getCmbbxTipologia().getSelectedIndex()));
					if (quotapre != null) {
						viewInserimento.getTxtFieldDataIPre().setText(quotapre.getDataI().toString());
						viewInserimento.getTxtFieldValorePre().setText(String.valueOf(quotapre.getValore()));
					}
				}
				if (viewInserimento.getCmbbxTipologia().getSelectedIndex() == -1 || quotapre == null) {
					viewInserimento.getTxtFieldDataIPre().setText("");
					viewInserimento.getTxtFieldValorePre().setText("");
				}
			}
		});

		// Evento inserimento quota
		viewInserimento.getBtnInserisci().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (validatorForm()) {
					boolean esito = false;
					Quota quota = null;
					quota = new Quota(Float.valueOf(viewInserimento.getTxtFieldValore().getText()).floatValue(),
							viewInserimento.getCmbbxTipologia().getSelectedItem().toString(),
							Date.valueOf(viewInserimento.getTxtFieldDataI().getText() + "-01"));
					esito = model.insertQuota(quota);
					if (esito) {
						JOptionPane.showMessageDialog(viewInserimento.getFrame().getContentPane(), "Quota inserita");
						azzeraInsertForm();
					} else {
						JOptionPane.showMessageDialog(viewInserimento.getFrame().getContentPane(),
								"Inserimento non effettuato");
					}
				} else {
					JOptionPane.showMessageDialog(viewInserimento.getFrame().getContentPane(),
							"Campi non validi, modificare i campi contrassegnati in rosso");
				}
			}
		});

		// Evento azzeramento form
		viewInserimento.getBtnAzzera().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				azzeraInsertForm();
			}
		});

		// Evento ritorno all'AdminView
		viewInserimento.getBtnDashboard().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminController adminController = new AdminController();
				adminController.controlloEvento();
				viewInserimento.getFrame().dispose();
			}
		});
	}

	public void controlloEventiGestione() {
		// Evento eliminazione Versamento
		viewGestione.getBtnElimina().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Eliminare la quota?") == 0
						&& viewGestione.getTable().getSelectedRow() != -1) {
					boolean esito = model.deleteQuota(quote.get(viewGestione.getTable().getSelectedRow()).getId());
					quote.remove(viewGestione.getTable().getSelectedRow());
					if (esito) {
						JOptionPane.showMessageDialog(viewGestione.getFrameGestQuote().getContentPane(),
								"Versamento eliminato");
						viewGestione.getFrameGestQuote().dispose();
						mostraGestioneQuote();
					} else {
						JOptionPane.showMessageDialog(viewGestione.getFrameGestQuote().getContentPane(),
								"Versamento non eliminato");
					}
				}
			}
		});

		// Evento ritorno all'AdminView
		viewGestione.getBtnDashboard().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminController adminController = new AdminController();
				adminController.controlloEvento();
				viewGestione.getFrameGestQuote().dispose();
			}
		});
	}

	private void riempimentoTableQuote() {
		String[] nameColumns = { "Id", "Data inizio", "Valore", "Tipologia" };
		quote = new ArrayList<Quota>(model.getQuote());

		/*
		 * Istanza del TableModel con l'override di isCellEditable per rendere
		 * la tabella non modificabile
		 */
		DefaultTableModel dati = new DefaultTableModel(nameColumns, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		for (int j = 0; j < quote.size(); j++) {
			dati.addRow(new Vector<>());
			dati.setValueAt(quote.get(j).getId(), j, 0);
			dati.setValueAt(quote.get(j).getDataI(), j, 1);
			dati.setValueAt(quote.get(j).getValore(), j, 2);
			dati.setValueAt(quote.get(j).getTipologia(), j, 3);
		}
		viewGestione.getTable().setModel(dati);
	}

	private boolean validatorForm() {
		boolean validazione = true;
		if (!Validator.validaDataInizio(viewInserimento.getTxtFieldDataI().getText())) {
			viewInserimento.getTxtFieldDataI().setBackground(Color.red);
			validazione = false;
		} else {
			if (viewInserimento.getTxtFieldDataI().getBackground() == Color.red)
				viewInserimento.getTxtFieldDataI().setBackground(Color.white);
		}
		if (!Validator.validaImporto(viewInserimento.getTxtFieldValore().getText())) {
			viewInserimento.getTxtFieldValore().setBackground(Color.red);
			validazione = false;
		} else {
			if (viewInserimento.getTxtFieldValore().getBackground() == Color.red)
				viewInserimento.getTxtFieldValore().setBackground(Color.white);
		}

		if (!viewInserimento.getTxtFieldDataI().getText().equals("")
				&& !viewInserimento.getTxtFieldDataIPre().getText().equals("")) {
			if (!Date.valueOf(viewInserimento.getTxtFieldDataIPre().getText()).before(Date.valueOf(viewInserimento.getTxtFieldDataI().getText() + "-01"))
					) {
				viewInserimento.getTxtFieldDataI().setBackground(Color.red);
				validazione = false;
			} else {
				if (viewInserimento.getTxtFieldDataI().getBackground() == Color.red)
					viewInserimento.getTxtFieldDataI().setBackground(Color.white);
			}
		}
		return validazione;
	}

	private void azzeraInsertForm() {
		viewInserimento.getCmbbxTipologia().setSelectedIndex(-1);
		viewInserimento.getTxtFieldDataI().setText("");
		viewInserimento.getTxtFieldValore().setText("");
		viewInserimento.getTxtFieldDataI().setBackground(Color.white);
		viewInserimento.getTxtFieldValore().setBackground(Color.white);
	}
}
