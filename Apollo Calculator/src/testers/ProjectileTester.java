package testers;

import java.io.PrintStream;

import converters.MassConverter;
import objects.Projectile;
import objects.Railgun;

public class ProjectileTester {
	static Railgun r = new Railgun(1.6);
	static double massGrs = MassConverter.convertToGrains(.196, "lbs");
	static Projectile p = new Projectile(massGrs, 2, 120, r);
	
	static PrintStream out = System.out;
	
	public static void main(String args[]) {
		testProjectile(p);
	}
	
	private static void testProjectile(Projectile p) {
		p.calcAll();
		
		out.println(p.getAcceleration() + " m/s^2");
		out.println(p.getBarrelTravelTime() + " s");
		out.println(p.getMuzzleVelocity() + " m/s");
		out.println(p.getMuzzleEnergy() + " J");
	}
}
