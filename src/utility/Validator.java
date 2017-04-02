package utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author simoneonori
 * @author eliapacioni
 * @author riccardosmerilli
 * @author francescotalento
 * @version 1.0 Marzo 2017 
 * 
 * Classe che si effettuare la validazione dei dati inseriti in input
 */
public class Validator {

	/**
	 * Metodo statico che si occupa della validazione del codice fiscale
	 * @param str, codice fiscale che deve essere validato
	 * @return true se il codice è validato correttamente, altrimenti false
	 */
	public static boolean validaCf(String str) {
		boolean esito = false;
		Pattern patt = Pattern.compile("[A-Z]{6}+[0-9]{2}+[A-Z]{1}+[0-9]{2}+[A-Z]+[0-9]{3}[A-Z]");
		Matcher match = patt.matcher(str);
		if (match.matches()) {
			esito = true;
		}
		return esito;
	}

	/**
	 * Metodo che si occupa di validare un indirizzo email
	 * @param str, indirizzo email da validare
	 * @return true se l'indirizzo è validato correttamente, altrimenti false
	 */
	public static boolean validaEmail(String str) {
		Pattern patt = Pattern.compile("[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}");
		Matcher match = patt.matcher(str);
		return (match.matches() && str.length() < 101);
	}

	/**
	 * Metodo statico che si occupa di validare una data in formato AAAA/MM/GG
	 * @param str, data da validare
	 * @return true se la data è validata correttamente, altrimenti false
	 */
	public static boolean validaData(String str) {
		Pattern patt = Pattern.compile("(19|20)[0-9]{2}[- /.](0[1-9]|1[012])[-/.](0[1-9]|[12][0-9]|3[01])");
		Matcher match = patt.matcher(str);
		return match.matches();
	}
	
	/**
	 * Metodo che si occupa di validare una data formata solo da anno e mese nel formato AAAA/MM
	 * @param str, data da validare
	 * @return true se la data è validato correttamente, altrimenti false
	 */
	public static boolean validaDataInizio(String str) {
		Pattern patt = Pattern.compile("(19|20)[0-9]{2}[- /.](0[1-9]|1[012])");
		Matcher match = patt.matcher(str);
		return match.matches();
	}

	/**
	 * Metodo che si occupa di validare il cap
	 * @param str, cap da validare
	 * @return true se il cap è validato correttamente, altrimenti false
	 */
	public static boolean validaCap(String str) {
		Pattern patt = Pattern.compile("[0-9]{5}");
		Matcher match = patt.matcher(str);
		return match.matches();
	}

	/**
	 * Metodo che si occupa di validare un numero di telefono
	 * @param str, numero da validare
	 * @return true se il numero è validato correttamente, altrimenti false
	 */
	public static boolean validaTel(String str) {
		Pattern patt = Pattern.compile("[3]+[0-9]{8,9}");
		Matcher match = patt.matcher(str);
		return match.matches();
	}

	/**
	 * Metodo che si occupa di validare un importo
	 * @param str, importo da validare
	 * @return true se l'importo è validato correttamente, altrimenti false
	 */
	public static boolean validaImporto(String str) {
		Pattern patt = Pattern.compile("[0-9]{1,3}+[.,]{0,1}+[0-9]{0,2}");
		Matcher match = patt.matcher(str);
		return match.matches();
	}

	/**
	 * Metodo che si occupa di validare un testo generico
	 * @param str, testo da validare
	 * @return true se il testo è validato correttamente, altrimenti false
	 */
	public static boolean validaTesto(String str){
		Pattern patt = Pattern.compile("[A-Z\\s]+");
		Matcher match = patt.matcher(str);
		return match.matches(); 
	}
	
	/**
	 * Metodo che valida nome o cognome, rispettando la lunghezza massima impostata nel db
	 * @param str, nome o cognome da validare
	 * @return true se il nome o cognome è validato correttamente, altrimenti false
	 */
	public static boolean validaAnagrafica(String str) {
		
		return ( validaTesto(str) && str.length() < 21);
	}

	/**
	 * Metodo che si occupa di validare un indirizzo composto da nome via + n. civico
	 * @param str, indirizzo da validare
	 * @return true se l'indirizzo è validato correttamente, altrimenti false
	 */
	public static boolean validaIndirizzo(String str) {
		Pattern patt = Pattern.compile("[A-Z\\s]*+[0-9]{1,4}");
		Matcher match = patt.matcher(str);
		return (match.matches() && str.length() < 200);
	}

	/**
	 * Metodo che si occupa di validare il nome di una città rispettando la lunghezza imposta nel database
	 * @param str, città da validare
	 * @return true se la città è validata correttamente, altrimenti false
	 */
	public static boolean validaCitta(String str){
		return (validaTesto(str) && str.length()<36);
	}
	
	/**
	 * Metodo che si occupa di validare il nome di una professione, rispettando la lunghezza imposta nel database
	 * @param str
	 * @return true se la profssione è validata correttamente, altrimenti false
	 */
	public static boolean validaProfessione(String str){
		return (validaTesto(str) && str.length()<31);
	}
	
	public static boolean validaMesi(int mesi, String metpagamento) {
		return ((metpagamento.equals("MENSILE") && mesi == 1) || (metpagamento.equals("TRIMESTRALE") && mesi == 3)
				|| (metpagamento.equals("SEMESTRALE") && mesi == 6) || (metpagamento.equals("ANNUALE") && mesi == 12));
	}
	
	public static boolean validaHost(String str){
		Pattern patt = Pattern.compile("[A-Z a-z]*+[:]+[0-9]*");
		Matcher match = patt.matcher(str);
		return match.matches();
	}
}
