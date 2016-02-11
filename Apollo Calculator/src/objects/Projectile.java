package objects;

import objectVariables.ProjectileVariables;
import converters.ForceConverter;
import converters.MassConverter;
import equations.QuadraticEquation;
import util.VariableUtil;

public class Projectile extends ProjectileVariables{
	/**
	 * Constructor for ATI's Projectile
	 * 
	 * @Precondition the mass must be in grains, the contact surface area must be in square inches, the air pressure must be in PSI
	 * 
	 * @param m the mass of the projectile
	 * @param cSA the surface area of the projectile that is exposed to the pressurized air
	 * @param p the air pressure propelling the projectile
	 * @param r the railgun used to fire the projectile
	 */
	public Projectile(double m, double cSA, double p, Railgun r) {
		mass = m; contactSA = cSA; pressure = p; railgun = r;
	}
	
	/**
	 * Constructor for ATI's Projectile 
	 * 
	 * @Precondition the length/width/height must be in inch, the density must be in pounds per cubic inch,
	 *               the contact surface area must be in square inches, the air pressure must be in PSI
	 * 
	 * @param l the length of the projectile
	 * @param w the width of the projectile
	 * @param h the height of the projectile
	 * @param d the density of the projectile's material
	 * @param cSA the surface area of the projectile that is exposed to the pressurized air
	 * @param p the air pressure propelling the projectile
	 * @param r the railgun used to fire the projectile
	 */
	public Projectile(double l, double w, double h, double d, double cSA, double p, Railgun r) {
		length = l; width = w; height = h; density = d; contactSA = cSA; pressure = p; railgun = r;
	}
	
	/**
	 * Constructor for ATI's Projectile 
	 * 
	 * @Precondition the volume must be in cubic inch, the density must be in pounds per cubic inch,
	 *               the contact surface area must be in square inches, the air pressure must be in PSI
	 *               
	 * @param v the volume of the projectile
	 * @param d the density of the projectile's material
	 * @param cSA the surface area of the projectile that is exposed to the pressurized air 
	 * @param p the air pressure propelling the projectile
	 * @param r the railgun used to fire the projectile
	 */
	public Projectile(double v, double d, double cSA, double p, Railgun r) {
		volume = v; density = d; contactSA = cSA; pressure = p; railgun = r;
	}
	
	/**
	 * Method that calculates all of the properties of the projectile
	 */
	public void calcAll() {
		calcMuzzleVelocity(); calcMuzzleEnergy();
	}
	
	/**
	 * Method that calculates the mass of the projectile
	 */
	public void calcMass() {
		if (!VariableUtil.hasValue(volume)) {
			calcVolume();
		}
		mass = density * volume;
	}
	
	/**
	 * Method that calculates the volume of the projectile
	 * 
	 * @Precondition projectile shape must be rectangular
	 */
	private void calcVolume() {
		volume = length * width * height;
	}
	
	/**
	 * Method theat calculates the force exerted on the projectile when the air pressure hits it
	 */
	public void calcForce() {
		force = pressure * contactSA; //Calculates force in pounds
	}
	
	/**
	 * Method that calculates the muzzle velocit
	 */
	public void calcMuzzleVelocity() {
		calcAcceleration(); //Calculates the acceleration of the projectile in ft/s^2
		calcbarrelTravelTime(); //Calculates the muzzle travel time
		muzzleVelocity = acceleration * barrelTravelTime;
	}
	
	private void calcAcceleration() {
		calcForce();
		if (!VariableUtil.hasValue(mass)) {
			calcMass(); //Calculates mass in pounds
		}
		force = ForceConverter.convertToNewtons(force, "pounds"); mass = MassConverter.convertToKilograms(mass, "pounds");
		acceleration = force / mass; //Calculates acceleration in m/s^2
	}
	
	private void calcbarrelTravelTime() {
		double a = .5 * acceleration, b = 0, c = -railgun.length;
		QuadraticEquation qe = new QuadraticEquation(a, b, c); qe.calcQuadraticEquation();
		barrelTravelTime = qe.solution;
	}
	
	private void calcMuzzleEnergy() {		
		double veloSqrd = Math.pow(muzzleVelocity, 2);
		
		muzzleEnergy = (mass * veloSqrd) / 2;
	}
	
	
	//*****START GETTERS*****
	
	
	/**
	 * @return the muzzleVelocity
	 */
	public double getMuzzleVelocity() {
		return muzzleVelocity;
	}

	/**
	 * @return the acceleration
	 */
	public double getAcceleration() {
		return acceleration;
	}

	/**
	 * @return the finalVelo
	 */
	public double getFinalVelo() {
		return finalVelo;
	}

	/**
	 * @return the barrelTravelTime
	 */
	public double getBarrelTravelTime() {
		return barrelTravelTime;
	}

	/**
	 * @return the muzzleEnergy
	 */
	public double getMuzzleEnergy() {
		return muzzleEnergy;
	}
	
	
	//*****END GETTERS*****
}
