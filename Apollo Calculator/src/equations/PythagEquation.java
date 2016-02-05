package equations;

import util.VariableUtil;

public class PythagEquation {
	double num1, num2;
	public double a, b, c;
	public double missingVal;
	
	public String missing;
	String[] vars = {"a", "b", "c"};
	
	public PythagEquation(double num1, String num1Iden, double num2, String num2Iden) {
		missing = VariableUtil.findMissingVar(num1Iden, num2Iden, vars); //Finds the missing variable
		determineVarType(num1, num1Iden); determineVarType(num2, num2Iden); //Sets the knwon variables
	}
	
	public void calcEquation() {
		if (missing.equalsIgnoreCase("c")) {
			double aPow = Math.pow(a, 2), bPow = Math.pow(b, 2);
			
			c = Math.sqrt(aPow + bPow); missingVal = c;
		}
		
		else if (missing.equalsIgnoreCase("b")) {
			double aPow = Math.pow(a, 2), cPow = Math.pow(c, 2);
			
			b = Math.sqrt(aPow + cPow); missingVal = b;
		}
		
		else {
			double cPow = Math.pow(c, 2), bPow = Math.pow(b, 2);
			
			a = Math.sqrt(cPow + bPow); missingVal = a;
		}
	}
	
	/**
	 * Method that determines the type of variable that the passed value is
	 * @param num the value of the variable
	 * @param numIden the type of variable the value is
	 */
	private void determineVarType(double num, String numIden) {
		if (numIden.equalsIgnoreCase("a")) {
			a = num;
		}
		
		else if (numIden.equalsIgnoreCase("b")) {
			b = num;
		}
		
		else {
			c = num;
		}
	}
}
