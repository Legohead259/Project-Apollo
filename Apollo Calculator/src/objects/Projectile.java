package objects;

import converters.ForceConverter;
import converters.MassConverter;
import equations.QuadraticEquation;
import util.VariableUtil;

public class Projectile {
	double mass, contactSA, pressure;
	double length, width, height, density;
	double volume;
	public double muzzleVelocity, acceleration, finalVelo, barrelTravelTime, force;
	Railgun railgun;
	final double initVelo = 0;
	
	/**
	 * Constructor for ATI's Projectile
	 * 
	 * @Precondition the mass must be in pounds, the contact surface area must be in square inches, the air pressure must be in PSI
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
	
	public void calcMass() {
		if (!VariableUtil.hasValue(volume)) {
			calcVolume();
		}
		mass = density * volume;
	}
	
	private void calcVolume() {
		volume = length * width * height;
	}
	
	public void calcForce() {
		force = pressure * contactSA; //Calculates force in pounds
	}
	
	public void calcMuzzleVelocity() {
		calcAcceleration(); //Calculates the acceleration of the projectile in ft/s^2
		calcbarrelTravelTime(); //Calculates the muzzle travel time
		muzzleVelocity = acceleration * barrelTravelTime;
	}
	
	private void calcAcceleration() {
		calcForce(); //Calculates force in pounds
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
}
