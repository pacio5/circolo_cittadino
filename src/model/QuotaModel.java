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
		String operation = "INSERT INTO Quota (DATA_INIZIO, DATA_FINE, VALORE, TIPOLOGIA) VALUES (?, ?, ?, ?)";
		try {
			db.open();
			PreparedStatement command = null;
			command = db.getConn().prepareStatement(operation);
			command.setDate(1, quo.getDataI());
			command.setDate(2, quo.getDataF());
			command.setFloat(3, quo.getValore());
			command.setString(4, quo.getTipologia());
			command.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
	}

	public void updateQuota(Quota quo) {
		String operation = "UPDATE Quota SET DATA_INIZIO = ?, DATA_FINE = ?, VALORE = ?, TIPOLOGIA = ? WHERE ID = ?";
		try {
			db.open();
			PreparedStatement command = null;
			command = db.getConn().prepareStatement(operation);
			command.setDate(1, quo.getDataI());
			command.setDate(2, quo.getDataF());
			command.setFloat(3, quo.getValore());
			command.setString(4, quo.getTipologia());
			command.setInt(5, quo.getId());
			command.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
	}

	public void deleteQuota(int cod) {
		String operation = "DELETE FROM Quota WHERE ID = ?";
		try {
			db.open();
			PreparedStatement command = null;
			command = db.getConn().prepareStatement(operation);
			command.setInt(1, cod);
			command.executeUpdate();
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
	public boolean insertVersamento(Versamento spill) {
		boolean esito = false;
		String operationV = "INSERT INTO Versamento (DATA, IMPORTO, DESCRIZIONE, SOCIO) VALUES (?, ?, ?, ?)";
		String operationM = "INSERT INTO Mese VALUES (?, (SELECT MAX(ID) FROM Versamento))";
		try {
			db.open();
			PreparedStatement command = null;
			command = db.getConn().prepareStatement(operationV);
			command.setDate(1, spill.getData());
			command.setFloat(2, spill.getImporto());
			command.setString(3, spill.getDescrizione());
			command.setString(4, spill.getSocio());
			command.executeUpdate();
			command = null;
			String[] mesi;
			mesi = spill.getMesi().clone();
			command = db.getConn().prepareStatement(operationM);
			for (int i = 0; i < 12 && mesi[i] != null; i++){
				command.setString(1, mesi[i]);
				command.executeUpdate();
			}
			esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return esito;
	}

	public boolean updateVersamento(Versamento spill) {
		boolean esito = false;
		String operationU = "UPDATE Versamento SET DATA = ?, IMPORTO = ?, DESCRIZIONE = ?, SOCIO = ? WHERE ID = ?";
		String operationD = "DELETE FROM Mese WHERE VERSAMENTO = ?";
		String operationM = "INSERT INTO Mese VALUES (?, ?)";
		try {
			db.open();
			PreparedStatement command = null;
			command = db.getConn().prepareStatement(operationU);
			command.setDate(1, spill.getData());
			command.setFloat(2, spill.getImporto());
			command.setString(3, spill.getDescrizione());
			command.setString(4, spill.getSocio());
			command.setInt(5, spill.getId());
			command.executeUpdate();
			command = null;
			
			command = db.getConn().prepareStatement(operationD);
			command.setInt(1, spill.getId());
			command.executeUpdate();
			command = null;
			
			command = db.getConn().prepareStatement(operationM);
			for (int i = 0; i < spill.getMesiLeng() && spill.getMese(i) != null; i++){
				command.setString(1, spill.getMese(i));
				command.setInt(2, spill.getId());
				command.executeUpdate();
			}
			esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return esito;
	}

	public void deleteVersamento(int cod) {
		String operation = "DELETE FROM Versamento WHERE ID = ?";
		try {
			db.open();
			PreparedStatement command = null;
			command = db.getConn().prepareStatement(operation);
			command.setInt(1, cod);
			command.executeUpdate();
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
			rs = command.executeQuery("SELECT * FROM Mese ORDER BY VERSAMENTO");
			rs.next();
			for (int i = 0; i < spill.size(); i++) {
				while (!rs.isAfterLast() && rs.getInt("VERSAMENTO") == spill.get(i).getId()) {
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
