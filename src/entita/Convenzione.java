package entita;

/**
 * @author simoneonori
 * @author eliapacioni
 * @author riccardosmerilli
 * @author francescotalento
 * @version 1.0 Marzo 2017 
 *
 * Classe che si occupa di mappare l'entità convenzione contenuta nel database
 */
public class Convenzione {
	private int id;
	private String ragioneSociale;
	private String indirizzo;
	private String descrizione;
	private double sconto;
	
	/**
	 * Costruttore del socio senza parametri
	 * 
	 */
	public Convenzione(){
		this(-1, null, null, null, 0);
	}
	
	/**
	 * 
	 * @param ident, identificatore della convenzione
	 * @param azienda, ragione sociale dell'azienda
	 * @param address, indirizzo dell'azienda
	 * @param desc, descrizione dell'azienda
	 * @param percent, percentuale di sconto
	 */
	public Convenzione(int ident, String azienda, String address, String desc, double percent){
		id = ident;
		ragioneSociale = azienda;
		indirizzo = address;
		descrizione = desc;
		sconto = percent;
	}
	
	/**
	 * 
	 * @param azienda, ragione sociale dell'azienda
	 * @param address, indirizzo dell'azienda 
	 * @param desc, descrizione dell'azienda
	 * @param percent, percentuale di sconto
	 */
	public Convenzione(String azienda, String address, String desc, double percent){
		id = -1;
		ragioneSociale = azienda;
		indirizzo = address;
		descrizione = desc;
		sconto = percent;
	}

	/**
	 * 
	 * @return id (int)
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @return ragioneSociale (String)
	 */
	public String getRagioneSociale() {
		return ragioneSociale;
	}

	/**
	 * 
	 * @return indirizzo (String)
	 */
	public String getIndirizzo() {
		return indirizzo;
	}

	/**
	 * 
	 * @return descrizione (String)
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * 
	 * @return sconto (double)
	 */
	public double getSconto() {
		return sconto;
	}
	
	/**
	 * Override del metodo toString()
	 */
	@Override
	public String toString(){
		return ragioneSociale + " " + String.valueOf(sconto);
	}
	
}