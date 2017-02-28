package model;

import java.sql.Date;
import utility.MySql;
import entita.Sala;
import entita.Evento;
import entita.NonSocio;
import entita.Socio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author simoneonori
 *
 */

public class PrenotazioneModel {
	private MySql db;
	public PrenotazioneModel(){
		db=new MySql();
	}
	
	/* Operazioni Prenotazioni Eventi */
	
	public boolean insertEvento(Evento e) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "INSERT INTO sEvento (ID, NOME, DATA, DESCRIZIONE, N_POSTI, LUOGO, PREZZO)"
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
		String query = "UPDATE Evento SETSET NOME = ?, DATA = ?, DESCRIZIONE = ?, N_POSTI = ?, LUOGO = ?, PREZZO = ?"
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


}
