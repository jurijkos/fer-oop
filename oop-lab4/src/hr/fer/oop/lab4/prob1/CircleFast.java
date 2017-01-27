package hr.fer.oop.lab4.prob1;

import hr.fer.oop.lab4.pic.Picture;
/**
 * Class that extends class Circle. It enables faster drawing of circle.
 * @author Jurij Kos
 *
 */
public class CircleFast extends Circle {
	/**
	 * Creates object of CircleFast with gotten parameters.
	 * radius must be positive number.  
	 * @param centerX
	 * @param centerY
	 * @param radius
	 */
	public CircleFast(int centerX, int centerY ,int radius) {
		super(centerX, centerY, radius);
	}
	
	public CircleFast(CircleFast aFast) {
		super(aFast);
	}
	@Override
	public void drawOnPicture(Picture picture) {
		
		for (int i = getCenterY() - getRadius(); i < getCenterY() + getRadius(); i++) {
			double circlePoint = Math.pow(getRadius(), 2) - Math.pow(i - getCenterY(),2);
			circlePoint = Math.sqrt(circlePoint);
			int xStart = getCenterX() - (int)circlePoint;
			int xEnd = getCenterX() + (int)circlePoint;
			if (xStart < 0)
				xStart = 0;
			if (xEnd >= picture.getWidth())
				xEnd = picture.getWidth() - 1;
			if (i < picture. getHeight() && i >= 0 && xStart < xEnd )
				picture.drawLine(xStart , xEnd, i);
		}
	}
}
