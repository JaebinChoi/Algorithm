package swea;

import java.util.Scanner;

public class Solution_1945_간단한소인수분해 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int testcase = 1; testcase <= T; testcase++) {
			int num = sc.nextInt();
			int[] cnt = new int[5];

			while (num % 2 == 0) {
				num /= 2;
				cnt[0]++;
			}
			while (num % 3 == 0) {
				num /= 3;
				cnt[1]++;
			}
			while (num % 5 == 0) {
				num /= 5;
				cnt[2]++;
			}
			while (num % 7 == 0) {
				num /= 7;
				cnt[3]++;
			}
			while (num % 11 == 0) {
				num /= 11;
				cnt[4]++;
			}

			System.out.print("#" + testcase + " ");
			for (int x : cnt)
				System.out.print(x + " ");
			System.out.println();

		}
	}
}
