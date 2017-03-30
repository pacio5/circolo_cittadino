package view;

import entita.Figlio;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 * @author simoneonori
 *
 */
public class BefaneView {
	
	private JFrame frmCircoloCittadinoAscoli;
	private JList<Figlio> list;
	private DefaultListModel<Figlio> dlm;
	private ScrollPane scrollPaneFigli;
	private JButton btnDashboard;
	private JTextArea textArea;
	
	/**
	 * Create the frame
	 */
	public BefaneView(ArrayList<Figlio> figli){
		frmCircoloCittadinoAscoli = new JFrame("Circolo Cittadino Ascoli Piceno");
		frmCircoloCittadinoAscoli.setTitle("Circolo Cittadino Ascoli Piceno - Le Befane");
		frmCircoloCittadinoAscoli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCircoloCittadinoAscoli.setBounds(100, 100, 800, 600);
		frmCircoloCittadinoAscoli.setResizable(false);
		frmCircoloCittadinoAscoli.getContentPane().setLayout(null);
		
		JLabel lblElencoFigli = new JLabel("Figli");
		lblElencoFigli.setBounds(156, 57, 38, 16);
		frmCircoloCittadinoAscoli.getContentPane().add(lblElencoFigli);
		
		JLabel lblElencoSoci = new JLabel("Genitore");
		lblElencoSoci.setBounds(445, 57, 89, 16);
		frmCircoloCittadinoAscoli.getContentPane().add(lblElencoSoci);
		
		list = new JList<Figlio>();
		dlm = new DefaultListModel<Figlio>();
		figli.stream().forEach((s)->{
			dlm.addElement(s);
		});
		list.setModel(dlm);
		
		scrollPaneFigli = new ScrollPane();
		scrollPaneFigli.setBounds(10, 91, 373, 469);
		frmCircoloCittadinoAscoli.getContentPane().add(scrollPaneFigli);
		scrollPaneFigli.add(list);
		
		btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(697, 9, 97, 41);
		frmCircoloCittadinoAscoli.getContentPane().add(btnDashboard);
		
		textArea = new JTextArea();
		textArea.setBounds(445, 91, 327, 189);
		frmCircoloCittadinoAscoli.getContentPane().add(textArea);

	}

	public JFrame getFrame() {
		return frmCircoloCittadinoAscoli;
	}

	public JList<Figlio> getListF() {
		return list;
	}

	public DefaultListModel<Figlio> getDlm() {
		return dlm;
	}

	public ScrollPane getScrollPaneF() {
		return scrollPaneFigli;
	}
	
	public JTextArea getTxtG() {
		return textArea;
	}
	
	public void setTxtG(String g) {
		textArea.setText(g);
	}

	public JButton getBtnDashboard() {
		return btnDashboard;
	}
}