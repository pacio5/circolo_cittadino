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
 * Classe che si occupa di mappare l'entità Quota nel database
 */
public class Quota {
	private int id;
	private float valore;
	private String tipologia;
	private Date dataInizio;

	/**
	 * Costruttore, una quota è costituita da un id,
	 * l'importo assegnato, la tipologia del socio considerata
	 * e la data di partenza della quota
	 */
	public Quota() {
		this(-1, 0, null, null);
	}

	/**
	 * @param cod
	 * @param value
	 * @param type
	 * @param dataI
	 */
	public Quota(int cod, float value, String type, Date dataI) {
		id = cod;
		valore = value;
		tipologia = type;
		dataInizio = dataI;
	}

	/**
	 * @param value
	 * @param type
	 * @param dataI
	 */
	public Quota(float value, String type, Date dataI) {
		valore = value;
		tipologia = type;
		dataInizio = dataI;
	}

	@Override
	public String toString() {
		return "Quota[Id = " + id + ", Valore = " + valore + ", Tipologia = " + tipologia + ", Data Inizio = "
				+ dataInizio + "]";
	}

	/**
	 * @param x oggetto Quota
	 * @return true se le proprietà delle Quote corrispondono, altrimenti false
	 */
	public boolean equals(Quota x) {
		return (id == x.id && valore == x.valore && tipologia.equals(x.tipologia) && !dataInizio.after(x.dataInizio)
				&& !dataInizio.before(x.dataInizio));
	}

	/**
	 * @return id della quota
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return valore della quota
	 */
	public float getValore() {
		return valore;
	}

	/**
	 * @return tipologia del socio
	 */
	public String getTipologia() {
		return tipologia;
	}

	/**
	 * @return data di partenza della quota
	 */
	public Date getDataI() {
		return dataInizio;
	}

	/**
	 * @param cod id della quota
	 */
	public void setId(int cod) {
		id = cod;
	}

	/**
	 * @param value valore della quota
	 */
	public void setValore(float value) {
		valore = value;
	}

	/**
	 * @param type tipologia dei soci
	 */
	public void setTipologia(String type) {
		tipologia = type;
	}

	/**
	 * @param dataI data partenza della quota
	 */
	public void setDataI(Date dataI) {
		dataInizio = dataI;
	}
}