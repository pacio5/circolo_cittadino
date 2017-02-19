/**
 * 
 */
package model;

import utility.MySql;
import java.sql.*;

/**
 * @author eliapacioni
 *
 */
public class LoginModel {
		private MySql db;
	public LoginModel() {
		db = new MySql();
	}

	public boolean accedi(String user, String password) {
		db.open();
		boolean accesso = false;
		try {
			Statement st = db.getConn().createStatement();
			String query = "SELECT * FROM utente WHERE nomeUtente='" + user + "' AND password='" + password + "';";
			ResultSet rs = st.executeQuery(query);
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
}
