/**
 * 
 */
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
import view.InsertQuoteView;
import view.QuoteManagementView;
import entita.Quota;

/**
 * @author smero
 *
 */
public class QuoteController {
	private QuotaModel model;
	private QuoteManagementView viewManagement;
	private InsertQuoteView viewInsert;
	private ArrayList<Quota> quotes;
	private Quota quotapre;

	public QuoteController() {
		model = new QuotaModel();
	}

	public void mostraGestioneQuote() {
		viewManagement = new QuoteManagementView();
		fillTableQuote();
		viewManagement.getFrameGestQuote().setVisible(true);
		controlEventManagement();
	}

	public void mostraInserimentoQuote() {
		viewInsert = new InsertQuoteView();
		viewInsert.getFrame().setVisible(true);
		controlEventInsert();
	}

	public void controlEventInsert() {
		// Riempimento form della quota precedente
		viewInsert.getCmbbxTipologia().addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (viewInsert.getCmbbxTipologia().getSelectedIndex() != -1) {
					quotapre = model.getQuotaPrecendente(viewInsert.getCmbbxTipologia()
							.getItemAt(viewInsert.getCmbbxTipologia().getSelectedIndex()));
					if (quotapre != null) {
						viewInsert.getTxtFieldDataIPre().setText(quotapre.getDataI().toString());
						viewInsert.getTxtFieldValorePre().setText(String.valueOf(quotapre.getValore()));
					}
				}
				if (viewInsert.getCmbbxTipologia().getSelectedIndex() == -1 || quotapre == null) {
					viewInsert.getTxtFieldDataIPre().setText("");
					viewInsert.getTxtFieldValorePre().setText("");
				}
			}
		});

		// Evento inserimento quota
		viewInsert.getBtnInserisci().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (validatorInsertForm()) {
					boolean esito = false;
					Quota quota = null;
					quota = new Quota(Float.valueOf(viewInsert.getTxtFieldValore().getText()).floatValue(),
							viewInsert.getCmbbxTipologia().getSelectedItem().toString(),
							Date.valueOf(viewInsert.getTxtFieldDataI().getText() + "-01"));
					esito = model.insertQuota(quota);
					if (esito) {
						JOptionPane.showMessageDialog(viewInsert.getFrame().getContentPane(), "Quota inserita");
						azzeraInsertForm();
					} else {
						JOptionPane.showMessageDialog(viewInsert.getFrame().getContentPane(),
								"Inserimento non effettuato");
					}
				} else {
					JOptionPane.showMessageDialog(viewInsert.getFrame().getContentPane(),
							"Campi non validi, modificare i campi contrassegnati in rosso");
				}
			}
		});

		// Evento azzeramento form
		viewInsert.getBtnAzzera().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				azzeraInsertForm();
			}
		});

		// Evento ritorno all'AdminView
		viewInsert.getBtnDashboard().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminController adminController = new AdminController();
				adminController.controlloEvento();
				viewInsert.getFrame().dispose();
			}
		});
	}

	public void controlEventManagement() {
		// Evento eliminazione Versamento
		viewManagement.getBtnElimina().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Eliminare la quota?") == 0
						&& viewManagement.getTable().getSelectedRow() != -1) {
					boolean esito = model.deleteQuota(quotes.get(viewManagement.getTable().getSelectedRow()).getId());
					quotes.remove(viewManagement.getTable().getSelectedRow());
					if (esito) {
						JOptionPane.showMessageDialog(viewManagement.getFrameGestQuote().getContentPane(),
								"Versamento eliminato");
						viewManagement.getFrameGestQuote().dispose();
						mostraGestioneQuote();
					} else {
						JOptionPane.showMessageDialog(viewManagement.getFrameGestQuote().getContentPane(),
								"Versamento non eliminato");
					}
				}
			}
		});

		// Evento ritorno all'AdminView
		viewManagement.getBtnDashboard().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminController adminController = new AdminController();
				adminController.controlloEvento();
				viewManagement.getFrameGestQuote().dispose();
			}
		});
	}

	private void fillTableQuote() {
		String[] nameColumns = { "Id", "Data inizio", "Valore", "Tipologia" };
		quotes = new ArrayList<Quota>(model.getQuote());

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
		for (int j = 0; j < quotes.size(); j++) {
			dati.addRow(new Vector<>());
			dati.setValueAt(quotes.get(j).getId(), j, 0);
			dati.setValueAt(quotes.get(j).getDataI(), j, 1);
			dati.setValueAt(quotes.get(j).getValore(), j, 2);
			dati.setValueAt(quotes.get(j).getTipologia(), j, 3);
		}
		viewManagement.getTable().setModel(dati);
	}

	private boolean validatorInsertForm() {
		boolean validazione = true;
		if (!Validator.ValidaDataInizio(viewInsert.getTxtFieldDataI().getText())) {
			viewInsert.getTxtFieldDataI().setBackground(Color.red);
			validazione = false;
		} else {
			if (viewInsert.getTxtFieldDataI().getBackground() == Color.red)
				viewInsert.getTxtFieldDataI().setBackground(Color.white);
		}
		if (!Validator.ValidaImporto(viewInsert.getTxtFieldValore().getText())) {
			viewInsert.getTxtFieldValore().setBackground(Color.red);
			validazione = false;
		} else {
			if (viewInsert.getTxtFieldValore().getBackground() == Color.red)
				viewInsert.getTxtFieldValore().setBackground(Color.white);
		}

		if (!viewInsert.getTxtFieldDataI().getText().equals("")
				&& !viewInsert.getTxtFieldDataIPre().getText().equals("")) {
			if (!Validator.ValidaDataMaggiore(Date.valueOf(viewInsert.getTxtFieldDataIPre().getText()),
					Date.valueOf(viewInsert.getTxtFieldDataI().getText() + "-01"))) {
				viewInsert.getTxtFieldDataI().setBackground(Color.red);
				validazione = false;
			} else {
				if (viewInsert.getTxtFieldDataI().getBackground() == Color.red)
					viewInsert.getTxtFieldDataI().setBackground(Color.white);
			}
		}
		return validazione;
	}

	private void azzeraInsertForm() {
		viewInsert.getCmbbxTipologia().setSelectedIndex(-1);
		viewInsert.getTxtFieldDataI().setText("");
		viewInsert.getTxtFieldValore().setText("");
		viewInsert.getTxtFieldDataI().setBackground(Color.white);
		viewInsert.getTxtFieldValore().setBackground(Color.white);
	}
}
