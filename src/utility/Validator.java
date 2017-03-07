/**
 * 
 */
package utility;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entita.Versamento;

import java.sql.Date;

/**
 * @author eliapacioni
 *
 */
public class Validator {

	public static boolean ValidaCf(String str) {
		boolean esito = false;
		Pattern patt = Pattern.compile("[A-Z]{6}+[0-9]{2}+[A-Z]{1}+[0-9]{2}+[A-Z]+[0-9]{3}[A-Z]");
		Matcher match = patt.matcher(str);
		if (match.matches()) {
			esito = true;
		}
		return esito;
	}

	public static boolean ValidaEmail(String str) {
		Pattern patt = Pattern.compile("[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}");
		Matcher match = patt.matcher(str);
		return (match.matches() && str.length() < 101);
	}

	public static boolean ValidaData(String str) {
		Pattern patt = Pattern.compile("(19|20)[0-9]{2}[- /.](0[1-9]|1[012])[-/.](0[1-9]|[12][0-9]|3[01])");
		Matcher match = patt.matcher(str);
		return match.matches();
	}
	
	public static boolean ValidaDataInizio(String str) {
		Pattern patt = Pattern.compile("(19|20)[0-9]{2}[- /.](0[1-9]|1[012])");
		Matcher match = patt.matcher(str);
		return match.matches();
	}

	public static boolean ValidaCap(String str) {
		Pattern patt = Pattern.compile("[0-9]{5}");
		Matcher match = patt.matcher(str);
		return match.matches();
	}

	public static boolean ValidaTel(String str) {
		Pattern patt = Pattern.compile("[3]+[0-9]{8,9}");
		Matcher match = patt.matcher(str);
		return match.matches();
	}

	public static boolean ValidaImporto(String str) {
		Pattern patt = Pattern.compile("[0-9]{1,3}+[.,]{0,1}+[0-9]{0,2}");
		Matcher match = patt.matcher(str);
		return match.matches();
	}

	public static boolean ValidaTesto(String str){
		Pattern patt = Pattern.compile("[A-Z\\s]+");
		Matcher match = patt.matcher(str);
		return match.matches(); 
	}
	
	public static boolean ValidaAnagrafica(String str) {
		
		return ( ValidaTesto(str) && str.length() < 21);
	}

	public static boolean ValidaIndirizzo(String str) {
		Pattern patt = Pattern.compile("[A-Z\\s]*+[0-9]{1,4}");
		Matcher match = patt.matcher(str);
		return (match.matches() && str.length() < 200);
	}

	public static boolean ValidaCitta(String str){
		return (ValidaTesto(str) && str.length()<36);
	}
	
	public static boolean ValidaProfessione(String str){
		return (ValidaTesto(str) && str.length()<31);
	}
	
	public static boolean ValidaMesi(int mesi, String metpagamento) {
		return ((metpagamento.equals("MENSILE") && mesi == 1) || (metpagamento.equals("TRIMESTRALE") && mesi == 3)
				|| (metpagamento.equals("SEMESTRALE") && mesi == 6) || (metpagamento.equals("ANNUALE") && mesi == 12));
	}
	
	public static boolean ValidaDataMaggiore(Date dataPre, Date data){
		return dataPre.before(data);
	}
	
	public static boolean ValidaMesiPagati(String mese, ArrayList<String> mesipagati) {
		return !mesipagati.contains(mese);
	}
}
