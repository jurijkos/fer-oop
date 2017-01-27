package hr.fer.oop.lab5.third;


import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;


/**
 * Contains main method of program. It encryptes startFile  in codedFile. 
 * Than it decrypts codedFile into decodefFile.
 * @author Jurij Kos
 *
 */
public class Program {

	public static void main(String[] args) {
		Path startFIle = Paths.get("zad3/startFile.txt");
		Path codedFile = Paths.get("zad3/codedFile.txt");
		Path decodedFile = Paths.get("zad3/decodedFile.txt");
		Random random = new Random();
		byte key = (byte) random.nextInt(256);
		try (InputStream iStart = new FileInputStream(startFIle.toFile());
				InputStream iCoded = new FileInputStream(codedFile.toFile())) {
			MyCriptByteWriter mWriter1 = new MyCriptByteWriter(iStart, codedFile, key);
			mWriter1.run();
			MyCriptByteWriter mWriter2 = new MyCriptByteWriter(iCoded, decodedFile, key);
			mWriter2.run();
			System.out.println("Key: " + key);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
