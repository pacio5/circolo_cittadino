package entita;

public class Convenzione {
	private String id;
	private String ragione_sociale;
	private String indirizzo;
	private String descrizione;
	private double sconto;
	
	
	public String getId(){
		
		return id;
	}
	
	public String getRagione_sociale(){
		
		return ragione_sociale;
	}
	
	public void setRagione_sociale(String ragSoc){
		
		ragione_sociale = ragSoc;
	}
	
	public String getIndirizzo(){
		
		return indirizzo;
	}
	
	public void setIndirizzo(String ind){

		indirizzo = ind;
	}
	
	public String getDescrizione(){
	
		return descrizione;
	}
	
	public void setDescrizione(String descr){
		
		descrizione=descr;
	}
	
	public double getSconto(){
		
		return sconto;
		
	}
	
	public void setSconto(double scnt){
		
		sconto = scnt;
	}
	
	public String toString() {
		return "Convenzione [id=" + id + ", ragione_sociale=" + ragione_sociale + ","
				+ " indirizzo=" + indirizzo + ", descrizione=" + descrizione + ", "
						+ "sconto=" + sconto + "]"; 
	}
}