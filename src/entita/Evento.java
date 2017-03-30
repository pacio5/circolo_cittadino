/**
 * 
 */
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
 * classe che si occupa di mappare l'entità evento contenuta nel databese
 */
public class Evento {
	private String id;
	private String nome;
	private Date data;
	private String descrizione;
	private int posti;
	private String luogo;
	private float prezzo;
	
	/**
	 * Costruttore della prenotazione senza parametri
	 */
	public Evento(){
		this(null, null, null, null, 0, null, 0);
	}
	
	/**
	 * costruttore parametrico inizializza tutte le proprietà con i parametri passati
	 * @param identification id dell'evento
	 * @param name nome dell'evento
	 * @param date data dell'evento
	 * @param description breve descrizione dell'evento
	 * @param seats numero di posti dell'evento
	 * @param location via o luogo dove si svolgerà l'evento
	 * @param price prezzo del biglietto dell'evento
	 */
	public Evento(String identification, String name, Date date, String description, int seats, String location, float price){ 
		id = identification;
		nome = name;
		data = date;
		descrizione = description;
		posti = seats;
		luogo = location;
		prezzo = price;		
	}
	
	public Evento(String name, Date date, String description, int seats, String location, float price){
		nome = name;
		data = date;
		descrizione = description;
		posti = seats;
		luogo = location;
		prezzo = price;		
	}
	
	/**
	 * @return nome contenente il nome dell'evento
	 */
	public String getNome() {
		return nome;
	}
	public void setNome(String name) {
		nome = name;
	}
	
	/**
	 * @return data contenente la data dell'evento
	 */
	public Date getData() {
		return data;
	}
	
	public void setData(Date dataE) {
		data = dataE;
	}
	
	/**
	 * @return descrizione contenente una breve descrizione dell'evento
	 */
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String desc) {
		descrizione = desc;
	}
	
	/**
	 * @return posti contenente il numero di posti dell'evento
	 */
	public int getPosti() {
		return posti;
	}
	
	public void setPosti(int numero) {
		this.posti = numero;
	}
	
	/**
	 * @return luogo contenente la via o il luogo dell'evento
	 */
	public String getLuogo() {
		return luogo;
	}
	
	public void setLuogo(String posto) {
		luogo = posto;
	}
	
	/**
	 * @return prezzo contenente il prezzo dell'evento
	 */
	public float getPrezzo() {
		return prezzo;
	}
	
	public void setPrezzo(float costo) {
		prezzo = costo;
	}
	
	/**
	 * @return id contenente l'id dell'evento
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * override del metodo toString
	 * @return una stringa contenente i dati dell'evento
	 */
	@Override
	public String toString() {
		return nome + " " + prezzo;
	}
	
	
	
}
