package com.ssafy.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution_d3_1225_암호생성기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		// T = sc.nextInt();
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		int num;

		for (int test_case = 1; test_case <= T; test_case++) {
			int idx = sc.nextInt();
			int cnt = 1;

			for (int i = 0; i < 8; i++) {
				queue.offer(sc.nextInt());
			}

			while (true) {
				num = queue.poll();
				num -= cnt;
				cnt++;

				if (cnt > 5) {
					cnt = 1;
				}
				if (num <= 0) {
					num = 0;
					queue.offer(num);
					break;
				}

				queue.offer(num);
			}

			System.out.print("#" + idx + " ");
			while (!queue.isEmpty()) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();

		}

	}
}
