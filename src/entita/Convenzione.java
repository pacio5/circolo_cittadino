package entita;

/**
 * @author talento
 *
 */
public class Convenzione {
	private int id;
	private String ragioneSociale;
	private String indirizzo;
	private String descrizione;
	private double sconto;
	
	public Convenzione(){
		this(-1, null, null, null, 0);
	}
	
	public Convenzione(int ident, String azienda, String address, String desc, double percent){
		id = ident;
		ragioneSociale = azienda;
		indirizzo = address;
		descrizione = desc;
		sconto = percent;
	}
	
	public Convenzione(String azienda, String address, String desc, double percent){
		id = -1;
		ragioneSociale = azienda;
		indirizzo = address;
		descrizione = desc;
		sconto = percent;
	}

	public int getId() {
		return id;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public double getSconto() {
		return sconto;
	}
	
	@Override
	public String toString(){
		return ragioneSociale + " " + String.valueOf(sconto);
	}
	
}