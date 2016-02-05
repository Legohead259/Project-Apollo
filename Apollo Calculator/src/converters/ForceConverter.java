package converters;

public class ForceConverter {
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
