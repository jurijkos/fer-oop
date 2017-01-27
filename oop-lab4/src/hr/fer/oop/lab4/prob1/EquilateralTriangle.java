package hr.fer.oop.lab4.prob1;
/**
 * Represents Equilateral triangle. Triangle has base parallel with
 * x-axis. 
 * @author Jurij Kos
 *
 */

public class EquilateralTriangle extends GeometricBody {
	/**X-axis coordinate of top highest point.*/
	private int topX;
	/**Y-axis coordinate of highest point. */
	private int topY;
	/**Length of triangles side.*/
	private int sideLength;
	/**
	 * Initializes object. sideLength must be positive number.
	 * @param topX x-axis coordinate from top of the triangle
	 * @param topY x-axis coordinate from top of the triangle
	 * @param sideLength length of side
	 */
	public EquilateralTriangle(int topX, int topY, int sideLength) {
		if (sideLength <= 0) {
			throw new IllegalArgumentException("Illegal velaue for sidelen "
					+ "of triangle");
			
		}
		this.topX = topX;
		this.topY = topY; 
		this.sideLength = sideLength;
	}
	/**
	 * Creates new object that has same properties as parameter aEquilateralTriangle
	 * @param aEquilateralTriangle
	 */
	public EquilateralTriangle (EquilateralTriangle aEquilateralTriangle) {
		this(aEquilateralTriangle.topX, 
				aEquilateralTriangle.topY, aEquilateralTriangle.sideLength);
	}
	@Override
	public boolean hasPoint(int x, int y) {
		int height = (int) (sideLength / 2 * Math.sqrt(3));
		if (y < topY || y > topY + height) 
			return false;
		int space = (int) (Math.tan(Math.PI/6) * (y - this.topY));
		if (x < topX - space || x > topX + space) 
			return false;
		return true;
	}
	
	/**
	 * 
	 * @return sideLength of triangle
	 */
	public int getSideLength() {
		return sideLength;
	}
	
	/**
	 * 
	 * @return x-axis coordinate of top-most point.
	 */
	public int getTopX() {
		return topX;
	}
	/**
	 * 
	 * @return y-axis coordinate of top-most point.
	 */
	public int getTopY() {
		return topY;
	}
}
