package hr.fer.oop.lab2.prob3;



/**
 * The Roots represents program for calculating roots
 * of complex numbers.	
 * @author jurij
 *
 */
public class Roots {
	/**Starting point of the program.
	 * 
	 * @param args Command line arguments. First is real part of complex number,<br/>
	 *  second is imaginary part and third argumnet is which root we want to calculate.
	 * */
	public static void main(String[] args) {
		findAndPrintRoots(Double.parseDouble(args[0]), Double.parseDouble(args[1]), Integer.parseInt(args[2]));
	}
	
	/**
	 * It finds all roots of complex number and prints them on console.
	 * @param args Command line arguments 
	 * 
	 */
	private static void findAndPrintRoots(double realPart,double imPart,int rootNum){
		double[] polarForm=toPolarForm(realPart, imPart);
		double rootLength=Math.pow(polarForm[0], 1.0/rootNum);
		double rootAngle=polarForm[1]/rootNum;
		System.out.println("You requested calculation of "+rootNum+". roots Solutions are: ");
		for(int i=0;i<rootNum;i++){
			double[] cartesianForm=toCartesianForm(rootLength, rootAngle+((Math.PI*2*i)/rootNum));
			System.out.println((i+1)+") "+cartesianForm[0]+" + "+cartesianForm[1]+"i");
		}
		
	}

	/**
	 * It converts complex number from a+bi form to polar form.
	 * @param realPart real part of complex number
	 * @param imPart	imaginary part
	 * @return	It returns array in which first element represent absolute value
	 * and second element represent angle in degrees.
	 */
	private static double[] toPolarForm(double realPart,double imPart){
		double[] polarForm=new double[2];
		polarForm[0]=Math.sqrt(Math.pow(realPart, 2)+Math.pow(imPart, 2));
		polarForm[1]=Math.atan2(imPart, realPart);
		return polarForm;
	}
	/**
	 * Converts complex numbers from polar form to a+bi form.
	 * @param rootLength 
	 *        Length of the number shown in cordinate system 
	 * @param rootAngle 
	 * 		  Angle in radians between number and x-axis
	 * @return [a,b] from complex number in form a+bi
	 * 		  
	 */
	private static double[] toCartesianForm(double rootLength,double rootAngle){
		double[] CartesianForm=new double[2];
		CartesianForm[0]=rootLength* Math.cos(rootAngle);
		CartesianForm[1]=rootLength* Math.sin(rootAngle);
		return CartesianForm;
	}
}
