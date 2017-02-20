/**
 * 
 */
package entita;

import java.sql.Date;

/**
 * @author eliapacioni
 *
 */
public class Figlio {
	private String cf;
	private String nome;
	private Date dataNascita;
	private Socio genitore;
	private boolean aCarico;
	
	public Figlio(String codice, String name, Date dateB, Socio parent, boolean carico){
		cf = codice;
		nome = name;
		dataNascita = dateB;
		genitore = parent;
		aCarico = carico;
	}
	
	public Figlio(){
		this(null, null, null, null, false);
	}
	
	public String getCf(){
		return cf;
	}

	public String getNome() {
		return nome;
	}
	
	public Date getDataNascita() {
		return dataNascita;
	}
	
	public Socio getGenitore(){
		return genitore;
	}
	
	public boolean getACarico(){
		return aCarico;
	}
	
	public String toString(){
		return nome + " codice fiscale: " + cf + " nato a " + dataNascita + "figlio di: " + genitore.toString() + "a carico: " + aCarico;
	}
}
