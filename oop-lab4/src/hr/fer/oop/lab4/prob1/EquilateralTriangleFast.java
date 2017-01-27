package hr.fer.oop.lab4.prob1;

import hr.fer.oop.lab4.pic.Picture;
/**
 * Extended class of EquilateralTriangle. It enables faster drawing of triuangle. 
 * @author Jurij Kos
 *
 */
public class EquilateralTriangleFast extends EquilateralTriangle {
	/**
	 * Creates new object and initializes values to parameters.
	 * 
	 * 
	 * @param sideLength Must be positive number.
	 */
	public EquilateralTriangleFast(int topX, int topY, int sideLength) {
		super(topX, topY, sideLength);
	}
	
	public EquilateralTriangleFast(EquilateralTriangleFast t) {
		super(t);
	}
	
	@Override
	public void drawOnPicture(Picture picture){
		int height = (int) (this.getSideLength() / 2 * Math.sqrt(3));
		
		for (int i = this.getTopY(); i < this.getTopY() + height; i++) {
			int space = (int) (Math.tan(Math.PI/6) * (i - this.getTopY()));
			int startX = this.getTopX() - space;
			int endX = this.getTopX() + space;
			if (startX < 0)
				startX = 0;
			if (endX >= picture.getWidth())
				endX = picture.getWidth() -1;
			if (i >= 0 && i < picture.getHeight() && startX < endX)
				picture.drawLine(startX, endX, i);
			
		}
	}

}
