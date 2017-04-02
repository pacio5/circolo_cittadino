/**
 * 
 */
package model;

import utility.MySql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 * @author simoneonori
 * @author eliapacioni
 * @author riccardosmerilli
 * @author francescotalento
 * @version 1.0 Marzo 2017 Classe che si occupa del login
 */
public class LoginModel {
	private MySql db;

	/**
	 * Costruttore del SocioModel inizializza l'oggetto MySql
	 */
	public LoginModel() {
		db = new MySql();
	}

	/**
	 * Metodo che si occupa di verificare se l'utente può essere autentica
	 * @param user, username inserito dall'utente per effettuare il login
	 * @param password inserita dall'utente per effettuare il login
	 * @return valore boolean in base all'esito dell'autenticazione
	 */
	public boolean accedi(String user, String password) {
		db.open();
		boolean accesso = false;
		String query = "SELECT * FROM utente WHERE nomeuser=? AND password=?;";
		try {
			PreparedStatement st = db.getConn().prepareStatement(query);
			st.setString(1, user);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if (rs.next())
				accesso = true;
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close();
		}

		return accesso;
	}
	
	public MySql getDb(){
		return db;
	}
}
