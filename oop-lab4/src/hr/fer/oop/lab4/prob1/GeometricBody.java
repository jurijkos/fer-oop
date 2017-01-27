package hr.fer.oop.lab4.prob1;

import hr.fer.oop.lab4.pic.Picture;
/**
 * Abstract class represents abstract body.
 * 
 * @author Jurij Kos
 *
 */
public abstract class GeometricBody {
	/**
	 * hasPoint checks if Geometric Body has 
	 * point on that pixel so drawOnPicture method can paint point.
	 * Returns true if it pixel is in geometric body.
	 * @param x position of Point on the x-axis.
	 * @param y position of Point on the y-axis.
	 * @return true if it has point ,false if point is not inside geometric body.
	 */
	
	public abstract boolean hasPoint(int x, int y);
	
	/**
	 * Method draws on picture. It checks every point and  if it is in geometric body
	 * it turns pixel on.
	 *  
	 * @param picture Picture object on which draws figure. 
	 */
	public void drawOnPicture(Picture picture) {
		for (int i = 0; i < picture.getWidth(); i++) {
			for (int j = 0; j < picture.getHeight(); j++) {
				if (this.hasPoint(i, j))
					picture.turnPixelOn(i, j);
			}
		}
	}
}
