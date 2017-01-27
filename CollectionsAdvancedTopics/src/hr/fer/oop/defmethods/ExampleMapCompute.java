package hr.fer.oop.defmethods;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class ExampleMapCompute {
	public static void main(String[] args) {
		Map<String, Integer> grades = createMap();
		for (Map.Entry<String, Integer> entry : grades.entrySet()) {
			entry.setValue(24);
		}
		for (Map.Entry<String, Integer> entry : grades.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		grades = createMap();
		/*grades.compute("jurij", new BiFunction<String, Integer, Integer>() {
			@Override
			public Integer apply(String t, Integer u) {
				return u==100?5:6;
			}
		});*/
		grades.compute("jurij", (k,v)->  v == 100 ? 5 : 6);
		System.out.println();
		grades.forEach((k, v)->System.out.println(k + " " + v));
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
