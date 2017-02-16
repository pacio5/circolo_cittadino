package entita;

import java.lang.*;
import java.sql.Date;
import java.util.Arrays;

public class Versamento {
	private int id;
	private double importo;
	private String[] mesi;
	private Date data;
	private String descrizione = new String();
	
	public Versamento(){
		this(-1, null, 0, null, null);
	}
	
	public Versamento(int cod, String[] month, double value, Date dataV, String desc){
		id = cod;
		mesi = month;
		importo = value;
		data = dataV;
		descrizione = desc;
	}
	
	public boolean equals(Versamento x){
		return (id == x.id && mesi.equals(x.mesi) && importo == x.importo && !data.after(x.data) && !data.before(x.data) && descrizione.equals(x.descrizione));
	}
	
	public String toString() {
		return "Versamento [Id=" + id + ", Importo=" + importo + ", Mesi=" + Arrays.toString(mesi) + ", Data=" + data
				+ ", Descrizione=" + descrizione + "]";
	}
	
	/* Lettura attributi */
	public int getId(){
		return id;
	}
	
	public String[] getMesi(){
		return mesi;
	}
	
	public double getImporto(){
		return importo;
	}
	
	public Date getData(){
		return data;
	}
	
	public String getDescrizione(){
		return descrizione;
	}
	
	/* Inserimento attributi */
	public void setId(int cod){
		id = cod;
	}
	
	public void setMesi(String[] month){
		mesi = month;
	}
	
	public void setImporto(double value){
		importo = value;
	}
	
	public void setData(Date dataV){
		data = dataV;
	}
	
	public void setDescrizione(String desc){
		descrizione = desc;
	}
}