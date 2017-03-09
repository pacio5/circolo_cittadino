package view;
import javax.swing.JButton;
import javax.swing.JFrame;


public class PrenotaEventoView {

	private JFrame frmCircoloCittadino;
	private JButton btnDashboard;
	

	/**
	 * Create the frame.
	 */
	public PrenotaEventoView() {
		frmCircoloCittadino = new JFrame("Circolo Cittadino - Prenota Sala");
		frmCircoloCittadino.setTitle("Circolo Cittadino - Prenotazione Sale");
		frmCircoloCittadino.setBounds(100, 100, 800, 600);
		frmCircoloCittadino.setResizable(false);
		frmCircoloCittadino.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCircoloCittadino.getContentPane().setLayout(null);
		
		btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(697, 11, 97, 41);
		frmCircoloCittadino.getContentPane().add(btnDashboard);

		
	}
	
	public JFrame getFrame() {
		return frmCircoloCittadino;
	}
	
	public JButton getBtnDashboard() {
		return btnDashboard;
	}
	
}
