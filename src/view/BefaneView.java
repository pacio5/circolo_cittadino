package view;

import entita.Figlio;
import entita.Socio;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

/**
 * @author simoneonori
 *
 */
public class BefaneView {
	
	private JFrame frame;
	private JList<Figlio> list;
	private JList<Socio> lists; 
	private DefaultListModel<Figlio> dlm;
	private ScrollPane scrollPaneFigli;
	private ScrollPane scrollPaneGenitori;
	private JButton btnDashboard;
	
	/**
	 * Create the frame
	 */
	public BefaneView(ArrayList<Figlio> figli){
		frame = new JFrame("Circolo Cittadino Ascoli Piceno");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 800, 600);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblElencoFigli = new JLabel("Figli");
		lblElencoFigli.setBounds(163, 21, 38, 16);
		frame.getContentPane().add(lblElencoFigli);
		
		JLabel lblElencoSoci = new JLabel("Genitori");
		lblElencoSoci.setBounds(163, 21, 38, 16);
		frame.getContentPane().add(lblElencoSoci);
		
		list = new JList<Figlio>();
		dlm = new DefaultListModel<Figlio>();
		figli.stream().forEach((s)->{
			dlm.addElement(s);
		});
		list.setModel(dlm);		
		
		lists = new JList<Socio>();		
		
		scrollPaneFigli = new ScrollPane();
		scrollPaneFigli.setBounds(10, 57, 353, 503);
		frame.getContentPane().add(scrollPaneFigli);
		scrollPaneFigli.add(list);
		
		btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(697, 9, 97, 41);
		frame.getContentPane().add(btnDashboard);
		
		scrollPaneGenitori = new ScrollPane();
		scrollPaneGenitori.setBounds(431, 57, 353, 503);
		frame.getContentPane().add(scrollPaneGenitori);
		scrollPaneGenitori.add(lists);

	}

	public JFrame getFrame() {
		return frame;
	}

	public JList<Figlio> getListF() {
		return list;
	}
	
	public JList<Socio> getListG() {
		return lists;
	}

	public DefaultListModel<Figlio> getDlm() {
		return dlm;
	}

	public ScrollPane getScrollPaneF() {
		return scrollPaneFigli;
	}
	
	public ScrollPane getScrollPaneG() {
		return scrollPaneGenitori;
	}

	public JButton getBtnDashboard() {
		return btnDashboard;
	}
}