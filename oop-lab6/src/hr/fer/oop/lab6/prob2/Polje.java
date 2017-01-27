package hr.fer.oop.lab6.prob2;

public class Polje {
	public static void main(String[] args) {
		int [][]polje = new int[3][2];
		//int [][]polje2 = System.arraycopy(polje, 0, polje2, 0, length);
		polje[2][1]=5;
		System.out.println(polje);
		System.out.println(polje.length);
		System.out.println(polje[0].length);
	}
}
