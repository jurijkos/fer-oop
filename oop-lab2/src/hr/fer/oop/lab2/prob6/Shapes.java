package hr.fer.oop.lab2.prob6;
/**
 * This program draws some simple shapes on the terminal.
 * @author Jurij Kos
 *
 */
public class Shapes {
	/**
	 * Starting point of the program.
	 * 
	 */
	public static void main(String[] args) {
		//1st shape
		plusLine();
		upContainer();
		
		//2nd shape
		downContainer();
		plusLine();
		
		//3rd shape
		downContainer();
		upContainer();
		
		//one blank line to look nicer
		System.out.println(" ");
		//4th shape
		upContainer();
		plusLine();
		
		//5th shape
		downContainer();
		plusLine();
	}
	/**
	 * This method draw line on terminal.
	 * It looks like next line.
	 * +--------+
	 */
	private static void plusLine(){
		System.out.println("+--------+");
	}

	/**
	 * Draws shape on terminal.<br/>
	 * It looks like container
	 */
	private static void upContainer(){
		System.out.println("\\        /");
		System.out.println(" \\______/");
	}
	/**
	 * Draws shape on terminal.<br/>
	 * It looks like inverted container. 
	 */
	private static void downContainer(){
		System.out.println("  ______");
		System.out.println(" /      \\");
		System.out.println("/        \\");
	}
}