package view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class SpillManagementView {

	private JFrame frame;
	private JTable table;
	private JButton btnElimina;
	private JButton btnDashboard;

	/**
	 * Create the application.
	 */
	public SpillManagementView() {
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
		lblIntroduzione.setBounds(10, 11, 634, 42);

		table = new JTable();
		table.setBackground(null);
		table.setAutoResizeMode(4);

		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(10, 64, 764, 402);

		btnElimina = new JButton("Elimina");
		btnElimina.setBounds(349, 510, 89, 23);

		btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(654, 11, 120, 33);

		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblIntroduzione);
		frame.getContentPane().add(scroll);
		frame.getContentPane().add(btnElimina);
		frame.getContentPane().add(btnDashboard);

	}

	public JFrame getFrameGestVersamento() {
		return frame;
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnElimina() {
		return btnElimina;
	}

	public JButton getBtnDashboard() {
		return btnDashboard;
	}
}
