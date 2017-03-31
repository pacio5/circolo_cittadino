package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;

import utility.MySql;
import entita.Versamento;
import entita.Quota;
import entita.Socio;

/**
 * @author simoneonori
 * @author eliapacioni
 * @author riccardosmerilli
 * @author francescotalento
 * 
 * @version 1.0 Marzo 2017
 * 
 * 
 * Classe che si occupa delle interazioni con le entità Quota e Versamento del database 
 */
public class QuotaModel {

	MySql db;

	/** 
	 * Costruttore, il model è costituito da un oggetto MySql 
	 * per stabilire la connessione con il database
	 */
	public QuotaModel() {
		db = new MySql();
	}

	/**
	 * Inserimento di una quota
	 * @param quo quota da inserire
	 * @return true se l'operazione ha successo, altrimenti false
	 */
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

	/**
	 * Aggiornamento di una quota
	 * @param quo quota da aggiornare
	 * @return true se l'operazione ha successo, altrimenti false
	 */
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

	/**
	 * Elimina di una quota
	 * @param quo quota da eliminare
	 * @return true se l'operazione ha successo, altrimenti false
	 */
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

	/**
	 * Visualizzazione tutte le quote ordinate per data iniziale e tipologia
	 * @return ArrayList contenente tutte le quote presenti
	 */
	public ArrayList<Quota> getQuote() {
		ArrayList<Quota> quote = new ArrayList<Quota>();
		try {
			db.open();
			Statement command = db.getConn().createStatement();
			ResultSet rs = command.executeQuery("SELECT * FROM Quota ORDER BY DATA_INIZIO DESC, TIPOLOGIA DESC");
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

	/**
	 * Visualizzazione dell'ultima quota della tipologia considerata
	 * @param tipo tipologia di socio considerata
	 * @return l'ultima quota caricata
	 */
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

	/**
	 * Calcolo del debito/credito del socio considerato
	 * @param socio socio considerato
	 * @return il valore del debito/credito
	 */
	public float getCreditoDebito(Socio socio) {
		ArrayList<Date> datainizio = new ArrayList<Date>();
		ArrayList<Float> importo = new ArrayList<Float>();
		float creditodebito = 0;
		boolean passaggio = false;
		String operations = "SELECT * FROM Passaggio WHERE YEAR(DATA_PASSAGGIO) = YEAR(curdate()) AND SOCIO = ?";
		String operationq = "SELECT DISTINCT VALORE, DATA_INIZIO FROM Quota WHERE YEAR(DATA_INIZIO) = (YEAR(curdate())-1) AND TIPOLOGIA = ?";
		String operationv = "SELECT SUM(IMPORTO) as IMPORTO FROM Versamento WHERE SOCIO = ? AND (YEAR(DATA) = YEAR(curdate())-1 OR (YEAR(DATA) = YEAR(curdate()) AND DESCRIZIONE = ?))";
		try {
			db.open();
			PreparedStatement command = null;
			command = db.getConn().prepareStatement(operations);
			command.setString(1, socio.getCf());
			ResultSet rss = command.executeQuery();
			/* Controlla se sono presenti passaggi di tipologia */
			if(rss.next())
				passaggio = true;
			command = db.getConn().prepareStatement(operationq);
			if(passaggio)
				command.setString(1, rss.getString("TIPOLOGIA_PRECEDENTE")); // Inserisco tipologia precedente al cambio
			else 
				command.setString(1, socio.getTipologia()); 
			ResultSet rsq = command.executeQuery();
			while (rsq.next()) {
				datainizio.add(rsq.getDate("DATA_INIZIO"));
				importo.add(rsq.getFloat("VALORE"));
			}
			rsq.close();
			/* Caso in cui è presente almeno una quota nell'anno precedente */
			if (!datainizio.isEmpty()) {
				/* Caso in cui è presente una sola quota */
				if (datainizio.size() == 1){
					/* Caso in cui la quota abbia inizio a Gennaio */
					if (datainizio.get(0).toString().substring(5, 7).equals("01")){
						creditodebito += (float) (importo.get(0) * 12);
					} else {
						/* Controllo per il cambio di tipologia */
						if(passaggio)
							creditodebito += (float) (getValoreQuotaPrecedente(rss.getString("TIPOLOGIA_PRECEDENTE"))
									* (Integer.valueOf(datainizio.get(0).toString().substring(5, 7)) - 1));
						else
							creditodebito += (float) (getValoreQuotaPrecedente(socio.getTipologia())
									* (Integer.valueOf(datainizio.get(0).toString().substring(5, 7)) - 1));
						creditodebito += (float) (importo.get(0)
								* (13 - Integer.valueOf(datainizio.get(0).toString().substring(5, 7))));
					}
				} else {
					/* Caso in cui sono presenti più quote */
					for (int i = 0; i < datainizio.size() - 1; i++) {
						/* Caso in cui la prima quota dell'anno non è stata creata a Gennaio */
						if (!datainizio.get(i).toString().substring(5, 7).equals("01") && i == 0) {
							if (passaggio)
								creditodebito += (float) (getValoreQuotaPrecedente(
										rss.getString("TIPOLOGIA_PRECEDENTE"))
										* (Integer.valueOf(datainizio.get(i).toString().substring(5, 7)) - 1));
							else
								creditodebito += (float) (getValoreQuotaPrecedente(socio.getTipologia())
										* (Integer.valueOf(datainizio.get(i).toString().substring(5, 7)) - 1));
						}
						creditodebito += (float) (importo.get(i)
								* (Integer.valueOf(datainizio.get(i + 1).toString().substring(5, 7))
										- Integer.valueOf(datainizio.get(i).toString().substring(5, 7))));
					}
					/* Somma dell'ultima quota dell'anno */
					creditodebito += (importo.get(importo.size()-1)
							* (13 - Integer.valueOf(datainizio.get(importo.size()-1).toString().substring(5, 7))));
				}
				rss.close();
				rsq.close();
				db.open();
				command = null;
				command = db.getConn().prepareStatement(operationv);
				command.setString(1, socio.getCf());
				command.setString(2, "ChiusuraAnnuale"
						+ String.valueOf(Integer.valueOf(Calendar.getInstance().get(Calendar.YEAR)) - 1));
				ResultSet rsv = command.executeQuery();
				if (rsv.next())
					creditodebito = rsv.getFloat("IMPORTO") - creditodebito;
				rsv.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return creditodebito;
	}

	/**
	 * Restituisce il valore della quota valida sia negl'ultimi mesi dei due anni precendenti
	 * e sia nei mesi iniziali dell'anno appena trascorso (rispetto all'anno della chiusura annuale considerata)
	 * @param tipologia
	 * @return importo della quota
	 */
	private float getValoreQuotaPrecedente(String tipologia) {
		float importo = 0;
		String operation = "SELECT VALORE FROM Quota WHERE TIPOLOGIA = ? AND DATA_INIZIO = (SELECT MAX(DATA_INIZIO) FROM Quota WHERE YEAR(DATA_INIZIO) = (YEAR(curdate())-2))";
		try {
			db.open();
			PreparedStatement command = null;
			command = db.getConn().prepareStatement(operation);
			command.setString(1, tipologia);
			ResultSet rs = command.executeQuery();
			if (rs.next())
				importo = rs.getFloat("VALORE");
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return importo;
	}

	/**
	 * Visualizza la lista dei mesi pagati nell'anno attuale
	 * @param cf codice fiscale del socio
	 * @return ArrayList contenente i mesi pagati
	 */
	public ArrayList<String> getMesiPagati(String cf) {
		ArrayList<String> mesipagati = new ArrayList<String>();
		String operation = "SELECT Mese.DATA as Mesi FROM Mese, Versamento WHERE Mese.VERSAMENTO = Versamento.ID AND Versamento.SOCIO = ? AND YEAR(Versamento.DATA) = YEAR(curdate())";
		try {
			db.open();
			PreparedStatement command = null;
			command = db.getConn().prepareStatement(operation);
			command.setString(1, cf);
			ResultSet rs = command.executeQuery();
			while(rs.next())
				mesipagati.add(rs.getString("Mesi"));
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return mesipagati;
	}

	/**
	 * Inserimento di un versamento
	 * @param spill versamento da inserire
	 * @return true se l'operazione ha successo, altrimenti false
	 */
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

	/**
	 * Aggiornamento di un versamento
	 * @param spill versamento da aggiornare
	 * @return true se l'operazione ha successo, altrimenti false
	 */
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

	/**
	 * Eliminazione di un versamento
	 * @param cod codice del versamento da eliminare
	 * @return true se l'operazione ha successo, altrimenti false
	 */
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

	/**
	 * Visualizza tutti i versamenti e i relativi mesi
	 * @return ArrayList di versamenti
	 */
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

	/**
	 * Restituisce il valore della quota valida per il periodo considerato
	 * di un determinato tipo di socio
	 * @param tipo tipologia dei soci
	 * @param data data dell'inizio della quota
	 * @return valore della quota
	 */
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
	
	/**
	 * Inserimento del versamento della chiusura annuale
	 * @param spill versamento della chiusura annuale da inserire
	 * @return true se l'operazione ha successo, altrimenti false
	 */
	public boolean insertChiusuraAnnuale(Versamento spill) {
		boolean esito = false;
		String operationV = "INSERT INTO Versamento (DATA, IMPORTO, DESCRIZIONE, SOCIO) VALUES (?, ?, ?, ?)";
		try {
			db.open();
			PreparedStatement command = null;
			command = db.getConn().prepareStatement(operationV);
			command.setDate(1, spill.getData());
			command.setFloat(2, spill.getImporto());
			command.setString(3, spill.getDescrizione());
			command.setString(4, spill.getSocio());
			command.executeUpdate();
			esito = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close();
		}
		return esito;
	}
}
