package mi_priprema.osnovno;

import java.io.File;
import java.io.IOException;
import java.io.LineNumberInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import javax.imageio.IIOException;
*/
public class Primitive {
	public static void main(String[] args) {
		/*String broj = "10.6";
		Double brojd = Double.parseDouble(broj);
		int ib = 60;
		System.out.println(brojd.intValue());
		System.out.println(Integer.highestOneBit(ib));
		System.out.println(broj.length());
		Scanner scanner = new Scanner(System.in);
		System.out.println(scanner.delimiter());
		Object objekt = new Object();
		objekt.toString();
		Class<String> class1 = String.class;
		class1.getMethod("length", String);
		//Poruka p1 = new Poruka("Hi!");
		//PorukaSCijenom p2 = new PorukaSCijenom("Hello!", 100.0);
		//Poruka p3 = new PorukaSCijenom("Ahoj!", 120.0);
		//System.out.println(((PorukaSCijenom)p3).getCijena());
		Integer integer = 10;
		Object object = integer;
		Float integer2 = (Float)integer.floatValue();
		System.out.println(integer2);
		int x = 10;
		float y = x;
		String jurij = String.format("%4$d %2$5.2f", x,y,10,20);
		System.out.println(jurij);
		Set<Integer> set = new HashSet<Integer>();
	

		
	}
			try{
				File file = new File("/home/jurij/Desktop/aha");
				System.out.println(file.exists());
				String[] polje = file.list();
				System.out.println(polje.length);
				for (String string : polje){
					System.out.println(string);
				}
				
			}
			catch (Exception e){
				System.out.println(e);
				//e.printStackTrace();
			}*/
		List<Integer> mySet = new LinkedList<>();
		mySet.add(10);
		mySet.add(104);
		mySet.add(6);
		mySet.add(0);
		mySet.add(10);
		for (Integer integer : mySet) {
			System.out.println(integer);
		}
		
	

	}
}
