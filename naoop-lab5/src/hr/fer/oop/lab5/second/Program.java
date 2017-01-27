package hr.fer.oop.lab5.second;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * 
 * @author Jurij Kos
 *
 */

public class Program {
	/**
	 * Starting point of our second program. Finds all articles from
	 * input directory and adds them to the output file. 
	 * @param args
	 */
	public static void main(String[] args) {
		Path output1 = Paths.get("cjenik.utf8.txt");
		Path output2 = Paths.get("cjenik.88592.txt");
		Path inputDir = Paths.get("racuni3");
		OutputStream oStream;
		MySecondByteReader visitor1;
		MySecondByteReader visitor2;
		try {
			Files.deleteIfExists(output1);
			Files.createFile(output1);
			oStream = new FileOutputStream(output1.toFile());
			visitor1 = new MySecondByteReader(oStream, "UTF-8");
			Files.walkFileTree(inputDir, visitor1);
			visitor1.writeArticles();
			oStream.close();
			Files.deleteIfExists(output2);
			Files.createFile(output2);
			oStream = new FileOutputStream(output2.toFile());
			visitor2 = new MySecondByteReader(oStream,"ISO-8859-2");
			Files.walkFileTree(inputDir, visitor2);
			visitor2.writeArticles();
			oStream.close();
		} catch (IOException e) {
			//e.printStackTrace();
			System.err.println("main");
			
		}

	}
}
