package entita;

import java.sql.Date;
/**
 * @author simoneonori
 *
 */
public class Affitto {
	
	private Date data;
	private String cf;
	private String sala;
	
	public Affitto(){
		this(null, null, null);
	}
	
	public Affitto(Date date, String code, String room) {
		data = date;
		cf = code;
		sala = room;
	}
		
	public Date getData() {
		return data;
	}
	
	public void setData(Date dataE) {
		data = dataE;
	}
	
	public String getCf() {
		return cf;
	}
	
	public void setCf(String codiceFiscale) {
		cf = codiceFiscale;
	}
	
	public String getSala() {
		return sala;
	}
	
	public void setSala(String nomeSala){
		sala = nomeSala;
	}
	
	@Override
	public String toString() {
		return sala + " " + data + " " + cf;
	}
	
	
	
}
