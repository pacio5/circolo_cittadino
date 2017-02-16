package entita;

import java.lang.*;
import java.sql.Date;

public class Quota {
	private int id;
	private double valore;
	private String tipologia;
	private Date dataInizio;
	private Date dataFine;

	public Quota() {
		this(-1, 0, null, null, null);
	}

	public Quota(int cod, double value, String type, Date dataI, Date dataF) {
		id = cod;
		valore = value;
		tipologia = type;
		dataInizio = dataI;
		dataFine = dataF;
	}

	public String toString() {
		return "Quota[Id = " + id + ", Valore = " + valore + ", Tipologia = " + tipologia + ", Data Inizio = "
				+ dataInizio + ", Data Fine = " + dataFine + "]";
	}

	public boolean equals(Quota x) {
		return (id == x.id && valore == x.valore && tipologia.equals(x.tipologia) && !dataInizio.after(x.dataInizio)
				&& !dataInizio.before(x.dataInizio) && !dataFine.after(x.dataFine) && !dataFine.before(x.dataFine));
	}

	/* Lettura attributi */
	public int getId() {
		return id;
	}

	public double getValore() {
		return valore;
	}

	public String getTipologia() {
		return tipologia;
	}

	public Date getDataI() {
		return dataInizio;
	}

	public Date getDataF() {
		return dataFine;
	}

	/* Inserimento attributi */
	public void setId(int cod) {
		id = cod;
	}

	public void setValore(double value) {
		valore = value;
	}

	public void setTipologia(String type) {
		tipologia = type;
	}

	public void setDataI(Date dataI) {
		dataInizio = dataI;
	}

	public void setDataF(Date dataF) {
		dataFine = dataF;
	}
}