package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ChiusuraAnnualeView {

	private JFrame frame;
	public JTable table;
	private JButton btnDashboard;
	private JButton btnSalda;

	/**
	 * Create the application.
	 */
	public ChiusuraAnnualeView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
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

	public JFrame getFrame() {
		return frame;
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnDashboard() {
		return btnDashboard;
	}

	public JButton getBtnSalda() {
		return btnSalda;
	}
}
