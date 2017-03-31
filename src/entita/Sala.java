package entita;

/**
 * @author simoneonori
 * @author eliapacioni
 * @author smerilliriccardo
 * @author francescotalento
 * @version 1.0 marzo 2017
 */
/**
 * classe che si occupa di mappare l'entità sala contenuta nel databese
 */
public class Sala {
	private String nome;
	private int capienza;
	private String descrizione;
	private float tariffa;
	
	/**
	 * costruttore parametrico inizializza tutte le proprietà con i parametri passati
	 * @param name nome della sala
	 * @param posti numero di posti della sala
	 * @param desc breve descrizione della sala
	 * @param prezzo costo di affitto della sala
	 */
	public Sala(String name, int posti, String desc, float prezzo){
		nome = name;
		capienza = posti;
		descrizione = desc;
		tariffa = prezzo;
	}
	

	/**
	 * Costruttore della sala senza parametri
	 */
	public Sala(){
		this(null,-1, null, 0);
	}
	
	/**
	 * @return nome contenente il nome della sala
	 */
	public String getNome(){
		return nome;
	}
	
	/**
	 * @return capienza contenente il numero di posti della sala
	 */
	public int getCapienza(){
		return capienza;
	}
	
	/**
	 * @return descrizione contenente una breve descrizione della sala
	 */
	public String getDescrizione(){
		return descrizione;
	}
	
	/**
	 * @return tariffa contenente costo di affitto della sala
	 */
	public float getTariffa(){
		return tariffa;
	}
	
	public void setNome(String name){
		nome = name;
	}
	
	public void setCapienza(int posti){
		capienza = posti;
	}
	
	public void setDescrizione(String desc){
		descrizione = desc;
	}
	
	/**
	 * override del metodo toString
	 * @return una stringa contenente i dati della sala
	 */
	public String toString(){
		return nome + " " + capienza + " " + tariffa;
	}
}
