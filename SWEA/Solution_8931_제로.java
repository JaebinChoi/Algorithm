package swea;

import java.util.Scanner;
import java.util.Stack;

public class Solution_8931_제로 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Stack<Integer> stack;

		for (int tc = 1; tc <= T; tc++) {
			int K = sc.nextInt();
			stack = new Stack<Integer>();
			int sum = 0;

			for (int tc2 = 1; tc2 <= K; tc2++) {
				int num = sc.nextInt();

				if (num == 0) {
					stack.pop();
				} else {
					stack.push(num);
				}
			}

			while (stack.size() != 0) {
				sum += stack.pop();
			}

			System.out.println("#" + tc + " " + sum);
		}

	}
}
