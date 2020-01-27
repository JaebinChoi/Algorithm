package jungol;

import java.util.Scanner;

public class Main1856 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int count = 1;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(count++ + " ");
			}
			System.out.println();
		}
// i + () * (i % 2)
	}
}
