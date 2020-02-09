package backjoon;

import java.util.Scanner;

public class Main_2991_사나운개 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(); // 개1 공격시간
		int B = sc.nextInt(); // 개1 쉬는시간
		int C = sc.nextInt(); // 개2 공격시간
		int D = sc.nextInt(); // 개2 쉬는시간
		// int P = sc.nextInt(); // 우체부 도착시간
		// int M = sc.nextInt(); // 우유배달원 도착시간
		// int N = sc.nextInt(); // 신문배달원 도착시간
		int[] arrivalTime = new int[3];
		int condition = 0;

		for (int i = 0; i < 3; i++) {
			arrivalTime[i] = sc.nextInt(); // 우체부, 우유배달원, 신문배달원 도착시간
			int cnt = 0;

			// 개 1의 공격 여부
			condition = arrivalTime[i] % (A + B);
			if (condition <= A && condition != 0) { // 공격시간 동안이거나 0이 아닐경우 (0 => 쉬는시간)
				cnt++;
			}

			// 개 2의 공격 여부
			condition = arrivalTime[i] % (C + D);
			if (condition <= C && condition != 0) {
				cnt++;
			}

			System.out.println(cnt);
		}

	}

}
