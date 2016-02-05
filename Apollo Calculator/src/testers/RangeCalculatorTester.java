package testers;

import calculators.RangeCalculator;
import converters.LengthConverter;
import objects.Projectile;
import objects.Railgun;

public class RangeCalculatorTester {
	static double lengthMeters = LengthConverter.convertToMeters(20, "in");
	
	static Railgun r = new Railgun(lengthMeters);
		
	static RangeCalculator rc0Elev = new RangeCalculator(10, 30);
	static Projectile p = new Projectile(2, .098, 1, 120, r); 
//	static RangeCalculator rcDiffElev = new RangeCalculator(90, 53, 25, 9);
//	static RangeCalculator rcDiffElev1 = new RangeCalculator(30, 80, 0, 10);

	public static void main(String[] args) {
		p.calcMuzzleVelocity(); //Calculates projectile's muzzle velocity
		
		RangeCalculator rc = new RangeCalculator(p.muzzleVelocity, 30);
		
		testRangeCalculator0Elev(rc);
		testRangeCalculator0Elev(rc0Elev);
//		testRangeCalculatorDiffElev();
//		testRangeCalculatorDiffElev();
	}
	
	private static void testRangeCalculator0Elev(RangeCalculator rc) {
		rc.calcRange();
		
		System.out.println(rc.range + " meters");
	}
	
//	private static void testRangeCalculatorDiffElev() {
//		rc.calcRangeDiffElev();
//		
//		System.out.println(rc.range);
//	}

}
