package converters;

/**
 * Velocity converter class for the Apollo Targeting Interface
 * @author Braidan Duffy
 *
 */
public class VelocityConverter {
	
	
	//*****START TO IMPERIAL CONVERSIONS*****
	
	
	/**
	 * Method that converts a value to Feet per Second (fps)
	 * 
	 * @Prerequisite value must be a measurement of velocity
	 * 
	 * @param value the value of the velocity
	 * @param unit the unit the value is in
	 * @return new value in fps
	 */
	public static double convertToFPS(double value, String unit) {
		double fps = 0;
		
		//***Start imperial to imperial conversions***
		
		if (unit.contains("mile") || unit.equalsIgnoreCase("mph")) {
			fps = value * 1.4667; //Converts mph to fps
			return fps;
		}
		
		else if (unit.contains("feet") || unit.equalsIgnoreCase("fps")) {
			return value;
		}
		
		//***End imperial to imperial conversions***
		
		//***Start metric to imperial conversion***
		
		else if (unit.contains("kilometer") || unit.equalsIgnoreCase("km/h") || unit.equalsIgnoreCase("kph")) {
			fps = value * .911344; //Converts km/h to fps
			return fps;
		}
		
		else if (unit.contains("meter") || unit.equals("m/s") || unit.equalsIgnoreCase("mps")) {
			fps = value * 3.6; //Converts m/s to fps
			return fps;
		}
		
		else if (unit.contains("knot") || unit.equalsIgnoreCase("kn")) {
			fps = value * 1.852; //Converts kn to fps
			return fps;
		}
		
		else {
			return fps;
		}
	}
	
	/**
	 * Method that converts a value to Miles per Hour (mph)
	 * 
	 * @Prerequisite value must be a measurement of velocity
	 * 
	 * @param value the value of the velocity
	 * @param unit the unit the value is in
	 * @return new value in mph
	 */
	public double convertToMPH(double value, String unit) {
		double mph = convertToFPS(value, unit) / 1.4667; //Converts value to mph
		return mph;
	}
	
	
	//*****END TO IMPERIAL CONVERSIONS*****
	
	
	//*****START TO METRIC CONVERSIONS*****
	
	
	/**
	 * Method that converts a value to Meters per Second (m/s)
	 * 
	 * @Prerequisite value must be a measurement of velocity
	 * 
	 * @param value the value of the velocity
	 * @param unit the unit the value is in
	 * @return new value in m/s
	 */
	public static double convertToMPS(double value, String unit) {
		double mps = 0;
		
		//***Start imperial to metric conversions***
		
		if (unit.contains("feet") || unit.equalsIgnoreCase("fps")) {
			mps = value / 3.6; //Converts fps to m/s
			return mps;
		}
		
		else if (unit.contains("mile") || unit.equalsIgnoreCase("mph")) {
			mps = value * .44704; //Converts mph to m/s
			return mps;
		}
		
		//***End imperial to metric conversions***
		
		//***Start metric to metric conversions***
		
		else if (unit.contains("kilometer") || unit.equalsIgnoreCase("km/h") || unit.equalsIgnoreCase("kph")) {
			mps = value * .277778; //Converts km/h to m/s
			return mps;
		}
		
		else if (unit.contains("meter") || unit.equalsIgnoreCase("m/s") || unit.equalsIgnoreCase("mps")) {
			return value;
		}
		
		else if (unit.contains("kn")) {
			mps = value * 514444; //Converts kn to m/s
			return mps;
		}
		
		else {
			return mps;
		}
		
		//***End metric to metric conversions***
	}
	
	
	//*****END TO METRIC CONVERSIONS*****
}
