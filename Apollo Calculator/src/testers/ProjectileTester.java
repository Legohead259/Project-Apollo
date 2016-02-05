package testers;

import java.io.PrintStream;

import objects.Projectile;
import objects.Railgun;

public class ProjectileTester {
	static Railgun r = new Railgun(1.6);
	static Projectile p = new Projectile(1, 2, 120, r);
	
	static PrintStream out = System.out;
	
	public static void main(String args[]) {
		testProjectile(p);
	}
	
	private static void testProjectile(Projectile p) {
		p.calcMuzzleVelocity();
		
		out.println(p.acceleration + " m/s^2");
		out.println(p.barrelTravelTime + " s");
		out.println(p.muzzleVelocity + " m/s");
	}
}
