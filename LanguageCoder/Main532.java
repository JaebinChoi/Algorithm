package jungol;

import java.util.Scanner;

public class Main532 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		double a = s.nextDouble();
		double b = s.nextDouble();

		if (a >= 4.0 && b >= 4.0)
			System.out.println("A");
		else if (a >= 3.0 && b >= 3.0)
			System.out.println("B");
		else
			System.out.println("C");

	}

}
