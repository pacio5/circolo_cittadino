package model;

import utility.MySql;
import entita.Convenzione;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConvenzioneModel {
	private MySql db;
	public ConvenzioneModel(){
		db=new MySql();
	}
	
	public boolean insertConvenzioni(Convenzione c) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "INSERT INTO Convenzione (ID, RAGIONE_SOCIALE, INDIRIZZO, DESCRIZIONE, SCONTO)"
				+ " VALUES(?,?,?,?.?)";
		try {	
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, c.getId());
			stm.setString(2, c.getRagione_sociale());
			stm.setString(3, c.getIndirizzo());
			stm.setString(4, c.getDescrizione());
			stm.setDouble(5, c.getSconto());
		
			int res = stm.executeUpdate();
			if (res == 1)
				esito = true;
			stm.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			db.close();
		}
		return esito;
	}
	
	public boolean updateConvenzioni(Convenzione c) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "UPDATE Convenzione SET ID = ?, RAGIONE_SOCIALE = ?, INDIRIZZO = ?, DESCRIZIONE = ?, SCONTO = ?"
				+ " WHERE ID = ?";
		try {	
			stm = db.getConn().prepareStatement(query);
			stm.setString(1,  c.getId() );
			stm.setString(2, c.getRagione_sociale());
			stm.setString(3,  c.getIndirizzo());
			stm.setString(4, c.getDescrizione());
			stm.setDouble(5, c.getSconto());
			
			int res = stm.executeUpdate();
			if (res == 1)
				esito = true;
			stm.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			db.close();
		}
		return esito;
	}
	
	public boolean deleteConvenzione(String id) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "DELETE FROM Convenzione WHERE ID = ?";
		try {
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, id);
			
			int res = stm.executeUpdate();
			if (res == 1)
				esito = true;
			stm.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			db.close();
		}
		return esito;
	}
	
	public ArrayList<Convenzione> ListaConvenzioni() {
		ArrayList<Convenzione> Convenzione = new ArrayList<Convenzione>();
		db.open();
		Statement stm;
		String query = "SELECT C.id, C.ragione_sociale, C.indirizzo, C.descrizione, C.sconto FROM Convenzioni AS C INNER JOIN "
				+ "Sconto ON C.id = T.Convenzione;";
		try {
			stm = db.getConn().createStatement();
			ResultSet res = stm.executeQuery(query);
			while (res.next()) {
				Convenzione c = new Convenzioni(
						res.getString("id"), 
						res.getString("ragione_sociale"), 
						res.getString("indirizzo"),
						res.getString("descrizione"),
						res.getDouble("sconto"));
				Convenzione.add(c);
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return Convenzione;
	}
	
	
	
	