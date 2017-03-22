/**
 * 
 */
package entita;

import java.sql.Date;

/**
 * @author eliapacioni
 *
 */
public class ExSocio extends Socio {
	protected Date dataDimissione;
	protected Boolean espulso;

	public ExSocio() {
		super();
		dataDimissione = null;
		espulso = null;
	}

	public ExSocio(String codice, String name, String surname, char sex, Date dateB, String placeB, String address,
			String city, String postalCode, String mail, String tel, String profession, String civilStatus,
			String spouse, Date dateAmmission, float taxAmmission, String modPay, String metPay, String type, Date dimissionDate, Boolean expelled) {
		super(codice, name, surname, sex, dateB, placeB, address, city, postalCode, mail, tel, profession, civilStatus,
				spouse, dateAmmission, taxAmmission, modPay, metPay, type);
		dataDimissione = dimissionDate;
		espulso = expelled;
	}
	
	public ExSocio(Socio n, Date dimissionDate, Boolean expelled){
		this(n.getCf(), n.getNome(), n.getCognome(), n.getSesso(), n.getDataNascita(), n.luogoNascita, n.getIndirizzo(),
			n.getCitta(), n.getCap(), n.getEmail(), n.getTelefono(), n.getProfessione(), n.getStatoCivile(), n.getConiuge(), n.getDataAmmissione(),
			n.getTassaAmmissione(), n.getModPagamento(), n.getMetPagamento(), n.getTipologia(), dimissionDate, expelled);		
	}
	
	public Date getDataDimissione() {
		return dataDimissione;
	}

	public Boolean getEspulso() {
		return espulso;
	}

	@Override
	public String toString() {
		return nome + " " + cognome + " "+ cf;
	}
}
