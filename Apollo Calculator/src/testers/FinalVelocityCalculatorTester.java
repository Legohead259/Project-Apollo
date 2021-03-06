package testers;

import java.io.PrintStream;

import calculators.ImpactVariablesCalculator;
import converters.MassConverter;
import converters.VelocityConverter;

public class FinalVelocityCalculatorTester {
	static double massKg = MassConverter.convertToKilograms(.196, "lbs");
	static ImpactVariablesCalculator ivc = new ImpactVariablesCalculator(29.54, 5.67, 5.21, massKg);
	static PrintStream out = System.out;
	
	public static void main(String args[]) {
		testFinalVeloCalc(ivc);
	}
	
	private static void testFinalVeloCalc(ImpactVariablesCalculator ivc) {
		ivc.calcAll();
		
		out.println(ivc.impactVelo + " m/s");
		out.println(VelocityConverter.convertToFPS(ivc.impactVelo, "m/s") + " ft/s");
		out.println(ivc.impactAngle + " degrees");
		out.println(ivc.impactForce + " N");
		out.println(ivc.impactEnergy + " J");
	}
}
