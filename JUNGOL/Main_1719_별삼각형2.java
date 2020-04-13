package jungol;

import java.util.Scanner;

public class Main1917 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] arr = new char[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = ' ';
			}
		}

		if (n > 100 || n % 2 == 0 || m < 1 || m > 4) {
			System.out.println("INPUT ERROR!");
		} else {
			switch (m) {
			case 1:
				for (int i = 0; i < n / 2; i++) {
					for (int j = 0; j <= i; j++)
						System.out.print("*");
					System.out.println();
				}
				for (int i = n / 2, k = 0; i < n; i++, k += 2) {
					for (int j = i - k; j >= 0; j--)
						System.out.print("*");
					System.out.println();
				}
				break;
			case 2:
				for (int i = n / 2, k = 1; i < n - 1; i++, k++) {
					for (int j = i; j < n - 1; j++)
						System.out.print(" ");
					for (int j = n - k; j < n; j++)
						System.out.print("*");
					System.out.println();
				}
				for (int i = n / 2, k = 0; i < n; i++, k++) {
					for (int j = 0; j < k; j++)
						System.out.print(" ");
					for (int j = i; j < n; j++)
						System.out.print("*");
					System.out.println();
				}
				break;
			case 3:
				for (int i = 0, k = 0; i < n / 2; i++, k++) {
					for (int j = 0 + k; j < n - k; j++)
						arr[i][j] = '*';
				}
				for (int i = n / 2, k = n / 2; i < n; i++, k--) {
					for (int j = 0 + k; j < n - k; j++)
						arr[i][j] = '*';
				}
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++)
						System.out.print(arr[i][j]);
					System.out.println();
				}
				break;
			case 4:
				for (int i = 0; i < n / 2; i++) {
					for (int j = i; j <= n / 2; j++)
						arr[i][j] = '*';
				}
				for (int i = n / 2; i < n; i++) {
					for (int j = n / 2; j <= i; j++)
						arr[i][j] = '*';
				}
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++)
						System.out.print(arr[i][j]);
					System.out.println();
				}
				break;

			} // switch
		}

	}
}
