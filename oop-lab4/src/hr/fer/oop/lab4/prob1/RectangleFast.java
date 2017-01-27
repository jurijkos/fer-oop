package hr.fer.oop.lab4.prob1;

import hr.fer.oop.lab4.pic.Picture;
/**
 * This class enables faster drawing of rectangles than rectangle class.
 * @author Jurij Kos
 *
 */
public class RectangleFast extends Rectangle {
	/**
	 *Creates new RectangleFast object. 
	 * @param width It must be positive number.
	 * @param height It must be positive number.
	 */
	public RectangleFast(int width, int height, int cordinateX, int cordinateY) {
		super(width, height, cordinateX, cordinateY);
	}
	public RectangleFast(RectangleFast aFast) {
		super(aFast);
	}
	
	@Override
	public void drawOnPicture(Picture picture) {
		for (int i = this.getCordinateY(); i < this.getCordinateY() + this.getHeight(); i++) {
			int startX = getCordinateX();
			int endX = getCordinateX() + getWidth();
			if (startX < 0)
				startX = 0;
			if (endX >= picture.getWidth()) 
				endX = picture.getWidth() - 1;
			if (startX < endX && i >= 0 && i < picture.getHeight())
				picture.drawLine(getCordinateX(), getCordinateX() + getWidth(), i);
		}
	}
	
}
