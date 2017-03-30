package entita;

import java.sql.Date;

/**
 * @author simoneonori
 * @author eliapacioni
 * @author riccardosmerilli
 * @author francescotalento
 * @version 1.0 Marzo 2017 
 * 
 * Classe che si occupa di mappare l'entità socio contenuta nel database
 */
public class Socio {
	protected String cf;
	protected String nome;
	protected String cognome;
	protected char sesso;
	protected Date dataNascita;
	protected String luogoNascita;
	protected String indirizzo;
	protected String citta;
	protected String cap;
	protected String email;
	protected String telefono;
	protected String professione;
	protected String statoCivile;
	protected String coniuge;
	protected Date dataAmmissione;
	protected float tassaAmmissione;
	protected String modPagamento;
	protected String metPagamento;
	protected String tipologia;

	/**
	 * Costruttore parametrico del socio, inizializza tutte le proprietà con i valori passati
	 * @param codice, codice fiscale del socio
	 * @param name, nome del socio
	 * @param surname, cognome del socio
	 * @param sex, sesso del socio
	 * @param dateB, data di compleanno del socio
	 * @param placeB, luogo di nascita del socio
	 * @param address, indirizzo del socio
	 * @param city, città di residenza del socio
	 * @param postalCode, cap del socio
	 * @param mail, indirizzo email del socio
	 * @param tel, numero di telefono del socio
	 * @param profession, professione del socio
	 * @param civilStatus, stato civile del socio
	 * @param spouse, eventuale nome del coniuge
	 * @param dateAmmission, data di ammissione al circolo
	 * @param taxAmmission, tassa di ammissione
	 * @param modPay, modalità di pagamento scelta
	 * @param metPay, metodo di pagamento scelto
	 * @param type, tipologia del socio
	 */
	public Socio(String codice, String name, String surname, char sex, Date dateB, String placeB, String address,
			String city, String postalCode, String mail, String tel, String profession, String civilStatus,
			String spouse, Date dateAmmission, float taxAmmission, String modPay, String metPay, String type) {
		cf = codice;
		nome = name;
		cognome = surname;
		sesso = sex;
		dataNascita = dateB;
		luogoNascita = placeB;
		indirizzo = address;
		citta = city;
		cap = postalCode;
		email = mail;
		telefono = tel;
		professione = profession;
		statoCivile = civilStatus;
		coniuge = spouse;
		dataAmmissione = dateAmmission;
		tassaAmmissione = taxAmmission;
		modPagamento = modPay;
		metPagamento = metPay;
		tipologia = type;
	}

	/**
	 * Costruttore del socio senza parametri
	 * 
	 */
	public Socio() {
		this(null, null, null, ' ', null, null, null, null, null, null, null, null, null, null, null, 0, null, null,
				null);
	}

	/**
	 * 
	 * @return codice fiscale del socio (String)
	 */
	public String getCf() {
		return cf;
	}

	/**
	 * 
	 * @return nome del socio (String)
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * @return cognome del socio (String)
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * 
	 * @return sesso del socio (char)
	 */
	public char getSesso() {
		return sesso;
	}

	/**
	 * 
	 * @return data di nascita del socio (Date)
	 */
	public Date getDataNascita() {
		return dataNascita;
	}

	/**
	 * 
	 * @return luogo di nascita del socio (String)
	 */
	public String getLuogoNascita() {
		return luogoNascita;
	}

	/**
	 * 
	 * @return indirizzo del socio (String)
	 */
	public String getIndirizzo() {
		return indirizzo;
	}
	
	/**
	 * 
	 * @return città di residenza del socio (String)
	 */
	public String getCitta() {
		return citta;
	}

	/**
	 * 
	 * @return cap del socio (String)
	 */
	public String getCap() {
		return cap;
	}

	/**
	 * 
	 * @return indirizzo email del socio (String)
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @return numero di telefono del socio (String)
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * 
	 * @return professione del socio (String)
	 */
	public String getProfessione() {
		return professione;
	}
	
	/**
	 * @return statoCivile (String)
	 */
	public String getStatoCivile() {
		return statoCivile;
	}
	
	/**
	 * 
	 * @return nome del coniuge (String)
	 */
	public String getConiuge() {
		return coniuge;
	}

	/**
	 * 
	 * @return data ammissione al circolo (Date)
	 */
	public Date getDataAmmissione() {
		return dataAmmissione;
	}

	/**
	 * 
	 * @return tassa ammissione al circolo (float)
	 */
	public float getTassaAmmissione() {
		return tassaAmmissione;
	}
	
	/**
	 * 
	 * @return modalità di pagamento scelta dal socio (String)
	 */
	public String getModPagamento() {
		return modPagamento;
	}

	/**
	 * 
	 * @return metodo di pagamento scelto dal socio (String)
	 */
	public String getMetPagamento() {
		return metPagamento;
	}

	/**
	 * 
	 * @return tipologia del socio (String)
	 */
	public String getTipologia() {
		return tipologia;
	}
	
	/**
	 * Override del metodo toString()
	 * @return stringa contente i dati del socio
	 */
	@Override
	public String toString() {
		return nome + " " + cognome + " "+ cf;
	}
}