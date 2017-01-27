package hr.fer.oop.lab4.prob1;



/**
 * Class represents geometric figure Rectangle.
 * @author Jurij Kos
 *
 */
public class Rectangle extends GeometricBody {
	/**Width of rectangles base. */
	private int width;
	/**Width of rectangles base.*/
	private int height;
	/**X-axis coordinate of top-left point.*/
	private int cordinateX;
	/**X-axis coordinate of top-left point.*/
	private int cordinateY;
	
	/**
	 * Constructor with all values send. All values must be positive.
	 * 
	 * @param width width of Rectangle
	 * @param height height of Rectangle
	 * @param cordinateX x-axis coordinates of top left point.
	 * @param cordinateY y-axis coordinates of top left point.
	 */
	public Rectangle(int width, int height, int cordinateX, int cordinateY) {
		if (width <= 0){
			throw new IllegalArgumentException("Illegal arguments "
					+ "for width of rectangle.");
		}
		else if (height <= 0){
			throw new IllegalArgumentException("Illegal arguments "
					+ "for height of rectangle.");
		}
		this.width = width;
		this.height = height;
		this.cordinateX = cordinateX;
		this.cordinateY = cordinateY;
	}
	/**
	 * Creates object that is the same as the on it got in constructor.
	 * @param aRectangle
	 */
	public Rectangle(Rectangle aRectangle) {
		this.width = aRectangle.width;
		this.height = aRectangle.height;
		this.cordinateX = aRectangle.cordinateX;
		this.cordinateY = aRectangle.cordinateY;
	}
	
	@Override
	public boolean hasPoint(int x, int y) {
		if (y < cordinateY || y > cordinateY + height)
			return false;
		else if (x < cordinateX || x > cordinateX + width)
			return false;
		return true;	
		
	}
	/**
	 * Returns x-axis coordinate of points  on top edge. 
	 * 
	 */
	public int getCordinateX() {
		return cordinateX;
	}
	/**
	 * Returns y-axis coordinate of the points on left-edge.
	 * 
	 */
	public int getCordinateY() {
		return cordinateY;
	}
	/**
	 * Returns height of the rectangle.
	 * 
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * 
	 * @return width of rectangle.
	 */
	public int getWidth() {
		return width;
	}

    
}
