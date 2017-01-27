package hr.fer.oop.stream;

import java.util.List;

public class Example1 {
	
	public static void main(String[] args) {
		List<Student> list = StudentData.load();
		for (Student student : list) {
			System.out.println(student);
		}
		System.out.println();
		list.forEach(s -> System.out.println(s));
		System.out.println();
		list.stream().forEach(s -> System.out.println(s));
		
	}
	
}
