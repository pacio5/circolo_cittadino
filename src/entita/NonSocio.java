/**
 * 
 */
package entita;

/**
 * @author eliapacioni
 *
 */

import java.sql.Date;

public class NonSocio {
	protected String cf;
	protected String nome;
	protected String cognome;
	protected char sesso;
	protected Date dataNascita;
	protected String indirizzo;
	protected String citta;
	protected String cap;
	protected String email;
	protected String telefono;
	
	public NonSocio() {
		this(null, null, null, ' ', null, null);
	}
	
	public NonSocio(String codice, String name, String surname, char sex, String mail, String tel) {
		cf = codice;
		nome = name;
		cognome = surname;
		sesso = sex;
		email = mail;
		telefono = tel;
	}

	public String getCf() {
		return cf;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public char getSesso() {
		return sesso;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setCf(String codice) {
		cf = codice;
	}

	public void setNome(String name) {
		nome = name;
	}

	public void setCognome(String surname) {
		cognome = surname;
	}

	public void setSesso(char sex) {
		sesso = sex;
	}

	public void setDataNascita(Date dateB) {
		dataNascita = dateB;
	}

	public void setIndirizzo(String address) {
		indirizzo = address;
	}

	public void setCitta(String city) {
		citta = city;
	}

	public void setCap(String postalCode) {
		cap = postalCode;
	}

	public void setEmail(String mail) {
		email = mail;
	}

	public void setTelefono(String tel) {
		telefono = tel;
	}

	@Override
	public String toString() {
		return nome + " " + cognome + ", codice fiscale: " + cf;
	}

}

