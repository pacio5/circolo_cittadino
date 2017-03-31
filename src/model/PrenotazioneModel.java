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
 * @author eliapacioni
 * @author smerilliriccardo
 * @author francescotalento
 * @version 1.0 marzo 2017
 */
/**
 *classe che gestisce tutte le interazioni tra model e base di dati riguardanti le prenotazioni di sale ed eventi.
 *sono implementati: metodi di inserimento modifica e cancellazione di sale ed eventi, metodi di inserimento di prenotazioni 
 *di eventi e sale da parte di soci e non soci, metodi per la cancellazione delle prenotazioni gia' effettuati 
 */


public class PrenotazioneModel {

	MySql db = null;
	
	/** Costruttore del model della prenotazione
	 * @return oggetto di tipo PrenotazioneModel
	 * @throws non definito
	 */
	public PrenotazioneModel() {
		db = new MySql();
	}

	/** Operazioni sugli Eventi :
	* metodo che inserisce i dati realativi ad un evento 'e' all'interno della tabella evento del database
	* @param e evento da inserire
	* @return valore booleano in base all'esito dell'inserimento
	*/
	public boolean insertEvento(Evento e) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "INSERT INTO Evento (NOME, DATA, DESCRIZIONE, N_POSTI, LUOGO, PREZZO)" + " VALUES(?,?,?,?,?,?);";
		try {
			/* parametrizzo la query di inserimento passando il valore dei parametri allo statement*/
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, e.getNome());
			stm.setDate(2, e.getData());
			stm.setString(3, e.getDescrizione());
			stm.setInt(4, e.getPosti());
			stm.setString(5, e.getLuogo());
			stm.setFloat(6, e.getPrezzo());

			if (stm.executeUpdate() == 1) 
				//se la query di inserimento ha avuto successo il valore ritornato è pari a 1
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
	
	/** metodo che modifica i dati relativi ad un evento all'interno della tabella evento del database
	 * @param e evento contente i dati nuovi da inserire
	 * @param idvecchio id del vecchio evento da aggiornare
	 * @return  valore booleano in base all'esito dell'aggiornamento
	*/
	public boolean updateEvento(Evento e, int idvecchio) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "UPDATE Evento SET NOME = ?, DATA = ?, DESCRIZIONE = ?, N_POSTI = ?, LUOGO = ?, PREZZO = ?"
				+ " WHERE ID = ?";
		try {
			/* parametrizzo la query di modiica passando il valore dei parametri allo statement*/
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
				//se la query di inserimento ha avuto successo il valore ritornato è pari a 1
				esito = true;
			stm.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			db.close();
		}
		return esito;
	}
	
	/** metodo che cancella i dati relativi ad un evento all'interno della tabella evento del database
	 * @param id contente l'id dell'evento da cancellare
	 * @return valore booleano in base all'esito della cancellaizone
	*/
	public boolean deleteEvento(String id) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "DELETE FROM Evento WHERE ID = ?";
		try {
			/* parametrizzo la query di cancellazione passando il valore dell'id dell'evento allo statement*/
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, id);

			int res = stm.executeUpdate();
			if (res == 1)
				//se la query di inserimento ha avuto successo il valore ritornato è pari a 1
				esito = true;
			stm.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			db.close();
		}
		return esito;
	}
	
	/** metodo che restituisce tutti gli eventi organizzati dal circolo
	 * @return oggetto di tipo ArrayList<Evento> contenente gli eventi organizzati
	*/
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
				/*finchè ci sono eventi nel resultset creo un nuovo evento e lo aggiungo alla lista*/
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return Eventi;
	}

	/** metodo che restituisce tutti gli eventi ancora in programma 
	 * @return oggetto di tipo ArrayList<Evento> contenente gli eventi organizzati ancora in programma
	*/
	public ArrayList<Evento> listaEventiValidi() {
		ArrayList<Evento> Eventi = new ArrayList<Evento>();
		db.open();
		Statement stm;
		String query = "SELECT * FROM evento WHERE data>=CURDATE()"; //interessano solo gli eventi con data successiva o uguale alla odierna
		try {
			stm = db.getConn().createStatement();
			ResultSet res = stm.executeQuery(query);
			while (res.next()) {
				Evento e = new Evento(res.getString("id"), res.getString("nome"), res.getDate("data"),
						res.getString("descrizione"), res.getInt("n_posti"), res.getString("luogo"),
						res.getFloat("prezzo"));
				Eventi.add(e);
				/*finchè ci sono eventi nel resultset creo un nuovo evento e lo aggiungo alla lista*/
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return Eventi;
	}

	/** metodo che restituisce il numero di posti disponibili ad uno specifico evento
	 * @param e evento del quale si desidera conoscere il numero di posti
	 * @return numero intero equivalente al numero di posti ancora disponibili per un evento
	*/
	public int postiDisponibili(Evento e) {
		db.open();
		int po = 0;
		PreparedStatement stm = null;
		try {
			/* calcolo del numero dei posti occupati dai non soci*/
			String query = "SELECT SUM(n_biglietti) AS n FROM prenotazionen WHERE evento = ?;";
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, e.getId());
			ResultSet res = stm.executeQuery();
			res.next();
			po = res.getInt("n");
			/* calcolo del numero dei posti occupati dai soci*/
			query = "SELECT SUM(n_biglietti) AS n FROM prenotaziones WHERE evento = ?;";
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, e.getId());
			res = stm.executeQuery();
			res.next();
			po += res.getInt("n"); //numero di posti occupati relativi all evento e

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			db.close();
		}
		return e.getPosti() - po; //numero di psoti disponibili
	}

	/** Operazioni sulle Prenotazioni degli Eventi:
	 * metodo che inserisce i dati realativi ad un prenotazione di un non socio 'ns' ad un evento 'e'
	 * all'interno della tabella prenotazionen del database
	 * @param ns non socio che prenota l'evento
	 * @param NumB numero di biglietti prenotati
	 * @param e evento per il quale si deisdera prenotare i biglietti
	 * @param dataAcq data di acuqisto dei biglietti
	 * @return valore booleano in base all'esito dell'inserimento
	*/
	public boolean insertPrenotazioneN(NonSocio ns, int NumB, Evento e, Date dataAcq) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "INSERT INTO PrenotazioneN (N_BIGLIETTI, DATA_ACQUISTO, NONSOCIO, EVENTO) " + "VALUES(?,?,?,?)";
		try {
			/* parametrizzo la query di inserimento passando il valore dei parametri allo statement*/
			stm = db.getConn().prepareStatement(query);
			stm.setInt(1, NumB);
			stm.setDate(2, dataAcq);
			stm.setString(3, ns.getCf());
			stm.setString(4, e.getId());

			int res = stm.executeUpdate();
			if (res == 1)
				//se la query di inserimento ha avuto successo il valore ritornato è pari a 1
				esito = true;
			stm.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			db.close();
		}
		return esito;
	}

	/** metodo che inserisce i dati realativi ad un prenotazione di un socio 's' ad un evento 'e'
	 * all'interno della tabella prenotaziones del database
	 * @param s socio che prenota l'evento
	 * @param NumB numero di biglietti prenotati
	 * @param e evento per il quale si deisdera prenotare i biglietti
	 * @param dataAcq data di acuqisto dei biglietti
	 * @return valore booleano in base all'esito dell'inserimento
	*/
	public boolean insertPrenotazioneS(Socio s, int NumB, Evento e, Date dataAcq) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "INSERT INTO PrenotazioneS (N_BIGLIETTI, DATA_ACQUISTO, SOCIO, EVENTO) " + "VALUES(?,?,?,?)";
		try {
			/* parametrizzo la query di inserimento passando il valore dei parametri allo statement*/
			stm = db.getConn().prepareStatement(query);
			stm.setInt(1, NumB);
			stm.setDate(2, dataAcq);
			stm.setString(3, s.getCf());
			stm.setString(4, e.getId());

			int res = stm.executeUpdate();
			if (res == 1)
				//se la query di inserimento ha avuto successo il valore ritornato è pari a 1
				esito = true;
			stm.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			db.close();
		}
		return esito;
	}

	/** metodo che elimina i dati realativi ad un prenotazione 'p' all'interno della tabella prenotazionen del database se è una prenotazione
	 * relativa ad un non socio o all'interno della tabella prenotaziones del database se è una prenotazione relativa ad un socio
	 * @param p prenotazione che si desidera eliminare
	 * @return valore booleano in base all'esito della cancellazione
	*/
	public boolean deletePrenotazione(Prenotazione p) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		try {
			String query = "DELETE FROM PrenotazioneN WHERE NONSOCIO = ? && EVENTO = ? && DATA_ACQUISTO = ? && N_BIGLIETTI = ?";
			/* parametrizzo la query di eliminazione passando il valore dei parametri allo statement*/
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, p.getCf());
			stm.setInt(2, p.getEvento());
			stm.setDate(3, p.getDataAcquisto());
			stm.setInt(4, p.getNumBiglietti());
			stm.executeUpdate();
			
			query = "DELETE FROM PrenotazioneS WHERE SOCIO = ? && EVENTO = ? && DATA_ACQUISTO = ? && N_BIGLIETTI = ?";
			/* parametrizzo la query di inserimento passando il valore dei parametri allo statement*/
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, p.getCf());
			stm.setInt(2, p.getEvento());
			stm.setDate(3, p.getDataAcquisto());
			stm.setInt(4, p.getNumBiglietti());
			stm.executeUpdate();
			esito = true;
			stm.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			db.close();
		}
		return esito;
	}
	
	/**  metodo che restituisce tutte le prenotazioni relative ad un id evento
	 * @param idEvento id dell'evento di cui si desidera conoscere tutte le prenotazioni effettuate
	 * @return oggetto di tipo ArrayList<Prenotazione> contenente le prenotazioni effettuate
	*/
	public ArrayList<Prenotazione> listaPrenotazioni(String idEvento) {
		ArrayList<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
		db.open();
		try {
			ResultSet res = null;
			if (idEvento != null) {
				String query = "(SELECT * FROM prenotazionen WHERE evento = ?) UNION (SELECT * FROM prenotaziones WHERE evento = ?);";
				/* parametrizzo la query passando il valore dei parametri allo statement */
				PreparedStatement stm = db.getConn().prepareStatement(query);
				stm.setInt(1, Integer.valueOf(idEvento));
				stm.setInt(2, Integer.valueOf(idEvento));
				res = stm.executeQuery();
			} else {
				String query = "(SELECT * FROM prenotazionen) UNION (SELECT * FROM prenotaziones );";
				Statement stm = db.getConn().createStatement();
				res = stm.executeQuery(query);
			}
			while (res.next()) {
				prenotazioni.add(new Prenotazione(res.getDate("data_acquisto"), res.getString("nonsocio"),
						res.getInt("evento"), res.getInt("n_biglietti")));
				/*finchè ci sono prenotazioni nel resultset creo una nuova prenotazione e la aggiungo alla lista*/
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return prenotazioni;
	}

	/** Operazioni sui Partecipanti agli Eventi:
	*   metodo che ritorna tutta la lista dei soci partecipanti ad un determinato evento 'e' 
	*   @param e evento di cui si desidera la lista di soci partecipanti
	*   @return oggetto di tipo ArrayList<Socio> contenente tutti i soci partecipanti all'evento deisderato
	*/
	public ArrayList<Socio> partecipantiSoci(Evento e) {
		ArrayList<Socio> partecipantiS = new ArrayList<Socio>();
		db.open();
		PreparedStatement stm;
		String query = "SELECT * FROM socio AS s INNER JOIN prenotaziones AS p ON s.cf = p.socio"
				+ " INNER JOIN evento AS e p.evento = e.id WHERE e.id = ?;";
		try {
			/* parametrizzo la query passando il valore dei parametri allo statement */
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, e.getId());
			ResultSet res = stm.executeQuery();
			while (res.next()) {
				Socio s = new Socio(res.getString("cf"), res.getString("nome"), res.getString("cognome"),
						res.getString("sesso").charAt(0), res.getDate("data_nascita"), res.getString("luogo_nascita"),
						res.getString("indirizzo"), res.getString("citta"), res.getString("cap"),
						res.getString("email"), res.getString("telefono"), res.getString("professione"),
						res.getString("stato_civile"), res.getString("coniuge"), res.getDate("data_ammissione"),
						res.getFloat("tassa_ammissione"), res.getString("mod_pagamento"),
						res.getString("met_pagamento"), res.getString("tipologia"));
				partecipantiS.add(s);
				/*finchè ci sono soci nel resultset creo un nuovo socio e lo aggiungo alla lista*/
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return partecipantiS;
	}

	/** metodo che ritorna tutta la lista dei non soci partecipanti ad un determinato evento 'e' 
	 * @param e evento di cui si desidera la lista di non soci partecipanti
	 * @return oggetto di tipo ArrayList<NonSocio> contenente tutti i non soci partecipanti all'evento deisderato
	*/
	public ArrayList<NonSocio> partecipantiNonSoci(Evento e) {
		ArrayList<NonSocio> partecipantiNS = new ArrayList<NonSocio>();
		db.open();
		PreparedStatement stm;
		String query = "SELECT * FROM nonsocio AS ns INNER JOIN prenotazionen AS p ON ns.cf = p.nonsocio"
				+ " INNER JOIN evento AS e p.evento = e.id WHERE e.id = ?;";
		try {
			/* parametrizzo la query passando il valore dei parametri allo statement */
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, e.getId());
			ResultSet res = stm.executeQuery();
			while (res.next()) {
				NonSocio ns = new NonSocio(res.getString("cf"), res.getString("nome"), res.getString("cognome"),
						res.getString("sesso").charAt(0), res.getString("email"), res.getString("telefono"));
				partecipantiNS.add(ns);
				/*finchè ci sono non soci nel resultset creo un nuovo non socio e lo aggiungo alla lista*/
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return partecipantiNS;
	}

	/** Operazioni Sale:
	 * metodo che inserisce i dati realativi ad una sala 's' all'interno della tabella sala del database
	 * @param s contiene la sala da inserire nel database
	 * @return valore booleano in base all'esito dell'inserimeto
	*/
	public boolean insertSala(Sala s) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "INSERT INTO Sala (NOME, CAPIENZA, DESCRIZIONE, TARIFFA)" + " VALUES(?,?,?,?)";
		try {
			/* parametrizzo la query di inserimento passando il valore dei parametri allo statement */
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, s.getNome());
			stm.setInt(2, s.getCapienza());
			stm.setString(3, s.getDescrizione());
			stm.setDouble(4, s.getTariffa());

			int res = stm.executeUpdate();
			if (res == 1)
				//se la query di inserimento ha avuto successo il valore ritornato è pari a 1
				esito = true;
			stm.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			db.close();
		}
		return esito;
	}

	/** metodo che inserisce i dati realativi ad una sala 's' all'interno della tabella sala del database 
	 * @param s contiene la sala con i dati aggiornati da inserire nel database
	 * @param nomevs è il nome della della sala prima della modifica
	 * @return valore booleano in base all'esito della modifica
	*/
	public boolean updateSala(Sala s, String nomevs) {
		boolean esito = false;
		db.open();
		PreparedStatement stm = null;
		String query = "UPDATE sala SET nome = ?, capienza = ?, descrizione = ?, tariffa = ? WHERE nome = ?;";
		try {
			/* parametrizzo la query di modifica passando il valore dei parametri allo statement */
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, s.getNome());
			stm.setInt(2, s.getCapienza());
			stm.setString(3, s.getDescrizione());
			stm.setFloat(4, s.getTariffa());
			stm.setString(5, nomevs);

			if (stm.executeUpdate() == 1)
				//se la query di modifica ha avuto successo il valore ritornato è pari a 1
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
	
	/** metodo che elimina i dati relativi ad una sala all'interno della tabella sala del database
	 * @param nome nome della sala da eliminare
	 * @return valore booleano in base all'esito della cancellazione
	 */	
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
				//se la query di cancellazione ha avuto successo il valore ritornato è pari a 1
				esito = true;
			stm.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			db.close();
		}
		return esito;
	}

	/** metodo che ritorna la lista di tutte le sale del circolo
	 * @return  oggetto di tipo ArrayList<Sala> contenente le sale
	 */
	public ArrayList<Sala> listaSale() {
		ArrayList<Sala> sale = new ArrayList<Sala>();
		Statement stm;
		try {
			db.open();
			String query = "SELECT * FROM Sala;";
			stm = db.getConn().createStatement();
			ResultSet res = stm.executeQuery(query);
			while (res.next()) {
				sale.add(new Sala(res.getString("nome"), res.getInt("capienza"), res.getString("descrizione"), res.getFloat("tariffa")));
				/*finchè ci sono sale nel resultset creo una nuova sale e la aggiungo alla lista*/
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return sale;
	}

	/** metodo che ritorna la lista delle sale non occupate in data: 'data'
	 * @param data data di prenotazione di una sala
	 * @return oggetto di tipo ArrayList<Sala> contenente le sale libere
	 */
	public ArrayList<Sala> listaSaleDisponibili(Date data) {
		ArrayList<Sala> sale = new ArrayList<Sala>();
		PreparedStatement stm = null;
		String query = "SELECT * FROM sala WHERE sala.nome NOT IN (SELECT affitton.sala FROM affitton WHERE DATEDIFF(affitton.data, ?) = 0 ) "
				+ "AND sala.nome NOT IN (SELECT affittos.sala FROM affittos WHERE DATEDIFF(affittos.data, ?) = 0 );";
				//la differenza tra le due date(affittos.data, data) in entrambi i casi deve essere uguale a 0 
				//poichè si vogliono selezionare solo date uguali		
		try {
			db.open();
			stm = db.getConn().prepareStatement(query);
			stm.setDate(1, data);
			stm.setDate(2, data);
			ResultSet res = stm.executeQuery();
			while (res.next()) {
				sale.add(new Sala(res.getString("nome"), res.getInt("capienza"), res.getString("descrizione"),
						res.getFloat("tariffa")));
				/*finchè ci sono sale nel resultset creo una nuova sale e la aggiungo alla lista*/
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return sale;
	}

	/** Operazioni sull'affitto delle sale:
	 * metodo che inserisce i dati realativi all'affitto di una sala da parte di un non socio 
	 * all'interno della tabella affitton del database
	 * @param ns non socio che affitta la sala
	 * @param s sala da affittare
	 * @param dataAft data in cui la sala sarà affittata
	 * @return valore booleano in base all'esito dell'inserimento
	 */
	public boolean insertAffittoN(NonSocio ns, Sala s, Date dataAft) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "INSERT INTO AFFITTON (DATA, NONSOCIO, SALA) " + "VALUES(?,?,?)";
		try {
			/* parametrizzo la query di inserimento passando il valore dei parametri allo statement */
			stm = db.getConn().prepareStatement(query);
			stm.setDate(1, dataAft);
			stm.setString(2, ns.getCf());
			stm.setString(3, s.getNome());

			int res = stm.executeUpdate();
			if (res == 1)
				//se la query di inserimento ha avuto successo il valore ritornato è pari a 1
				esito = true;
			stm.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			db.close();
		}
		return esito;
	}

	/** metodo che inserisce i dati realativi all'affitto di una sala da parte di un socio all'interno della tabella affittos del database
	 * @param sc socio che affitt la sala
	 * @param s sala da affittare
	 * @param data in cui la sala sarà affittata
	 * @return valore booleano in base all'esito dell'inserimento
	 */
	public boolean insertAffittoS(Socio sc, Sala s, Date dataAft) {
		db.open();
		PreparedStatement stm = null;
		boolean esito = false;
		String query = "INSERT INTO AFFITTOS (DATA, SOCIO, SALA) " + "VALUES(?,?,?)";
		try {
			/* parametrizzo la query di inserimento passando il valore dei parametri allo statement */
			stm = db.getConn().prepareStatement(query);
			stm.setDate(1, dataAft);
			stm.setString(2, sc.getCf());
			stm.setString(3, s.getNome());

			int res = stm.executeUpdate();
			if (res == 1)
				//se la query di inserimento ha avuto successo il valore ritornato è pari a 1
				esito = true;
			stm.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			db.close();
		}
		return esito;
	}

	/** metodo che elimina i dati realativi all'affitto di una sala all'interno della tabella affittos o della tabella affitton
	 * a seconda che la sala sia stata affittata da un socio o da un non socio
	 * @param a affitto di una sala
	 * @return valore booleano in base all'esito della cancellazione
	 */
	public boolean deleteAffitto(Affitto a) {
		db.open();
		PreparedStatement stm = null;
		PreparedStatement stm2 = null;
		boolean esito = false;
		String query = "DELETE FROM affitton WHERE NONSOCIO = ? && EVENTO = ? && DATA = ?";
		String query2 = "DELETE FROM affittos WHERE SOCIO = ? && EVENTO = ? && DATA = ?";
		try {
			/* parametrizzo la prima query di cancellazione passando il valore dei parametri allo statement */
			stm = db.getConn().prepareStatement(query);
			stm.setString(1, a.getCf());
			stm.setString(2, a.getSala());
			stm.setDate(3, a.getData());
			/* parametrizzo la seconda query di cancellazione passando il valore dei parametri allo statement */
			stm2 = db.getConn().prepareStatement(query2);
			stm2.setString(1, a.getCf());
			stm2.setString(2, a.getSala());
			stm2.setDate(3, a.getData());

			int res = stm.executeUpdate();
			int res2 = stm2.executeUpdate();
			if (res == 1 || res2 == 1)
				//se una delle due query di cancellazione ha avuto successo il valore ritornato è pari a 1
				esito = true;
			stm.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			db.close();
		}
		return esito;
	}

	/** metodo che ritorna la lista di tutti gli affitti eseguiti
	 * @return oggetto di tipo ArrayList<Affitto> contenente gli affitti delle sale
	 */
	public ArrayList<Affitto> affittuari() {
		ArrayList<Affitto> affittuari = new ArrayList<Affitto>();
		db.open();
		Statement stm;
		String query = "SELECT * FROM affittos WHERE DATEDIFF(affittos.data, CURDATE()) >= 0;"; //recupera tutti gli affitti successivi alla data odierna
		try {
			stm = db.getConn().createStatement();
			ResultSet res = stm.executeQuery(query);
			while (res.next()) {
				affittuari.add(new Affitto(res.getDate("data"), res.getString("socio"), res.getString("sala")));
				//*finchè ci sono affitti nel resultset creo un nuovo affitto e lo aggiungo alla lista*/
			}
			query = "SELECT * FROM affitton WHERE DATEDIFF(affitton.data, CURDATE()) >= 0;"; //recupera tutti gli affitti successivi alla data odierna
			res = stm.executeQuery(query);
			while (res.next()) {
				affittuari.add(new Affitto(res.getDate("data"), res.getString("nonsocio"), res.getString("sala")));
				/*finchè ci sono affitti nel resultset creo un nuovo affitto e lo aggiungo alla lista*/
			}

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return affittuari;
	}
	
}
