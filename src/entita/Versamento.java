package entita;

import java.sql.Date;

/**
 * @author simoneonori
 * @author eliapacioni
 * @author riccardosmerilli
 * @author francescotalento
 * 
 * @version 1.0 Marzo 2017
 * 
 * 
 * Classe che si occupa di mappare l'entit� Versamento nel database
 */
public class Versamento {
	private int id;
	private float importo;
	private String[] mesi = new String[12];
	private int lunghmesi;
	private String socio;
	private Date data;
	private String descrizione = new String();
	private Socio s;

	/**
	 * Costruttore, un versamento � formato da un id, il valore dell'importo pagato,
	 * un array mesi contenente i nomi dei mesi considerati nel versamento,
	 * il numero di mesi inseriti, il codice fiscale del socio, la data del versamento
	 * e la descrizione
	 */
	public Versamento() {
		this(0, new String[12], 0, (float)0.0, "", null, null);
	}
	
	/**
	 * @param cod
	 * @param month
	 * @param length
	 * @param value
	 * @param member
	 * @param dataV
	 * @param desc
	 */
	public Versamento(int cod, String[] month, int length, float value, String member, Date dataV, String desc) {
		id = cod;
		mesi = month.clone();
		lunghmesi = length;
		importo = value;
		socio = member;
		data = dataV;
		descrizione = desc;
	}
	
	public Versamento(int cod, String[] month, int length, float value, Socio member, Date dataV, String desc) {
		id = cod;
		mesi = month.clone();
		lunghmesi = length;
		importo = value;
		s = member;
		data = dataV;
		descrizione = desc;
	}

	/**
	 * @param cod
	 * @param value
	 * @param member
	 * @param dataV
	 * @param desc
	 */
	public Versamento(int cod, float value, String member, Date dataV, String desc) {
		id = cod;
		importo = value;
		socio = member;
		data = dataV;
		descrizione = desc;
	}

	/**
	 * @param value
	 * @param member
	 * @param dataV
	 * @param desc
	 */
	public Versamento(float value, String member, Date dataV, String desc) {
		importo = value;
		socio = member;
		data = dataV;
		descrizione = desc;
	}
	
	/**
	 * @param x oggetto Versamento
	 * @return true se le propriet� dei Versamenti corrispondono, altrimenti false
	 */
	public boolean equals(Versamento x) {
		return (id == x.id && mesi.equals(x.mesi) && importo == x.importo && socio.equals(x.socio)
				&& !data.after(x.data) && !data.before(x.data) && descrizione.equals(x.descrizione));
	}
	
	@Override
	public String toString() {
		return "Versamento [Id = " + id + ", Importo = " + importo + ", Socio = " + socio + ", Data = " + data
				+ ", Descrizione = " + descrizione + "]";
	}

	/**
	 * Metodo per clonare le propriet� di un Versamento x
	 * in un Versamento considerato
	 * @param x oggetto Verssamento
	 */
	public void cloneSpill(Versamento x) {
		id = x.getId();
		mesi = x.getMesi().clone();
		lunghmesi = x.getMesiLeng();
		importo = x.getImporto();
		socio = x.getSocio();
		data = x.getData();
		descrizione = x.getDescrizione();
	}

	/**
	 * @return id del versamento
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return mesi pagati col pagamento
	 */
	public String[] getMesi() {
		return mesi;
	}

	/**
	 * Restituisce il mese all'indice index
	 * @param index indice del mese considerato
	 * @return una stringa con il valore del mese considerato
	 */
	public String getMese(int index) {
		return mesi[index];
	}
	
	/**
	 * @return numero dei mesi pagati
	 */
	public int getMesiLeng() {
		return lunghmesi;
	}

	/**
	 * @return importo del versamento
	 */
	public float getImporto() {
		return importo;
	}

	/**
	 * @return codice fiscale del socio
	 */
	public String getSocio() {
		return socio;
	}

	/**
	 * @return data del versamento
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @return descrizione del versamento
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * @param cod codice del versamento
	 */
	public void setId(int cod) {
		id = cod;
	}

	/**
	 * Inserimento di un'array di mesi
	 * @param months mesi da inserire
	 */
	public void setMesi(String[] months) {
		mesi = months.clone();
	}

	/**
	 * Inserimento di un singolo mese
	 * @param month mese da inserire
	 */
	public void setMese(String month) {
		mesi[lunghmesi] = month;
		lunghmesi++;
	}

	/**
	 * @param value importo del versamento
	 */
	public void setImporto(float value) {
		importo = value;
	}

	/**
	 * @param member codice fiscale del socio
	 */
	public void setSocio(String member) {
		socio = member;
	}

	/**
	 * @param dataV data del versamento
	 */
	public void setData(Date dataV) {
		data = dataV;
	}

	/**
	 * @param desc descrizione del versamento
	 */
	public void setDescrizione(String desc) {
		descrizione = desc;
	}

	/**
	 * Metodo per azzerare i mesi e la quantit� considerata nel versamento
	 */
	public void azzeraMesi() {
		String[] mesivuoti = { null, null, null, null, null, null, null, null, null, null, null, null };
		mesi = mesivuoti;
		lunghmesi = 0;
	}
}