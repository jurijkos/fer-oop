package hr.fer.oop.lab5.first;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * MyByteReader class find all files that ends with .txt and writes tham in new file.
 * It implements FileVisitor interface<Path>.
 * @author Jurij Kos
 *
 */
public class MyByteReader implements FileVisitor<Path> {
	/**Writes in this stream.*/
	private OutputStream oStream;
	/**Size of buffer.*/
	protected final int BUFFER_SIZE = 1024;
	/**Constructor. Wraps oStream in BufferedOutpuStream.*/
	public MyByteReader(OutputStream oStream) {
		this.oStream = new BufferedOutputStream(oStream);
	}
	
	
	
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		// TODO Auto-generated method stub
		return FileVisitResult.CONTINUE;
	}
	/**
	 * Checks if file ends with extension txt. and writes to file file.
	 * Invoked for visiting file.
	 */
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
		if (attrs.isRegularFile() && file.toFile().toString().endsWith(".txt")){
			try (InputStream iStream = new BufferedInputStream
					(new FileInputStream(file.toFile()));) {
				while (true){
					byte[] buffer = new byte[BUFFER_SIZE];
					int numOfBytes = iStream.read(buffer);
					if (numOfBytes < 0) break;
					oStream.write(buffer, 0, numOfBytes);
					
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		// TODO Auto-generated method stub
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		// TODO Auto-generated method stub
		return FileVisitResult.CONTINUE;
	}
	
}
