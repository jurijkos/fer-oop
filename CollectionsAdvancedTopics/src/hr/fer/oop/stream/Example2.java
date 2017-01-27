package hr.fer.oop.stream;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Example2 {
	public static void main(String[] args) {
		List<Student> list = StudentData.load();
		list.stream().filter(new Predicate<Student>() {

			@Override
			public boolean test(Student t) {
				// TODO Auto-generated method stub
				return t.getFinalGrade() == 5;
			}
		}).forEach(new Consumer<Student>() {
			@Override
			public void accept(Student t) {
				System.out.println(t);
			}
		});
		System.out.println();
		list.stream().filter(t -> t.getFinalGrade() == 5).forEach(t ->
			System.out.println(t));
	}
	
	
}
