package calculators;

import converters.MassConverter;
import equations.KineticEnergyEquation;
import equations.PythagEquation;

public class ImpactVariablesCalculator {
	double time, initVertVelo, horizVelo, mass;
	public double impactVelo, impactAngle, impactEnergy, impactForce;
	public double finalVertVelo, acceleration;
	final double GRAVITY = 9.8;
	
	/**
	 * Constructor for ATI's impact variables calculator
	 * 
	 * @Precondition launch vertical velocity must be in m/s, t must be in seconds, hV must be in m/s, and m must be in kg
	 * 
	 * @param iVV the vertical launch velocity of the projectile
	 * @param t the time the projectile is in flight
	 * @param hV the horizontal velocity of the proje88ctile
	 * @param m the mass of the projectile
	 */
	public ImpactVariablesCalculator(double iVV, double t, double hV, double m) {
		time = t; initVertVelo = iVV; horizVelo = hV; mass = m; 
	}
	
	/**
	 * Method that calculates all of the impact variables
	 */
	public void calcAll() {
		calcFinalVelo(); calcVeloAngle(); calcKineticEnergy(); calcImpactForce();
	}
	
	/**
	 * Method that calculates the final vertical velocity of the projectile
	 */
	public void calcFinalVertVelo() {
		finalVertVelo = -initVertVelo; 
	}
	
	/**
	 * Method that calculates the impact velocity of the projectile
	 */
	public void calcFinalVelo() {
		impactVelo = -GRAVITY * time;
		impactVelo = -impactVelo;
	}
	
	/**
	 * Method that calculates the angle at which the projectile impacts
	 */
	public void calcVeloAngle() {
		calcFinalVertVelo();
		
		impactAngle = Math.atan(-finalVertVelo / horizVelo); 
		impactAngle = Math.toDegrees(impactAngle);//Calculates the angle the projectile hits the ground
	}
	
	/**
	 * Method that calculates the kinetic energy of the projectile's impact
	 */
	public void calcKineticEnergy() {
		KineticEnergyEquation ke = new KineticEnergyEquation(mass, impactVelo); ke.calcEquation(); //Calculates kinetic energy in joules
		impactEnergy = ke.kineticEnergy;
	}
	
	/**
	 * Method that calculates the force the impact of the projectile generates
	 */
	public void calcImpactForce() {
		impactForce = mass * GRAVITY;
	}
}
