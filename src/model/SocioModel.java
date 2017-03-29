/**
 * 
 */
package model;

import entita.Socio;
import entita.ExSocio;
import entita.Figlio;
import entita.NonSocio;
import utility.MySql;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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

			if (st.executeUpdate() == 1)
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

			if (st.executeUpdate() == 1)
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

			if (st.executeUpdate() == 1)
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

			e.printStackTrace();
		}
		return soci;
	}

	public boolean diventaExSocio(ExSocio n) {
		boolean esito = false;
		db.open();
		PreparedStatement st = null;
		String query = "INSERT INTO exsocio(cf, nome, cognome, sesso, data_nascita, luogo_nascita, indirizzo, citta, cap, email, telefono, "
				+ "professione, stato_civile, coniuge, data_ammissione, tassa_ammissione, mod_pagamento, met_pagamento, tipologia, data_dimissione, espulso)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
			st.setDate(20, n.getDataDimissione());
			st.setBoolean(21, n.getEspulso());
			if (st.executeUpdate() == 1) {
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
					st.executeUpdate();
				}
				esito = true;
			}

			if (esito) {
				query = "DELETE FROM socio WHERE cf = ?;";
				st = db.getConn().prepareStatement(query);
				st.setString(1, n.getCf());
				st.executeUpdate();
				query = "DELETE FROM passaggio WHERE socio = ?";
				st = db.getConn().prepareStatement(query);
				st.setString(1, n.getCf());
				st.executeUpdate();
				query = "DELETE FROM figlio WHERE genitore = ?;";
				st = db.getConn().prepareStatement(query);
				st.setString(1, n.getCf());
				st.executeUpdate();
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

	public ArrayList<ExSocio> elencoExSoci() {
		ArrayList<ExSocio> exSoci = new ArrayList<ExSocio>();
		Statement st;
		try {
			db.open();
			st = db.getConn().createStatement();
			String query = "SELECT * FROM exsocio;";
			ResultSet res = st.executeQuery(query);
			while (res.next()) {
				exSoci.add(new ExSocio(res.getString("cf"), res.getString("nome"), res.getString("cognome"),
						res.getString("sesso").charAt(0), res.getDate("data_nascita"), res.getString("luogo_nascita"),
						res.getString("indirizzo"), res.getString("citta"), res.getString("cap"),
						res.getString("email"), res.getString("telefono"), res.getString("professione"),
						res.getString("stato_civile"), res.getString("coniuge"), res.getDate("data_ammissione"),
						res.getFloat("tassa_ammissione"), res.getString("mod_pagamento"),
						res.getString("met_pagamento"), res.getString("tipologia"), res.getDate("data_dimissione"),
						res.getBoolean("espulso")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close();
		}
		return exSoci;
	}

	public boolean diventaSocio(Socio n) {
		Boolean esito = true;
		esito = inserisciSocio(n);
		ArrayList<Figlio> figli = elencoFigliEx(n.getCf());
		figli.stream().forEach((f) -> {
			inserisciFiglio(f);
		});
		try {
			db.open();
			PreparedStatement st = null;
			String query = "DELETE FROM exsocio WHERE cf = ?;";
			st = db.getConn().prepareStatement(query);
			st.setString(1, n.getCf());
			st.executeUpdate();
			query = "DELETE FROM figlioex WHERE cf = ?;";
			st = db.getConn().prepareStatement(query);
			st.setString(1, n.getCf());
			st.executeUpdate();
			st.close();
		} catch (

		SQLException e) {
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
			if (st.executeUpdate() == 1)
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
			if (st.executeUpdate() == 1)
				esito = true;
			st.close();
		} catch (SQLException e) {
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

			if (st.executeUpdate() == 1)
				esito = true;
			st.close();
		} catch (SQLException e) {
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
			e.printStackTrace();
		} finally {
			db.close();
		}

		return socio;
	}

	// Cercare di unire i due metodi parametrizzando la query
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
			e.printStackTrace();
		} finally {
			db.close();
		}
		return figli;
	}

	public ArrayList<Figlio> elencoFigliEx(String cf) {
		ArrayList<Figlio> figli = new ArrayList<Figlio>();
		Statement st;
		try {
			db.open();
			String query;
			st = db.getConn().createStatement();
			if (cf == null) {
				query = "SELECT * FROM figlioex";
			} else {
				query = "SELECT * FROM figlioex WHERE genitore = '" + cf + "';";
			}
			ResultSet res = st.executeQuery(query);
			while (res.next()) {
				figli.add(new Figlio(res.getString("cf"), res.getString("nome"), res.getString("sesso").charAt(0),
						res.getDate("data_nascita"), cercaSocio(res.getString("genitore")), res.getBoolean("acarico")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return figli;
	}

	public boolean inserisciNonSocio(NonSocio n) {
		db.open();
		PreparedStatement st = null;
		boolean esito = false;
		String query = "INSERT INTO nonsocio(cf, nome, cognome, sesso, email, telefono) VALUES(?,?,?,?,?,?)";
		try {
			st = db.getConn().prepareStatement(query);
			st.setString(1, n.getCf());
			st.setString(2, n.getNome());
			st.setString(3, n.getCognome());
			st.setString(4, Character.toString(n.getSesso()));
			st.setString(5, n.getEmail());
			st.setString(6, n.getTelefono());

			if (st.executeUpdate() == 1)
				esito = true;
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return esito;
	}

	public boolean modificaNonSocio(NonSocio n, String cf) {
		boolean esito = false;
		db.open();
		PreparedStatement st = null;
		String query = "UPDATE nonsocio SET cf = ?, nome = ?, cognome = ?, sesso = ?, email = ?, telefono = ? WHERE cf = ?;";
		try {
			st = db.getConn().prepareStatement(query);
			st.setString(1, n.getCf());
			st.setString(2, n.getNome());
			st.setString(3, n.getCognome());
			st.setString(4, Character.toString(n.getSesso()));
			st.setString(5, n.getEmail());
			st.setString(6, n.getTelefono());
			st.setString(7, cf);

			if (st.executeUpdate() == 1)
				esito = true;
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}

		return esito;
	}

	public boolean eliminaNonSocio(NonSocio n) {
		boolean esito = false;
		db.open();
		PreparedStatement st = null;
		String query = "DELETE FROM nonsocio WHERE cf = ?";
		try {
			st = db.getConn().prepareStatement(query);
			st.setString(1, n.getCf());

			if (st.executeUpdate() == 1)
				esito = true;
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return esito;
	}

	public ArrayList<NonSocio> elencoNonSoci() {
		ArrayList<NonSocio> nonSoci = new ArrayList<NonSocio>();
		Statement st;
		try {
			db.open();
			st = db.getConn().createStatement();
			String query = "SELECT * FROM nonsocio;";
			ResultSet res = st.executeQuery(query);
			while (res.next()) {
				nonSoci.add(new NonSocio(res.getString("cf"), res.getString("nome"), res.getString("cognome"),
						res.getString("sesso").charAt(0), res.getString("email"), res.getString("telefono")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return nonSoci;
	}

	public ArrayList<Socio> passaggioCategoria() {
		ArrayList<Socio> soci = new ArrayList<Socio>();
		Statement st;
		try {
			db.open();
			st = db.getConn().createStatement();
			String query = "SELECT * FROM socio WHERE (DATEDIFF(NOW(), data_ammissione)>=18250 AND tipologia = 'ORDINARIO') "
					+ "OR (DATEDIFF(NOW(), data_nascita)>=14600 AND tipologia = 'GIOVANE')"
					+ "OR (DATEDIFF(NOW(), data_nascita)>=12775 AND tipologia = 'PIU GIOVANE');";
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
			e.printStackTrace();
		} finally {
			db.close();
		}

		return soci;
	}

	public boolean effettuaPassaggioCategoria(Socio n) {
		boolean esito = false;
		PreparedStatement st;
		String tip = null;
		switch (n.getTipologia()) {
		case ("ORDINARIO"):
			tip = "BENEMERITO";
			break;
		case ("GIOVANE"):
			tip = "ORDINARIO";
			break;
		case ("PIU GIOVANE"):
			tip = "GIOVANE";
			break;
		}
		try {
			db.open();
			String query = "UPDATE socio SET tipologia = ? WHERE cf = ? ";
			st = db.getConn().prepareStatement(query);
			st.setString(1, tip);
			st.setString(2, n.getCf());
			st.executeUpdate();
			query = "INSERT INTO passaggio (data_passaggio, tipologia_precedente, socio) VALUES(?,?,?);";
			st = db.getConn().prepareStatement(query);
			st.setDate(1, Date.valueOf(LocalDate.now()));
			st.setString(2, n.getTipologia());
			st.setString(3, n.getCf());
			st.executeUpdate();
			esito = true;
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}

		return esito;
	}
}