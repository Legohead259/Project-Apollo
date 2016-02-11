package calculators;

import equations.DisplacementEquation;
import equations.VectorEquation;
import util.VariableUtil;

/**
 * RangeCalculator for Apollo Targeting Interface
 * @author Braidan Duffy
 *
 */
public class RangeCalculator {
	public double initVelo, angle, angleRadians, startElev, endElev;
	public double initVertVelo, finalVertVelo, horizVelo, time, range, changeVertVelo;
	public String trajectoryFormula;
	public final double GRAVITY = 9.8;
	
	/**
	 * Constructor for ATI's RangeCalculator
	 * 
	 * @Precondition velocity in meters per second (m/s), angle in degrees
	 * 
	 * @param v muzzle velocity of projectile
	 * @param a angle of projectile launch
	 */
	public RangeCalculator(double v, double a) {
		initVelo = v; angle = a; angleRadians = Math.toRadians(a);
	}
	
	/**
	 * Constructor for ATI's RangeCalculator
	 * 
	 * @Precondition velocity in meters per second, angle in degrees, starting and ending elevation in meters (m)
	 * 
	 * @param v muzzle velocity of projectile
	 * @param a angle of projectile launch
	 * @param sL starting elevation of projectile launch
	 * @param eL ending elevation of projectile launch
	 */
	public RangeCalculator(double v, double a, double sL, double eL) {
		initVelo = v; angle = a; angleRadians = Math.toRadians(a); startElev = sL; endElev = eL;
	}
	
	
	//*****START VECTOR COMPONENTS AND TIME CALCULATIONS*****
	
	
	/**
	 * Method that calculates the projectile's vertical velocity at launch and impact
	 * 
	 * @Note velocity is in meters per second (m/s)
	 */
	private void calcVertVelo() {
		VectorEquation ve = new VectorEquation(angle, initVelo); ve.calcVertComponent(); //Calculates vertical velocity at launch
		initVertVelo = ve.vertComponent;
		finalVertVelo = -initVertVelo; //Calculates vertical velocity at impact
		changeVertVelo = finalVertVelo - initVertVelo; //Calculates change in velocity over time
	}
	
	/**
	 * Method that calculates the projectile's horizontal velocity
	 * 
	 * @Note velocity is in meters per second (m/s)
	 */
	private void calcHorizVelo() {		
		horizVelo = initVelo * Math.cos(angleRadians); //Calculates horizontal velocity assuming air resistance is negligible
	}
	
	/**
	 * Method that calculates the projectile's flight time
	 * 
	 * @Note time is in seconds (s)
	 */
	public void calcTime() {		
		time = changeVertVelo / -GRAVITY; //Calculates projectile's flight time
	}
	
	
	//*****END VECTOR COMPONENTS AND TIME CALCULATIONS*****
	
	
	//*****START RANGE CALCULATIONS*****
	
	
	/**
	 * Method that calculates the range that the projectile travels
	 */
	public void calcRange() {
		calcVertVelo(); calcHorizVelo();
		double displacement;
		
		if (VariableUtil.hasValue(endElev) || VariableUtil.hasValue(startElev)) {
			displacement = endElev - startElev;
		}
		
		else {
			displacement = 0;
		}
		
		
		DisplacementEquation de = new DisplacementEquation(initVertVelo, "velocity", displacement, "displacement"); de.calcEquation(); //Calculates the time projectile is in flight
		time = de.time;
		range = time * horizVelo;
		trajectoryFormula = de.quadFormula;
	}
	
	
	//*****END DIFFERENT ELEVATION RANGE CALCULATIONS*****
}