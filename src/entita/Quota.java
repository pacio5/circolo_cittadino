package entita;

import java.sql.Date;

public class Quota {
	private int id;
	private float valore;
	private String tipologia;
	private Date dataInizio;

	public Quota() {
		this(-1, 0, null, null);
	}

	public Quota(int cod, float value, String type, Date dataI) {
		id = cod;
		valore = value;
		tipologia = type;
		dataInizio = dataI;
	}

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

	public boolean equals(Quota x) {
		return (id == x.id && valore == x.valore && tipologia.equals(x.tipologia) && !dataInizio.after(x.dataInizio)
				&& !dataInizio.before(x.dataInizio));
	}

	/* Lettura attributi */
	public int getId() {
		return id;
	}

	public float getValore() {
		return valore;
	}

	public String getTipologia() {
		return tipologia;
	}

	public Date getDataI() {
		return dataInizio;
	}

	/* Inserimento attributi */
	public void setId(int cod) {
		id = cod;
	}

	public void setValore(float value) {
		valore = value;
	}

	public void setTipologia(String type) {
		tipologia = type;
	}

	public void setDataI(Date dataI) {
		dataInizio = dataI;
	}
}