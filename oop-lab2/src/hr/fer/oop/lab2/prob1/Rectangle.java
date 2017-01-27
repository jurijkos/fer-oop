package hr.fer.oop.lab2.prob1;

import java.util.Scanner;
/**
 * Program calculates area and perimeter of rectangle.
 * @author jurij
 *
 */
public class Rectangle {
	/**
	 * Starting point of the program.
	 * @param args Width and height of rectangle
	 */
	public static void main(String[] args) {
		if(args.length==0){
			Scanner sc=new Scanner(System.in);
			double width=readArgument(sc,"width");
			double height=readArgument(sc,"height");
			System.out.println("Rectangle you specified have area of "+calculateArea(width, height)+
					" and perimeter of " +calculatePerimeter(width, height));
		}
		else if(args.length==2){
			double width=Double.parseDouble(args[0]);
			double height=Double.parseDouble(args[1]);
			System.out.println("Rectangle you specified have area of "+calculateArea(width, height)+
					" and perimeter of " +calculatePerimeter(width, height));
		}
		else{
			System.out.println("Invalid number of arguments was provided.");
		}
	}
	/**
	 * Calculates perimeter of the rectangle.
	 * Perimeter is the continuous line forming 
	 * the boundary of a closed geometric figure.
	 * @param a Width of rectangle
	 * @param b Height of rectangle
	 * @return Perimeter of rectangle
	 */
	private static double calculatePerimeter(double a,double b){
		return (2*(a+b));
	}
	/**
	 * Calculates area of the rectangle. Area is measurement of a surface
	 * 
	 * @param a Width of rectangle
	 * @param b Height of rectangle
	 * @return Area of rectangle
	 */
	private static double calculateArea(double a,double b){
		return a*b;
		
	}
	/**
	 * It reads arguments from console.
	 * @param sc Scanner for input throug console. 
	 * @param type It says user what we are asking for 
	 * @return Width/height of rectangle
	 */
	private static double readArgument(Scanner sc,String type){
		String argument=new String();
		while(true){
			System.out.println("Please provide "+ type +": ");
			argument=sc.next();
			argument.trim();
			if(argument.isEmpty())
				System.out.println("The input must not be blank");
			else if(Double.parseDouble(argument)<0)
				System.out.println("The "+ type +"must not be negative");
			else 
				return Double.parseDouble(argument);
		}
	}
}
