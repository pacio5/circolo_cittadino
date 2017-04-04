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
import java.time.LocalDate;

import entita.Versamento;
import entita.Socio;
import view.InserimentoVersamentoView;
import view.ChiusuraAnnualeView;
import view.GestioneVersamentiView;
import model.QuotaModel;
import model.SocioModel;

import utility.Validator;

/**
 * @author simoneonori
 * @author eliapacioni
 * @author riccardosmerilli
 * @author francescotalento
 * 
 * @version 1.0 Marzo 2017
 * 
 * 
 * Classe che si occupa della gestione degli eventi azionati dall'utente
 * interagendo con la view dei versamenti e della gestione delle interazioni tra le view
 * e il model
 */
public class VersamentoController {
	private InserimentoVersamentoView viewInserimento;
	private GestioneVersamentiView viewGestione;
	private ChiusuraAnnualeView viewChiusura;
	private QuotaModel model;
	private ArrayList<Socio> soci;
	private ArrayList<Versamento> versamenti;
	private float importo;

	/**
	 * Costruttore, il controller � costruito
	 * mediante il QuotaModel, la GestioneVersamentiView,
	 * l'InserimentoVersamentoView, un ArrayList soci contenente
	 * tutte i soci esistenti, un ArrayList versamenti contenente tutti
	 * i versamenti esistenti e una variabile importo come appoggio per
	 * sommare tutti gli importi delle quote dei mesi selezionati.
	 */
	public VersamentoController() {
		model = new QuotaModel();
		viewGestione = new GestioneVersamentiView();
		viewInserimento = new InserimentoVersamentoView();
		viewChiusura = new ChiusuraAnnualeView();
		soci = null;
		versamenti = null;
		importo = (float)0.0;
	}

	public void mostraGestioneVers() {
		riempimentoTableVersamento();
		viewGestione.getFrameGestVersamento().setVisible(true);
		controlloEventiGestione();
	}

	public void mostraInserimentoVers() {
		viewInserimento.getFrameInsVersamento().setVisible(true);
		riempimentoCmbbxSoci();
		controlloEventiInserimento();
	}
	
	public void mostraChiusuraAnnuale() {
		viewChiusura.getFrame().setVisible(true);
		riempimentoTableChiusura();
		controlloEventiChiusura();
	}

	/**
	 * Metodo per la gestione degli eventi
	 * nel form della gestione dei versamenti
	 */ 
	private void controlloEventiGestione() {
		/**
		 * Evento eliminazione Versamento 
		 */
		viewGestione.getBtnElimina().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Eliminare il versamento?") == 0
						&& viewGestione.getTable().getSelectedRow() != -1) {
					boolean esito = model
							.deleteVersamento(versamenti.get(viewGestione.getTable().getSelectedRow()).getId());
					versamenti.remove(viewGestione.getTable().getSelectedRow());
					if (esito) {
						JOptionPane.showMessageDialog(viewGestione.getFrameGestVersamento().getContentPane(),
								"Versamento eliminato");
						viewGestione.getFrameGestVersamento().dispose();
						mostraGestioneVers();
					} else {
						JOptionPane.showMessageDialog(viewGestione.getFrameGestVersamento().getContentPane(),
								"Versamento non eliminato");
					}
				}
			}
		});

		/**
		 * Evento ritorno all'AdminView 
		 */
		viewGestione.getBtnDashboard().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminController adminController = new AdminController();
				adminController.controlloEvento();
				viewGestione.getFrameGestVersamento().dispose();
			}
		});
	}

	/**
	 * Metodo per la gestione degli eventi
	 * nel form dell'inserimento dei versamenti
	 */ 
	private void controlloEventiInserimento() {
		/**
		 * Evento inserimento 
		 */
		viewInserimento.getBtnInserisci().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (validatorForm()) {
					Versamento spill = new Versamento(
							Float.valueOf(viewInserimento.getTxtFieldImporto().getText()).floatValue(),
							viewInserimento.getTxtFieldCodFisc().getText(),
							Date.valueOf(viewInserimento.getTxtFieldData().getText()),
							viewInserimento.getTxtFieldDescrizione().getText().toUpperCase());
					inserisciMesiChecked(spill);
					boolean esito = model.insertVersamento(spill);
					if (esito) {
						JOptionPane.showMessageDialog(viewInserimento.getFrameInsVersamento().getContentPane(),
								"Versamento inserito");
						azzeraFormInsert();
					} else {
						JOptionPane.showMessageDialog(viewInserimento.getFrameInsVersamento().getContentPane(),
								"Inserimento non effettuato");
					}
				} else {
					JOptionPane.showMessageDialog(viewInserimento.getFrameInsVersamento().getContentPane(),
							"Campi non validi, modificare i campi contrassegnati in rosso");
				}
			}
		});

		/**
		 *  Evento azzeramento form 
		 */
		viewInserimento.getBtnAzzera().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				azzeraFormInsert();
			}
		});

		/* *
		 * Riempimento informazioni Socio 
		 */
		viewInserimento.getCmbbxSocio().addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				viewInserimento.getTxtFieldData().setText("");
				viewInserimento.getTxtFieldImporto().setText("0.0");
				viewInserimento.getTxtFieldDescrizione().setText("");
				viewInserimento.getChckbxGennaio().setSelected(false);
				viewInserimento.getChckbxFebbraio().setSelected(false);
				viewInserimento.getChckbxMarzo().setSelected(false);
				viewInserimento.getChckbxAprile().setSelected(false);
				viewInserimento.getChckbxMaggio().setSelected(false);
				viewInserimento.getChckbxGiugno().setSelected(false);
				viewInserimento.getChckbxLuglio().setSelected(false);
				viewInserimento.getChckbxAgosto().setSelected(false);
				viewInserimento.getChckbxSettembre().setSelected(false);
				viewInserimento.getChckbxOttobre().setSelected(false);
				viewInserimento.getChckbxNovembre().setSelected(false);
				viewInserimento.getChckbxDicembre().setSelected(false);
				if (viewInserimento.getCmbbxSocio().getSelectedIndex() != -1) {
					viewInserimento.getTxtFieldCodFisc()
							.setText(soci.get(viewInserimento.getCmbbxSocio().getSelectedIndex()).getCf());
					viewInserimento.getTxtFieldModPagamento()
							.setText(soci.get(viewInserimento.getCmbbxSocio().getSelectedIndex()).getModPagamento());
					viewInserimento.getTxtFieldMetPagamento()
							.setText(soci.get(viewInserimento.getCmbbxSocio().getSelectedIndex()).getMetPagamento());
					viewInserimento.getTxtFieldTipologia()
							.setText(soci.get(viewInserimento.getCmbbxSocio().getSelectedIndex()).getTipologia());
					viewInserimento.getTxtFieldTelefono()
							.setText(soci.get(viewInserimento.getCmbbxSocio().getSelectedIndex()).getTelefono());
					viewInserimento.getTxtFieldEmail()
							.setText(soci.get(viewInserimento.getCmbbxSocio().getSelectedIndex()).getEmail());
				} else {
					viewInserimento.getTxtFieldCodFisc().setText("");
					viewInserimento.getTxtFieldModPagamento().setText("");
					viewInserimento.getTxtFieldMetPagamento().setText("");
					viewInserimento.getTxtFieldTipologia().setText("");
					viewInserimento.getTxtFieldTelefono().setText("");
					viewInserimento.getTxtFieldEmail().setText("");
				}
			}
		});

		/* 
		 * Eventi per il calcolo dell'importo totale
		 * da pagare, a seconda di quale mese viene selezionato
		*/
		viewInserimento.getChckbxGennaio().addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
				Date mensilita = Date.valueOf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-01-01");
				importo = model.getImportoMese(viewInserimento.getTxtFieldTipologia().getText(), mensilita);
				if (viewInserimento.getChckbxGennaio().isSelected())
					viewInserimento.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInserimento.getTxtFieldImporto().getText()).floatValue() + importo));
				else
					viewInserimento.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInserimento.getTxtFieldImporto().getText()).floatValue() - importo));
			}
		});

		viewInserimento.getChckbxFebbraio().addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
				Date mensilita = Date.valueOf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-02-01");
				importo = model.getImportoMese(viewInserimento.getTxtFieldTipologia().getText(), mensilita);
				if (viewInserimento.getChckbxFebbraio().isSelected())
					viewInserimento.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInserimento.getTxtFieldImporto().getText()).floatValue() + importo));
				else
					viewInserimento.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInserimento.getTxtFieldImporto().getText()).floatValue() - importo));
			}
		});

		viewInserimento.getChckbxMarzo().addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
				Date mensilita = Date.valueOf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-03-01");
				importo = model.getImportoMese(viewInserimento.getTxtFieldTipologia().getText(), mensilita);
				if (viewInserimento.getChckbxMarzo().isSelected())
					viewInserimento.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInserimento.getTxtFieldImporto().getText()).floatValue() + importo));
				else
					viewInserimento.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInserimento.getTxtFieldImporto().getText()).floatValue() - importo));
			}
		});

		viewInserimento.getChckbxAprile().addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
				Date mensilita = Date.valueOf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-04-01");
				importo = model.getImportoMese(viewInserimento.getTxtFieldTipologia().getText(), mensilita);
				if (viewInserimento.getChckbxAprile().isSelected())
					viewInserimento.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInserimento.getTxtFieldImporto().getText()).floatValue() + importo));
				else
					viewInserimento.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInserimento.getTxtFieldImporto().getText()).floatValue() - importo));
			}
		});

		viewInserimento.getChckbxMaggio().addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
				Date mensilita = Date.valueOf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-05-01");
				importo = model.getImportoMese(viewInserimento.getTxtFieldTipologia().getText(), mensilita);
				if (viewInserimento.getChckbxMaggio().isSelected())
					viewInserimento.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInserimento.getTxtFieldImporto().getText()).floatValue() + importo));
				else
					viewInserimento.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInserimento.getTxtFieldImporto().getText()).floatValue() - importo));
			}
		});

		viewInserimento.getChckbxGiugno().addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
				Date mensilita = Date.valueOf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-06-01");
				importo = model.getImportoMese(viewInserimento.getTxtFieldTipologia().getText(), mensilita);
				if (viewInserimento.getChckbxGiugno().isSelected())
					viewInserimento.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInserimento.getTxtFieldImporto().getText()).floatValue() + importo));
				else
					viewInserimento.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInserimento.getTxtFieldImporto().getText()).floatValue() - importo));
			}
		});

		viewInserimento.getChckbxLuglio().addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
				Date mensilita = Date.valueOf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-07-01");
				importo = model.getImportoMese(viewInserimento.getTxtFieldTipologia().getText(), mensilita);
				if (viewInserimento.getChckbxLuglio().isSelected())
					viewInserimento.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInserimento.getTxtFieldImporto().getText()).floatValue() + importo));
				else
					viewInserimento.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInserimento.getTxtFieldImporto().getText()).floatValue() - importo));
			}
		});

		viewInserimento.getChckbxAgosto().addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
				Date mensilita = Date.valueOf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-08-01");
				importo = model.getImportoMese(viewInserimento.getTxtFieldTipologia().getText(), mensilita);
				if (viewInserimento.getChckbxAgosto().isSelected())
					viewInserimento.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInserimento.getTxtFieldImporto().getText()).floatValue() + importo));
				else
					viewInserimento.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInserimento.getTxtFieldImporto().getText()).floatValue() - importo));
			}
		});

		viewInserimento.getChckbxSettembre().addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
				Date mensilita = Date.valueOf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-09-01");
				importo = model.getImportoMese(viewInserimento.getTxtFieldTipologia().getText(), mensilita);
				if (viewInserimento.getChckbxSettembre().isSelected())
					viewInserimento.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInserimento.getTxtFieldImporto().getText()).floatValue() + importo));
				else
					viewInserimento.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInserimento.getTxtFieldImporto().getText()).floatValue() - importo));
			}
		});

		viewInserimento.getChckbxOttobre().addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
				Date mensilita = Date.valueOf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-10-01");
				importo = model.getImportoMese(viewInserimento.getTxtFieldTipologia().getText(), mensilita);
				if (viewInserimento.getChckbxOttobre().isSelected())
					viewInserimento.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInserimento.getTxtFieldImporto().getText()).floatValue() + importo));
				else
					viewInserimento.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInserimento.getTxtFieldImporto().getText()).floatValue() - importo));
			}
		});

		viewInserimento.getChckbxNovembre().addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
				Date mensilita = Date.valueOf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-11-01");
				importo = model.getImportoMese(viewInserimento.getTxtFieldTipologia().getText(), mensilita);
				if (viewInserimento.getChckbxNovembre().isSelected())
					viewInserimento.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInserimento.getTxtFieldImporto().getText()).floatValue() + importo));
				else
					viewInserimento.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInserimento.getTxtFieldImporto().getText()).floatValue() - importo));
			}
		});

		viewInserimento.getChckbxDicembre().addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent actionEvent) {
				Date mensilita = Date.valueOf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-12-01");
				importo = model.getImportoMese(viewInserimento.getTxtFieldTipologia().getText(), mensilita);
				if (viewInserimento.getChckbxDicembre().isSelected())
					viewInserimento.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInserimento.getTxtFieldImporto().getText()).floatValue() + importo));
				else
					viewInserimento.getTxtFieldImporto().setText(String
							.valueOf(Float.valueOf(viewInserimento.getTxtFieldImporto().getText()).floatValue() - importo));
			}
		});

		/**
		 * Evento ritorno all'AdminView 
		 */
		viewInserimento.getBtnDashboard().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminController adminController = new AdminController();
				adminController.controlloEvento();
				viewInserimento.getFrameInsVersamento().dispose();
			}
		});
	}
	
	/**
	 * Metodo per la gestione degli eventi
	 * nel form della gestione della chiusura annuale
	 */ 
	public void controlloEventiChiusura() {
		/**
		 * Evento versamento chiusura annuale
		 */
		viewChiusura.getBtnSalda().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Calendar.getInstance();
				boolean esito = model.insertChiusuraAnnuale(new Versamento(
						-Float.valueOf(viewChiusura.getTable().getModel()
								.getValueAt(viewChiusura.getTable().getSelectedRow(), 3).toString()).floatValue(),
						(String) viewChiusura.getTable().getModel().getValueAt(viewChiusura.getTable().getSelectedRow(),
								0),
						Date.valueOf(LocalDate.now()), "ChiusuraAnnuale"
								+ String.valueOf(Integer.valueOf(Calendar.getInstance().get(Calendar.YEAR)) - 1)));
				if (esito) {
					JOptionPane.showMessageDialog(viewChiusura.getFrame().getContentPane(), "Versamento inserito");
					viewChiusura.getFrame().dispose();
					mostraChiusuraAnnuale();
				} else
					JOptionPane.showMessageDialog(viewChiusura.getFrame().getContentPane(),
							"Inserimento non effettuato");
			}
		});

		/**
		 * Evento ritorno all'AdminView 
		 */
		viewChiusura.getBtnDashboard().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminController adminController = new AdminController();
				adminController.controlloEvento();
				viewChiusura.getFrame().dispose();
			}
		});
	}

	/**
	 * Setta tutti i valori di default dei componenti 
	 * nel form dell'inserimento dei versamenti
	 */
	private void azzeraFormInsert() {
		viewInserimento.getCmbbxSocio().setSelectedIndex(-1);
		viewInserimento.getTxtFieldData().setText("");
		viewInserimento.getTxtFieldImporto().setText("0.0");
		viewInserimento.getTxtFieldDescrizione().setText("");
		viewInserimento.getChckbxGennaio().setSelected(false);
		viewInserimento.getChckbxFebbraio().setSelected(false);
		viewInserimento.getChckbxMarzo().setSelected(false);
		viewInserimento.getChckbxAprile().setSelected(false);
		viewInserimento.getChckbxMaggio().setSelected(false);
		viewInserimento.getChckbxGiugno().setSelected(false);
		viewInserimento.getChckbxLuglio().setSelected(false);
		viewInserimento.getChckbxAgosto().setSelected(false);
		viewInserimento.getChckbxSettembre().setSelected(false);
		viewInserimento.getChckbxOttobre().setSelected(false);
		viewInserimento.getChckbxNovembre().setSelected(false);
		viewInserimento.getChckbxDicembre().setSelected(false);
	}

	/**
	 *  Inserimento dei mesi all'interno 
	 *  di un oggetto Versamento 
	 */
	private Versamento inserisciMesiChecked(Versamento spill) {
		if (viewInserimento.getChckbxGennaio().isSelected())
			spill.setMese(viewInserimento.getChckbxGennaio().getText());
		if (viewInserimento.getChckbxFebbraio().isSelected())
			spill.setMese(viewInserimento.getChckbxFebbraio().getText());
		if (viewInserimento.getChckbxMarzo().isSelected())
			spill.setMese(viewInserimento.getChckbxMarzo().getText());
		if (viewInserimento.getChckbxAprile().isSelected())
			spill.setMese(viewInserimento.getChckbxAprile().getText());
		if (viewInserimento.getChckbxMaggio().isSelected())
			spill.setMese(viewInserimento.getChckbxMaggio().getText());
		if (viewInserimento.getChckbxGiugno().isSelected())
			spill.setMese(viewInserimento.getChckbxGiugno().getText());
		if (viewInserimento.getChckbxLuglio().isSelected())
			spill.setMese(viewInserimento.getChckbxLuglio().getText());
		if (viewInserimento.getChckbxAgosto().isSelected())
			spill.setMese(viewInserimento.getChckbxAgosto().getText());
		if (viewInserimento.getChckbxSettembre().isSelected())
			spill.setMese(viewInserimento.getChckbxSettembre().getText());
		if (viewInserimento.getChckbxOttobre().isSelected())
			spill.setMese(viewInserimento.getChckbxOttobre().getText());
		if (viewInserimento.getChckbxNovembre().isSelected())
			spill.setMese(viewInserimento.getChckbxNovembre().getText());
		if (viewInserimento.getChckbxDicembre().isSelected())
			spill.setMese(viewInserimento.getChckbxDicembre().getText());
		return spill;
	}

	/**
	 * Inserimento del nome, cognome e codice fiscale
	 * all'interno della comboBox nel form dell'inserimento del versamento
	 */
	private void riempimentoCmbbxSoci() {
		SocioModel modelSocio = new SocioModel();
		soci = new ArrayList<Socio>(modelSocio.elencoSoci());
		for (int i = 0; i < soci.size(); i++)
			viewInserimento.getCmbbxSocio()
					.addItem(soci.get(i).getNome() + " " + soci.get(i).getCognome() + " - " + soci.get(i).getCf());
		viewInserimento.getCmbbxSocio().setSelectedIndex(-1);
	}

	/**
	 * Definizione e riempimento della tabella
	 * nella gestione dei versamenti
	 */
	private void riempimentoTableVersamento() {
		String[] nameColumns = { "Id", "Data", "Importo", "Socio", "Descrizione" };
		versamenti = new ArrayList<Versamento>(model.getVersamenti());

		/*
		 * Istanza del TableModel con l'override di isCellEditable per rendere
		 * la tabella non modificabile
		 */
		@SuppressWarnings("serial")
		DefaultTableModel dati = new DefaultTableModel(nameColumns, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		for (int j = 0; j < versamenti.size(); j++) {
			dati.addRow(new Vector<>());
			dati.setValueAt(versamenti.get(j).getId(), j, 0);
			dati.setValueAt(versamenti.get(j).getData(), j, 1);
			dati.setValueAt(versamenti.get(j).getImporto(), j, 2);
			dati.setValueAt(versamenti.get(j).getSocio(), j, 3);
			dati.setValueAt(versamenti.get(j).getDescrizione(), j, 4);
		}
		viewGestione.getTable().setModel(dati);
	}
	
	/**
	 * Definizione e riempimento della tabella
	 * nella gestione delle chiusure annuali
	 */
	private void riempimentoTableChiusura() {
		String[] nameColumns = { "Socio", "Tipologia", "Modalita di pagamento", "Credito/Debito"};
		SocioModel modelSocio = new SocioModel();
		ArrayList<Socio> socichiusura = modelSocio.elencoSoci();

		/*
		 * Istanza del TableModel con l'override di isCellEditable per rendere
		 * la tabella non modificabile
		 */
		@SuppressWarnings("serial")
		DefaultTableModel dati = new DefaultTableModel(nameColumns, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		if(!socichiusura.isEmpty()){
			int i = 0;
			for (int j = 0; j < socichiusura.size(); j++) {
				if(model.getCreditoDebito(socichiusura.get(j)) != 0){
					dati.addRow(new Vector<>());
					dati.setValueAt(socichiusura.get(j).getCf(), i, 0);
					dati.setValueAt(socichiusura.get(j).getTipologia(), i, 1);
					dati.setValueAt(socichiusura.get(j).getModPagamento(), i, 2);
					dati.setValueAt(model.getCreditoDebito(socichiusura.get(j)), i, 3);
					i++;
				}
			}
			viewChiusura.getTable().setModel(dati);
		}
	}

	/**
	 * Controllo per i vari componenti
	 * nel form dell'inserimento dei versamenti
	 * @return true se vengono rispettati i validator, altrimenti false
	 */ 
	private boolean validatorForm() {
		boolean validazione = true;
		if (!Validator.validaData(viewInserimento.getTxtFieldData().getText())) {
			viewInserimento.getTxtFieldData().setBackground(Color.red);
			validazione = false;
		} else {
			if (viewInserimento.getTxtFieldData().getBackground() == Color.red)
				viewInserimento.getTxtFieldData().setBackground(Color.white);
		}
		if (!Validator.validaImporto(viewInserimento.getTxtFieldImporto().getText())) {
			viewInserimento.getTxtFieldImporto().setBackground(Color.red);
			validazione = false;
		} else {
			if (viewInserimento.getTxtFieldImporto().getBackground() == Color.red)
				viewInserimento.getTxtFieldImporto().setBackground(Color.white);
		}
		if (!Validator.validaMesi(viewInserimento.getNumberChckbxChecked(),
				viewInserimento.getTxtFieldMetPagamento().getText())) {
			viewInserimento.getTxtFieldMetPagamento().setBackground(Color.red);
			validazione = false;
		} else {
			if (viewInserimento.getTxtFieldMetPagamento().getBackground() == Color.red)
				viewInserimento.getTxtFieldMetPagamento().setBackground(null);
		}
		if (viewInserimento.getCmbbxSocio().getSelectedIndex() != -1){
			ArrayList<String> mesipagati = model.getMesiPagati(soci.get(viewInserimento.getCmbbxSocio().getSelectedIndex()).getCf());
			if (mesipagati.contains("Gennaio") && viewInserimento.getChckbxGennaio().isSelected()){
				viewInserimento.getChckbxGennaio().setBackground(Color.red);
				validazione = false;
			} else {
				if (viewInserimento.getChckbxGennaio().getBackground() == Color.red)
					viewInserimento.getChckbxGennaio().setBackground(null);
			}
			if (mesipagati.contains("Febbraio") && viewInserimento.getChckbxFebbraio().isSelected()){
				viewInserimento.getChckbxFebbraio().setBackground(Color.red);
				validazione = false;
			} else {
				if (viewInserimento.getChckbxFebbraio().getBackground() == Color.red)
					viewInserimento.getChckbxFebbraio().setBackground(null);
			}
			if (mesipagati.contains("Marzo") && viewInserimento.getChckbxMarzo().isSelected()){
				viewInserimento.getChckbxMarzo().setBackground(Color.red);
				validazione = false;
			} else {
				if (viewInserimento.getChckbxMarzo().getBackground() == Color.red)
					viewInserimento.getChckbxMarzo().setBackground(null);
			}
			if (mesipagati.contains("Aprile") && viewInserimento.getChckbxAprile().isSelected()){
				viewInserimento.getChckbxAprile().setBackground(Color.red);
				validazione = false;
			} else {
				if (viewInserimento.getChckbxAprile().getBackground() == Color.red)
					viewInserimento.getChckbxAprile().setBackground(null);
			}
			if (mesipagati.contains("Maggio") && viewInserimento.getChckbxMaggio().isSelected()){
				viewInserimento.getChckbxMaggio().setBackground(Color.red);
				validazione = false;
			} else {
				if (viewInserimento.getChckbxMaggio().getBackground() == Color.red)
					viewInserimento.getChckbxMaggio().setBackground(null);
			}
			if (mesipagati.contains("Giugno") && viewInserimento.getChckbxGiugno().isSelected()){
				viewInserimento.getChckbxGiugno().setBackground(Color.red);
				validazione = false;
			} else {
				if (viewInserimento.getChckbxGiugno().getBackground() == Color.red)
					viewInserimento.getChckbxGiugno().setBackground(null);
			}
			if (mesipagati.contains("Luglio") && viewInserimento.getChckbxLuglio().isSelected()){
				viewInserimento.getChckbxLuglio().setBackground(Color.red);
				validazione = false;
			} else {
				if (viewInserimento.getChckbxLuglio().getBackground() == Color.red)
					viewInserimento.getChckbxLuglio().setBackground(null);
			}
			if (mesipagati.contains("Agosto") && viewInserimento.getChckbxAgosto().isSelected()){
				viewInserimento.getChckbxAgosto().setBackground(Color.red);
				validazione = false;
			} else {
				if (viewInserimento.getChckbxAgosto().getBackground() == Color.red)
					viewInserimento.getChckbxAgosto().setBackground(null);
			}
			if (mesipagati.contains("Settembre") && viewInserimento.getChckbxSettembre().isSelected()){
				viewInserimento.getChckbxSettembre().setBackground(Color.red);
				validazione = false;
			} else {
				if (viewInserimento.getChckbxSettembre().getBackground() == Color.red)
					viewInserimento.getChckbxSettembre().setBackground(null);
			}
			if (mesipagati.contains("Ottobre") && viewInserimento.getChckbxOttobre().isSelected()){
				viewInserimento.getChckbxOttobre().setBackground(Color.red);
				validazione = false;
			} else {
				if (viewInserimento.getChckbxOttobre().getBackground() == Color.red)
					viewInserimento.getChckbxOttobre().setBackground(null);
			}
			if (mesipagati.contains("Novembre") && viewInserimento.getChckbxNovembre().isSelected()){
				viewInserimento.getChckbxNovembre().setBackground(Color.red);
				validazione = false;
			} else {
				if (viewInserimento.getChckbxNovembre().getBackground() == Color.red)
					viewInserimento.getChckbxNovembre().setBackground(null);
			}
			if (mesipagati.contains("Dicembre") && viewInserimento.getChckbxDicembre().isSelected()){
				viewInserimento.getChckbxDicembre().setBackground(Color.red);
				validazione = false;
			} else {
				if (viewInserimento.getChckbxDicembre().getBackground() == Color.red)
					viewInserimento.getChckbxDicembre().setBackground(null);
			}
		} else
			validazione = false;			
		return validazione;
	}
}
