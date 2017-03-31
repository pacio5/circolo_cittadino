package entita;

import java.sql.Date;

/**
 * @author simoneonori
 * @author eliapacioni
 * @author riccardosmerilli
 * @author francescotalento
 * @version 1.0 Marzo 2017 
 * 
 * Classe che si occupa di mappare l'entità figlio contenuta nel database
 */
public class Figlio {
	private String cf;
	private String nome;
	private char sesso;
	private Date dataNascita;
	private Socio genitore;
	private boolean aCarico;
	
	/**
	 * Costruttore del figlio senza parametri
	 * 
	 */
	public Figlio(){
		this(null, null, ' ', null, null, false);
	}
	
	/**
	 * Costruttore parametrico del figlio, inizializza tutte le proprietà con i valori passati
	 * @param codice, codice fiscale del figlio
	 * @param name, nome del figlio
	 * @param sex, sesso del figlio
	 * @param dateB, data di nascita del figlio
	 * @param parent, genitore 
	 * @param carico, se è a carico del genitore o no
	 */
	public Figlio(String codice, String name, char sex, Date dateB, Socio parent, boolean carico){
		cf = codice;
		nome = name;
		sesso = sex;
		dataNascita = dateB;
		genitore = parent;
		aCarico = carico;
	}
	
	/**
	 * 
	 * @return codice fiscale del figlio (String)
	 */
	public String getCf(){
		return cf;
	}
	
	/**
	 * 
	 * @return nome del figlio (String)
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * 
	 * @return sesso del figlio (char)
	 */
	public char getSesso(){
		return sesso;
	}
	
	/**
	 * 
	 * @return data di nascita del figlio (Date)
	 */
	public Date getDataNascita() {
		return dataNascita;
	}
	
	/**
	 * 
	 * @return genitore (Socio)
	 */
	public Socio getGenitore(){
		return genitore;
	}
	
	/**
	 * 
	 * @return valore booleano che varia se il figlio è a carico del genitore o no
	 */
	public boolean getACarico(){
		return aCarico;
	}
	
	/**
	 * Override del metodo toString()
	 * @return valori delle proprietà del figlio (String)
	 */
	@Override
	public String toString(){
		return nome + " Data di Nascita " + dataNascita;
	}
}
