package view;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class AdminView {

	private JFrame frame;
	private JButton btnLogout;
	private JButton btnInserisciSocio;

	/**
	 * Create the frame.
	 */
	public AdminView() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnLogout = new JButton("Logout");
		btnLogout.setBounds(677, 6, 117, 29);
		frame.getContentPane().add(btnLogout);
		
		btnInserisciSocio = new JButton("Inserisci Socio");
		btnInserisciSocio.setBounds(24, 76, 117, 29);
		frame.getContentPane().add(btnInserisciSocio);
		
		JLabel lblCircoloCittadinoDi = new JLabel("Circolo Cittadino di Ascoli Piceno");
		lblCircoloCittadinoDi.setBounds(266, 11, 211, 16);
		frame.getContentPane().add(lblCircoloCittadinoDi);
		
	}

	public JFrame getFrame() {
		return frame;
	}
	
	public JButton getBtnLogout() {
		return btnLogout;
	}
	
	public JButton getBtnInserisciSocio() {
		return btnInserisciSocio;
	}
}
