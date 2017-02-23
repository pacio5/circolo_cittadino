/**
 * 
 */
package controller;

import model.SocioModel;
import view.AdminView;
import view.InserisciSocioView;
import java.sql.Date;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import entita.Socio;

/**
 * @author eliapacioni
 *
 */
public class SocioController {

	private SocioModel model;
	private InserisciSocioView view;

	public SocioController() {
		model = new SocioModel();
		view = new InserisciSocioView();
		view.getFrame().setVisible(true);
	}
	
	
	public void ControllaInserimento() {
		view.getBtnInserisci().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				char sex;
				if(view.getRdbtnUomo().isSelected())
					sex = 'M';
				else 
					sex = 'F';
				boolean esito = model.InserisciSocio(new Socio(
						view.getCf().getText(),
						view.getNome().getText(),
						view.getCognome().getText(),
						sex,
						Date.valueOf(view.getDataNascita().getText()),
						view.getLuogoNascita().getText(),
						view.getIndirizzo().getText(),
						view.getCitta().getText(),
						view.getCap().getText(),
						view.getEmail().getText(),
						view.getTelefono().getText(),
						view.getProfessione().getText(),
						view.getStatoSociale().getText(),
						view.getConiuge().getText(),
						Date.valueOf(view.getDataAmmissione().getText()),
						Float.valueOf(view.getTassaAmmissione().getText()),
						view.getModPagamento().getSelectedItem().toString(),
						view.getMetPagamento().getSelectedItem().toString(),
						view.getTipologia().getSelectedItem().toString()
						));
				JOptionPane.showMessageDialog(view.getFrame().getContentPane(), esito);
			}
		});

	}
	
	public void TornaAllaDashboard(){
		view.getBtnDashboard().addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				AdminView adminView = new AdminView();
				adminView.getFrame().setVisible(true);
				view.getFrame().dispose();
			}
		});
	}
}
