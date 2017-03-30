package entita;


import java.sql.Date;

/**
 * @author simoneonori
 * @author eliapacioni
 * @author riccardosmerilli
 * @author francescotalento
 * @version 1.0 Marzo 2017 
 * 
 * Classe che si occupa di mappare l'entità nonsocio contenuta nel database
 */
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
	
	/**
	 * Costruttore del socio senza parametri
	 * 
	 */
	public NonSocio() {
		this(null, null, null, ' ', null, null);
	}
	
	/**
	 * 
	 * @param codice
	 * @param name
	 * @param surname
	 * @param sex
	 * @param mail
	 * @param tel
	 */
	public NonSocio(String codice, String name, String surname, char sex, String mail, String tel) {
		cf = codice;
		nome = name;
		cognome = surname;
		sesso = sex;
		email = mail;
		telefono = tel;
	}

	/**
	 * 
	 * @return codice fiscale del nonsocio (String)
	 */
	public String getCf() {
		return cf;
	}

	/**
	 * 
	 * @return nome del nonsocio (String)
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * @return cognome del nonsocio (String)
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * 
	 * @return sesso del nonsocio (char)
	 */
	public char getSesso() {
		return sesso;
	}

	/**
	 * 
	 * @return indirizzo email del nonsocio (String)
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @return numero di telefono del nonsocio (String)
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Override del metodo toString()
	 * @return stringa contente i dati del nonsocio
	 */
	@Override
	public String toString() {
		return nome + " " + cognome + " " + cf;
	}

}

