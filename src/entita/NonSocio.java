/**
 * 
 */
package entita;

/**
 * @author eliapacioni
 *
 */

import java.time.LocalDate;

public class NonSocio {
	protected String cf;
	protected String nome;
	protected String cognome;
	protected char sesso;
	protected LocalDate dataNascita;
	protected String indirizzo;
	protected String citta;
	protected String cap;
	protected String email;
	protected String telefono;

	public NonSocio(String codice, String name, String surname, char sex, LocalDate dateB, String address, String city,
			String postalCode, String mail, String tel) {
		cf = codice;
		nome = name;
		cognome = surname;
		sesso = sex;
		dataNascita = dateB;
		indirizzo = address;
		citta = city;
		cap = postalCode;
		email = mail;
		telefono = tel;
	}

	public NonSocio() {
		this(null, null, null, ' ', null, null, null, null, null, null);
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

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public String getCap() {
		return cap;
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

	public void setDataNascita(LocalDate dateB) {
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

	public String toString() {
		return "Il cliente: " + nome + " " + cognome + ", codice fiscale: " + cf;
	}

}

