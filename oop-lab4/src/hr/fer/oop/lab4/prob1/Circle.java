package hr.fer.oop.lab4.prob1;
/**
 * Object of this class represents circle.
 * @author Jurij Kos
 *
 */
public class Circle extends GeometricBody {
	/**Value on x-axis of circles center.*/
	private int centerX;
	/**Value on y-axis of circles center.*/
	private int centerY;
	/**Radius of circle.*/
	private int radius;
	
	/**
	 * Creates object from received parameters. 
	 * @param centerX
	 * @param centerY
	 * @param radius
	 */
	public Circle(int centerX, int centerY ,int radius) {
		if (radius <= 0){
			throw new IllegalArgumentException("Radius of circle must be "
					+ "positive number.");
		}
		this.centerX = centerX;
		this.centerY = centerY;
		this.radius = radius;
	}
	
	/**
	 * Creates object  that is same to parameter. Copy-constructor.
	 * @param aCircle
	 */
	public Circle(Circle aCircle) {
		this(aCircle.centerX, aCircle.centerY, aCircle.radius);
	}
	
	@Override
	public boolean hasPoint(int x, int y) {
		double distanceOfPointSquared = Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2);
		if (distanceOfPointSquared - Math.pow(radius, 2) <= 1E-6)
			return true;
		return false;
	}
	
	public int getCenterX() {
		return centerX;
	}
	
	
	public int getCenterY() {
		return centerY;
	}
	
	
	
	public int getRadius() {
		return radius;
	}
}
