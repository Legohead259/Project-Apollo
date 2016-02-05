package equations;

public class KineticEnergyEquation {
	double mass, velocity;
	public double kineticEnergy;
	
	/**
	 * Constructor for a kinetic energy equation calculation
	 * 
	 * @Precondition mass must be in kilograms (kg) and velocity must be in meters per second (m/s)
	 * 
	 * @param m the mass of the projectile
	 * @param v the velocity the projectile impacts the ground
	 */
	public KineticEnergyEquation(double m, double v) {
		mass = m; velocity = v;
	}
	
	/**
	 * Method that calculates the kinetic energy of the projectiles impact
	 * 
	 * @Postcondition the kinetic energy will be in Joules (J)
	 */
	public void calcEquation() {
		double veloSqrd = Math.pow(velocity, 2);
		
		kineticEnergy = .5 * mass * veloSqrd;
	}
}
