/**
 * 
 */
package utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author eliapacioni
 *
 */
public class Validator {

	public static boolean ValidaCf(String str) {
		boolean esito = false;
		Pattern patt = Pattern.compile("[A-Z]{6}+[0-9]{2}+[A-Z]{2}+[0-9]{2}+[A-Z]+[0-9]{3}[A-Z]");
		Matcher match = patt.matcher(str);
		if(match.matches()){
			esito = true;
		}
		return esito;
	}
	
	public static boolean ValidaEmail(String str){
		boolean esito = false;
		Pattern patt = Pattern.compile("[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}");
		Matcher match = patt.matcher(str);
		if(match.matches()){
			esito = true;
		}
		return esito;
	}

	public static boolean ValidaData(String str) {
		boolean esito = false;
		Pattern patt = Pattern.compile("(19|20)[0-9]{2}[- /.](0[1-9]|[12][0-9]|3[01])[-/.](0[1-9]|1[012])");
		Matcher match = patt.matcher(str);
		if(match.matches()){
			esito = true;
		}
		return esito;
	}

	public static boolean ValidaCap(String str) {
		boolean esito = false;
		Pattern patt = Pattern.compile("[0-9]{5}");
		Matcher match = patt.matcher(str);
		if(match.matches()){
			esito = true;
		}
		return esito;
	}

	public static boolean ValidaTel(String str) {
		boolean esito = false;
		Pattern patt = Pattern.compile("[3]+[0-9]{8,9}");
		Matcher match = patt.matcher(str);
		if(match.matches()){
			esito = true;
		}
		return esito;
	}

	public static boolean ValidaImporto(String str) {
		boolean esito = false;
		Pattern patt = Pattern.compile("[0-9]*+[.,]+[0-9]{2}");
		Matcher match = patt.matcher(str);
		if(match.matches()){
			esito = true;
		}else{
			patt = Pattern.compile("[0-9]*");
			match = patt.matcher(str);
			if(match.matches())
				esito = true;
		}
		return esito;
	}

}
