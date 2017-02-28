package view;


import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entita.Socio;

import javax.swing.JLabel;
import javax.swing.JList;

public class VisualizzaSoci {

	private JFrame frame;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public VisualizzaSoci(ArrayList<Socio> soci) {
		frame = new JFrame("Elenco soci del Circolo Cittadino di Ascoli Piceno");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 800, 600);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblElencoSoci = new JLabel("Elenco Soci ");
		lblElencoSoci.setBounds(341, 20, 75, 16);
		frame.getContentPane().add(lblElencoSoci);
		
		
		JList<Socio> list = new JList<Socio>();
		list.setBounds(6, 48, 317, 524);
		DefaultListModel<Socio> dlm = new DefaultListModel<Socio>();
		soci.stream().forEach((s)->{
			dlm.addElement(s);
		});
		list.setModel(dlm);
		frame.getContentPane().add(list);
		
		//list.setModel(dlm);
		list.setVisible(true);
	
		/*String intestazione[] = {"C.F.", "NOME", "COGNOME", "EMAIL", "TELEFONO", "MODALITA' PAGAMENTO", "METODO PAGAMENTO"};
		DefaultTableModel tableModel = new DefaultTableModel(0, 0);
		tableModel.setColumnIdentifiers(intestazione);
		JTable table = new JTable();
		table.setModel(tableModel);
		table.getTableHeader().setVisible(true);
		String riga[]= {"prova", "prova","prova", "prova","prova", "prova","prova"};
		tableModel.addRow(riga);
		table.setBounds(1, 50, 798, 548);
		frame.getContentPane().add(table);*/
		
	}
	
	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}
	
	public void setTable(JTable tab){
		table = tab;
	}
}
