/**
 * 
 */
package view;

import entita.Socio;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextPane;

/**
 * @author simoneonori
 * @author eliapacioni
 * @author riccardosmerilli
 * @author francescotalento
 * @version 1.0 Marzo 2017 
 *
 * Classe PassaggioCategoriaView, si occupa di visualizzare la finestra per gestire i passaggi di categoria dei soci
 */
public class PassaggioCategoriaView {
	
	private JFrame frame;
	private JList<Socio> list;
	private DefaultListModel<Socio> dlm;
	private ScrollPane scrollPane;
	private JButton btnEffettua;
	private JButton btnDashboard;
	private JLabel lblCategoriaAttuale;
	
	/**
	 * Costruttore PassaggioCategoriaView, si occupa di visualizzare la finestra per il passaggio di categoria
	 * e di inizializzare tutti i componenti
	 */
	public PassaggioCategoriaView(ArrayList<Socio> soci){
		frame = new JFrame("Circolo Cittadino Ascoli Piceno");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 800, 600);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblElencoSoci = new JLabel("Gestione Passaggi Categoria ");
		lblElencoSoci.setBounds(341, 20, 213, 16);
		frame.getContentPane().add(lblElencoSoci);
		
		list = new JList<Socio>();
		dlm = new DefaultListModel<Socio>();
		soci.stream().forEach((s)->{
			dlm.addElement(s);
		});
		list.setModel(dlm);
		
		scrollPane = new ScrollPane();
		scrollPane.setBounds(6, 54, 428, 518);
		frame.getContentPane().add(scrollPane);
		scrollPane.add(list);
		
		btnEffettua = new JButton("Effettua");
		btnEffettua.setBounds(525, 394, 117, 29);
		frame.getContentPane().add(btnEffettua);
		
		btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(697, 9, 97, 41);
		frame.getContentPane().add(btnDashboard);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(null);
		textPane.setText("Categoria Attuale -> Categoria Futura\n\nPIU GIOVANE -> GIOVANE \nGIOVANE -> ORDINARIO \nORDINARIO -> BENEMERITO");
		textPane.setBounds(468, 54, 251, 85);
		frame.getContentPane().add(textPane);
		
		lblCategoriaAttuale = new JLabel("Categoria Attuale:");
		lblCategoriaAttuale.setBounds(466, 151, 241, 16);
		frame.getContentPane().add(lblCategoriaAttuale);
	}

	/**
	 * @return frame (JFrame)
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * 
	 * @return list, contiene tutti i socio (JList)
	 */
	public JList<Socio> getList() {
		return list;
	}

	/**
	 * 
	 * @return dlm, model per riempire la lista
	 */
	public DefaultListModel<Socio> getDlm() {
		return dlm;
	}

	/**
	 * 
	 * @return scrollPane, pannello per visualizzare la lista
	 */
	public ScrollPane getScrollPane() {
		return scrollPane;
	}
	
	/**
	 * 
	 * @return btnEffattua, bottone per effettuare il passaggio di categoria
	 */
	public JButton getBtnEffettua() {
		return btnEffettua;
	}

	/**
	 * 
	 * @return bottone per tornare alla dashboard (JButton)
	 */
	public JButton getBtnDashboard() {
		return btnDashboard;
	}
	
	/**
	 * 
	 * @return lblCategoriaAttuale, label contenente la categoria attuale del socio (JLabel)
	 */
	public JLabel getLblCategoriaAttuale(){
		return lblCategoriaAttuale;
	}
}
