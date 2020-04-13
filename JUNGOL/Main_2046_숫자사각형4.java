package jungol;

import java.util.Scanner;

public class Main2046 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		switch (m) {
		case 1:
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
			break;
		case 2:
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					System.out.print((j + ((n + 1) - 2 * j) * ((i - 1) % 2)) + " ");
				}
				System.out.println();
			}
			break;
		case 3:
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					System.out.print(i * j + " ");
				}
				System.out.println();
			}
			break;
		}

	}
}
