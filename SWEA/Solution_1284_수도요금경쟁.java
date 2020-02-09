package swea;

import java.util.Scanner;

public class Solution_1284_수도요금경쟁 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int testcase = 1; testcase <= T; testcase++) {
			int P = sc.nextInt();
			int Q = sc.nextInt();
			int R = sc.nextInt();
			int S = sc.nextInt();
			int W = sc.nextInt();
			int costA = P * W;
			int costB = Q;
			if (W > R) {
				costB += (W - R) * S;
			}

			if (costA < costB)
				System.out.println("#" + testcase + " " + costA);
			else
				System.out.println("#" + testcase + " " + costB);

		}

	}
}
