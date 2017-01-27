package hr.fer.oop.lab4.prob1;

import hr.fer.oop.lab4.pic.Picture;
import hr.fer.oop.lab4.pic.PictureDisplay;
/**
 * This class is used 
 * @author Jurij Kos
 *
 */
public class Demonstration {
	public static void main(String[] args) {
	/*	
		final int M = 1;
		
		GeometricBody[] figures = new GeometricBody[] {
			new EquilateralTriangleFast(1250, 0 , 200),
			new EquilateralTriangle(1200, 500, 40),
			new CircleFast(30, 30, 50),
			new CircleFast(200, 250, 100),
			new Rectangle(100, 100, 200, 400),
			new RectangleFast( 300, 150, 500, 400),
			//new Rectangle(1300, 700, 0 , 0)
		};
		
		Picture pic = new Picture(1300,  750);
		for (GeometricBody figure : figures) {
			figure.drawOnPicture(pic);
		}
		pic.renderImageToStream(System.out);
		PictureDisplay.showPicture(pic);
	*/
		GeometricBody[] figures = new GeometricBody[] {
				//new EquilateralTriangleFast(20, 0 , 30),
				//new EquilateralTriangle(12, 16, 15),
				new CircleFast(30, 30, 20),
				new CircleFast(90, 40, 10),
				new Rectangle(10, 10, 70, 5),
				//new RectangleFast( 300, 150, 500, 400),
				//new Rectangle(1300, 700, 0 , 0)
			};
			
			Picture pic = new Picture(100,  50);
			for (GeometricBody figure : figures) {
				figure.drawOnPicture(pic);
			}
			pic.renderImageToStream(System.out);
			PictureDisplay.showPicture(pic);
	}
	
	
}
