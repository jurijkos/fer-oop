package hr.fer.oop.lab2.prob4;



/**
 * Program prints first n prime numbers on terminal.
 *<br/> 
 *There are two types of numbers: primes and non-primes.
 *Prime number can be divided by 1 and itself only. Every non-prime number can
 *be factored out into prime numbers.
 *
 *Prime number is very important concept in math because they are building blocks 
 * @author Jurij Kos
 *
 */
public class PrimeNumbers {
	/**
	 * Starting point of the program.
	 * @param args Command line argument-number of prime number wanted to see on console
	 */
	public static void main(String[] args) {
		//Number of prime numbers to print on terminal.
		if(args.length==1){
			System.out.println("You requested calculation of first "+args[0]+" prime numbers. "
					+ "Here they are:");
			int n=Integer.parseInt(args[0]);
			int[] listOfPrimeNumbers=primeNumbersList(n);
			for (int i=0; i<listOfPrimeNumbers.length;i++) {
				System.out.println((i+1)+". "+listOfPrimeNumbers[i]);
			}
		}
		else
			System.out.println("Provided wrong number of arguments");
	}
	/**
	 * Function makes list of fist n prime numbers.
	 * @param n number of primes that will be returned
	 * @return Array of type int containg prime numbers
	 */
	private static int[] primeNumbersList(int n){
		int i=0;
		int number=2;
		int[] primes=new int[n];
		while(true){
			if(isPrimeNumber(number)){
				primes[i]=number;
				i++;
			}
			if(i==n)
				break;
			number++;
		}
		return primes;
	}
	/**
	 * Function checks if number is prime.
	 * @param number This is number we check.
	 * @return True if number is prime.
	 * False if is non-prime
	 */
	private static boolean isPrimeNumber(int number){
		for(int i=2;i<=Math.floor(Math.sqrt(number));i++){
			if(number%i==0)
				return false;
		}
		return true;
	}













}
