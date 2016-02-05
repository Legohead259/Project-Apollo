package converters;

/**
 * Mass converter class for the Apollo Targeting Interface
 * @author Duffy
 *
 */
public class MassConverter {
	
	
	//*****START TO IMPERIAL MASS CONVERSIONS*****
	
	/**
	 * Method that converts a value to ounces (oz)
	 * 
	 * @Prerequisite value must be a measure of mass
	 * 
	 * @param value the value of the mass
	 * @param unit the unit the value is in
	 * @return the new value in oz
	 */
	public double convertToOunces(double value, String unit) {		
		double ounces = 0;
		
		//***Start imperial to imperial conversions***
		
		if (unit.contains("ton")) {
			ounces = (value * 16); //Converts pounds to ounces
			return ounces * 2000; //Converts tons to ounces
		}
		
		else if (unit.contains("pound") || unit.equalsIgnoreCase("lb")) {
			ounces = value * 16; //Converts pounds to ounces
			return ounces;
		}
		
		else if (unit.contains("ounce") || unit.equalsIgnoreCase("oz")) {
			return value;
		}
		
		//***End imperial to imperial conversions***
		
		//***Start metric to imperial conversions***
		
		else if (unit.equalsIgnoreCase("gram") || unit.equalsIgnoreCase("grams") || unit.equalsIgnoreCase("g")) {
			ounces = value * .0353; //Converts grams to ounces
			return ounces;
		}
		
		else if (unit.contains("kilo") || unit.equalsIgnoreCase("kg")) {
			ounces = value * 35.274; //Converts kilograms to ounces
			return ounces;
		}
		
		else {
			return ounces;
		}
		
		//**End metric to imperial conversions***
	}
	
	/**
	 * Method that converts a value to pounds (lbs)
	 * 
	 * @Prerequisite value must be a measure of mass
	 * 
	 * @param value the value of the mass
	 * @param unit the unit the value is in
	 * @return the new value in lbs
	 */
	public double convertToPounds(double value, String unit) {
		double pounds = convertToOunces(value, unit) / 16; //Converts value to pounds
		return pounds;
	}
	
	public double convertToTons(double value, String unit) {
		double tons = convertToPounds(value, unit) / 2000;
		return tons;
	}
	
	
	//*****END TO IMPERIAL MASS CONVERSIONS*****
	
	
	//*****START TO METRIC MASS CONVERSIONS*****
	
	
	/**
	 * Method that converts a value to grams (g)
	 * 
	 * @Prerequisite value must be a measure of mass
	 * 
	 * @param value the value of the mass
	 * @param unit the unit the value is in
	 * @return the new value in g
	 */
	public static double convertToGrams(double value, String unit) {
		double grams = 0;
		
		//***Start imperial to metric conversions***
		
		if (unit.contains("ounce") || unit.equalsIgnoreCase("oz")) {
			grams = value / .0353;
			return grams;
		}
		
		else if (unit.contains("pound") || unit.equalsIgnoreCase("lbs")) {
			grams = value * 453.592; //Converts pounds to grams
			return grams;
		}
		
		//***End imperial to metric conversions***
		
		//***Start metric to metric conversions***
		
		else if (unit.contains("kilo") || unit.equalsIgnoreCase("kg")) {
			grams = value * 1000; //Converts kilograms to grams
			return grams;
		}
		
		else if (unit.contains("ton")) {
			grams = value * 2000000; //Converts metric tons to grams
			return grams;
		}
		
		else if (unit.contains("grams") || unit.equalsIgnoreCase("g")) {
			return value;
		}
		
		else {
			return grams;
		}
		
		//***End metric to metric conversions***
	}
	
	/**
	 * Method that converts a value to kilograms (kg)
	 * 
	 * @Prerequisite value must be a measure of mass
	 * 
	 * @param value the value of the mass
	 * @param unit the unit the value is in
	 * @return the new value in kg
	 */
	public static double convertToKilograms(double value, String unit) {
		double kilograms = convertToGrams(value, unit) / 1000; //Converts value to kilograms
		return kilograms;
	}
	
	/**
	 * Method that converts a value to metric tons (mt)
	 * 
	 * @Prerequisite value must be a measure of mass
	 * 
	 * @param value the value of the mass
	 * @param unit the unit the value is in
	 * @return the new value in mt
	 */
	public double convertToMetricTons(double value, String unit) {
		double metricTons = convertToKilograms(value, unit) / 2000; //Converts value to metric tons
		return metricTons;
	}
}
