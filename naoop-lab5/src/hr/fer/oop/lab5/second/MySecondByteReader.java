package hr.fer.oop.lab5.second;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collection;
import java.util.TreeSet;

/**
 * Class for reading all articles and writing them in one file.
 * Uses Writer and Reader so we can work directly with Strings.
 * @author Jurij Kos
 *
 */
public class MySecondByteReader implements FileVisitor<Path> {
	/**Collection for all articles.*/
	private Collection<Artikl> collection;
	/**Used for  writing in new file.*/
	private OutputStream oStream;
	/**Represents charset we are working with.*/
	private String charset;
	
	
	/**
	 * Initializzing object ob MySecondByteReader.
	 * @param oStream reference to output strem.
	 * @param charset charset used for output file.
	 */
	public MySecondByteReader(OutputStream oStream, String charset) {
		collection = new TreeSet<>();
		this.oStream = oStream;
		this.charset = charset;	
	}
	
	/**
	 * Writes all articles from collection to the outputStream.
	 */
	public void writeArticles () {
		try (BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(oStream, charset));) {
			for (Artikl artikl : collection) {
				bWriter.write(artikl.toString());
			}
		} catch (Exception e) {
			//e.printStackTrace();
			System.err.println("write articles");
		}
	}
	
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		// TODO Auto-generated method stub
		return FileVisitResult.CONTINUE;
	}
	/**
	 * Functions awaken when file is visited. Reads line by line from file.
	 * If line represents Artikl creates object Artikl and adds it to the
	 * collection. 
	 */
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
		String line;
		if (attrs.isRegularFile() && file.toFile().toString().endsWith(".txt")){
			try (BufferedReader bReader = new BufferedReader(new InputStreamReader(
					new FileInputStream(file.toFile()),"UTF-8"));) {
				while(true){
					line = bReader.readLine();
					if (line.equals(""))
						continue;
					else if (line.substring(0, 5).equals("Kupac"))
						continue;
					else if (line.substring(0, 6).equals("UKUPNO")) 
						break;
					else if(line.substring(0, 5).equals("Račun") ||  line.substring(0, 3).equals("---") 
							|| line.substring(0, 8).equals("Proizvod") 
							|| line.substring(0, 3).equals("   "))
						continue;
					Artikl artikl = new Artikl(line.substring(0, 80), 
							Double.parseDouble(line.substring(80,90)));
					collection.add(artikl);

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
