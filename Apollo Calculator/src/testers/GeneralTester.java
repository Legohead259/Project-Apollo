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

public class GeneralTester {
	static double lengthMeters = LengthConverter.convertToMeters(20, "in");
	static double massKg = MassConverter.convertToKilograms(.196, "lbs");
	
	static Railgun r = new Railgun(lengthMeters); //Makes a new Railgun object
	static Projectile p = new Projectile(2, .098, 1, 120, r); //Makes a new Projectile object
	
	static PrintStream out = System.out;
	
	public static void main(String[] args) {
		simulate();
	}
		
	
	//*****START SIMULATION*****
	
	
	private static void simulate() {
		calcProjectileVariables(); calcRange(); 
	}
	
	
	//*****START PROJECTILE CALCULATIONS*****
	
	
	private static void calcProjectileVariables() {
		p.calcMuzzleVelocity();
		
		out.println("Muzzle Velocity: " + p.muzzleVelocity + " m/s"); //Prints projectile's muzzle velocity in m/s
		out.println("Muzzle Velocity: " + VelocityConverter.convertToFPS(p.muzzleVelocity, "m/s") + " ft/s"); //Prints projectile's muzzle velocity in ft/s
		out.println("Time in Barrel: " + p.barrelTravelTime + " seconds");
		out.println();
	}
	
	
	//*****START RANGE CALCULATIONS*****
	
	
	private static void calcRange() {
		RangeCalculator rc = new RangeCalculator(p.muzzleVelocity, 30); rc.calcRange();
		
		out.println("Range: " + rc.range + " m"); //Prints range in meters
		out.println("Time of flight: " + rc.time + " s"); // Prints time of flight in s
		out.println("Trajectory formula: " + rc.trajectoryFormula);
		out.println();
		
		calcImpactVariables(rc.initVertVelo, rc.time, rc.horizVelo);
	}
	
	
	//*****START IMPACT CALCULATIONS*****
	
	
	private static void calcImpactVariables(double initVertVelo, double t, double hVelo) {
		ImpactVariablesCalculator ivc = new ImpactVariablesCalculator(initVertVelo, t, hVelo, massKg ); ivc.calcAll();
		
		out.println("Impact angle: " + ivc.veloAngle + " degrees");
		out.println("Impact velocity: " + ivc.finalVelo + " m/s"); //Prints impact velocity in m/s
		out.println("Impact velocity: " + VelocityConverter.convertToFPS(ivc.finalVelo, "m/s") + " ft/s"); //Prints impact velocity in ft/s
		out.println("Impact energy: " + ivc.kineticEnergy + " J"); //Prints impact energy in Joules
		out.println("Impact force: " + ivc.impactForce + " N"); //Prints impact force in Newtons
		out.println("Impact force: " + ForceConverter.convertToPoundsForce(ivc.impactForce, "N") + " lbf"); //Prints impact force in lbf
		out.println();
	}

}
