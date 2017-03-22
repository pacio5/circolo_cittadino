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

/**
 * @author eliapacioni
 *
 */
public class PassaggioCategoriaView {
	
	private JFrame frame;
	private JList<Socio> list;
	private JButton btnEffettua;
	private DefaultListModel<Socio> dlm;
	private ScrollPane scrollPane;
	
	/**
	 * Create the frame
	 */
	public PassaggioCategoriaView(ArrayList<Socio> soci){
		frame = new JFrame("Circolo Cittadino Ascoli Piceno");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 800, 600);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblElencoSoci = new JLabel("Gestione Passaggi Categoria ");
		lblElencoSoci.setBounds(341, 20, 105, 16);
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
		btnEffettua.setBounds(523, 295, 117, 29);
		frame.getContentPane().add(btnEffettua);
		btnEffettua.setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}

	public JList<Socio> getList() {
		return list;
	}

	public JButton getBtnEffettua() {
		return btnEffettua;
	}

	public DefaultListModel<Socio> getDlm() {
		return dlm;
	}

	public ScrollPane getScrollPane() {
		return scrollPane;
	}
	
	
	
}
