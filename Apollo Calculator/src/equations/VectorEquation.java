package equations;

public class VectorEquation {
	double angle, angleRadians, magnitude;
	public double vertComponent, horizComponent;
	
	public VectorEquation(double a, double m) {
		angle = a; angleRadians = Math.toRadians(a); magnitude = m;
	}
	
	public void calcVertComponent() {
		vertComponent = magnitude * Math.sin(angleRadians);
	}
	
	public void calcHorizComponenet() {
		horizComponent = magnitude * Math.cos(angleRadians);
	}
}
