package testers;

import java.io.PrintStream;

import converters.LengthConverter;
import equations.AngleEquation;
import equations.DisplacementEquation;
import equations.LorentzForceEquation;

public class EquationTester {
	static double distMeters = LengthConverter.convertToMeters(20, "in"); 
	
	static PrintStream out = System.out;
	
	static AngleEquation AE = new AngleEquation(30, "angle", 8.83, "range");
	static DisplacementEquation DE = new DisplacementEquation(90 * Math.sin(Math.toRadians(53)), "velocity", 16, "displacement");
	static LorentzForceEquation LFE = new LorentzForceEquation(.00024, distMeters, 78.1, .013);
	
	public static void main(String[] args) {
//		calcAngleEquation();
//		calcDisplacementEquation();
		calcLorentzForce();
	}
	
	private static void calcAngleEquation() {
		AE.calcEquation();
		out.println("The " + AE.missing + " value of the equation is: " + AE.missingVal);
	}
	
	private static void calcDisplacementEquation() {
		DE.calcEquation();
		out.println();
		out.println(DE.quadFormula);
		out.println("The " + DE.missing + " value of the equation is: " + DE.missingVal);
	}
	
	private static void calcLorentzForce() {
		LFE.calcLorentzForce();
		out.println(LFE.lorentzForce);
	}
}
