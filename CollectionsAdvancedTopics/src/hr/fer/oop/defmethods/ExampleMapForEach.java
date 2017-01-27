package hr.fer.oop.defmethods;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class ExampleMapForEach {
	public static void main(String[] args) {
		ispisKlasican();
		
		Map<String, Integer> grades = createMap();
		grades.forEach(new BiConsumer<String, Integer>() {

			@Override
			public void accept(String t, Integer u) {
				System.out.println(t +" " + u);
				
			}
		});
		
		grades.forEach((k,v) -> System.out.println(k + " " + v));
	}
	
	public static void ispisKlasican() {
		Map<String, Integer> mapa = new HashMap<>();
		mapa.put("jurij", 100);
		mapa.put("marko", 50);
		mapa.put("matija", 200);
		mapa.put("janko", 300);
		mapa.put("lovro", 10);
		mapa.put("ivan", 1020);
		for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
			System.out.println(entry.getKey() +" " + entry.getValue());
		}
	}
	public static Map<String, Integer> createMap() {
		Map<String, Integer> mapa = new HashMap<>();
		mapa.put("jurij", 100);
		mapa.put("marko", 50);
		mapa.put("matija", 200);
		mapa.put("janko", 300);
		mapa.put("lovro", 10);
		mapa.put("ivan", 1020);
		return mapa;
	}
	
}
