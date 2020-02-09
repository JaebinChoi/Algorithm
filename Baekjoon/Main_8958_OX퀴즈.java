package backjoon;

import java.util.Scanner;

public class Main_8958_OX퀴즈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int testcase = 1; testcase <= T; testcase++) {
			String str = sc.next();
			int cnt = 0;
			int sum = 0;

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == 'O') {
					cnt++;
					sum += cnt;
				} else {
					cnt = 0;
				}
			}
			System.out.println(sum);

		}

	}
}
