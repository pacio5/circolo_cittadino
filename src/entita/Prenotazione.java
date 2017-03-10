package entita;

import java.sql.Date;
/**
 * @author simoneonori
 *
 */
public class Prenotazione {
	
	private Date dataAcquisto;
	private String cf;
	private int evento;
	private int nBiglietti;
	
	public Prenotazione(){
		this(null, null, 0, 0);
	}
	
	public Prenotazione(Date date, String code, int event, int ticket) {
		dataAcquisto = date;
		cf = code;
		evento = event;
		nBiglietti = ticket;
	}
		
	public Date getDataAcquisto() {
		return dataAcquisto;
	}
	
	public void setData(Date dataA) {
		dataAcquisto = dataA;
	}
	
	public String getCf() {
		return cf;
	}
	
	public void setCf(String codiceFiscale) {
		cf = codiceFiscale;
	}
	
	public int getEvento() {
		return evento;
	}
	
	public void setEvento(int codiceEvento){
		evento = codiceEvento;
	}
	
	public int getNumBiglietti() {
		return nBiglietti;
	}
	
	public void setNumBiglietti(int numBiglietti) {
		nBiglietti = numBiglietti;
	}
	
	@Override
	public String toString() {
		return "L'evento=" + evento + ", è stato prenotato da cf=" + cf + " per " + nBiglietti + " persone il " + dataAcquisto;
	}
		
}
