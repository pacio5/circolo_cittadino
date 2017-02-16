package entita;

import java.sql.Date;
import java.util.Arrays;

public class Versamento {
	private int id;
	private double importo;
	private String[] mesi;
	private String socio;
	private Date data;
	private String descrizione = new String();

	public Versamento() {
		this(-1, null, 0, null, null, null);
	}

	public Versamento(int cod, String[] month, double value, String member, Date dataV, String desc) {
		id = cod;
		mesi = month;
		importo = value;
		socio = member;
		data = dataV;
		descrizione = desc;
	}

	public boolean equals(Versamento x) {
		return (id == x.id && mesi.equals(x.mesi) && importo == x.importo && socio.equals(x.socio) && !data.after(x.data) && !data.before(x.data)
				&& descrizione.equals(x.descrizione));
	}

	public String toString() {
		return "Versamento [Id=" + id + ", Importo=" + importo + ", Socio="+ socio +", Mesi=" + Arrays.toString(mesi) + ", Data=" + data
				+ ", Descrizione=" + descrizione + "]";
	}

	/* Lettura attributi */
	public int getId() {
		return id;
	}

	public String[] getMesi() {
		return mesi;
	}

	public double getImporto() {
		return importo;
	}
	
	public String getSocio(){
		return socio;
	}

	public Date getData() {
		return data;
	}

	public String getDescrizione() {
		return descrizione;
	}

	/* Inserimento attributi */
	public void setId(int cod) {
		id = cod;
	}

	public void setMesi(String[] month) {
		mesi = month;
	}

	public void setImporto(double value) {
		importo = value;
	}
	
	public void setSocio(String member){
		socio = member;
	}

	public void setData(Date dataV) {
		data = dataV;
	}

	public void setDescrizione(String desc) {
		descrizione = desc;
	}
}