import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PictureMirroring {
	public static void main(String[] args) throws IOException {
		//int width = 963;
		//int height = 640;
		BufferedImage image1 = null;
		File file  = null;
		try {
			file = new File("/home/jurij/Pictures/download.jpg");
		    image1 = ImageIO.read(file);
		    //System.out.println("reading complete");
		}
		catch (IOException exception) {
			System.err.println("Error" + exception);
		}
		//Mirroring picture 
		int height = image1.getHeight();
		int width = image1.getWidth();
		BufferedImage image2 = new BufferedImage(width, height, 
				image1.getType());
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int pixel = image1.getRGB(j, i);
				image2.setRGB(width - j - 1, i, pixel);
			}
		}
		
		//write image
		try {
			file = new File("/home/jurij/Pictures/download2.jpg");
			ImageIO.write(image2, "jpg", file);
		} catch (Exception e) {
			System.err.println("Error: " + e);
		}
	}
}
