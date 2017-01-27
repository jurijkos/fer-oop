package hr.fer.oop.lab2.extra;
/**
 * Program for checking if string is palindrom.
 * @author Jurij Kos
 *
 */

public class Palindrom{
	/**
	 * Starting point of the program.
	 * @param args args[0] string to check
	 */
	public static void main(String[] args) {
		//String jurij="heii";
		//char[] jurij2=jurij.toCharArray();
		//System.out.println(jurij2);
		if(args.length==1){
			boolean value=isPalindrom(args[0].toCharArray());
			System.out.println(value);
		}
		else {
			System.out.println("You provided wrong number of arguments");
		}
			
	}
	/**
	 * Returns if string is palindrom.
	 * @param word Value we check
	 * @return True if it is palindrom, false if it s not a palindom.
	 */
	private static boolean isPalindrom(char[] word){
		if(word.length%2==0){
			for(int i=0;i<(word.length/2);i++){
				if(word[i]!=word[word.length-1-i]){
					return false;
				}
			}
		return true;	
		}
		return false;
	}
}
