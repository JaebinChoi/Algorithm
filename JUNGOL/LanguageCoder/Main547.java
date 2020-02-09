package jungol;

/**
 * 
 * 2 3 4 5 6
 * 3 4 5 6 7
 * 4 5 6 7 8
 * 5 6 7 8 9
 * 6 7 8 9 10
 * 
 */
public class Main547 {
	public static void main(String[] args) {
		for (int i = 2; i < 7; i++) {
			for (int j = i; j < i + 5; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}
