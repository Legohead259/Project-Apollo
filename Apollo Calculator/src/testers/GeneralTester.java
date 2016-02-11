package testers;

import java.io.PrintStream;

import calculators.ImpactVariablesCalculator;
import calculators.RangeCalculator;
import converters.ForceConverter;
import converters.LengthConverter;
import converters.MassConverter;
import converters.VelocityConverter;
import objects.Projectile;
import objects.Railgun;
import util.Writer;

public class GeneralTester {
	static double lengthMeters = LengthConverter.convertToMeters(20, "in");
	static double massGrs = MassConverter.convertToGrains(.196, "lbs");
	
	static Railgun r = new Railgun(lengthMeters); //Makes a new Railgun object
	static Projectile p = new Projectile(2, .098, 1, 120, r); //Makes a new Projectile object
	
	static PrintStream out = System.out;
	
	static String pathHardDrive = "E:\\Project ZEUS\\Project APOLLO\\Output Test.txt";
	static String pathSchoolDrive = "H:\\My Documents\\Project Apollo\\Output Test.txt";
	static String[] names = {"Muzzle Velocity: ",  "Muzzle Velocity: ", "Muzzle Energy: ", "Acceleration: ", 
							 "Time in Barrel: ", "Range: ", "Time of Flight: ", "Impact Angle: ", "Impact Velocity: ",
							 "Impact Velocity: ", "Impact Energy: ", "Impact Force: ", "Impact Foce: "};
	
	static double muzzleVeloMPS, muzzleVeloFPS, muzzleEnergy, acceleration, barrelTravelTime;
	static double range, timeOfFlight; 
	static String trajectoryFormula;
	static double impactAngle, impactVeloMPS, impactVeloFPS, impactEnergy, impactForceN, impactForceLBS; 
	static double[] dataPoints = new double[13];
				  
	
	public static void main(String[] args) {
		simulate();
	}
		
	
	//*****START SIMULATION*****
	
	
	private static void simulate() {
		calcProjectileVariables(); calcRange(); createVariableArr(); 
		writeVariablesToFile(pathSchoolDrive, dataPoints, names, trajectoryFormula);
	}
	
	
	//*****START PROJECTILE CALCULATIONS*****
	
	
	private static void calcProjectileVariables() {
		p.calcAll();
		
		muzzleVeloMPS = p.muzzleVelocity; muzzleVeloFPS = VelocityConverter.convertToFPS(p.muzzleVelocity, "m/s");
		muzzleEnergy = p.muzzleEnergy; acceleration = p.acceleration; barrelTravelTime = p.barrelTravelTime;
		
		out.println("Muzzle Velocity: " + muzzleVeloMPS + " m/s"); //Prints projectile's muzzle velocity in m/s
		out.println("Muzzle Velocity: " + muzzleVeloFPS + " ft/s"); //Prints projectile's muzzle velocity in ft/s
		out.println("Muzzle Energy: " + muzzleEnergy + " J");
		out.println("Acceleration: " + acceleration + " m/s^2");
		out.println("Time in Barrel: " + barrelTravelTime + " seconds");
		out.println();
	}
	
	
	//*****START RANGE CALCULATIONS*****
	
	
	private static void calcRange() {
		RangeCalculator rc = new RangeCalculator(p.muzzleVelocity, 30); rc.calcRange();
		
		range = rc.range; timeOfFlight = rc.time; trajectoryFormula = rc.trajectoryFormula;
		
		out.println("Range: " + range + " m"); //Prints range in meters
		out.println("Time of flight: " + timeOfFlight + " s"); // Prints time of flight in s
		out.println("Trajectory formula: " + trajectoryFormula);
		out.println();
		
		calcImpactVariables(rc.initVertVelo, rc.time, rc.horizVelo);
	}
	
	
	//*****START IMPACT CALCULATIONS*****
	
	
	private static void calcImpactVariables(double initVertVelo, double t, double hVelo) {
		ImpactVariablesCalculator ivc = new ImpactVariablesCalculator(initVertVelo, t, hVelo, massGrs ); ivc.calcAll();
		
		impactAngle = ivc.impactAngle; impactVeloMPS = ivc.impactVelo; 
		impactVeloFPS = VelocityConverter.convertToFPS(ivc.impactVelo, "m/s"); impactEnergy = ivc.impactEnergy;
		impactForceN = ivc.impactForce; impactForceLBS = ForceConverter.convertToPoundsForce(ivc.impactForce, "N");
		
		out.println("Impact angle: " + impactAngle + " degrees");
		out.println("Impact velocity: " + impactVeloMPS + " m/s"); //Prints impact velocity in m/s
		out.println("Impact velocity: " + impactVeloFPS + " ft/s"); //Prints impact velocity in ft/s
		out.println("Impact energy: " + impactEnergy + " J"); //Prints impact energy in Joules
		out.println("Impact force: " + impactForceN + " N"); //Prints impact force in Newtons
		out.println("Impact force: " + impactForceLBS + " lbf"); //Prints impact force in lbf
		out.println();
	}
	
	
	//*****START WRITE TO FILE METHODS*****
	
	
	private static void createVariableArr() {
		dataPoints[0] = muzzleVeloMPS; dataPoints[1] = muzzleVeloFPS; dataPoints[2] = muzzleEnergy; 
		dataPoints[3] = acceleration; dataPoints[4] = barrelTravelTime; dataPoints[5] = range; dataPoints[6] = timeOfFlight;
		dataPoints[7] = impactAngle; dataPoints[8] = impactVeloMPS; dataPoints[9] = impactVeloFPS;
		dataPoints[10] = impactEnergy; dataPoints[11] = impactForceN; dataPoints[12] = impactForceLBS;
	}
	
	/**
	 * Method that writes given variables to a .txt file that will be created in the workspace
	 * @param path the path to the file
	 * @param arr the array of data
	 * @param names the names of the variables
	 * @param equation the equation for the projectile trajectory
	 */
	private static void writeVariablesToFile(String path, double[] arr, String[] names, String equation) {
		Writer writer = new Writer(path);
		int place = 0;
		
		for (int x = 0; x < arr.length; x++) {
			String name = names[place];
			double data = arr[x];
			
			writer.write(name); writer.write(data); writer.writeNewLine();
			
			if (name.equals("Time in Barrel: ")) {
				writer.writeNewLine();
			}
			
			if (name.equals("Time of Flight: ")) {
				writer.write("Trajectory Formula: " + equation); writer.skipLine(2);
			}
			
			place++;
		}
		writer.skipLine(2);
		writer.stop();
	}

}
