package hr.fer.oop.lab4.prob2;

//import java.util.HashSet;


import hr.fer.oopj.lab4.data.StudentGrades;
import hr.fer.oopj.lab4.data.StudentRecord;

/**
 * This class is used for testing SimpleHashtable class.
 * @author jurij
 *
 */
public class SimpleHashatableTest {
	public static void main(String[] args) {
	/*	// create collection:
		SimpleHashtable<String,Integer> examMarks = new SimpleHashtable<>(2);
		// fill data:
		examMarks.put("Ivana", Integer.valueOf(2));
		examMarks.put("Ante", Integer.valueOf(2));
		examMarks.put("Jasna", Integer.valueOf(2));
		examMarks.put("Kristina", Integer.valueOf(5));
		examMarks.put("Ivana", Integer.valueOf(5)); // overwrites old grade for Ivana
		// query collection:
		Integer kristinaGrade = examMarks.get("Kristina");
		System.out.println("Kristina's exam grade is: " + kristinaGrade); // writes: 5
		//What is collection's size? Must be four!
		System.out.println("Number of stored pairs: " + examMarks.size()); // writes: 4
		System.out.println("kraj");
		System.out.println(examMarks.toString());
		//na satu */
		
		
		SimpleHashtable<String,Integer> bakic = new SimpleHashtable<>();
		SimpleHashtable<String,Integer> anic = new SimpleHashtable<>();
		int numberOfStudents = StudentGrades.getNumberOfRecords();
		StudentRecord newStudent;
		for (int i = 0; i < numberOfStudents; i++){
			newStudent = StudentGrades.getRecord(i);
			if (newStudent.getLecturer() == "Bakić")
				bakic.put(newStudent.getStudentID(), newStudent.getGrade());
			else if (newStudent.getLecturer() == "Anić")
				anic.put(newStudent.getStudentID(), newStudent.getGrade());
		}
		
		System.out.println(anic.size());
		System.out.println(bakic.size());
		anic.addAll(bakic);
		System.out.println(anic.size());
		System.out.println(anic.toString());

		
	}
		
		

	
}
