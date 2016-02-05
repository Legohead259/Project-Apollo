package equations;

import util.VariableUtil;

/**
 * Equation class for angle of launch, range, and muzzle velocity calculations for the Apollo Targeting Interface
 * @author Braidan Duffy
 *
 */
public class AngleEquation {
	double angle, range, velocity;
	public double missingVal;
	final double GRAVITY = 9.8;
	public String missing;
	String[] vars = {"angle", "range", "velocity"};
	
	/**
	 * Constructor for a new AngleEquation
	 * 
	 * @Preconditions velocity is in meters per second (m/s), angle is in degrees, and range is in meters (m)
	 * 
	 * @param num1 the value of the first known value
	 * @param num1Iden the variable type of the first known value
	 * @param num2 the value of the second known value
	 * @param num2Iden the variable type of the second known value
	 */
	public AngleEquation(double num1, String num1Iden, double num2, String num2Iden) {
		missing = VariableUtil.findMissingVar(num1Iden, num2Iden, vars);
		determineVarType(num1, num1Iden); determineVarType(num2, num2Iden);
	}
		
	/**
	 * Method that calculates the equation given the known variables
	 * 
	 * @Postcondition velocity is in meters per second (m/s), range is in meters (m), and angle is in degrees
	 */
	public void calcEquation() {
		double sinCalc;
		
		if (missing.equalsIgnoreCase("angle")) {
			angle = .5 * Math.asin(GRAVITY * range / Math.pow(velocity, 2));
			angle = Math.toDegrees(angle);
			missingVal = angle;
		}
		
		else if (missing.equalsIgnoreCase("range")) {
			sinCalc = Math.sin(Math.toRadians(2 * angle));
			
			range = Math.pow(velocity, 2) * sinCalc / GRAVITY;
			missingVal = range;
		}
		
		else {
			sinCalc = Math.sin(Math.toRadians(2 * angle));
			
			velocity = Math.sqrt(range * GRAVITY / sinCalc);
			missingVal = velocity;
		}
	}
	
	/**
	 * Method that determines the type of variable that the passed value is
	 * @param num the value of the variable
	 * @param numIden the type of variable the value is
	 */
	private void determineVarType(double num, String numIden) {
		if (numIden.equalsIgnoreCase("angle")) {
			angle = num;
		}
		
		else if (numIden.equalsIgnoreCase("range")) {
			range = num;
		}
		
		else {
			velocity = num;
		}
	}
}
