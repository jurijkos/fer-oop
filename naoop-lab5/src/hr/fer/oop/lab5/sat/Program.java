package hr.fer.oop.lab5.sat;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



public class Program {
	public static void main(String[] args) {
		//Path output = Paths.get("nasatu.txt");
		Path inputDir = Paths.get("racuni3");
		//OutputStream oStream;

		try {
			//Files.deleteIfExists(output);
			//Files.createFile(output);
			//oStream = new FileOutputStream(output.toFile());
			MyFileVisitor visitor = new MyFileVisitor();
			Files.walkFileTree(inputDir, visitor);
			visitor.ispisiNajveceRacune();
			//oStream.close();

		} catch (IOException e) {
			//e.printStackTrace();
			System.err.println("main");
			
		}

	}
}

