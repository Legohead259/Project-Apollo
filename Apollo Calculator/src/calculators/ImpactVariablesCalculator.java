package calculators;

import converters.MassConverter;
import equations.KineticEnergyEquation;
import equations.PythagEquation;

public class ImpactVariablesCalculator {
	double time, initVertVelo, horizVelo, mass;
	public double finalVelo, veloAngle, kineticEnergy, impactForce;
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
	
	public void calcAll() {
		calcFinalVelo(); calcVeloAngle(); calcKineticEnergy(); calcImpactForce();
	}
	
	public void calcFinalVertVelo() {
		finalVertVelo = -initVertVelo; 
	}
	
	public void calcFinalVelo() {
		finalVelo = -GRAVITY * time;
		finalVelo = -finalVelo;
	}
	
	public void calcVeloAngle() {
		calcFinalVertVelo();
		
		veloAngle = Math.atan(-finalVertVelo / horizVelo); 
		veloAngle = Math.toDegrees(veloAngle);//Calculates the angle the projectile hits the ground
	}
	
	public void calcKineticEnergy() {
		KineticEnergyEquation ke = new KineticEnergyEquation(mass, finalVelo); ke.calcEquation(); //Calculates kinetic energy in joules
		kineticEnergy = ke.kineticEnergy;
	}
	
	public void calcImpactForce() {
		impactForce = mass * GRAVITY;
	}
}
