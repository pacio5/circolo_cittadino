/**
 * 
 */
package entita;

import java.sql.Date;
/**
 * @author eliapacioni
 *
 */
public class Evento {
	private String id;
	private String nome;
	private Date data;
	private String descrizione;
	private int posti;
	private String luogo;
	private double prezzo;
	
	public Evento(){
		this(null, null, null, null, 0, null, 0);
	}
	
	public Evento(String identification, String name, Date date, String description, int seats, String location, float price){ 
		id = identification;
		nome = name;
		data = date;
		descrizione = description;
		posti = seats;
		luogo = location;
		prezzo = price;		
	}
	
	public Evento(String name, Date date, String description, int seats, String location, float price){
		nome = name;
		data = date;
		descrizione = description;
		posti = seats;
		luogo = location;
		prezzo = price;		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String name) {
		nome = name;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date dataE) {
		data = dataE;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String desc) {
		descrizione = desc;
	}
	public int getPosti() {
		return posti;
	}
	public void setPosti(int numero) {
		this.posti = numero;
	}
	public String getLuogo() {
		return luogo;
	}
	public void setLuogo(String posto) {
		luogo = posto;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double costo) {
		prezzo = costo;
	}
	public String getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Evento [id=" + id + ", nome=" + nome + ", data=" + data + ", descrizione=" + descrizione + ", posti="
				+ posti + ", luogo=" + luogo + ", prezzo=" + prezzo + "]";
	}
	
	
	
}
