package hr.fer.oop.lab4.prob3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class is making a map in which we put grades of specified students.
 * Using that map we can easy caluculte students grades, get to those grades, print it.
 * @author Jurij Kos
 *
 */

public class Grades {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Map<String,List<Integer>> student = new LinkedHashMap<>();
		
		while(sc.hasNext()){
			
			String line = sc.nextLine();
			
			if(line.toUpperCase().equals("KRAJ")){
				break;
			}
				
			List<Integer> grades;
			Integer grade;
			String name;
			
			try{
				String[] data = line.split("\\s");
				name = data[0];
				grade = Integer.parseInt(data[1]);
			}catch (NumberFormatException | ArrayIndexOutOfBoundsException ex){
				System.out.printf("Error causing: %s ",ex.getMessage());
				System.out.println("Wrong input, please enter again.");
				continue;
			}
			
			if(!student.containsKey(name)){
				grades = new ArrayList<>();
				grades.add(grade);	
				student.put(name,grades);
				continue;
			}
			
			grades = student.get(name);
			grades.add(grade);
			student.put(name, grades);
		}
		
		Set<Map.Entry<String, List<Integer>>> set=student.entrySet();
	
		for(Map.Entry<String, List<Integer>> x:set){
			List<Integer> grades=x.getValue();
			
			System.out.printf("Učenik %s %n  Broj ocijena: %d %n  Ocijene: ",
								x.getKey(),grades.size()); 
			Grades.printingGrades(grades);
			System.out.printf("%n  Razlicite ocijene: "); 
			Grades.HowManyDifferent(grades);
			System.out.printf("%n  Prosječna ocijena: %.2f %n  Standardno odstupanje: %.4f %n",
									Grades.average(grades), Grades.StandardDeviation(grades) );
			
		}
	
		sc.close();
	}

		/**
		 * Calculates average of students grades
		 * @param grades all grades of specified student
		 * @return average of grades
		 */
		public static double average(List<Integer> grades) {
			double sum = 0;
			
			for (Integer grade:grades) {
				sum += grade;
			}
			return sum/grades.size();
		}

		/**
		 * Returning an array which contains nonduplicated grades
		 * @param grades-students grades
		 */
		
		public static void HowManyDifferent (List<Integer> grades) {
			
			Set<Integer> different = new TreeSet<>(grades);

			for(Integer x : different)
				System.out.printf("%d ",x);
			
		}
		/**
		 * Method is calculating standard deviation of given grades
		 * @param grades list of grades
		 * @return calculated deviation
		 */
		
		public static double StandardDeviation(List<Integer> grades) {
			double deviation = 0;
			double gradeAverage = average(grades);
			
			if(grades.size() == 1) 
				return 0.0;
			
			for(Integer grade:grades){
				deviation += Math.pow((gradeAverage-grade), 2);
			}
			
			return Math.sqrt(deviation / ((grades.size())));
			
		}
		
		/**
		 * Method prints all grades of one specified student
		 * @param grades all grades the specified student get
		 */
		public static void printingGrades(List<Integer> grades) {
			for(Integer x : grades)
				System.out.printf("%d ",x);
		}


}