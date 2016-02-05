package equations;

/**
 * QuadraticEquation class for the Apollo Targeting Interface
 * @author Braidan Duffy
 *
 */
public class QuadraticEquation {
	public double a, b, c, discriminant;
	public double solution;
	
	/**
	 * Constructor for the Quadratic Equation
	 * @param a the a value of the quadratic formula
	 * @param b the b value of the quadratic formula
	 * @param c the c value of the quadratic formula
	 */
	public QuadraticEquation(double a, double b, double c) {
		this.a = a; this.b = b; this.c = c;
	}
	
	/**
	 * Method that calculates the maximum solution of the quadratic formula
	 */
	public void calcQuadraticEquation() {
		calcDiscriminant();
		
		double xPlus = -b + Math.sqrt(discriminant);
		xPlus /= 2 * a; //Calculates the +Radical
		
		double xMinus = -b - Math.sqrt(discriminant);
		xMinus /= 2 * a; //Calculates the -Radical
		
		if (xPlus > xMinus && xPlus > 0) {
			solution = xPlus;
		}
		
		else if (xMinus > xPlus && xMinus > 0) {
			solution = xMinus;
		}
		
		else {
			solution = -1;
		}
	}
	
	/**
	 * Method that calculates the discriminant of the quadratic formula
	 */
	public void calcDiscriminant() {
		double bSqrd = Math.pow(b, 2); //Squares b
		discriminant = bSqrd - 4 * a * c;
	}
}
