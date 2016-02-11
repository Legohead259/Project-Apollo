package converters;

/**
 * Converter class that converts values between units
 * @author Duffy
 *
 */
public class ForceConverter {
	
	/**
	 * Method that converts a value to Newtons of force
	 * @param value the value to be converted
	 * @param unit the unit being converted from
	 * @return the value in Newtons of force
	 */
	public static double convertToNewtons(double value, String unit) {
		double newtons = 0;
		
		if (unit.contains("pound") || unit.equalsIgnoreCase("lbf")) {
			newtons = value * 4.44822;
			return newtons;
		}
		
		else {
			return newtons;
		}
	}
	
	/**
	 * Method that converts a value to Pounds of force
	 * @param value the value to be converted
	 * @param unit the unit being converted from
	 * @return the value in Pounds of force
	 */
	public static double convertToPoundsForce(double value, String unit) {
		double lbf = 0;
		
		if (unit.contains("newton") || unit.equalsIgnoreCase("N")) {
			lbf = value / 4.44822;
			return lbf;
		}
		
		else {
			return lbf;
		}
	}
}
