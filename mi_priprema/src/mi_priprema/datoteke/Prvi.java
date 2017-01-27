package mi_priprema.datoteke;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.omg.CORBA.StringHolder;


public class Prvi {
	public static void main(String[] args) {
		File file;
		
		file = new File("/home/jurij/Desktop");
		
		File[] polje = file.listFiles();
		for (File string : polje) {
			System.out.println(string);
		}
		System.out.println(polje[0].getAbsolutePath());
		//URI uri = new URI(str)
		System.out.println("jurij");
		Path path = file.toPath();
		
		//String jurij = "10.5";
		
	}

}
