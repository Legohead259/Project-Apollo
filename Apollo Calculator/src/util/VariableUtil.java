package util;

/**
 * VaraibleUtilities class for the Apollo Targetting Interface
 * @author Braidan Duffy
 *
 */
public class VariableUtil {
	
	/**
	 * Method that finds what variable is missing out of a list of three variables
	 * @param iden1 the first variable type
	 * @param iden2 the second variable type
	 * @param vars the list of variable types
	 * @return the missing variable type
	 */
	public static String findMissingVar(String iden1, String iden2, String[] vars) {
		int pos = 0;
		
		for (int x = 0; x < vars.length; x++) {
			String var = vars[x];
			
			if (!(var.equalsIgnoreCase(iden1)) && !(var.equalsIgnoreCase(iden2))) {
				vars[pos] = "";
				return var;
			}
			pos++;
		}
		
		return "ERROR";
	}
	
	public static boolean hasValue(double value) {
		if (value > 0 || value < 0) {
			return true;
		}
		
		else {
			return false;
		}
	}
}
