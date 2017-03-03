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
	private char sesso;
	private Date dataNascita;
	private Socio genitore;
	private boolean aCarico;
	
	public Figlio(){
		this(null, null, ' ', null, null, false);
	}
	
	public Figlio(String codice, String name, char sex, Date dateB, Socio parent, boolean carico){
		cf = codice;
		nome = name;
		sesso = sex;
		dataNascita = dateB;
		genitore = parent;
		aCarico = carico;
	}
	
	public String getCf(){
		return cf;
	}

	public String getNome() {
		return nome;
	}
	
	public char getSesso(){
		return sesso;
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
		return nome + " Genitore " + genitore.getNome() + " " + genitore.getCognome();
	}
}
