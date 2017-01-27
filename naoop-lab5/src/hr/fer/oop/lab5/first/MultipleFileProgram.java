package hr.fer.oop.lab5.first;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * Starting point of the second part of first program.
 * Writes to output file all data from .txt files inside inputDir.
 * @author Jurij Kos
 *
 */
public class MultipleFileProgram {
	/**
	 * Uses MyByteReader  in walkFileTree method to walk around tree. 
	 * 
	 */
	public static void main(String[] args) {
		Path output = Paths.get("multipleout.txt");
		Path inputDir = Paths.get("racuni3");
		OutputStream oStream;
		FileVisitor<Path> visitor;
		try {
			Files.deleteIfExists(output);
			Files.createFile(output);
			oStream = new FileOutputStream(output.toFile());
			visitor = new MyByteReader(oStream);
			Files.walkFileTree(inputDir, visitor);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
}
