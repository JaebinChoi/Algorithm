package jungol;

import java.util.Scanner;

public class Main123 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.print("Number? ");
		int num = s.nextInt();

		switch (num) {
		case 1:
			System.out.println("dog");
			break;
		case 2:
			System.out.println("cat");
			break;
		case 3:
			System.out.println("chick");
			break;
		default:
			System.out.println("I don't know.");

		}

	}

}
