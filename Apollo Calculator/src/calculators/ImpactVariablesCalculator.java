package calculators;

import converters.MassConverter;
import equations.KineticEnergyEquation;
import equations.PythagEquation;

public class ImpactVariablesCalculator {
	double time, initVertVelo, horizVelo, mass, massKg;
	public double finalVelo, veloAngle, kineticEnergy, impactForce;
	public double finalVertVelo, acceleration;
	final double GRAVITY = 9.8;
	
	/**
	 * Constructor for ATI's impact variables calculator
	 * 
	 * @Precondition launch vertical velocity must be in m/s, t must be in seconds, hV must be in m/s, and m must be in lbs
	 * 
	 * @param iVV the vertical launch velocity of the projectile
	 * @param t the time the projectile is in flight
	 * @param hV the horizontal velocity of the projectile
	 * @param m the mass of the projectile
	 */
	public ImpactVariablesCalculator(double iVV, double t, double hV, double m) {
		time = t; initVertVelo = iVV; horizVelo = hV; mass = m; massKg = MassConverter.convertToKilograms(mass, "lbs");
	}
	
	public void calcAll() {
		calcFinalVelo(); calcVeloAngle(); calcKineticEnergy(); calcImpactForce();
	}
	
	public void calcFinalVertVelo() {
		finalVertVelo = initVertVelo - GRAVITY * time;  
	}
	
	public void calcFinalVelo() {
		calcFinalVertVelo(); //Calculates the final vertical velocity
		calcVeloAngle(); //Calculates the angle at which the projectile impacts
		
		PythagEquation pe = new PythagEquation(horizVelo, "a", finalVertVelo, "b"); pe.calcEquation(); //Calculates the final velocity
		finalVelo = pe.missingVal;
	}
	
	public void calcVeloAngle() {
		veloAngle = Math.atan(-finalVertVelo / horizVelo); 
		veloAngle = Math.toDegrees(veloAngle);//Calculates the angle the projectile hits the ground
	}
	
	public void calcKineticEnergy() {
		KineticEnergyEquation ke = new KineticEnergyEquation(massKg, finalVelo); ke.calcEquation(); //Calculates kinetic energy in joules
		kineticEnergy = ke.kineticEnergy;
	}
	
	public void calcImpactForce() {
		calcAcceleration();
		impactForce = massKg * acceleration;
	}
	
	public void calcAcceleration() {
		acceleration = finalVelo / time;
	}
	
	
}
