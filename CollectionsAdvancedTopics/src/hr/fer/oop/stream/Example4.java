package hr.fer.oop.stream;


import java.util.List;
import java.util.stream.Stream;

public class Example4 {

	public static void main(String[] args) {
		List<Student> students = StudentData.load();
		Stream<Student> st = students.stream();
		st.forEach(t -> System.out.println(t));
		try{
			st.forEach(t -> System.out.println(t));
		}
		catch(Exception exc){
			System.out.println(exc);		
		}
		students.stream().forEach(t -> System.out.println(t));
		
	}	
}