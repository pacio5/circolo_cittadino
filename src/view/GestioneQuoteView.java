package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

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
 * finestra della gestione delle quote e i relativi componenti
 */
public class GestioneQuoteView {

	private JFrame frame;
	private JTable table;
	private JButton btnDashboard;
	private JButton btnElimina;

	/**
	 * Creazione dell'applicazione
	 */
	public GestioneQuoteView() {
		initialize();
	}

	/**
	 * Inizializzazione del contenuto del frame
	 */
	private void initialize() {
		frame = new JFrame("Circolo cittadino - Gestione quote");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblIntroduzione = new JLabel(
				"Visualizzazione di tutte le quote precedentemente registrate e possibilità di eliminarle");
		lblIntroduzione.setBounds(10, 11, 634, 80);

		table = new JTable();
		table.setBackground(null);
		table.setAutoResizeMode(4);

		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(10, 102, 764, 402);
		
		btnElimina = new JButton("Elimina");
		btnElimina.setBounds(339, 527, 89, 23);
		
		btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(654, 11, 120, 33);
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblIntroduzione);
		frame.getContentPane().add(scroll);
		frame.getContentPane().add(btnDashboard);
		frame.getContentPane().add(btnElimina);
		
		
	}
	
	/**
	 * @return frame (JFrame)
	 */
	public JFrame getFrameGestQuote (){
		return frame;
	}
	
	/**
	 * @return table (JTable)
	 */
	public JTable getTable (){
		return table;
	}
	
	/**
	 * @return btnElimina (JButton)
	 */
	public JButton getBtnElimina() {
		return btnElimina;
	}
	
	/**
	 * @return btnDashboard (JButton)
	 */
	public JButton getBtnDashboard() {
		return btnDashboard;
	}
}
