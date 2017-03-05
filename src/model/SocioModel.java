/**
 * 
 */
package model;

import entita.Socio;
import entita.Figlio;
import entita.NonSocio;
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

	public boolean inserisciSocio(Socio n) {
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

	public boolean eliminaSocio(Socio n) {
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

	public boolean modificaSocio(Socio n, String cf) {
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
			st.setString(20, cf);

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

	public ArrayList<Socio> elencoSoci() {
		ArrayList<Socio> soci = new ArrayList<Socio>();
		Statement st;
		try {
			db.open();
			st = db.getConn().createStatement();
			String query = "SELECT * FROM socio;";
			ResultSet res = st.executeQuery(query);
			while (res.next()) {
				soci.add(new Socio(res.getString("cf"), res.getString("nome"), res.getString("cognome"),
						res.getString("sesso").charAt(0), res.getDate("data_nascita"), res.getString("luogo_nascita"),
						res.getString("indirizzo"), res.getString("citta"), res.getString("cap"),
						res.getString("email"), res.getString("telefono"), res.getString("professione"),
						res.getString("stato_civile"), res.getString("coniuge"), res.getDate("data_ammissione"),
						res.getFloat("tassa_ammissione"), res.getString("mod_pagamento"),
						res.getString("met_pagamento"), res.getString("tipologia")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return soci;
	}

	public boolean diventaExSocio(Socio n, Boolean espulso) {
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
			if (res == 1) {
				query = "SELECT * FROM figlio WHERE genitore = ?";
				st = db.getConn().prepareStatement(query);
				st.setString(1, n.getCf());

				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					query = "INSERT INTO figlioex(cf, nome, sesso, data_nascita, genitore, acarico) VALUES(?,?,?,?,?,?);";
					st = db.getConn().prepareStatement(query);
					st.setString(1, rs.getString("cf"));
					st.setString(2, rs.getString("nome"));
					st.setString(3, rs.getString("sesso"));
					st.setDate(4, rs.getDate("data_nascita"));
					st.setString(5, rs.getString("genitore"));
					st.setBoolean(6, rs.getBoolean("acarico"));
					res = st.executeUpdate();
					if (res == 1)
						esito = true;
				}
			}

			if (esito) {
				query = "DELETE FROM socio WHERE cf = ?;";
				st = db.getConn().prepareStatement(query);
				st.setString(1, n.getCf());
				res = st.executeUpdate();
				query = "DELETE FROM figlio WHERE genitore = ?;";
				st = db.getConn().prepareStatement(query);
				st.setString(1, n.getCf());
				res = st.executeUpdate();
			}

			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close();
		}

		return esito;
	}
	
	public ArrayList<Socio> elencoExSoci() {
		ArrayList<Socio> exSoci = new ArrayList<Socio>();
		Statement st;
		try {
			db.open();
			st = db.getConn().createStatement();
			String query = "SELECT * FROM exsocio;";
			ResultSet res = st.executeQuery(query);
			while (res.next()) {
				exSoci.add(new Socio(res.getString("cf"), res.getString("nome"), res.getString("cognome"),
						res.getString("sesso").charAt(0), res.getDate("data_nascita"), res.getString("luogo_nascita"),
						res.getString("indirizzo"), res.getString("citta"), res.getString("cap"),
						res.getString("email"), res.getString("telefono"), res.getString("professione"),
						res.getString("stato_civile"), res.getString("coniuge"), res.getDate("data_ammissione"),
						res.getFloat("tassa_ammissione"), res.getString("mod_pagamento"),
						res.getString("met_pagamento"), res.getString("tipologia")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exSoci;
	}

	public boolean diventaSocio(Socio n) {
		boolean esito = inserisciSocio(n);
		try {
			db.open();
			PreparedStatement st = null;
			String query = "DELETE FROM exsocio WHERE cf = ?;";
			st = db.getConn().prepareStatement(query);
			st.setString(1, n.getCf());
			int res = st.executeUpdate();
			if (res == 0)
				esito = false;
			st.close();
		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close();
		}

		return esito;
	}

	public boolean inserisciFiglio(Figlio n) {
		boolean esito = false;
		db.open();
		PreparedStatement st = null;
		String query = "INSERT INTO figlio(cf, nome, sesso, data_nascita, genitore, acarico) VALUES(?,?,?,?,?,?);";
		try {
			st = db.getConn().prepareStatement(query);
			st.setString(1, n.getCf());
			st.setString(2, n.getNome());
			st.setString(3, String.valueOf(n.getSesso()));
			st.setDate(4, n.getDataNascita());
			st.setString(5, n.getGenitore().getCf());
			st.setBoolean(6, n.getACarico());
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

	public boolean eliminaFiglio(Figlio n) {
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

	public boolean modificaFiglio(Figlio n, String cf) {
		boolean esito = false;
		db.open();
		PreparedStatement st = null;
		String query = "UPDATE figlio SET cf = ?, nome = ?, sesso = ?, data_nascita = ?, genitore = ?, acarico = ? WHERE cf = ?;";
		try {
			st = db.getConn().prepareStatement(query);
			st.setString(1, n.getCf());
			st.setString(2, n.getNome());
			st.setString(3, String.valueOf(n.getSesso()));
			st.setDate(4, n.getDataNascita());
			st.setString(5, n.getGenitore().getCf());
			st.setBoolean(6, n.getACarico());
			st.setString(7, cf);

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

	private Socio cercaSocio(String cf) {
		Socio socio = null;
		PreparedStatement st;
		String query = "SELECT * FROM socio WHERE cf = ?";
		try {
			db.open();
			st = db.getConn().prepareStatement(query);
			st.setString(1, cf);
			ResultSet res = st.executeQuery();
			if (res.next()) {
				socio = new Socio(res.getString("cf"), res.getString("nome"), res.getString("cognome"),
						res.getString("sesso").charAt(0), res.getDate("data_nascita"), res.getString("luogo_nascita"),
						res.getString("indirizzo"), res.getString("citta"), res.getString("cap"),
						res.getString("email"), res.getString("telefono"), res.getString("professione"),
						res.getString("stato_civile"), res.getString("coniuge"), res.getDate("data_ammissione"),
						res.getFloat("tassa_ammissione"), res.getString("mod_pagamento"),
						res.getString("met_pagamento"), res.getString("tipologia"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close();
		}

		return socio;
	}

	public ArrayList<Figlio> elencoFigli(String cf) {
		ArrayList<Figlio> figli = new ArrayList<Figlio>();
		Statement st;
		try {
			db.open();
			String query;
			st = db.getConn().createStatement();
			if (cf == null) {
				query = "SELECT * FROM figlio";
			} else {
				query = "SELECT * FROM figlio WHERE genitore = '" + cf + "';";
			}
			ResultSet res = st.executeQuery(query);
			while (res.next()) {
				figli.add(new Figlio(res.getString("cf"), res.getString("nome"), res.getString("sesso").charAt(0),
						res.getDate("data_nascita"), cercaSocio(res.getString("genitore")), res.getBoolean("acarico")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close();
		}
		return figli;
	}

	public boolean inserisciNonSocio(NonSocio n){
		db.open();
		PreparedStatement st = null;
		boolean esito = false;
		String query = "INSERT INTO nonsocio(cf, nome, cognome, sesso email, telefono) VALUES(?,?,?,?,?,?)";
		try {
			st = db.getConn().prepareStatement(query);
			st.setString(1, n.getCf());
			st.setString(2, n.getNome());
			st.setString(3, n.getCognome());
			st.setString(4, Character.toString(n.getSesso()));
			st.setString(5, n.getEmail());
			st.setString(6, n.getTelefono());
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
	
	public boolean modificaNonSocio(NonSocio n, String cf){
		boolean esito = false;
		db.open();
		PreparedStatement st = null;
		String query = "UPDATE socio SET cf = ?, nome = ?, cognome = ?, sesso = ?, email = ?, telefono = ? WHERE cf = ?;";
		try {
			st = db.getConn().prepareStatement(query);
			st = db.getConn().prepareStatement(query);
			st.setString(1, n.getCf());
			st.setString(2, n.getNome());
			st.setString(3, n.getCognome());
			st.setString(4, Character.toString(n.getSesso()));
			st.setString(5, n.getEmail());
			st.setString(6, n.getTelefono());
			st.setString(7, cf);

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

	public boolean eliminaNonSocio(NonSocio n){
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

	public ArrayList<NonSocio> elencoNonSoci(){
		ArrayList<NonSocio> nonSoci = new ArrayList<NonSocio>();
		Statement st;
		try {
			db.open();
			st = db.getConn().createStatement();
			String query = "SELECT * FROM nonsocio;";
			ResultSet res = st.executeQuery(query);
			while (res.next()) {
				nonSoci.add(new NonSocio(res.getString("cf"), res.getString("nome"), res.getString("cognome"), res.getString("sesso").charAt(0), res.getString("email"), res.getString("telefono")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nonSoci;
	}
}