package jungol;

import java.util.Scanner;

public class Main540 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n;

		while (true) {
			n = s.nextInt();

			if (n % 3 == 0)
				System.out.println(n / 3);
			else if (n == -1)
				break;
			else
				continue;
		}

	}

}
