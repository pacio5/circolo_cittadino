/**
 * 
 */
package entita;

/**
 * @author eliapacioni
 *
 */
public class Sala {
	private String nome;
	private int capienza;
	private String descrizione;
	private double tariffa;
	
	public Sala(String name, int posti, String desc, double prezzo){
		nome = name;
		capienza = posti;
		descrizione = desc;
		tariffa = prezzo;
	}
	
	public Sala(){
		this(null,-1, null, 0);
	}
		
	public String getNome(){
		return nome;
	}
	
	public int getCapienza(){
		return capienza;
	}
	
	public String getDescrizione(){
		return descrizione;
	}
	
	public double getTariffa(){
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
	
	public String toString(){
		return "La sala: "+ nome + " ha una capienza di: " + capienza + ", la sua tariffa è: " + tariffa + ". Breve descrizione della sala: "+ descrizione;
	}
}
