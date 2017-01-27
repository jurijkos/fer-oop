package hr.fer.oop.lab5.third;

import static org.junit.Assert.*;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * Class for testing Mask class.
 * @author Jurij Kos
 *
 */
public class MaskTest {
	
	private Path path1, path2;
	@Before
	public void setUp() {
		path1 = Paths.get("zad3/startFile.txt");
		path2 = Paths.get("zad3/decodedFile.txt");
	}
	@After
	public void tearDown() {
		path1 = null;
		path2 = null;
	}
	

	@Test
	public void sizesEqual() {
		try {
			assertEquals(Files.size(path1),Files.size(path2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void linesEqual() {
		try {
			List<String> first = Files.readAllLines(path1);
			List<String> second = Files.readAllLines(path2);
			assertEquals(first, second);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
