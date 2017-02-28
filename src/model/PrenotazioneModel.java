package model;

import java.sql.Date;
import utility.MySql;
import entita.Evento;
import entita.NonSocio;
import entita.Socio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author simoneonori
 *
 */

public class PrenotazioneModel {
	private MySql db;
	public PrenotazioneModel(){
		db=new MySql();
	}
	
	/* Operazioni Eventi */
	
	public boolean insertEvento(Evento e) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "INSERT INTO Evento (ID, NOME, DATA, DESCRIZIONE, N_POSTI, LUOGO, PREZZO)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {	
			stm = db.getConn().prepareStatement(query);
			stm.setString(1,  e.getId() );
			stm.setString(2, e.getNome());
			stm.setDate(3,  e.getData());
			stm.setString(4, e.getDescrizione());
			stm.setInt(5, e.getPosti());
			stm.setString(6, e.getLuogo());
			stm.setDouble(7, e.getPrezzo());
			
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
	
	public boolean updateEvento(Evento e) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "UPDATE Evento SET NOME = ?, DATA = ?, DESCRIZIONE = ?, N_POSTI = ?, LUOGO = ?, PREZZO = ?"
				+ " WHERE ID = ?";
		try {	
			stm = db.getConn().prepareStatement(query);
			stm.setString(1,  e.getId() );
			stm.setString(2, e.getNome());
			stm.setDate(3,  e.getData());
			stm.setString(4, e.getDescrizione());
			stm.setInt(5, e.getPosti());
			stm.setString(6, e.getLuogo());
			stm.setDouble(7, e.getPrezzo());
			stm.setString(8, e.getId());
			
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

	public boolean deleteEvento(String id) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "DELETE FROM Evento WHERE ID = ?";
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
	
	public ArrayList<Evento> ListaEventi() {
		ArrayList<Evento> Eventi = new ArrayList<Evento>();
		db.open();
		Statement stm;
		String query = "SELECT * FROM evento;";
		try {
			stm = db.getConn().createStatement();
			ResultSet res = stm.executeQuery(query);
			while (res.next()) {
				Evento e = new Evento(
						res.getString("id"), 
						res.getString("nome"), 
						res.getDate("data"),
						res.getString("descrizione"), 
						res.getInt("posti"), 
						res.getString("luogo"),
						res.getDouble("prezzo"));
				Eventi.add(e);
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return Eventi;
	}
	
	/* Operazioni sulle Prenotazioni degli Eventi */
	
	public boolean insertPrenotazioneN(NonSocio ns, int NumB, Evento e, Date dataAcq){
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "INSERT INTO PrenotazioneN (N_BIGLIETTI, DATA_ACQUISTO, NONSOCIO, EVENTO) "
				+ "VALUES(?,?,?,?)";
		try{
			stm = db.getConn().prepareStatement(query);
			stm.setInt(1, NumB);
			stm.setDate(2, dataAcq);
			stm.setString(3, ns.getCf());
			stm.setString(4, e.getId());
			
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
	
	public boolean insertPrenotazioneS(Socio s, int NumB, Evento e, Date dataAcq){
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "INSERT INTO PrenotazioneS (N_BIGLIETTI, DATA_ACQUISTO, SOCIO, EVENTO) "
				+ "VALUES(?,?,?,?)";
		try{
			stm = db.getConn().prepareStatement(query);
			stm.setInt(1, NumB);
			stm.setDate(2, dataAcq);
			stm.setString(3, s.getCf());
			stm.setString(4, e.getId());
			
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
	
	public boolean updatePrenotazioneN(NonSocio ns, int NumB, Evento e, Date dataAcq){
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "UPDATE PrenotazioneN SET N_BIGLIETTI = ?, DATA_ACQUISTO = ?, NONSOCIO = ?, EVENTO = ? "
				+ "WHERE NONSOCIO = ? && EVENTO = ?";
		try{
			stm = db.getConn().prepareStatement(query);
			stm.setInt(1, NumB);
			stm.setDate(2, dataAcq);
			stm.setString(3, ns.getCf());
			stm.setString(4, e.getId());
			stm.setString(5, ns.getCf());
			stm.setString(6, e.getId());
			
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
	
	public boolean updatePrenotazioneS(Socio s, int NumB, Evento e, Date dataAcq){
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "UPDATE PrenotazioneS SET N_BIGLIETTI = ?, DATA_ACQUISTO = ?, SOCIO = ?, EVENTO = ? "
				+ "WHERE SOCIO = ? && EVENTO = ?";
		try{
			stm = db.getConn().prepareStatement(query);
			stm.setInt(1, NumB);
			stm.setDate(2, dataAcq);
			stm.setString(3, s.getCf());
			stm.setString(4, e.getId());
			stm.setString(5, s.getCf());
			stm.setString(6, e.getId());
			
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
	
	public boolean deletePrenotazioneN(String cfNs, String idEvento) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "DELETE FROM Prenotazione WHERE NONSOCIO = ? && EVENTO = ?";
		try {
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, cfNs);
			stm.setString(2, idEvento);
			
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
	
	public boolean deletePrenotazioneS(String cfS, String idEvento) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "DELETE FROM Prenotazione WHERE NONSOCIO = ? && EVENTO = ?";
		try {
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, cfS);
			stm.setString(2, idEvento);
			
			
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
	
	/* Operazioni sui Partecipanti agli Eventi */
	
	public ArrayList<Socio> PartecipantiSoci(Evento e) {
		ArrayList<Socio> partecipantiS = new ArrayList<Socio>();
		db.open();
		PreparedStatement stm;
		String query = "SELECT * FROM socio AS s INNER JOIN prenotaziones AS p ON s.cf = p.socio"
				+ " INNER JOIN evento AS e p.evento = e.id WHERE e.id = ?;";
		try {
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, e.getId());
			ResultSet res = stm.executeQuery(query);
			while (res.next()) {
				Socio s = new Socio(
						res.getString("cf"), 
						res.getString("nome"), 
						res.getString("cognome"),
						res.getString("sesso").charAt(0), 
						res.getDate("data_nascita"), 
						res.getString("luogo_nascita"),
						res.getString("indirizzo"), 
						res.getString("citta"), 
						res.getString("cap"),
						res.getString("email"), 
						res.getString("telefono"), 
						res.getString("professione"),
						res.getString("stato_civile"), 
						res.getString("coniuge"), 
						res.getDate("data_ammissione"),
						res.getFloat("tassa_ammissione"), 
						res.getString("mod_pagamento"),
						res.getString("met_pagamento"), 
						res.getString("tipologia"));
				partecipantiS.add(s);
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return partecipantiS;
	}
	
	public ArrayList<NonSocio> PartecipantiNonSoci(Evento e) {
		ArrayList<NonSocio> partecipantiNS = new ArrayList<NonSocio>();
		db.open();
		PreparedStatement stm;
		String query = "SELECT * FROM socio AS s INNER JOIN prenotaziones AS p ON s.cf = p.socio"
				+ " INNER JOIN evento AS e p.evento = e.id WHERE e.id = ?;";
		try {
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, e.getId());
			ResultSet res = stm.executeQuery(query);
			while (res.next()) {
				NonSocio ns = new NonSocio(
						res.getString("cf"), 
						res.getString("nome"), 
						res.getString("cognome"),
						res.getString("sesso").charAt(0), 
						res.getDate("data_nascita"),
						res.getString("indirizzo"), 
						res.getString("citta"), 
						res.getString("cap"),
						res.getString("email"), 
						res.getString("telefono"));
				partecipantiNS.add(ns);
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return partecipantiNS;
	}
		
}
