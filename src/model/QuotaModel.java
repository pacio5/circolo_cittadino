package model;

import java.util.*;
import java.sql.*;
import java.sql.Date;

import utility.MySql;
import entita.Versamento;
import entita.Quota;

public class QuotaModel {

	MySql db;

	public QuotaModel() {
		db = new MySql();
	}

	/* Operazioni quote */
	public boolean insertQuota(Quota quo) {
		boolean esito = false;
		String operation = "INSERT INTO Quota (DATA_INIZIO, VALORE, TIPOLOGIA) VALUES (?, ?, ?)";
		try {
			db.open();
			PreparedStatement command = null;
			command = db.getConn().prepareStatement(operation);
			command.setDate(1, quo.getDataI());
			command.setFloat(2, quo.getValore());
			command.setString(3, quo.getTipologia());
			command.executeUpdate();
			esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return esito;
	}

	public boolean updateQuota(Quota quo) {
		boolean esito = false;
		String operation = "UPDATE Quota SET DATA_INIZIO = ?,  VALORE = ?, TIPOLOGIA = ? WHERE ID = ?";
		try {
			db.open();
			PreparedStatement command = null;
			command = db.getConn().prepareStatement(operation);
			command.setDate(1, quo.getDataI());
			command.setFloat(2, quo.getValore());
			command.setString(3, quo.getTipologia());
			command.setInt(4, quo.getId());
			command.executeUpdate();
			esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return esito;
	}

	public boolean deleteQuota(int cod) {
		boolean esito = false;
		String operation = "DELETE FROM Quota WHERE ID = ?";
		try {
			db.open();
			PreparedStatement command = null;
			command = db.getConn().prepareStatement(operation);
			command.setInt(1, cod);
			command.executeUpdate();
			esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return esito;
	}

	public ArrayList<Quota> getQuote() {
		ArrayList<Quota> quote = new ArrayList<Quota>();
		try {
			db.open();
			Statement command = db.getConn().createStatement();
			ResultSet rs = command.executeQuery("SELECT * FROM Quota");
			while (rs.next()) {
				quote.add(new Quota(rs.getInt("ID"), rs.getFloat("VALORE"), rs.getString("TIPOLOGIA"),
						rs.getDate("DATA_INIZIO")));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return quote;
	}

	public Quota getQuotaPrecendente(String tipo) {
		Quota quote = null;
		String operation = "SELECT * FROM Quota WHERE DATA_INIZIO = (SELECT MAX(DATA_INIZIO) FROM Quota WHERE TIPOLOGIA = ?) AND TIPOLOGIA = ?";
		try {
			db.open();
			PreparedStatement command = null;
			command = db.getConn().prepareStatement(operation);
			command.setString(1, tipo);
			command.setString(2, tipo);
			ResultSet rs = command.executeQuery();
			if (rs.next()) {
				quote = new Quota(rs.getInt("ID"), rs.getFloat("VALORE"), rs.getString("TIPOLOGIA"),
						rs.getDate("DATA_INIZIO"));
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
			for (int i = 0; i < 12 && mesi[i] != null; i++) {
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
			for (int i = 0; i < spill.getMesiLeng() && spill.getMese(i) != null; i++) {
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

	public boolean deleteVersamento(int cod) {
		boolean esito = false;
		String operation = "DELETE FROM Versamento WHERE ID = ?";
		try {
			db.open();
			PreparedStatement command = null;
			command = db.getConn().prepareStatement(operation);
			command.setInt(1, cod);
			command.executeUpdate();
			esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return esito;
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

	public float getImportoMese(String tipo, Date data) {
		float valore = 0;
		String operation = "SELECT VALORE FROM Quota WHERE TIPOLOGIA = ? AND DATA_INIZIO = (SELECT MAX(DATA_INIZIO) FROM Quota WHERE DATA_INIZIO <= ? AND TIPOLOGIA = ?)";
		try {
			db.open();
			PreparedStatement command = null;
			command = db.getConn().prepareStatement(operation);
			command.setString(1, tipo);
			command.setDate(2, data);
			command.setString(3, tipo);
			ResultSet rs = command.executeQuery();
			if (rs.next())
				valore = rs.getFloat("VALORE");
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return valore;
	}
}
