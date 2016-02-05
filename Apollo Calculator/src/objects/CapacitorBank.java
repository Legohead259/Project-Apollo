package objects;

/**
 * Capacitor bank object for the Apollo Targeting Interface
 * @author Braidan Duffy
 *
 */
public class CapacitorBank {
	double voltage, capacitance, charge, energy;
	
	/**
	 * Constructor for the capacitor bank object
	 * 
	 * @Precondition capacitance must be in farads and voltage in volts
	 * 
	 * @param capac the capacitance of the capacitor bank
	 * @param volt the voltage of the capacitor bank
	 */
	public CapacitorBank(double capac, double volt) {
		voltage = volt; capacitance = capac;
	}
	
	/**
	 * Method that calculates the charge of the capacitor bank
	 * 
	 * @Postcondition capacitor charge is in Coulombs of charge
	 */
	public void calcCharge() {
		charge = capacitance * voltage;
	}
	
	/**
	 * Method that calculates the energy of the capacitor bank
	 * 
	 * @Postcondition capacitor energy is in Joules of energy
	 */
	public void calcEnergy () {
		calcCharge();
		energy = .5 * charge * voltage; 
	}
}
