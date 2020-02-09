package jungol;

import java.util.Scanner;

public class Main633 {

	public static void menu() {
		System.out.println("1. Korea");
		System.out.println("2. USA");
		System.out.println("3. Japan");
		System.out.println("4. China");
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int num;

		while (true) {
			menu();
			System.out.print("number? ");
			num = s.nextInt();

			System.out.println();

			if (num == 1)
				System.out.println("Seoul");
			else if (num == 2)
				System.out.println("Washington");
			else if (num == 3)
				System.out.println("Tokyo");
			else if (num == 4)
				System.out.println("Beiging");
			else {
				System.out.println("none");
				break;
			}

			System.out.println();
		}

	}

}
