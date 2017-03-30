package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author simoneonori
 * @author eliapacioni
 * @author riccardosmerilli
 * @author francescotalento
 * 
 * @version 1.0 Marzo 2017
 * 
 * 
 * Classe che si della definizione e visualizzazione della
 * finestra della chiusura annuale e i relativi componenti
 */
public class ChiusuraAnnualeView {

	private JFrame frame;
	public JTable table;
	private JButton btnDashboard;
	private JButton btnSalda;

	/**
	 * Creazione dell'applicazione
	 */
	public ChiusuraAnnualeView() {
		initialize();
	}

	/**
	 * Inizializzazione del contenuto del frame
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDescrizione = new JLabel("descrizione");
		lblDescrizione.setBounds(10, 11, 634, 97);
		
		table = new JTable();
		table.setBackground(null);
		table.setAutoResizeMode(4);
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(10, 119, 764, 361);
		
		btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(654, 11, 120, 33);
		
		btnSalda = new JButton("Salda");
		btnSalda.setBounds(349, 506, 89, 23);
		
		frame.getContentPane().add(lblDescrizione);
		frame.getContentPane().add(scroll);
		frame.getContentPane().add(btnDashboard);
		frame.getContentPane().add(btnSalda);
	}

	/**
	 * @return frame (JFrame)
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @return table (JTable)
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * @return btnDashboard (JButton)
	 */
	public JButton getBtnDashboard() {
		return btnDashboard;
	}

	/**
	 * @return btnSalda (JButton)
	 */
	public JButton getBtnSalda() {
		return btnSalda;
	}
}
