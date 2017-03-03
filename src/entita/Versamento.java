package entita;

import java.sql.Date;

public class Versamento {
	private int id;
	private float importo;
	private String[] mesi = new String[12];
	private int lunghmesi;
	private String socio;
	private Date data;
	private String descrizione = new String();

	public Versamento() {

	}

	public Versamento(int cod, String[] month, int length, float value, String member, Date dataV, String desc) {
		id = cod;
		mesi = month.clone();
		lunghmesi = length;
		importo = value;
		socio = member;
		data = dataV;
		descrizione = desc;
	}

	public Versamento(int cod, float value, String member, Date dataV, String desc) {
		id = cod;
		importo = value;
		socio = member;
		data = dataV;
		descrizione = desc;
	}

	public Versamento(float value, String member, Date dataV, String desc) {
		importo = value;
		socio = member;
		data = dataV;
		descrizione = desc;
	}

	public boolean equals(Versamento x) {
		return (id == x.id && mesi.equals(x.mesi) && importo == x.importo && socio.equals(x.socio)
				&& !data.after(x.data) && !data.before(x.data) && descrizione.equals(x.descrizione));
	}

	@Override
	public String toString() {
		return "Versamento [Id = " + id + ", Importo = " + importo + ", Socio = " + socio + ", Data = " + data
				+ ", Descrizione = " + descrizione + "]";
	}
	
	public void cloneSpill(Versamento x){
		id = x.getId();
		mesi = x.getMesi().clone();
		lunghmesi = x.getMesiLeng();
		importo = x.getImporto();
		socio = x.getSocio();
		data = x.getData();
		descrizione = x.getDescrizione();
	}

    //Lettura attributi 
	public int getId() {
		return id;
	}

	public String[] getMesi() {
		return mesi;
	}

	public String getMese(int index) {
		return mesi[index];
	}

	public int getMesiLeng() {
		return lunghmesi;
	}

	public float getImporto() {
		return importo;
	}

	public String getSocio() {
		return socio;
	}

	public Date getData() {
		return data;
	}

	public String getDescrizione() {
		return descrizione;
	}

	//Inserimento attributi 
	public void setId(int cod) {
		id = cod;
	}

	public void setMesi(String[] months) {
		mesi = months.clone();
	}

	public void setMese(String month) {
		mesi[lunghmesi] = month;
		lunghmesi++;
	}

	public void setImporto(float value) {
		importo = value;
	}

	public void setSocio(String member) {
		socio = member;
	}

	public void setData(Date dataV) {
		data = dataV;
	}

	public void setDescrizione(String desc) {
		descrizione = desc;
	}
	
	public void azzeraMesi(){
		String[] mesivuoti = {null, null, null, null, null, null, null, null, null, null, null, null};
		mesi = mesivuoti;
		lunghmesi = 0;
	}
}