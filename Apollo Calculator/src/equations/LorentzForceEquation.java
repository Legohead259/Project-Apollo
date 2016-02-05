package equations;

public class LorentzForceEquation {
	double charge, distance, velocity, magField, time;
	double elecField, current;
	final double MAG_FIELD_RADIUS = .1;
	public double lorentzForce;
	
	/**
	 * Lorentz force equation constructor for ATI's calculations
	 * 
	 * @Precondition q must be in coulombs of charge, d must be in meters, velocity must be in m/s, b must be in Tesla (T), and time must be in seconds (s)
	 * 
	 * @param q the charge of the capacitor bank
	 * @param d the distance between the rails
	 * @param v the velocity the projectile is traveling at
	 * @param b the strength of the magnetic field
	 * @param t the time the projectile is in the barrel of the railgun
	 */
	public LorentzForceEquation(double q, double d, double v, double t) {
		charge = q; distance = d; velocity = v; time = t;
	}
	
	private void calcCurrent() {
		current = charge / time;
	}
	
	private void calcMagneticField() {
		calcCurrent(); //Calculates current going through rails
		
		double u = 4 * Math.PI * Math.pow(10, -7);
		magField = u * current / 2 * Math.PI * MAG_FIELD_RADIUS;
	}
	
	private void calcElectricField() {
		calcMagneticField(); //Calculates the strength of the magnetic field
		
		double k = 9 * Math.pow(10, 9);
		elecField = k * charge / Math.pow(distance, 2);
	}
	
	/**
	 * Method that calculates the Lorentz force
	 */
	public void calcLorentzForce() {
		calcElectricField(); //Calculates the strength of the electric field
		
		lorentzForce = charge * (elecField + (velocity * magField));
	}
}
