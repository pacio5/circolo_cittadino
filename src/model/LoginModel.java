/**
 * 
 */
package model;

import utility.MySql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

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
}
