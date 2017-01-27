package hr.fer.oop.lab5.first;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;

/**
 *Object that represents this class writes information from InputStream 
 *to the file that is given with varibale Path. 
 * @author Jurij Kos
 *
 */
public class MyByteWriter {
	/**For reading input information.*/
	protected InputStream iStream;
	/**Writing in this file data read from iStream.*/
	protected Path path;
	/**Number of bytes used for reading in one step.*/
	protected final int SIZE_OF_BUFFER = 1024;
	
	/**
	 * Only constructor for objects of this class.
	 * @param iStream Reference to inputStream.
	 * @param path Path to file for writing informations in.
	 */
	public MyByteWriter(InputStream iStream, Path path) {
		this.iStream = iStream;
		this.path = path;
	}
	/**
	 * Running this method on our object does all the job.
	 * It creates Object for OutputStram from path. I am using BufferedStreams
	 * because of big size that is read in one step.
	 */
	public void run() {
		 try (BufferedInputStream bStream = new BufferedInputStream(iStream);
				   OutputStream oStream = new BufferedOutputStream(new FileOutputStream(path.toFile()));){
		
						 
		
		byte[] buffer = new byte[SIZE_OF_BUFFER];
		while (true) {
			
			int hasMore = bStream.read(buffer);
			if (hasMore == -1)
				break;
			oStream.write(buffer, 0, hasMore);
			
		}

		 }
		 catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
