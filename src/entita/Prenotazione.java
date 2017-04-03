package entita;

import java.sql.Date;
/**
 * @author simoneonori
 * @author eliapacioni
 * @author smerilliriccardo
 * @author francescotalento
 * @version 1.0 marzo 2017
 */
/**
 * classe che si occupa di mappare l'entità prenotazione contenuta nel databese
 */
public class Prenotazione {
	
	private Date dataAcquisto;
	private String cf;
	private int evento;
	private int nBiglietti;
	private Evento e;
	private NonSocio ns;
	private Socio s;
	
	/**
	 * Costruttore della prenotazione senza parametri
	 */
	public Prenotazione(){
		this(null, null, 0, 0);
	}
	
	/**
	 * costruttore parametrico inizializza tutte le proprietà con i parametri passati
	 * @param date data di acquisto dei biglietti
	 * @param code codice fiscale di chi acquista i biglietti
	 * @param event id dell'evento
	 * @param ticket numero di biglietti acquistati
	 */
	public Prenotazione(Date date, String code, int event, int ticket) {
		dataAcquisto = date;
		cf = code;
		evento = event;
		nBiglietti = ticket;
	}
	
	public Prenotazione(Date date, Socio partner, Evento event, int ticket) {
		dataAcquisto = date;
		s = partner;
		e = event;
		nBiglietti = ticket;
	}
	
	public Prenotazione(Date date, NonSocio notPartner, Evento event, int ticket) {
		dataAcquisto = date;
		ns = notPartner;
		e = event;
		nBiglietti = ticket;
	}
		
	/**
	 * @return dataAcquisto contenente la data di acquisto dei biglietti
	 */
	public Date getDataAcquisto() {
		return dataAcquisto;
	}
	
	public void setData(Date dataA) {
		dataAcquisto = dataA;
	}
	
	/**
	 * @return cf contenente il codice fiscale di chi ha prenotato l'evento
	 */
	public String getCf() {
		return cf;
	}
	
	public void setCf(String codiceFiscale) {
		cf = codiceFiscale;
	}
	
	/**
	 * @return evento contenente l'id dell'evento relativo alla prenotazione
	 */
	public int getEvento() {
		return evento;
	}
	
	public void setEvento(int codiceEvento){
		evento = codiceEvento;
	}
	
	/**
	 * @return nBiglietti contenente il nuemero di biglietti prenotati
	 */
	public int getNumBiglietti() {
		return nBiglietti;
	}
	
	public void setNumBiglietti(int numBiglietti) {
		nBiglietti = numBiglietti;
	}
	
	/**
	 * override del metodo toString
	 * @return una stringa contenente i dati della prenotazione
	 */
	@Override
	public String toString() {
		return  evento + " " + cf + " " + nBiglietti;
	}
		
}
