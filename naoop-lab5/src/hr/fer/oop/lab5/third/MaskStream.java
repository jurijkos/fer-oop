package hr.fer.oop.lab5.third;


import java.io.IOException;
import java.io.OutputStream;

/**
 * Decorator for OutputStream. Encrypts data using xor with key.
 * @author Jurij Kos
 *
 */
public class MaskStream extends OutputStream {
	
	private OutputStream oStream;
	/**Key used for encryption*/
	private byte key;
	/**
	 * Constructor for our decorator.
	 * @param oStream Output stream we are writing in.
	 * @param key Key for encryption.
	 */
	public MaskStream(OutputStream oStream, byte key) {
		this.oStream = oStream;
		this.key = key;
	}
	@Override
	public void write(int b) throws IOException {
		oStream.write(b ^ key);
	}
	
}
