package swea;

import java.util.Scanner;

public class Solution_1986_지그재그숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testcase = 1; testcase <= T; testcase++) {
			int n = sc.nextInt();
			int sum = 0;
			for (int i = 1; i <= n; i++) {
				sum += -i + (2 * i) * (i % 2);
			}
			System.out.println("#" + testcase + " " + sum);
		}

	}
}
