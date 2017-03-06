package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.Color;
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.lang.Float;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import java.sql.Date;

import entita.Versamento;
import entita.Socio;
import view.InsertSpillView;
import view.SpillManagementView;
import model.QuotaModel;
import model.SocioModel;

import utility.Validator;

public class SpillController {
	private InsertSpillView viewInsert;
	private SpillManagementView viewManagement;
	private QuotaModel model;
	private ArrayList<Socio> soci;
	private ArrayList<Versamento> spills;
	private float importo;

	public SpillController() {
		model = new QuotaModel();
	}

	public void mostraGestioneVers() {
		viewManagement = new SpillManagementView();
		fillTableSpill();
		viewManagement.getFrameGestVersamento().setVisible(true);
		controlEventManagement();
	}

	public void mostraInserimentoVers() {
		viewInsert = new InsertSpillView();
		viewInsert.getFrameInsVersamento().setVisible(true);
		fillCmbbxSoci();
		controlEventInsert();
	}

	private void controlEventManagement() {
		// Evento riempimento form
		viewManagement.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (viewManagement.getTable().getSelectedRow() != -1) {
					azzeraFormManagement();
					viewManagement.getTxtFieldData()
							.setText(spills.get(viewManagement.getTable().getSelectedRow()).getData().toString());
					viewManagement.getTxtFieldImporto().setText(
							String.valueOf(spills.get(viewManagement.getTable().getSelectedRow()).getImporto()));
					viewManagement.getTextAreaDescrizione()
							.setText(spills.get(viewManagement.getTable().getSelectedRow()).getDescrizione());
					fillChckbxMesi();
				}
			}
		});

		// Evento modifica Versamento
		viewManagement.getBtnModifica().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (validatorManagementForm()) {
					spills.get(viewManagement.getTable().getSelectedRow())
							.setData(Date.valueOf(viewManagement.getTxtFieldData().getText()));
					spills.get(viewManagement.getTable().getSelectedRow())
							.setImporto(Float.valueOf(viewManagement.getTxtFieldImporto().getText()).floatValue());
					spills.get(viewManagement.getTable().getSelectedRow())
							.setDescrizione(viewManagement.getTextAreaDescrizione().getText());
					spills.get(viewManagement.getTable().getSelectedRow()).cloneSpill(
							insertMesiCheckedManagement(spills.get(viewManagement.getTable().getSelectedRow())));
					boolean esito = model
							.updateVersamento(spills.get(viewManagement.getTable().getSelectedRow()));
					((DefaultTableModel) viewManagement.getTable().getModel()).setValueAt(
							spills.get(viewManagement.getTable().getSelectedRow()).getData(),
							viewManagement.getTable().getSelectedRow(), 1);
					((DefaultTableModel) viewManagement.getTable().getModel()).setValueAt(
							spills.get(viewManagement.getTable().getSelectedRow()).getImporto(),
							viewManagement.getTable().getSelectedRow(), 2);
					((DefaultTableModel) viewManagement.getTable().getModel()).setValueAt(
							spills.get(viewManagement.getTable().getSelectedRow()).getSocio(),
							viewManagement.getTable().getSelectedRow(), 3);
					((DefaultTableModel) viewManagement.getTable().getModel()).setValueAt(
							spills.get(viewManagement.getTable().getSelectedRow()).getDescrizione(),
							viewManagement.getTable().getSelectedRow(), 4);
					if (esito) {
						JOptionPane.showMessageDialog(viewManagement.getFrameGestVersamento().getContentPane(),
								"Versamento modificato");
						azzeraFormManagement();
					} else {
						JOptionPane.showMessageDialog(viewManagement.getFrameGestVersamento().getContentPane(),
								"Aggiornamento non effettuato");
					}
				} else {
					JOptionPane.showMessageDialog(viewManagement.getFrameGestVersamento().getContentPane(),
							"Campi non validi, modificare i campi contrassegnati in rosso");
				}
			}
		});

		// Evento eliminazione Versamento
		viewManagement.getBtnElimina().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Eliminare il versamento?") == 0
						&& viewManagement.getTable().getSelectedRow() != -1) {
					boolean esito = model
							.deleteVersamento(spills.get(viewManagement.getTable().getSelectedRow()).getId());
					spills.remove(viewManagement.getTable().getSelectedRow());
					if (esito) {
						JOptionPane.showMessageDialog(viewManagement.getFrameGestVersamento().getContentPane(),
								"Versamento eliminato");
						viewManagement.getFrameGestVersamento().dispose();
						mostraGestioneVers();
					} else {
						JOptionPane.showMessageDialog(viewManagement.getFrameGestVersamento().getContentPane(),
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
				viewManagement.getFrameGestVersamento().dispose();
			}
		});
	}

	private void controlEventInsert() {
		// Evento inserimento
		viewInsert.getBtnInserisci().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (validatorInsertForm()) {
					Versamento spill = new Versamento(
							Float.valueOf(viewInsert.getTxtFieldImporto().getText()).floatValue(),
							viewInsert.getTxtFieldCodFisc().getText(),
							Date.valueOf(viewInsert.getTxtFieldData().getText()),
							viewInsert.getTxtFieldDescrizione().getText().toUpperCase());
					insertMesiCheckedInsert(spill);
					boolean esito = model.insertVersamento(spill);
					if (esito) {
						JOptionPane.showMessageDialog(viewInsert.getFrameInsVersamento().getContentPane(),
								"Versamento inserito");
						azzeraFormInsert();
					} else {
						JOptionPane.showMessageDialog(viewInsert.getFrameInsVersamento().getContentPane(),
								"Inserimento non effettuato");
					}
				} else {
					JOptionPane.showMessageDialog(viewInsert.getFrameInsVersamento().getContentPane(),
							"Campi non validi, modificare i campi contrassegnati in rosso");
				}
			}
		});

		// Evento azzeramento form
		viewInsert.getBtnAzzera().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				azzeraFormInsert();
			}
		});

		// Evento riempimento informazioni Socio
		viewInsert.getCmbbxSocio().addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (viewInsert.getCmbbxSocio().getSelectedIndex() != -1) {
					viewInsert.getTxtFieldCodFisc()
							.setText(soci.get(viewInsert.getCmbbxSocio().getSelectedIndex()).getCf());
					viewInsert.getTxtFieldModPagamento()
							.setText(soci.get(viewInsert.getCmbbxSocio().getSelectedIndex()).getModPagamento());
					viewInsert.getTxtFieldMetPagamento()
							.setText(soci.get(viewInsert.getCmbbxSocio().getSelectedIndex()).getMetPagamento());
					viewInsert.getTxtFieldTipologia()
							.setText(soci.get(viewInsert.getCmbbxSocio().getSelectedIndex()).getTipologia());
					viewInsert.getTxtFieldTelefono()
							.setText(soci.get(viewInsert.getCmbbxSocio().getSelectedIndex()).getTelefono());
					viewInsert.getTxtFieldEmail()
							.setText(soci.get(viewInsert.getCmbbxSocio().getSelectedIndex()).getEmail());
				} else {
					viewInsert.getTxtFieldCodFisc().setText("");
					viewInsert.getTxtFieldModPagamento().setText("");
					viewInsert.getTxtFieldMetPagamento().setText("");
					viewInsert.getTxtFieldTipologia().setText("");
					viewInsert.getTxtFieldTelefono().setText("");
					viewInsert.getTxtFieldEmail().setText("");
				}
			}
		});
		
		// Evento calcolo importo
		viewInsert.getChckbxGennaio().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Date mensilita = Date.valueOf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-01-01");
				importo = model.getImportoMese(viewInsert.getTxtFieldTipologia().getText(), mensilita);
				if (viewInsert.getChckbxGennaio().isSelected())
					viewInsert.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInsert.getTxtFieldImporto().getText()).floatValue() + importo));
				else
					viewInsert.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInsert.getTxtFieldImporto().getText()).floatValue() - importo));
			}
		});

		viewInsert.getChckbxFebbraio().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Date mensilita = Date.valueOf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-02-01");
				importo = model.getImportoMese(viewInsert.getTxtFieldTipologia().getText(), mensilita);
				if (viewInsert.getChckbxFebbraio().isSelected())
					viewInsert.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInsert.getTxtFieldImporto().getText()).floatValue() + importo));
				else
					viewInsert.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInsert.getTxtFieldImporto().getText()).floatValue() - importo));
			}
		});
		
		viewInsert.getChckbxMarzo().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Date mensilita = Date.valueOf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-03-01");
				importo = model.getImportoMese(viewInsert.getTxtFieldTipologia().getText(), mensilita);
				if (viewInsert.getChckbxMarzo().isSelected())
					viewInsert.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInsert.getTxtFieldImporto().getText()).floatValue() + importo));
				else
					viewInsert.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInsert.getTxtFieldImporto().getText()).floatValue() - importo));
			}
		});
		
		viewInsert.getChckbxAprile().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Date mensilita = Date.valueOf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-04-01");
				importo = model.getImportoMese(viewInsert.getTxtFieldTipologia().getText(), mensilita);
				if (viewInsert.getChckbxAprile().isSelected())
					viewInsert.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInsert.getTxtFieldImporto().getText()).floatValue() + importo));
				else
					viewInsert.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInsert.getTxtFieldImporto().getText()).floatValue() - importo));
			}
		});
		
		viewInsert.getChckbxMaggio().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Date mensilita = Date.valueOf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-05-01");
				importo = model.getImportoMese(viewInsert.getTxtFieldTipologia().getText(), mensilita);
				if (viewInsert.getChckbxMaggio().isSelected())
					viewInsert.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInsert.getTxtFieldImporto().getText()).floatValue() + importo));
				else
					viewInsert.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInsert.getTxtFieldImporto().getText()).floatValue() - importo));
			}
		});
		
		viewInsert.getChckbxGiugno().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Date mensilita = Date.valueOf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-06-01");
				importo = model.getImportoMese(viewInsert.getTxtFieldTipologia().getText(), mensilita);
				if (viewInsert.getChckbxGiugno().isSelected())
					viewInsert.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInsert.getTxtFieldImporto().getText()).floatValue() + importo));
				else
					viewInsert.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInsert.getTxtFieldImporto().getText()).floatValue() - importo));
			}
		});
		
		viewInsert.getChckbxLuglio().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Date mensilita = Date.valueOf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-07-01");
				importo = model.getImportoMese(viewInsert.getTxtFieldTipologia().getText(), mensilita);
				if (viewInsert.getChckbxLuglio().isSelected())
					viewInsert.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInsert.getTxtFieldImporto().getText()).floatValue() + importo));
				else
					viewInsert.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInsert.getTxtFieldImporto().getText()).floatValue() - importo));
			}
		});
		
		viewInsert.getChckbxAgosto().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Date mensilita = Date.valueOf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-08-01");
				importo = model.getImportoMese(viewInsert.getTxtFieldTipologia().getText(), mensilita);
				if (viewInsert.getChckbxAgosto().isSelected())
					viewInsert.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInsert.getTxtFieldImporto().getText()).floatValue() + importo));
				else
					viewInsert.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInsert.getTxtFieldImporto().getText()).floatValue() - importo));
			}
		});
		
		viewInsert.getChckbxSettembre().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Date mensilita = Date.valueOf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-09-01");
				importo = model.getImportoMese(viewInsert.getTxtFieldTipologia().getText(), mensilita);
				if (viewInsert.getChckbxSettembre().isSelected())
					viewInsert.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInsert.getTxtFieldImporto().getText()).floatValue() + importo));
				else
					viewInsert.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInsert.getTxtFieldImporto().getText()).floatValue() - importo));
			}
		});
		
		viewInsert.getChckbxOttobre().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Date mensilita = Date.valueOf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-10-01");
				importo = model.getImportoMese(viewInsert.getTxtFieldTipologia().getText(), mensilita);
				if (viewInsert.getChckbxOttobre().isSelected())
					viewInsert.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInsert.getTxtFieldImporto().getText()).floatValue() + importo));
				else
					viewInsert.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInsert.getTxtFieldImporto().getText()).floatValue() - importo));
			}
		});
		
		viewInsert.getChckbxNovembre().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Date mensilita = Date.valueOf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-11-01");
				importo = model.getImportoMese(viewInsert.getTxtFieldTipologia().getText(), mensilita);
				if (viewInsert.getChckbxNovembre().isSelected())
					viewInsert.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInsert.getTxtFieldImporto().getText()).floatValue() + importo));
				else
					viewInsert.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInsert.getTxtFieldImporto().getText()).floatValue() - importo));
			}
		});
		
		viewInsert.getChckbxDicembre().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Date mensilita = Date.valueOf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-12-01");
				importo = model.getImportoMese(viewInsert.getTxtFieldTipologia().getText(), mensilita);
				if (viewInsert.getChckbxDicembre().isSelected())
					viewInsert.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInsert.getTxtFieldImporto().getText()).floatValue() + importo));
				else
					viewInsert.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInsert.getTxtFieldImporto().getText()).floatValue() - importo));
			}
		});

		// Evento ritorno all'AdminView
		viewInsert.getBtnDashboard().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminController adminController = new AdminController();
				adminController.controlloEvento();
				viewInsert.getFrameInsVersamento().dispose();
			}
		});
	}

	private void azzeraFormInsert() {
		viewInsert.getCmbbxSocio().setSelectedIndex(-1);
		viewInsert.getTxtFieldData().setText("");
		viewInsert.getTxtFieldImporto().setText("");
		viewInsert.getTxtFieldDescrizione().setText("");
		viewInsert.getChckbxGennaio().setSelected(false);
		viewInsert.getChckbxFebbraio().setSelected(false);
		viewInsert.getChckbxMarzo().setSelected(false);
		viewInsert.getChckbxAprile().setSelected(false);
		viewInsert.getChckbxMaggio().setSelected(false);
		viewInsert.getChckbxGiugno().setSelected(false);
		viewInsert.getChckbxLuglio().setSelected(false);
		viewInsert.getChckbxAgosto().setSelected(false);
		viewInsert.getChckbxSettembre().setSelected(false);
		viewInsert.getChckbxOttobre().setSelected(false);
		viewInsert.getChckbxNovembre().setSelected(false);
		viewInsert.getChckbxDicembre().setSelected(false);
	}

	private void azzeraFormManagement() {
		viewManagement.getTxtFieldData().setText("");
		viewManagement.getTxtFieldImporto().setText("");
		viewManagement.getTextAreaDescrizione().setText("");
		viewManagement.getChckbxGennaio().setSelected(false);
		viewManagement.getChckbxFebbraio().setSelected(false);
		viewManagement.getChckbxMarzo().setSelected(false);
		viewManagement.getChckbxAprile().setSelected(false);
		viewManagement.getChckbxMaggio().setSelected(false);
		viewManagement.getChckbxGiugno().setSelected(false);
		viewManagement.getChckbxLuglio().setSelected(false);
		viewManagement.getChckbxAgosto().setSelected(false);
		viewManagement.getChckbxSettembre().setSelected(false);
		viewManagement.getChckbxOttobre().setSelected(false);
		viewManagement.getChckbxNovembre().setSelected(false);
		viewManagement.getChckbxDicembre().setSelected(false);
	}

	private Versamento insertMesiCheckedInsert(Versamento spill) {
		if (viewInsert.getChckbxGennaio().isSelected())
			spill.setMese(viewInsert.getChckbxGennaio().getText());
		if (viewInsert.getChckbxFebbraio().isSelected())
			spill.setMese(viewInsert.getChckbxFebbraio().getText());
		if (viewInsert.getChckbxMarzo().isSelected())
			spill.setMese(viewInsert.getChckbxMarzo().getText());
		if (viewInsert.getChckbxAprile().isSelected())
			spill.setMese(viewInsert.getChckbxAprile().getText());
		if (viewInsert.getChckbxMaggio().isSelected())
			spill.setMese(viewInsert.getChckbxMaggio().getText());
		if (viewInsert.getChckbxGiugno().isSelected())
			spill.setMese(viewInsert.getChckbxGiugno().getText());
		if (viewInsert.getChckbxLuglio().isSelected())
			spill.setMese(viewInsert.getChckbxLuglio().getText());
		if (viewInsert.getChckbxAgosto().isSelected())
			spill.setMese(viewInsert.getChckbxAgosto().getText());
		if (viewInsert.getChckbxSettembre().isSelected())
			spill.setMese(viewInsert.getChckbxSettembre().getText());
		if (viewInsert.getChckbxOttobre().isSelected())
			spill.setMese(viewInsert.getChckbxOttobre().getText());
		if (viewInsert.getChckbxNovembre().isSelected())
			spill.setMese(viewInsert.getChckbxNovembre().getText());
		if (viewInsert.getChckbxDicembre().isSelected())
			spill.setMese(viewInsert.getChckbxDicembre().getText());
		return spill;
	}

	private Versamento insertMesiCheckedManagement(Versamento spill) {
		spill.azzeraMesi();
		if (viewManagement.getChckbxGennaio().isSelected())
			spill.setMese(viewManagement.getChckbxGennaio().getText());
		if (viewManagement.getChckbxFebbraio().isSelected())
			spill.setMese(viewManagement.getChckbxFebbraio().getText());
		if (viewManagement.getChckbxMarzo().isSelected())
			spill.setMese(viewManagement.getChckbxMarzo().getText());
		if (viewManagement.getChckbxAprile().isSelected())
			spill.setMese(viewManagement.getChckbxAprile().getText());
		if (viewManagement.getChckbxMaggio().isSelected())
			spill.setMese(viewManagement.getChckbxMaggio().getText());
		if (viewManagement.getChckbxGiugno().isSelected())
			spill.setMese(viewManagement.getChckbxGiugno().getText());
		if (viewManagement.getChckbxLuglio().isSelected())
			spill.setMese(viewManagement.getChckbxLuglio().getText());
		if (viewManagement.getChckbxAgosto().isSelected())
			spill.setMese(viewManagement.getChckbxAgosto().getText());
		if (viewManagement.getChckbxSettembre().isSelected())
			spill.setMese(viewManagement.getChckbxSettembre().getText());
		if (viewManagement.getChckbxOttobre().isSelected())
			spill.setMese(viewManagement.getChckbxOttobre().getText());
		if (viewManagement.getChckbxNovembre().isSelected())
			spill.setMese(viewManagement.getChckbxNovembre().getText());
		if (viewManagement.getChckbxDicembre().isSelected())
			spill.setMese(viewManagement.getChckbxDicembre().getText());
		return spill;
	}

	private void fillChckbxMesi() {
		for (int i = 0; i < spills.get(viewManagement.getTable().getSelectedRow()).getMesiLeng(); i++) {
			if (spills.get(viewManagement.getTable().getSelectedRow()).getMese(i).equals("Gennaio"))
				viewManagement.getChckbxGennaio().setSelected(true);
			if (spills.get(viewManagement.getTable().getSelectedRow()).getMese(i).equals("Febbraio"))
				viewManagement.getChckbxFebbraio().setSelected(true);
			if (spills.get(viewManagement.getTable().getSelectedRow()).getMese(i).equals("Marzo"))
				viewManagement.getChckbxMarzo().setSelected(true);
			if (spills.get(viewManagement.getTable().getSelectedRow()).getMese(i).equals("Aprile"))
				viewManagement.getChckbxAprile().setSelected(true);
			if (spills.get(viewManagement.getTable().getSelectedRow()).getMese(i).equals("Maggio"))
				viewManagement.getChckbxMaggio().setSelected(true);
			if (spills.get(viewManagement.getTable().getSelectedRow()).getMese(i).equals("Giugno"))
				viewManagement.getChckbxGiugno().setSelected(true);
			if (spills.get(viewManagement.getTable().getSelectedRow()).getMese(i).equals("Luglio"))
				viewManagement.getChckbxLuglio().setSelected(true);
			if (spills.get(viewManagement.getTable().getSelectedRow()).getMese(i).equals("Agosto"))
				viewManagement.getChckbxAgosto().setSelected(true);
			if (spills.get(viewManagement.getTable().getSelectedRow()).getMese(i).equals("Settembre"))
				viewManagement.getChckbxSettembre().setSelected(true);
			if (spills.get(viewManagement.getTable().getSelectedRow()).getMese(i).equals("Ottobre"))
				viewManagement.getChckbxOttobre().setSelected(true);
			if (spills.get(viewManagement.getTable().getSelectedRow()).getMese(i).equals("Novembre"))
				viewManagement.getChckbxNovembre().setSelected(true);
			if (spills.get(viewManagement.getTable().getSelectedRow()).getMese(i).equals("Dicembre"))
				viewManagement.getChckbxDicembre().setSelected(true);
		}
	}

	private void fillCmbbxSoci() {
		SocioModel modelSocio = new SocioModel();
		soci = new ArrayList<Socio>(modelSocio.elencoSoci());
		for (int i = 0; i < soci.size(); i++)
			viewInsert.getCmbbxSocio()
					.addItem(soci.get(i).getNome() + " " + soci.get(i).getCognome() + " - " + soci.get(i).getCf());
		viewInsert.getCmbbxSocio().setSelectedIndex(-1);
	}

	private void fillTableSpill() {
		String[] nameColumns = { "Id", "Data", "Importo", "Socio", "Descrizione" };
		spills = new ArrayList<Versamento>(model.getVersamenti());

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
		for (int j = 0; j < spills.size(); j++) {
			dati.addRow(new Vector<>());
			dati.setValueAt(spills.get(j).getId(), j, 0);
			dati.setValueAt(spills.get(j).getData(), j, 1);
			dati.setValueAt(spills.get(j).getImporto(), j, 2);
			dati.setValueAt(spills.get(j).getSocio(), j, 3);
			dati.setValueAt(spills.get(j).getDescrizione(), j, 4);
		}
		viewManagement.getTable().setModel(dati);
	}

	private boolean validatorInsertForm() {
		boolean validazione = true;
		if (!Validator.ValidaData(viewInsert.getTxtFieldData().getText())) {
			viewInsert.getTxtFieldData().setBackground(Color.red);
			validazione = false;
		} else {
			if (viewInsert.getTxtFieldData().getBackground() == Color.red)
				viewInsert.getTxtFieldData().setBackground(Color.white);
		}
		if (!Validator.ValidaImporto(viewInsert.getTxtFieldImporto().getText())) {
			viewInsert.getTxtFieldImporto().setBackground(Color.red);
			validazione = false;
		} else {
			if (viewInsert.getTxtFieldImporto().getBackground() == Color.red)
				viewInsert.getTxtFieldImporto().setBackground(Color.white);
		}
		if (!Validator.ValidaMesi(viewInsert.getNumberChckbxChecked(),
				viewInsert.getTxtFieldMetPagamento().getText())) {
			viewInsert.getTxtFieldMetPagamento().setBackground(Color.red);
			validazione = false;
		} else {
			if (viewInsert.getTxtFieldMetPagamento().getBackground() == Color.red)
				viewInsert.getTxtFieldMetPagamento().setBackground(null);
		}
		return validazione;
	}

	private boolean validatorManagementForm() {
		boolean validazione = true;
		if (!Validator.ValidaData(viewManagement.getTxtFieldData().getText())) {
			viewManagement.getTxtFieldData().setBackground(Color.red);
			validazione = false;
		} else {
			if (viewManagement.getTxtFieldData().getBackground() == Color.red)
				viewManagement.getTxtFieldData().setBackground(Color.white);
		}
		if (!Validator.ValidaImporto(viewManagement.getTxtFieldImporto().getText())) {
			viewManagement.getTxtFieldImporto().setBackground(Color.red);
			validazione = false;
		} else {
			if (viewManagement.getTxtFieldImporto().getBackground() == Color.red)
				viewManagement.getTxtFieldImporto().setBackground(Color.white);
		}
		return validazione;
	}
}
