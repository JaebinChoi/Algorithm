package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247_최적경로 {
	static int[][] customer;
	static int cusNum;
	static int bisR, bisC, homeR, homeC;
	static int totalDis;
	static int result;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/최적경로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			cusNum = Integer.parseInt(br.readLine());
			customer = new int[cusNum][2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			bisR = Integer.parseInt(st.nextToken());
			bisC = Integer.parseInt(st.nextToken());
			homeR = Integer.parseInt(st.nextToken());
			homeC = Integer.parseInt(st.nextToken());

			for (int i = 0; i < cusNum; i++) {
				customer[i][0] = Integer.parseInt(st.nextToken());
				customer[i][1] = Integer.parseInt(st.nextToken());
			}

			totalDis = 0;
			result = Integer.MAX_VALUE;
			visited = new boolean[cusNum];
			move(bisR, bisC, 0);

			System.out.println("#" + tc + " " + result);

		}

	}

	private static void move(int r, int c, int cur) {
		if (totalDis > result) { // 효빈이의 개꿀팁 : 집 돌아다니는데 이미 최소값보다 크면 돌 필요 없음!
			return;
		}
		// 마지막 손님까지 방문하면
		if (cur == cusNum) {
			// 집까지 벡터 구하기
			result = Math.min(result, totalDis + distance(r, c, homeR, homeC));
			return;
		}

		for (int i = 0; i < cusNum; i++) {
			if (!visited[i]) {
				totalDis += distance(r, c, customer[i][0], customer[i][1]);
				visited[i] = true;

				move(customer[i][0], customer[i][1], cur + 1);
				visited[i] = false;
				totalDis -= distance(r, c, customer[i][0], customer[i][1]);
			}
		}

	}

	private static int distance(int sr, int sc, int er, int ec) {
		return Math.abs(sr - er) + Math.abs(sc - ec);
	}

}
