package hr.fer.oop.lab2.prob5;

import java.util.Arrays;

/**
 * Decomposition of number to prime factors.
 * @author Jurij Kos
 *
 */
public class PrimeFactorization {
	/**
	 * Starting point of the program.
	 * @param args number we want to decompose
	 */
	public static void main(String[] args) {
		if(args.length==1){
			int number=Integer.parseInt(args[0]);
			int[] factors=findPrimeFactors(number);
			System.out.println("You requested decomposition of number "+number+" into prime factors. Here they are:");
			for (int i : factors) {
				System.out.println(i);
			}
		}
		else
			System.out.println("You should enter one argument");
	}
	/**
	 * Finds all prime factors of some number.
	 * @param number positive integer
	 * @return Array of prime factors
	 */
	private static int[] findPrimeFactors(int number){
		int[] primes=new int[1];
		if(number==1){
			primes[0]=1;
			return primes;
		}
		while(number>1){
			for(int i=2;i<=number;i++){
				if(number%i==0 && primes[0]==0){
					number=number/i;
					primes[0]=i;
					break;
				}
				else if (number%i==0) {
					number=number/i;
					primes=Arrays.copyOf(primes, primes.length+1);
					primes[primes.length-1]=i;
					break;
				}
			}
		}
		return primes;
	}
}
