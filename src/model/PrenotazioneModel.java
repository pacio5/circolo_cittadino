package model;

import java.sql.Date;
import utility.MySql;
import entita.Evento;
import entita.NonSocio;
import entita.Sala;
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
		String query = "INSERT INTO Evento (NOME, DATA, DESCRIZIONE, N_POSTI, LUOGO, PREZZO)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {	
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, e.getNome());
			stm.setDate(2,  e.getData());
			stm.setString(3, e.getDescrizione());
			stm.setInt(4, e.getPosti());
			stm.setString(5, e.getLuogo());
			stm.setDouble(6, e.getPrezzo());
			
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
	
	public ArrayList<Evento> listaEventi() {
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
		String query = "DELETE FROM PrenotazioneN WHERE NONSOCIO = ? && EVENTO = ?";
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
		String query = "DELETE FROM PrenotazioneS WHERE SOCIO = ? && EVENTO = ?";
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
	
	public ArrayList<Socio> partecipantiSoci(Evento e) {
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
	
	public ArrayList<NonSocio> partecipantiNonSoci(Evento e) {
		ArrayList<NonSocio> partecipantiNS = new ArrayList<NonSocio>();
		db.open();
		PreparedStatement stm;
		String query = "SELECT * FROM nonsocio AS ns INNER JOIN prenotazionen AS p ON ns.cf = p.nonsocio"
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
	
 /* Operazioni Sale */
	
	public boolean insertSala(Sala s) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "INSERT INTO Sala (ID, NOME, CAPIENZA, DESCRIZIONE)"
				+ " VALUES(?,?,?,?)";
		try {	
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, s.getId());
			stm.setString(2,  s.getNome());
			stm.setInt(3, s.getCapienza());
			stm.setString(4, s.getDescrizione());
		
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
	
	public boolean updateSala(Sala s) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "UPDATE Sala SET ID = ?, NOME = ?, CAPIENZA = ?, DESCRIZIONE = ?"
				+ " WHERE ID = ?";
		try {	
			stm = db.getConn().prepareStatement(query);
			stm.setString(1,  s.getId() );
			stm.setString(2, s.getNome());
			stm.setInt(3,  s.getCapienza());
			stm.setString(4, s.getDescrizione());
			
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

	public boolean deleteSala(String id) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "DELETE FROM Sala WHERE ID = ?";
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
	
	public ArrayList<Sala> listaSale() {
		ArrayList<Sala> Sale = new ArrayList<Sala>();
		db.open();
		Statement stm;
		String query = "SELECT S.id, S.nome, S.capienza, S.descrizione, T.prezzo FROM Sala AS S INNER JOIN "
				+ "Tariffa ON S.id = T.sala;";
		try {
			stm = db.getConn().createStatement();
			ResultSet res = stm.executeQuery(query);
			while (res.next()) {
				Sala s = new Sala(
						res.getString("id"), 
						res.getString("nome"), 
						res.getInt("capienza"),
						res.getString("descrizione"),
						res.getFloat("prezzo"));
				Sale.add(s);
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return Sale;
	}
	
	/* Operazioni Sull'affitto delle sale */
	
	public boolean insertAffittoN(NonSocio ns, Sala s, Date dataAft){
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "INSERT INTO AFFITTON (DATA, NONSOCIO, SALA) "
				+ "VALUES(?,?,?)";
		try{
			stm = db.getConn().prepareStatement(query);
			stm.setDate(1, dataAft);
			stm.setString(2, ns.getCf());
			stm.setString(3, s.getId());
			
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
	
	public boolean insertAffittoS(Socio sc, Sala s, Date dataAft){
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "INSERT INTO AFFITTOS (DATA, SOCIO, SALA) "
				+ "VALUES(?,?,?)";
		try{
			stm = db.getConn().prepareStatement(query);
			stm.setDate(1, dataAft);
			stm.setString(2, sc.getCf());
			stm.setString(3, s.getId());
			
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
	
	public boolean updateAffittoN(NonSocio ns, Sala s, Date dataAft){
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "UPDATE AFFITTON SET DATA = ?, NONSOCIO = ?, SALA = ? "
				+ "WHERE DATA = ? && NONSOCIO = ? && SALA = ?";
		try{
			stm = db.getConn().prepareStatement(query);
			stm.setDate(1, dataAft);
			stm.setString(2, ns.getCf());
			stm.setString(3, s.getId());
			stm.setDate(4, dataAft);
			stm.setString(5, ns.getCf());
			stm.setString(6, s.getId());
			
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
	
	public boolean updateAffittoS(Socio sc, Sala s, Date dataAft){
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "UPDATE AFFITTOS SET DATA = ?, SOCIO = ?, SALA = ? "
				+ "WHERE DATA = ? && SOCIO = ? && SALA = ?";
		try{
			stm = db.getConn().prepareStatement(query);
			stm.setDate(1, dataAft);
			stm.setString(2, sc.getCf());
			stm.setString(3, s.getId());
			stm.setDate(4, dataAft);
			stm.setString(5, sc.getCf());
			stm.setString(6, s.getId());
			
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
	
	public boolean deleteAffittoN(String cfns, String idSala, Date dataAft) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "DELETE FROM AffittoN WHERE NONSOCIO = ? && EVENTO = ? && DATA = ?";
		try {
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, cfns);
			stm.setString(2, idSala);
			stm.setDate(3, dataAft);
			
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
	
	public boolean deletePrenotazioneS(String cfs, String idSala, Date dataAft) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "DELETE FROM Prenotazione WHERE NONSOCIO = ? && EVENTO = ? && DATA = ?";
		try {
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, cfs);
			stm.setString(2, idSala);
			stm.setDate(3, dataAft);
			
			
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
	
	public ArrayList<Socio> affituariSoci(Sala s) {
		ArrayList<Socio> affittuariS = new ArrayList<Socio>();
		db.open();
		PreparedStatement stm;
		String query = "SELECT * FROM socio AS sc INNER JOIN affittos AS a ON sc.cf = a.socio"
				+ " INNER JOIN sala AS s A a.sala = s.id WHERE s.id = ?;";
		try {
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, s.getId());
			ResultSet res = stm.executeQuery(query);
			while (res.next()) {
				Socio sc = new Socio(
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
				affittuariS.add(sc);
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return affittuariS;
	}
	
	public ArrayList<NonSocio> affittuariNonSoci(Sala s) {
		ArrayList<NonSocio> affittuariNS = new ArrayList<NonSocio>();
		db.open();
		PreparedStatement stm;
		String query = "SELECT * FROM nonsocio AS ns INNER JOIN affitton AS a ON ns.cf = a.nonsocio"
				+ " INNER JOIN sala AS s a.sala = s.id WHERE s.id = ?;";
		try {
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, s.getId());
			ResultSet res = stm.executeQuery(query);
			while (res.next()) {
				NonSocio ns = new NonSocio(
						res.getString("cf"), 
						res.getString("nome"), 
						res.getString("cognome"),
						res.getString("sesso").charAt(0),
						res.getString("email"), 
						res.getString("telefono"));
				affittuariNS.add(ns);
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return affittuariNS;
	}
		
}
