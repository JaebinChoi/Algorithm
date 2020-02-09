package swea;

import java.util.Scanner;

public class Solution_9658_Summation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int testcase = 1; testcase <= T; testcase++) {
			int max = 0;
			int min = 100;

			for (int i = 0; i < 10; i++) {
				String s = sc.next();
				int len = s.length() - 1;
				int num = Integer.parseInt(s);
				int sum = 0;

				while (len >= 0) {
					sum += num / Math.pow(10, len);
					num = (int) (num % Math.pow(10, len--));
				}

				if (sum > max)
					max = sum;
				if (sum < min)
					min = sum;

			}
			System.out.println("#" + testcase + " " + max + " " + min);
		}

	}
}
