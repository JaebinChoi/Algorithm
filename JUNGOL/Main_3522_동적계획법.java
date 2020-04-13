package jungol;

import java.util.Scanner;

public class Main_3522_동적계획법 {
	static int[] f;
	static final int num = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		f = new int[N + 1];

		int result = fibo(N);
		System.out.println(result);
	}

	private static int fibo(int n) {
		f[1] = 1;
		f[2] = 1;
		for (int i = 3; i <= n; i++)
			f[i] = (f[i - 1] + f[i - 2]) % num;

		return f[n];

	}

}
