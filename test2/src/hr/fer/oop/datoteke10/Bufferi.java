package hr.fer.oop.datoteke10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Bufferi {
	public static void main(String[] args) throws IOException {
		OutputStream oStream;
		InputStream iStream;
		byte[] b = new byte[1024];
		iStream = new FileInputStream(new File("/home/jurij/Desktop/tekst2.txt"));
		
		int x = iStream.read(b);
		System.out.println(x);
		iStream.close();
		for (byte c : b) {
			System.out.println(c);
		}
		oStream = new FileOutputStream(new File("/home/jurij/Desktop/novi_tekst.txt"));
		System.out.println("jesam");
		oStream.write(b, 0, x);
		oStream.write(b, 0, x);
		oStream.close();

	}
}
