package entita;

import java.sql.Date;
import entita.Sala;
import entita.NonSocio;
import entita.Socio;
/**
 * @author simoneonori
 * @author eliapacioni
 * @author smerilliriccardo
 * @author francescotalento
 * @version 1.0 marzo 2017
 */
/**
 * classe che si occupa di mappare l'entità affitto contenuta nel databese
 */
public class Affitto {
	
	private Date data;
	private String cf;
	private String sala;
	private Socio s;
	private Sala sl;
	private NonSocio ns;
	
	/**
	 * Costruttore dell'affitto senza parametri
	 */
	public Affitto(){
		this(null, "", "");
	}
	
	/**
	 * costruttore parametrico inizializza tutte le proprietà con i parametri passati
	 * @param date data di afitto della sala
	 * @param code codice fiscale di chi affitta la sala
	 * @param room nome della sala affittata
	 */
	public Affitto(Date date, String code, String room) {
		data = date;
		cf = code;
		sala = room;
	}
	
	public Affitto(Date date, Socio partner, Sala room) {
		data = date;
		s = partner;
		sl = room;
	}
	
	public Affitto(Date date, NonSocio notPartner, Sala room) {
		data = date;
		ns = notPartner;
		sl = room;
	}
		
	/**
	 * @return data contenente la data di affitto della sala
	 */
	public Date getData() {
		return data;
	}
	
	public void setData(Date dataE) {
		data = dataE;
	}
	
	/**
	 * @return cf contenente il codice fiscale di chi affitta la sala
	 */
	public String getCf() {
		return cf;
	}
	
	public void setCf(String codiceFiscale) {
		cf = codiceFiscale;
	}
	
	/**
	 * @return sala contenente il nome della sala affittata
	 */
	public String getSala() {
		return sala;
	}
	
	public void setSala(String nomeSala){
		sala = nomeSala;
	}
	
	/**
	 * override del metodo toString
	 * @return una stringa contenente i dati dell'affitto
	 */
	@Override
	public String toString() {
		return sala + " " + data + " " + cf;
	}
	
	
	
}
