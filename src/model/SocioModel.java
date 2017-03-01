/**
 * 
 */
package model;

import entita.Socio;
import entita.Figlio;
import utility.MySql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author eliapacioni
 *
 */
public class SocioModel {

	MySql db = null;

	public SocioModel() {
		db = new MySql();
	}

	public boolean InserisciSocio(Socio n) {
		db.open();
		PreparedStatement st = null;
		boolean esito = false;
		String query = "INSERT INTO socio(cf, nome, cognome, sesso, data_nascita, luogo_nascita, indirizzo, citta, cap, email, telefono, "
				+ "professione, stato_civile, coniuge, data_ammissione, tassa_ammissione, mod_pagamento, met_pagamento, tipologia)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			st = db.getConn().prepareStatement(query);
			st.setString(1, n.getCf());
			st.setString(2, n.getNome());
			st.setString(3, n.getCognome());
			st.setString(4, Character.toString(n.getSesso()));
			st.setDate(5, n.getDataNascita());
			st.setString(6, n.getLuogoNascita());
			st.setString(7, n.getIndirizzo());
			st.setString(8, n.getCitta());
			st.setString(9, n.getCap());
			st.setString(10, n.getEmail());
			st.setString(11, n.getTelefono());
			st.setString(12, n.getProfessione());
			st.setString(13, n.getStatoCivile());
			st.setString(14, n.getConiuge());
			st.setDate(15, n.getDataAmmissione());
			st.setFloat(16, n.getTassaAmmissione());
			st.setString(17, n.getModPagamento());
			st.setString(18, n.getMetPagamento());
			st.setString(19, n.getTipologia());

			int res = st.executeUpdate();
			if (res == 1)
				esito = true;
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close();
		}
		return esito;
	}

	public boolean EliminaSocio(Socio n) {
		boolean esito = false;
		db.open();
		PreparedStatement st = null;
		String query = "DELETE FROM socio WHERE cf = ?";
		try {
			st = db.getConn().prepareStatement(query);
			st.setString(1, n.getCf());

			int res = st.executeUpdate();
			if (res == 1)
				esito = true;
			st.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close();
		}

		return esito;
	}

	public boolean ModificaSocio(Socio n) {
		boolean esito = false;
		db.open();
		PreparedStatement st = null;
		String query = "UPDATE socio SET cf = ?, nome = ?, cognome = ?, sesso = ?, data_nascita = ?, luogo_nascita = ?, indirizzo = ?, citta = ?, cap = ?, email = ?, telefono = ?, "
				+ "professione = ?, stato_civile = ?, coniuge = ?, data_ammissione = ?, tassa_ammissione = ?, mod_pagamento = ?, met_pagamento = ?, tipologia = ? WHERE cf = ?;";
		try {
			st = db.getConn().prepareStatement(query);
			st = db.getConn().prepareStatement(query);
			st.setString(1, n.getCf());
			st.setString(2, n.getNome());
			st.setString(3, n.getCognome());
			st.setString(4, Character.toString(n.getSesso()));
			st.setDate(5, n.getDataNascita());
			st.setString(6, n.getLuogoNascita());
			st.setString(7, n.getIndirizzo());
			st.setString(8, n.getCitta());
			st.setString(9, n.getCap());
			st.setString(10, n.getEmail());
			st.setString(11, n.getTelefono());
			st.setString(12, n.getProfessione());
			st.setString(13, n.getStatoCivile());
			st.setString(14, n.getConiuge());
			st.setDate(15, n.getDataAmmissione());
			st.setFloat(16, n.getTassaAmmissione());
			st.setString(17, n.getModPagamento());
			st.setString(18, n.getMetPagamento());
			st.setString(19, n.getTipologia());
			st.setString(20, n.getCf());

			int res = st.executeUpdate();
			if (res == 1)
				esito = true;
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close();
		}

		return esito;
	}

	public ArrayList<Socio> ElencoSoci() {
		ArrayList<Socio> soci = new ArrayList<Socio>();
		Statement st;
		try {
			db.open();
			st = db.getConn().createStatement();
			String query = "SELECT * FROM socio;";
			ResultSet res = st.executeQuery(query);
			while (res.next()) {
				Socio n = new Socio(
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
				soci.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return soci;
	}

	public boolean DiventaExSocio(Socio n, Boolean espulso) {
		boolean esito = false;
		db.open();
		PreparedStatement st = null;
		String query = "INSERT INTO exsocio(cf, nome, cognome, sesso, data_nascita, luogo_nascita, indirizzo, citta, cap, email, telefono, "
				+ "professione, stato_civile, coniuge, data_ammissione, tassa_ammissione, mod_pagamento, met_pagamento, tipologia, espulso)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			st = db.getConn().prepareStatement(query);
			st.setString(1, n.getCf());
			st.setString(2, n.getNome());
			st.setString(3, n.getCognome());
			st.setString(4, Character.toString(n.getSesso()));
			st.setDate(5, n.getDataNascita());
			st.setString(6, n.getLuogoNascita());
			st.setString(7, n.getIndirizzo());
			st.setString(8, n.getCitta());
			st.setString(9, n.getCap());
			st.setString(10, n.getEmail());
			st.setString(11, n.getTelefono());
			st.setString(12, n.getProfessione());
			st.setString(13, n.getStatoCivile());
			st.setString(14, n.getConiuge());
			st.setDate(15, n.getDataAmmissione());
			st.setFloat(16, n.getTassaAmmissione());
			st.setString(17, n.getModPagamento());
			st.setString(18, n.getMetPagamento());
			st.setString(19, n.getTipologia());
			st.setBoolean(20, espulso);

			int res = st.executeUpdate();
			if (res == 1)
				esito = true;
			query = "DELETE FROM socio WHERE cf = ?;";
			st = db.getConn().prepareStatement(query);
			st.setString(1, n.getCf());
			res = st.executeUpdate();
			if (res == 0)
				esito = false;
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close();
		}

		return esito;
	}

	public boolean DiventaSocio(Socio n) {
		boolean esito = false;
		db.open();
		PreparedStatement st = null;
		String query = "INSERT INTO socio(cf, nome, cognome, sesso, data_nascita, luogo_nascita, indirizzo, citta, cap, email, telefono, "
				+ "professione, stato_civile, coniuge, data_ammissione, tassa_ammissione, mod_pagamento, met_pagamento, tipologia)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			st = db.getConn().prepareStatement(query);
			st.setString(1, n.getCf());
			st.setString(2, n.getNome());
			st.setString(3, n.getCognome());
			st.setString(4, Character.toString(n.getSesso()));
			st.setDate(5, n.getDataNascita());
			st.setString(6, n.getLuogoNascita());
			st.setString(7, n.getIndirizzo());
			st.setString(8, n.getCitta());
			st.setString(9, n.getCap());
			st.setString(10, n.getEmail());
			st.setString(11, n.getTelefono());
			st.setString(12, n.getProfessione());
			st.setString(13, n.getStatoCivile());
			st.setString(14, n.getConiuge());
			st.setDate(15, n.getDataAmmissione());
			st.setFloat(16, n.getTassaAmmissione());
			st.setString(17, n.getModPagamento());
			st.setString(18, n.getMetPagamento());
			st.setString(19, n.getTipologia());

			int res = st.executeUpdate();
			if (res == 1)
				esito = true;
			query = "DELETE FROM exsocio WHERE cf = ?;";
			st = db.getConn().prepareStatement(query);
			st.setString(1, n.getCf());
			res = st.executeUpdate();
			if (res == 0)
				esito = false;
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close();
		}

		return esito;
	}

	public boolean InserisciFiglio(Figlio n) {
		boolean esito = false;
		db.open();
		PreparedStatement st = null;
		String query = "INSERT INTO figlio(cf, nome, data_nascita, genitore, acarico) VALUES(?,?,?,?,?);";
		try {
			st = db.getConn().prepareStatement(query);
			st.setString(1, n.getCf());
			st.setString(2, n.getNome());
			st.setDate(3, n.getDataNascita());
			st.setString(4, n.getGenitore().getCf());
			st.setBoolean(5, n.getACarico());
			int res = st.executeUpdate();
			if (res == 1)
				esito = true;
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close();
		}

		return esito;
	}

	public boolean EliminaFiglio(Figlio n) {
		boolean esito = false;
		db.open();
		PreparedStatement st = null;
		String query = "DELETE FROM figlio WHERE cf = ?;";
		try {
			st = db.getConn().prepareStatement(query);
			st.setString(1, n.getCf());
			int res = st.executeUpdate();
			if (res == 1)
				esito = true;
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close();
		}

		return esito;
	}

	public boolean ModificaFiglio(Figlio n) {
		boolean esito = false;
		db.open();
		PreparedStatement st = null;
		String query = "UPDATE figlio SET cf = ?, nome = ?, data_nascita = ?, genitore = ?, acarico = ? WHERE cf = ?;";
		try {
			st = db.getConn().prepareStatement(query);
			st.setString(1, n.getCf());
			st.setString(2, n.getNome());
			st.setDate(3, n.getDataNascita());
			st.setString(4, n.getGenitore().getCf());
			st.setBoolean(5, n.getACarico());
			int res = st.executeUpdate();
			if (res == 1)
				esito = true;
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close();
		}

		return esito;
	}

}