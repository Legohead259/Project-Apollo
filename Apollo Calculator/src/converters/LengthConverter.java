package converters;

/**
 * Length converter class for the Apollo Targeting Interface
 * @author Braidan Duffy
 *
 */
public class LengthConverter {
	
	
	//*****START TO IMPERIAL LENGTH CONVERSIONS*****
	
	/**
	 * Method that converts a value into inches (in)
	 * 
	 * @Precondition value must be a length measurement
	 * 
	 * @param value the value of the measurement
	 * @param unit the unit the value is in
	 * @return the new value in in
	 */
	public double convertToInches(double value, String unit) {
		double inches = 0;
		
		//***Start imperial to imperial conversions***
		
		if (unit.equalsIgnoreCase("feet") || unit.equalsIgnoreCase("foot") || unit.equalsIgnoreCase("ft")) {
			inches = value * 12; //Converts to inches
			return inches;
		}
		
		else if (unit.contains("mile") || unit.equalsIgnoreCase("mi")) {
			inches = value * 5280; //Convert to feet
			inches *= 12; //Convert to inches
			return inches;
		}
		
		//***End imperial to imperial conversions***
		
		//***Start metric to imperial conversions***
		
		if (unit.contains("millimeter") || unit.equalsIgnoreCase("mm")) {
			inches = value / 10; //Converts to centimeters
			inches /= 2.54; //Converts to inches
			return inches;
		}
		
		else if (unit.contains("centimeter") || unit.equalsIgnoreCase("cm")) {
			inches = value / 2.54; //Converts to inches
			return inches;
		}
		
		else if (unit.contains("kilometer") || unit.equalsIgnoreCase("km")) {
			inches = value / 1000; //Converts to centimeters
			inches /= 2.54; //Converts to inches
			return inches;
		}
				
		else {
			return -1;
		}
		
		//***End metric to imperial conversions***
	}
	
	/**
	 * Method that converts a value into feet (ft)
	 * 
	 * @Precondition value must be a length measurement
	 * 
	 * @param value the value of the measurement
	 * @param unit the unit the value is in
	 * @return the new value in ft
	 */
	public double convertToFeet(double value, String unit) {
		double feet = convertToInches(value, unit) * 12; //Converts to feet
		return feet;
	}
	
	/**
	 * Method that converts a value into miles (mi)
	 * 
	 * @Precondition value must be a length measurement
	 * 
	 * @param value the value of the measurement
	 * @param unit the unit the value is in
	 * @return the new value in mi
	 */
	public double convertToMiles(double value, String unit) {
		double miles = convertToFeet(value, unit) / 5280; //Converts to miles
		return miles;
	}
	
	
	//*****END TO IMPERIAL LENGTH CONVERSIONS*****
	
	
	//*****START TO METRIC LENGTH CONVERSIONS*****
	
	
	/**
	 * Method that converts a value into millimeters (mm)
	 * 
	 * @Precondition value must be a length measurement
	 * 
	 * @param value the value of the measurement
	 * @param unit the unit the value is in
	 * @return the new value in mm
	 */
	public double convertToMillimeters(double value, String unit) {
		double millimeters = convertToCentimeters(value, unit) * 10;
		return millimeters;
	}
	
	/**
	 * Method that converts a value into centimeters (cm)
	 * 
	 * @Precondition value must be a length measurement
	 * 
	 * @param value the value of the measurement
	 * @param unit the unit the value is in
	 * @return the new value in cm
	 */
	public static double convertToCentimeters(double value, String unit) {
		double centimeters = 0;
		
		//***Start imperial to metric conversions***
		
		if (unit.contains("inch") || unit.equalsIgnoreCase("in")) {
			centimeters = value * 2.54; //Converts to centimeters
			return centimeters;
		}
		
		else if (unit.equalsIgnoreCase("feet") || unit.equalsIgnoreCase("foot") || unit.equalsIgnoreCase("ft")) {
			centimeters = value / 12; //Converts to inches
			centimeters /= 2.54; //Converts to centimeters
			return centimeters;
		}
		
		else if (unit.contains("mile") || unit.equalsIgnoreCase("mi")) {
			centimeters = value / 5280; //Converts to feet
			centimeters /= 12; //Converts to inches
			centimeters *= 2.54; //Converts to centimeters
			return centimeters;
		}
		
		//***End imperial to metric conversions***
		
		//***Start metric to metric conversions***
		
		else if (unit.contains("millimeter") || unit.equalsIgnoreCase("mm")) {
			centimeters = value * 10; //Converts to centimeters
			return centimeters;
		}
		
		else if (unit.contains("meter") || unit.equalsIgnoreCase("m")) {
			centimeters = value / 100; //Converts to centimeters
			return centimeters;
		}
		
		else if (unit.contains("kilometer") || unit.equalsIgnoreCase("km")) {
			centimeters = value / 1000; //Converts to meters
			centimeters /= 100; //Converts to centimeters
			return centimeters;
		}
		
		else {
			return -1;
		}
	}
	
	/**
	 * Method that converts a value into meters (m)
	 * 
	 * @Precondition value must be a length measurement
	 * 
	 * @param value the value of the measurement
	 * @param unit the unit the value is in
	 * @return the new value in m
	 */
	public static double convertToMeters(double value, String unit) {
		double meters = convertToCentimeters(value, unit) / 100; //Converts to meters
		return meters;
	}
	
	/**
	 * Method that converts a value into kilometers (km)
	 * 
	 * @Precondition value must be a length measurement
	 * 
	 * @param value the value of the measurement
	 * @param unit the unit the value is in
	 * @return the new value in km
	 */
	public double convertToKilometers(double value, String unit) {
		double kilometers = convertToMeters(value, unit) / 1000; //Converts to kilometers
		return kilometers;
	}
	
	
	//*****END TO METRIC LENGTH CONVERSIONS*****
}
