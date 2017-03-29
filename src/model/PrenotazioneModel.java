package model;

import java.sql.Date;
import utility.MySql;
import entita.Evento;
import entita.NonSocio;
import entita.Sala;
import entita.Socio;
import entita.Prenotazione;
import entita.Affitto;
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

	MySql db = null;

	public PrenotazioneModel() {
		db = new MySql();
	}

	/* Operazioni Eventi */

	public boolean insertEvento(Evento e) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "INSERT INTO Evento (NOME, DATA, DESCRIZIONE, N_POSTI, LUOGO, PREZZO)" + " VALUES(?,?,?,?,?,?);";
		try {
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, e.getNome());
			stm.setDate(2, e.getData());
			stm.setString(3, e.getDescrizione());
			stm.setInt(4, e.getPosti());
			stm.setString(5, e.getLuogo());
			stm.setFloat(6, e.getPrezzo());

			if (stm.executeUpdate() == 1)
				esito = true;
			stm.close();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} finally {
			db.close();
		}
		return esito;
	}

	public boolean updateEvento(Evento e, int idvecchio) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "UPDATE Evento SET NOME = ?, DATA = ?, DESCRIZIONE = ?, N_POSTI = ?, LUOGO = ?, PREZZO = ?"
				+ " WHERE ID = ?";
		try {
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, e.getNome());
			stm.setDate(2, e.getData());
			stm.setString(3, e.getDescrizione());
			stm.setInt(4, e.getPosti());
			stm.setString(5, e.getLuogo());
			stm.setFloat(6, e.getPrezzo());
			stm.setInt(7, idvecchio);

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
				Evento e = new Evento(res.getString("id"), res.getString("nome"), res.getDate("data"),
						res.getString("descrizione"), res.getInt("n_posti"), res.getString("luogo"),
						res.getFloat("prezzo"));
				Eventi.add(e);
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return Eventi;
	}

	public ArrayList<Evento> listaEventiValidi() {
		ArrayList<Evento> Eventi = new ArrayList<Evento>();
		db.open();
		Statement stm;
		String query = "SELECT * FROM evento WHERE data>CURDATE();";
		try {
			stm = db.getConn().createStatement();
			ResultSet res = stm.executeQuery(query);
			while (res.next()) {
				Evento e = new Evento(res.getString("id"), res.getString("nome"), res.getDate("data"),
						res.getString("descrizione"), res.getInt("n_posti"), res.getString("luogo"),
						res.getFloat("prezzo"));
				Eventi.add(e);
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return Eventi;
	}

	public int postiDisponibili(Evento e) {
		db.open();
		int po = 0;
		PreparedStatement stm = null;
		String query = "SELECT SUM(n_biglietti) AS n FROM prenotaziones AS ps INNER JOIN evento AS e ON ps.evento=e.id INNER JOIN"
				+ " prenotazionen AS pn ON pn.evento=e.id WHERE e.id=?"; // query
																			// giusta?
		try {
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, e.getId());

			ResultSet res = stm.executeQuery(query);
			po = res.getInt("n");

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			db.close();
		}
		return e.getPosti() - po;
	}

	/* Operazioni sulle Prenotazioni degli Eventi */

	public boolean insertPrenotazioneN(NonSocio ns, int NumB, Evento e, Date dataAcq) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "INSERT INTO PrenotazioneN (N_BIGLIETTI, DATA_ACQUISTO, NONSOCIO, EVENTO) " + "VALUES(?,?,?,?)";
		try {
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

	public boolean insertPrenotazioneS(Socio s, int NumB, Evento e, Date dataAcq) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "INSERT INTO PrenotazioneS (N_BIGLIETTI, DATA_ACQUISTO, SOCIO, EVENTO) " + "VALUES(?,?,?,?)";
		try {
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

	public boolean deletePrenotazione(Prenotazione p) {
		db.open();
		PreparedStatement stm = null;
		PreparedStatement stm2 = null;
		boolean esito = false;
		String query = "DELETE FROM PrenotazioneN WHERE NONSOCIO = ? && EVENTO = ?";
		String query2 = "DELETE FROM PrenotazioneS WHERE SOCIO = ? && EVENTO = ?";
		try {
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, p.getCf());
			stm.setInt(2, p.getEvento());

			stm2 = db.getConn().prepareStatement(query2);
			stm2.setString(1, p.getCf());
			stm2.setInt(2, p.getEvento());

			int res = stm.executeUpdate();
			int res2 = stm.executeUpdate();
			if (res == 1 || res2 == 1)
				esito = true;
			stm.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			db.close();
		}
		return esito;
	}

	public ArrayList<Prenotazione> listaPrenotazioni(String IdEvento) {
		ArrayList<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
		db.open();
		PreparedStatement stm;
		String query = "SELECT * FROM prenotazionen, prenotaziones WHERE evento=?;";
		try {
			stm = db.getConn().prepareStatement(query);
			stm.setInt(1, Integer.valueOf(IdEvento));
			stm.setInt(2, Integer.valueOf(IdEvento));

			ResultSet res = stm.executeQuery(query);
			while (res.next()) {
				Prenotazione p = new Prenotazione(res.getDate("data_acquisto"), res.getString("cf"),
						res.getInt("evento"), res.getInt("n_biglietti"));
				prenotazioni.add(p);
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return prenotazioni;
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
				Socio s = new Socio(res.getString("cf"), res.getString("nome"), res.getString("cognome"),
						res.getString("sesso").charAt(0), res.getDate("data_nascita"), res.getString("luogo_nascita"),
						res.getString("indirizzo"), res.getString("citta"), res.getString("cap"),
						res.getString("email"), res.getString("telefono"), res.getString("professione"),
						res.getString("stato_civile"), res.getString("coniuge"), res.getDate("data_ammissione"),
						res.getFloat("tassa_ammissione"), res.getString("mod_pagamento"),
						res.getString("met_pagamento"), res.getString("tipologia"));
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
				NonSocio ns = new NonSocio(res.getString("cf"), res.getString("nome"), res.getString("cognome"),
						res.getString("sesso").charAt(0), res.getString("email"), res.getString("telefono"));
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
		String query = "INSERT INTO Sala (NOME, CAPIENZA, DESCRIZIONE, TARIFFA)" + " VALUES(?,?,?,?)";
		try {
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, s.getNome());
			stm.setInt(2, s.getCapienza());
			stm.setString(3, s.getDescrizione());
			stm.setDouble(4, s.getTariffa());

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

	public boolean updateSala(Sala s, String nomevs) {
		boolean esito = false;
		db.open();
		PreparedStatement stm = null;
		String query = "UPDATE sala SET nome = ?, capienza = ?, descrizione = ?, tariffa = ? WHERE nome = ?;";
		try {
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, s.getNome());
			stm.setInt(2, s.getCapienza());
			stm.setString(3, s.getDescrizione());
			stm.setFloat(4, s.getTariffa());
			stm.setString(5, nomevs);

			if (stm.executeUpdate() == 1)
				esito = true;
			stm.close();
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} finally {
			db.close();
		}
		return esito;
	}

	public boolean deleteSala(String nome) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "DELETE FROM Sala WHERE NOME = ?";
		try {
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, nome);

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
		ArrayList<Sala> sale = new ArrayList<Sala>();
		Statement stm;
		try {
			db.open();
			String query = "SELECT * FROM Sala;";
			stm = db.getConn().createStatement();
			ResultSet res = stm.executeQuery(query);
			while (res.next()) {
				sale.add(new Sala(res.getString("nome"), res.getInt("capienza"), res.getString("descrizione"),
						res.getFloat("tariffa")));
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return sale;
	}

	public ArrayList<Sala> listaSaleDisponibili(Date data) {
		ArrayList<Sala> sale = new ArrayList<Sala>();
		PreparedStatement stm = null;
		String query = "SELECT * FROM sala WHERE sala.nome NOT IN (SELECT affitton.sala FROM affitton WHERE DATEDIFF(affitton.data, ?) = 0 ) "
				+ "AND sala.nome NOT IN (SELECT affittos.sala FROM affittos WHERE DATEDIFF(affittos.data, ?) = 0 );";
		try {
			db.open();
			stm = db.getConn().prepareStatement(query);
			stm.setDate(1, data);
			stm.setDate(2, data);
			ResultSet res = stm.executeQuery();
			while (res.next()) {
				sale.add(new Sala(res.getString("nome"), res.getInt("capienza"), res.getString("descrizione"),
						res.getFloat("tariffa")));
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return sale;
	}

	/* Operazioni Sull'affitto delle sale */

	public boolean insertAffittoN(NonSocio ns, Sala s, Date dataAft) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "INSERT INTO AFFITTON (DATA, NONSOCIO, SALA) " + "VALUES(?,?,?)";
		try {
			stm = db.getConn().prepareStatement(query);
			stm.setDate(1, dataAft);
			stm.setString(2, ns.getCf());
			stm.setString(3, s.getNome());

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

	public boolean insertAffittoS(Socio sc, Sala s, Date dataAft) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "INSERT INTO AFFITTOS (DATA, SOCIO, SALA) " + "VALUES(?,?,?)";
		try {
			stm = db.getConn().prepareStatement(query);
			stm.setDate(1, dataAft);
			stm.setString(2, sc.getCf());
			stm.setString(3, s.getNome());

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

	public boolean deleteAffitto(Affitto a) {
		db.open();
		PreparedStatement stm = null;
		PreparedStatement stm2 = null;
		boolean esito = false;
		String query = "DELETE FROM affitton WHERE NONSOCIO = ? && EVENTO = ? && DATA = ?";
		String query2 = "DELETE FROM affittos WHERE SOCIO = ? && EVENTO = ? && DATA = ?";
		try {
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, a.getCf());
			stm.setString(2, a.getSala());
			stm.setDate(3, a.getData());

			stm2 = db.getConn().prepareStatement(query2);
			stm2.setString(1, a.getCf());
			stm2.setString(2, a.getSala());
			stm2.setDate(3, a.getData());

			int res = stm.executeUpdate();
			int res2 = stm2.executeUpdate();
			if (res == 1 || res2 == 1)
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

	public ArrayList<Affitto> afittuari() {
		ArrayList<Affitto> affittuari = new ArrayList<Affitto>();
		db.open();
		Statement stm;
		String query = "SELECT * FROM affittos WHERE DATEDIFF(affittos.data, CURDATE()) >= 0;";
		try {
			stm = db.getConn().createStatement();
			ResultSet res = stm.executeQuery(query);
			while (res.next()) {
				affittuari.add(new Affitto(res.getDate("data"), res.getString("socio"), res.getString("sala")));
			}
			query = "SELECT * FROM affitton WHERE DATEDIFF(affitton.data, CURDATE()) >= 0;";
			res = stm.executeQuery(query);
			while (res.next()) {
				affittuari.add(new Affitto(res.getDate("data"), res.getString("nonsocio"), res.getString("sala")));
			}

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return affittuari;
	}

	public ArrayList<Socio> affituariSoci(Sala s) {
		ArrayList<Socio> affittuariS = new ArrayList<Socio>();
		db.open();
		PreparedStatement stm;
		String query = "SELECT * FROM socio AS sc INNER JOIN affittos AS a ON sc.cf = a.socio"
				+ " INNER JOIN sala AS s A a.sala = s.nome WHERE s.nome = ? && a.data>CURDATE();";
		try {
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, s.getNome());
			ResultSet res = stm.executeQuery(query);
			while (res.next()) {
				Socio sc = new Socio(res.getString("cf"), res.getString("nome"), res.getString("cognome"),
						res.getString("sesso").charAt(0), res.getDate("data_nascita"), res.getString("luogo_nascita"),
						res.getString("indirizzo"), res.getString("citta"), res.getString("cap"),
						res.getString("email"), res.getString("telefono"), res.getString("professione"),
						res.getString("stato_civile"), res.getString("coniuge"), res.getDate("data_ammissione"),
						res.getFloat("tassa_ammissione"), res.getString("mod_pagamento"),
						res.getString("met_pagamento"), res.getString("tipologia"));
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
				+ " INNER JOIN sala AS s a.sala = s.nome WHERE s.nome = ? && a.data>CURDATE();";
		try {
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, s.getNome());
			ResultSet res = stm.executeQuery(query);
			while (res.next()) {
				NonSocio ns = new NonSocio(res.getString("cf"), res.getString("nome"), res.getString("cognome"),
						res.getString("sesso").charAt(0), res.getString("email"), res.getString("telefono"));
				affittuariNS.add(ns);
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return affittuariNS;
	}

}
