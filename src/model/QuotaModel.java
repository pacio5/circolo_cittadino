package model;

import java.util.*;
import java.sql.*;
import utility.MySql;
import entita.Versamento;
import entita.Quota;

public class QuotaModel {	
	
	MySql db;

	public QuotaModel() {
		db = new MySql();
	}

	

	/* Operazioni quote */
	public void insertQuota(Quota quo) {
		try {
			db.open();
			Statement command = db.getConn().createStatement();
			command.executeUpdate(
					"INSERT INTO Quota (DATA_INIZIO, DATA_FINE, VALORE, TIPOLOGIA) VALUES ('" + quo.getDataI() + "', '"
							+ quo.getDataF() + "', '" + quo.getValore() + "', '" + quo.getTipologia() + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
	}

	public void updateQuota(Quota quo) {
		try {
			db.open();
			Statement command = db.getConn().createStatement();
			command.executeUpdate("UPDATE Quota SET DATA_INIZIO = '" + quo.getDataI() + "', DATA_FINE = '"
					+ quo.getDataF() + "', VALORE = '" + quo.getValore() + "', TIPOLOGIA = '" + quo.getTipologia()
					+ "' WHERE ID = '" + quo.getId() + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
	}

	public void deleteQuota(int cod) {
		try {
			db.open();
			Statement command = db.getConn().createStatement();
			command.executeUpdate("DELETE FROM Quota WHERE ID = '" + cod + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
	}

	public ArrayList<Quota> getQuote() {
		ArrayList<Quota> quote = new ArrayList<Quota>();
		try {
			db.open();
			Statement command = db.getConn().createStatement();
			ResultSet rs = command.executeQuery("SELECT * FROM Quota");
			while (rs.next()) {
				quote.add(new Quota(rs.getInt("ID"), rs.getFloat("VALORE"), rs.getString("TIPOLOGIA"),
						rs.getDate("DATA_INIZIO"), rs.getDate("DATA_FINE")));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return quote;
	}

	/* Operazioni versamenti */
	public void insertVersamento(Versamento spill) {
		try {
			db.open();
			Statement command = db.getConn().createStatement();
			command.executeUpdate(
					"INSERT INTO Versamento (DATA, IMPORTO, DESCRIZIONE, SOCIO) VALUES ('" + spill.getData() + "', '"
							+ spill.getImporto() + "', '" + spill.getDescrizione() + "', '" + spill.getSocio() + "')");
			String[] mesi;
			mesi = (spill.getMesi().clone());
			for (int i = 0; i < mesi.length; i++)
				command.executeUpdate("INSERT INTO Mese VALUES ('" + mesi[i] + "', (SELECT MAX(ID) FROM Versamento))");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
	}

	public void updateVersamento(Versamento spill) {
		try {
			db.open();
			Statement command = db.getConn().createStatement();
			command.executeUpdate("UPDATE Versamento SET DATA = '" + spill.getData() + "', IMPORTO = '"
					+ spill.getImporto() + "', DESCRIZIONE = '" + spill.getDescrizione() + "', SOCIO = '"
					+ spill.getSocio() + "' WHERE ID = '" + spill.getId() + "'");
			command.executeUpdate("DELETE FROM Mese WHERE VERSAMENTO = '" + spill.getId() + "'");
			for (int i = 0; i < spill.getMesiLeng(); i++)
				command.executeUpdate("INSERT INTO Mese VALUES ('" + spill.getMese(i) + "', '" + spill.getId() + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
	}

	public void deleteVersamento(int cod) {
		try {
			db.open();
			Statement command = db.getConn().createStatement();
			command.executeUpdate("DELETE FROM Versamento WHERE ID = '" + cod + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
	}

	public ArrayList<Versamento> getVersamenti() {
		ArrayList<Versamento> spill = new ArrayList<Versamento>();
		try {
			db.open();
			Statement command = db.getConn().createStatement();
			ResultSet rs = command.executeQuery("SELECT * FROM Versamento");
			while (rs.next()) {
				spill.add(new Versamento(rs.getInt("ID"), rs.getFloat("IMPORTO"), rs.getString("SOCIO"),
						rs.getDate("DATA"), rs.getString("DESCRIZIONE")));
			}
			rs = command.executeQuery("SELECT * FROM Mese");
			rs.next();
			for (int i = 0; i < spill.size(); i++) {
				rs.first();
				while (rs.getInt("VERSAMENTO") == spill.get(i).getId()) {
					spill.get(i).setMese(rs.getString("DATA"));
					rs.next();
				}
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return spill;
	}
}