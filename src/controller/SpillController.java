package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.Color;
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.lang.Float;
import java.util.ArrayList;
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
	private QuotaModel modelVersamento;
	private ArrayList<Socio> soci;
	private ArrayList<Versamento> spills;

	public SpillController() {
		modelVersamento = new QuotaModel();
	}

	public void MostraGestioneVers() {
		viewManagement = new SpillManagementView(fillTableSpill());
		viewManagement.getFrameGestVersamento().setVisible(true);
	}

	public void MostraInserimentoVers() {
		viewInsert = new InsertSpillView();
		viewInsert.getFrameInsVersamento().setVisible(true);
		fillCmbbxSoci();
		controlEventInsert();
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
					insertMesiChecked(spill);
					boolean esito = modelVersamento.insertVersamento(spill);
					if (esito) {
						JOptionPane.showMessageDialog(viewInsert.getFrameInsVersamento().getContentPane(),
								"Versamento inserito");
						azzeraForm();
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
				azzeraForm();
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

	private void azzeraForm() {
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

	private Versamento insertMesiChecked(Versamento spill) {
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

	private void fillCmbbxSoci() {
		SocioModel modelSocio = new SocioModel();
		soci = new ArrayList<Socio>(modelSocio.ElencoSoci());
		for (int i = 0; i < soci.size(); i++)
			viewInsert.getCmbbxSocio()
					.addItem(soci.get(i).getNome() + " " + soci.get(i).getCognome() + " - " + soci.get(i).getCf());
		viewInsert.getCmbbxSocio().setSelectedIndex(-1);
	}

	private DefaultTableModel fillTableSpill() {
		String[] ciaone = { "Id", "Data", "Socio", "Importo", "Descrizione" };
		spills = new ArrayList<Versamento>(modelVersamento.getVersamenti());
		DefaultTableModel dati = new DefaultTableModel(ciaone, 0);
		for (int j = 0; j < spills.size(); j++) {
			dati.addRow(new Vector<>());
			dati.setValueAt(spills.get(j).getId(), j, 0);
			dati.setValueAt(spills.get(j).getData(), j, 1);
			dati.setValueAt(spills.get(j).getImporto(), j, 2);
			dati.setValueAt(spills.get(j).getSocio(), j, 3);
			dati.setValueAt(spills.get(j).getDescrizione(), j, 4);
		}
		return dati;
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
}
