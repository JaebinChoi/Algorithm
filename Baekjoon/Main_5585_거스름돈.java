package backjoon;

import java.util.Scanner;

public class Main_5585_거스름돈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] coins = { 500, 100, 50, 10, 5, 1 };
		int pay = sc.nextInt();
		int change = 1000 - pay;

		int count = 0;
		for (int i = 0; i < coins.length; i++) {
			count += change / coins[i];
			change %= coins[i];
		}
		System.out.println(count);
	}
}
