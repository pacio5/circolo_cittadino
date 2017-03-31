package entita;

import java.sql.Date;

/**
 * @author simoneonori
 * @author eliapacioni
 * @author riccardosmerilli
 * @author francescotalento
 * @version 1.0 Marzo 2017 
 * 
 * Classe che si occupa di mappare l'entità ex-socio contenuta nel database, 
 * estende la classe socio con le proprietà: dataDimissione(Date) e espulso(Boolean)
 */
public class ExSocio extends Socio {
	protected Date dataDimissione;
	protected Boolean espulso;
	
	/**
	 * Costruttore dell'exsocio senza parametri
	 * 
	 */
	public ExSocio() {
		super();
		dataDimissione = null;
		espulso = null;
	}

	/**
	 * Costruttore parametrico dell'exsocio, inizializza tutte le proprietà con i valori passati
	 * @param codice, codice fiscale dell'exsocio
	 * @param name, nome dell'exsocio
	 * @param surname, cognome dell'exsocio
	 * @param sex, sesso dell'exsocio
	 * @param dateB, data di nascita dell'exsocio
	 * @param placeB, luogo di nascita dell'exsocio
	 * @param address, indirizzo dell'exsocio
	 * @param city, città di residenza dell'exsocio
	 * @param postalCode, cap dell'exsocio
	 * @param mail, indrizzo email dell'exsocio
	 * @param tel, numero di telefono dell'exsocio
	 * @param profession, professione dell'exsocio
	 * @param civilStatus, stato civile dell'exsocio
	 * @param spouse, eventuale coniuge
	 * @param dateAmmission, data di ammissione al ciroclo
	 * @param taxAmmission, tassa di ammissione al circolo
	 * @param modPay, modalità di pagamento scelta
	 * @param metPay, metodo di pagamento scelto
	 * @param type, tipologia dell'exsocio
	 * @param dimissionDate, data di dimissione
	 * @param expelled, valore booleano che rappresenta se è stato espulso o no
	 */
	public ExSocio(String codice, String name, String surname, char sex, Date dateB, String placeB, String address,
			String city, String postalCode, String mail, String tel, String profession, String civilStatus,
			String spouse, Date dateAmmission, float taxAmmission, String modPay, String metPay, String type, Date dimissionDate, Boolean expelled) {
		super(codice, name, surname, sex, dateB, placeB, address, city, postalCode, mail, tel, profession, civilStatus,
				spouse, dateAmmission, taxAmmission, modPay, metPay, type);
		dataDimissione = dimissionDate;
		espulso = expelled;
	}
	
	/**
	 * 
	 * @param n socio che deve diventare exsocio
	 * @param dimissionDate
	 * @param expelled
	 */
	public ExSocio(Socio n, Date dimissionDate, Boolean expelled){
		this(n.getCf(), n.getNome(), n.getCognome(), n.getSesso(), n.getDataNascita(), n.luogoNascita, n.getIndirizzo(),
			n.getCitta(), n.getCap(), n.getEmail(), n.getTelefono(), n.getProfessione(), n.getStatoCivile(), n.getConiuge(), n.getDataAmmissione(),
			n.getTassaAmmissione(), n.getModPagamento(), n.getMetPagamento(), n.getTipologia(), dimissionDate, expelled);		
	}
	
	/**
	 * 
	 * @return data di dimissione dal circolo (Date)
	 */
	public Date getDataDimissione() {
		return dataDimissione;
	}

	/**
	 * 
	 * @return valore booleano se il socio è stato o no espulso
	 */
	public Boolean getEspulso() {
		return espulso;
	}

	/**
	 * Override del metodo toString()
	 * @return 
	 */
	@Override
	public String toString() {
		return nome + " " + cognome + " "+ cf;
	}
}
