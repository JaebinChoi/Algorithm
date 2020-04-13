package jungol;

import java.util.Scanner;

public class Main_1309 {
	static int sum = 1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		System.out.println(factorial(n));
	}

	private static long factorial(int n) {

		if (n == 0) {
			System.out.println(n + "! = " + 1);
			return 1;
		}
		if (n == 1) {
			System.out.println(n + "! = " + n);
			return 1;
		}
		
		System.out.println(n + "! = " + n + " * " + (n - 1) + "!");
		return n * factorial(n - 1);
	}

}
