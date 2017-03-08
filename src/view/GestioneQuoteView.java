package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class GestioneQuoteView {

	private JFrame frame;
	private JTable table;
	private JButton btnDashboard;
	private JButton btnElimina;

	/**
	 * Create the application.
	 */
	public GestioneQuoteView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblIntroduzione = new JLabel("descrizione");
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
	
	public JFrame getFrameGestQuote (){
		return frame;
	}
	
	public JTable getTable (){
		return table;
	}
	
	public JButton getBtnElimina() {
		return btnElimina;
	}
	
	public JButton getBtnDashboard() {
		return btnDashboard;
	}
}
