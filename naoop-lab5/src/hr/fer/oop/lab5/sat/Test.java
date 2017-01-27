package hr.fer.oop.lab5.sat;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		String text = "račun br. 146936";
		//System.out.println(text.substring(90, 95) + "kraj");
		//int x = Integer.parseInt(text.substring(9,16).trim());
		System.out.println(text.substring(9,16));
		int x = Integer.parseInt("  15  ".trim());
		System.out.println(x);
		HashSet<String> set = new HashSet<>();
		set.add("majmun");
		set.add("trcanje");
		set.add("skok");
		List<String> fruitList = new ArrayList<String>(set);
		Collections.sort(fruitList);

		
		for (String string : set) {
			System.out.println(string);
		}
		for (String string : fruitList) {
			System.out.println(string);
		}
	}
}
