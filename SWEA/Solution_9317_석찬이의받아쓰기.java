package swea;

import java.util.Scanner;

public class Solution_9317_석찬이의받아쓰기 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testcase = 1; testcase <= T; testcase++) {
			int len = sc.nextInt();
			String str = sc.next();
			String my = sc.next();
			int cnt = 0;

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) != my.charAt(i)) {
					cnt++;
				}
			}
			System.out.println("#" + testcase + " " + (len - cnt));

		}

	}
}
