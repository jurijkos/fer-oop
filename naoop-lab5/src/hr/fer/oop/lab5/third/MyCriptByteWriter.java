package hr.fer.oop.lab5.third;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;

import hr.fer.oop.lab5.first.MyByteWriter;
/**
 * Class for encryption of file. It uses Mask Stream.
 * @author Jurij Kos
 *
 */
public class MyCriptByteWriter extends MyByteWriter {
	private byte key;
	public MyCriptByteWriter(InputStream iStream, Path path, byte key) {
		super(iStream, path);
		this.key = key;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run()  {
		try (BufferedInputStream bStream = new BufferedInputStream(iStream);
				   OutputStream oStream = new MaskStream((new FileOutputStream
						   (path.toFile())), key)/*(byte)random.nextInt(255))*/;) {
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
