package model;

import utility.MySql;
import entita.Convenzione;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConvenzioneModel {
	private MySql db;

	public ConvenzioneModel() {
		db = new MySql();
	}

	public boolean insertConvenzione(Convenzione c) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "INSERT INTO convenzione (RAGIONE_SOCIALE, INDIRIZZO, DESCRIZIONE, PERCENTUALE_SCONTO) VALUES(?,?,?,?)";
		try {
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, c.getRagioneSociale());
			stm.setString(2, c.getIndirizzo());
			stm.setString(3, c.getDescrizione());
			stm.setDouble(4, c.getSconto());

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

	public boolean updateConvenzione(Convenzione c) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "UPDATE convenzione SET ragione_sociale = ?, indirizzo = ?, descrizione = ?, percentuale_sconto = ? WHERE id = ?;";
		try {
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, c.getRagioneSociale());
			stm.setString(2, c.getIndirizzo());
			stm.setString(3, c.getDescrizione());
			stm.setDouble(4, c.getSconto());
			stm.setInt(5, c.getId());

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

	public boolean deleteConvenzione(Convenzione c) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "DELETE FROM convenzione WHERE id = ?";
		try {
			stm = db.getConn().prepareStatement(query);
			stm.setInt(1, c.getId());

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

	public ArrayList<Convenzione> listaConvenzioni() {
		ArrayList<Convenzione> convenzione = new ArrayList<Convenzione>();
		db.open();
		Statement stm;
		String query = "SELECT * FROM convenzione;";
		try {
			stm = db.getConn().createStatement();
			ResultSet res = stm.executeQuery(query);
			while (res.next()) {
				convenzione.add(new Convenzione(res.getInt("id"), res.getString("ragione_sociale"),
						res.getString("indirizzo"), res.getString("descrizione"), res.getDouble("percentuale_sconto")));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			db.close();
		}
		return convenzione;
	}

}
