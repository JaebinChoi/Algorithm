package backjoon;

import java.util.Scanner;

// DP
public class Main_11726_2xn타일링 {
	static int[] a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		a = new int[n + 1];

		int result = dp(n);
		System.out.println(result);
	}

	private static int dp(int n) {
		if (n <= 2)
			return n;

		if (a[n] != 0)
			return a[n];

		a[n] = (dp(n - 1) + dp(n - 2)) % 10007;
		return a[n];

	}

}
