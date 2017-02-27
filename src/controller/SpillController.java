package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;

import java.lang.Float;
import java.util.ArrayList;

import java.sql.Date;

import entita.Versamento;
import entita.Socio;
import view.InsertSpillView;
import model.QuotaModel;
import model.SocioModel;

public class SpillController {
	private InsertSpillView view;
	private QuotaModel model;
	private ArrayList<Socio> soci;

	public SpillController() {
		model = new QuotaModel();
	}
	
	public void MostraInserimentoVers (){
		view = new InsertSpillView();
		view.getFrameInsVersamento().setVisible(true);
		fillCmbbxSoci();
		controlloEventi();
	}

	private void controlloEventi() {
		// Evento inserimento
		view.getBtnInserisci().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Versamento spill = new Versamento(
						Float.valueOf(view.getTxtFieldImporto().getText()).floatValue(),
						view.getTxtFieldCodFisc().getText(),
						Date.valueOf(view.getTxtFieldData().getText()),
						view.getTxtFieldDescrizione().getText());
				insertMesiChecked(spill);
				boolean esito = model.insertVersamento(spill);
				if (esito) {
					JOptionPane.showMessageDialog(view.getFrameInsVersamento().getContentPane(),
							"Versamento inserito");
					azzeraForm();
				}
			}
		});

		// Evento azzeramento form
		view.getBtnAzzera().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				azzeraForm();
			}
		});

		// Evento riempimento informazioni Socio
		view.getCmbbxSocio().addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (view.getCmbbxSocio().getSelectedIndex() != -1) {
					view.getTxtFieldCodFisc()
							.setText(soci.get(view.getCmbbxSocio().getSelectedIndex()).getCf());
					view.getTxtFieldModPagamento()
							.setText(soci.get(view.getCmbbxSocio().getSelectedIndex()).getModPagamento());
					view.getTxtFieldMetPagamento()
							.setText(soci.get(view.getCmbbxSocio().getSelectedIndex()).getMetPagamento());
					view.getTxtFieldTipologia()
							.setText(soci.get(view.getCmbbxSocio().getSelectedIndex()).getTipologia());
					view.getTxtFieldTelefono()
							.setText(soci.get(view.getCmbbxSocio().getSelectedIndex()).getTelefono());
					view.getTxtFieldEmail()
							.setText(soci.get(view.getCmbbxSocio().getSelectedIndex()).getEmail());
				} else {
					view.getTxtFieldCodFisc().setText("");
					view.getTxtFieldModPagamento().setText("");
					view.getTxtFieldMetPagamento().setText("");
					view.getTxtFieldTipologia().setText("");
					view.getTxtFieldTelefono().setText("");
					view.getTxtFieldEmail().setText("");
				}
			}
		});
		
		//Evento ritorno all'AdminView
		view.getBtnDashboard().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				AdminController adminController = new AdminController();
				adminController.controlloEvento();
				view.getFrameInsVersamento().dispose();
			}
		});
	}

	private void azzeraForm() {
		view.getCmbbxSocio().setSelectedIndex(-1);
		view.getTxtFieldData().setText("");
		view.getTxtFieldImporto().setText("");
		view.getTxtFieldDescrizione().setText("");
		view.getChckbxGennaio().setSelected(false);
		view.getChckbxFebbraio().setSelected(false);
		view.getChckbxMarzo().setSelected(false);
		view.getChckbxAprile().setSelected(false);
		view.getChckbxMaggio().setSelected(false);
		view.getChckbxGiugno().setSelected(false);
		view.getChckbxLuglio().setSelected(false);
		view.getChckbxAgosto().setSelected(false);
		view.getChckbxSettembre().setSelected(false);
		view.getChckbxOttobre().setSelected(false);
		view.getChckbxNovembre().setSelected(false);
		view.getChckbxDicembre().setSelected(false);
	}

	private Versamento insertMesiChecked(Versamento spill) {
		if (view.getChckbxGennaio().isSelected())
			spill.setMese(view.getChckbxGennaio().getText());
		if (view.getChckbxFebbraio().isSelected())
			spill.setMese(view.getChckbxFebbraio().getText());
		if (view.getChckbxMarzo().isSelected())
			spill.setMese(view.getChckbxMarzo().getText());
		if (view.getChckbxAprile().isSelected())
			spill.setMese(view.getChckbxAprile().getText());
		if (view.getChckbxMaggio().isSelected())
			spill.setMese(view.getChckbxMaggio().getText());
		if (view.getChckbxGiugno().isSelected())
			spill.setMese(view.getChckbxGiugno().getText());
		if (view.getChckbxLuglio().isSelected())
			spill.setMese(view.getChckbxLuglio().getText());
		if (view.getChckbxAgosto().isSelected())
			spill.setMese(view.getChckbxAgosto().getText());
		if (view.getChckbxSettembre().isSelected())
			spill.setMese(view.getChckbxSettembre().getText());
		if (view.getChckbxOttobre().isSelected())
			spill.setMese(view.getChckbxOttobre().getText());
		if (view.getChckbxNovembre().isSelected())
			spill.setMese(view.getChckbxNovembre().getText());
		if (view.getChckbxDicembre().isSelected())
			spill.setMese(view.getChckbxDicembre().getText());
		return spill;
	}

	private void fillCmbbxSoci() {
		SocioModel model = new SocioModel();
		soci = new ArrayList<Socio>(model.ElencoSoci());
		for (int i = 0; i < soci.size(); i++)
			view.getCmbbxSocio().addItem(soci.get(i).getNome() + " " + soci.get(i).getCognome() + " - " + soci.get(i).getCf());
		view.getCmbbxSocio().setSelectedIndex(-1);
	}
}
