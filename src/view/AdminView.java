package view;

import javax.swing.JFrame;
import javax.swing.JButton;

public class AdminView {

	private JFrame frame;
	private JButton btnLogout;

	/**
	 * Create the application.
	 */
	public AdminView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnLogout = new JButton("Logout");
		btnLogout.setBounds(327, 6, 117, 29);
		frame.getContentPane().add(btnLogout);
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}

	public JFrame getFrame() {
		return frame;
	}
}
