package hr.fer.oop.collections_and_customclasses.example1;

import java.util.ArrayList;
import java.util.List;

import hr.fer.oop.collections_and_customclasses.Common;

public class ArrayListMain {

	public static void main(String[] args) {
		List<Student> studenti = new ArrayList<>();
		Common.fillStudentsCollection(studenti, Student::new);
		System.out.println("I have following students: ");
		Common.printCollection(studenti);
		Student poe = new Student("Poe", "Edgar Allan", "2345678901");
		System.out.println("Poe present: " + studenti.contains(poe));
	}
}
