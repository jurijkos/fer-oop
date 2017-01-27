package hr.fer.oop.lab5.first;


import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Paths;


/**
 * Main program for the first task. Starting point of our program.
 * Creates object MyByteWriter and uses method run to write informations form one
 * file to another.
 * It runs method run  
 * @author Jurij Kos
 *
 */
public class SingleFileProgram {
	/**
	 * Starting point of program.
	 * 
	 */
	public static void main(String[] args) {
		try(InputStream iStream = new FileInputStream("racuni3/2015/1/Racun_0.txt");) {
			MyByteWriter myByteWriter = new MyByteWriter(iStream, Paths.get("singleout.txt"));
			myByteWriter.run();	
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	


}
