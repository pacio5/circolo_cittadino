package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;
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
				viewInsert.getTxtFieldData().setText("");
				viewInsert.getTxtFieldImporto().setText("0.0");
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
		viewInsert.getChckbxGennaio().addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
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

		viewInsert.getChckbxFebbraio().addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
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

		viewInsert.getChckbxMarzo().addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
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

		viewInsert.getChckbxAprile().addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
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

		viewInsert.getChckbxMaggio().addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
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

		viewInsert.getChckbxGiugno().addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
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

		viewInsert.getChckbxLuglio().addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
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

		viewInsert.getChckbxAgosto().addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
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

		viewInsert.getChckbxSettembre().addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
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

		viewInsert.getChckbxOttobre().addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
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

		viewInsert.getChckbxNovembre().addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
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

		viewInsert.getChckbxDicembre().addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
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
		viewInsert.getTxtFieldImporto().setText("0.0");
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
				viewInsert.getTxtFieldModPagamento().getText())) {
			viewInsert.getTxtFieldModPagamento().setBackground(Color.red);
			validazione = false;
		} else {
			if (viewInsert.getTxtFieldModPagamento().getBackground() == Color.red)
				viewInsert.getTxtFieldModPagamento().setBackground(null);
		}
		if (viewInsert.getCmbbxSocio().getSelectedIndex() != -1){
			ArrayList<String> mesipagati = model.getMesiPagati(soci.get(viewInsert.getCmbbxSocio().getSelectedIndex()).getCf());
			if (!Validator.ValidaMesiPagati("Gennaio", mesipagati) && viewInsert.getChckbxGennaio().isSelected()){
				viewInsert.getChckbxGennaio().setBackground(Color.red);
				validazione = false;
			} else {
				if (viewInsert.getChckbxGennaio().getBackground() == Color.red)
					viewInsert.getChckbxGennaio().setBackground(null);
			}
			if (!Validator.ValidaMesiPagati("Febbraio", mesipagati) && viewInsert.getChckbxFebbraio().isSelected()){
				viewInsert.getChckbxFebbraio().setBackground(Color.red);
				validazione = false;
			} else {
				if (viewInsert.getChckbxFebbraio().getBackground() == Color.red)
					viewInsert.getChckbxFebbraio().setBackground(null);
			}
			if (!Validator.ValidaMesiPagati("Marzo", mesipagati) && viewInsert.getChckbxMarzo().isSelected()){
				viewInsert.getChckbxMarzo().setBackground(Color.red);
				validazione = false;
			} else {
				if (viewInsert.getChckbxMarzo().getBackground() == Color.red)
					viewInsert.getChckbxMarzo().setBackground(null);
			}
			if (!Validator.ValidaMesiPagati("Aprile", mesipagati) && viewInsert.getChckbxAprile().isSelected()){
				viewInsert.getChckbxAprile().setBackground(Color.red);
				validazione = false;
			} else {
				if (viewInsert.getChckbxAprile().getBackground() == Color.red)
					viewInsert.getChckbxAprile().setBackground(null);
			}
			if (!Validator.ValidaMesiPagati("Maggio", mesipagati) && viewInsert.getChckbxMaggio().isSelected()){
				viewInsert.getChckbxMaggio().setBackground(Color.red);
				validazione = false;
			} else {
				if (viewInsert.getChckbxMaggio().getBackground() == Color.red)
					viewInsert.getChckbxMaggio().setBackground(null);
			}
			if (!Validator.ValidaMesiPagati("Giugno", mesipagati) && viewInsert.getChckbxGiugno().isSelected()){
				viewInsert.getChckbxGiugno().setBackground(Color.red);
				validazione = false;
			} else {
				if (viewInsert.getChckbxGiugno().getBackground() == Color.red)
					viewInsert.getChckbxGiugno().setBackground(null);
			}
			if (!Validator.ValidaMesiPagati("Luglio", mesipagati) && viewInsert.getChckbxLuglio().isSelected()){
				viewInsert.getChckbxLuglio().setBackground(Color.red);
				validazione = false;
			} else {
				if (viewInsert.getChckbxLuglio().getBackground() == Color.red)
					viewInsert.getChckbxLuglio().setBackground(null);
			}
			if (!Validator.ValidaMesiPagati("Agosto", mesipagati) && viewInsert.getChckbxAgosto().isSelected()){
				viewInsert.getChckbxAgosto().setBackground(Color.red);
				validazione = false;
			} else {
				if (viewInsert.getChckbxAgosto().getBackground() == Color.red)
					viewInsert.getChckbxAgosto().setBackground(null);
			}
			if (!Validator.ValidaMesiPagati("Settembre", mesipagati) && viewInsert.getChckbxSettembre().isSelected()){
				viewInsert.getChckbxSettembre().setBackground(Color.red);
				validazione = false;
			} else {
				if (viewInsert.getChckbxSettembre().getBackground() == Color.red)
					viewInsert.getChckbxSettembre().setBackground(null);
			}
			if (!Validator.ValidaMesiPagati("Ottobre", mesipagati) && viewInsert.getChckbxOttobre().isSelected()){
				viewInsert.getChckbxOttobre().setBackground(Color.red);
				validazione = false;
			} else {
				if (viewInsert.getChckbxOttobre().getBackground() == Color.red)
					viewInsert.getChckbxOttobre().setBackground(null);
			}
			if (!Validator.ValidaMesiPagati("Novembre", mesipagati) && viewInsert.getChckbxNovembre().isSelected()){
				viewInsert.getChckbxNovembre().setBackground(Color.red);
				validazione = false;
			} else {
				if (viewInsert.getChckbxNovembre().getBackground() == Color.red)
					viewInsert.getChckbxNovembre().setBackground(null);
			}
			if (!Validator.ValidaMesiPagati("Dicembre", mesipagati) && viewInsert.getChckbxDicembre().isSelected()){
				viewInsert.getChckbxDicembre().setBackground(Color.red);
				validazione = false;
			} else {
				if (viewInsert.getChckbxDicembre().getBackground() == Color.red)
					viewInsert.getChckbxDicembre().setBackground(null);
			}
		} else
			validazione = false;			
		return validazione;
	}
}
