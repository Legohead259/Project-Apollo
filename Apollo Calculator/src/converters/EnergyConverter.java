package converters;

/**
 * Energy converter class for the Apollo Targeting Interface
 * @author Braidan Duffy
 *
 */
public class EnergyConverter {
	
	/**
	 * Method that converts a value into Joules of energy (J)
	 * 
	 * @Precondition value must be in an energy unit
	 * 
	 * @param value the value of the energy
	 * @param unit the unit that value is in
	 * @return the value in J
	 */
	public double convertToJoules(double value, String unit) {
		double joules = 0;
		
		if (unit.contains("kilojoule") || unit.equalsIgnoreCase("kj")) {
			joules = value * 1000; //Converts kj to j
			return joules;
		}
		
		else if (unit.contains("megajoules") || unit.equalsIgnoreCase("mj")) {
			joules = value * 100000; //Converts mj to j
			return joules;
		}
		
		else if (unit.contains("joules") || unit.equalsIgnoreCase("j")) {
			return value;
		}
		
		else if (unit.contains("kilowatt") || unit.equalsIgnoreCase("kwh")) {
			joules = value * 3600000; //Converts kwh to j
			return joules;
		}
		
		else if (unit.contains("megawatt") || unit.equalsIgnoreCase("mwh")) {
			joules = value * (3.6 * Math.pow(10, 9)); //Converts mwh to j
			return joules;
		}
		
		else if (unit.contains("watt") || unit.equalsIgnoreCase("wh")) {
			joules = value * 3600; //Converts wh to j
			return joules;
		}
		
		else if (unit.contains("foot") || unit.equalsIgnoreCase("ft-lbs")) {
			joules = value * 1.35582; //Converts ft-lbs to j
			return joules;
		}
		
		else {
			return joules;
		}
	}
	
	/**
	 * Method that converts a value into KiloJoules of energy (KJ)
	 * 
	 * @Precondition value must be in an energy unit
	 * 
	 * @param value the value of the energy
	 * @param unit the unit that value is in
	 * @return the value in KJ
	 */
	public double convertToKilojoule(double value, String unit) {
		double kJoules = convertToJoules(value, unit) / 1000; //Converts value to kj
		return kJoules;
	}
	
	/**
	 * Method that converts a value into MegaJoules of energy (MJ)
	 * 
	 * @Precondition value must be in an energy unit
	 * 
	 * @param value the value of the energy
	 * @param unit the unit that value is in
	 * @return the value in MJ
	 */
	public double convertToMegajoules(double value, String unit) {
		double mJoules = convertToJoules(value, unit) / 1000000; //Converts value to mj
		return mJoules;
	}
	
	/**
	 * Method that converts a value into WattHours of energy (WH)
	 * 
	 * @Precondition value must be in an energy unit
	 * 
	 * @param value the value of the energy
	 * @param unit the unit that value is in
	 * @return the value in WH
	 */
	public double convertToWattHours(double value, String unit) {
		double wh = convertToJoules(value, unit) / 3600; //Converts value to wh
		return wh;
	}
	
	/**
	 * Method that converts a value into KilowattHours of energy (KwH)
	 * 
	 * @Precondition value must be in an energy unit
	 * 
	 * @param value the value of the energy
	 * @param unit the unit that value is in
	 * @return the value in KwH)
	 */
	public double convertToKilowattHours(double value, String unit) {
		double kwh = convertToJoules(value, unit) / 3600000; //Converts value to kwh
		return kwh;
	}
	
	/**
	 * Method that converts a value into MegawattHours of energy (MwH)
	 * 
	 * @Precondition value must be in an energy unit
	 * 
	 * @param value the value of the energy
	 * @param unit the unit that value is in
	 * @return the value in MwH
	 */
	public double convertToMegawattHours(double value, String unit) {
		double mwh = convertToJoules(value, unit) / (3.6 * Math.pow(10, 9)); //Converts value to mwh
		return mwh;
	}
	
	/**
	 * Method that converts a value into Foot-Pounds of force (ft-lbf)
	 * 
	 * @Precondition value must be in an energy unit
	 * 
	 * @Note ft-lbf is a measurement of kinetic energy
	 * 
	 * @param value the value of the energy
	 * @param unit the unit that value is in
	 * @return the value in ft-lbf
	 */
	public double convertToFootPounds(double value, String unit) {
		double ftlbs = convertToJoules(value, unit) / 1.35582; //Converts value to ft-lbs
		return ftlbs;
	}
}
