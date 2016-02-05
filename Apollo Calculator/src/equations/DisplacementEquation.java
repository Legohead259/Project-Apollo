package equations;

import util.VariableUtil;

/**
 * DisplacementEquation class for the Apollo Targeting Interface
 * @author Braidan Duffy
 *
 */
public class DisplacementEquation {
	public double disp, velo, time;
	public double missingVal;
	
	public final double GRAVITY = 9.8;
	
	String[] vars = {"displacement", "velocity", "time", "acceleration"};
	public String missing;
	public String quadFormula;
	
	/**
	 * Constructor for a DisplacementEquation
	 * 
	 * @Precondition displacement is in meters (m), velocity is in meters per second (m/s), and time is in seconds (s)
	 * 
	 * @param num1 the value of the first known value
	 * @param num1Iden the type of variable the first known value is
	 * @param num2 the value of the second known value
	 * @param num2Iden the type of variable the second known value is
	 */
	public DisplacementEquation(double num1, String num1Iden, double num2, String num2Iden) {
		determineVarType(num1, num1Iden); determineVarType(num2, num2Iden);
		missing = VariableUtil.findMissingVar(num1Iden, num2Iden, vars);
	}
	
	/**
	 * Method that calculates the Displacement equation given the passed values
	 */
	public void calcEquation() {
		if (missing.equalsIgnoreCase("displacement")) {
			disp = velo * time + (-GRAVITY / 2) * Math.pow(time, 2);
			missingVal = disp;
		}
		
		else if (missing.equalsIgnoreCase("velocity")) {
			velo = (disp / time) - (-GRAVITY / 2) * Math.pow(time, 2);
			missingVal = velo;
		}
		
		else if (missing.equalsIgnoreCase("time")) {
			convertToQuadratic();
			missingVal = time;
		}
	}
	
	/**
	 * Method that converts the displacement equation into a quadratic formula that is then used to solve for time of flight
	 * 
	 * @Note Only used to solve for time
	 */
	public void convertToQuadratic() {
		double a, b, c;
		
		a = -GRAVITY / 2; b = velo; c = -disp;
		quadFormula = a + "t^2 * " + b + "t + " + c; //TODO Round off values at points
		
		QuadraticEquation qe = new QuadraticEquation(a, b, c); qe.calcQuadraticEquation(); //Finds solution to create quadratic formula
		
		time = qe.solution;
	}
	
	/**
	 * Method that determines the type of variable that the passed value is
	 * @param num the value of the variable
	 * @param numIden the type of variable the value is
	 */
	private void determineVarType(double num, String numIden) {
		if (numIden.equalsIgnoreCase("displacement")) {
			disp = num;
		}
		
		else if (numIden.equalsIgnoreCase("velocity")) {
			velo = num;
		}
		
		else {
			time = num;
		}
	}
}
