/**
 * 
 */
package entita;

import java.sql.Date;

/**
 * @author eliapacioni
 *
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

	public Socio() {
		this(null, null, null, ' ', null, null, null, null, null, null, null, null, null, null, null, 0, null, null,
				null);
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

	public Date getDataNascita() {
		return dataNascita;
	}

	public String getLuogoNascita() {
		return luogoNascita;
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

	public String getProfessione() {
		return professione;
	}
	/**
	 * @return the statoCivile
	 */
	public String getStatoCivile() {
		return statoCivile;
	}
	public String getConiuge() {
		return coniuge;
	}

	public Date getDataAmmissione() {
		return dataAmmissione;
	}

	public float getTassaAmmissione() {
		return tassaAmmissione;
	}

	public String getModPagamento() {
		return modPagamento;
	}

	public String getMetPagamento() {
		return metPagamento;
	}

	public String getTipologia() {
		return tipologia;
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

	public void setLuogoNascita(String placeB) {
		luogoNascita = placeB;
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

	public void setProfessione(String profession) {
		professione = profession;
	}

	public void setStatoCivile(String civilState) {
		statoCivile = civilState;
	}

	public void setConiuge(String spouse) {
		coniuge = spouse;
	}

	public void setDataAmmissione(Date dateA) {
		dataAmmissione = dateA;
	}

	public void setTassaAmmissione(float taxA) {
		tassaAmmissione = taxA;
	}

	public void setModPagamento(String modPay) {
		modPagamento = modPay;
	}

	public void setTipologia(String type) {
		tipologia = type;
	}
	
	@Override
	public String toString() {
		return nome + " " + cognome + " "+ cf;
	}
	
}